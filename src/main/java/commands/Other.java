package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.GeneralHelper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static data.GeneralData.*;

public class Other extends ListenerAdapter {

    public static final Logger LOGGER = LoggerFactory.getLogger(Other.class);

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        String msg = message.getContentDisplay();

        new GeneralHelper().printMessageInfo(event);

        switch (msg) {
            case PREFIX + "info":
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("Aven Bot");
                info.setDescription("A bot is created as a personal project to provide links and " +
                        "tips for games I play.\n\n" +
                        "Type " + PREFIX + "commands to see available commands");
                info.setColor(BLUE_COLOR_HEX);
                info.setFooter("Created by Andrii Shumylo", Objects
                        .requireNonNull(event.getMember()).getUser().getAvatarUrl());

                channel.sendMessage(info.build()).queue();
                info.clear();
                break;
            case PREFIX + "commands":
                EmbedBuilder commands = new EmbedBuilder();
                commands.setColor(BLUE_COLOR_HEX);
                commands.addField("Tarkov", TARKOV_COMMANDS_PREFIXED
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")), false);
                commands.addField("Fun", FUN_COMMANDS_PREFIXED
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")), false);
                commands.addField("Other", OTHER_COMMANDS_PREFIXED
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")), false);
                channel.sendMessage(commands.build()).queue();
                commands.clear();
                break;
            case PREFIX + "github":
                channel.sendMessage("Github link will be provided soon...").queue();
                break;
            case PREFIX + "youtube":
                channel.sendMessage("My YouTube channel: " + YOUTUBE).queue();
                break;
            case PREFIX + "soundcloud":
                channel.sendMessage("My Soundcloud: " + SOUNDCLOUD).queue();
                break;
        }

        String[] args = msg.split("\\s+");

        if (args[0].startsWith(PREFIX + "clear")) {
            if (args.length < 2) {
                EmbedBuilder err = new EmbedBuilder();
                err.setColor(RED_COLOR_HEX);
                err.setTitle("Specify amount to delete");
                err.setDescription("Usage: " + PREFIX + "clear [# of messages to delete]");
                channel.sendMessage(err.build()).queue();
                err.clear();
            } else {
                try {
                    List<Message> messages = channel.getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                    messages.forEach(m -> channel.deleteMessageById(m.getId()).queue());
                    LOGGER.info("Cleared " + args[1] + " last messages.");
                } catch (IllegalArgumentException e) {
                    EmbedBuilder err = new EmbedBuilder();
                    err.setColor(RED_COLOR_HEX);
                    err.setTitle("Too many messages selected for deletion");
                    err.setDescription("Choose between 1-100 messages at once");
                    channel.sendMessage(err.build()).queue();
                    err.clear();
                } catch (Exception e) {
                    EmbedBuilder err = new EmbedBuilder();
                    err.setColor(RED_COLOR_HEX);
                    err.setTitle("Messages older than 2 weeks");
                    err.setDescription("Messages older than 2 weeks cannot be deleted");
                    channel.sendMessage(err.build()).queue();
                    err.clear();
                }
            }
        }
    }
}
