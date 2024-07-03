public class Polymorphism {
    
    // Method Overloading
    // Compile time is known as method overloading

    //Method Overriding 
    //Run time overloading

    public static void main(String[] args){

        Animal ani=new Animal();
        ani.eat();
        Deer deer=new Deer();
        deer.eat();
        // Calculator cal=new Calculator();
        //  System.out.println(cal.sum(1,2));
        //  System.out.println(cal.sum(1,2,3));
    }
}
class Calculator{
    int sum(int a, int b)
    {
        return a+b;
    }
    // method overloading
    int sum(int a, int b, int c)
    {
        return a+b+c; 
    }
}

class Animal{
    void eat()
    {
        System.out.print("Animal eats anything");
    }
}
    class Deer extends Animal{
        // Method Overriding
        void eat(){
            System.out.print("\nEats grass");
        }
    }












//     {
//         Ram ram=new Ram();
//         Ram.ChildofRam cor= ram.new ChildofRam();
//         cor.Height();
//     }

//      static class Ram{
//         void Height()
//         {
//             System.out.println("His height is 6ft");

//         }

//     class ChildofRam extends Ram{
        
//         void Height(){

//             System.out.print("his height is 7ft");
//         }
//     }
// }