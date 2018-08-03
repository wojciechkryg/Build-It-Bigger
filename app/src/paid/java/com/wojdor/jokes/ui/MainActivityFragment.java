package com.wojdor.jokes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wojdor.jokeactivity.JokeActivity;
import com.wojdor.jokes.api.JokeCallback;
import com.wojdor.jokes.api.JokeProvider;
import com.wojdor.jokes.builditbigger.R;

public class MainActivityFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        initJokeBtn(root);
        return root;
    }

    private void initJokeBtn(View root) {
        Button jokeBtn = root.findViewById(R.id.fragment_main_joke_btn);
        jokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showJoke();
            }
        });
    }

    public void showJoke() {
        new JokeProvider(getJokeCallback()).execute();
    }

    public JokeCallback getJokeCallback() {
        return new JokeCallback() {
            @Override
            public void onJokeDownloaded(String joke) {
                Intent intent = new Intent(getContext(), JokeActivity.class);
                intent.putExtra(JokeActivity.JOKE_EXTRA, joke);
                startActivity(intent);
            }
        };
    }
}
