package com.pouillos.suiviseries.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import com.facebook.stetho.Stetho;
import com.google.android.material.snackbar.Snackbar;
import com.pouillos.suiviseries.R;
import com.pouillos.suiviseries.entities.Serie;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;

public class AccueilActivity extends NavDrawerActivity implements AdapterView.OnItemClickListener {

    Serie serieSelected;
    List<Serie> listSeriesBD;

    @BindView(R.id.selectSerie)
    AutoCompleteTextView selectedSerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_accueil);
        Stetho.initializeWithDefaults(this);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        selectedSerie.setOnItemClickListener(this);

        listSeriesBD = serieDao.loadAll();
        Collections.sort(listSeriesBD);
        if (listSeriesBD.size() == 0) {
            Snackbar.make(selectedSerie, R.string.text_no_matching, Snackbar.LENGTH_SHORT).setAnchorView(selectedSerie).show();
        } else {
            buildDropdownMenu(listSeriesBD, AccueilActivity.this,selectedSerie);
        }
        setTitle("Liste des Series");

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        serieSelected = listSeriesBD.get(position);
        ouvrirActiviteSuivante(this, AfficherSaisonActivity.class,"serieId",serieSelected.getId(),false);

    }

}
