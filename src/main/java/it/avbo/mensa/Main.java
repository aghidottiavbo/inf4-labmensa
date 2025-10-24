package it.avbo.mensa;

import it.avbo.mensa.api.*;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AuthenticationService authService = null;
        MenuService menuService = null;
        OrderingService orderingService = null;
        PersistenceService persistenceService = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Servizio mensa AVBO: Benvenuto!");

        Session session = null;
        while(session == null) {

            String username;
            System.out.println("Inserisci username");
            username = scanner.next();

            String password;
            System.out.println("Inserisci password");
            password = scanner.next();

            session = authService.login(username, password);
            if (session == null) {
                System.out.println("username o password errati.");
            }
        }

        if(!authService.isActive(session)){
            System.out.println("Sessione non attiva.");
            return;
        }

        System.out.println("Ecco il menu:");
        List<MenuEntry> entries = menuService.list();
        for(int id = 0; id < entries.size(); id++) {
            MenuEntry entry = entries.get(id);
            System.out.println((id+1) + " | " + entry);
        }

        int entryId = -1;
        while(entryId <= 0 || entryId >= entries.size()) {
            System.out.println("Digita l'ID della voce di menu che vuoi ordinare:");
            entryId = scanner.nextInt();
        }

        orderingService.order(entryId);
        orderingService.list();
    }
}