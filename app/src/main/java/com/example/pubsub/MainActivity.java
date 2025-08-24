package com.example.pubsub;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTeams = findViewById(R.id.btnTeams);
        Button btnMatches = findViewById(R.id.btnMatches);

        btnTeams.setOnClickListener(v ->
                startActivity(new Intent(this, TeamsActivity.class)));

        btnMatches.setOnClickListener(v ->
                startActivity(new Intent(this, MatchesActivity.class)));
    }
}
