import org.junit.Test;

import java.util.Random;

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
        tree.setValue(null, 234);
    }

    @Test(expected = IllegalStateException.class)
    public void isNullRootExceptionThrownCorrectly() {
        tree.getValue("o");
    }

    @Test
    public void checkTimeforDifferentNumbersofData(){
        RBT<Double, Double> tree = new RBT<>();
        double constValueforTest = 1;
        Random r = new Random();
        for(int i = 100; i < 10000; i=i+100){
            long x = System.nanoTime();
            for (int j = 0; j < i; j++){
                tree.setValue(r.nextDouble(), constValueforTest);
            }
            long y = System.nanoTime();
            long difference = y  - x;
            System.out.println("Time of execution for\t" + i + "\telements:\t" + difference);
        }
    }
}