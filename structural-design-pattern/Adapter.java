// Adaptee (incompatible interface)
class Adaptee {
    void specificRequest() {
        System.out.println("Adaptee: Executing specific request.");
        // Some specific logic here
    }
}


// Target interface
interface Target {
    void request();
}


// Adapter
class ObjectAdapter implements Target {
    private final Adaptee adaptee;

    ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        System.out.println("Adapter: Calling specificRequest from Adaptee.");
        adaptee.specificRequest();
    }
}


public class Adapter{
    public static void main(String[] args) {
        // Create an instance of Adaptee
        Adaptee adaptee = new Adaptee();

        // Create an ObjectAdapter
        Target adapter = new ObjectAdapter(adaptee);

        // Call the request method (which internally calls specificRequest)
        adapter.request();
    }
}
