import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class MainTest {

    LinkedList<String> list;

    @org.junit.Before
    public void setUp() throws Exception {
         list = new LinkedList<>();
         for (int i = 0; i < 10; i++){
             list.add(" " + i);
         }
    }


    @Test
    public void addToEndOfListTest(){
        list.add("a");
        assertTrue(list.size() == 1);
    }

}