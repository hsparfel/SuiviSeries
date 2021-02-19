package com.pouillos.suiviseries.recycler.holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pouillos.suiviseries.R;
import com.pouillos.suiviseries.dao.EpisodeDao;
import com.pouillos.suiviseries.entities.Episode;
import com.pouillos.suiviseries.entities.Saison;
import com.pouillos.suiviseries.recycler.adapter.RecyclerAdapterSaison;
import com.pouillos.suiviseries.utils.BasicUtils;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHolderSaison extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.detail)
    TextView detail;

    private WeakReference<RecyclerAdapterSaison.Listener> callbackWeakRef;

    public RecyclerViewHolderSaison(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateWithSaison(Saison saison, RecyclerAdapterSaison.Listener callback){
        this.detail.setText(saison.toString());
        this.detail.setOnClickListener(this);
        this.callbackWeakRef = new WeakReference<RecyclerAdapterSaison.Listener>(callback);
    }

    @Override
    public void onClick(View view) {
        RecyclerAdapterSaison.Listener callback = callbackWeakRef.get();
        if (callback != null) callback.onClickSaisonButton(getAdapterPosition());
    }
}