package com.example.pubsub.model;

import java.util.List;

public class TeamResponse {
    private List<Team> data;

    public void setData(List<Team> data) {
        this.data = data;
    }

    public List<Team> getData() {
        return data;
    }
}
