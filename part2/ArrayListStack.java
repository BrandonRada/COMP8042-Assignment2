import java.util.ArrayList;

public class ArrayListStack<T> implements Stack<T>{
    private ArrayList<T> parenthesesList;
    private int top;

    public ArrayListStack(){
        parenthesesList = new ArrayList<>();
        top = -1;
    }

    public boolean empty(){
        return top == -1;
    }

    public T peek(){
        if(empty()){
            return null;
        }
        return parenthesesList.get(top);
    }

    public T pop(){
        if(empty()){
            return null;
        }
        T topValue = parenthesesList.remove(top);
        top--;
        return topValue;
    }

    public T push(T newValue){
        parenthesesList.add(newValue);
        top++;
        return newValue;
    }
}

/**
 * Question 2:
 * the big O complexity for the pop push and peek methods are as follows:
 * pop:     O(1) Removes the last element of the ArrayList
 * push:    O(1) adds am element to the end of ArrayList
 * peek:    O(1) reads the last element without removing it
 */