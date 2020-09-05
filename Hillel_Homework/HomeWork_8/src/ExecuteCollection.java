import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class ExecuteCollection implements Col {

    public Object[] list;
    private int count;


    public ExecuteCollection() {
        this.list = new Object[10];
    }

    public void print() {
        if (count == 0) {
            System.out.println("Empty!!!");
        } else {
            for (int i = 0; i < list.length; i++) {
                if (list[i] == null) {
                    break;
                }
                System.out.print(list[i] + " ");
            }
        }
        System.out.println(" ");
    }

    private Object[] newlist(Object[] list) {
        if (Objects.isNull(list)) return null;
        Object[] newList = new Object[list.length + 1];
        int i = 0;
        for (Object s : list) {
            newList[i] = s;
            i++;
        }
        return newList;
    }

    @Override
    public boolean add(Object o) {
        if (count == list.length) {
            this.list = newlist(list);
            list[count++] = o;
        } else {
            list[count++] = o;
        }
        return true;
    }
        @Override
    public boolean add(int index, Object o) {
        if (index <= 0 || index > list.length || Objects.isNull(o)) return false;
        index--;
        if (list[index] == null) {
            add(o);
        } else {
                this.list = newlist(list);
                for (int j = count - 1; j >= index; j--) {
                    list[j + 1] = list[j];
                }
                list[index] = o;
                count++;
            }
        return true;
    }

    private Object[] copy(int index) {

        Object[] newstr = new Object[list.length - 1];
        System.arraycopy(list, 0, newstr, 0, index);

        System.arraycopy(list, index + 1, newstr, index, list.length - index - 1);
        list = newstr;
        return list;
    }

    public boolean delete(int index) {
        index--;
        if (index >= count || index < 0) return false;
        copy(index);
        count--;
        return true;
    }

    @Override
    public boolean delete(Object o) {
        if (o == null) return false;
        for (int i = 0; i < count; i++) {
            if (list[i].equals(o)) {
                i++;
                delete(i);
            }
        }
        return true;
    }

    @Override
    public Object get(int index) {
        index--;
        if (index >= count || index < 0)
            return "-1";
        return list[index];
    }

    @Override
    public boolean contain(Object o) {
        if (list.length == 0) return false;
        for (int i = 0; i < count; i++) {
            if (list[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Col str) {
        if (this == str) {
            return true;
        }
        if (this.size() != str.size()) {
            return false;
        }
        int i = 0, count1 = 0;
        while (i < this.size()) {
            if (this.list[i].equals(str.get(i + 1))) {
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
        if (list.length == 0) return true;

        list = null;
        count = 0;
        return true;
    }
    @Override
    public int size() {
        return count;
    }
}

