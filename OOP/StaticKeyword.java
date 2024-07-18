public class StaticKeyword {
    //static var methods and class and cannot be changed or overridden


    public static void main(String[] args) {
        Students std=new Students();
        std.schoolName="LLM";
        String name="Anup";
        std.setName(name);
        Students s2=new Students();
        System.out.println(s2.schoolName); 
        System.out.println(std.sum(1, 2, 3));
        System.out.println(s2.sum(4, 5, 6));
        // this sum method is inside stduents class whose sum method is 
        //static once it is static we can acccess it using no of refrence variables multiple times
        
       }

}
  class Students{ 
    String name;
    int roll;
   static String schoolName;

   static int sum(int a, int b, int c)
   {
    return a+b+c;
   }
    
    //getter 
    void setName(String name)
    {
       this.name=name;
    }
    String getName(){
        return this.name;
    }
}

