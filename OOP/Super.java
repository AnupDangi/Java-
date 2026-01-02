public class Super {
    
    public static void main(String[] args) {
        
        Animal ani=new Animal();
        Horse hor=new Horse();
        System.out.println(hor.color);
    }
}

class Animals
{    String color;
    Animals(){
        System.out.println("Animal constructor is called");
    }
}

class Horse extends Animals{
    Horse()
    {
        super.color="brown";
        //super();
        System.out.println("Horse constructor is called");  
    }
}