package fop.w8trees;
import java.util.Comparator;
import java.util.function.Predicate;

public class Tree<T> {
    private TreeElement<T> root;
    private Comparator<T> comp;

    public Tree(Comparator<T> comp) {
        this.root = new Leaf<T>();
        this.comp = comp;
    }

    public void insert(T value) {
        this.root = this.root.insert(value, this.comp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.root.toString(sb);
        return sb.toString();
    }

    public int size() {
        return this.root.size();
    }

    public void remove(T value) {
        this.root = this.root.remove(value, this.comp);
    }

    public boolean contains(T value) {
        return this.root.contains(value, this.comp);
    }

    public int countMatches(Predicate<T> filter) {
        return this.root.countMatches(filter);
    }

    public T[] getAll(Predicate<T> filter) {
        // Generics and Arrays don't get along very well
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[countMatches(filter)];
        this.root.getAll(filter, array, 0);
        return array;
    }
}
