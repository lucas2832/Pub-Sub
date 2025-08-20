package com.example.pubsub.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.pubsub.R;
import com.example.pubsub.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<Team> teams = new ArrayList<>();

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team currentTeam = teams.get(position);
        holder.textViewTeamName.setText(currentTeam.getName());
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public void setTeams(Object teams) {
        this.teams = teams;
        notifyDataSetChanged(); // Notifica o RecyclerView que os dados mudaram
    }

    // ViewHolder que "segura" as views de cada item da lista
    static class TeamViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTeamName;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTeamName = itemView.findViewById(R.id.textViewTeamName);
        }
    }
}
