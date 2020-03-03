package com.canvas.painter;

import com.canvas.exception.CanvasExceptions;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class FillPainter extends AbstractPainter {

    @Override
    public void execute(List<String> params) throws CanvasExceptions {
        if (params.size() < 3 || !validParams(params)) {
            throw new CanvasExceptions(
                    "Fill painter expects 3 params");
        }
        int x = Integer.parseInt(params.get(0));
        int y = Integer.parseInt(params.get(1));
        char fillChar = params.get(2).charAt(0);

        String fill = fill(x, y, fillChar);

        System.out.println(fill);
    }

    private boolean validParams(List<String> params) {
        return isNumeric(params.get(0)) && isNumeric(params.get(1)) && params.get(2).length() == 1;
    }

    private String fill(int x, int y, char ch) {
        if (shape[y][x] != 0) {
            return "";
        }

        if (x > 0 || x < height || y > 0 || y < width) {
            if (shape[y][x] == 0)
                shape[y][x] = ch;
            fill(x + 1, y, ch);
            fill(x - 1, y, ch);
            fill(x, y - 1, ch);
            fill(x, y + 1, ch);
        }
        return getShapeAsString();
    }
}
