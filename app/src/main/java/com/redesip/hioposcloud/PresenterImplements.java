package com.redesip.hioposcloud;

import java.util.List;

public class PresenterImplements implements MainScreenContract.Presenter {

    MainScreenContract.View view;
    MainScreenContract.Model model;

    public PresenterImplements(MainScreenContract.View view, MainScreenContract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void listClients() {
        List<String> clients = model.getClients();
        view.showClients(clients);
    }

    @Override
    public void onHideTitleButtonPressed() {
        if(view.isTitleVisible()) {
            view.hideTitle();
        } else {
            view.showTitle();
        }
    }

    @Override
    public void onViewDestroy() {
        this.view = null;
    }

    @Override
    public void onViewCreated() {
        listClients();
    }
}
