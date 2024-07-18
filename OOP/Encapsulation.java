public class Encapsulation {
    
    public static void main(String[] args) {

        Message msg=new Message();
        msg.setMessage("Hello What is your name?");
        msg.printMessage(msg.message);
    }
}

    // Encapsulation refers to wrapping up of data and methods under a single unit. It implements data hiding 
    // data hiding refers to hide of data from the normal user
    class Message
    {
         String message="Hello";

        void setMessage(String newMessage)
        {
             message=newMessage;
        }
        void printMessage(String message)
        {
            System.out.print(message);
        }
    }
    