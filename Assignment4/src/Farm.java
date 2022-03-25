import java.util.Scanner;

public class Farm {

    static Scanner sc =new Scanner(System.in);
    public int wrongInputCount;
    FarmLinkedList fll = new FarmLinkedList();

    public static void main(String[] args) {
        Farm fm = new Farm();
        // Assume that input from user is right
        fm.wrongInputCount = 0;
        fm.menuOptions();
        fm.menuSwitch();

    }

    public void menuOptions(){
        System.out.println("""
                \n
                1. Add an animal
                2. Search for an animal
                3. Sort
                4. Remove by consumption
                5. Exit
                - - - - - - - - - - - - -\s
                Enter your choice:\s""");
    }

    public void menuSwitch(){

        
        if(wrongInputCount > 5){
            System.out.println("You're out...");
            System.exit(1);
        }

        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> {
                fll.addAnimal();
                menuOptions();
                menuSwitch();
            }
            case 2 -> {
                System.out.println("Enter type of animal to print: ");
                String animal = sc.next();
                fll.listAnimals(animal);
                menuOptions();
                menuSwitch();
            }
             case 3 -> {
                 fll.insertionSort(fll.head);
                 menuOptions();
                 menuSwitch();

             }
             case 4 -> {
                 System.out.println("Please enter amount of food: ");
                 float food = sc.nextFloat();
                 fll.removeAnimals(food);
                 menuOptions();
                 menuSwitch();
             }


             case 5 -> System.exit(0);

            // cases 6-7 for testing purposes
             case 6 -> {
                 System.out.println(fll.getSize());
                 menuOptions();
                 menuSwitch();
             }

             case 7 -> {
                 fll.listAll();
                 menuOptions();
                 menuSwitch();
             }

             default -> {
                 System.out.println("Please enter a choice from 1 - 5: ");
                 wrongInputCount++;
                 menuOptions();
                 menuSwitch();
             }
        }



    }

}
