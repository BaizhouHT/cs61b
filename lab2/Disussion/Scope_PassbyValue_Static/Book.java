package Disussion.Scope_PassbyValue_Static;

class Book {
    public String title;
    public Library library;
    public static Book last = null;
    public Book(String name) {// constructor
        title = name;
        last = this;
        library = null;
    }
    public static String lastBookTitle() {
        return last.title;
    }

    public static String testdd() {
        return "dasd";
    }
    public String getTitle() {
        return title;
    }
}


