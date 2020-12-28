package com.aven;

import com.aven.commands.Fun;
import com.aven.commands.Other;
import com.aven.commands.Tarkov;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.util.Random;

import static com.aven.data.GeneralData.FAVOURITE_BANDS;

public class Main {

    public static final Logger LOGGER = LoggerFactory.getLogger(Other.class);

    public static JDA jda;

    public static void main(String[] args) {
        try {
            jda = JDABuilder.createDefault(System.getenv("DISCORD_BOT_TOKEN"))
                    .addEventListeners(
                            new Fun(),
                            new Tarkov(),
                            new Other()
                    )
                    .build();
            jda.awaitReady();
            LOGGER.info("Finished Building JDA!");
        }
        catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence()
                .setActivity(Activity.listening(FAVOURITE_BANDS.get(new Random().nextInt(FAVOURITE_BANDS.size()))));
    }
}
