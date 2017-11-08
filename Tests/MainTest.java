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


    @Test //
    public void linkedList_addToEndOfListTest(){

        list.add("1");
        assertTrue(list.get(10).equals("1"));
    }

    @Test //
    public void linkedList_addColletionToEndOfList_elementInPostionTest(){
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("100");
        list2.add("200");

        list.addAll(list2);
        System.out.println(list.size());
        assertTrue(list.get(10).equals("100"));
    }

    @Test //
    public void linkedList_addColletionToEndOfList_noPriorElementsDeletedTest(){
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("100");
        list2.add("200");

        list.addAll(list2);
        System.out.println(list.size());
        assertTrue(list.size() == 12);
    }



    @Test //
    public void linkedList_clearTest(){
        list.clear();
        assertTrue(list.size() == 0);
    }

    @Test  //
    public void linkedList_containsAll_whenTrueTest(){
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("100");
        list2.add("200");

        list.addAll(list2);

        assertTrue(list.containsAll(list2));
    }

    @Test //
    public void linkedList_containsAll_whenFalseTest(){
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("100");
        list2.add("200");

        list.add(list2.get(1));

        assertFalse(list.containsAll(list2));
    }

        @Test //
    public void linkedList_get_WorksNormalTest(){
        assertTrue(list.get(1).equals("1"));
    }

        @Test (expected = IndexOutOfBoundsException.class)//
    public void linkedList_get_RealizeOutOfBoundsTest(){
        list.get(11);
    }

//    @Test //
//    public void linkedList_Test(){
//
//    }
}