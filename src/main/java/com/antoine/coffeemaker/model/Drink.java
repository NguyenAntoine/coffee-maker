package com.antoine.coffeemaker.model;

public enum Drink {
    TEA,
    COFFEE,
    CHOCOLATE;

    public String toString() {
        switch (this) {
            case TEA:
                return "tea";
            case COFFEE:
            default:
                return "coffee";
            case CHOCOLATE:
                return "chocolate";
        }
    }
}
