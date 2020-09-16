public class MainConvert {
    public static void main(String[] args){
        try {
            new Convert(args[0]);
        }catch (NullPointerException e){
            e.getMessage();
        }

    }
}
