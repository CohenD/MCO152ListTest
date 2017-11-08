import org.junit.Test;

import java.util.Collections;
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
    public void linkedList_addToEndOfList_Test(){

        list.add("1");
        assertTrue(list.get(10).equals("1"));
    }

    @Test //
    public void linkedList_addColletionToEndOfList_elementInPostion_Test(){
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("100");
        list2.add("200");

        list.addAll(list2);
        System.out.println(list.size());
        assertTrue(list.get(10).equals("100"));
    }

    @Test //
    public void linkedList_addColletionToEndOfList_noPriorElementsDeleted_Test(){
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("100");
        list2.add("200");

        list.addAll(list2);
        System.out.println(list.size());
        assertTrue(list.size() == 12);
    }



    @Test //
    public void linkedList_clearWorks_Test(){
        list.clear();
        assertTrue(list.size() == 0);
    }

    @Test  //
    public void linkedList_containsAll_whenTrue_Test(){
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("100");
        list2.add("200");

        list.addAll(list2);

        assertTrue(list.containsAll(list2));
    }

    @Test //
    public void linkedList_containsAll_whenFalse_Test(){
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("100");
        list2.add("200");

        list.add(list2.get(1));

        assertFalse(list.containsAll(list2));
    }

    @Test //
    public void linkedList_get_WhenInBounds_Test(){
        assertTrue(list.get(1).equals("1"));
    }

    @Test (expected = IndexOutOfBoundsException.class)//
    public void linkedList_get_RealizeOutOfBoundsTest(){
        list.get(list.size() + 1);
    }

    @Test //
    public void linkedList_indexOf_whenInList_Test(){
        assertEquals(list.indexOf("9"), 9);
    }

    @Test //
    public void linkedList_indexOf_whenNotInList_Test(){
        assertEquals(list.indexOf("1_000"), -1);
    }

    @Test //????????????????????????????????????????????
    public void linkedList_Iterator_properSequence_Test(){

    }

    @Test //????????????????????????????????????????????
    public void linkedList_listIterator_properSequence_Test(){

    }

    @Test //
    public void linkedList_remove_whenInBounds_Test(){
        assertEquals(list.remove(0), "0");
    }

    @Test (expected = IndexOutOfBoundsException.class)//
    public void linkedList_remove_whenOutOfBounds_Test(){
        list.remove(list.size() + 1);
    }

    @Test //
    public void linkedList_removeAll_Normal_Test(){
        LinkedList<String> list2 = new LinkedList<>();
        for (int i = 0; i < 10; i++){
            list2.add("" + i);
        }
        list.removeAll(list2);
        assertTrue(list.size() == 0);
    }

    @Test  //???????????????????????????????????? (expected = NullPointerException.class)
    public void linkedList_removeAll_WhenNull_Test(){

    }

    @Test
    public void linkedList_size_worksCorrect_Test(){
        assertTrue(list.size() == 10);
    }

    @Test
    public void linkedlist_size_wontShowWrongResults_Test(){
        assertFalse(list.size() == 1_000);
    }

//    @Test //
//    public void linkedList_Test(){
//
//    }
}