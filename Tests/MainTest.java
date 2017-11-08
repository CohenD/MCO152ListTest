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
    public void linkedList_addToEndOfListTest(){

        list.add("1");
        assertTrue(list.get(10).equals("1"));
    }

    @Test                   //addAll
    public void linkedList_addColletionToEndOfList_elementInPostionTest(){
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("100");
        list2.add("200");

        list.addAll(list2);
        System.out.println(list.size());
        assertTrue(list.get(10).equals("100"));
    }

    @Test                   //addAll
    public void linkedList_addColletionToEndOfList_noElementsDeletedTest(){
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("100");
        list2.add("200");

        list.addAll(list2);
        System.out.println(list.size());
        assertTrue(list.size() == 12);
    }



    @Test
    public void clearTest(){

        list.clear();
        assertTrue(list.size() == 0);
    }
}