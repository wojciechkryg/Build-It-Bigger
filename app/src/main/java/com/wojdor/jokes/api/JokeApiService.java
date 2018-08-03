package com.wojdor.jokes.api;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;

import java.io.IOException;

public final class JokeApiService {

    private static final String BASE_URL = "http://10.0.2.2:8080/_ah/api/";

    private static JokeApi instance;

    private JokeApiService() {
    }

    public static JokeApi getInstance() {
        if (instance == null) {
            instance = getNewInstance();
        }
        return instance;
    }

    private static JokeApi getNewInstance() {
        JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl(BASE_URL)
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });
        return builder.build();
    }
}
