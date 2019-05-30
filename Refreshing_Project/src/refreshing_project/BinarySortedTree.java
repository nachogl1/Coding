package refreshing_project;

/**
 *
 * @author Ignacio_Gonzalez 
 * Binary Search Tree or Sorted Tree
 */
public class BinarySortedTree {

    Node root;
    
    public BinarySortedTree(){}

    public void addNode(int data, String name) {
        Node newNode = new Node(data,name);
        if (this.root == null) {
            root = newNode;
        }else{
            Node parent=root;
            while(true){
                if(data < parent.getData()){                  
                    if(parent.getLeft_child() == null){
                        parent.setLeft_child(newNode);
                        return;
                    }else{
                        parent=parent.getLeft_child();
                    }
                }else {
                    if(parent.getRight_child() == null){
                        parent.setRight_child(newNode);
                        return;
                    }else{
                        parent=parent.getRight_child();
                    }
                }
            }
        }
        
    }

    public void deleteNode() {
    }

    public void inOrderTraversing(Node parent) {
       if(parent!=null){
           inOrderTraversing(parent.getLeft_child());
           System.out.println(parent);
           inOrderTraversing(parent.getRight_child());
       }
    }
    public void preOrderTraversing(Node parent) {
       if(parent!=null){
           System.out.println(parent);
           preOrderTraversing(parent.getLeft_child());
           preOrderTraversing(parent.getRight_child());
       }
    }
    public void postOrderTraversing(Node parent) {
       if(parent!=null){
           postOrderTraversing(parent.getLeft_child());
           postOrderTraversing(parent.getRight_child());
           System.out.println(parent);
       }
    }
    public Node findNode(int data){
        //I think it is deep-first seach
        Node parent = root;
        while(parent.getData()!=data){
            if(data < parent.getData()){
                parent = parent.getLeft_child();
            }else{
                parent=parent.getRight_child();
            }
            if(parent==null){return null;}
        }
        return parent;
    }

}

class Node {

    private int data;
    private String name;
    private Node left_child;
    private Node right_child;

    public Node(int data, String name) {
        this.data = data;
        this.name=name;
        this.left_child = null;
        this.right_child = null;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", name=" + name + ", left_child=" + left_child + ", right_child=" + right_child + '}';
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft_child() {
        return left_child;
    }

    public void setLeft_child(Node left_child) {
        this.left_child = left_child;
    }

    public Node getRight_child() {
        return right_child;
    }

    public void setRight_child(Node right_child) {
        this.right_child = right_child;
    }
    

}
