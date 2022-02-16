public class Square extends Shape{

    private float sideLength;

    Square(float x_c, float y_c, float sdlng) {
        super(x_c, y_c);
        sideLength = sdlng;
    }

    public float getSideLength() {
        return sideLength;
    }

    public void setSideLength(float side_length) {
        this.sideLength = side_length;
    }

    @Override
    public float getArea() {
        return (float) Math.pow(sideLength,2);
    }

    @Override
    public float getPerimeter() {
        return 4 * sideLength;
    }
}
