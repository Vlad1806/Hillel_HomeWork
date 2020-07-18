public class WildAnimal extends Animal {

    protected boolean isPredator;

    protected WildAnimal(int id, int age, float weight, String color, boolean isPredator) {
        this.isPredator = isPredator;
    }

    @Override
    protected void voice() {
        if (isPredator == true) {
            System.out.println("Hello,I am a wild animal and I am angry");
        }
        else {
            System.out.println("Hello,I am a wild animal");
        }
    }
}



