package com.pruebita.TimetonicChallenge.data;

import com.google.gson.annotations.SerializedName;

// Class to capture login response from the API
public class LoginResponse {
    @SerializedName("success")
    private boolean success;

    @SerializedName("session_token")
    private String sessionToken;

    // Getter to check if login was successful
    public boolean isSuccess() {
        return success;
    }

    // Getter to retrieve session token
    public String getSessionToken() {
        return sessionToken;
    }
}
