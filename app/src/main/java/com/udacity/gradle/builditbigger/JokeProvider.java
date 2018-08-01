package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;
import com.wojdor.jokeactivity.JokeActivity;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class JokeProvider extends AsyncTask<Void, Void, String> {

    private static JokeApi jokeApiService = null;

    private WeakReference<Context> weakContext;

    public JokeProvider(WeakReference<Context> weakContext) {
        this.weakContext = weakContext;
    }

    private static void createApiService() {
        JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });
        jokeApiService = builder.build();
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (jokeApiService == null) {
            createApiService();
        }
        try {
            return jokeApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        Context context = weakContext.get();
        if (context == null) return;
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_EXTRA, joke);
        context.startActivity(intent);
    }
}
