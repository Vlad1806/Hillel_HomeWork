
public class ExecuteCollection implements Col {

    private Object[] list;
    private int count;


    public ExecuteCollection() {
        this.list = new Object[10];
    }

    public void print() {
        if (count == 0){
            System.out.println("Empty!!!");
        }
        else {
            for (int i = 0; i < count; i++) {
                if (list[i] == null){
                    break;
                }
                System.out.print(list[i] + " ");
            }
        }
        System.out.println(" ");
    }

    private Object[] newlist(Object[] list) {
        if (list == null)
            return null;
        Object[] newList = new Object[list.length * 3 / 2 + 1];
        int i = 0;
        for (Object s : list) {
            newList[i] = s;
            i++;
        }
        return newList;
    }

    public boolean add(Object o) {

        if (count == list.length){
            this.list = newlist(list);
            list[count++] = o;
        }
        else {
            list[count++] = o;
        }
        return true;
    }

    public boolean add(int index, Object o) {
        index--;
        Object[] oldstr = new String[list.length];
        oldstr = list;

        if (index < 0 || index > oldstr.length) return false;

        Object[] newstr = new String[oldstr.length + 1];
        if (oldstr[index] == null) {
            add(o);
        }
        else {
            for (int i = 0, j = 0; i < count; i++, j++) {
                if (i == index) {
                    newstr[i + 1] = oldstr[index];
                    newstr[i] = o;
                    j++;
                } else {
                    newstr[j] = oldstr[i];
                }
            }
            list = newstr;
        }
        return true;
    }


    private Object[] copy1(int index){
        if (index == 0) {
            index = 0;
        }else{
            index--;
        }
        Object[] oldstr = new String[list.length];
        oldstr = list;
        String[] newstr = new String[oldstr.length - 1];
        System.arraycopy(oldstr, 0, newstr, 0, index);

        System.arraycopy(oldstr, index + 1, newstr, index, oldstr.length - index - 1);
        list = newstr;
        return list;
    }

    public boolean delete(int index) {
        if (index > count || index < 0) return false;
        copy1(index);
        count--;
        return true;
    }

    public boolean delete(Object o) {
        if (o == null) return false;
        int temp = count;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) break;
            if (list[i].equals(o))
                delete(i);
        }
        return count < temp;
    }


    public Object get(int index) {
        if (index >= list.length || index < 0)
            return "-1";
        return list[index];
    }


    public boolean contain(Object o) {
        if (list.length == 0) return false;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) return false;
            if (list[i].equals(o)) {
                return true;
            }
        }
        return false;
    }


    public boolean equals(Col str) {
        if (this == str) {
            return true;
        }

        if (this.size() != str.size()) {
            return false;
        }

        int i = 0, count1 = 0;

        while (i < this.size()) {
            //if (this.list == null)return false;
            if (this.list[i].equals(str.get(i))) {
                count1++;
            }
            i++;
        }

        if (count1 == this.size()) {
            return true;
        }
        return false;
    }

    public boolean clear() {
        if (count == 0 && list == null) return false;
        list = null;
        count = 0;
        return true;
    }

    public int size() {
        return count;
    }
}

