package com.aven.utils;

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class GeneralHelper {

    public static final Logger LOGGER = LoggerFactory.getLogger(GeneralHelper.class);

    public void printMessageInfo(MessageReceivedEvent event) {
        User author = event.getAuthor();
        Message message = event.getMessage();
        String msg = message.getContentDisplay();

        if (event.isFromType(ChannelType.TEXT)) {
            Guild guild = event.getGuild();
            TextChannel textChannel = event.getTextChannel();
            Member member = event.getMember();

            String name = message.isWebhookMessage() ? author.getName() : Objects.requireNonNull(member).getEffectiveName();
            LOGGER.info("({})[{}]<{}>: {}", guild.getName(), textChannel.getName(), name, msg);
        }
    }
}
