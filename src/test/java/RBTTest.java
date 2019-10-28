import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class RBTTest {
    RBT<String, Integer> tree = new RBT<>();

    @Test
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

    @Test
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

    @Test(expected = IllegalArgumentException.class)
    public void isNullNodeValueExceptionThrownCorrectly() {
        tree.setValue("a", null);
    }

    @Test(expected = IllegalStateException.class)
    public void isNullRootExceptionThrownCorrectly() {
        tree.getValue("o");
    }

    @Test
    public void checkTimeOfInsertingDifferentNumbersOfData() {
        Random r = new Random(System.currentTimeMillis());
        RBT<Integer, Integer> tree = new RBT<>();
        int randKey;
        long x, difference;
        int constValueforTest = 1;
        for (int i = 100; i <= 10000; i = i + 100) {
            x = System.nanoTime();
            for (int j = 0; j < i; j++) {
                randKey = r.nextInt();
                tree.setValue(randKey, constValueforTest);
            }
            difference = System.nanoTime() - x;
            System.out.println("Time of execution for inserting\t " + i + " elements:\t" + difference + " nanoseconds");
        }
    }

    @Test
    public void testRotateRight() {
        Node x = new Node(1, 1);
        Node y = new Node(1, 1);
        Node b = new Node(1, 1);
        x.right = b;
        y.left = x;
        assertEquals(x, tree.rotateRight(y));
        assertEquals(y, x.right);
        assertEquals(y.left, b);
    }

    @Test
    public void testRotateLeft() {
        Node x = new Node(1, 1);
        Node y = new Node(1, 1);
        Node b = new Node(1, 1);
        x.right = y;
        y.left = b;
        assertEquals(y, tree.rotateLeft(x));
        assertEquals(x, y.left);
        assertEquals(x.right, b);
    }

    @Test
    public void checkHowLongisBeingInsertedElementAfterSettingEarlierNElements() throws IOException {
        Random random = new Random(System.currentTimeMillis());
        Workbook workbook = new XSSFWorkbook();
        Sheet excelSheet = workbook.createSheet("Results");
        int keyPickedByRandom;
        int constValueForTest = 1;
        long start, duration;
        for (int j = 0; j < 100; j++) {
            RBT<Integer, Integer> tree = new RBT<>();
            Row row = excelSheet.createRow(j);
            for (int i = 0; i < 1000; i++) {
                keyPickedByRandom = random.nextInt();
                start = System.nanoTime();
                tree.setValue(keyPickedByRandom, constValueForTest);
                duration = System.nanoTime() - start;
                row.createCell(i).setCellValue(duration);
            }
        }
        FileOutputStream fileOut = new FileOutputStream("Results.xlsx");
        try {
            workbook.write(fileOut);
        } catch (IOException e) {
            System.out.println("File error");
        }
        fileOut.close();
    }

    @Test
    public void isValueOverwriitenCorrectly() {
        tree.setValue("a", 25);
        tree.setValue("l", 128);
        tree.setValue("g", 543);
        tree.setValue("o", 37);
        tree.setValue("r", 259);
        tree.setValue("y", 43);
        tree.setValue("t", 25);
        tree.setValue("m", 20);

        tree.setValue("g", 278);
        assertEquals(278, (int) tree.getValue("g"));
    }

    @Test(expected = NoKeyInTreeException.class)
    public void isNoKeyInTreeExceptionThrownCorrectly() {
        tree.setValue("a", 129);
        tree.getValue("g");
    }
}