package com.canvas.common;

import com.canvas.painter.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FactoryTest {

    @Test
    void painterEnumFactoryTest() {
        PainterInput painterInput = new PainterInput("C 20 4");
        AbstractPainter abstractPainter = painterInput.getPainterEnumFactory().createPainter();
        assertTrue(abstractPainter instanceof Canvas);

        painterInput = new PainterInput("C 20 4");
        abstractPainter = painterInput.getPainterEnumFactory().createPainter();
        assertTrue(abstractPainter instanceof Canvas);

        painterInput = new PainterInput("L 1 2 6 2");
        abstractPainter = painterInput.getPainterEnumFactory().createPainter();
        assertTrue(abstractPainter instanceof LinePainter);

        painterInput = new PainterInput("R 14 1 18 3");
        abstractPainter = painterInput.getPainterEnumFactory().createPainter();
        assertTrue(abstractPainter instanceof RectanglePainter);

        painterInput = new PainterInput("B 10 3 o");
        abstractPainter = painterInput.getPainterEnumFactory().createPainter();
        assertTrue(abstractPainter instanceof FillPainter);

        painterInput = new PainterInput("Q");
        abstractPainter = painterInput.getPainterEnumFactory().createPainter();
        assertTrue(abstractPainter instanceof Quit);
    }

}