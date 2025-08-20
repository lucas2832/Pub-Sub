package com.example.pubsub.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.pubsub.api.ApiService;
import com.example.pubsub.model.Team;
import com.example.pubsub.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Repositório para gerenciar os dados dos Times.
 * É a única fonte de verdade para os dados dos times, decidindo se busca da API
 * ou de um cache local (não implementado neste exemplo).
 */
public class TeamRepository {

    private static TeamRepository instance;
    private final ApiService apiService;

    private TeamRepository() {
        // Cria a implementação da nossa interface ApiService usando o Retrofit
        apiService = RetrofitClient.getClient().create(ApiService.class);
    }

    // Padrão Singleton para garantir uma única instância do repositório
    public static synchronized TeamRepository getInstance() {
        if (instance == null) {
            instance = new TeamRepository();
        }
        return instance;
    }

    /**
     * Busca a lista de todos os times da API.
     * @return LiveData que conterá a lista de times ou null em caso de erro.
     */
    public LiveData<List<Team>> getAllTeams() {
        final MutableLiveData<List<Team>> data = new MutableLiveData<>();

        // Executa a chamada de rede de forma assíncrona
        apiService.getAllTeams().enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                Log.e("TeamRepository", "API call failed.", t);
                data.setValue(null); // Informa a UI que houve um erro
            }
        });

        return data;
    }

}
