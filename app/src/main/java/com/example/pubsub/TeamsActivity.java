package com.example.pubsub;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pubsub.model.Team;
import com.example.pubsub.model.TeamsAdapter;
import com.example.pubsub.repository.TeamRepository;

import java.util.List;

public class TeamsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TeamsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        recyclerView = findViewById(R.id.recyclerViewTeams);
        progressBar = findViewById(R.id.progressBarTeams);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TeamsAdapter(null);
        recyclerView.setAdapter(adapter);

        progressBar.setVisibility(View.VISIBLE);

        TeamRepository.getInstance().getAllTeams().observe(this, new Observer<List<Team>>() {
            @Override
            public void onChanged(List<Team> teams) {
                progressBar.setVisibility(View.GONE);
                if (teams != null) {
                    adapter = new TeamsAdapter(teams);
                    recyclerView.setAdapter(adapter);
                }
            }
        });
    }
}
