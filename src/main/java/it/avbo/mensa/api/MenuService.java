package it.avbo.mensa.api;

import java.util.List;

public interface MenuService {
    List<MenuEntry> list();
    void addEntry(String name, int kcal);
    void removeEntry(String name);
}
