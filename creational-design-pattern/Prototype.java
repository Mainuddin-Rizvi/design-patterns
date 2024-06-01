public abstract class Tree {
    // Common properties for all trees (e.g., mass, height, position)

    public abstract Tree copy();
}

public class PlasticTree extends Tree {
    private double mass;
    private double height;
    private String position;

    public PlasticTree(double mass, double height) {
        this.mass = mass;
        this.height = height;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public Tree copy() {
        PlasticTree plasticTreeClone = new PlasticTree(this.mass, this.height);
        plasticTreeClone.setPosition(this.position);
        return plasticTreeClone;
    }
}

public class PineTree extends Tree {
    private double mass;
    private double height;
    private String position;

    public PineTree(double mass, double height) {
        this.mass = mass;
        this.height = height;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public Tree copy() {
        PineTree pineTreeClone = new PineTree(this.mass, this.height);
        pineTreeClone.setPosition(this.position);
        return pineTreeClone;
    }
}

public class Prototype {
    public static void main(String[] args) {
        // Create prototype trees
        PlasticTree plasticTreePrototype = new PlasticTree(10.0, 5.0);
        PineTree pineTreePrototype = new PineTree(15.0, 8.0);

        // Clone trees
        Tree clonedPlasticTree = plasticTreePrototype.copy();
        clonedPlasticTree.setPosition("Near the entrance");

        Tree clonedPineTree = pineTreePrototype.copy();
        clonedPineTree.setPosition("In the garden");

        // Use the cloned trees
        System.out.println("Plastic tree position: " + clonedPlasticTree.getPosition());
        System.out.println("Pine tree position: " + clonedPineTree.getPosition());
    }
}
