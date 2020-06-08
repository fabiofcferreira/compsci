import java.util.Scanner;

class Process {
  String name;
  int initial_time = -1;
  int finish_time = -1;
  int time_left;
}

public class ED237 {
  static int executionTime;
  static int processes;

  static MyQueue<Process> queue = new LinkedListQueue<Process>();

  public static void finishProcesses() {
    int time = 0;

    while (queue.size() > 0) {
      Process currProcess = queue.first();

      // remove from the queue temporarily
      queue.dequeue();

      // set initial_time if it is not set yet (first time executing process)
      if (currProcess.initial_time == -1) currProcess.initial_time = time;

      // update time_left
      if (currProcess.time_left >= executionTime) {
        // update time_left
        currProcess.time_left -= executionTime;
        // update time
        time += executionTime;

        // set finish time if the process has ended
        if (currProcess.time_left == 0 && currProcess.finish_time == -1) { currProcess.finish_time = time; }
      } else {
        time += currProcess.time_left;

        // update time_left and finish_time
        currProcess.time_left = 0;
        currProcess.finish_time = time;
      }


      if (currProcess.time_left > 0) queue.enqueue(currProcess);
      else System.out.printf("%s %d %d\n", currProcess.name, currProcess.initial_time, currProcess.finish_time);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    executionTime = in.nextInt();
    processes = in.nextInt();

    for (int i = 0; i < processes; i++) {
      Process newProcess = new Process();
      
      newProcess.name = in.next();
      newProcess.time_left = in.nextInt();

      queue.enqueue(newProcess);
    }

    finishProcesses();

    in.close();
  }
}