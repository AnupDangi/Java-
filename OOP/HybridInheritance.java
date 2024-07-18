public class HybridInheritance {
    


    public static void main(String[] args) {
        Animal ani=new Animal();
       Animal.Fish fish=ani.new Fish();
       Animal.Fish.Tuna tuna= fish.new Tuna();
       Animal.Fish.Tuna.LargeTuna ltuna=tuna.new LargeTuna();
       // tuna.tuna();
        ltuna.largetuna();
        // parentclass.childclass ref var= parentclass of current child class  ref .new child class
    }


}
class Animal{

class Fish extends Animal{

    class Tuna extends Fish{
        void tuna()
        {
            System.out.print("This is tuna");
        }
        class LargeTuna extends Tuna{
            void largetuna()
            {
                System.out.println("This is a large tuna");
            }
        }
    }
    class Shark extends Fish{

        void shark()
        {
            System.out.print("This is shark");
        }
    }
}
class Bird extends Animal{

    class Peaco extends Bird{

    }

}
class Mammals extends Animal{

    class Dog extends Mammals{


    }
    class Cat extends Mammals{

    }

    class Human extends Mammals{

    }
}
}




