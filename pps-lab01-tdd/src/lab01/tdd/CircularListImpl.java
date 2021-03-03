package lab01.tdd;

import java.util.*;
import java.util.stream.Stream;

public class CircularListImpl implements CircularList{

    private List<Integer> list;
    private int index = 0;

    public CircularListImpl(){
        list = new ArrayList<>();
    }

    public CircularListImpl(List<Integer> list) {
        this.list = new ArrayList<>(list);
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        Integer result = list.get(index);
        index = (index + 1) % size();

        return Optional.of(result);
    }

    @Override
    public Optional<Integer> previous() {
        Integer result = list.get(size() - 1 - index);
        index = (index + 1) % size();

        return Optional.of(result);
    }

    @Override
    public void reset() {
        this.index = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
