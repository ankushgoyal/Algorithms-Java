package datastrs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Adding some functionality I like to use, but are missing from
 * ArrayList implementation.
 * @author agoyal
 *
 * @param <E>
 */
public class ArrayListOnSteroids<E> extends ArrayList<E> implements List<E>{
    
    private static final long serialVersionUID = 1L;
    
    public ArrayListOnSteroids() {
        super();
    }
    
    /**
     * Copy Constructor
     * @param c
     */
    public ArrayListOnSteroids(Collection<? extends E> c) {
        super(c);
    }
    
    public ArrayListOnSteroids<E> addItem(E item) {
        add(item);
        return this;
    }
    
    public ArrayListOnSteroids<E> addItems(Collection<? extends E> c) {
        addAll(c);
        return this;
    }

    public ArrayListOnSteroids<E> and(E item) {
        add(item);
        return this;
    }
    
    public ArrayListOnSteroids<E> removeItem(E item) {
        remove(item);
        return this;
    }
}
