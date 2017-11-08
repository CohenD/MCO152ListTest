import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class MainTest {

    LinkedList<String> list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList<String>();
    }

    @Test
    public void addToPosition(){
        list.add("");
    }

}