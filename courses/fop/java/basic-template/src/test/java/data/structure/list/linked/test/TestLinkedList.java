package data.structure.list.linked.test;

import data.structure.list.List;
import data.structure.list.linked.LinkedList;
import data.structure.list.linked.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import resources.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Test cases for the class {@code LinkedList}.
 *
 * @author Nhan Huynh
 * @version 1.0.0
 * @see data.structure.list.linked.LinkedList
 */
@DisplayName("Test: LinkedList")
@TestMethodOrder(MethodOrderer.MethodName.class)
final class TestLinkedList {

    /**
     * Root path to the linked list resources.
     */
    private static final String PATH_TEST_SOURCE = "list/linked/";

    /**
     * Path to the input files for creating linked lists.
     */
    private static final String PATH_TEST_INPUT = String.format("%s%s%s", Resources.TEST_DIRECTORY, PATH_TEST_SOURCE, "input/");

    /**
     * The name of the field containing the head of the list.
     */
    private static final String HEAD_NAME = "head";

    /**
     * The name of the field containing the sentinel node of the list.
     */
    private static final String NIL_NAME = "nil";

    /**
     * The linked list used in test cases.
     */
    private LinkedList<String> list;

    /**
     * The head of the list {@code list}.
     */
    private Node<String> head;

    /**
     * The sentinel node of the list {@code list}.
     */
    private Node<String> nil;

    /**
     * Checks if the nil does not change after each test case.
     */
    @AfterEach
    void checkNil() {
        final Node<String> nil = getNil(list);
        if (nil == null) {
            return;
        }
        Assertions.assertSame(this.nil, nil, "The sentinel node has changed.");
        Assertions.assertSame(this.nil, nil.next(), "The successor node of the sentinel node should reference itself.");
        Assertions.assertNull(nil.key(), "The sentinel node does not have a key.");
    }

    /**
     * Returns the head of the list {@code list}. If the head cannot be accesses, the test will automatically fail.
     *
     * @param l the list with its head node
     *
     * @return the head of the list {@code list}
     */
    @SuppressWarnings("unchecked")
    private Node<String> getHead(final LinkedList<String> l) {
        try {
            return (Node<String>) Resources.getField(l, HEAD_NAME);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            Assertions.fail(String.format("Could not access the field %s.", HEAD_NAME), e);
        }
        return null;
    }

    /**
     * Returns the sentinel node of the list. If the sentinel node cannot be accesses, the test will automatically
     * fail.
     *
     * @param l the list with its sentinel node
     *
     * @return the sentinel node of the list {@code list}
     */
    @SuppressWarnings("unchecked")
    private Node<String> getNil(final LinkedList<String> l) {
        try {
            return (Node<String>) Resources.getField(l, NIL_NAME);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            Assertions.fail(String.format("Could not access the field %s.", NIL_NAME), e);
        }
        return null;
    }

    /**
     * Read all lines from a file as a {@code String[]}. If something went wrong while trying to read the file, the test
     * will automatically fail.
     *
     * @param path the path to the file
     *
     * @return the lines from the file as a {@code String[]}
     *
     * @see Resources#read(String)
     */
    private String[] lines(final String path) {
        try {
            return Resources.read(path);
        } catch (IOException e) {
            Assertions.fail(String.format("File at %s could not be read", path), e);
        }
        return null;
    }

    /**
     * Parses the lines to a node chained list line by line. Each line represents a node and its successor is the next
     * line.
     *
     * @param lines the lines representing a node chained list
     *
     * @return head node from the lines
     *
     * @see #lines(String)
     */
    private Node<String> parse(final String[] lines) {
        // Reference to the first element of the list
        Node<String> head = nil;
        // Reference to the last element of the list
        Node<String> tail = head;
        for (final String line : lines) {
            // Skip empty lines
            if (line.isBlank()) {
                continue;
            }
            // If head is not set
            final Node<String> node = new Node<>(line, nil);
            if (head == nil) {
                head = node;
                tail = head;
            } else {
                tail.setNext(node);
                tail = tail.next();
            }
        }
        return head;
    }

    /**
     * Sets the head node of the list {@code list} to the given node. If the head cannot be accesses, the test will
     * automatically fail.
     *
     * @param l    the list with its head node
     * @param head the head node of a list
     */
    void setHead(final LinkedList<String> l, final Node<String> head) {
        try {
            Resources.setField(l, head, HEAD_NAME);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            Assertions.fail(String.format("Could not access the field %s.", HEAD_NAME), e);
        }

    }

