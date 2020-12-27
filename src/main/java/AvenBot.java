import commands.Fun;
import commands.Other;
import commands.Tarkov;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
import java.util.Random;

import static data.GeneralData.FAVOURITE_BANDS;

public class AvenBot {

    public static final Logger LOGGER = LoggerFactory.getLogger(Other.class);

    public static JDA jda;

    public static void main(String[] args) {
        String token;
        Properties properties = null;
        try (InputStream input = new FileInputStream("src/main/resources/app.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        token = Objects.requireNonNull(properties).getProperty("token");

        try {
            jda = JDABuilder.createDefault(token)
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
