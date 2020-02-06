public class Library implements BookFactory {
    @Override
    public Book newBook() {
        return new PaperBook();
    }
}

class PaperBook extends Book {

}