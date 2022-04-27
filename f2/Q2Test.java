public class Q2Test {
        private static String toString(Queue<String> q)
        {
           String result = "Front -> [";
           while(q != null && !q.isEmpty()){
             Object i = q.dequeue();
             String p = (String)i;
             result += p + ", ";
           }
           result = result + "] <- Rear";

           return result;
        }

	public static void main(String[] args) {
           Queue<String> queue0 = new LinkedQueue<String>();
           queue0.enqueue("A1");
           queue0.enqueue("A2");
           queue0.enqueue("A3");
           queue0.enqueue("A4");
           queue0.enqueue("A5");
           queue0.enqueue("A6");
           queue0.enqueue("A7");
           queue0.enqueue("A8");
           Queue<String> queue1 = new LinkedQueue<String>();
           queue1.enqueue("B1");
           queue1.enqueue("B2");
           queue1.enqueue("B3");
           queue1.enqueue("B4");
           
           Queue<String>[] queues = new Queue[]{queue0, queue1};
           Queue<String> res = QueueUtils.merge(queues);
           System.out.println (toString(res));

           queue0 = new LinkedQueue<String>();
           queue0.enqueue("A1");
           queue0.enqueue("A2");
           queue0.enqueue("A3");
           queue0.enqueue("A4");
           queue0.enqueue("A5");
           queue1 = new LinkedQueue<String>();
           queue1.enqueue("B1");
           queue1.enqueue("B2");
           queue1.enqueue("B3");
           Queue<String> queue2 = new LinkedQueue<String>();
           queue2.enqueue("C1");
           Queue<String> queue3 = new LinkedQueue<String>();
           Queue<String> queue4 = new LinkedQueue<String>();
           queue4.enqueue("E1");
           queue4.enqueue("E2");
           queue4.enqueue("E3");
           queue4.enqueue("E4");
           queue4.enqueue("E5");
           queue4.enqueue("E6");
           queue4.enqueue("E7");

           queues = new Queue[]{queue0, queue1, queue2, queue3, queue4};
           res = QueueUtils.merge(queues);
           System.out.println (toString(res));
        }
}

