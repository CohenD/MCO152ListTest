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
    /////////////////////////////////////////////
    @Test
    public void testElementSpecifiedPosition(){
        list.add(3 ,"a");
        assertTrue(list.get(3).equals("a"));
    }
    /////////////////////////////////////////////
    @Test
    public void testCollectionSpecifiedPosition(){
        String[] collection = {"abc", "def"};

//        list.add(3 , collection);
        assertTrue(list.get(3).equals("a"));
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
    public void listEquals(){
        //Note this is deep because contents are String which are immutable
        LinkedList<String> list2 = (LinkedList<String>) list.clone();

        assertTrue(list2.equals(list));
    }
    @Test
    public void listNotEquals(){
        //Note this is deep because contents are String which are immutable
        LinkedList<String> list2 = (LinkedList<String>) list.clone();

        list2.set(0, "a");

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

    }
    //////////////////////////////////////////////
    @Test
    public void testRemoveFirstOccurrence(){
        list.remove("0");
        assertTrue(list.get(0).equals("1"));
    }
    /////////////////////////////////////////////
    @Test
    public void testReplaceAll(){
        list.replaceAll(s -> s + "00");
        assertTrue(list.get(3).equals("300"));
    }
    /////////////////////////////////////////////
    @Test
    public void testSet(){
        list.set(0, "abc");
        assertTrue(list.get(0).equals("abc"));
    }
    /////////////////////////////////////////////
    @Test
    public void testSort(){
//        list.sort((o1, o2) -> );
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
    public void testToArrayOfSpecifiedTypeInCorrectOrder(){

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