package com.example.ricoramars.studentportofolio;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class SitesActivity extends AppCompatActivity {

    EditText editUrl_Update;
    EditText editTitle_Update;
    Button button_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sites);

        editUrl_Update      = (EditText) findViewById(R.id.editUrl_Update);
        editTitle_Update    = (EditText) findViewById(R.id.editTitle_Update);

        editUrl_Update.setText("https://");

        Button button = (Button) findViewById(R.id.button_Add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent (SitesActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("WebsiteReminder", new WebsiteReminder(editTitle_Update.getText().toString(), editUrl_Update.getText().toString()));
                data.putExtras(bundle);

                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }
}
