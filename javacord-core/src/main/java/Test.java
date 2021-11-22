import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Test {
    public static void main(String[] args){
        DiscordApi api = new DiscordApiBuilder().setToken("ODM1NTU0NDI0MzEwNDY0NTIy.YIRIsg.ilTPwzz0NN0GSuB7p4Tf9CKeb0Y").setAllIntents().login().join();
    }
}
