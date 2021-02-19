package com.pouillos.suiviseries.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.stetho.Stetho;
import com.google.android.material.snackbar.Snackbar;
import com.pouillos.suiviseries.R;
import com.pouillos.suiviseries.entities.Saison;
import com.pouillos.suiviseries.entities.Serie;
import com.pouillos.suiviseries.recycler.adapter.RecyclerAdapterSaison;
import com.pouillos.suiviseries.recycler.adapter.RecyclerAdapterSerie;
import com.pouillos.suiviseries.utils.ItemClickSupport;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;

public class AccueilActivity extends NavDrawerActivity implements AdapterView.OnItemClickListener, RecyclerAdapterSerie.Listener {

    Serie serieSelected;
    List<Serie> listSeriesBD;

    @BindView(R.id.selectSerie)
    AutoCompleteTextView selectedSerie;

    List<Saison> listSaison;
    private RecyclerAdapterSerie adapterSerie;
    @BindView(R.id.list_recycler_saison)
    RecyclerView list_recycler_saison;

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
        //listSaison = saisonDao.loadAll();
        listSaison = saisonDao.queryRaw("where vu = ?", "0");
        configureRecyclerView();
        configureOnClickRecyclerView();
    }

    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(list_recycler_saison, R.layout.recycler_list_saison)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Log.e("TAG", "Position : "+position);
                    }
                });
    }

    public void configureRecyclerView() {
        adapterSerie = new RecyclerAdapterSerie(listSaison, this);
        list_recycler_saison.setAdapter(adapterSerie);
        list_recycler_saison.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClickSerieButton(int position) {
        Saison saison = listSaison.get(position);
        ouvrirActiviteSuivante(this, AfficherEpisodeActivity.class,"saisonId",saison.getId(),false);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        serieSelected = listSeriesBD.get(position);
        ouvrirActiviteSuivante(this, AfficherSaisonActivity.class,"serieId",serieSelected.getId(),false);
    }
}
