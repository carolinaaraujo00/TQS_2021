import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Stack<T>
{
    LinkedList<T> list = new LinkedList<>();
    private int size = -1;

    public Stack(){

    }

    public Stack(int size){
        this.size = size;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void push(T e) {
        if(this.size == -1){
            list.addFirst(e);
        }else{
            if(this.size == list.size()){
                throw new IllegalStateException();
            }else{
                list.addFirst(e);
            }
        }

    }

    public T pop() {
        if (list.size() == 0) {
            throw new NoSuchElementException();
        }
        T ret = list.get(0);
        list.remove(0);
        return ret;
    }

    public T peek() {
        if (list.size() == 0) {
            throw new NoSuchElementException();
        }
        return list.get(0);
    }

    public int size() {
        return list.size();
    }

}
