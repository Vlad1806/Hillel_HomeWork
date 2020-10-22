import java.util.Collection;
import java.util.Iterator;

class Link<T>{
    public T dData;
    public Link next;

    public Link(T d) {
        dData = d;
    }

    public void displayLink(){
        System.out.print(dData + " ");
    }

    public T getdData() {
        return dData;
    }

    public void setdData(T dData) {
        this.dData = dData;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}

public class LinkedList<T>implements CustomCollection{
   private Link<T> first;
   private Link<T> last;
   private int count;

    public LinkedList() {
        first = null;
        last = null;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void displayList()
    {
        System.out.print("List -->: ");
        Link current = first;
        while(current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
    @Override
    public boolean add(String str) {
        Link newLink = new Link(str);
        if( isEmpty() )
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
        count++;
        return true;
    }
    @Override
    public boolean addAll(String[] strArr) {
        if (strArr == null) {
            return false;
        } else {
            for (int i = 0; i < strArr.length; i++) {
                add(strArr[i]);
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection strColl) {
        if (strColl == null) {
            return false;
        } else {
            Iterator iterator = strColl.iterator();
            while (iterator.hasNext()) {
                add((String) iterator.next());
            }
            return true;
        }
    }

    private Link getNodeAt(int index) throws Exception {

        if (count == 0) {
            throw new Exception("LL is Empty.");
        }

        if (index < 0 || index >= count) {
            throw new Exception("Invalid Index.");
        }

        Link temp = this.first;

        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }

        return temp;

    }

    private boolean removeFirst() throws Exception {

        if (count== 0) {
            throw new Exception("LL is empty.");
        }

        Link temp = this.first;

        if (count == 1) {
            this.first = null;
            this.last = null;
            count = 0;
        } else {
            this.first = this.last.next;
            count--;
        }
        return true;
    }

    private boolean removeLast() throws Exception {

        if (count == 0) {
            throw new Exception("LL is empty.");
        }

        Link temp = this.last;

        if (count == 1) {
            this.first = null;
            this.last = null;
            count = 0;
        } else {
            Link sm2 = getNodeAt(count - 2);
            sm2.next = null;
            this.last = sm2;
            count--;
        }
        return true;
    }
    @Override
    public boolean delete(int index) throws Exception {

        if (count == 0) {
            throw new Exception("LL is empty.");
        }

        if (index < 0 || index >= count) {
            throw new Exception("Invalid Index.");
        }

        if (index == 0) {
            return (boolean) removeFirst();
        } else if (index == count - 1) {
            return removeLast();

        } else {

            Link nm1 = getNodeAt(index - 1);
            Link n = nm1.next;

            Link np1 = n.next;

            nm1.next = np1;
            count--;
        }
        return false;
    }

    @Override
    public boolean delete(String str) throws Exception {
        Link current = first;
        int i = 0;
        while(current != null && current.next != null) {
            if (current.dData == str){
            delete(i);
            }
            i++;
            current = current.next;
        }
        return true;
    }

    @Override
    public String get(int index) throws Exception {
        if (count == 0) {
            throw new Exception("LL is Empty.");
        }

        if (index < 0 || index >= count) {
            throw new Exception("Invalid Index.");
        }

        Link temp = this.first;

        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }

        return (String) temp.dData;

    }

    @Override
    public boolean contains(String str) {
        Link current = first;
        do {
            if ((current.getdData().equals(str))) {
                return true;
            }
            current = current.getNext();
        } while (current != null);
        return false;
    }

    @Override
    public boolean clear() {
        if (count == 0)
            return false;
        for (Link node = first; node != null; ) {

            Link next = node.getNext();
            node.setNext(null);
            node = next;
        }
        first = last = null;
        count = 0;
        return true;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean trim() throws Exception {
        if (isEmpty()) return false;
        int counter = 0;
        int counter2 = 0;
        Link currentNode = first;
        while (currentNode != null) {
            if (currentNode.getdData() == null) {
                Link next = currentNode.getNext();
                delete(counter2);
                counter++;
                currentNode = next;
                continue;
            }
            currentNode = currentNode.getNext();
            counter2++;
        }
        return counter > 0;
    }

    @Override
    public boolean compare(LinkedList coll) throws Exception {
        if (this == coll) {
            return true;
        }

        if (coll == null || this.count != coll.count) return false;

        int counter = 0;
        for (int i = 0; i < count; i++) {
            if (this.get(i).equals(coll.get(i)))
                counter++;
        }
        return count == counter;
    }
}
