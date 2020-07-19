public class fish extends WildAnimal{

    public fish(int id, int age, float weight, String color, boolean isPredator) {
        super(id, age, weight, color, isPredator);
    }

    @Override
    public void voice(){
        System.out.println(".......");
    }

    @Override
    public void eat() {
        System.out.println(".......");
    }
}
