import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Shape> shapesArray = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.printMenu();
        main.menuManager();
    }

    //Options methods-----------------------------------------------------

    public void printMenu(){
        System.out.println("\n1. Add a shape");
        System.out.println("2. Delete a shape");
        System.out.println("3. Compute area and perimeter");
        System.out.println("4. Display all");
        System.out.println("5. Move an object");
        System.out.println("6. Read from file");
        System.out.println("7. Exit");
        System.out.println("----------------------");
        System.out.println("Enter your choice: ");

    }
    public void chooseShape(){
        System.out.println("\nA. Add circle");
        System.out.println("B. Add square");
        System.out.println("C. Add triangle");
        System.out.println("D. Return to main menu");
        System.out.println("----------------------");
        System.out.println("Enter your choice: ");
    }
    public void menuManager(){

        int choice = scanner.nextInt();
        while(choice != 7) {
                switch (choice) {
                    case 1 -> {
                        chooseShape();
                        shapeManager();
                        printMenu();
                        choice = scanner.nextInt();
                    }
                    case 2 -> {
                        if(checkShapesLength()) {
                            float x = getX();
                            float y = getY();
                            deleteShape(x, y);
                        }
                        printMenu();
                        choice = scanner.nextInt();

                    }
                    case 3 -> {
                        if(checkShapesLength()){
                            float x = getX();
                            float y = getY();
                            perimeterAndArea(x,y);
                        }
                        printMenu();
                        choice = scanner.nextInt();
                    }
                    case 4 -> {
                        listShapes();
                        printMenu();
                        choice = scanner.nextInt();
                    }
                    case 5 -> {
                        if(checkShapesLength()){
                            float x = getX();
                            float y = getY();
                            moveShape(x,y);
                        }
                        printMenu();
                        choice = scanner.nextInt();
                    }
                    case 6 -> {
                        readFromFile();
                        printMenu();
                        choice = scanner.nextInt();
                    }
                    default -> {
                        System.out.println("\nInvalid choice\n");
                        printMenu();
                        choice = scanner.nextInt();
                    }

                }
        }

        exit();
    }
    public void shapeManager(){
        String option = scanner.next().toUpperCase();
        while (!option.equals("D")){
            switch (option){
                case "A" -> {
                    float x = getX();
                    float y = getY();
                    float radius = getRadius();
                    Circle circle = new Circle(x,y,radius);
                    shapesArray.add(circle);
                    System.out.println("Circle was successfully added");
                    chooseShape();
                    option = scanner.next().toUpperCase();
                }
                case "B" -> {
                    float x = getX();
                    float y = getY();
                    float sideLength = getSideLength();
                    Square square = new Square(x,y,sideLength);
                    shapesArray.add(square);
                    System.out.println("Square was successfully added");
                    chooseShape();
                    option = scanner.next().toUpperCase();
                }
                case "C" -> {
                    setTriangle();

                    chooseShape();
                    option = scanner.next().toUpperCase();
                }
                default -> {
                    System.out.println("\nInvalid input...");
                    chooseShape();
                    option = scanner.next().toUpperCase();
                }
            }

        }

        printMenu();
        menuManager();
    }

    //getter methods for shapes for option 1-----------------------------

    public float getX(){
        System.out.println("\nEnter x-coordinates of the shape: ");
        return scanner.nextFloat();
    }
    public float getY(){
        System.out.println("\nEnter y-coordinates of the shape: ");
        return scanner.nextFloat();
    }
    public float getRadius(){
        System.out.println("\nEnter the radius of the circle: ");
        return scanner.nextFloat();
    }
    public float getSideLength(){
        System.out.println("\nEnter the length of side: ");
        return scanner.nextFloat();
    }
    public void setTriangle(){
        float x = getX();
        float y = getY();
        float[] sides = new float[3];
        float s1,s2,s3;
        System.out.println("\nEnter side1 length: ");
        s1 = scanner.nextFloat();
        sides[0] = s1;
        System.out.println("Enter side2 length: ");
        s2 = scanner.nextFloat();
        sides[1] = s2;
        System.out.println("Enter side3 length: ");
        s3 = scanner.nextFloat();
        sides[2] = s3;
        if (s1 == s2 && s2 == s3 && s1 == s3) {
            EquilateralTriangle equilateralTriangle = new EquilateralTriangle(x,y,sides);
            shapesArray.add(equilateralTriangle);
            System.out.println("EquilateralTriangle was successfully added");
        }
        else {
            Triangle triangle = new Triangle(x,y,sides);
            shapesArray.add(triangle);
            System.out.println("Triangle was successfully added");
        }

    }

    //Option 2 method-----------------------------------------------------
    public void deleteShape(float x, float y){

        shapesArray.removeIf(shape -> shape.getX_coordinates() == x && shape.getY_coordinates() == y);
        System.out.println("Shape(s) successfully removed...");

    }

    //Option 3 method-----------------------------------------------------
    public void perimeterAndArea(float x, float y){
        for (Shape shape : shapesArray){
            if(shape.getX_coordinates() == x && shape.getY_coordinates() == y) {
                float area = shape.getArea();
                float perimeter = shape.getPerimeter();
                System.out.println("Shape has area of "+area+"\nPerimeter of "+perimeter);
            }
            else{
                System.out.println("No shape with this coordinates");
            }
        }
    }

    //Option 4 method-----------------------------------------------------
    public void listShapes(){
        if(checkShapesLength()){
            for (Shape shape : shapesArray)
                System.out.println(shape);
        }
    }

    //Option 5 method-----------------------------------------------------
    public void moveShape(float x, float y){
        for (Shape shape: shapesArray){
            if(shape.getX_coordinates() == x && shape.getY_coordinates() == y){
                if (shape.isMovable()){
                    System.out.println("Enter how to move: hor/vert");
                    String choice = scanner.next();
                    switch (choice){
                        case "hor" -> {
                            x = getX();
                            if(shape.getX_coordinates() <= 200 || shape.getX_coordinates() >= -200){
                                shape.setX_coordinates(x);
                                System.out.println("X-axis successfully updated");
                            }
                            else{
                                System.out.println("You can't move more than +-200");
                            }
                        }
                        case "vert" ->{
                            y = getY();
                            if(shape.getY_coordinates() <= 200 || shape.getY_coordinates() >= -200){
                                shape.setY_coordinates(y);
                                System.out.println("Y-axis successfully updated");
                            }
                            else{
                                System.out.println("You can't move more than +-200");
                            }
                        }
                        default -> {
                            System.out.println("Invalid input...");
                            moveShape(x,y);
                        }
                    }
                }
                else{
                    System.out.println("This shape is not movable");
                }
            }
        }


    }

    //Else----------------------------------------------------------------
    public Boolean checkShapesLength(){
        if(shapesArray.size() == 0) {
            System.out.println("No shapes in the the array yet");
            return false;
        }
        else{
            return true;
        }
    }

    public void readFromFile() {
        /*I am running my code on linux so for me this is the absolute path, it worked the file values
        * where displayed successfully*/
        try {
            File myObj = new File("/home/poenixman/IdeaProjects/csc245-assignments/Assignment-2/src/shapesFile.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void createFile(){
        try {
            File myObj = new File("/home/poenixman/IdeaProjects/csc245-assignments/Assignment-2/src/userShapes.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeTiFile(){
        try {
            FileWriter myWriter = new FileWriter("/home/poenixman/IdeaProjects/csc245-assignments/Assignment-2/src/userShapes.txt");
            for (Shape shape : shapesArray){
                myWriter.write(shape.toString());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void exit() {
        createFile();
        writeTiFile();
        System.out.println("\nBye");
        System.exit(1);
    }
}
