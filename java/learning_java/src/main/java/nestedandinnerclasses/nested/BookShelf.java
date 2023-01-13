package nestedandinnerclasses.nested;

public class BookShelf {
    public static void main(String[] args) {

        BookList shelf = new BookList();
        shelf.add(new Book("Harry Potter"));
        shelf.add(new Book("Around the World in 80 Days"));
        shelf.add(new Book("Count of Monte Cristo"));
        shelf.add(new Book("Jataka Tales"));
        shelf.add(new Book("Aesop's Fables"));

        System.out.println(shelf);
    }
}
