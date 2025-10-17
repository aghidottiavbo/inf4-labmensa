package it.avbo.mensa.api;

public record MenuEntry(String name, int kcal) {

    @Override
    public String toString() {
        return name + ", kcal=" + kcal;
    }
}
