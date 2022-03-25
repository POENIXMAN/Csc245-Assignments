import java.io.*;
import java.util.Scanner;

public class TestProgram {

    final static int SIZE=5;

    public static void sort(Sortable[] items)
    {
        /*sorts  an array of items in an increasing order as specified in the compareTo() method*/

        for (int i = 1; i < items.length; i++ )
        {
            Sortable key  = items[i];
            int position = i;
            while (position > 0 && items[position-1].compareTo(key) > 0)
            {
                items[position]=items[position-1];
                position--;
            }
            items[position]=key;
        }
    }

    public static void show(Sortable[] items)
    {
        for (Sortable item : items) {
            if (item != null)
                System.out.println(item);
        }
    }

    public static void main (String[] args) {
        Animal[] animals= new Animal[SIZE];

        File file = new File("/home/poenixman/IdeaProjects/Assignment4/src/input.txt");

        try {

            Scanner input = new Scanner(file);
            int count = 0;
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] elements = line.split(" ");
                Animal anim = new Animal(Float.parseFloat(elements[1]),elements[2],elements[3]); // create new animal
                anim.setMaximumAmountOfFood(elements[0]); // according to animal type
                anim.setActualAmountOfFood(Float.parseFloat(elements[4])); // check bounds for actual food amount
                anim.setAnimalType(anim.getMaximumAmountOfFood());
                animals[count] = anim; // add new animal to the array
                count++;
            }
            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        sort(animals);
        show(animals);

        // code to save animals to "output.txt"
        FileWriter writer = null;
        try {
            writer = new FileWriter("/home/poenixman/IdeaProjects/Assignment4/src/output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Animal animal: animals) {
            try {
                if (writer != null) {
                    writer.write(animal.toString() + System.lineSeparator());
                }
            } catch (IOException e) {
                System.out.println("couldn't write");
            }
        }
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("couldn't close file");
        }
    }

}

