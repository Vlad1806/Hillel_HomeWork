import java.util.Collection;

public interface CustomCollection {
    boolean add(String str);
    boolean addAll(String[] strArr);
    boolean addAll(Collection strColl);
    boolean delete (int index) throws Exception;
    boolean delete (String str) throws Exception;
    String get(int index) throws Exception;
    boolean contains(String str);
    boolean clear();
    int size();
    boolean trim() throws Exception;
    boolean compare(LinkedList coll) throws Exception;
}

