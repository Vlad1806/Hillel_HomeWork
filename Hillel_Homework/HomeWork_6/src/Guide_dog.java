public class Guide_dog extends Dog{
    protected boolean isTrained;

    public Guide_dog(int id, int age, float weight, String color, String name, boolean isVaccinated, boolean isTrained) {
        super(id, age, weight, color, name, isVaccinated);
        this.isTrained = isTrained;
    }

    public void voice() {
        if (isTrained == true) {
            System.out.println("Hello,my name is " + name + ". I can take you home.");
        }
        else{
            System.out.println("Hello,my name is " + name + ". Woof.");
        }

    }
    protected void take_home(){
        System.out.println("Master let's go home.");
    }
}
