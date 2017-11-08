import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

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
            //how do you get a null collection
    }

    @Test //
    public void linkedList_size_worksCorrect_Test(){
        assertTrue(list.size() == 10);
    }

    @Test //
    public void linkedlist_size_wontShowWrongResults_Test(){
        assertFalse(list.size() == 1_000);
    }

    @Test //
    public void linkedList_retainAll_removeLastElt_sizeIsCorrect_Test(){
        LinkedList<String> list2 = new LinkedList<>();
        for (int i = 0; i < 9; i++){
            list2.add("" + i);
        }

        list.retainAll(list2);
        assertTrue(list.size() == 9);
    }

    @Test //
    public void linkedList_retainAll_removeLastElt_makeSureEltIsRemoved_Test(){
        LinkedList<String> list2 = new LinkedList<>();
        for (int i = 0; i < 9; i++){
            list2.add("" + i);
        }

        list.retainAll(list2);
        assertFalse(list.contains("9"));
    }

    @Test  //???????????????????????????????????? (expected = NullPointerException.class)
    public void linkedList_retainAll_WhenNull_Test(){
        //how do you get a null collection
    }

    @Test //??????????????????????????????????????
    public void linkedList_Spliterator_Test(){

    }

    //The reason I'm testing for Object[] and NOT String[] is b/c at runtime
    //this is treated as an Object array, but it does prove that it IS an Array
    @Test
    public void linkedList_toArray_Test() {
        assertTrue(list.toArray() instanceof Object[]);
    }



    @Test
    public void testElementSpecifiedPosition(){
        list.add(3 ,"a");
        assertTrue(list.get(3).equals("a"));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testElementSpecifiedPositionOutOfBounds(){
        list.add(11, "abc");
    }

    /////////////////////////////////////////////
    @Test
    public void testCollectionSpecifiedPosition(){
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("ABC");
        list2.add("DEF");

        list.addAll(4, list2);
        assertTrue(list.get(5).equals("DEF"));
    }
    @Test
    public void testCollectionSpecifiedPositionSize(){
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("ABC");
        list2.add("DEF");

        list.addAll(4, list2);
        assertTrue(list.size() == 12);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testCollectionSpecifiedPositionOutOfBounds(){
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("ABC", "DEF"));

        list.addAll(15, list2);
    }
    /////////////////////////////////////////////
    @Test
    public void testContainsElement(){
        assertTrue(list.contains("1"));
    }
    @Test
    public void testDoesntContaintElement(){
        assertFalse(list.contains("12"));
    }
    /////////////////////////////////////////////
    @Test
    public void testListEquals(){
        //Note this is deep because contents are String which are immutable
        LinkedList<String> list2 = (LinkedList<String>) list.clone();

        assertTrue(list2.equals(list));
    }
    @Test
    public void testListNotEquals(){
        //Note this is deep because contents are String which are immutable
        LinkedList<String> list2 = (LinkedList<String>) list.clone();

        list2.set(4, "a");

        assertFalse(list2.equals(list));
    }
    @Test
    public void testHalfListNotEquals(){
        //Note this is deep because contents are String which are immutable
        LinkedList<String> list2 = (LinkedList<String>) list.subList(0,5);

        assertFalse(list2.equals(list));
    }
    /////////////////////////////////////////////
    //test hashCode()????
    ////////////////////////////////////////////
    @Test
    public void testIsEmpty(){
        list = new LinkedList<>();
        assertTrue(list.isEmpty());
    }
    @Test
    public void testIsEmptyOnFullList(){
        assertFalse(list.isEmpty());
    }
    /////////////////////////////////////////////
    @Test
    public void testLastIndexAtEnd(){
        list.set(list.size() -1, "abcd");
        assertTrue(list.lastIndexOf("abcd") == list.size() - 1);
    }
    @Test
    public void testLastIndexAtMiddle(){
        list.set(5, "abcd");
        assertTrue(list.lastIndexOf("abcd") == 5);
    }
    @Test
    public void testLastIndexAtBegining(){
        list.set(0, "abcd");
        assertTrue(list.lastIndexOf("abcd") == 0);
    }
    ///////////////////////////////////////////////
    @Test
    public void testListIterator(){
        ListIterator<String> stringListIterator = list.listIterator(5);
        assertTrue(stringListIterator.next().equals("5"));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListIteratorOutOfBounds(){
        ListIterator<String> stringListIterator = list.listIterator(14);
        assertTrue(stringListIterator.next().equals("5"));
    }
    //////////////////////////////////////////////
    @Test
    public void testRemoveFirstOccurrence(){
        list.remove("0");
        assertTrue(list.get(0).equals("1"));
    }
    @Test
    public void testRemoveFirstOccurrenceMiddle(){
        list.remove("5");
        assertTrue(list.get(5).equals("6"));
    }
    /////////////////////////////////////////////
    @Test
    public void testReplaceAll(){
        boolean flag = true;
        list.replaceAll(s -> s + "00");
        for (String s: list) {
            if (!s.contains("00")){
                flag = false;
            }
        }
        assertTrue(flag);
    }
    /////////////////////////////////////////////
    @Test
    public void testSet(){
        list.set(7, "abc");
        assertTrue(list.get(7).equals("abc"));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetOutOfBounds(){
        list.set(11, "abc");
    }
    /////////////////////////////////////////////
    @Test
    public void testSort(){
        Collections.shuffle(list);

        list.sort((o1, o2) -> o1.charAt(0) - o2.charAt(0));

        boolean flag = true;

        for (int i = 0; i < list.size(); i++){
            if (!list.get(i).equals("" + i)){
                flag = false;
            }
        }
        assertTrue(flag);
    }

    /////////////////////////////////////////////
    @Test
    public void testSubList(){
        LinkedList<String> sub = new LinkedList<>();
        sub.addAll(list.subList(0, 5));

        LinkedList<String> newList = new LinkedList<>();
        for (int i = 0; i < 5; i++){
            newList.add("" + i);
        }

        assertTrue(sub.equals(newList));
    }
    /////////////////////////////////////////////
    @Test
    public void testToArrayOfSpecifiedType(){
        assertTrue(list.toArray(new String[list.size()]) instanceof String[]);
    }
    @Test
    public void testToArrayOfSpecifiedTypeIsCorrectOrder(){

        String[] array = list.toArray(new String[list.size()]);
        boolean flag = true;

        for (int i = 0; i < list.size(); i++){
            if (!list.get(i).equals(array[i])){
                flag = false;
            }
        }
        assertTrue(flag);
    }
}