    /**
     * Resets the list before each test case.
     */
    @BeforeEach
    void setup() {
        this.list = new LinkedList<>();
        this.head = getHead(list);
        this.nil = getNil(list);
    }

    /**
     * Test case for the operation {@code add}. Testing the following methods:
     * <ul>
     *     <li>{@code add(Object)}</li>
     *     <li>{@code addAll(List)}</li>
     *     <li>{@code addAll(int, List)}</li>
     * </ul>
     *
     * @author Nhan Huynh
     * @version 1.0.0
     * @see LinkedList#add(Object)
     * @see LinkedList#addAll(List)
     * @see LinkedList#addAll(int, List)
     */
    @Nested
    @DisplayName("Test: add")
    @TestMethodOrder(MethodOrderer.MethodName.class)
    class TestAdd {

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @DisplayName("Test: Empty list")
        @ParameterizedTest(name = "Add {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testEmptyList(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                Node<String> tail = head;
                for (final String line : lines) {
                    list.add(line);
                    if (head == nil) {
                        head = getHead(list);
                        if (head == null) {
                            return;
                        }
                        tail = head;
                    } else {
                        tail = tail.next();
                    }
                    Assertions.assertEquals(line, tail.key(), String.format("Element %s should be added at the end of the list.", line));
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @DisplayName("Test: Empty list with non empty list - addAll(List)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testEmptyListAddAll(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                final LinkedList<String> list = new LinkedList<>();
                setHead(list, head);
                Assertions.assertTrue(TestLinkedList.this.list.addAll(list));
                int i = 0;
                for (Node<String> p = head; p != nil; p = p.next(), i++) {
                    Assertions.assertEquals(lines[i], p.key(), String.format("The element at %d with the element %s should be added to the list.", i, lines[i]));
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @DisplayName("Test: Empty list with non empty list - addAll(int, List)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testEmptyListAddAllIndex(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                final LinkedList<String> list = new LinkedList<>();
                setHead(list, head);
                Assertions.assertTrue(TestLinkedList.this.list.addAll(0, list));
                int i = 0;
                for (Node<String> p = head; p != nil; p = p.next(), i++) {
                    Assertions.assertEquals(lines[i], p.key(), String.format("The element at %d with the element %s should be added to the list.", i, lines[i]));
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @DisplayName("Test: Empty list with non empty list - addAll(int, List)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testEmptyListAddAllIndexException(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                final LinkedList<String> list = new LinkedList<>();
                setHead(list, head);
                int random = 0;
                while (random == 0) {
                    random = ThreadLocalRandom.current().nextInt(0, 10000);
                }
                final int index = random;
                Assertions.assertThrows(IndexOutOfBoundsException.class, () -> TestLinkedList.this.list.addAll(index, list), String.format("Index %d is out of boundary.", index));

            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list")
        @ParameterizedTest(name = "Add {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyList(final String value) {
            try {
                String path = String.format("%s%d", PATH_TEST_INPUT, 10000);
                String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                path = String.format("%s%s", PATH_TEST_INPUT, value);
                lines = lines(path);
                if (lines == null) {
                    return;
                }
                Node<String> tail = getHead(list);
                if (tail == null) {
                    return;
                }
                while (tail.next() != nil) {
                    tail = tail.next();
                }
                for (final String line : lines) {
                    list.add(line);
                    tail = tail.next();
                    Assertions.assertEquals(line, tail.key(), String.format("Element %s should be added at the end of the list.", line));
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with a non empty list.
         */
        @DisplayName("Test: Non empty list - addAll(List)")
        @ParameterizedTest(name = "List with 10000 and {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListAddAll(final String value) {
            try {
                final String pathHead = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] linesHead = lines(pathHead);
                if (linesHead == null) {
                    return;
                }
                Node<String> head = parse(linesHead);
                setHead(TestLinkedList.this.list, head);
                final LinkedList<String> list = new LinkedList<>();
                final String path = String.format("%s%d", PATH_TEST_INPUT, 10000);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                head = parse(lines);
                setHead(list, head);
                Assertions.assertTrue(TestLinkedList.this.list.addAll(list), "Elements should be added. So there was a change.");
                int i = 0;
                Node<String> p = getHead(TestLinkedList.this.list);
                if (p == null) {
                    return;
                }
                for (; p != nil && i < linesHead.length; p = p.next(), i++) {
                    Assertions.assertEquals(lines[i], p.key(), String.format("The element at %d with the element %s should be added to the list.", i, lines[i]));
                }
                Assertions.assertEquals(linesHead.length, i, "Some elements are missing or there are too many elements.");
                i = 0;
                for (; p != nil && i < lines.length; p = p.next(), i++) {
                    Assertions.assertEquals(lines[i], p.key(), String.format("The element at %d with the element %s should be added to the list.", i, lines[i]));
                }
                Assertions.assertEquals(lines.length, i, "Some elements are missing or there are too many elements.");
                Assertions.assertSame(TestLinkedList.this.nil, p, "Some elements are missing or there are too many elements.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with a non empty list.
         */
        @DisplayName("Test: Non empty list with empty list - addAll(List)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListAddAllEmpty(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(TestLinkedList.this.list, head);
                final LinkedList<String> list = new LinkedList<>();
                Assertions.assertFalse(TestLinkedList.this.list.addAll(list), "No changes, because the second list is an empty list.");
                int i = 0;
                for (Node<String> p = head; p != nil; p = p.next(), i++) {
                    Assertions.assertEquals(lines[i], p.key(), String.format("The element at %d should not change.", i));
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with a non empty list.
         */
        @DisplayName("Test: Non empty list - addAll(int, List)")
        @ParameterizedTest(name = "List with 10000, add elements at index {0}")
        @ValueSource(strings = {"1", "10", "100", "250", "500", "750", "1000", "2500", "3333", "5555", "8352"})
        void testNonEmptyListAddAllIndex(final String value) {
            try {
                final String pathHead = String.format("%s%d", PATH_TEST_INPUT, 10000);
                final String[] linesHead = lines(pathHead);
                if (linesHead == null) {
                    return;
                }
                Node<String> head = parse(linesHead);
                setHead(TestLinkedList.this.list, head);
                final String path = String.format("%s%s%s/%s", Resources.TEST_DIRECTORY, PATH_TEST_SOURCE, "add", value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final LinkedList<String> list = new LinkedList<>();
                setHead(list, head);

                int index = Integer.parseInt(value);
                Assertions.assertTrue(TestLinkedList.this.list.addAll(index, list), "Elements should be added. So there was a change.");
                int i = 0;
                Node<String> p = getHead(TestLinkedList.this.list);
                if (p == null) {
                    return;
                }
                for (; p != nil && i < lines.length; p = p.next(), i++) {
                    Assertions.assertEquals(lines[i], p.key(), String.format("Element at index %d does not match.", i));
                }
                Assertions.assertEquals(nil, p, "Some elements are missing or there are too many.");
                Assertions.assertEquals(lines.length, i, "Some elements are missing or there are too many.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with a non empty list.
         */
        @DisplayName("Test: Non empty list with empty list - addAll(List)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListAddAllIndexEmpty(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(TestLinkedList.this.list, head);
                final LinkedList<String> list = new LinkedList<>();
                final int bound = Integer.parseInt(value);
                final int index = ThreadLocalRandom.current().nextInt(0, bound);
                Assertions.assertFalse(TestLinkedList.this.list.addAll(index, list), "No changes, because the second list is an empty list.");
                int i = 0;
                for (Node<String> p = head; p != nil; p = p.next(), i++) {
                    Assertions.assertEquals(lines[i], p.key(), String.format("The element at %d should not change.", i));
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with a non empty list.
         */
        @DisplayName("Test: Non empty list with empty list - addAll(List)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListAddAllIndexEmptyException(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(TestLinkedList.this.list, head);
                final LinkedList<String> list = new LinkedList<>();
                final int bound = Integer.parseInt(value);
                for (int i = 0; i < 10; i++) {
                    int random = 0;
                    while (0 <= random && random < lines.length) {
                        random = ThreadLocalRandom.current().nextInt(-bound, 2 * bound);
                    }
                    final int index = random;
                    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> TestLinkedList.this.list.addAll(index, list), String.format("Index %d is out of boundary.", index));
                    int j = 0;
                    for (Node<String> p = head; p != nil; p = p.next(), j++) {
                        Assertions.assertEquals(lines[j], p.key(), String.format("The element at %d should not change.", j));
                    }
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }
    }

    /**
     * Test case for the operation {@code clear}. Testing the following methods:
     * <ul>
     *     <li>{@code clear()}</li>
     * </ul>
     *
     * @author Nhan Huynh
     * @version 1.0.0
     * @see LinkedList#size()
     */
    @Nested
    @DisplayName("Test: clear")
    @TestMethodOrder(MethodOrderer.MethodName.class)
    class TestClear {

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @Test
        @DisplayName("Test: Empty list")
        void testEmptyList() {
            try {
                list.clear();
                TestLinkedList.this.head = getHead(list);
                Assertions.assertSame(nil, TestLinkedList.this.head, "An empty list does not contain any elements. Only the sentinel node exists.");
                Assertions.assertSame(nil, TestLinkedList.this.head.next(), "An empty list does not contain any elements. Only the sentinel node exists.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyList(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                list.clear();
                TestLinkedList.this.head = getHead(list);
                Assertions.assertSame(nil, TestLinkedList.this.head, "After this operation the list must be empty. Only the sentinel node exists.");
                Assertions.assertSame(nil, TestLinkedList.this.head.next(), "After this operation the list must be empty. Only the sentinel node exists.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }
    }

    /**
     * Test case for the operation {@code contains}. Testing the following methods:
     * <ul>
     *     <li>{@code contains(Object)}</li>
     *     <li>{@code containsAll(List)}</li>
     * </ul>
     *
     * @author Nhan Huynh
     * @version 1.0.0
     * @see LinkedList#contains(Object)
     * @see LinkedList#containsAll(List)
     */
    @Nested
    @DisplayName("Test: contains")
    @TestMethodOrder(MethodOrderer.MethodName.class)
    class TestContains {

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @DisplayName("Test: Empty list")
        @ParameterizedTest(name = "List does not contains element {0}.")
        @ValueSource(strings = {"1", "4324", "2313", "65467", "54205", "78432", "94847232189", "1643124"})
        void testEmptyList(final String value) {
            try {
                Assertions.assertFalse(list.contains(value), String.format("An empty list cannot contain the element %s.", value));
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @DisplayName("Test: Empty list - containsAll(List)")
        @ParameterizedTest(name = "Empty list does not contain elements [0, ..., {0} - 1].")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testEmptyListContainsAll(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                LinkedList<String> l = new LinkedList<>();
                setHead(l, head);
                Assertions.assertFalse(list.containsAll(l), "An empty list does not contain anything.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list - list contains the element")
        @ParameterizedTest(name = "List with elements [0, ..., 9999], contains {0}.")
        @ValueSource(strings = {"1", "10", "25", "36", "50", "75", "100", "125", "250", "333", "375", "500", "653", "750", "854", "1000", "1111", "1250", "2452", "2500", "3750", "5000", "7500", "8596", "9999"})
        void testNonEmptyListContains(final String value) {
            try {
                int elements = 10000;
                final String path = String.format("%s%d", PATH_TEST_INPUT, elements);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                Assertions.assertTrue(list.contains(value), String.format("A list with elements from %d to %d cannot contain the element %s.", 0, elements, value));
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with a non empty list.
         */
        @DisplayName("Test: Non empty list with the not same elements - containsAll(List)")
        @ParameterizedTest(name = "Non empty list with elements [0, ..., {0} - 1] and a different list.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000"})
        void testNonEmptyListContainsAllFalse(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                Node<String> head = parse(lines);
                setHead(list, head);
                lines = new String[lines.length];
                for (int i = 0; i < lines.length; i++) {
                    lines[i] = String.valueOf(i + 5000 * 2);
                }
                head = parse(lines);
                final LinkedList<String> l = new LinkedList<>();
                setHead(l, head);
                Assertions.assertFalse(list.containsAll(l), "Two different lists should not contain the other list if they do not contain the same elements.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with a non empty list.
         */
        @DisplayName("Test: Non empty list with more elements - containsAll(List)")
        @ParameterizedTest(name = "Non empty list with elements [0, ..., {0} - 1] and the second list with more elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000"})
        void testNonEmptyListContainsAllFalseMoreElements(final String value) {
            try {
                String path = String.format("%s%s", PATH_TEST_INPUT, value);
                String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                Node<String> head = parse(lines);
                setHead(list, head);
                path = String.format("%s%s", PATH_TEST_INPUT, "10000");
                lines = lines(path);
                if (lines == null) {
                    return;
                }
                head = parse(lines);
                final LinkedList<String> l = new LinkedList<>();
                setHead(l, head);
                Assertions.assertFalse(list.containsAll(l), "Two different lists should not contain the other list if they have different size.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with a non empty list.
         */
        @DisplayName("Test: Non empty list with the same elements - containsAll(List)")
        @ParameterizedTest(name = "Non empty list with elements [0, ..., {0} - 1] contains the same elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListContainsAllTrue(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                final LinkedList<String> l = new LinkedList<>();
                setHead(l, head);
                Assertions.assertTrue(list.containsAll(l), "A list should contain all elements of the second list if the elements are the same.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list -  list does not contain the element")
        @ParameterizedTest(name = "List with elements [0, ..., 9999], does not contain {0}.")
        @ValueSource(strings = {"-53253267", "-12345", "-532", "-1", "10000", "10001", "123456", "532532", "2313124", "4363754785"})
        void testNonEmptyListContainsNot(final String value) {
            try {
                int elements = 10000;
                final String path = String.format("%s%d", PATH_TEST_INPUT, elements);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                Assertions.assertFalse(list.contains(value), String.format("A list with elements from %d to %d can only elements between this interval. So the element %s is not in the list.", 0, elements, value));
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with a non empty list.
         */
        @DisplayName("Test: Non empty list but given list is empty - containsAll(List)")
        @ParameterizedTest(name = "Non empty list with elements [0, ..., {0} - 1] contains an empty list.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListEmptyListContainsAll(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                LinkedList<String> l = new LinkedList<>();
                Assertions.assertTrue(list.containsAll(l), "A list should contain an empty list");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }
    }

    /**
     * Test case for the operation {@code isEmpty}. Testing the following methods:
     * <ul>
     *     <li>{@code isEmpty()}</li>
     * </ul>
     *
     * @author Nhan Huynh
     * @version 1.0.0
     * @see LinkedList#isEmpty()
     */
    @Nested
    @DisplayName("Test: isEmpty")
    @TestMethodOrder(MethodOrderer.MethodName.class)
    class TestIsEmpty {

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @Test
        @DisplayName("Test: Empty list")
        void testEmptyList() {
            try {
                Assertions.assertTrue(list.isEmpty(), "A list with 0 elements must return true when the operation is called");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @DisplayName("Test: Empty list with removing non empty list - removeAll(List)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testEmptyListRemoveAll(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                final LinkedList<String> l = new LinkedList<>();
                setHead(l, head);
                Assertions.assertFalse(list.removeAll(l), "We cannot remove an element from an empty list");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyList(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                Assertions.assertFalse(list.isEmpty(), String.format("A list with %s elements must return false when the operation is called", value));
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with a non empty list.
         */
        @DisplayName("Test: Non empty list with removing an empty list - removeAll(List)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListRemoveAllEmpty(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                final LinkedList<String> l = new LinkedList<>();
                setHead(list, head);
                Assertions.assertFalse(list.removeAll(l), "We cannot remove an element from an empty list");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with a non empty list.
         */
        @DisplayName("Test: Non empty list a larger list - removeAll(List)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"10", "50", "100", "250", "500", "1000", "2500", "5000"})
        void testNonEmptyListRemoveAllLarger(final String value) {
            try {
                final String pathHead = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] linesHead = lines(pathHead);
                if (linesHead == null) {
                    return;
                }
                Node<String> head = parse(linesHead);
                setHead(list, head);

                final String path = String.format("%s%d", PATH_TEST_INPUT, 10000);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final LinkedList<String> l = new LinkedList<>();
                Node<String> node = parse(lines);
                setHead(l, node);
                Assertions.assertTrue(list.removeAll(l), "We are removing all elements, so the list was changed.");
                final Node<String> p = getHead(list);
                if (p == null) {
                    return;
                }
                Assertions.assertSame(nil, p, "The list must be empty.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with a non empty list.
         */
        @DisplayName("Test: Non empty list a part of the list - removeAll(List)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListRemoveAllLess(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                Node<String> head = parse(lines);
                final LinkedList<String> l = new LinkedList<>();
                setHead(list, head);
                String[] sub = new String[lines.length / 2];
                System.arraycopy(lines, 0, sub, 0, lines.length / 2);
                head = parse(sub);
                setHead(l, head);
                Assertions.assertTrue(list.removeAll(l), "We are removing all elements, so the list was changed.");
                Node<String> p = getHead(list);
                if (p == null) {
                    return;
                }
                int i = 0;
                for (; p != nil && i < lines.length / 2; p = p.next(), i++) {
                    Assertions.assertEquals(lines[lines.length / 2 + i], p.key(), "Elements does not match.");
                }
                Assertions.assertEquals(lines.length / 2, i, "T");
                Assertions.assertSame(nil, p, "Some elements are missing or there are too many elements.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with a non empty list.
         */
        @DisplayName("Test: Non empty list removing the same list - removeAll(List)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListRemoveAllSameList(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                Node<String> head = parse(lines);
                final LinkedList<String> l = new LinkedList<>();
                setHead(list, head);
                head = parse(lines);
                setHead(l, head);
                Assertions.assertTrue(list.removeAll(l), "We are removing all elements, so the list was changed.");
                head = getHead(list);
                if (head == null) {
                    return;
                }
                Assertions.assertSame(nil, head, "The list must be empty after removing all elements.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }
    }

    /**
     * Test case for the operation {@code get}. Testing the following methods:
     * <ul>
     *     <li>{@code get(int)}</li>
     * </ul>
     *
     * @author Nhan Huynh
     * @version 1.0.0
     * @see LinkedList#get(int)
     */
    @Nested
    @DisplayName("Test: get")
    @TestMethodOrder(MethodOrderer.MethodName.class)
    class TestGet {

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @DisplayName("Test: Empty list")
        @ParameterizedTest(name = "Get element at index {0}")
        @ValueSource(ints = {-421, -5, -2, 0, 1, 241, 4214, 4214, 53532})
        void testEmptyListException(final int value) {
            try {
                Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(value), "We cannot access an index when the list is empty.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list with invalid index access")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListInvalidIndex(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                final int bound = Integer.parseInt(value);
                for (int i = 0; i < bound; i++) {
                    int random = 0;
                    while (0 <= random && random < bound) {
                        random = ThreadLocalRandom.current().nextInt(-bound, bound * 2);
                    }
                    final int index = random;
                    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(index), String.format("Index %d is out of bounds [0, %s].", index, value));
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list with valid index access")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListValidIndex(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                final int bound = Integer.parseInt(value);
                for (int i = 0; i < bound; i++) {
                    Assertions.assertEquals(lines[i], list.get(i), String.format("Element at index %d does not match.", i));
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }
    }

    /**
     * Test case for the operation {@code indexOf}. Testing the following methods:
     * <ul>
     *     <li>{@code indexOf(Object)}</li>
     *     <li>{@code lastIndexOf(Object)}</li>
     * </ul>
     *
     * @author Nhan Huynh
     * @version 1.0.0
     * @see LinkedList#indexOf(Object)
     * @see LinkedList#lastIndexOf(Object)
     */
    @Nested
    @DisplayName("Test: indexOf")
    @TestMethodOrder(MethodOrderer.MethodName.class)
    class TestIndexOf {

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @DisplayName("Test: Empty list - indexOf")
        @ParameterizedTest(name = "Get element at index {0}.")
        @ValueSource(ints = {-52, -5, -2, 1, 23, 54, 65474, 3424325, 325324113})
        void testEmptyListIndex(final int value) {
            try {
                Assertions.assertEquals(-1, list.indexOf(value), "An empty list does not contain any elements.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @DisplayName("Test: Empty list - lastIndexOf")
        @ParameterizedTest(name = "Get element at index {0}.")
        @ValueSource(ints = {-52, -5, -2, 1, 23, 54, 65474, 3424325, 325324113})
        void testEmptyListLastIndexOfException(final int value) {
            try {
                Assertions.assertEquals(-1, list.indexOf(value), "An empty list does not contain any elements.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list invalid index - indexOf")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListIndexOfInvalid(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                int random = 0;
                final int bound = Integer.parseInt(value);
                while (0 <= random && random < bound) {
                    random = ThreadLocalRandom.current().nextInt(-bound, bound * 2);
                }
                final int index = random;
                Assertions.assertEquals(-1, list.indexOf(index), "Element is not in the list.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list valid index - indexOf")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListIndexOfValid(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                for(int i = 0; i < lines.length; i++){
                    Assertions.assertEquals(lines[i], list.get(i), String.format("Element at index %d does not match.", i));
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @DisplayName("Test: Empty list - lastIndexOf")
        @ParameterizedTest(name = "Get element at index {0}.")
        @ValueSource(ints = {-52, -5, -2, 1, 23, 54, 65474, 3424325, 325324113})
        void testEmptyListLastIndex(final int value) {
            try {
                Assertions.assertEquals(-1, list.indexOf(value), "An empty list does not contain any elements.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list invalid index - lastIndexOf")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListLastIndexOfInvalid(final String value) {
            try {
                final String path = String.format("%s%s%s%s", Resources.TEST_DIRECTORY, PATH_TEST_SOURCE, "index/", value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                int random = 0;
                final int bound = Integer.parseInt(value);
                while (random != 0) {
                    random = ThreadLocalRandom.current().nextInt(-bound, bound * 2);
                }
                final int index = random;
                Assertions.assertEquals(-1, list.lastIndexOf(index), "Element is not in the list.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list valid index - lastIndexOf")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListLastIndexOfValid(final String value) {
            try {
                final String path = String.format("%s%s%s%s", Resources.TEST_DIRECTORY, PATH_TEST_SOURCE, "index/", value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                int actual = list.lastIndexOf("0");
                Assertions.assertEquals(lines.length - 1, actual, String.format("Element at index %d is not the last index.", actual));
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }
    }

    /**
     * Test case for the operation {@code iterator}. Testing the following methods:
     * <ul>
     *     <li>{@code iterator()}</li>
     * </ul>
     *
     * @author Nhan Huynh
     * @version 1.0.0
     * @see LinkedList#iterator()
     */
    @Nested
    @DisplayName("Test: iterator")
    @TestMethodOrder(MethodOrderer.MethodName.class)
    class TestIterator {

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @Test
        @DisplayName("Test: Empty list")
        void testEmptyList() {
            try {
                final Iterator<String> iter = list.iterator();
                Assertions.assertFalse(iter.hasNext(), "An empty list contains only the sentinel node");
                Assertions.assertNull(iter.next(), "An empty list contains only the sentinel node.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyList(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                int i = 0;
                for (Iterator<String> iter = list.iterator(); iter.hasNext(); i++) {
                    final String key = iter.next();
                    Assertions.assertEquals(lines[i], key, String.format("The element at the position %d must be the element %s.", i, lines[i]));
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }
    }

    /**
     * Test case for the operation {@code remove}. Testing the following methods:
     * <ul>
     *     <li>{@code remove(int)}</li>
     *     <li>{@code remove(Object)}</li>
     *     <li>{@code removeAll(List)}</li>
     * </ul>
     *
     * @author Nhan Huynh
     * @version 1.0.0
     * @see LinkedList#remove(int)
     * @see LinkedList#remove(Object)
     * @see LinkedList#removeAll(List)
     */
    @Nested
    @DisplayName("Test: remove")
    @TestMethodOrder(MethodOrderer.MethodName.class)
    class TestRemove {

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @Test
        @DisplayName("Test: Empty list")
        void testEmptyList() {
            try {
                Assertions.assertNull(list.remove(0), "An empty list does not contain an element.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @DisplayName("Test: Empty list - Exception")
        @ParameterizedTest(name = "Access the index {0} from an empty list.")
        @ValueSource(ints = {-532, -213, -5, -1, 1, 23, 421, 532, 1000})
        void testEmptyListException(final int value) {
            try {
                Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(value), String.format("We cannot access an index (%d) of an empty list.", value));
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @DisplayName("Test: Empty list - remove(Object)")
        @ParameterizedTest(name = "Remove element {0}.")
        @ValueSource(ints = {-532, -213, -5, -1, 1, 23, 421, 532, 1000})
        void testEmptyListObject(int value) {
            try {
                Assertions.assertFalse(list.remove(Integer.valueOf(value)), "An empty list does not contain an element.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyList(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                for (int i = 0; i < lines.length; i++) {
                    final Node<String> head = parse(lines);
                    setHead(list, head);
                    final String actual = list.remove(i);
                    Assertions.assertEquals(lines[i], actual, "The removed element does not match.");
                    Node<String> p = getHead(list);
                    if (p == null) {
                        return;
                    }
                    for (int j = 0; p != nil; j++) {
                        if (i == j) {
                            continue;
                        }
                        Assertions.assertEquals(lines[j], p.key(), "The position of the element is wrong.");
                        p = p.next();
                    }
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListException(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                int random = 0;
                final int bound = Integer.parseInt(value);
                while (0 <= random && random < bound) {
                    random = ThreadLocalRandom.current().nextInt(-bound, bound * 2);
                }
                final int index = random;
                Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(index), String.format("Index %d is out of boundary.", index));
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list - remove(Object)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListObject(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                for (int i = 0; i < lines.length; i++) {
                    final Node<String> head = parse(lines);
                    setHead(list, head);
                    Assertions.assertTrue(list.remove(String.valueOf(i)), "The list should change after a removal.");
                    Node<String> p = getHead(list);
                    if (p == null) {
                        return;
                    }
                    for (int j = 0; p != nil; j++) {
                        if (i == j) {
                            continue;
                        }
                        Assertions.assertEquals(lines[j], p.key(), "The position of the element is wrong.");
                        p = p.next();
                    }
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list does not contain element - remove(Object)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListObjectNot(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                for (int i = 0; i < lines.length; i++) {
                    Assertions.assertFalse(list.remove(Integer.valueOf(i + 10000000)), "The list should change after a removal.");
                    Node<String> p = getHead(list);
                    if (p == null) {
                        return;
                    }
                    for (int j = 0; p != nil; p = p.next(), j++) {
                        Assertions.assertEquals(lines[j], p.key(), "The position of the element is wrong.");
                    }
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }
    }

    /**
     * Test case for the operation {@code size}. Testing the following methods:
     * <ul>
     *     <li>{@code size()}</li>
     * </ul>
     *
     * @author Nhan Huynh
     * @version 1.0.0
     * @see LinkedList#size()
     */
    @Nested
    @DisplayName("Test: size")
    @TestMethodOrder(MethodOrderer.MethodName.class)
    class TestSize {

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @Test
        @DisplayName("Test: Empty list")
        void testEmptyList() {
            try {
                Assertions.assertEquals(0, list.size(), "A list with 0 elements must return the size of 0 when the operation is called");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyList(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                Assertions.assertEquals(Integer.parseInt(value), list.size(), String.format("A list with %s elements must return the size of %s when the operation is called", value, value));
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }
    }

    /**
     * Test case for the operation {@code toArray}. Testing the following methods:
     * <ul>
     *     <li>{@code toArray()}</li>
     *     <li>{@code toArray(Object[])}</li>
     * </ul>
     *
     * @author Nhan Huynh
     * @version 1.0.0
     * @see LinkedList#toArray()
     * @see LinkedList#toArray(Object[])
     */
    @Nested
    @DisplayName("Test: toArray")
    @TestMethodOrder(MethodOrderer.MethodName.class)
    class TestToArray {

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @Test
        @DisplayName("Test: Empty list - toArray(Object)")
        void testEmptyListArray() {
            try {
                final String[] array = new String[100];
                Assertions.assertEquals(array.length, list.toArray(array).length, "The size of the list after this operation on an empty list should not change.");
                for (int i = 0; i < array.length; i++) {
                    Assertions.assertNull(array[i], String.format("The element at index %d should not change after this operation.", i));
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an empty list.
         */
        @Test
        @DisplayName("Test: Empty list - toArray()")
        void testEmptyListObjectArray() {
            try {
                Assertions.assertEquals(0, list.toArray().length, "An empty list converted to array results in an empty array.");
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list with array size larger than list - toArray(Object)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListArrayLargerSize(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                final String[] array = new String[lines.length * 2];
                Arrays.fill(array, "S");
                final String[] actual = list.toArray(array);
                Assertions.assertEquals(lines.length * 2, actual.length, String.format("An array  with %d space should have should not change after this operation.", lines.length * 2));
                int i = 0;
                for (Node<String> p = head; p != nil; p = p.next(), i++) {
                    Assertions.assertEquals(p.key(), actual[i], String.format("Element at index %d does not match.", i));
                }
                Assertions.assertNull(actual[lines.length], String.format("The mark the end of the list of a list with %s elements should be at index %s", value, value));
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list with same size - toArray(Object)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListArraySameSize(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                final String[] array = new String[lines.length];
                final String[] actual = list.toArray(array);
                Assertions.assertEquals(lines.length, actual.length, String.format("A list with %s elements converted to an array should have the same size.", value));
                int i = 0;
                for (Node<String> p = head; p != nil; p = p.next(), i++) {
                    Assertions.assertEquals(p.key(), actual[i], String.format("Element at index %d does not match.", i));
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list with array size smaller than list - toArray(Object)")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListArraySmallerSize(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                final String[] array = new String[lines.length / 2];
                final String[] actual = list.toArray(array);
                Assertions.assertEquals(lines.length, actual.length, String.format("A list with %s elements converted to an array should have the same size.", value));
                int i = 0;
                for (Node<String> p = head; p != nil; p = p.next(), i++) {
                    Assertions.assertEquals(p.key(), actual[i], String.format("Element at index %d does not match.", i));
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }

        /**
         * Test case whether the operation is successful with an non empty list.
         *
         * @param value path of the file and the element of numbers in the list
         */
        @DisplayName("Test: Non empty list - toArray()")
        @ParameterizedTest(name = "List with {0} elements.")
        @ValueSource(strings = {"1", "10", "50", "100", "250", "500", "1000", "2500", "5000", "10000"})
        void testNonEmptyListObjectArray(final String value) {
            try {
                final String path = String.format("%s%s", PATH_TEST_INPUT, value);
                final String[] lines = lines(path);
                if (lines == null) {
                    return;
                }
                final Node<String> head = parse(lines);
                setHead(list, head);
                final Object[] array = list.toArray();
                int i = 0;
                Assertions.assertEquals(lines.length, array.length, String.format("A list with %s elements converted to an array should have the same size.", value));
                for (Node<String> p = head; p != nil; p = p.next(), i++) {
                    Assertions.assertEquals(p.key(), array[i], String.format("Element at index %d does not match.", i));
                }
            } catch (UnsupportedOperationException e) {
                Assertions.fail(e.getMessage());
            }
        }
    }
}
