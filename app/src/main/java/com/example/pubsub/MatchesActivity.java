package com.example.pubsub;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pubsub.model.Match;
import com.example.pubsub.model.MatchesAdapter;
import com.example.pubsub.repository.MatchRepository;

import java.util.List;

public class MatchesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MatchesAdapter adapter;
    private Button btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        recyclerView = findViewById(R.id.recyclerViewMatches);
        progressBar = findViewById(R.id.progressBarMatches);
        btnRefresh = findViewById(R.id.btnRefresh);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MatchesAdapter();
        recyclerView.setAdapter(adapter);

        // primeira busca
        fetchMatches();

        btnRefresh.setOnClickListener(v -> {
            fetchMatches(); // recarrega a API
        });
    }

    private void fetchMatches() {
        progressBar.setVisibility(View.VISIBLE);

        MatchRepository.getInstance().getAllMatches().observe(this, new Observer<List<Match>>() {
            @Override
            public void onChanged(List<Match> matches) {
                progressBar.setVisibility(View.GONE);
                if (matches != null) {
                    adapter.setMatches(matches);
                }
            }
        });
    }
}
