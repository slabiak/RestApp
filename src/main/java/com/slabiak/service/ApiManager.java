package com.slabiak.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.slabiak.model.ApiResponse;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

import java.io.IOException;

public class ApiManager {

    private static ApiService apiService;

    public static ApiService getClient()
    {
        if(apiService==null)
        {
            createClient();
        }
        return apiService;
    }

    private static void createClient() {

        final String BASE_URL = " http://dt-gwitczak-recruitment.westeurope.cloudapp.azure.com:8080/";
        final String USERNAME = "candidate";
        final String PASSWORD = "abc123";


        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        Credentials.basic(USERNAME, PASSWORD));

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiService = retrofit.create(ApiService.class);
    }
}
