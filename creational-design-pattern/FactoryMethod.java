// The Product interface defines the operations that all concrete products must implement.
interface Product {
    void use();
}

// ConcreteProductA is a specific implementation of the Product interface.
class ConcreteProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using Product A");
    }
}

// ConcreteProductB is another specific implementation of the Product interface.
class ConcreteProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using Product B");
    }
}

// The Creator class declares the factory method that returns an object of type Product.
abstract class Creator {
    // The factory method that subclasses will implement to create specific products.
    public abstract Product factoryMethod();

    // An operation that uses the factory method to create a product and then uses it.
    public void doSomething() {
        Product product = factoryMethod();
        product.use();
    }
}

// ConcreteCreatorA overrides the factory method to create and return a ConcreteProductA.
class ConcreteCreatorA extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

// ConcreteCreatorB overrides the factory method to create and return a ConcreteProductB.
class ConcreteCreatorB extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

// The Client class uses the Creator to create products.
public class FactoryMethod {
    public static void main(String[] args) {
        // Create a creator for Product A
        Creator creatorA = new ConcreteCreatorA();
        creatorA.doSomething(); // Outputs: Using Product A

        // Create a creator for Product B
        Creator creatorB = new ConcreteCreatorB();
        creatorB.doSomething(); // Outputs: Using Product B
    }
}
