import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;


public class PrincipalBot {
    public static void main(String[] args) {
        String token = "MTMxMDAxNDIxMjY4NDM4NjM5NA.GChOn4.bwqo5LCSNSLAaHuOwSpDCtFfJnu2da4wVaRaiM";
        DiscordApi discordApi = new DiscordApiBuilder()
                .setToken(token)
                .setAllIntents()
                .login()
                .join();

        String akashi = "akashi6644";
        String atos = "atrukz";

        System.out.println("Bot conectado! Link do convite " + discordApi.createBotInvite());

        discordApi.addMessageCreateListener(event -> {
            if (event.getMessage().getAuthor().getName().equalsIgnoreCase(akashi)) {
                event.getChannel().sendMessage("Muito Gay");
            } else if (event.getMessage().getAuthor().getName().equalsIgnoreCase(atos)) {
                event.getChannel().sendMessage("cruzeiro muito ruim 4 X 1");
            }
        });




    }
}
