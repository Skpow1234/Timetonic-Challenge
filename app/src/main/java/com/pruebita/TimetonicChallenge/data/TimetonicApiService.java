package com.pruebita.TimetonicChallenge.data;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

// Interface defining the API endpoints
public interface TimetonicApiService {

    @FormUrlEncoded
    @POST("/createSesskey")
    // Method to perform login via API
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password
    );
}
