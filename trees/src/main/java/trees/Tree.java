package trees;

import java.util.*;
import java.util.Collection;
import java.util.stream.Collectors;

public class Tree<T> {

    private Collection<Tree<T>> children = new HashSet<>();
    private Tree<T> parent = null;
    private T data;

    public Tree(T data) {
        this.setData(data);
    }

    public Tree(T data, Collection<Tree<T>> children) {
        this(data);
        addChildren(children);
    }

    public Tree(T data, Tree<T> parent) {
        if (parent == null) {
            throw new NullPointerException("Parent cannot be null");
        }
        setData(data);
        parent.addChild(this);
    }

    public Tree(T data, Tree<T> parent, Collection<Tree<T>> children) {
        this(data, parent);
        addChildren(children);
    }

    public Tree<T>  addChild(T data) {
        Tree<T> child = new Tree<>(data);
        addChild(child);
        return child;
    }

    public void addChild(Tree<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChildren(Collection<Tree<T>> children) {
        children.forEach((child) -> this.addChild(child));
    }

    public void addChildren2(List<T> dataList) {
        addChildren(dataList.stream().map(d -> newNode(this, d)).collect(Collectors.toList()));
    }

    private <T> Tree<T> newNode(Tree<T> parent, T data) {
        final Tree<T> result = new Tree<>(data);
        return result;
    }

    public Collection<Tree<T>> getChildren() {
        return Collections.unmodifiableCollection(this.children);
    }

    public int getChildrenCount() {
        return this.children.size();
    }

    public void removeChild(Tree<T> child) {
        if (child == null) {
            throw new NullPointerException("Child cannot be null");
        }
        if (!this.children.contains(child)) {
            throw new RuntimeException("Tree " + child + " is not a child of " + this);
        }
        this.children.remove(child);
    }

    private void setParent(Tree<T> parent) {
        if (parent == null) {
            throw new NullPointerException("Parent cannot be null");
        }
        this.parent = parent;
    }

    public Tree<T> getParent() {
        return this.parent;
    }

    public void removeParent() {
        if (this.parent == null) {
            throw new NullPointerException("Tree " + this + " has no parent");
        }
        this.parent.removeChild(this);
        this.parent = null;
    }

    private void setData(T data) {
        if (data == null) {
            throw new NullPointerException("Data cannot be null");
        }
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return (this.children.size() == 0);
    }

    @Override
    public String toString() {
        String returnString = "<" + this.data;
        for(Tree<T> child : children) {
            returnString += child.toString();
        }
        returnString += ">";
        return returnString;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tree)) {
            return false;
        }
        final Tree<T> that = (Tree<T>) other;
        return this.getData().equals(that.getData());
    }

    @Override
    public int hashCode() {
        return getData().hashCode();
    }

}
