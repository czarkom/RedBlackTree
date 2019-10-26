public class RBT<K extends Comparable<K>, V> implements MapInterface<K, V>{


    private static Node root = null;


    @Override
    public void setValue(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("Nie chce pustego klucza:(");

        else {
            root = insert(root, key, value);
            root.isRed = false;
        }

    }

    @Override
    public V getValue(K key) {
        Node<K,V> r = root;
        boolean found = false;
        while (r != null)
        {
            K rval = r.key;
            if (key.compareTo(rval) == -1)
                r = r.left;
            else if (key.compareTo(rval) == 1)
                r = r.right;
            else if (key.compareTo(rval) == 0)
            {
                break;
            }
        }
        if(r==null){
            System.out.println("Value of given key not found");
            return null;
        }else{
            System.out.println("Value of the given key:" + r.value);
        }
        return r.value;
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

    boolean isRed(Node<K,V> node){
        if(node == null)
            return false;
        return node.isRed;
    }

    Node insert(Node<K, V> myNode, K key, V value) {
        if (myNode == null)
            return new Node(key, value);

        if (key.compareTo(myNode.key) < 0)
            myNode.left = insert(myNode.left, key, value);
        else if (key.compareTo(myNode.key) > 1)
            myNode.right = insert(myNode.right, key, value);
        else if (key.compareTo(myNode.key) == 0){
            myNode.value = value;
            return myNode;
        }
        else
            return myNode;
        if(isRed(myNode.right) && !isRed(myNode.left)){
            myNode = rotateLeft(myNode);
            swapColors(myNode, myNode.left);
        }
        if(isRed(myNode.left) && isRed(myNode.left.left)){
            myNode = rotateRight(myNode);
            swapColors(myNode, myNode.right);
        }
        if(isRed(myNode.left) && isRed(myNode.right)){
            myNode.isRed = !myNode.isRed;
            myNode.right.isRed = false;
            myNode.left.isRed = false;
        }
        return myNode;
    }

    public static void main(String args[]){
        RBT<String,Integer> tree = new RBT<>();
        tree.setValue("a",25);
        tree.setValue("l",128);
        tree.setValue("g",543);
        tree.setValue("o",32);
        tree.setValue("r",259);
        tree.setValue("y",43);
        System.out.println(root.key);
        tree.setValue("t",25);
        tree.setValue("m",20);


        System.out.println("Values set");
        System.out.println(root.key);

        tree.getValue("o");

    }
}
