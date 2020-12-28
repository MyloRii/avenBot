package com.aven.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;

import static com.aven.data.GeneralData.*;

public class Tarkov extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        String msg = message.getContentDisplay();

        switch (msg) {
            case PREFIX + "customs" -> {
                channel.sendMessage("Tarkov Customs Map:\n").addFile(new File(CUSTOMS_IMAGE)).queue();
                EmbedBuilder customs = new EmbedBuilder();
                customs.addField("Mapgenie link: ", CUSTOMS_MAP, false);
                channel.sendMessage(customs.build()).queue();
                customs.clear();
            }
            case PREFIX + "shoreline" -> {
                channel.sendMessage("Tarkov Shoreline Map:\n").addFile(new File(SHORELINE_IMAGE)).queue();
                EmbedBuilder shoreline = new EmbedBuilder();
                shoreline.addField("Mapgenie link: ", SHORELINE_MAP, false);
                channel.sendMessage(shoreline.build()).queue();
                shoreline.clear();
            }
            case PREFIX + "interchange" -> {
                channel.sendMessage("Tarkov Interchange Map:\n").addFile(new File(INTERCHANGE_IMAGE)).queue();
                EmbedBuilder interchange = new EmbedBuilder();
                interchange.addField("Mapgenie link: ", INTERCHANGE_MAP, false);
                channel.sendMessage(interchange.build()).queue();
                interchange.clear();
            }
            case PREFIX + "reserve" -> channel.sendMessage("Tarkov Reserve Map:\n").addFile(new File(RESERVE_IMAGE)).queue();
            case PREFIX + "ammo" -> {
                EmbedBuilder ammo = new EmbedBuilder();
                ammo.addField("Ammo chart link v12.9: ", AMMO_CHART_V_12_9, false);
                channel.sendMessage(ammo.build()).queue();
                ammo.clear();
            }
        }
    }
}
