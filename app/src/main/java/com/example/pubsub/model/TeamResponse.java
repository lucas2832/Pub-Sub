package com.example.pubsub.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TeamResponse {

    @SerializedName("data")
    private List<Team> data;

    public List<Team> getData() {
        return data;
    }

    public void setData(List<Team> data) {
        this.data = data;
    }
}
