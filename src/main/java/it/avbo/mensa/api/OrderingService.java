package it.avbo.mensa.api;

import java.util.List;

public interface OrderingService {
    void order(int entryId);
    List<Order> list();
}
