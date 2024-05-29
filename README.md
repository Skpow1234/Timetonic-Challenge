
# Timetonic Challenge API Client

## Overview

This repository contains the Java classes necessary to interact with the Timetonic API. It's designed as a simple, robust client for Android applications using Retrofit for HTTP requests and Gson for JSON conversion.

## Features

- **Singleton ApiService Class**: Ensures efficient use of resources by maintaining a single instance of the Retrofit client.
- **Login Functionality**: Includes methods to handle user authentication and session management.
- **Simple and Clear API**: Easy-to-use methods for API communication.

## Getting Started

### Prerequisites

- Android SDK with a minimum API level 21.
- Retrofit2
- Gson

### Installation

Add the following dependencies to your `build.gradle` file:

```gradle
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
```

### Usage

Here is a quick example of how to use the API client to perform a login operation:

```java
ApiService apiService = ApiService.getInstance();
Call<LoginResponse> call = apiService.login("user@example.com", "password");
call.enqueue(new Callback<LoginResponse>() {
    @Override
    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
        if (response.isSuccessful() && response.body() != null) {
            String sessionToken = response.body().getSessionToken();
            // Use the session token for subsequent requests
        }
    }

    @Override
    public void onFailure(Call<LoginResponse> call, Throwable t) {
        // Handle failure
    }
});
```

## Contribution

Contributions are welcome. Please fork this repository and submit a pull request to make improvements.

## License

Distributed under the MIT License. See `LICENSE` file for more information.
