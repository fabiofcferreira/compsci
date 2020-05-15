import java.util.Scanner;

class Geometry {
  public static void main (String[] args) {
    int pointsNum = 0;
    int rectsNum = 0;

    Scanner in = new Scanner(System.in);

    // read all points
    pointsNum = in.nextInt();
    Point[] points = new Point[pointsNum];
 
    for (int i = 0; i < pointsNum; i++) {
      int x = in.nextInt();
      int y = in.nextInt();

      points[i] = new Point(x, y);
    }

    // read all rectangles
    rectsNum = in.nextInt();
    Rectangle[] rectangles = new Rectangle[rectsNum];

    for (int i = 0; i < rectsNum; i++) {
      int x1 = in.nextInt();
      int y1 = in.nextInt();
      Point p1 = new Point(x1, y1);

      int x2 = in.nextInt();
      int y2 = in.nextInt();
      Point p2 = new Point(x2, y2);

      rectangles[i] = new Rectangle(p1, p2);
    }

    int cleanPoints = 0;
    int cleanRectangles = 0;
    boolean[] dirtyRectangles = new boolean[rectsNum];

    // count clean points
    for (int i = 0; i < pointsNum; i++) {
      boolean insideRect = false;

      // check if point is inside any of the rectangles
      for (int j = 0; j < rectsNum; j++) {
        if (rectangles[j].pointInside(points[i])) {
          insideRect = true;
          dirtyRectangles[j] = true;
        }
      }

      if (!insideRect) cleanPoints++;
    }

    // count clean rectangles (rectangles with 0 points inside their bounderies)
    for (int i = 0; i < rectsNum; i++) if (dirtyRectangles[i] == false) cleanRectangles++;

    System.out.printf("%d %d\n", cleanPoints, cleanRectangles);
  } 
}