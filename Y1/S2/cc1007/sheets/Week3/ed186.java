class Rectangle {
  Point bottomLeftPoint;
  Point topRightPoint;
  int length = 0;
  int height = 0;

  Rectangle(int x1, int y1, int x2, int y2) {
    length = x2 - x1;
    height = y2 - y1;

    bottomLeftPoint = new Point(x1, y1);
    topRightPoint = new Point(x2, y2);
  }

  Rectangle(Point p1, Point p2) {
    length = p2.x - p1.x;
    height = p2.y - p1.y;

    bottomLeftPoint = p1;
    topRightPoint = p2;
  }

  public int area() {
    return length * height;
  }

  public int perimeter() {
    return (2 * length) + (2 * height);
  }

  public boolean pointInside(Point b) {
    return (b.x >= bottomLeftPoint.x && b.y >= bottomLeftPoint.y && b.x <= topRightPoint.x && b.y <= topRightPoint.y);
  }

  public boolean rectangleInside(Rectangle r) {
    return (r.bottomLeftPoint.x >= bottomLeftPoint.x && r.bottomLeftPoint.y >= bottomLeftPoint.y && r.topRightPoint.x <= topRightPoint.x && r.topRightPoint.y <= topRightPoint.y);
  }
}