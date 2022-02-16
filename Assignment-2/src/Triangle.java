public class Triangle extends Shape{
    protected float[] sideLength = new float[3];

    Triangle(float x_c, float y_c, float[] sides) {

        super(x_c, y_c);
        sideLength = sides;
    }


    @Override
    public float getArea() {
        // Using Heron's formula
        float s = getPerimeter()/2;
        float area = (float) Math.sqrt(s * (s-sideLength[0]) * (s-sideLength[1]) * (s-sideLength[2]));
        return area;
    }

    @Override
    public float getPerimeter() {
        return sideLength[0] + sideLength[1] + sideLength[2];
    }
}
