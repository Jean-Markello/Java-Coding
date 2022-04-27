import java.time.Year;

public class Book {

    private String title, author;
    private int year;

    public Book (String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean equals(Object other) {
        if ( !(other instanceof Book) ) {
            return false;
        }

        Book newOther = Book.class.cast(other);

        if (author==null && newOther.author==null) {
            return (title.equals(newOther.title) && year==newOther.year);
        }

        if (title == null && newOther.title == null) {
            return (author.equals(newOther.author) && year==newOther.year);
        }

        if ( (title == null || newOther.title == null || author == null || newOther.author == null) ) {
            return false;
        }

        return (author.equals(newOther.author) && title.equals(newOther.title) && year == newOther.year);

    }


    public String toString() {
        return "«"+author + ":" + title + "(" + year + ");";
    }
}
