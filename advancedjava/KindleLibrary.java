public class KindleLibrary implements BookFactory {

    @Override
    public Book newBook() {
        return new KindleBook();
    }
}

class KindleBook extends Book {

}