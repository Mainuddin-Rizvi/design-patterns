public interface Color {
    String fill();
}


public class Blue implements Color {
    @Override
    public String fill() {
        return "Color is Blue";
    }
}


public abstract class Shape {
    protected Color color; // Reference to the Color object

    // Standard constructors

    abstract public String draw();
}


public class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Square drawn. " + color.fill();
    }
}

public class Bridge{
    public static void main(String[] args) {
        // Create a square with red color
        Shape square = new Square(new Red());
        System.out.println(square.draw());
    }
}
