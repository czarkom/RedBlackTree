import static org.junit.Assert.*;

public class RBTTest {

    @org.junit.Test
    public void setValue() {
        RBT<String, Integer> tree = new RBT<>();
        tree.setValue("a", 25);
        tree.setValue("l", 128);
        tree.setValue("g", 543);
        tree.setValue("o", 37);
        tree.setValue("r", 259);
        tree.setValue("y", 43);
        tree.setValue("t", 25);
        tree.setValue("m", 20);

        assertEquals(128, (int) tree.getValue("l"));
    }

    @org.junit.Test
    public void getValue() {
    }

    @org.junit.Test
    public void rotateLeft() {
    }

    @org.junit.Test
    public void rotateRight() {
    }
}