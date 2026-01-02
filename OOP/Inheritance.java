public class Inheritance {
    public static void main(String[] args) {
        child c1=new child();
        parent p1=new parent();
        son s1=new son();
        daughter d1=new daughter();
        // child can access the properties of parent ie genes a method
        c1.genes();
        //but parent cannot access the properties of child child class
      //  p1.eat();// gives an error 
        c1.eat();
        s1.boy();
        d1.girl();
    }
}

        class parent{
        void genes(){
        System.out.println("This is a parent");
    }
}
    class child extends parent{
        void eat(){
            System.out.println("This is a child");
        }
}
    class son extends child{

        void boy(){
            System.out.println("This is a boy");
        }
    }
    class daughter extends child{
        void girl(){
            System.out.println("This is a girl");
        }
    }
   
