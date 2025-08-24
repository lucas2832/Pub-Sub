package com.example.pubsub.model;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pubsub.R;

public class MatchViewHolder extends RecyclerView.ViewHolder {

    private TextView textMatchName, textTeams, textScore, textStatus;

    public MatchViewHolder(@NonNull View itemView) {
        super(itemView);
        textMatchName = itemView.findViewById(R.id.textMatchName);
        textTeams = itemView.findViewById(R.id.textTeams);
        textScore = itemView.findViewById(R.id.textScore);
        textStatus = itemView.findViewById(R.id.textStatus);
    }

    public void bind(Match match) {
        Log.d("MatchViewHolder", "Exibindo partida: " + match.getMatchName());

        textMatchName.setText(match.getMatchName());

        String teams = match.getHomeTeam().getName() + " × " + match.getAwayTeam().getName();
        textTeams.setText(teams);

        if (match.getScore() != null &&
                match.getScore().getHome() != null &&
                match.getScore().getAway() != null) {
            textScore.setText(match.getScore().getHome() + " x " + match.getScore().getAway());
        } else {
            textScore.setText("- x -");
        }

        textStatus.setText("Status: " + match.getStatus());
    }
}
