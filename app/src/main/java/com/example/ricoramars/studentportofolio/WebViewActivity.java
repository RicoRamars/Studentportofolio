package com.example.ricoramars.studentportofolio;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

       webView = findViewById(R.id.webViewID);


        webView = findViewById(R.id.webViewID);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(getIntent().getStringExtra("url"));
    }
}
