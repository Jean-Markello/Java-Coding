import java.util.Calendar;
import java.util.Date;

public class Post implements Likeable, Comparable<Post> {

    protected int likes;
    private Date timeStamp;
    private String userName;

    //Post contructor
    public Post(String userName) {
        timeStamp=Calendar.getInstance().getTime();
        this.userName = userName;
    }

    public String getUserName() {
	     return userName;
    }

    public Date getTimeStamp() {
	     return timeStamp;
    }

    // Implement the methods required by the interface Likeable.
    // This file will not compile unless they are present with the correct name and signature.

    public String toString() {
    	String str = new String();
    	str = getClass().getName() + ": " + timeStamp + ", " + userName + ", likes = " + likes;
    	return  str;
    }

    //this method compare two Post to determine who's the oldest and the newest post.
  	public int compareTo(Post other){
  		if(timeStamp.compareTo(other.timeStamp)>0) {
            return 1;
        } else if(timeStamp.compareTo(other.timeStamp)<0) {
              return -1;
        } else {
              return 0;
        }
  	}

    //Verify if Post is consider popular or not
  	public boolean isPopular(){
        if(likes>100){
            return true;
        }else{
            return false;
        }
  	}

    //Likable method
    @Override
    public void like() {
        likes++;
    }

    @Override
    public int getLikes() {
        return likes;
    }
}
