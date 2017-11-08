import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class MainTest {

    LinkedList<String> list;

    @org.junit.Before
    public void setUp() throws Exception {
         list = new LinkedList<>();
         for (int i = 0; i < 10; i++){
             list.add("" + i);
         }
    }

    @Test
    public void testElementSpecifiedPosition(){
        list.add(3 ,"a");
        assertTrue(list.get(3).equals("a"));
    }

    @Test
    public void testCollectionSpecifiedPosition(){
        String[] collection = {"abc", "def"};

//        list.add(3 , collection);
        assertTrue(list.get(3).equals("a"));
    }

    //////////////////////////////////////////////
    @Test
    public void testContainsElement(){
        assertTrue(list.contains("1"));
    }
    @Test
    public void testDoesntContaintElement(){
        assertFalse(list.contains("12"));
    }
    //////////////////////////////////////////////



}