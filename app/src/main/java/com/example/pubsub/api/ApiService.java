package com.example.pubsub.api;

import com.example.pubsub.model.League;
import com.example.pubsub.model.Match;
import com.example.pubsub.model.MatchesResponse;
import com.example.pubsub.model.Team;
import com.example.pubsub.model.TeamResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("teams") // Endpoint para buscar todos os times
    Call<TeamResponse> getAllTeams();

    @GET("leagues") // Endpoint para buscar todas as ligas
    Call<List<League>> getAllLeagues();

    @GET("matches")
    Call<MatchesResponse> getMatches();


}

