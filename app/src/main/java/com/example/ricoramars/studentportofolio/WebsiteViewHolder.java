package com.example.ricoramars.studentportofolio;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class WebsiteViewHolder extends RecyclerView.ViewHolder {

    public TextView websiteName;

    public WebsiteViewHolder(@NonNull View itemView) {
        super(itemView);

        websiteName =itemView.findViewById(R.id.PortalName);
    }
}
