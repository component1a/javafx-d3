package org.treez.javafxd3.d3.democases.barchart;

import org.treez.javafxd3.d3.core.Value;
import org.treez.javafxd3.d3.functions.DatumFunction;
import org.treez.javafxd3.d3.scales.LinearScale;

import javafx.scene.web.WebEngine;
import netscape.javascript.JSObject;

public class BarChartHeightDatumFunction implements DatumFunction<Double> {
	
	private WebEngine webEngine;
	private BarChart barChart;
	
	public BarChartHeightDatumFunction(WebEngine webEngine, BarChart barChart){
		this.webEngine=webEngine;
		this.barChart = barChart;
	}

		@Override
		public Double apply(final Object context, final Object d, final int index) {

			JSObject jsDatum = (JSObject) d;
			Value value = new Value(webEngine, jsDatum);
			BarChartData data = value.<BarChartData> as();
			Double frequency = data.getFrequency();		
			
			LinearScale y = barChart.getYScale();			
			Value scaledValue = y.apply(frequency);			
			Double scaledDoubleValue = scaledValue.asDouble();	
			
			int height = barChart.getHeight();
			double result = height -scaledDoubleValue ;
			return result;
		}		
		

}