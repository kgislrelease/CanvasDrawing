package com.canvas.painter;

import com.canvas.exception.CanvasExceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CanvasTest {

    @Test
    void executeSuccess() throws CanvasExceptions {
        Canvas canvas = new Canvas();
        List<String> params = new ArrayList<>();
        params.add("10");
        params.add("5");
        char[][] expected = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, {'|', 0, 0, 0, 0, 0, 0, 0, 0, '|'}, {'|', 0, 0, 0, 0, 0, 0, 0, 0, '|'}, {'|', 0, 0, 0, 0, 0, 0, 0, 0, '|'}, {'|', 0, 0, 0, 0, 0, 0, 0, 0, '|'}, {'|', 0, 0, 0, 0, 0, 0, 0, 0, '|'}, {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};

        canvas.execute(params);

        assertNotNull(canvas.shape);
        assertEquals(5, canvas.height);
        assertEquals(10, canvas.width);
        assertEquals(Arrays.deepToString(canvas.shape), Arrays.deepToString(expected));
    }

    @Test
    void executeException() {
        Canvas canvas = new Canvas();
        List<String> params = new ArrayList<>();
        params.add("10");

        CanvasExceptions exceptionThrown = Assertions.assertThrows(CanvasExceptions.class, () -> canvas.execute(params));

        assertEquals("Canvas painter expects 2 params", exceptionThrown.getMessage());
    }
}