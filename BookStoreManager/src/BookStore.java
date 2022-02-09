import java.util.Scanner;


class BookStore{

    public Book[] books = new Book[0];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BookStore bookStore = new BookStore();

        bookStore.printMenu();


        int choice = scanner.nextInt();

        while(choice != 5){
            switch (choice) {
                case 1 -> {
                    bookStore.addBook();
                    bookStore.printMenu();
                    choice = scanner.nextInt();
                }
                case 2 -> {
                    bookStore.removeBook();
                    bookStore.printMenu();
                    choice = scanner.nextInt();
                }
                case 3 -> {
                    bookStore.sellBook();
                    bookStore.printMenu();
                    choice = scanner.nextInt();
                }
                case 4 -> {
                    bookStore.listBooks();
                    bookStore.printMenu();
                    choice = scanner.nextInt();
                }
                default -> {
                    System.out.println("\nInvalid choice\n");
                    bookStore.printMenu();
                    choice = scanner.nextInt();
                }

            }


        }

        bookStore.exit();

    }

    public void printMenu(){
        System.out.println("\n1. Add a book");
        System.out.println("2. Remove a book");
        System.out.println("3. Sell a book");
        System.out.println("4. List all books");
        System.out.println("5. Exit");
        System.out.println("----------------------");
        System.out.println("Enter your choice: ");

    }

    //----------------------------------------------------------------------------------------------
    // Add a book related methods

    public void addBook() {

        /*Method to add a book to the array
         * prompts the user for title if the title already exists asks for
         * author's name if both are same to the input, 1 copy is added
         * Or another book is created */

        System.out.println("Enter the name of the book: ");
        String name = scanner.next();

        for (Book book : books) {
            if (book != null && book.getBookTitle().equals(name)) {
                System.out.println("Enter the author of the book: ");
                String author = scanner.next();
                if (book.getAuthor().equals(author)) {
                    book.setNumberOfCopies(book.getNumberOfCopies() + 1);
                    System.out.println("Book copy added");
                } else {
                    setBookValues(name);
                }
                return;
            }
        }
        setBookValues(name);
        System.out.println("\nBook added!!\n");
    }

    public void setBookValues(String name){

        /*Method to set a book in the array after getting all
        * additional information
        * Just to hold redundant code*/

        System.out.println("Enter the author of the book: ");
        String author = scanner.next();
        System.out.println("Enter the genre of the book: ");
        String genre = scanner.next();
        System.out.println("Enter number of pages: ");
        int pages = scanner.nextInt();
        System.out.println("Enter the price of the book: ");
        float price = scanner.nextFloat();
        System.out.println("Enter number of copies of the book: ");
        int copies = scanner.nextInt();
        Book book = new Book(name,author, genre, pages, copies, price);
        books = addBookToArray(book);
    }

    public Book[] addBookToArray(Book book){
        /*Method to add a book to the array*/

        Book[] temp = new Book[books.length + 1]; // temporary array to hold the books
        System.arraycopy(books, 0, temp, 0, books.length); // copy the old array to the temporary array
        temp[temp.length - 1] = book; // add the new book to the temporary array (last index).
        return temp;
    }

    //----------------------------------------------------------------------------------------------

    public void removeBook(){
        /*Method to remove a book from the array
         * prompts the user for title if the title already exists asks for
         * author's name if both are same to the input, 1 copy is removed
         * Or another book is created */

        if(checkBooksLength()){
            System.out.println("Enter the name of the book: ");
            String name = scanner.next();
            System.out.println("Enter the author of the book: ");
            String author = scanner.next();

            for (Book book : books) {
                if (book != null && book.getBookTitle().equals(name) && book.getAuthor().equals(author)) {
                    books = removeBookFromArray(book);
                }
                else{
                    System.out.println("Book not found");
                }
            }

        }

    }

    public Book[] removeBookFromArray(Book book){
        /*Method to remove a book from the array*/

        Book[] temp = new Book[books.length - 1]; // temporary array to hold the books
        int index = 0;
        for (Book value : books) {
            if (value != book) {
                temp[index] = value; // copy the old value  to the temporary array
                index++;
            }
        }
        return temp;
    }

    //----------------------------------------------------------------------------------------------

    public void sellBook(){

        if(checkBooksLength()){
            System.out.println("Enter the name of the book: ");
            String name = scanner.next();
            System.out.println("Enter the author of the book: ");
            String author = scanner.next();

            for (Book book : books) {
                if (book != null && book.getBookTitle().equals(name) && book.getAuthor().equals(author)) {
                    if (book.getNumberOfCopies() > 0) {
                        book.setNumberOfCopies(book.getNumberOfCopies() - 1);
                    }
                    else{
                        books = removeBookFromArray(book);
                    }
                }
                else{
                    System.out.println("Book not found");
                }
            }
        }



    }

    //----------------------------------------------------------------------------------------------

    public void listBooks(){
        if (checkBooksLength()){
            System.out.println("\nList of books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    //----------------------------------------------------------------------------------------------

    public void exit(){
        System.out.println("Bye!");
        System.exit(1);
    }

    //----------------------------------------------------------------------------------------------

    public Boolean checkBooksLength(){
        if(books.length == 0) {
            System.out.println("No books in the the store yet");
            return false;
        }
        else{
            return true;
        }
    }
}
