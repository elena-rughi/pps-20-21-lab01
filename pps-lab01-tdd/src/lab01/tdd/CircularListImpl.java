package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList{

    private List<Integer> list;

    public CircularListImpl(){
        list = new ArrayList<>();
    }

    public CircularListImpl(List<Integer> list) {
        this.list = new ArrayList<>(list);
    }

    @Override
    public void add(int element) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Optional<Integer> next() {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.empty();
    }

    @Override
    public void reset() {

    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
