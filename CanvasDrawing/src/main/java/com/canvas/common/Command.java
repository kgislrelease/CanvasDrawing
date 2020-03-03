package com.canvas.common;

import com.canvas.exception.CanvasExceptions;
import com.canvas.painter.AbstractPainter;

import java.util.List;

public class Command {

    private AbstractPainter abstractPainter;

    public void setCommand(final PainterInput painterInput) {
        AbstractPainter newAbstractPainter = painterInput.getPainterEnumFactory().createPainter();
        if (this.abstractPainter != null) {
            newAbstractPainter.setHeight(this.abstractPainter.getHeight());
            newAbstractPainter.setWidth(this.abstractPainter.getWidth());
            newAbstractPainter.setShape(this.abstractPainter.getShape());
        }
        this.abstractPainter = newAbstractPainter;
    }

    public void executeCommand(final List<String> params)
            throws CanvasExceptions {
        abstractPainter.execute(params);
    }
}
