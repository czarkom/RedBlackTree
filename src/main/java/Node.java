public class Node<K extends Comparable<K>,V> {
    K key;
    V value;
    Node left;
    Node right;
    boolean isRed;

    Node(K key, V value){
        this.key = key;
        this.value = value;
        isRed = true;
        left = null;
        right = null;
    }
}
