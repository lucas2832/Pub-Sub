package com.example.pubsub.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("_id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("tla")
    private String tla;

    public String getId() {
        return id;
    }

    public String getName() {
        return name != null ? name : "(Sem nome)";
    }

    public String getTla() {
        return tla;
    }
}
