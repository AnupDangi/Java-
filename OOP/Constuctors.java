public class Constuctors {
    
   
    public static void main(String[] args) {
    //     AIML aiml=new AIML(50,60,70);// paramterized constructors passing paramters
    //     AIML aiml2=new AIML();// non-parameterized constructors
    //    // Paramterized constructors output statements
    //     System.out.println(aiml.A);
    //     System.out.println(aiml.B);
    //     System.out.println(aiml.C);
       
    //     // non Paramterized constructors output statements

    //     System.out.println(aiml2.A);
    //     System.out.println(aiml2.B);
    //     System.out.println(aiml2.C);

        // copy constructors
        Student s1=new Student();
        s1.name="Anup";
        s1.roll=456;
        s1.password="abcd";
        s1.marks[0]=100;
        s1.marks[1]=90;
        s1.marks[2]=80;

        Student s2=new Student(s1);//copy
        s2.password="xyz";
        s1.marks[2]=100;
        for(int i=0;i<3;i++)
        {
            System.out.println(s2.marks[i]);
        }
    }
}
class AIML{
        
    protected int A;
    protected int B;
    protected int C;


    AIML(int A, int B, int C){// parameterized constructors 
        this.A=50;
        this.B=60;
        this.C=70;
    }
    AIML(){     // unparametrized constructors
        this.A=60;
        this.B=70;
        this.C=80;
    }
}





class Student {
    String name;
    int roll;
    String password;
    int marks[];
    
    Student()
    {
        marks = new int[3];
    }
    //shallow copy constructors
//     Student (Student s1)
//     {
//          marks=new int[3];
//         this.name=s1.name;
//         this.roll=s1.roll;
//         this.marks=s1.marks;
//         for (int i = 0; i < s1.marks.length; i++) {
//             this.marks[i]=s1.marks[i];
//     }
// }

   // deep copy constructor
    Student(Student s1)
    {
         marks=new int[3];
        this.name=s1.name;
        this.roll=s1.roll;
        for(int i=0; i<marks.length;i++)
        {
            this.marks[i]=s1.marks[i];
        }
    }
}

