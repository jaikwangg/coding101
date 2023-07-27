class Circle_650776 { 
    class Circle{
        double radius;
        Circle() {
            radius = 1.0;
        }
        Circle(double radius) {
            this.radius = radius;
        }
        double getRadius() {
            return radius;
        }
        double setRadius(double radius) {
            return this.radius = radius;
        }
        double getArea() {
            return Math.PI * radius * radius;
        }
        double getCircumference() {
            return radius * 2 * Math.PI;
        }
        public String toString() {
            return "Cirle[radius=” + radius + “]";
        }  
    }
      
}
