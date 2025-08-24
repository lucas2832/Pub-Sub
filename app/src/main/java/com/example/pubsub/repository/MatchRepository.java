package com.example.pubsub.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pubsub.api.ApiService;
import com.example.pubsub.model.Match;
import com.example.pubsub.model.MatchesResponse;
import com.example.pubsub.network.RetrofitClient;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchRepository {

    private static MatchRepository instance;
    private final ApiService apiService;

    private MatchRepository() {
        apiService = RetrofitClient.getClient().create(ApiService.class);
    }

    public static synchronized MatchRepository getInstance() {
        if (instance == null) {
            instance = new MatchRepository();
        }
        return instance;
    }

    public LiveData<List<Match>> getAllMatches() {
        MutableLiveData<List<Match>> data = new MutableLiveData<>();

        apiService.getMatches().enqueue(new Callback<MatchesResponse>() {
            @Override
            public void onResponse(Call<MatchesResponse> call, Response<MatchesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("MatchRepository", "Resposta: " + new Gson().toJson(response.body()));
                    data.setValue(response.body().getData());
                } else {
                    Log.e("MatchRepository", "Resposta inválida da API.");
                    data.setValue(Collections.emptyList());
                }
            }

            @Override
            public void onFailure(Call<MatchesResponse> call, Throwable t) {
                Log.e("MatchRepository", "Falha na API de partidas.", t);
                data.setValue(Collections.emptyList());
            }
        });

        return data;
    }
}
