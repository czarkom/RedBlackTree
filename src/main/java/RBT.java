public class RBT<K extends Comparable<K>, V> implements MapInterface<K, V> {


    private static Node root = null;


    @Override
    public void setValue(K key, V value) {

    }

    @Override
    public V getValue(K key) {
        return null;
    }

    Node rotateLeft(Node myNode)
    {
        System.out.printf("left rotation!!\n");
        Node child = myNode.right;
        Node childLeft = child.left;

        child.left = myNode;
        myNode.right = childLeft;

        return child;
    }

    Node rotateRight(Node myNode)
    {
        System.out.printf("right rotation\n");
        Node child = myNode.left;
        Node childRight = child.right;

        child.right = myNode;
        myNode.left = childRight;

        return child;
    }
}
