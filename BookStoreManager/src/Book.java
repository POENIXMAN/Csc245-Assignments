
/* A class to display the book information */

class Book{
    protected String title, author, genre;
    protected int numberOfPages, numberOfCopies;
    protected float bookPrice;

    //constructor
    public Book(String bookTitle, String bookAuthor, String bookGenre, int bookPages, int bookCopies, float price){
        title = bookTitle;
        author = bookAuthor;
        genre = bookGenre;
        numberOfPages = bookPages;
        numberOfCopies = bookCopies;
        bookPrice = price;
    }


    //setters
    public void setBookTitle(String bookTitle){
        title = bookTitle;
    }

    public void setAuthor(String bookAuthor){
        author = bookAuthor;
    }

    public void setGenre(String bookGenre){
        genre = bookGenre;
    }

    public void setNumberOfPages(int bookPages){
        numberOfPages = bookPages;
    }

    public void setNumberOfCopies(int bookCopies){
        numberOfCopies = bookCopies;
    }

    public void setBookPrice(float price){
        bookPrice = price;
    }

    //getters
    public String getBookTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getGenre(){
        return genre;
    }

    public int getNumberOfPages(){
        return numberOfPages;
    }

    public int getNumberOfCopies(){
        return numberOfCopies;
    }

    public float getBookPrice(){
        return bookPrice;
    }


    //method to display book information
    @Override
    public String toString() {
        return "\nThe book title is: " + getBookTitle() +
                "\nThe author is: " + getAuthor() + "\nThe genre is: " +
                getGenre() +
                "\nThe number of pages is: " + getNumberOfPages()
                + "\nThe number of copies is: " + getNumberOfCopies() +
                "\nThe book price is: " + getBookPrice() + "$\n";
    }
}
