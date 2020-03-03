package com.canvas.painter;

import com.canvas.exception.CanvasExceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LinePainterTest {

    @Test
    void executeSuccess() throws CanvasExceptions {
        Canvas canvas = new Canvas();
        List<String> params = new ArrayList<>();
        params.add("10");
        params.add("4");

        canvas.execute(params);

        LinePainter linePainter = new LinePainter();
        params.clear();

        params.add("1");
        params.add("2");
        params.add("6");
        params.add("2");

        linePainter.setHeight(canvas.height);
        linePainter.setWidth(canvas.width);
        linePainter.shape = canvas.shape;

        linePainter.execute(params);
        assertNotNull(canvas.shape);
        assertEquals(4, canvas.height);
        assertEquals(10, canvas.width);

        char[][] expected = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, {'|', 0, 0, 0, 0, 0, 0, 0, 0, '|'},
                {'|', 'x', 'x', 'x', 'x', 'x', 'x', 0, 0, '|'}, {'|', 0, 0, 0, 0, 0, 0, 0, 0, '|'}, {'|', 0, 0, 0, 0, 0, 0, 0, 0, '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};

        assertEquals(Arrays.deepToString(linePainter.shape), Arrays.deepToString(expected));

        params.clear();
        params.add("6");
        params.add("3");
        params.add("6");
        params.add("4");

        linePainter.execute(params);

        char[][] expected1 = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, {'|', 0, 0, 0, 0, 0, 0, 0, 0, '|'},
                {'|', 'x', 'x', 'x', 'x', 'x', 'x', 0, 0, '|'}, {'|', 0, 0, 0, 0, 0, 'x', 0, 0, '|'}, {'|', 0, 0, 0, 0, 0, 'x', 0, 0, '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};

        assertEquals(Arrays.deepToString(linePainter.shape), Arrays.deepToString(expected1));
    }

    @Test
    void executeException() throws CanvasExceptions {
        Canvas canvas = new Canvas();
        List<String> params = new ArrayList<>();
        params.add("10");
        params.add("4");

        canvas.execute(params);

        LinePainter linePainter = new LinePainter();
        params.clear();

        params.add("1");
        params.add("2");
        params.add("6");

        CanvasExceptions exceptionThrown = Assertions.assertThrows(CanvasExceptions.class, () -> linePainter.execute(params));

        assertEquals("Line painter expects 4 params", exceptionThrown.getMessage());
    }
}