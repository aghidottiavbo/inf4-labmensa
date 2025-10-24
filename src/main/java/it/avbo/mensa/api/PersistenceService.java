package it.avbo.mensa.api;

import java.util.List;

public interface PersistenceService {
    List<Order> loadOrders();
    List<MenuEntry> loadMenu();
    void saveOrders(List<Order> orders);
    void saveMenu(List<MenuEntry> menu);
}
