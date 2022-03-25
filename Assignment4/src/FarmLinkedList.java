import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class FarmLinkedList {
    AnimalNode head;
    AnimalNode sorted;

    private final Scanner scanner = new Scanner(System.in);

    public void addAnimal (){
        Animal animal = setNewAnimal();

        AnimalNode an = new AnimalNode(animal);

        if (head == null){
            head = an;
        }

        else {
            AnimalNode temp = head;
            while (temp.getNextAnimal() != null){
                temp =temp.getNextAnimal();
            }
            temp.setNextAnimal(an);
        }

        System.out.println("Successfully added");
    }

    public int getSize() {
        int size = 0;

        if (head == null)
            return size;

        else {
            AnimalNode temp = head;
            while (temp != null){
                size++;
                temp = temp.getNextAnimal();
            }
        }

        return size;
    }

    public void listAnimals(String animal){

        if (head == null)
            System.out.println("No animals in the farm.");

        else {
            AnimalNode temp = head;
            while (temp != null){
                if (Objects.equals(temp.getAnimal().getAnimalTypeString(temp.getAnimal().getAnimalType()),
                        animal.toLowerCase(Locale.ROOT)))
                    System.out.println(temp.getAnimal());
                temp = temp.getNextAnimal();
            }
        }

    }

    public void removeAnimals(float amount){

        if (amount < 0){
            System.out.println("Please enter an appropriate amount of food.");
            return;
        }

        else if (head == null){ // check for empty farm
            System.out.println("The farm is empty");
            return;
        }

        insertionSort(head); // sort the farm

        if(head.getAnimal().getActualAmountOfFood() >= amount){
            // farm is empty, so if first element eats more than
            // provided -> empty farm
            head = null;
            System.out.println("Done");
        }


        else{
            AnimalNode temp = head.getNextAnimal(), prev = head;
            while (temp != null){
                if (temp.getAnimal().getActualAmountOfFood() >= amount)
                    prev.setNextAnimal(null);
                temp = temp.getNextAnimal();
                prev = prev.getNextAnimal();
            }
            System.out.println("Done...");
        }
    }

    // function to sort a singly linked list using insertion sort
    void insertionSort(AnimalNode headref)
    {
        // Initialize sorted linked list
        sorted = null;
        AnimalNode current = headref;
        // Traverse the given linked list and insert every
        // node to sorted
        while (current != null)
        {
            // Store next for next iteration
            AnimalNode next = current.getNextAnimal();
            // insert current in sorted linked list
            sortedInsert(current);
            // Update current
            current = next;
        }
        // Update head to point to sorted linked list
        head = sorted;
    }


    void sortedInsert(AnimalNode newnode)
    {

        if (sorted == null || sorted.getAnimal().getActualAmountOfFood() >= newnode.getAnimal().getActualAmountOfFood())
        {
            newnode.setNextAnimal(sorted);
            sorted = newnode;
        }
        else
        {
            AnimalNode current = sorted;

            while (current.getNextAnimal() != null && current.getNextAnimal().getAnimal().getActualAmountOfFood()
                    < newnode.getAnimal().getActualAmountOfFood())
            {
                current = current.getNextAnimal();
            }
            newnode.setNextAnimal(current.getNextAnimal());
            current.setNextAnimal(newnode);
        }
    }

    void listAll(){
        if (head == null){
            System.out.println("empty farm");
        }
        else{
            AnimalNode temp = head;
            while (temp != null){
                System.out.println(temp.getAnimal());
                temp = temp.getNextAnimal();
            }

        }
    }

    // Methods to setup main methods -------------------------------------------------
    private Animal setNewAnimal() {
        String color = getAnimalColor();
        String gender = getAnimalGender();
        float food = getAnimalFood();
        float age = getAnimalAge();
        String animalType = getAnimalType();
        Animal animal = new Animal(age, color, gender);
        animal.setMaximumAmountOfFood(animalType);
        animal.setAnimalType(animal.getMaximumAmountOfFood());
        animal.setActualAmountOfFood(food);
        return animal;
    }

    private String getAnimalColor () {
        System.out.println("Enter animal color: ");
        return scanner.next();
    }

    private String getAnimalGender () {
        System.out.println("Enter animal gender: ");
        return scanner.next();
    }

    private float getAnimalFood() {

        while(true) {
            try{
                System.out.println("Enter amount of food the animal eats: ");
                return scanner.nextFloat();
            }catch (InputMismatchException e){
                System.out.println("please enter number: ");
                scanner.next();
            }
        }


    }

    private float getAnimalAge() {
        while(true) {
            try{
                System.out.println("Enter age of the animal: ");
                return scanner.nextFloat();
            }catch (InputMismatchException e){
                System.out.println("please enter a number: ");
                scanner.next();
            }
        }
    }

    private String getAnimalType () {
        System.out.println("Please choose animal type: ");
        System.out.println("> Chicken");
        System.out.println("> Lamb");
        System.out.println("> Cow");
        System.out.println("> Horse");
        System.out.println("Enter your choice: ");
        return scanner.next();
    }
}
