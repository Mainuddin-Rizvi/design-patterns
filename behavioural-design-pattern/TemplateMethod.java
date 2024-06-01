// Abstract Class
abstract class Beverage {
    // Template method
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Concrete method
    private void boilWater() {
        System.out.println("Boiling water");
    }

    // Concrete method
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Abstract methods
    protected abstract void brew();
    protected abstract void addCondiments();
}

// Concrete Class for Tea
class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}

// Concrete Class for Coffee
class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

// Client
public class TemplateMethod{
    public static void main(String[] args) {
        Beverage tea = new Tea();
        tea.prepareRecipe();

        System.out.println();

        Beverage coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
