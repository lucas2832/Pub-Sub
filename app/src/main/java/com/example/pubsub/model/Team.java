package com.example.pubsub.model;

import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("_id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("tla")
    private String tla;

    @SerializedName("crest")
    private String crest;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
