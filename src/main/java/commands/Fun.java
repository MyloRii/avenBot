package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static data.GeneralData.NEKO_URL;
import static data.GeneralData.PREFIX;

public class Fun extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        JDA jda = event.getJDA();
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        String msg = message.getContentDisplay();

        switch (msg) {
            case PREFIX + "ping":
                channel.sendMessage("ping yourself you filthy perv!").queue();
                break;
            case PREFIX + "roll":
                Random rand = ThreadLocalRandom.current();
                int roll = rand.nextInt(6) + 1; //This results in 1 - 6 (instead of 0 - 5)
                channel.sendMessage("Your roll: " + roll).queue();
                break;
            case PREFIX + "nekogirl":
                OkHttpClient client = jda.getHttpClient();
                Request request = new Request.Builder().url(NEKO_URL).build();
                Call call = client.newCall(request);
                Response response;
                String jsonData = null;
                try {
                    response = call.execute();
                    jsonData = Objects.requireNonNull(response.body()).string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JSONObject jsonObject = new JSONObject(Objects.requireNonNull(jsonData));

                EmbedBuilder neko = new EmbedBuilder();
                neko.setImage(jsonObject.getString("neko"));
                channel.sendMessage(neko.build()).queue();
                neko.clear();
                break;
        }
    }
}
