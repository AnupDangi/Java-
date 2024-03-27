public class Abstraction {
    

    public static void main(String[] args) {
        Son son=new Son();
        Daughter daut=new Daughter();
        son.House();
        son.Money();
        daut.Money();
        daut.House();// daughter is using the house method of parents if she has not her own method implementation
        son.changename();
     }
 }
 
    abstract class Parents{
        String name;
        Parents(){ // constructors
            name="xyz";
        }
       abstract void Money();
       // abstract class has no object and implements in parent class
        void House(){
            System.out.println("This is house");
        }
    }
        class Son extends Parents{
            void changename(){
                name="Hello";
                System.out.println("Name is changed to "+name);
            }
            void Money(){
                System.out.println("This is the money of parents");
            }
            void House(){
                System.out.println("This is the house of son");
            }
        }
        class Daughter extends Parents{
            void Money(){
                System.out.println("She is using the money of parents");
            }
        }
