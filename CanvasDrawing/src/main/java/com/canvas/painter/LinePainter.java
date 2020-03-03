package com.canvas.painter;

import com.canvas.exception.CanvasExceptions;

import java.util.List;

public class LinePainter extends AbstractPainter {

    @Override
    public void execute(List<String> params) throws CanvasExceptions {

        if (params.size() < 4) {
            throw new CanvasExceptions(
                    "Line painter expects 4 params");
        }

        int x1 = Integer.parseInt(params.get(0));
        int y1 = Integer.parseInt(params.get(1));
        int x2 = Integer.parseInt(params.get(2));
        int y2 = Integer.parseInt(params.get(3));

        validate(x1, y1, x2, y2);

        String line = getLine(x1, y1, x2, y2);

        System.out.print(line);
    }

    private String getLine(int x1, int y1, int x2, int y2) {
        draw(x1, y1, x2, y2, LINE_CHAR);
        return getShapeAsString();
    }

}
