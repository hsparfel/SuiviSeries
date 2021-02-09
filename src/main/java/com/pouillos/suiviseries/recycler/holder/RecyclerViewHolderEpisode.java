package com.pouillos.suiviseries.recycler.holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pouillos.suiviseries.R;
import com.pouillos.suiviseries.entities.Episode;
import com.pouillos.suiviseries.recycler.adapter.RecyclerAdapterEpisode;
import com.pouillos.suiviseries.utils.BasicUtils;

import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHolderEpisode extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.detail)
    TextView detail;

    private WeakReference<RecyclerAdapterEpisode.Listener> callbackWeakRef;

    public RecyclerViewHolderEpisode(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateWithEpisode(Episode episode, RecyclerAdapterEpisode.Listener callback){
        this.detail.setText(episode.toString());
        this.detail.setOnClickListener(this);

        //4 - Create a new weak Reference to our Listener
        this.callbackWeakRef = new WeakReference<RecyclerAdapterEpisode.Listener>(callback);
    }

    @Override
    public void onClick(View view) {
        // 5 - When a click happens, we fire our listener.
        RecyclerAdapterEpisode.Listener callback = callbackWeakRef.get();
        if (callback != null) callback.onClickEpisodeButton(getAdapterPosition());
    }
}
