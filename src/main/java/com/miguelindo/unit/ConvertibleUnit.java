package com.miguelindo.unit;

public interface ConvertibleUnit {
    double convert(double value, ConvertibleUnit to);
    String getName(double value);
}