import java.util.Stack;

public class Question1
{
    Stack<Integer> in;
    Stack<Integer> out;

    public Question1()
    {
        in=new Stack<>();
        out=new Stack<>();
    }

    public void push(int x)
    {
        in.push(x);
    }

    public int pop()
    {
        peek();
        return out.pop();
    }

    public int peek()
    {
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty()
    {
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args)
    {
        Question1 q=new Question1();
        q.push(1);
        q.push(2);

        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}