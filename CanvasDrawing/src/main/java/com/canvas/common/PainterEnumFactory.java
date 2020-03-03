package com.canvas.common;

import com.canvas.painter.*;

public enum PainterEnumFactory {

    C {
        @Override
        public AbstractPainter createPainter() {
            return new Canvas();
        }
    },
    L {
        @Override
        public AbstractPainter createPainter() {
            return new LinePainter();
        }
    },
    R {
        @Override
        public AbstractPainter createPainter() {
            return new RectanglePainter();
        }
    },
    B {
        @Override
        public AbstractPainter createPainter() {
            return new FillPainter();
        }
    },
    Q {
        @Override
        public AbstractPainter createPainter() {
            return new Quit();
        }
    };

    public abstract AbstractPainter createPainter();
}
