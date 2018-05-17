package com.slabiak.service;

import com.slabiak.model.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("rest/task")
    Call<ApiResponse> getNumbers();
}