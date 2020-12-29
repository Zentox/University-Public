package data.structure.list;

import java.util.Iterator;

/**
 * An ordered collection (also known as a <i>sequence</i>). The user of this interface has precise control over where in
 * the list each element is inserted.  The user can access elements by their integer index (position in the list), and
 * search for elements in the list.
 * <p>
 * Unlike sets, lists typically allow duplicate elements but the elements must be not null.
 *
 * @param <E> type of the element in this list
 *
 * @author Nhan Huynh
 * @version 1.0.0
 * @see data.structure.list.linked.LinkedList
 */
public interface List<E> extends Iterable<E> {

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     *
     * @throws NullPointerException          if the specified element is null
     * @throws UnsupportedOperationException if the method is not implemented
     */
    void add(E e);

    /**
     * Appends all of the elements in the specified list to the end of this list.The behavior of this operation is
     * undefined if the specified list is modified while the operation is in progress. (Note that this will occur if the
     * specified list is this list, and it's nonempty.)
     *
     * @param l list containing elements to be added to this list
     *
     * @return {@code true} if this list changed as a result of the call
     *
     * @throws NullPointerException          if the specified list contains one or more null elements
     * @throws UnsupportedOperationException if the method is not implemented
     * @see #add(Object)
     * @see #iterator()
     */
    boolean addAll(List<? extends E> l);

    /**
     * Inserts all of the elements in the specified list into this list at the specified position. Shifts the element
     * currently at that position (if any) and any subsequent elements to the right (increases their indices). The
     * behavior of this operation is undefined if the specified list is modified while the operation is in progress.
     * (Note that this will occur if the specified list is this list, and it's nonempty.)
     *
     * @param index index at which to insert the first element from the specified list
     * @param l     list containing elements to be added to this list
     *
     * @return {@code true} if this list changed as a result of the call list prevents it from being added to this list
     *
     * @throws IndexOutOfBoundsException     if the index is out of range ({@code index < 0 || index > size()})
     * @throws NullPointerException          if the specified list contains one or more null elements
     * @throws UnsupportedOperationException if the method is not implemented
     */
    boolean addAll(int index, List<? extends E> l);

    /**
     * Returns {@code true} if this list contains the specified element. More formally, returns {@code true} if and only
     * if this list contains at least one element {@code e} such that {@code Objects.equals(o, e)}.
     *
     * @param o element whose presence in this list is to be tested
     *
     * @return {@code true} if this list contains the specified element
     *
     * @throws ClassCastException            if the type of the specified element is incompatible with this list
     * @throws NullPointerException          if the specified element is null
     * @throws UnsupportedOperationException if the method is not implemented
     */
    boolean contains(Object o);

    /**
     * Returns {@code true} if this list contains all of the elements of the specified list.
     *
     * @param l list to be checked for containment in this list
     *
     * @return {@code true} if this list contains all of the elements of the specified list
     *
     * @throws ClassCastException            if the types of one or more elements in the specified list are incompatible
     *                                       with this list
     * @throws NullPointerException          if the specified list contains one or more null elements or if the
     *                                       specified list is null
     * @throws UnsupportedOperationException if the method is not implemented
     * @see #contains(Object)
     * @see #iterator()
     */
    boolean containsAll(List<?> l);

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     *
     * @throws UnsupportedOperationException if the method is not implemented
     */
    void clear();

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     *
     * @throws UnsupportedOperationException if the method is not implemented
     */
    boolean isEmpty();

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     *
     * @throws UnsupportedOperationException if the method is not implemented
     * @see Iterable
     */
    Iterator<E> iterator();

    /**
     * Returns the number of elements in this list.  If this list contains more than {@code Integer.MAX_VALUE} elements,
     * returns {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this list
     *
     * @throws UnsupportedOperationException if the method is not implemented
     */
    int size();

    /**
     * Returns an array containing all of the elements in this list in proper sequence (from first to last element).
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this list.  (In other words, this method must allocate a new array even if this list is backed by
     * an array). The caller is thus free to modify the returned array.
     *
     * @return an array containing all of the elements in this list in proper sequence
     *
     * @throws UnsupportedOperationException if the method is not implemented
     */
    Object[] toArray();

    /**
     * Returns an array containing all of the elements in this list in proper sequence (from first to last element); the
     * runtime type of the returned array is that of the specified array.  If the list fits in the specified array, it
     * is returned therein.  Otherwise, a new array is allocated with the runtime type of the specified array and the
     * size of this list.
     *
     * <p>If the list fits in the specified array with room to spare (i.e.,
     * the array has more elements than the list), the element in the array immediately following the end of the list is
     * set to {@code null}. (This is useful in determining the length of the list <i>only</i> if the caller knows that
     * the list does not contain any null elements.)
     *
     * @param a   the array into which the elements of this list are to be stored, if it is big enough; otherwise, a new
     *            array of the same runtime type is allocated for this purpose.
     * @param <T> type of the elements in that the array stores
     *
     * @return an array containing the elements of this list
     *
     * @throws ArrayStoreException           if the runtime type of the specified array is not a supertype of the
     *                                       runtime type of every element in this list
     * @throws NullPointerException          if the specified array is null
     * @throws UnsupportedOperationException if the method is not implemented
     * @see Object
     * @see java.lang.reflect.Array#newInstance(Class, int)
     */
    <T> T[] toArray(T[] a);
}
