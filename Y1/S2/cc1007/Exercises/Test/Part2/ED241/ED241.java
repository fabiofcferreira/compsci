import java.util.Scanner;
import java.util.LinkedList;

class Submission {
  String user;
  String problem;
  String status;
}

public class ED241 {
  static int flag;
  static int numSubmissions;
  static BSTMap<String, Submission> submissions = new BSTMap<String, Submission>();
  static BSTMap<String, Integer> userSubmissions = new BSTMap<String, Integer>();
  static BSTMap<String, Integer> userAcceptedSubmissions = new BSTMap<String, Integer>();
  static BSTMap<String, Integer> problemSolvers = new BSTMap<String, Integer>();

  public static void diffProblems() {
    System.out.println(submissions.size());
  }

  public static void maximumSubmissionsPerUser() {
    int maxSubmissions = 0;
    String biggestSubmissionUser = "";
    LinkedList<String> keysLL = userSubmissions.keys();

    for (int i = 0; i < keysLL.size(); i++) {
      String user = keysLL.get(i);

      if (userSubmissions.get(user) > maxSubmissions) {
        biggestSubmissionUser = user;
        maxSubmissions = userSubmissions.get(biggestSubmissionUser);
      }
    }

    System.out.printf("%s %d\n", biggestSubmissionUser, maxSubmissions);
  }

  public static void acceptedRatio() {
    LinkedList<String> keysLL = userAcceptedSubmissions.keys();

    for (int i = 0; i < keysLL.size(); i++) {
      String user = keysLL.get(i);

      if ((float) userAcceptedSubmissions.get(user) / userSubmissions.get(user) >= 0.5) {
        System.out.println(user);
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    flag = in.nextInt();
    numSubmissions = in.nextInt();

    for (int i = 0; i < numSubmissions; i++) {
      Submission sub = new Submission();

      sub.user = in.next();
      sub.problem = in.next();
      sub.status = in.next();

      submissions.put(sub.problem, sub);

      // submission number for each user
      int currSubmissions = 0;
      if (userSubmissions.get(sub.user) != null)
        currSubmissions = userSubmissions.get(sub.user);

      userSubmissions.put(sub.user, currSubmissions + 1);
      
      // accepted submission number for each user
      if (sub.status.compareTo("Accepted") == 0) {
        int currAcceptedSubmissions = 0;
        if (userAcceptedSubmissions.get(sub.user) != null)
          currAcceptedSubmissions = userAcceptedSubmissions.get(sub.user);

        userAcceptedSubmissions.put(sub.user, currAcceptedSubmissions + 1);
      }
    }

    if (flag == 1) diffProblems();
    else if (flag == 2) maximumSubmissionsPerUser();
    else if (flag == 3) acceptedRatio();

    in.close();
  }
}