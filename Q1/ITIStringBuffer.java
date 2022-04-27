public class ITIStringBuffer {
    private SinglyLinkedList<String> array;
    boolean call_append;
    String print;

    public ITIStringBuffer() {
        array = new SinglyLinkedList<String>();
        call_append = false;
        print="";
    }

    public ITIStringBuffer(String  firstString){
        array = new SinglyLinkedList<String>();
        array.add(firstString);
        call_append = false;
        print="";
    }

    public void append(String nextString){
        array.add( nextString );
        call_append = true;
    }

    public String toString(){
        if(call_append){
            call_append = false;
            print= array.toString();
            return print;
        } else {
            return print;
        }
    }

}
