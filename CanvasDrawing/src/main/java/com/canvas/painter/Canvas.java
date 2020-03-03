package com.canvas.painter;

import com.canvas.exception.CanvasExceptions;

import java.util.List;

public class Canvas extends AbstractPainter {

    private static final char WIDTH_BORDER_CHAR = '-';
    private static final char HEIGHT_BORDER_CHAR = '|';

    @Override
    public void execute(final List<String> params) throws CanvasExceptions {

        if (params.size() < 2) {
            throw new CanvasExceptions(
                    "Canvas painter expects 2 params");
        }

        int width = Integer.parseInt(params.get(0));
        int height = Integer.parseInt(params.get(1));

        setWidth(width);
        setHeight(height);

        String canvas = getCanvas();

        System.out.print(canvas);
    }

    private String getCanvas() {
        shape = new char[height + 2][width];
        draw(0, 0, width - 1, 0, WIDTH_BORDER_CHAR);
        draw(0, 1, 0, height + 1, HEIGHT_BORDER_CHAR);
        draw(width - 1, 1, width - 1, height + 1, HEIGHT_BORDER_CHAR);
        draw(0, height + 1, width - 1, height + 1, WIDTH_BORDER_CHAR);
        return getShapeAsString();
    }
}
