package trees;

public class BinarySearchTree {

    private Node root;

    public Node getRoot(){
        return root;
    }

    public void setRoot(Node root){
        this.root = root;
    }

    public boolean isEmpty(){
        return  this.root == null;
    }

    public void add_iter(int value){
        if (isEmpty()){
            this.root = new Node(value);
        }

        Node currentNode = this.root;
        //traverse tree until valid position is found
        while (currentNode != null){
            Node leftChild = currentNode.getLeft();
            Node rightChild = currentNode.getRight();

            //follow BST formula
            if(currentNode.getData() > value){
                if (leftChild == null){
                    currentNode.setLeft(new Node(value));
                }
                //set current to the left node
                currentNode = leftChild;
            }else {
                if (rightChild == null){
                    rightChild = new Node(value);
                    currentNode.setRight(rightChild);
                }
                currentNode = rightChild;
            }
        }
    }

    public Node recursiveInsert(Node currentNode, int value){
        // base case
        if(currentNode == null){
            return new Node(value);
        }

        //follow the bst formula
        if( value < currentNode.getData()){
            //iterate on LST
            currentNode.setLeft(recursiveInsert(currentNode.getLeft(), value));
        }else if( value > currentNode.getData()){
            //iterate on RST
            currentNode.setRight(recursiveInsert(currentNode.getRight(), value));
        }else {
            //node exists
            return  currentNode;
        }
        return  currentNode;
    }

    public void add(int value){
        this.root = recursiveInsert(this.root, value);
    }

    public void printTree(Node current)
    {
        if (current == null) return;
        System.out.print(current.getData() + ",");
        printTree(current.getLeft());
        printTree(current.getRight());

    }
    //O(log(n)
    public Node search_iter(int value){
        if (isEmpty()){
            return null;
        }
        Node currentNode = this.root;
        while (currentNode != null){
            if (currentNode.getData() == value ){
                return currentNode;
            }else if(currentNode.getData() > value ){
                currentNode = currentNode.getLeft(); //move left
            }else {
                currentNode = currentNode.getRight();
            }
        }
        return null;
    }

    public Node search(int value){
        if (isEmpty()){
            return null;
        }
        return  searchRecursive(value, this.root);
    }

    public Node searchRecursive(int value, Node currentNode){
        //base case
        if (currentNode == null || currentNode.getData() == value){
            return currentNode;
        }
        // if value is less then search the LST
        if (value < currentNode.getData()){
            return searchRecursive(value, currentNode.getLeft());
        }else {
            //search the RST
            return  searchRecursive(value, currentNode.getRight());
        }
    }
    public static void preOrderTraverse(Node root){
        if (root == null ){
            return;
        }
        preOrderTraverse(root.getLeft());
        preOrderTraverse(root.getRight());
    }
}
