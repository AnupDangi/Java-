
public class BasicOOPS {
    public static void main(String[] args) {
        
        Pen p1=new Pen();//created an object a class Pen
        p1.setColor("Blue");
        System.out.println(p1.getcolor());
        p1.settip(5);
        System.out.println(p1.getTip());
        p1.setColor("Yellow");
        System.out.println(p1.getcolor());
        // Student s1=new Student();
        BankAccount myAccount=new BankAccount();
        myAccount.username="Anup";
        myAccount.setPassword("abcdefghi");
        
    }
}
    class Pen{
       private String color;
        private int tip;
        String getcolor(){
            return this.color;// refer to current object and can access the arguments or variables
        }
        int getTip(){
            return this.tip;
        }
        void setColor(String newColor)//color
        {
            this.color=newColor;
        }
        void settip(int tip)
        {
            this.tip=tip;
        }
    }
        class Student{
            String name;
            int age;
            float percentage;
            void calcPercentage(int phy, int chem, int math)
            {
                percentage=((phy+chem+math)/3) *100;
            }
        }
        class BankAccount{
           public  String username;
            private String Password;
            public void setPassword(String pwd)
            {
                Password=pwd;
            }
        }

