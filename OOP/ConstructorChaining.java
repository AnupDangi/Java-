public class ConstructorChaining {
    
    public static void main(String[] args) {
        Calculation cal=new Calculation();
    }
}
//main use of constructor chaining is used to call one constructor from another constructor 
// The  problem is to  call sum of three numbers from sum of 2 numbers  constructor and sum of 2 numbers constuctor is called from a default constructor

class Calculation{

    //default constructor
    Calculation()
    {
        this(5,6);
        System.out.print("This is a default Constructors");

    }
    Calculation(int a, int b)
    {
        this(5,6,7);// this calls the constructor of three parameters 
        System.out.println(a*b);
    }
    
    Calculation(int a, int b, int c)
    {
       // this(5,6); // if we call this constructor this will show error 
        System.out.println(a*b*c);
    }
    
}



