package com.wojdor.jokeactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA = "com.wojdor.jokeactivity.JOKE_EXTRA";

    private TextView jokeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        initComponents();
        handleIntent();
    }

    private void initComponents() {
        jokeTv = findViewById(R.id.activity_joke_joke_tv);
    }

    private void handleIntent() {
        Bundle bundle = getIntent().getExtras();
        String joke = obtainJoke(bundle, getString(R.string.joke_activity_no_joke));
        jokeTv.setText(joke);
    }

    private String obtainJoke(Bundle bundle, String defaultJoke) {
        if (bundle == null) return defaultJoke;
        return bundle.getString(JOKE_EXTRA, defaultJoke);
    }
}
