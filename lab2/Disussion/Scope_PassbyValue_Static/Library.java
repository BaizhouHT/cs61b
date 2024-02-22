package Disussion.Scope_PassbyValue_Static;

class Library {
    public Book[] books;
    public int index;
    public static int totalBooks = 0;
    public Library(int size) {// 分配boxes
        books = new Book[size];
        index = 0;
    }
    public void addBook(Book book) {// static will cause compile error
        books[index] = book;
        index++;
        totalBooks++;
        book.library = this;
    }
}

