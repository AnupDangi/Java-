//import java.util.*;
public class Stacks_Arrays {

    static int top=-1;
    static int max;
    static int stack[];
    public static void push(int element)
    {
        if(top==max-1)
        {
            System.out.println("Stack is full");
        }
        else{
                stack[++top]=element;
            }
    }
    public static void pop()
    {
        if(top==-1)
        {
            System.out.println("Stack is empty");
            return;
        }
        int element=stack[top--];
        System.out.println("The popped element is: "+element);
    }
    public static void printAll()
    {
        if(top==-1)
        {
            System.out.println("Stack is empty");
            return;
        }
        while(top>=0)
        {
            System.out.println(stack[top--]);
        }
    }
    public static void main(String[]args)
    {
      
        System.out.println("Enter the number of elements to push inside the stack: ");
        Scanner sc=new Scanner(System.in);
        max=sc.nextInt();
        stack=new int[max];
        for(int i=0;i<max;i++)
        {
            System.out.println("Enter the element to push: ");
            stack[i]=sc.nextInt();
            push(stack[i]);
        }
        System.out.println("Enter how many times you wanna pooo out: ");
        int poptimes=sc.nextInt();
        for(int i=0;i<poptimes;i++)
        {
            pop();
        }
        printAll();
    }
}
