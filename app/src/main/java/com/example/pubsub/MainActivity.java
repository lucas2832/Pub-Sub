package com.example.pubsub;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pubsub.model.Team;
import com.example.pubsub.model.TeamsAdapter;
import com.example.pubsub.repository.TeamRepository;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerViewTeams);
        progressBar = findViewById(R.id.progressBar);

        TeamRepository.getInstance().getAllTeams().observe(this, (teams) -> {
            if (teams != null && !teams.isEmpty()) {
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new TeamsAdapter(teams));
                Log.d("MainActivity", "Total de times: " + teams.size());
            } else {
                Log.w("MainActivity", "Lista de times vazia ou nula");
            }
            progressBar.setVisibility(View.GONE);
        });
    }
}