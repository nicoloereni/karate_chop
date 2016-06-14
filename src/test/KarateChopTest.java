package test;

import main.KarateChop;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KarateChopTest {

    private KarateChop karateChop;

    @Before
    public void setUp() throws Exception {

        karateChop = new KarateChop();

    }

    @Test
    public void karateChopTests(){
        assertEquals( new Integer(-1), karateChop.chop(3, new Integer []{}));
        assertEquals( new Integer(-1), karateChop.chop(3, new Integer []{1}));
        assertEquals( new Integer(0),  karateChop.chop(1, new Integer []{1}));
        assertEquals( new Integer(0),  karateChop.chop(1, new Integer []{1, 3, 5}));
        assertEquals( new Integer(1),  karateChop.chop(3, new Integer []{1, 3, 5}));
        assertEquals( new Integer(2),  karateChop.chop(5, new Integer []{1, 3, 5}));
        assertEquals( new Integer(-1), karateChop.chop(0, new Integer []{1, 3, 5}));
        assertEquals( new Integer(-1), karateChop.chop(2, new Integer []{1, 3, 5}));
        assertEquals( new Integer(-1), karateChop.chop(4, new Integer []{1, 3, 5}));
        assertEquals( new Integer(-1), karateChop.chop(6, new Integer []{1, 3, 5}));
        assertEquals( new Integer(0),  karateChop.chop(1, new Integer []{1, 3, 5, 7}));
        assertEquals( new Integer(1),  karateChop.chop(3, new Integer []{1, 3, 5, 7}));
        assertEquals( new Integer(2),  karateChop.chop(5, new Integer []{1, 3, 5, 7}));
        assertEquals( new Integer(3),  karateChop.chop(7, new Integer []{1, 3, 5, 7}));
        assertEquals( new Integer(-1), karateChop.chop(0, new Integer []{1, 3, 5, 7}));
        assertEquals( new Integer(-1), karateChop.chop(2, new Integer []{1, 3, 5, 7}));
        assertEquals( new Integer(-1), karateChop.chop(4, new Integer []{1, 3, 5, 7}));
        assertEquals( new Integer(-1), karateChop.chop(6, new Integer []{1, 3, 5, 7}));
        assertEquals( new Integer(-1), karateChop.chop(8, new Integer []{1, 3, 5, 7}));
    }

    

}
