package com.miguelindo.unit;

public enum TemperatureUnit implements ConvertibleUnit {
    K("Kelvin", "Kelvins") {
        @Override
        public double toKelvin(double value) {
            return value;
        }

        @Override
        public double fromKelvin(double kelvin) {
            return kelvin;
        }
    },

    C("Celsius", "Celsius") {
        @Override
        public double toKelvin(double value) {
            return value + 273.15;
        }

        @Override
        public double fromKelvin(double kelvin) {
            return kelvin - 273.15;
        }
    },

    F("Fahrenheit", "Fahrenheit") {
        @Override
        public double toKelvin(double value) {
            return (value - 32) * 5/9 + 273.15;
        }

        @Override
        public double fromKelvin(double kelvin) {
            return (kelvin - 273.15) * 9/5 + 32;
        }
    };


    private final String singular;
    private final String plural;

    TemperatureUnit(String singular, String plural) {
        this.singular = singular;
        this.plural = plural;
    }

    @Override
    public double convert(double value, ConvertibleUnit to) {
        return ((TemperatureUnit) to).fromKelvin(this.toKelvin(value));
    }

    @Override
    public String getName(double value) {
        return Math.abs(value) == 1.0 ? singular : plural;
    }

    public abstract double toKelvin(double value);
    public abstract double fromKelvin(double kelvin);
}
