package resources;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * An utility class to handle resources for testing purpose.
 *
 * @author Nhan Huynh
 * @version 1.0.0
 */
public final class Resources {
    /**
     * Represents the path of the test resources directory.
     */
    public static final String TEST_DIRECTORY = "res/test/";

    /**
     * We cannot not invoke the constructor of a utility class.
     */
    private Resources() {
        throw new UnsupportedOperationException("We cannot not invoke the constructor of a utility class.");
    }

    /**
     * Read all lines from a file as a {@code Stream}.
     *
     * @param path the path to the file
     *
     * @return the lines from the file as a {@code Stream}
     *
     * @throws IOException if an I/O error occurs opening the file.
     */
    public static Stream<String> stream(final String path) throws IOException {
        return stream(Path.of(path));
    }

    /**
     * Read all lines from a file as a {@code Stream}.
     *
     * @param path the path to the file
     *
     * @return the lines from the file as a {@code Stream}
     *
     * @throws IOException if an I/O error occurs opening the file.
     */
    public static Stream<String> stream(final Path path) throws IOException {
        return Files.lines(path);
    }

    /**
     * Read all lines from a file as a {@code String[]}.
     *
     * @param path the path to the file
     *
     * @return the lines from the file as a {@code String[]}
     *
     * @throws IOException if an I/O error occurs opening the file.
     */
    public static String[] read(final String path) throws IOException {
        return stream(path).toArray(String[]::new);
    }

    /**
     * Read all lines from a file as a {@code String[]}.
     *
     * @param path the path to the file
     *
     * @return the lines from the file as a {@code String[]}
     *
     * @throws IOException if an I/O error occurs opening the file.
     */
    public static String[] read(final Path path) throws IOException {
        return stream(path).toArray(String[]::new);
    }

    /**
     * Access a private field from an object. The field must match with the given name.
     *
     * @param object the object containing the field
     * @param name   the name of the field to access
     *
     * @return the field of the object
     *
     * @throws IllegalAccessException if this {@code Field} object is enforcing Java language access control and the
     *                                underlying field is inaccessible.
     * @throws NoSuchFieldException   if a field with the specified name is not found.
     */
    public static Object getField(final Object object, final String name) throws IllegalAccessException, NoSuchFieldException {
        final Field field = object.getClass().getDeclaredField(name);
        field.setAccessible(true);
        return field.get(object);
    }

    /**
     * Access a private field from an object to replace its value. The field must match with the given name.
     *
     * @param object the object containing the field
     * @param value  the new value of the field
     * @param name   the name of the field to access
     *
     * @throws IllegalAccessException if this {@code Field} object is enforcing Java language access control and the
     *                                underlying field is inaccessible.
     * @throws NoSuchFieldException   if a field with the specified name is ot found.
     */
    public static void setField(final Object object, final Object value, final String name) throws IllegalAccessException, NoSuchFieldException {
        final Field field = object.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(object, value);
    }
}
