package com.redesip.hioposcloud;

import java.util.ArrayList;
import java.util.List;

public class Modelmplements implements MainScreenContract.Model{
    List<String> clients;

    public Modelmplements() {
        clients = new ArrayList<>();
        clients.add("Santi");
        clients.add("Mia");
        clients.add("Vale");
        clients.add("Migue");
        clients.add("Margo");
    }

    @Override
    public List<String> getClients() {
        return clients;
    }
}
