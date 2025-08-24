package com.example.pubsub.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pubsub.R;

import java.util.ArrayList;
import java.util.List;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MatchViewHolder> {

    private List<Match> matches = new ArrayList<>();

    public MatchesAdapter() {
        // começa vazio
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
        notifyDataSetChanged(); // atualiza a lista na tela
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_match, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match match = matches.get(position);

        holder.textMatchName.setText(match.getMatchName());

        String teams = match.getHomeTeam().getName() + " × " + match.getAwayTeam().getName();
        holder.textTeams.setText(teams);

        if (match.getScore() != null &&
                match.getScore().getHome() != null &&
                match.getScore().getAway() != null) {
            holder.textScore.setText(match.getScore().getHome() + " x " + match.getScore().getAway());
        } else {
            holder.textScore.setText("- x -");
        }

        holder.textStatus.setText("Status: " + match.getStatus());
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    static class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView textMatchName, textTeams, textScore, textStatus;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            textMatchName = itemView.findViewById(R.id.textMatchName);
            textTeams = itemView.findViewById(R.id.textTeams);
            textScore = itemView.findViewById(R.id.textScore);
            textStatus = itemView.findViewById(R.id.textStatus);
        }
    }
}
