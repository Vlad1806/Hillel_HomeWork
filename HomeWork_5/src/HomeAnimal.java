public class HomeAnimal extends Animal{
    protected String name;
    protected boolean isVaccinated;

    protected HomeAnimal(int id, int age, float weight, String color, String name, boolean isVaccinated) {
        this.name = name;
        this.isVaccinated = isVaccinated;
    }
    @Override
    protected void voice(){
        System.out.println("Hello,my name is " + name);
    }

    @Override
    protected void eat() {
        System.out.println("Feed me");
    }
}
