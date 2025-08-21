package com.example.pubsub.model;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pubsub.R;

public class TeamViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewTeamName;
    public TeamViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewTeamName = itemView.findViewById(R.id.textViewTeamName);
    }

    public void bind(Team team) {
        textViewTeamName.setText(team.getName());
    }
}
