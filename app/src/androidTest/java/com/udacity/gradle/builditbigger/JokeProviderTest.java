package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.api.JokeCallback;
import com.udacity.gradle.builditbigger.api.JokeProvider;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class JokeProviderTest {

    @Test
    public void jokeProvider_ShouldProvideNonEmptyJokes() throws ExecutionException, InterruptedException {
        JokeProvider jokeProvider = new JokeProvider(getMockedJokeCallback());
        jokeProvider.execute();
        String joke = jokeProvider.get();
        assertNotNull(joke);
        assertFalse(joke.isEmpty());
    }

    private JokeCallback getMockedJokeCallback() {
        return new JokeCallback() {
            @Override
            public void onJokeDownloaded(String joke) {
            }
        };
    }
}
