package util_structures;

public class MyPair<T, U> {

    private final T first;
    private U second;

    public MyPair() {
        this.first = null;
        this.second = null;
    }
    public MyPair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }
}