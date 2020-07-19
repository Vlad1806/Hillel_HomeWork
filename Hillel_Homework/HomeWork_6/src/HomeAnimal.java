public class HomeAnimal extends Animal implements AnimalDo{
    protected String name;
    protected boolean isVaccinated;
    @Override
    public void voice() {
        System.out.println("Hello,my name is " + name);
    }

    public HomeAnimal(int id, int age, float weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color);
        this.name = name;
        this.isVaccinated = isVaccinated;
    }

    @Override
    public void eat() {
        System.out.println("Feed me");
    }
}
