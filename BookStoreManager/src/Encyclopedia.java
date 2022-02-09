public class Encyclopedia extends Book {

    private int numOfVolumes;

    public Encyclopedia(String bookTitle, String bookAuthor, String bookGenre, int bookPages,
                        int bookCopies, float price) {
        super(bookTitle, bookAuthor, bookGenre, bookPages, bookCopies, price);

    }

    //toString
    public String toString() {
        String TYPE = "E";
        return super.toString() + "'" + TYPE + "'";
    }
}
