package fop.w8trees;

import java.util.Comparator;
import java.util.function.Predicate;

public class InnerNode<T> implements TreeElement<T> {

    private T value;
    private TreeElement<T> left;
    private TreeElement<T> right;

    public InnerNode(T value) {
        this.value = value;
        this.left = new Leaf<T>();
        this.right = new Leaf<T>();
    }

    @Override
    public TreeElement<T> insert(T value, Comparator<T> comp) {
        if (comp.compare(value, this.value) < 0) { // value < this.value
            this.left = this.left.insert(value, comp);
        } else {
            this.right = this.right.insert(value, comp);
        }
        return this;
    }

    @Override
    public void toString(StringBuilder sb) {
        sb.append("(");
        this.left.toString(sb);
        sb.append(this.value);
        this.right.toString(sb);
        sb.append(")");
    }

    @Override
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }

    @Override
    public T getMin() {
        return this.left.getMin();
    }

    @Override
    public TreeElement<T> remove(T value, Comparator<T> comp) {
        if (comp.compare(value, this.value) < 0) { // value < this.value
            this.left = this.left.remove(value, comp);
        } else if (comp.compare(value, this.value) > 0) { // value > this.value
            this.right = this.right.remove(value, comp);
        } else {
            if (this.left.size() == 0) {
                return this.right;
            } else if (this.right.size() == 0) {
                return this.left;
            } else {
                this.value = this.right.getMin();
                this.right = this.right.remove(this.value, comp);
            }
        }
        return this;
    }

    @Override
    public boolean contains(T value, Comparator<T> comp) {
        if (comp.compare(value, this.value) < 0) { // value < this.value
            return this.left.contains(value, comp);
        } else if (comp.compare(value, this.value) > 0) { // value > this.value
            return this.right.contains(value, comp);
        } else {
            return true;
        }
    }

    @Override
    public int countMatches(Predicate<T> filter) {
        return (filter.test(this.value) ? 1 : 0) + this.left.countMatches(filter) + this.right.countMatches(filter);
    }

    @Override
    public int getAll(Predicate<T> filter, T[] array, int index) {
        if (filter.test(this.value)) {
            array[index++] = this.value;
        }
        index = this.left.getAll(filter, array, index);
        index = this.right.getAll(filter, array, index);
        return index;
    }
}
