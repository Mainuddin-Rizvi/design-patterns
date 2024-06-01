class Singleton {
    private static Singleton instance;

    // Private constructor to prevent external instantiation
    private Singleton() {
        // Initialization code (if needed)
    }

    // Static method to get the instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Other methods and attributes (if any)
}

public class SingletonPattern {
    public static void main(String[] args) {
        // Get the instance of Singleton multiple times
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        // Check if both references point to the same instance
        if (instance1 == instance2) {
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("Instances are different.");
        }

        // Example of additional methods or attributes in Singleton
        // instance1.someMethod();
    }
}

//Example we want to create only single databasse connection
