package nestedandinnerclasses.nested;

public class BookList {

    private BookNode list;

    public BookList() {
        list = null;
    }

    public void add(Book book) {
        BookNode node = new BookNode(book);
        BookNode tmpnode;
        if (list == null)
            list = node;
        else {
            tmpnode = list;
            while (tmpnode.next != null)
                tmpnode = tmpnode.next;
            tmpnode.next = node;
        }
    }

    public String toString() {
        String str = "";
        BookNode tmpnode = list;
        while (tmpnode != null) {
            str += tmpnode.book + "n";
            tmpnode = tmpnode.next;
        }
        return str;
    }

    // BookNode is a inner class
    private class BookNode {
        public Book book;
        public BookNode next;

        public BookNode(Book book) {
            this.book = book;
            next = null;
        }
    }
}
