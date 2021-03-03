import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
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
        this.list = new CircularListImpl(List.of(1,2,3));
    }

    private List<Integer> printList(CircularList cList, int nElements){
        List<Integer> retList = new ArrayList<>();

        for (int i : IntStream.range(0, nElements).toArray()){
            cList.next().ifPresent(val -> retList.add(val));
        }
        return  retList;
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

        assertEquals(targetList, printList(list, 4));
    }

    @Test
    void testPrevElement(){
        List<Integer> targetList = List.of(3,2,1,3);
        List<Integer> testList = new ArrayList<>();
        for (int i : IntStream.range(0, 4).toArray()){
            list.previous().ifPresent(val -> testList.add(val));
        }
        assertEquals(targetList, testList);
    }

    @Test
    void testReset(){
        list.next(); // 1
        list.next(); // 2
        list.reset();
        assertEquals(1, list.next().get());
    }

}
