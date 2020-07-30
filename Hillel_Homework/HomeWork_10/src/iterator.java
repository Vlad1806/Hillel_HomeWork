import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class iterator<T> implements Iterator<T> {

    private T[] array;
    private int index = 0;

    public iterator(T[] array) {
        this.array = array;
    }


    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return array[index++];
    }

}