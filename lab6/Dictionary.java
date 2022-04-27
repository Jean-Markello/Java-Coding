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
        for(int i=0; i<getCount(); i++){
            if(elems[i].getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer get(String key) {
       for(int i=getCount()-1; i>=0; i--){
           if((elems[i].getKey()).equals(key)) {
               return elems[i].getValue();
           }
       } return -1;
    }

    @Override
    public void replace(String key, Integer value) {
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
        int v_value=0;
        for(int i=getCount()-1; i>=0; i--){
            if((elems[i].getKey()).equals(key)) {
                v_value=+elems[i].getValue();
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