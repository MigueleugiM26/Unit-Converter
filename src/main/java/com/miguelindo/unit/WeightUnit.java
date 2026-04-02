package com.miguelindo.unit;

public enum WeightUnit implements ConvertibleUnit {
    TON("Ton", "Tons", 1000.0),
    KG("Kilogram", "Kilograms", 1.0),
    HG("Hectogram", "Hectograms", 0.1),
    DAG("Decagram", "Decagrams", 0.01),
    G("Gram", "Grams", 0.001),
    DG("Decigram", "Decigrams", 0.0001),
    CG("Centigram", "Centigrams", 0.00001),
    MG("Milligram", "Milligrams", 1e-6),
    UG("Microgram", "Micrograms", 1e-9),
    LB("Pound", "Pounds", 0.45359237),
    OZ("Ounce", "Ounces", 0.028349523125),
    ST("Stone", "Stone", 6.35029318);


    private final String singular;
    private final String plural;
    private final double toKgFactor;

    WeightUnit(String singular, String plural, double toKgFactor) {
        this.singular = singular;
        this.plural = plural;
        this.toKgFactor = toKgFactor;
    }

    @Override
    public double convert(double value, ConvertibleUnit to) {
        return ((WeightUnit) to).fromKilograms(this.toKilograms(value));
    }

    @Override
    public String getName(double value) {
        return Math.abs(value) == 1.0 ? singular : plural;
    }


    private double toKilograms(double value) {
        return value * toKgFactor;
    }

    private double fromKilograms(double kg) {
        return kg / toKgFactor;
    }
}
