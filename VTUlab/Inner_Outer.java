package labprog;
class Outer{
        void outmethod(){
            System.out.println("This is a outer method");
        }
    class Inner{
        void inmethod(){
            System.out.println("This is a inner method");
        }
    }
}
    public class Inner_Outer {
    public static void main(String[] args) {
        Outer out=new Outer();
        out.outmethod();
        Outer.Inner inner= out.new Inner();
        inner.inmethod();
    }
}
