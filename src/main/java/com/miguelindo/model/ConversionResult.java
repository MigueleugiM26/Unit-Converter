package com.miguelindo.model;

import com.miguelindo.unit.ConvertibleUnit;

public class ConversionResult {
    private final double originalValue;
    private final double result;
    private final ConvertibleUnit unitFrom;
    private final ConvertibleUnit unitTo;

    public ConversionResult (double originalValue, double result, ConvertibleUnit unitFrom, ConvertibleUnit unitTo) {
        this.originalValue = originalValue;
        this.result = result;
        this.unitFrom = unitFrom;
        this.unitTo = unitTo;
    }

    public String getResultString() {
        String formattedOriginal = formatNumber(originalValue);
        String formattedResult = formatNumber(result);
        String fromLabel = unitFrom.getName(originalValue);
        String toLabel = unitTo.getName(result);

        return formattedOriginal + " " + fromLabel + " is equivalent to " + formattedResult + " " + toLabel;
    }

    private String formatNumber(double value) {
        if (value == Math.floor(value) && !Double.isInfinite(value)) {
            return String.valueOf((long) value); // no decimal places
        }
        return String.valueOf(value);
    }
}
