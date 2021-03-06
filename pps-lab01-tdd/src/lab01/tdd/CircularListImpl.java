package lab01.tdd;

import java.util.*;

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
        list.add(element);
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
        if (list.isEmpty()){
            return Optional.empty();
        }
        Integer result = list.get(index);
        updateIndex();
        return Optional.of(result);
    }

    @Override
    public Optional<Integer> previous() {
        Integer result = list.get(size() - 1 - index);
        updateIndex();
        return Optional.of(result);
    }

    @Override
    public void reset() {
        index = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        Optional<Integer> result;
        boolean isNext;

        do {
            result = next();
            if (result.isEmpty()) return Optional.empty();
        } while (!strategy.apply(result.get()));

        return result;
    }

    private void updateIndex(){
        index = (index + 1) % size();
    }
}
