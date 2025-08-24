package com.example.pubsub;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pubsub.model.MatchesAdapter;
import com.example.pubsub.model.Match;
import com.example.pubsub.repository.MatchRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MatchesAdapter adapter;
    private MatchRepository matchRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewMatches);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MatchesAdapter();
        recyclerView.setAdapter(adapter);

        matchRepository = MatchRepository.getInstance();

        // Observa os dados vindos da API
        matchRepository.getAllMatches().observe(this, new Observer<List<Match>>() {
            @Override
            public void onChanged(List<Match> matches) {
                if (matches != null && !matches.isEmpty()) {
                    adapter.setMatches(matches);
                } else {
                    Log.e("MainActivity", "Nenhuma partida recebida.");
                }
            }
        });
    }
}