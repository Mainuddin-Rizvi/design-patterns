// Visitor Interface
interface Visitor {
    void visit(Book book);
    void visit(Electronic electronic);
}

// Concrete Visitor Class
class DiscountVisitor implements Visitor {
    @Override
    public void visit(Book book) {
        System.out.println("Applying discount to book: " + book.getTitle());
        // Apply discount logic for book
    }

    @Override
    public void visit(Electronic electronic) {
        System.out.println("Applying discount to electronic: " + electronic.getName());
        // Apply discount logic for electronic
    }
}

// Element Interface
interface Item {
    void accept(Visitor visitor);
}

// Concrete Element Class for Book
class Book implements Item {
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Concrete Element Class for Electronic
class Electronic implements Item {
    private String name;
    private double price;

    public Electronic(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Client
public class Visitor{
    public static void main(String[] args) {
        Item book = new Book("Design Patterns", 20.0);
        Item electronic = new Electronic("Smartphone", 100.0);

        Visitor discountVisitor = new DiscountVisitor();

        book.accept(discountVisitor);
        electronic.accept(discountVisitor);
    }
}
