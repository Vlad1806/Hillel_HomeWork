public class Collection implements CollectionDo{
    private String[] str = new String[10];

    public String getStr(int index) {
        return str[index - 1];
    }

    public int length(){
       return str.length;
    }

    public void print(){
        for (String i:str) {
            System.out.println(i);
        }
    }
    @Override
    public void add(String string) {
        String[] oldstr = new String[str.length];
        oldstr = str;
        for (int i = 0; i < oldstr.length; i++) {
            if (oldstr[i] == null) {
                oldstr[i] = string;
                break;
            }
        }
        str = oldstr;
    }

    @Override
    public void add(int index,String string) {

        index -= 1;
        String[] oldstr = new String[str.length];
        oldstr = str;
        String[] newstr = new String[oldstr.length + 1];
        if (oldstr[index] == null) {
            add(string);
        }
        else{
            for (int i = 0, j = 0;i < oldstr.length; i++,j++) {
                if(i == index){
                    newstr[i+1] = oldstr[index];
                    newstr[i] = string;
                    j++;
                }else{
                    newstr[j] = oldstr[i];
                }
            }
            str = newstr;
        }
    }

    @Override
    public void delete(String string) {
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == string){
                index = i;
                copy(index);
                i = 0;
            }
        }
    }
    private void copy(int index){
        String[] oldstr = new String[str.length];
        oldstr = str;
        String[] newstr = new String[oldstr.length - 1];
        System.arraycopy(oldstr, 0, newstr, 0, index);

        System.arraycopy(oldstr, index + 1, newstr, index, oldstr.length - index - 1);
        str = newstr;
    }

    @Override
    public void delete(int i) {
        copy(i - 1);
    }
}
