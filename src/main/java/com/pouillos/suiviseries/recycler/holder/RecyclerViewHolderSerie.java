package com.pouillos.suiviseries.recycler.holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pouillos.suiviseries.R;
import com.pouillos.suiviseries.entities.Saison;
import com.pouillos.suiviseries.entities.Serie;
import com.pouillos.suiviseries.recycler.adapter.RecyclerAdapterSerie;
import com.pouillos.suiviseries.utils.BasicUtils;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHolderSerie extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.detail)
    TextView detail;

    private WeakReference<RecyclerAdapterSerie.Listener> callbackWeakRef;

    public RecyclerViewHolderSerie(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateWithSerie(Saison saison, RecyclerAdapterSerie.Listener callback){
        //todo revoir le set text
        this.detail.setText(saison.getSerie().toString()+" - S"+ BasicUtils.afficherChiffre(saison.getNumSaison()));
        this.detail.setOnClickListener(this);
        this.callbackWeakRef = new WeakReference<RecyclerAdapterSerie.Listener>(callback);
    }

    @Override
    public void onClick(View view) {
        RecyclerAdapterSerie.Listener callback = callbackWeakRef.get();
        if (callback != null) callback.onClickSerieButton(getAdapterPosition());
    }
}