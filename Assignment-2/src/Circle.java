public class Circle extends Shape{

    private float radius;
    private final float PI = 2.1416f;
    Circle(float x_c, float y_c, float rds) {
        super( x_c, y_c);
        super.movable = false;
        radius = rds;
    }

    public void setRadius(float _radius){radius=_radius;}

    public float getRadius(){
        return radius;
    }
    @Override
    public float getArea() {
        return (float) (PI * Math.pow(radius,2));
    }

    @Override
    public float getPerimeter() {
        return 2*PI*radius;
    }
}
