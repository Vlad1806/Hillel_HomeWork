public class Dog extends HomeAnimal {
    public Dog(int id, int age, float weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }

    @Override
    public void voice() {
        System.out.println("Hello,my name is " + name + ". Woof");
    }
}
