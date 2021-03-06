package lab01.tdd.strategies;

import lab01.tdd.SelectStrategy;

public class EvenStrategy implements SelectStrategy {
    @Override
    public boolean apply(int element) {
        return element % 2 == 0 ? true : false;
    }
}
