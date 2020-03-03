package com.canvas.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PainterInput {
    private PainterEnumFactory painterEnumFactory;
    private List<String> params = new ArrayList<>();

    
    
    public PainterEnumFactory getPainterEnumFactory() {
		return painterEnumFactory;
	}



	public void setPainterEnumFactory(PainterEnumFactory painterEnumFactory) {
		this.painterEnumFactory = painterEnumFactory;
	}



	public List<String> getParams() {
		return params;
	}



	public void setParams(List<String> params) {
		this.params = params;
	}



	public PainterInput(String input) {
        String[] inputs = input.split(" ");
        this.painterEnumFactory = PainterEnumFactory.valueOf(inputs[0].toUpperCase());
        this.params = Arrays.stream(inputs).skip(1).collect(Collectors.toList());
    }
    
}
