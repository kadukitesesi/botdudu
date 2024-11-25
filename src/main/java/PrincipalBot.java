import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.ServerVoiceChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.channel.server.voice.ServerVoiceChannelMemberJoinEvent;


public class PrincipalBot {
    public static void main(String[] args) {
        String token;
        DiscordApi discordApi = new DiscordApiBuilder()
                .setToken(token)
                .setAllIntents()
                .login()
                .join();

        String akashi = "akashi6644";
        String atos = "atrukz";
        String mensagem = "O cruzeirense perdedor entrou no canal";

        System.out.println("Bot conectado! Link do convite " + discordApi.createBotInvite());

        discordApi.addMessageCreateListener(event -> {
            if (event.getMessage().getAuthor().getName().equalsIgnoreCase(akashi)) {
                event.getChannel().sendMessage("Muito Gay");
            } else if (event.getMessage().getAuthor().getName().equalsIgnoreCase(atos)) {
                event.getChannel().sendMessage("Cruzeiro muito ruim 4 X 1");
            }
        });

        discordApi.addServerVoiceChannelMemberJoinListener(event -> {

            if (event.getUser().getName().equalsIgnoreCase(atos)) {
                Server server = event.getServer();
                ServerVoiceChannel voiceChannel = event.getChannel();

                server.getTextChannelsByName("\uD83D\uDCAC┋\uD835\uDD1F\uD835\uDD1E\uD835\uDD31\uD835\uDD22-\uD835\uDD2D\uD835\uDD1E\uD835\uDD2D\uD835\uDD2C")
                        .stream()
                        .findFirst()
                        .ifPresent(channel ->
                        channel.sendMessage(mensagem + " no canal de voz " + voiceChannel.getName()));

            }

    });
}
}