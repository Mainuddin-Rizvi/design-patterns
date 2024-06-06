// The Product class represents the complex object to be created.
class Product {
    private String partA;
    private String partB;
    private String partC;

    // Private constructor to force the use of the Builder
    private Product(Builder builder) {
        this.partA = builder.partA;
        this.partB = builder.partB;
        this.partC = builder.partC;
    }

    @Override
    public String toString() {
        return "Product [partA=" + partA + ", partB=" + partB + ", partC=" + partC + "]";
    }

    // Static Builder class nested within the Product class.
    public static class Builder {
        private String partA;
        private String partB;
        private String partC;

        // Methods to set each part of the Product. Returns the Builder object for chaining.
        public Builder setPartA(String partA) {
            this.partA = partA;
            return this;
        }

        public Builder setPartB(String partB) {
            this.partB = partB;
            return this;
        }

        public Builder setPartC(String partC) {
            this.partC = partC;
            return this;
        }

        // The build method constructs the final Product object.
        public Product build() {
            return new Product(this);
        }
    }
}

// The Client class demonstrates how to use the Builder pattern.
public class Builder {
    public static void main(String[] args) {
        // Using the builder to create a Product object.
        Product product = new Product.Builder()
                .setPartA("Part A")
                .setPartB("Part B")
                .setPartC("Part C")
                .build();

        // Output the product details.
        System.out.println(product); // Outputs: Product [partA=Part A, partB=Part B, partC=Part C]

        // Create another Product with different parts.
        Product anotherProduct = new Product.Builder()
                .setPartA("Different Part A")
                .setPartC("Different Part C")
                .build();

        // Output the details of the other product.
        System.out.println(anotherProduct); // Outputs: Product [partA=Different Part A, partB=null, partC=Different Part C]
    }
}
