public class DAA006 {
  static int n;

  static double sqX = 0;
  static double sqY = 0;
  static double sqL = 0;
  static double sqA = 0;

  static double cX = 0;
  static double cY = 0;
  static double cR = 0;
  static double cA = 0;

  public static double squareArea (double l) {
    return l * l;
  }

  public static double circleArea (double r) {
    return Math.PI * r * r;
  }

  public static boolean noIntersection(double x1, double x2, double y1, double y2) {
    // Check if there is an intersection first
    if ((cX + cR) <= x1 || (cX - cR) >= x2) {
      return true;
    } else if ((cY + cR) <= y1 || (cY - cR) >= y2) {
      return true;
    }

    return false;
  }

  public static boolean circleInsideSquare (double x1, double x2, double y1, double y2) {
    return ((cX - cR) >= x1) && ((cX + cR) <= x2) && ((cY - cR) >= y1) && ((cY + cR) <= y2);
  }

  public static boolean squareInsideCircle (double x1, double x2, double y1, double y2) {
    // boolean squareInsideCircle = ((cX - cR) <= x1) && ((cX + cR) >= x2) && ((cY - cR) <= y1) && ((cY + cR) >= y2);
    double dx = Math.max(cX - x1, x2 - cX);
    double dy = Math.max(cY - y2, y1 - cY);
    
    return cR * cR >= dx*dx + dy*dy;
  }

  public static void displayResult(Double f) {
    FastPrint.out.printf("%.4f\n", f);
  }

  public static double intersection(double x1, double x2, double y1, double y2) {
    double length = x2 - x1;

    if (noIntersection(x1, x2, y1, y2)) {
      return 0;
    }

    // Check if circle is smaller than square and is inside it
    double area = 0;
    boolean circleInsideSquare = circleInsideSquare(x1, x2, y1, y2);
    boolean squareInsideCircle = squareInsideCircle(x1, x2, y1, y2);

    if (circleInsideSquare) {
      FastPrint.out.println("Circle inside square.");
      return circleArea(cR);
    } else if (squareInsideCircle) {
      FastPrint.out.println("Square inside circle.");
    } else {
      double diff = length / 2;
      if (diff <= 0.01) return 0;

      area += intersection(x1, x2 - diff, y1 + diff, y2); // Top left quare
      area += intersection(x1 + diff, x2, y1 + diff, y2); // Top right quare
      area += intersection(x1, x2 - diff, y1, y2 - diff); // Bottom left quare
      area += intersection(x1 + diff, x2, y1, y2 - diff); // Bottom right square
    }

    return area;
  }

  public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);
    n = in.nextInt();

    for (int i = 0; i < n; i++) {
      sqX = in.nextDouble();
      sqY = in.nextDouble();
      sqL = in.nextDouble();

      cX = in.nextDouble();
      cY = in.nextDouble();
      cR = in.nextDouble();

      displayResult(intersection(sqX, sqX, sqY+sqL, sqY+sqL));
    }

    FastPrint.out.close();
  }
}
