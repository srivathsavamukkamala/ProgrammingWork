import java.util.ArrayList;

public class DoublyLinkedList<T extends Comparable<T>> {
    public Node<T> head;

    public Node<T> tail;

    public DoublyLinkedList(){
        this.head = null;
    }

    public Node<T> append(T data){
        Node<T> newNode = new Node<>(data);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else{

            if(this.head.next == null){
                this.head.next = newNode;
                newNode.previous = this.tail;

                this.tail = newNode;
            }else{
                this.tail.next = newNode;
                newNode.previous = this.tail;

                this.tail = newNode;
            }
        }
        return newNode;
    }


    public Node<T> insert(int location, T data){
        Node<T> newNode = new Node<>(data);
        if(location == 0){
            newNode.next=this.head;
            this.head = newNode;
            newNode.next.previous=newNode;
        }else if(location>0){
            Node<T> temp = this.head;
            location--;
            while(location!=0){
                temp=temp.next;
                location--;
                if(temp.next==null && location!=0){
                    throw new IllegalArgumentException("Location outside of list");
                }
            }
            newNode.next = temp.next;
            temp.next = newNode;
            newNode.previous=temp;
            if(newNode.next!=null){
                newNode.next.previous=newNode;
            }else{
                this.tail=newNode;
            }
        }else{
            throw new IllegalArgumentException("Location outside of list");
        }
        return newNode;
    }//end insert method

    public Node<T> delete(int location){
        if(location<0 || this.head==null){
            throw new IllegalArgumentException("Location does not Exist");
        }else if(location==0){
            if(head.next!=null) {
                Node<T> returnNode = this.head;
                Node<T> temp = this.head.next;
                returnNode.next = null;
                temp.previous = null;
                this.head = temp;
                setTail();
                return returnNode;
            }else{
                Node<T> temp = this.head;
                this.head = null;
                this.tail=null;
                return temp;
            }
        }else{
            Node<T> temp = this.head.next;
            location--;
            while(location!=0){
                temp=temp.next;
                location--;
                if(temp.next==null && location!=0){
                    throw new IllegalArgumentException("Location outside of list");
                }
            }
            setTail();
            if(temp.next==null){
                temp.previous.next = null;
                temp.previous = null;
                return temp;
            }else{
                Node<T> nextNode = temp.next;
                Node<T> previousNode = temp.previous;
                previousNode.next = nextNode;
                previousNode.next.previous = previousNode;
                temp.next = null;
                temp.previous = null;
                //this.head = previousNode;
                return temp;
            }


        }//end if else statement
    }//end delete method

    public int getIndex(T data){
        Node<T> temp = this.head;
        int index = 0;
        while(temp!=null){
            if(temp.data.equals(data)){
                return index;
            }else{
                index++;
                temp=temp.next;
            }
        }//end while loop
        return -1;
    }

    @Override
    public String toString() {
        String value = "";
        if(this.head == null){
            value = "NULL";
            return value;
        }else{
            Node<T> temp = this.head;
            while(temp!=null){
                value+=temp.data.toString();
                value+=" -> ";
                temp=temp.next;
            }
            value+="NULL";
            return value;
        }
    }

    public DoublyLinkedList<T> partition(T data) {
        DoublyLinkedList<T> result = new DoublyLinkedList<>();
        Node<T> temp = this.head;
        while(temp!=null){
            if(temp.data.compareTo(data)>=0){
                result.append(temp.data);
            }//end if statement
            temp=temp.next;
        }//end while loop
        return result;
    }//end partition

    public Node<T> shuffle(){
        if(this.head==null || this.head.next==null){
            return this.head;
        }else{
            ArrayList<Node<T>> listOfElements = new ArrayList<>();
            Node<T> temp = this.head;
            while(temp!=null){
                listOfElements.add(temp);
                temp=temp.next;
            }//end while loop
            this.head=null;
            for(int i=1;i<listOfElements.size();i=i+2){
                this.append(listOfElements.get(i).data);
                this.append(listOfElements.get(i-1).data);
            }
            if(listOfElements.size()%2==1){
                this.append(listOfElements.get(listOfElements.size()-1).data);
            }//end if statement
        }//end if else statement
        return this.head;
    }//end shuffle method

    private void setTail(){
        if(this.head==null){
            this.tail=null;
        }else {
            Node<T> temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            this.tail = temp;
        }
    }
}
