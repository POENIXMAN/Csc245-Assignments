
public abstract class Shape {
    protected String color = "Black";
    protected char dimensions = '2';
    protected float x_coordinates;
    protected float y_coordinates;
    protected boolean movable = true;

    Shape(float x_c, float y_c){
        x_coordinates = x_c;
        y_coordinates = y_c;
    }

    public float getX_coordinates() {
        return x_coordinates;
    }

    public float getY_coordinates() {
        return y_coordinates;
    }

    public void setX_coordinates(float x_coordinates) {
        this.x_coordinates = x_coordinates;
    }

    public void setY_coordinates(float y_coordinates) {
        this.y_coordinates = y_coordinates;
    }

    public void setColor(String clr){ color = clr;}

    public boolean isMovable(){
        return movable;
    }

    public abstract float getArea();

    public abstract float getPerimeter();

    @Override
    public String toString() {
        String s = String.valueOf(this.getClass());
        s = s.substring(s.lastIndexOf(' ') + 1);
        return "Shape{" + s +
                ", color='" + color + '\'' +
                ", dimensions=" + dimensions + "D" +
                ", x_coordinates=" + x_coordinates +
                ", y_coordinates=" + y_coordinates +
                '}';
    }
}
