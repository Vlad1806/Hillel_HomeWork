public interface Col {
    public boolean add(Object o);
    public boolean add(int index, Object o);
    public boolean delete (Object o);
    public Object get(int index);
    public boolean contain(Object o);
    public boolean equals (Col str);
    public boolean clear();
    public int size();
}
