package com.miguelindo.unit;

public enum LengthUnit implements ConvertibleUnit {
    KM("Kilometer", "Kilometers", 1000.0),
    HM("Hectometer", "Hectometers", 100.0),
    DA("Decameter", "Decameters", 10.0),
    M("Meter", "Meters", 1.0),
    DM("Decimeter", "Decimeters", 0.1),
    CM("Centimeter", "Centimeters", 0.01),
    MM("Millimeter", "Millimeters", 0.001),
    UM("Micrometer", "Micrometers", 1e-6),
    NM("Nanometer", "Nanometers", 1e-9),
    MI("Mile", "Miles", 1609.34),
    YD("Yard", "Yards", 0.9144),
    FT("Foot", "Feet", 0.3048),
    IN("Inch", "Inches", 0.0254),
    NMI("Nautical Mile", "Nautical Miles", 1852.0);

    private final String singular;
    private final String plural;
    private final double toMeterFactor;

    LengthUnit(String singular, String plural, double toMeterFactor) {
        this.singular = singular;
        this.plural = plural;
        this.toMeterFactor = toMeterFactor;
    }

    @Override
    public double convert(double value, ConvertibleUnit to) {
        return ((LengthUnit) to).fromMeters(this.toMeters(value));
    }

    @Override
    public String getName(double value) {
        return Math.abs(value) == 1.0 ? singular : plural;
    }

    private double toMeters(double value) {
        return value * toMeterFactor;
    }

    private double fromMeters(double meters) {
        return meters / toMeterFactor;
    }
}
