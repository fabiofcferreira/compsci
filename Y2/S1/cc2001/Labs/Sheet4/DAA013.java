import java.io.*;
import java.util.*;

class Segment implements Comparable<Segment> {
  public int start;
  public int end;

  Segment(int s, int e) {
    start = s;
    end = e;
  }

  @Override
  public int compareTo(Segment s) {
    if (start < s.start) return -1;
    if (start > s.start) return 1;

    return Integer.compare(s.end, end);
  }
}

public class DAA013 {
  public static int maxSegments(Segment[] segments, int m) {
    Segment curr = segments[0];
    int counter = 1;

    // Identify max duration possible and its segment index
    Segment nextSegment = segments[0];
    while (curr.end < m) {
      for (int i = 0; i < segments.length; i++) {
        if (segments[i].start <= curr.end && segments[i].end > nextSegment.end) nextSegment = segments[i];
      }

      curr = nextSegment;
      counter++;
    }

    return counter;
  }

  public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);

    int m = 0;
    int segmentsNum = 0;
    Segment[] segments;

    m = in.nextInt();
    segmentsNum = in.nextInt();
    segments = new Segment[segmentsNum];

    // Read segments
    for (int i = 0; i < segments.length; i++) {
      segments[i] = new Segment(in.nextInt(), in.nextInt());
    }

    // Sort segments by start time and if there is a tie, order by greatest end time
    Arrays.sort(segments);

    FastPrint.out.printf("%d\n", maxSegments(segments, m));

    FastPrint.out.close();
  }
}
