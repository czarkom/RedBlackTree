public class RBT<K extends Comparable<K>,V> implements MapInterface<K,V>{


    @Override
    public void setValue(K key, V value) {

    }

    @Override
    public V getValue(K key) {
        return null;
    }

    private class Node<K extends Comparable<K>,V>{
        private V value;
        private Node<K,V> parent;
        private Node<K,V> leftSon;
        private Node<K,V> rightSon;
        private K key;
        private boolean isRed;
    }

}
