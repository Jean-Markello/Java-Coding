import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        if(o1.getAuthor().compareTo(o2.getAuthor())==0){
            if(o1.getTitle().compareTo(o2.getTitle())==0){
                return Integer.valueOf(o1.getYear()).compareTo(Integer.valueOf(o2.getYear()));
            }else {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        }else{
            return o1.getAuthor().compareTo(o2.getAuthor());
        }
    }

}