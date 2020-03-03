package com.canvas.painter;

import com.canvas.exception.CanvasExceptions;

import java.util.List;

public interface Painter {
    void execute(List<String> params) throws CanvasExceptions;
}
