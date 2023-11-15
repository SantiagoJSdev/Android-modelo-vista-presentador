package com.redesip.hioposcloud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View {
    MainScreenContract.Presenter presenter;
    boolean titleVisible;
    TextView title;
    TextView clientList;
    Button showTitleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        initializeTitle();
    }

    private void initialize() {
        titleVisible = true;
        title = findViewById(R.id.textViewTitle);
        clientList = findViewById(R.id.textViewClients);
        showTitleButton = findViewById(R.id.buttonShowTitle);

        presenter = new PresenterImplements(this, new Modelmplements());
        presenter.onViewCreated();
    }

    private void initializeTitle() {
        showTitleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onHideTitleButtonPressed();
            }
        });
    }
    @Override
    public void showClients(List<String> clients) {
        clientList.setText("");
        for (int i = 0; i < clients.size(); i++) {
            clientList.append(String.valueOf(clients.get(i) + "\n"));
        }
    }

    @Override
    public void showTitle() {
    title.setVisibility(View.VISIBLE);
    titleVisible = true;
    }

    @Override
    public void hideTitle() {
        title.setVisibility(View.INVISIBLE);
        titleVisible = false;
    }

    @Override
    public boolean isTitleVisible() {
        return titleVisible;
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onViewDestroy();
    }

}