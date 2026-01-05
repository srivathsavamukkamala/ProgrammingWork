public class Node<T> {
    public T data;

    public Node<T> next;

    public Node<T> previous;


    //Empty Constructor
    public Node(){
        this.data = null;
        this.next = null;
        this.previous = null;
    }

    //If User provides data
    public Node(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}
