import java.io.IOException;

public class ExecuteCollection implements Collection{

    private Object[] List ;


    public ExecuteCollection() {
        this.List = new Object[10];
    }


    @Override
    public boolean add(Object o) {

        Object[] oldstr = new String[List.length];
        oldstr = List;
        for (int i = 0; i < oldstr.length; i++) {
            if (oldstr[i] == null) {
                oldstr[i] = o;
                break;
            }
        }
        List = oldstr;
        return true;
    }

    public void print() {
        if (List == null){
            System.out.println("NULL");
        }
        else {
            for (int i = 0; i < List.length; i++) {
                System.out.print(List[i] + " ");
            }
        }
    }
    @Override
    public boolean add(int index, Object o) {
        index -= 1;
        Object[] oldstr = new String[List.length];
        oldstr = List;

        if (index < 0 || index > oldstr.length) return false;

        Object[] newstr = new String[oldstr.length + 1];
        if (oldstr[index] == null) {
            add(o);
        }
        else {
            for (int i = 0, j = 0; i < oldstr.length; i++, j++) {
                if (i == index) {
                    newstr[i + 1] = oldstr[index];
                    newstr[i] = o;
                    j++;
                } else {
                    newstr[j] = oldstr[i];
                }
            }
            List = newstr;
        }
        return true;
    }


    private Object[] copy1(int index){
        Object[] oldstr = new String[List.length];
        oldstr = List;
        String[] newstr = new String[oldstr.length - 1];
        System.arraycopy(oldstr, 0, newstr, 0, index);

        System.arraycopy(oldstr, index + 1, newstr, index, oldstr.length - index - 1);
        List = newstr;
        return List;
    }

    public boolean delete(int index) {
        if (index> List.length || index < 0) return false;
            copy1(index);
            return true;
    }
    @Override
    public boolean delete(Object o) {
        if (o == null) return false;
        for (int i = 0; i < List.length; i++) {
            if (List[i].equals(o))
                delete(i);
        }
        return true;
    }

    @Override
    public Object get(int index) {
        if (index >= List.length || index < 0)
            return "-1";
        return List[index];
    }

    @Override
    public boolean contain(Object o) {
        if (List.length == 0) return false;
        for (int i = 0; i < List.length; i++) {
            if (List[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Collection str) {
        if (this == str) {
            return true;
        }

        if (this.size() != str.size()) {
            return false;
        }

        int i = 0, count1 = 0;

        while (i < this.size()) {
            if (this.List[i].equals(str.get(i))) {
                count1++;
            }
            i++;
        }

        if (count1 == this.size()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean clear() {
        if (List.length == 0) return true;
        for (int i = 0; i < List.length; i++) {
            List[i] = null;
        }
        return true;
    }

    @Override
    public int size() {
        return List.length;
    }
}
