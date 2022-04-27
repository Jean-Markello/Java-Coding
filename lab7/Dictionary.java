import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return elems.length;
    }

    public Dictionary() {
        this.elems=new Pair[INITIAL_CAPACITY];
    }

    @Override
    public void put(String key, Integer value) {

        if (key==null || value==null){
            throw new NullPointerException();
        }

        if(getCount()==getCapacity()) { increaseCapacity(); }
        elems[getCount()]= new Pair(key,value);
        count++;
    }

    private void increaseCapacity() {
        Pair[] elem_more_capacity= new Pair[getCapacity()+INCREMENT];
        for(int i=0; i<getCapacity();i++){
            elem_more_capacity[i]=elems[i];
        }
        this.elems=elem_more_capacity.clone();
    }

    @Override
    public boolean contains(String key) {
        if(key==null){
            throw new NullPointerException();
        }
        for(int i=0; i<getCount(); i++){
            if(elems[i].getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer get(String key) {
        if(!contains(key)){
            throw new NoSuchElementException();
        }
        for(int i=getCount()-1; i>=0; i--){
            if((elems[i].getKey()).equals(key)) {
                return elems[i].getValue();
            }
        } return -1;
    }

    @Override
    public void replace(String key, Integer value) {
        if (key==null || value == null){
            throw new NullPointerException();
        }
        if(!contains(key)){
            throw new NoSuchElementException();
        }
        if(contains(key)) {
            for(int i=getCount()-1; i>=0; i--){
                if((elems[i].getKey()).equals(key)) {
                    elems[i].setValue(value);
                    break;
                }
            }
        }
    }

    @Override
    public Integer remove(String key) {
        if(!contains(key)){ throw new NoSuchElementException();}

        int v_value=0;
        for(int i=getCount()-1; i>=0; i--){
            if((elems[i].getKey()).equals(key)) {
                v_value=+elems[i].getValue();
                elems[i]=elems[count-1];
                count--;
                break;
            }
        } return v_value;

    }

    @Override
    public String toString() {
        String res;
        res = "Dictionary: {elems = [";
        for (int i = count-1; i >= 0 ; i--) {
            res += elems[i];
            if(i > 0) {
                res += ", ";
            }
        }
        return res +"]}";
    }

}