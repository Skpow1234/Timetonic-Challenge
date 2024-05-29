package com.pruebita.TimetonicChallenge.data;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Singleton class to manage Retrofit instance
public class ApiService {
    private static final String BASE_URL = "https://timetonic.com/";
    private static ApiService instance; // Singleton instance
    private TimetonicApiService apiService;

    // Private constructor to prevent external instantiation
    private ApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(TimetonicApiService.class);
    }

    // Public method to get the singleton instance
    public static synchronized ApiService getInstance() {
        if (instance == null) {
            instance = new ApiService();
        }
        return instance;
    }

    // Method to perform login operation
    public Call<LoginResponse> login(String email, String password) {
        return apiService.login(email, password);
    }
}
