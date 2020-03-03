package com.canvas.painter;

import com.canvas.exception.CanvasExceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FillPainterTest {

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

        FillPainter fillPainter = new FillPainter();
        params.clear();
        params.add("7");
        params.add("1");
        params.add("o");

        fillPainter.setHeight(canvas.height);
        fillPainter.setWidth(canvas.width);
        fillPainter.shape = canvas.shape;

        fillPainter.execute(params);

        assertNotNull(canvas.shape);
        assertEquals(4, canvas.height);
        assertEquals(10, canvas.width);

        char[][] expected = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, {'|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|'},
                {'|', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', '|'}, {'|', 'o', 'x', 0, 0, 0, 0, 0, 'x', '|'}, {'|', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};

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
		params.add("4");

		rectanglePainterct.setHeight(canvas.height);
		rectanglePainterct.setWidth(canvas.width);
		rectanglePainterct.shape = canvas.shape;

		rectanglePainterct.execute(params);

		FillPainter fillPainter = new FillPainter();
		params.clear();
		params.add("7");
		params.add("1");

		fillPainter.setHeight(canvas.height);
		fillPainter.setWidth(canvas.width);
		fillPainter.shape = canvas.shape;

		CanvasExceptions exceptionThrown = Assertions.assertThrows(CanvasExceptions.class, () -> fillPainter.execute(params));

		assertEquals("Fill painter expects 3 params", exceptionThrown.getMessage());
	}
}