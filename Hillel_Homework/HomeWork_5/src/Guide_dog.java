public class Guide_dog extends Dog{
   protected boolean isTrained;
    protected Guide_dog(int id, int age, float weight, String color, String name, boolean isVaccinated,boolean isTrained) {
        super(id, age, weight, color, name, isVaccinated);
        this.isTrained = isTrained;
    }

    @Override
    protected void voice() {
        if (isTrained == true)
        System.out.print("Hello,my name is " + name + ". Woof.");
    }
    protected void take_home(){
        System.out.println(" I can take you home.");
    }
}
