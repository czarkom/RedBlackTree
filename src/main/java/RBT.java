public class RBT<K extends Comparable<K>, V> implements MapInterface<K, V> {


    private Node<K, V> root;
    private Node<K, V> nil;

    public RBT() {
        nil = new Node<K, V>(null, null, false, null);
    }

    @Override
    public void setValue(K key, V value) {

    }

    @Override
    public V getValue(K key) {
        return null;
    }

    private void leftRotate(Node<K, V> x) {
        assert x.rightSon != nil;

        Node<K, V> y = x.rightSon;
        x.rightSon = y.leftSon;
        y.leftSon.parent = x;
        y.parent = x.parent;
        if (x.parent == nil)
            root = y;
        else {
            if (x == x.parent.leftSon)
                x.parent.leftSon = y;
            else
                x.parent.rightSon = y;
        }
        y.leftSon = x;
        x.parent = y;
    }

    private void rightRotate(Node<K, V> y) {
        assert y.leftSon != nil;

        Node<K, V> x = y.leftSon;
        y.leftSon = x.rightSon;
        x.rightSon.parent = y;
        x.parent = y.parent;
        if (y.parent == nil)
            root = x;
        else {
            if (y == y.parent.rightSon)
                y.parent.rightSon = x;
            else
                y.parent.leftSon = x;
        }
        x.rightSon = y;
        y.parent = x;
    }

    private class Node<K extends Comparable<K>, V> {
        private V value;
        private Node<K, V> parent;
        private Node<K, V> leftSon;
        private Node<K, V> rightSon;
        private K key;
        private boolean isRed;


        Node(K _key, Node<K,V> _parent, V _value){
            this.key = _key;
            this.value = _value;
            this.parent = _parent;
            leftSon = (Node<K, V>) nil;
            rightSon = (Node<K, V>) nil;
            isRed = true;
        }


        Node(K _key, Node<K, V> _parent, boolean _red, V _value) {
            this(_key, _parent, _value);
            this.isRed = _red;
        }

        boolean isAlone() {
            return leftSon == nil || rightSon == nil;
        }

        void paintRed() {
            isRed = true;
        }

        void paintBlack() {
            isRed = false;
        }
    }

}
