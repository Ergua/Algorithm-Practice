package other;

/**
 * Created by FYG on 17/7/28.
 */
public class MyNode<T> {
    private MyNode<T> next=null;
    private MyNode<T> prev=null;
    private T cur = null;
    MyNode(MyNode<T> prev, T obj, MyNode<T> next)
    {
        this.cur = obj;
        this.prev = prev;
        this.next = next;
    }

    public T getCur()
    {
        return cur;
    }
    public MyNode getNext()
    {
        return next;
    }
    public MyNode getPrev()
    {
        return prev;
    }
    public void setCur(T obj)
    {
        this.cur=obj;
    }
    public void setNext(MyNode next)
    {
        this.next=next;
    }
    public void setPrev(MyNode prev)
    {
        this.prev=prev;
    }
}
