public class Cat extends HomeAnimal{
    protected Cat(int id, int age, float weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }

    @Override
    protected void voice() {
        System.out.println("Hello,my name is " + name + ". Meow");
    }
}

