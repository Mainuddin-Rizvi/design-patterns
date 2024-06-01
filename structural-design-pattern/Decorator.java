public interface ChristmasTree {
    void decorate();
}

public class BasicChristmasTree implements ChristmasTree {
    @Override
    public void decorate() {
        System.out.println("Basic Christmas tree with lights and a star on top.");
    }
}


public class OrnamentDecorator implements ChristmasTree {
    private final ChristmasTree tree;

    public OrnamentDecorator(ChristmasTree tree) {
        this.tree = tree;
    }

    @Override
    public void decorate() {
        tree.decorate();
        System.out.println("Adding colorful ornaments.");
    }
}

public class LightsDecorator implements ChristmasTree {
    private final ChristmasTree tree;

    public LightsDecorator(ChristmasTree tree) {
        this.tree = tree;
    }

    @Override
    public void decorate() {
        tree.decorate();
        System.out.println("Stringing fairy lights around the tree.");
    }
}

public class Decorator{
    public static void main(String[] args) {
        // Create a basic Christmas tree
        ChristmasTree basicTree = new BasicChristmasTree();

        // Decorate the tree with ornaments and lights
        ChristmasTree decoratedTree = new LightsDecorator(new OrnamentDecorator(basicTree));

        // Display the final decorated tree
        decoratedTree.decorate();
    }
}

//The Decorator design pattern is a structural pattern that allows you to dynamically add functionality
//and behavior to an object without altering its structure. It’s particularly useful when you need to work
//with objects that form a tree-like hierarchy, where each node can be either a composite or a leaf node
