import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.*;

public class ExecuteCollectionTest{

    ExecuteCollection collection;
    @BeforeClass
    public static void start() {
        System.out.println("------");
        System.out.println("START!");
        System.out.println("------");
    }
    @AfterAll
    public static void finish() {
        System.out.println("-------------");
        System.out.println("SUCCESSFULLY!");
        System.out.println("-------------");
    }

    @BeforeEach
    public void printInfo() {
        System.out.println("-----test-----");
        collection = new ExecuteCollection();
        collection.add("a");
        collection.add("b");
        collection.add("c");
        collection.add("d");
        collection.add("e");
    }



    @RepeatedTest(2)
    public void addTest() {
        System.out.println("Add-----");
        Assertions.assertTrue(collection.add("78"));
        Assertions.assertTrue(collection.add(5, "990"));
    }
    @RepeatedTest(2)
    public void addIndex() {
        System.out.println("AddIndexTest-----");
        Assertions.assertFalse(collection.add(-2, "1"));
        Assertions.assertTrue(collection.add(2, "2"));
    }
    @RepeatedTest(2)
    public void DeleteIndex(){
        System.out.println("deleteIndexTest-----");
        Assertions.assertTrue(collection.delete(5));
        Assertions.assertFalse(collection.delete(-5));
        Assertions.assertFalse(collection.delete(200));

    }

    @RepeatedTest(2)
    public void DeleteObject(){
        System.out.println("deleteIndexTest-----");
        Assertions.assertTrue(collection.delete("a"));
        Assertions.assertFalse(collection.delete(null));
        Assertions.assertFalse(collection.delete("D"));

    }

    @RepeatedTest(2)
    public void sizeTest(){
        System.out.println("Size test-----");
        Assertions.assertEquals(5,collection.size());
        collection.delete(1);
        Assertions.assertEquals(4,collection.size());
        Assertions.assertNotEquals(5,collection.size());
    }

    @RepeatedTest(2)
    public void GetTest() {
        System.out.println("GetTest------");
        Assertions.assertEquals("-1",collection.get(-2));
        Assertions.assertEquals("-1",collection.get(11));
        Assertions.assertEquals("b",collection.get(1));
        Assertions.assertEquals(null,collection.get(8));
    }

    @RepeatedTest(2)
    public void ContainTest(){
        System.out.println("ContainTest------");
        Assertions.assertTrue(collection.contain("a"));
        Assertions.assertTrue(collection.contain("b"));
        Assertions.assertFalse(collection.contain("k"));
        Assertions.assertFalse(collection.contain("D"));
    }

    @RepeatedTest(2)
    public void EqualsTest(){
        System.out.println("EqualsTest----");
        ExecuteCollection test = new ExecuteCollection();
        Assertions.assertTrue(collection.equals(collection));
        Assertions.assertFalse(collection.equals(test));
        test.add("a");
        test.add("b");
        test.add("c");
        test.add("d");
        test.add("e");
        Assertions.assertTrue(collection.equals(test));
        test.delete("b");
        Assertions.assertFalse(collection.equals(test));
    }

    @RepeatedTest(2)
    public void ClearTest(){
        Assertions.assertTrue(collection.clear());
        Assertions.assertFalse(collection.clear());
        Assertions.assertEquals(0,collection.size());
    }
}
