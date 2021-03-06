import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import lab01.tdd.strategies.EvenStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    @BeforeEach
    void beforeEach(){
        list = new CircularListImpl(List.of(1,2,3));
    }

    @Test
    void testAddition(){
        list.add(4);
        assertEquals(List.of(1,2,3,4), printList(list, list.size()));
    }

    @Test
    void testSize(){
        assertEquals(3, list.size());
    }

    @Test
    void testEmptyList(){
        assertFalse(list.isEmpty());
    }

    @Test
    void testNextElement(){
        List<Integer> targetList = List.of(1,2,3,1);

        assertEquals(targetList, printList(list, targetList.size()));
    }

    @Test
    void testPrevElement(){
        List<Integer> targetList = List.of(3,2,1,3);
        List<Integer> testList = new ArrayList<>();

       IntStream.range(0, 4).forEach( i ->
            list.previous().ifPresent(val -> testList.add(val)));

        assertEquals(targetList, testList);
    }

    @Test
    void testReset(){
        list.next(); // 1
        list.next(); // 2
        list.reset();
        assertEquals(1, list.next().get());
    }

    @Test
    void testNextWithEvenStrategy(){
        CircularList sList = new CircularListImpl(List.of(1,2,6,7,8,3,4,5,9));

        List<Integer> targetList = List.of(2,6,8,4,2,6);
        List<Integer> testList = new ArrayList<>();

        IntStream.range(0, targetList.size()).forEach( i ->
                sList.next(new EvenStrategy()).ifPresent(val -> testList.add(val)));

        assertEquals(targetList, testList);
    }


    // return circular list iterated with next() method n times
    private List<Integer> printList(CircularList cList, int n){
        List<Integer> retList = new ArrayList<>();

        IntStream.range(0, n).forEach( i ->
                cList.next().ifPresent(val -> retList.add(val)));

        return  retList;
    }

}
