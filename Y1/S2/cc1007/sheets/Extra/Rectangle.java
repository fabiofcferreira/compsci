// Uma classe simples para representar um rectângulo
class Rectangle {
    Point p1, p2; // Ponto inferior esquerdo e ponto superior direito

    // Construtor de um rectângulo
    Rectangle(Point a, Point b) {
      p1 = new Point(a.getX(), a.getY());
      p2 = new Point(b.getX(), b.getY());
    }

    // Área de um rectângulo
    int area() {
	    return (p2.getX()-p1.getX()) * (p2.getY()-p1.getY()); 
    }

    // Perímetro de um rectângulo
    int perimeter() {
	    return (p2.getX()-p1.getX())*2 +  (p2.getY()-p1.getY())*2;
    }

    // Devolve true se o ponto p está dentro do rectângulo e false caso contrário
    // Se estiver na borda é considerado que está dentro
    boolean pointInside(Point p) {
	    return (p.getX() >= p1.getX() && p.getX() <= p2.getX() &&
		  p.getY() >= p1.getY() && p.getY() <= p2.getY());
    }

    // Devolve true se o rectângulo r está dentro do rectângulo e false caso contrário
    boolean rectangleInside(Rectangle r) {
	    return pointInside(r.p1) && pointInside(r.p2);
    }
}