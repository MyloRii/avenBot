package com.aven.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static com.aven.data.GeneralData.*;

public class Tarkov extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        String msg = message.getContentDisplay();

        switch (msg) {
            case PREFIX + "customs" -> {
                EmbedBuilder customs = new EmbedBuilder();
                customs.setImage(CUSTOMS);
                customs.addField("Mapgenie link: ", CUSTOMS_MAP, false);
                channel.sendMessage(customs.build()).queue();
                customs.clear();
            }
            case PREFIX + "shoreline" -> {
                EmbedBuilder shoreline = new EmbedBuilder();
                shoreline.setImage(SHORELINE);
                shoreline.addField("Mapgenie link: ", SHORELINE_MAP, false);
                channel.sendMessage(shoreline.build()).queue();
                shoreline.clear();
            }
            case PREFIX + "interchange" -> {
                EmbedBuilder interchange = new EmbedBuilder();
                interchange.setImage(INTERCHANGE);
                interchange.addField("Mapgenie link: ", INTERCHANGE_MAP, false);
                channel.sendMessage(interchange.build()).queue();
                interchange.clear();
            }
            case PREFIX + "reserve" -> {
                EmbedBuilder reserve = new EmbedBuilder();
                reserve.setImage(RESERVE);
                channel.sendMessage(reserve.build()).queue();
                reserve.clear();
            }
            case PREFIX + "woods" -> {
                EmbedBuilder reserve = new EmbedBuilder();
                reserve.setImage(WOODS);
                channel.sendMessage(reserve.build()).queue();
                reserve.clear();
            }
            case PREFIX + "ammo" -> {
                EmbedBuilder ammo = new EmbedBuilder();
                ammo.addField("Ammo chart link v12.9: ", AMMO_CHART_V_12_9, false);
                channel.sendMessage(ammo.build()).queue();
                ammo.clear();
            }
        }
    }
}
