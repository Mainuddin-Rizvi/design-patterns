import java.util.ArrayList;
import java.util.List;

// Item class
class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Iterator Interface
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Concrete Iterator Class
class ItemIterator implements Iterator<Item> {
    private List<Item> items;
    private int position = 0;

    public ItemIterator(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public Item next() {
        if (this.hasNext()) {
            return items.get(position++);
        }
        return null;
    }
}

// Aggregate Interface
interface Aggregate<T> {
    Iterator<T> createIterator();
}

// Concrete Aggregate Class
class ItemCollection implements Aggregate<Item> {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public Iterator<Item> createIterator() {
        return new ItemIterator(items);
    }
}

// Client
public class Iterator {
    public static void main(String[] args) {
        // Create collection
        ItemCollection itemCollection = new ItemCollection();
        itemCollection.addItem(new Item("Item 1"));
        itemCollection.addItem(new Item("Item 2"));
        itemCollection.addItem(new Item("Item 3"));

        // Create iterator
        Iterator<Item> iterator = itemCollection.createIterator();

        // Traverse the collection
        while (iterator.hasNext()) {
            Item item = iterator.next();
            System.out.println("Item: " + item.getName());
        }
    }
}
