public class TextPost extends Post {

    private String message;

    //TextPost constructor
    public TextPost(String userName, String message) {
        super(userName);
        this.message = message;
    }

    public String getMessage() {
	     return message;
    }

    public String toString() {
    	String str = new String();
    	str = super.toString() + ", " + message;
    	return  str;
    }

    //Verify if TextPost is consider popular or not
  	public boolean isPopular() {
        if(likes>50){
            return true;
        }else {
            return false;
        }

  	}

}
