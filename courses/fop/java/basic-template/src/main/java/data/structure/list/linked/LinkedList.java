package data.structure.list.linked;

import data.structure.list.List;

import java.util.Iterator;

/**
 * Simple-linked list implementation of the {@code List} interface. More formally the list is represented as a linked
 * node, each with exactly one element as key value and one successor node.
 *
 * @param <E> type of the element in this list
 *
 * @author Nhan Huynh
 * @version 1.0.0
 * @see List
 * @see Node
 */
public class LinkedList<E> implements List<E> {

    /**
     * The sentinel node which represents the end of this list.
     *
     * @see Node#nil()
     */
    private final Node<E> nil;

    /**
     * The head node which represents the head of the list.
     */
    private final Node<E> head;

    /**
     * Constructs an empty list.
     */
    public LinkedList() {
        this.nil = Node.nil();
        this.head = nil;
    }

    @Override
    public void add(final E e) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public boolean addAll(final List<? extends E> l) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public boolean addAll(final int index, final List<? extends E> l) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public boolean contains(final Object o) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public boolean containsAll(final List<?> l) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public E remove(final int index) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public boolean remove(final Object o) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public boolean removeAll(final List<?> l) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final String leftBracket = "[";
        final String rightBracket = "]";
        final String arrow = " -> ";
        sb.append(leftBracket);
        for (Node<E> p = head; p != nil; p = p.next()) {
            sb.append(p).append(arrow);
        }
        sb.append(nil.toString());
        sb.append(rightBracket);
        return sb.toString();
    }
}
