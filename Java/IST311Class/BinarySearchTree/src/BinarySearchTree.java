public class BinarySearchTree {
    // just a root variable
    Node root;

    /**
     * Empty constructor is all we need for now
     */
    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * Adds the data to the tree, duplicates are not allowed
     *
     * @param data value that you want to insert into the tree
     */
    public void add(int data) {
        this.root = this.addNode(root, data);
    }

    /**
     * You need to implement this for the exam, you need to swap the two values, so
     * find the node that contains the first value and find the node that contains
     * the second value, then swap them.
     *
     * @param firstValue  the value of the first node to swap
     * @param secondValue the value of the second node to swap
     * @return true if the swap was successful and false if it wasn't (e.g. one of
     *         the values wasn't there)
     */
    public boolean swapNodes(int firstValue, int secondValue) {
        Node first = null;
        Node second = null;
        Node parentFirst = null;
        Node parentSecond = null;
        Node temp = this.root;
        boolean isFound = true;
        while(isFound){

            if(temp.data.compareTo(firstValue)>0){
                parentFirst=temp;
                temp=temp.left;
            }else{
                if(temp.data.compareTo(firstValue)<0){
                    parentFirst=temp;
                    temp=temp.right;
                }else{
                    first=temp;
                    break;
                }
            }
            if(temp==null){
                isFound = false;
            }
        }//end while loop

        temp = this.root;
        isFound = true;
        while(isFound){

            if(temp.data.compareTo(secondValue)>0){
                parentSecond=temp;
                temp=temp.left;
            }else{
                if(temp.data.compareTo(secondValue)<0){
                    parentSecond=temp;
                    temp=temp.right;
                }else{
                    second=temp;
                    break;
                }
            }

            if(temp==null){
                isFound = false;
            }
        }//end while loop

        if(first==null || second==null){
            return false;
        }else{
            Node rightOfSecond = second.right;
            Node leftOfSecond = second.left;

            second.right=first.right;
            second.left= first.left;

            if(parentFirst.data.compareTo(firstValue)>0){
                parentFirst.left=second;
            }else{
                parentFirst.right=second;
            }

            first.right=rightOfSecond;
            first.left=leftOfSecond;

            if(parentSecond.data.compareTo(secondValue)>0){
                parentSecond.left=first;
            }else{
                parentSecond.right=first;
            }

            return true;
        }
    }

    /**
     * You need to implement this for the exam, you need to check if the tree is
     * constructed in a valid way, e.g. if a child of a node violates the BST rules
     * it is invalid and returns false
     *
     * @return true if the tree is valid and false if it isn't
     */
    public boolean isValid() {
        return isValid(this.root);
    }

    private boolean isValid(Node current){
        if(current==null){
            return true;
        }else{
            boolean leftTrue=false;
            boolean rightTrue=false;
            if(current.left==null || current.data.compareTo(current.left.data)>0){
                leftTrue=isValid(current.left);
            }

            if(current.right==null || current.data.compareTo(current.right.data)<0){
                rightTrue=isValid(current.right);
            }
            if(!leftTrue || !rightTrue){
                return false;
            }else{
                return true;
            }
        }
    }//end method

    /**
     * You need to implement this for the exam, you need to find the two nodes that
     * violate the BST and call swapNodes on them
     *
     * @return true if the tree is valid and false if it isn't
     */
    public boolean fixTree() {
        if(isValid()) {
            return true;
        }else {

            Node leftNode = swappedNode(this.root.left,true);
            Node rightNode = swappedNode(this.root.right,false);
            Node parentLeft = this.root;
            Node parentRight = this.root;

            Node tempLeft = this.root.left;
            //First get left Node Parent
            while(true){
                if(tempLeft.data.equals(leftNode.data)){
                    break;
                }
                parentLeft=tempLeft;
                if(tempLeft.left.data.compareTo(leftNode.data)!=0 && tempLeft.right.data.compareTo(leftNode.data)!=0){
                    parentLeft=tempLeft;
                    if(tempLeft.data.compareTo(rightNode.data)>0){
                        tempLeft=tempLeft.left;
                    }else{
                        tempLeft=tempLeft.right;
                    }
                }else{
                    break;
                }
            }

            Node tempRight = this.root.right;
            while(true){
                if(tempRight.data.equals(rightNode.data)){
                    break;
                }
                parentRight=tempRight;
                if(tempRight.left.data.compareTo(rightNode.data)!=0 && tempRight.right.data.compareTo(rightNode.data)!=0){
                    parentRight=tempRight;
                    if(tempRight.data.compareTo(leftNode.data)>0){
                        tempRight=tempRight.left;
                    }else{
                        tempRight=tempRight.right;
                    }
                }else{
                    break;
                }
            }

            Node rightRightNode= rightNode.right;
            Node leftRightNode = rightNode.left;
            rightNode.right=leftNode.right;
            rightNode.left=leftNode.left;
            if(parentLeft.data.compareTo(rightNode.data)>0){
                parentLeft.left=rightNode;
            }else{
                parentLeft.right=rightNode;
            }

            leftNode.right=rightRightNode;
            leftNode.left=leftRightNode;
            if(parentRight.data.compareTo(leftNode.data)>0){
                parentRight.left=leftNode;
            }else{
                parentRight.right=leftNode;
            }
            return true;
        }
    }

    private Node swappedNode(Node current,boolean direction){
        if(current==null){
            return null;
        }else{
            if(direction){
                if(current.data.compareTo(this.root.data)>0){
                    return current;
                }
                if(current.left==null){
                    return null;
                }
                if(current.data.compareTo(current.left.data)<0 || this.root.data.compareTo(current.left.data)<0){
                    return current.left;
                }else if(current.data.compareTo(current.right.data)>0|| this.root.data.compareTo(current.left.data)<0) {
                    return current.right;
                }else{
                    Node value = swappedNode(current.left,direction);
                    if(value==null){
                        return swappedNode(current.right,direction);
                    }else{
                        return value;
                    }
                }
            }else{
                if(current.data.compareTo(this.root.data)<0){
                    return current;
                }
                if(current.right==null){
                    return null;
                }

                if(current.data.compareTo(current.right.data)>0|| this.root.data.compareTo(current.right.data)>0){
                    return current.right;
                }else if(current.data.compareTo(current.left.data)<0 || this.root.data.compareTo(current.right.data)>0){
                    return current.left;
                }else{
                    Node value = swappedNode(current.right,direction);
                    if(value==null){
                        return swappedNode(current.left,direction);
                    }else{
                        return value;
                    }
                }
            }
        }
    }//end method



    /**
     * Recursive function to find where to insert a node, no duplicates
     *
     * @param current the node that we are comparing to
     * @param data    the data we want to insert into tree
     * @return the modified node, not the inserted node
     */
    private Node addNode(Node current, int data) {
        // time to insert node
        if (current == null) {
            return new Node(data);
        }

        // compare the data to the current node to see which way to traverse
        if (data < current.data) {
            current.left = this.addNode(current.left, data);
        } else if (data > current.data) {
            current.right = this.addNode(current.right, data);
        }

        // if the data is already there, just return current
        return current;
    }

    @Override
    public String toString() {
        String result = this.inOrderTraversal(this.root);
        return result.trim();
    }

    private String inOrderTraversal(Node current) {
        StringBuilder strBldr = new StringBuilder();

        // check if we have anything to add to the string
        if (current != null) {
            // go left first because this is inorder
            strBldr.append(this.inOrderTraversal(current.left));

            // no print the current node
            strBldr.append(current.data + " ");

            // go right last because inorder
            strBldr.append(this.inOrderTraversal(current.right));
        }

        return strBldr.toString();
    }
}