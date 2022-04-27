public class QueueUtils {

  public static Queue merge(Queue [] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException();
    }
    // votre code va ici
    Queue<String> queue0 = new LinkedQueue<String>();
    int n=array.length;
    while(n>0){
      for(int i = 0; i < array.length; i++) {
        if (!array[i].isEmpty()) {
          queue0.enqueue((String) array[i].dequeue());
        }else{
          n--;
        }
      }
    }
    return queue0;
  }
}
