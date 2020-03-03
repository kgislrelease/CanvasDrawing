package com.canvas.painter;

import com.canvas.exception.CanvasExceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RectanglePainterTest {

    @Test
    void executeSuccess() throws CanvasExceptions {
        Canvas canvas = new Canvas();
        List<String> params = new ArrayList<>();
        params.add("10");
        params.add("4");

        canvas.execute(params);

        RectanglePainter rectanglePainterct = new RectanglePainter();
        params.clear();

        params.add("2");
        params.add("2");
        params.add("8");
        params.add("4");

        rectanglePainterct.setHeight(canvas.height);
        rectanglePainterct.setWidth(canvas.width);
        rectanglePainterct.shape = canvas.shape;

        rectanglePainterct.execute(params);

        assertNotNull(canvas.shape);
        assertEquals(4, canvas.height);
        assertEquals(10, canvas.width);

        char[][] expected = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, {'|', 0, 0, 0, 0, 0, 0, 0, 0, '|'}, {'|', 0, 'x', 'x', 'x', 'x', 'x', 'x', 'x', '|'},
                {'|', 0, 'x', 0, 0, 0, 0, 0, 'x', '|'}, {'|', 0, 'x', 'x', 'x', 'x', 'x', 'x', 'x', '|'}, {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};

        assertEquals(Arrays.deepToString(rectanglePainterct.shape), Arrays.deepToString(expected));
    }

    @Test
    void executeException() throws CanvasExceptions {
        Canvas canvas = new Canvas();
        List<String> params = new ArrayList<>();
        params.add("10");
        params.add("4");

        canvas.execute(params);

        RectanglePainter rectanglePainterct = new RectanglePainter();
        params.clear();

        params.add("2");
        params.add("2");
        params.add("8");

        rectanglePainterct.setHeight(canvas.height);
        rectanglePainterct.setWidth(canvas.width);
        rectanglePainterct.shape = canvas.shape;

        CanvasExceptions exceptionThrown = Assertions.assertThrows(CanvasExceptions.class, () -> rectanglePainterct.execute(params));

        assertEquals("Rectangle painter expects 4 params", exceptionThrown.getMessage());
    }
}