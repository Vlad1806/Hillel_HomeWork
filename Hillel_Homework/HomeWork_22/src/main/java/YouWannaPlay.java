import java.util.Locale;
import java.util.ResourceBundle;

public class YouWannaPlay {
    public static void main(String[] args) {
        try {
            RockScissorsPaper rock = new RockScissorsPaper(
                    ResourceBundle.getBundle("MessagesBundle",new Locale(args[0])));
            rock.start();
        }
        catch (NullPointerException exception){
            System.out.println(exception.getMessage());
        }
    }

}
