package data.structure.list.linked;

/**
 * Chained node which contains exactly one element as key and one successor node.
 *
 * @param <E> the type of the key
 *
 * @author Nhan Huynh
 * @version 1.0.0
 */
public class Node<E> {

    /**
     * Common instance for {@code nil()}.
     *
     * @see #nil()
     */
    private static final Node<?> NIL = new Node<>();

    /**
     * The key value of this node.
     */
    private E key;

    /**
     * The successor node of this node.
     */
    private Node<E> next;

    /**
     * Constructs a chained node.
     */
    private Node() {
        this(null, null);
    }

    /**
     * Constructs a chained node with a key
     *
     * @param key the key value
     */
    public Node(final E key) {
        this(key, nil());
    }

    /**
     * Constructs a chained node with a key and its successor node.
     *
     * @param key  the key value
     * @param next the successor node
     */
    public Node(final E key, final Node<E> next) {
        this.key = key;
        this.next = next;
    }

    /**
     * Returns the sentinel node which is used to avoid {@code NullPointerException}. The sentinel node is an empty node
     * without an element and its successor points to itself.
     *
     * @param <E> type of the node
     *
     * @return the sentinel node
     */
    @SuppressWarnings("unchecked")
    public static <E> Node<E> nil() {
        final Node<E> node = (Node<E>) NIL;
        node.setNext(node);
        return node;
    }

    /**
     * Returns the key value of this node.
     *
     * @return the key of this node
     */
    public E key() {
        return key;
    }

    /**
     * Registers the key value of this node.
     *
     * @param key the key value
     */
    public void setKey(final E key) {
        this.key = key;
    }

    /**
     * Returns the successor node of this node.
     *
     * @return the successor node of this node
     */
    public Node<E> next() {
        return next;
    }

    /**
     * Registers the successor node of this node.
     *
     * @param next the successor node
     */
    public void setNext(final Node<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this == NIL ? "nil" : String.valueOf(key());
    }
}
