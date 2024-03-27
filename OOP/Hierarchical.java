public class Hierarchical {
    
    public static void main(String[] args) {
        // hierrarichal inheritance
        // maruti and tesla are inherited from car
        Car c=new Car();
        Maruti m=new Maruti();
        Tesla t=new Tesla();
        t.Break();
        m.accelerator();
        t.Shape();
        //m.power(); // gives an error
    }
}
class Car{

    void accelerator()
    {
        System.out.println("Max speed is 200km");
    }
    void gear(){
        System.out.println("Max gear is 5th gear");

    }
    void Break(){
        System.out.println("Break  absorbs friction on tyres.");
    }
}

class Maruti extends Car{
    void Shape()
    {
        System.out.println("Shape is aerodynamically perfect");  
    }
}
class Tesla extends Maruti{
    void power(){
        System.out.println("It is an ev vechile ");
    }
}
