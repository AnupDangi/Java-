class ProblemWithObjectCreation{


class Car{
    
    void gear(){
        System.out.println("This is a gear");
    }
   static class Tata extends  Car{
    void power(){
        System.out.println("This has a great power");
    }
   }
public static void main(String[] args)
{
   // Car c new Car();// has the object of car and can only access the methods and properties inside the car class not the inherited class
     Car c=new Tata(); // parent class refernce var contains child class object //this is allowed
    //Tata t=new Car(); // this is not allowed because the child class reference cannot access the parent class object
    c.gear();
   // c.power();// this gives error because the class type is parent and object type is child and we are trying to access the child object from the parent reference 
    // whenever we try to access the method or fields of Parent from child  object it wont allow 
        }
    }
}



// class Car{
    
//     void gear(){
//         System.out.println("This is a gear");
//     }
//    static class Tata extends  Car{
//     void power(){
//         System.out.println("This has a great power");
//     }
//    }
// public static void main(String[] args)
// {
//    // Car c new Car();// has the object of car and can only access the methods and properties inside the car class not the inherited class
//      Car c=new Tata(); // parent class refernce var contains child class object //this is allowed
//     //Tata t=new Car(); // this is not allowed because the child class reference cannot access the parent class object
//     c.gear();
//    // c.power();// this gives error because the class type is parent and object type is child and we are trying to access the child object from the parent reference 
//     // whenever we try to access the method or fields of Parent from child  object it wont allow 
// }
// }






