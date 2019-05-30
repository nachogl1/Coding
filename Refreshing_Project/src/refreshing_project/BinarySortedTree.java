package refreshing_project;

/**
 *
 * @author Ignacio_Gonzalez Binary Search Tree or Sorted Tree
 */
public class BinarySortedTree {

    Node root;

    public BinarySortedTree() {
    }

    public void addNode(int data, String name) {
        Node newNode = new Node(data, name);
        if (this.root == null) {
            root = newNode;
        } else {
            Node parent = root;
            while (true) {
                if (data < parent.getData()) {
                    if (parent.getLeft_child() == null) {
                        parent.setLeft_child(newNode);
                        return;
                    } else {
                        parent = parent.getLeft_child();
                    }
                } else {
                    if (parent.getRight_child() == null) {
                        parent.setRight_child(newNode);
                        return;
                    } else {
                        parent = parent.getRight_child();
                    }
                }
            }
        }

    }

    public void inOrderTraversing(Node parent) {
        if (parent != null) {
            inOrderTraversing(parent.getLeft_child());
            System.out.println(parent);
            inOrderTraversing(parent.getRight_child());
        }
    }

    public void preOrderTraversing(Node parent) {
        if (parent != null) {
            System.out.println(parent);
            preOrderTraversing(parent.getLeft_child());
            preOrderTraversing(parent.getRight_child());
        }
    }

    public void postOrderTraversing(Node parent) {
        if (parent != null) {
            postOrderTraversing(parent.getLeft_child());
            postOrderTraversing(parent.getRight_child());
            System.out.println(parent);
        }
    }

    public Node findNode(int data) {
        //I think it is deep-first seach
        Node parent = root;
        while (parent.getData() != data) {
            if (data < parent.getData()) {
                parent = parent.getLeft_child();
            } else {
                parent = parent.getRight_child();
            }
            if (parent == null) {
                return null;
            }
        }
        return parent;
    }
//__

    public boolean remove(int data) {

        // Start at the top of the tree
        Node focusNode = root;
        Node parent = root;

        // When searching for a Node this will
        // tell us whether to search to the
        // right or left
        boolean isItALeftChild = true;

        // While we haven't found the Node
        // keep looking
        while (focusNode.getData() != data) {

            parent = focusNode;

            // If we should search to the left
            if (data < focusNode.getData()) {

                isItALeftChild = true;

                // Shift the focus Node to the left child
                focusNode = focusNode.getLeft_child();

            } else {

                // Greater than focus node so go to the right
                isItALeftChild = false;

                // Shift the focus Node to the right child
                focusNode = focusNode.getRight_child();

            }

            // The node wasn't found
            if (focusNode == null) {
                return false;
            }

        }

        // If Node doesn't have children delete it
        if (focusNode.getLeft_child() == null && focusNode.getRight_child() == null) {

            // If root delete it
            if (focusNode == root) {
                root = null;
            } // If it was marked as a left child
            // of the parent delete it in its parent
            else if (isItALeftChild) {
                parent.setLeft_child(null);
            } // Vice versa for the right child
            else {
                parent.setRight_child(null);
            }

        } // If no right child
        else if (focusNode.getRight_child() == null) {

            if (focusNode == root) {
                root = focusNode.getLeft_child();
            } // If focus Node was on the left of parent
            // move the focus Nodes left child up to the
            // parent node
            else if (isItALeftChild) {
                parent.setLeft_child(focusNode.getLeft_child()) ;
            } // Vice versa for the right child
            else {
                parent.setRight_child(focusNode.getLeft_child());
            }

        } // If no left child
        else if (focusNode.getLeft_child() == null) {

            if (focusNode == root) {
                root = focusNode.getRight_child();
            } // If focus Node was on the left of parent
            // move the focus Nodes right child up to the
            // parent node
            else if (isItALeftChild) {
                parent.setLeft_child(focusNode.getRight_child());
            } // Vice versa for the left child
            else {
                parent.setRight_child(focusNode.getRight_child());
            }

        } // Two children so I need to find the deleted nodes
        // replacement
        else {

            Node replacement = getReplacementNode(focusNode);

            // If the focusNode is root replace root
            // with the replacement
            if (focusNode == root) {
                root = replacement;
            } // If the deleted node was a left child
            // make the replacement the left child
            else if (isItALeftChild) {
                parent.setLeft_child(replacement);
            } // Vice versa if it was a right child
            else {
                parent.setRight_child(replacement);
            }

            replacement.setLeft_child(focusNode.getLeft_child());

        }

        return true;

    }

    public Node getReplacementNode(Node replacedNode) {

        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.getRight_child();

        // While there are no more left children
        while (focusNode != null) {

            replacementParent = replacement;

            replacement = focusNode;

            focusNode = focusNode.getLeft_child();

        }

        // If the replacement isn't the right child
        // move the replacement into the parents
        // leftChild slot and move the replaced nodes
        // right child into the replacements rightChild
        if (replacement != replacedNode.getRight_child()) {

            replacementParent.setLeft_child(replacement.getRight_child());
            replacement.setLeft_child(replacedNode.getRight_child());

        }

        return replacement;

    }
//__
}

class Node {

    private int data;
    private String name;
    private Node left_child;
    private Node right_child;

    public Node(int data, String name) {
        this.data = data;
        this.name = name;
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
