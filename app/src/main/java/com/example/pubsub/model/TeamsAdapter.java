package com.example.pubsub.model;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pubsub.R;
import com.google.gson.Gson;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamViewHolder> {

    private List<Team> teams;

    public TeamsAdapter(List<Team> teams) {
        this.teams = teams;
        Log.d("TeamsAdapter", "Times: " + new Gson().toJson(teams));

    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_team, parent, false);
        Log.d("TeamsAdapter", "Criando ViewHolder");
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        holder.bind(teams.get(position));
    }

    @Override
    public int getItemCount() {
        int count = (teams != null ? teams.size() : 0);
        Log.d("TeamsAdapter", "getItemCount = " + count);
        return count;
    }
}
