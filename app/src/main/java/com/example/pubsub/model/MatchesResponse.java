package com.example.pubsub.model;

import java.util.List;

public class MatchesResponse {
    private boolean success;
    private String message;
    private List<Match> data;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<Match> getData() {
        return data;
    }
}
