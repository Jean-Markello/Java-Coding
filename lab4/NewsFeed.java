/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

	//create a Post array, with a size of 25
    public NewsFeed() {
		messages=new Post[MAX_SIZE];
    }

	//add the first 25 Post
    public void add(Post message) {
		if(size<MAX_SIZE){
			messages[size]=message;
			size++;
		}
    }

    public Post get(int index) {
	     return messages[index];
    }

	//return size
    public int size() {
	     return size;
    }

	  public void sort(){
			int i, j, argMin;
			Post tmp;
			for (i = 0; i < size - 1; i++) {
				argMin = i;
				for (j = i + 1; j < size(); j++) {
					if (messages[j].compareTo(messages[argMin]) < 0) {
						argMin = j;
					}
				}

  			tmp = messages[argMin];
  			messages[argMin] = messages[i];
  			messages[i] = tmp;
		  }

	  }

	//create a Newsfeed object which contain Saved PhotoPost
  	public NewsFeed getPhotoPost(){
		NewsFeed photoPostSaved=new NewsFeed();
		for(int i = 0; i < size(); i++) {
			if (get(i) instanceof PhotoPost){
				photoPostSaved.add(get(i));
			}
		}
		return photoPostSaved;
  	}

	//Create a Newsfeed obj which contain the added Post of two other Newsfeed obj.
	//then the method call sort() in order to put the Post from latest to newest
  	public NewsFeed plus(NewsFeed other) {
		NewsFeed combined = new NewsFeed();
		for (int i=0; i<messages.length; i++){
			if (get(i)!=null) {
				combined.add(get(i));
			}
		}
		for (int a=0; a<other.messages.length; a++){
			if (other.get(a)!=null) {
				combined.add(other.get(a));
			}
		}
		combined.sort();
		return combined;

	}
}
