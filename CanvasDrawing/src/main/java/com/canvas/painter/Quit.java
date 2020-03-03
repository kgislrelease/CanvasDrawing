package com.canvas.painter;

import java.util.List;

public class Quit extends AbstractPainter {

    @Override
    public void execute(final List<String> params) {
        System.exit(0);
    }
}
