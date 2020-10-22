public class RunAnimal {
    public static void main(String[] args) {

        fish fish = new fish(3,1,0.0001f,"Blue");
        System.out.print("Fish : ");
        fish.voice();
        fish.eat();
        Dog dog = new Dog(4,2, 1.2f,"Black","Puppy",true);
        System.out.print("Dog : ");
        dog.voice();
        dog.eat();
        Cat cat = new Cat(1,3,1.4f,"Red","Kitty",false);
        System.out.print("Cat : ");
        cat.voice();
        cat.eat();
        Wolf wolf = new Wolf(2,8,3.1f,"grey",true);
        System.out.print("Wolf : ");
        wolf.voice();
        wolf.eat();
        Lion lion = new Lion(3,12,20f,"Yellow",true);
        System.out.print("Lion : ");
        lion.voice();
        lion.eat();
        Giraffe giraffe = new Giraffe(1,5,27.5f,"Orange",false);
        System.out.print("Giraffe : ");
        giraffe.voice();
        giraffe.eat();
        Crocodile crocodile = new Crocodile(1,7,50.7f,"Green",true);
        System.out.print("Crocodile : ");
        crocodile.voice();
        crocodile.eat();
        Hamster hamster = new Hamster(2,1,0.9f,"White","Homyaxwill",true);
        System.out.print("Hamster : ");
        hamster.voice();
        hamster.eat();
        Guide_dog guide_dog = new Guide_dog(1,2,2.3f,"Red","Myhtar",true,true);
        System.out.print("Guide_dog : ");
        guide_dog.voice();
        guide_dog.take_home();
        guide_dog.eat();
    }
}
