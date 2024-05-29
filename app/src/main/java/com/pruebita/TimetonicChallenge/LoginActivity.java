package com.pruebita.TimetonicChallenge;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pruebita.TimetonicChallenge.data.ApiService;
import com.pruebita.TimetonicChallenge.data.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        emailEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        // Get the singleton instance of ApiService
        apiService = ApiService.getInstance();

        // Set onClickListener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });
    }

    private void performLogin() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Perform API call to login
        Call<LoginResponse> call = apiService.login(email, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    if (loginResponse != null && loginResponse.isSuccess()) {
                        String sessionToken = loginResponse.getSessionToken();
                        // Handle successful login with session token
                        handleSuccess(sessionToken);
                    } else {
                        showMessage("Login Error");
                    }
                } else {
                    showMessage("Server Error");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                showMessage("Network Error: " + t.getMessage());
            }
        });
    }

    private void handleSuccess(String sessionToken) {
        // Navigate to next screen or store the session token
        Toast.makeText(this, "Login Successful! Token: " + sessionToken, Toast.LENGTH_LONG).show();
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
