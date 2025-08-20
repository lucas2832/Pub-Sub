package com.example.pubsub.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    // Substitua pelo IP da sua máquina onde o backend está rodando
    // Use 10.0.2.2 se estiver rodando o app em um emulador Android
    private static final String BASE_URL = "http://10.0.2.2:3000/"; // Exemplo de URL

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
