import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RBTTest {
    RBT<String, Integer> tree = new RBT<>();

    @org.junit.Test
    public void isValueFromGivenKeyCheckedCorrectly() {
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
    public void isRootCorrect() {
        tree.setValue("a", 25);
        tree.setValue("l", 128);
        tree.setValue("g", 543);
        tree.setValue("o", 37);
        tree.setValue("r", 259);
        tree.setValue("y", 43);
        tree.setValue("t", 25);
        tree.setValue("m", 20);
        assertEquals("o", tree.root.key);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isNullNodeKeyExceptionThrownCorrectly() {
        RBT<String, Integer> tree = new RBT<>();
        tree.setValue(null, 234);
    }

    @Test(expected = IllegalStateException.class)
    public void isNullRootExceptionThrownCorrectly() {
        tree.getValue("o");
    }
}