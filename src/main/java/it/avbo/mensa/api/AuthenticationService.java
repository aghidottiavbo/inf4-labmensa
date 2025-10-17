package it.avbo.mensa.api;

public interface AuthenticationService {

    Session login(String username, String password);

    boolean isActive(Session session);

    void logout(Session session);
}
