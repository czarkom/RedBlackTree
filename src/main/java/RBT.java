public class RBT<K extends Comparable<K>, V> implements MapInterface<K, V> {


    private static Node root = null;


    @Override
    public void setValue(K key, V value) {
        root = insert(root, key, value);
    }

    @Override
    public V getValue(K key) {
        return null;
    }

    Node rotateLeft(Node<K, V> myNode) {
        System.out.printf("left rotation!!\n");
        Node child = myNode.right;
        Node childLeft = child.left;

        child.left = myNode;
        myNode.right = childLeft;

        return child;
    }

    Node rotateRight(Node<K, V> myNode) {
        System.out.printf("right rotation\n");
        Node child = myNode.left;
        Node childRight = child.right;

        child.right = myNode;
        myNode.left = childRight;

        return child;
    }

    void swapColors(Node node1, Node node2){
        boolean temp = node1.isRed;
        node1.isRed = node2.isRed;
        node2.isRed = temp;
    }

    Node insert(Node<K, V> myNode, K key, V value) {
        if (myNode == null)
            return new Node(key, value);

        if (key.compareTo(myNode.key) == -1)
            myNode.left = insert(myNode.left, key, value);
        if (key.compareTo(myNode.key) == 1)
            myNode.right = insert(myNode.right, key, value);
        else
            return myNode;
        if(myNode.right.isRed && !myNode.left.isRed){
            myNode = rotateLeft(myNode);
            swapColors(myNode, myNode.left);
        }
        if(myNode.left.isRed && myNode.left.left.isRed){
            myNode = rotateRight(myNode);
            swapColors(myNode, myNode.right);
        }
        if(myNode.left.isRed && myNode.right.isRed){
            myNode.isRed = !myNode.isRed;
            myNode.right.isRed = false;
            myNode.left.isRed = false;
        }
        return myNode;
    }

    public static void main(String args[]){
        RBT<Integer,Integer> tree = new RBT<>();
        tree.setValue(20,25);

    }
}
