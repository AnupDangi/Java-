import java.util.Stack;
public class StockSpan {

    public static void stockSpan(int stocks[],int span[])
    {
        Stack<Integer>s=new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=1;i<stocks.length;i++)
        {
            int currPrice=stocks[i];
            //while curPrice is greater than all previous i till the last ie end of stack
            while(!s.isEmpty() && currPrice>stocks[s.peek()])
            {
                //pop all of them
                s.pop();
            }
            //if it is empty then span is i+1
            if(s.isEmpty())
            {
                span[i]=i+1;
            }
            //neither prevhigh is at the top of the stack just peek it and i-prevhigh
            else{
                int prevHigh=s.peek();
                span[i]=i-prevHigh;
            }
            //push the element which is current element
            s.push(i);
        }

    }
    public static void main(String[] args) {
        int stocks[]={100,80,60,70,60,85,100};
        int span[]= new int[stocks.length];
        stockSpan(stocks,span);

        for(int i=0;i<span.length;i++)
        {
            System.out.println(span[i]+" ");
        }



    }
}
