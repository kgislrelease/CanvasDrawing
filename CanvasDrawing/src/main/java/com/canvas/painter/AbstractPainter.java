package com.canvas.painter;

import com.canvas.exception.CanvasExceptions;

import java.util.Arrays;

public abstract class AbstractPainter implements Painter {
    protected static final char LINE_CHAR = 'x';
    private static final String LINE_SEPARATOR = System
            .getProperty("line.separator");

    int width;
    int height;
    char[][] shape;

	void draw(int x1, int y1, int x2, int y2, char drawChar) {
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) {
                shape[i][x1] = drawChar;
            }
        } else if (y1 == y2) {
            Arrays.fill(shape[y1], x1, x2 + 1, drawChar);
        } else {
            double slope = (double) (y2 - y1) / (double) (x2 - x1);
            for (int i = y1; i <= y2; i++) {
                shape[i][(int) Math.ceil(x1 + (slope * i))] = drawChar;
            }
        }
    }

    String getShapeAsString() {
        StringBuilder results = new StringBuilder();
        for (char[] chars : shape) {
            for (char aChar : chars) {
                results.append(aChar == 0 ? " " : aChar);
            }
            results.append(LINE_SEPARATOR);
        }
        return results.toString();
    }

    void validate(int x1, int y1, int x2, int y2)
            throws CanvasExceptions {
        if (x1 >= 1 && y1 >= 1 && x2 >= 1 && y2 >= 1 && x1 <= width
                && y1 <= height && x2 <= width && y2 <= height && x1 <= x2
                && y1 <= y2) {
            return;
        }
        throw new CanvasExceptions(
                "Command is invalid");
    }
    
    public int getWidth() {
  		return width;
  	}

  	public void setWidth(int width) {
  		this.width = width;
  	}

  	public int getHeight() {
  		return height;
  	}

  	public void setHeight(int height) {
  		this.height = height;
  	}

  	public char[][] getShape() {
  		return shape;
  	}

  	public void setShape(char[][] shape) {
  		this.shape = shape;
  	}
}
