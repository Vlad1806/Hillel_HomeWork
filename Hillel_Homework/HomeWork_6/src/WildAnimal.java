public class WildAnimal extends Animal implements AnimalDo {

    protected boolean isPredator;

    public WildAnimal(int id, int age, float weight, String color, boolean isPredator) {
        super(id, age, weight, color);
        this.isPredator = isPredator;
    }

    @Override
    public void voice() {
        if (isPredator == true) {
            System.out.println("Hello,I am a wild animal and I am angry");
        }
        else {
            System.out.println("Hello,I am a wild animal");
        }
    }

    @Override
    public void eat() {
        if (isPredator == true) {
            System.out.println("I'll eat you");
        }
        else {
            System.out.println("I eat plants");
        }
    }
}
