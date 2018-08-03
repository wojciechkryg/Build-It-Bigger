package com.udacity.gradle.builditbigger.api;

import android.os.AsyncTask;

import java.io.IOException;

public class JokeProvider extends AsyncTask<Void, Void, String> {

    private JokeCallback callback;

    public JokeProvider(JokeCallback callback) {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            return JokeApiService.getInstance().tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        callback.onJokeDownloaded(joke);
    }
}
