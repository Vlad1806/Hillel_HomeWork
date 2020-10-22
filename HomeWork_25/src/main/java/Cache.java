import java.util.Objects;

public class Cache {
    final private int lifeTime;
    final private int size;
    private LRUMap<Integer, Object> objects;

    public Cache(int lifeTime, int size) {
        this.lifeTime = lifeTime;
        this.size = size;
        this.objects = new LRUMap<>(this.size);
        clear();
    }

    public Object getAll(){
        return objects.values();
    }

    public Object get(Object obj) {
        return objects.get(obj);
    }

    public void put(Object obj) {
        objects.put(obj.hashCode(), obj);
    }

    public synchronized void clear(){
        new Thread(() -> {
            try {
                Thread.sleep(lifeTime * 1000);
            } catch (InterruptedException ex) {
            }
            objects.clear();
        }).start();
    }
}
