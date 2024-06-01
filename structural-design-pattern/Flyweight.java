// Vehicle interface
interface Vehicle {
    void start();
    void stop();
    String getColor();
}

// Concrete vehicle (Car)
class Car implements Vehicle {
    private final Engine engine;
    private final String color;

    public Car(Engine engine, String color) {
        this.engine = engine;
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println("Car started.");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }

    @Override
    public String getColor() {
        return color;
    }
}

// Vehicle factory
class VehicleFactory {
    private static final Map<String, Vehicle> vehiclesCache = new HashMap<>();

    public static Vehicle createVehicle(String color) {
        return vehiclesCache.computeIfAbsent(color, newColor -> new Car(new Engine(), newColor));
    }
}

// Example usage
public class Flyweight{
    public static void main(String[] args) {
        Vehicle redCar = VehicleFactory.createVehicle("Red");
        Vehicle blueCar = VehicleFactory.createVehicle("Blue");

        redCar.start();
        blueCar.stop();

        System.out.println("Red car color: " + redCar.getColor());
    }
}
