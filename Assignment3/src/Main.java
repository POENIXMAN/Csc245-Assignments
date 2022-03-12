import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static int reverseAnswer = 0;  // int to store the reversed number from method reverseNumber()

    static int digitsCount = 0; // int to store the count of digits in a number from method countDigits()


    static int reverseNumber(int var) {
        if (var == 0) {
            return reverseAnswer;
        }

        if (var > 0) {
            int temp = var % 10;
            reverseAnswer = reverseAnswer * 10 + temp;
            reverseNumber(var / 10);
        }

        return reverseAnswer;
    }

    static int countDigits(int digit){
        if ( digit > 0){
            digitsCount +=1;
            countDigits(digit/10);
        }
        return digitsCount;
    }

    static String repeat(String str, int repeatFor){

        if (repeatFor <= 0)
            return "";

        if (repeatFor == 1){
            return str;
        }

        return str + repeat(str,repeatFor - 1);
    }

    static void printNumbers(int[] arr, char c){
        // a method to print even or odd elements of user's array

        if (c == 'e'){
            for (int j : arr) {
                if (j % 2 == 0)
                    System.out.println(j);
            }
        }
        else{
            for (int j : arr) {
                if (j % 2 != 0)
                    System.out.println(j);
            }
        }
    }

    static int maxValue(int[] arr,int length){
        // method to find the maximum value in an array
        if (arr.length == 1)
            return arr[0];

        return Math.max(maxValue(arr, arr.length-1), arr[length-1]);
    }

    static boolean sum(int[] arr, int neededResult) {
        neededResult = neededResult - arr[0];

        if (neededResult <= 0)
            return true;

        if (arr.length == 1)
            return arr[0] == neededResult;

        else{
            try {
                int[] subArray;
                if (arr.length % 2 == 0) { //check that length of array is even
                    subArray = Arrays.copyOfRange(arr, 2, arr.length);
                } else {
                    subArray = Arrays.copyOfRange(arr, 2, (arr.length) + 1);
                }

                System.out.println(neededResult);
                return sum(subArray, neededResult);
            }
           catch (ArrayIndexOutOfBoundsException e){
                return false;
           }
        }

    }

    public static void main(String[] args)
    {
        menuOptions();
        short choice = scanner.nextShort();
        while (choice != 8){
            switch (choice){
                case 1 -> {
                    System.out.println(reverseNumber(341)); // 143
                    menuOptions();
                    choice = scanner.nextShort();
                }
                case 2 -> {
                    System.out.println(countDigits(34114354)); // 8
                    menuOptions();
                    choice = scanner.nextShort();
                }
                case 3 -> {
                    System.out.println(repeat("Apple",6)); //AppleAppleAppleAppleAppleApple
                    System.out.println(repeat("Apple",0)); // line will be skipped
                    menuOptions();
                    choice = scanner.nextShort();
                }
                case 4 -> {
                    int[] array = numberArray();
                    System.out.println("What numbers you want printed? Even/Odd?");
                    String input = scanner.next();
                    if (input.toLowerCase(Locale.ROOT).startsWith("e")) {
                        printNumbers(array, 'e');
                        menuOptions();
                        choice = scanner.nextShort();
                    } else if (input.toLowerCase(Locale.ROOT).startsWith("o")) {
                        printNumbers(array, 'o');
                        menuOptions();
                        choice = scanner.nextShort();
                    } else {
                        System.out.println("Wrong input");
                        menuOptions();
                        choice = scanner.nextShort();
                    }
                }
                case 5 -> {
                    int[] array = numberArray();
                    int n = maxValue(array, array.length);
                    System.out.println("the largest number is: "+n);
                    menuOptions();
                    choice = scanner.nextShort();
                }

                case 6 -> System.out.println("Was not able to do it ...");

                case 7 -> {
                    int[] array = numberArray();
                    System.out.println("Enter an int: ");
                    int num = scanner.nextInt();
                    boolean b =  sum(array,num);
                    System.out.println(b);
                    menuOptions();
                    choice = scanner.nextShort();
                }
                default -> {
                    System.out.println("Wrong input ...");
                    menuOptions();
                    choice = scanner.nextShort();
                }

            }
        }
        System.out.println("Good bye");
        System.exit(1);
    }

    public static void menuOptions(){
        System.out.println("""
                    \n
                    1. Reverse number
                    2. Count Digits
                    3. Repeat
                    4. Even or odd
                    5. Find max
                    6. Adds up
                    7. Sum
                    8. Exit
                    - - - - - - - - - - - - -\s
                    Enter a choice:\s""");
    }

    public static int[] numberArray(){
        // method to create and add elements to ana array

        System.out.println("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] numberArray = new int[n];
        for (int i =0 ; i < n; i++){
            System.out.println("Enter element " + i + ": ");
            int temp = scanner.nextInt();
            numberArray[i] = temp;
        }
        System.out.println("Added the array");
        return numberArray;
    }
}
