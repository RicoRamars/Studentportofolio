package com.example.ricoramars.studentportofolio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Local variables
    private List<WebsiteReminder> mWebsite = new ArrayList<>();
    private WebsiteAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private EditText mNewReminderWebsite;
    private WebsiteReminder websiteReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getIntent();
        getIntent().getStringExtra("websiteReminder");

        mWebsite.add(new WebsiteReminder("VLO", "http://www.google.com"));

        RecyclerView mRecyclerView = findViewById(R.id.listView_main);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        WebsiteAdapter mAdapter = new WebsiteAdapter(this,mWebsite);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                System.out.println("wooehooee");
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SitesActivity.class);
                startActivityForResult(intent, 1234);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == 1234){
                Bundle bundle = data.getExtras();
                WebsiteReminder intentWebsiteReminder = (WebsiteReminder) bundle.getSerializable("WebsiteReminder");
                mWebsite.add(intentWebsiteReminder);
            }
        }
    }
}
