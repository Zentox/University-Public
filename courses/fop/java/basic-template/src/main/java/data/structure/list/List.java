package data.structure.list;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

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
     * @see Iterator
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
     * @see Iterator
     */
    boolean containsAll(List<?> l);

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     *
     * @throws UnsupportedOperationException if the method is not implemented
     */
    void clear();

    /**
     * Compares the specified object with this list for equality.  Returns {@code true} if and only if the specified
     * object is also a list, both lists have the same size, and all corresponding pairs of elements in the two lists
     * are <i>equal</i>.  (Two elements {@code e1} and {@code e2} are <i>equal</i> if {@code Objects.equals(e1, e2)}.)
     * In other words, two lists are defined to be equal if they contain the same elements in the same order.  This
     * definition ensures that the equals method works properly across different implementations of the {@code List}
     * interface.
     *
     * @param o the object to be compared for equality with this list
     *
     * @return {@code true} if the specified object is equal to this list
     */
    boolean equals(Object o);

    /**
     * Returns the hash code value for this list.  The hash code of a list is defined to be the result of the following
     * calculation:
     * <pre>{@code
     *     int hashCode = 1;
     *     for (E e : list)
     *         hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
     * }</pre>
     * This ensures that {@code list1.equals(list2)} implies that {@code list1.hashCode()==list2.hashCode()} for any two
     * lists, {@code list1} and {@code list2}, as required by the general contract of {@link Object#hashCode}.
     *
     * @return the hash code value for this list
     *
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    int hashCode();

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     *
     * @return the element at the specified position in this list
     *
     * @throws IndexOutOfBoundsException     if the index is out of range ({@code index < 0 || index >= size()})
     * @throws UnsupportedOperationException if the method is not implemented
     */
    E get(int index);

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not
     * contain the element. More formally, returns the lowest index {@code i} such that {@code Objects.equals(o,
     * get(i))}, or -1 if there is no such index.
     *
     * @param o element to search for
     *
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not
     *         contain the element
     *
     * @throws ClassCastException            if the type of the specified element is incompatible with this list
     * @throws NullPointerException          if the specified element is null
     * @throws UnsupportedOperationException if the method is not implemented
     */
    int indexOf(Object o);

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
     * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not
     * contain the element. More formally, returns the highest index {@code i} such that {@code Objects.equals(o,
     * get(i))}, or -1 if there is no such index.
     *
     * @param o element to search for
     *
     * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not
     *         contain the element
     *
     * @throws ClassCastException            if the type of the specified element is incompatible with this list
     * @throws NullPointerException          if the specified element is null
     * @throws UnsupportedOperationException if the method is not implemented
     */
    int lastIndexOf(Object o);

    /**
     * Removes the element at the specified position in this list.  Shifts any subsequent elements to the left
     * (subtracts one from their indices).  Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     *
     * @return the element previously at the specified position
     *
     * @throws UnsupportedOperationException if the method is not implemented
     * @throws IndexOutOfBoundsException     if the index is out of range ({@code index < 0 || index >= size()})
     */
    E remove(int index);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.  If this list does not
     * contain the element, it is unchanged.  More formally, removes the element with the lowest index {@code i} such
     * that {@code Objects.equals(o, get(i))} (if such an element exists).  Returns {@code true} if this list contained
     * the specified element (or equivalently, if this list changed as a result of the call).
     *
     * @param o element to be removed from this list, if present
     *
     * @return {@code true} if this list contained the specified element
     *
     * @throws ClassCastException            if the type of the specified element is incompatible with this list
     * @throws NullPointerException          if the specified element is null
     * @throws UnsupportedOperationException if the method is not implemented
     */
    boolean remove(Object o);

    /**
     * Removes from this list all of its elements that are contained in the specified list
     *
     * @param l list containing elements to be removed from this list
     *
     * @return {@code true} if this list changed as a result of the call
     *
     * @throws ClassCastException            if the class of an element of this list is incompatible with the specified
     *                                       list
     * @throws NullPointerException          if this list contains a null element
     * @throws UnsupportedOperationException if the method is not implemented
     * @see #remove(Object)
     * @see #contains(Object)
     * @see Iterator
     */
    boolean removeAll(List<?> l);

    /**
     * Removes all of the elements of this list that satisfy the given predicate.  Errors or runtime exceptions
     * thrown during iteration or by the predicate are relayed to the caller.
     *
     * @param filter a predicate which returns {@code true} for elements to be removed
     *
     * @return {@code true} if any elements were removed
     *
     * @throws NullPointerException          if the specified filter is null
     * @throws UnsupportedOperationException if the method is not implemented
     */
    boolean removeIf(Predicate<? super E> filter);

    /**
     * Replaces each element of this list with the result of applying the operator to that element. Errors or runtime
     * exceptions thrown by the operator are relayed to the caller.
     *
     * @param operator the operator to apply to each element
     *
     * @throws NullPointerException          if the specified operator is null or if the operator result is a null
     *                                       value
     * @throws UnsupportedOperationException if the method is not implemented
     * @see Iterator
     */
    void replaceAll(UnaryOperator<E> operator);

    /**
     * Retains only the elements in this list that are contained in the specified list.  In other words, removes from
     * this list all of its elements that are not contained in the specified list.
     *
     * @param l list containing elements to be retained in this list
     *
     * @return {@code true} if this list changed as a result of the call
     *
     * @throws ClassCastException            if the class of an element of this list is incompatible with the specified
     *                                       list
     * @throws NullPointerException          if this list contains a null element
     * @throws UnsupportedOperationException if the method is not implemented
     * @see #contains(Object)
     */
    boolean retainAll(List<?> l);
    
    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     *
     * @return the element previously at the specified position list
     *
     * @throws NullPointerException          if the specified element is null
     * @throws IndexOutOfBoundsException     if the index is out of range ({@code index < 0 || index >= size()})
     * @throws UnsupportedOperationException if the method is not implemented
     */
    E set(int index, E element);

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
     * Sorts this list according to the order induced by the specified {@link Comparator}.  The sort is <i>stable</i>:
     * this method must not reorder equal elements.
     *
     * <p>All elements in this list must be <i>mutually comparable</i> using the
     * specified comparator (that is, {@code c.compare(e1, e2)} must not throw a {@code ClassCastException} for any
     * elements {@code e1} and {@code e2} in the list).
     *
     * <p>If the specified comparator is {@code null} then all elements in this
     * list must implement the {@link Comparable} interface and the elements' {@linkplain Comparable natural ordering}
     * should be used.
     *
     * @param c the {@code Comparator} used to compare list elements. A {@code null} value indicates that the elements'
     *          {@linkplain Comparable natural ordering} should be used
     *
     * @throws ClassCastException            if the list contains elements that are not
     *                                       <i>mutually comparable</i> using the specified comparator
     * @throws IllegalArgumentException      if the comparator is found to violate the {@link Comparator} contract
     * @throws UnsupportedOperationException if the method is not implemented
     */
    void sort(Comparator<? super E> c);

    /**
     * Returns a view of the portion of this list between the specified {@code fromIndex}, inclusive, and {@code
     * toIndex}, exclusive.  (If {@code fromIndex} and {@code toIndex} are equal, the returned list is empty.)  The
     * returned list is backed by this list, so non-structural changes in the returned list are reflected in this list,
     * and vice-versa.
     * <p>
     * The semantics of the list returned by this method become undefined if the backing list (i.e., this list) is
     * <i>structurally modified</i> in any way other than via the returned list.  (Structural modifications are those
     * that change the size of this list, or otherwise perturb it in such a fashion that iterations in progress may
     * yield incorrect results.)
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex   high endpoint (exclusive) of the subList
     *
     * @return a view of the specified range within this list
     *
     * @throws IndexOutOfBoundsException     for an illegal endpoint index value ({@code fromIndex < 0 || toIndex > size
     *                                       || fromIndex > toIndex})
     * @throws UnsupportedOperationException if the method is not implemented
     */
    List<E> subList(int fromIndex, int toIndex);

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
