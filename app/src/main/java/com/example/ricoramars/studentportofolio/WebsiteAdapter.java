package com.example.ricoramars.studentportofolio;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WebsiteAdapter extends RecyclerView.Adapter<WebsiteViewHolder> {
    private Context context;
    private List<WebsiteReminder> mWebsite;

    public WebsiteAdapter(Context context, List<WebsiteReminder> mWebsite) {
        this.context = context;
        this.mWebsite = mWebsite;
    }

    @NonNull
    @Override
    public WebsiteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell,parent,false);
        return new WebsiteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WebsiteViewHolder holder, int position) {
        final WebsiteReminder websiteReminder= mWebsite.get(position);
        holder.websiteName.setText(websiteReminder.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("url", websiteReminder.getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mWebsite.size();
    }
    }