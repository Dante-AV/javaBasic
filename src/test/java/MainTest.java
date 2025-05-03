import org.junit.jupiter.api.*;
import ru.otus.homework.hw21.Main;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MainTest {

    @Test
    @DisplayName("Тест на проверку создания нового массива")
    void successTestNewArray() {
        Integer[] array = {1, 1, 2, 2, 3, 3};
        int[] result = Main.newArray(array);

        assertArrayEquals(new int[]{2, 2, 3, 3}, result);
    }

    @DisplayName("Тест на проверку RuntimeException если входной массив не содержит единиц")
    @Test
    void failTestNewArray() {
        Integer[] array = {2, 2, 2, 2, 3, 3};

        assertThrows(RuntimeException.class, () -> Arrays.equals(new int[]{2, 2, 2, 2, 3, 3}, Main.newArray(array)));
    }

    @Test
    @DisplayName("Тест на проверку входного массива - содержит только 1 и 2")
    void successCheckArrayTest() {
        Integer[] array = {1, 1, 2, 2, 3, 3};
        List<Integer> list = Arrays.asList(array);

        assertTrue(list.contains(1) && list.contains(2));
    }

    @Test
    @DisplayName("Тест на проверку входного массива - содержит или 1, или 2")
    void failCheckArrayTest() {
        Integer[] array = {2, 2, 2, 2, 3, 3};
        List<Integer> list = Arrays.asList(array);

        assertFalse(list.contains(1) && list.contains(2));
    }
}
