public class ED197 {
  public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b) {
    MyQueue<Integer> mergedQueue = new LinkedListQueue<Integer>();
    int smallerQueueSize = a.size() > b.size() ? b.size() : a.size();

    while (!a.isEmpty() && !b.isEmpty()) {
      Integer aElem = a.first();
      Integer bElem = b.first();

      if (aElem < bElem) {
        mergedQueue.enqueue(a.dequeue());
      } else {
        mergedQueue.enqueue(b.dequeue());
      }
    }

    // add remaining elements in one of the queues
    while (!a.isEmpty()) {
      mergedQueue.enqueue(a.dequeue());
    }

    while (!b.isEmpty()) {
      mergedQueue.enqueue(b.dequeue());
    }

    return mergedQueue;
  }
}