package com.example.pubsub;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pubsub.adapter.TeamAdapter;

public class MainActivity extends AppCompatActivity {
    private TeamViewModel teamViewModel;
    private RecyclerView recyclerView;
    private TeamAdapter teamAdapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Define o layout da activity

        // 1. Inicializa as Views
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerViewTeams);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // 2. Inicializa o Adapter
        teamAdapter = new TeamAdapter();
        recyclerView.setAdapter(teamAdapter);

        // 3. Obtém o ViewModel
        // ViewModelProvider garante que você receba a mesma instância do ViewModel
        // mesmo após rotações de tela.
        teamViewModel = new ViewModelProvider(this).get(TeamViewModel.class);

        // 4. Observa o LiveData
        // Este é o passo mais importante. O código dentro do 'observe' será executado
        // sempre que os dados no ViewModel mudarem.
        teamViewModel.getAllTeams().observe(this, teams -> {
            progressBar.setVisibility(View.GONE); // Esconde o progresso
            if (teams != null) {
                teamAdapter.setTeams(teams);
                recyclerView.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(MainActivity.this, "Erro ao carregar os dados", Toast.LENGTH_SHORT).show();
            }
        });
    }
}