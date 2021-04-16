package com.pouillos.suiviseries.activities;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pouillos.suiviseries.R;
import com.pouillos.suiviseries.dao.EpisodeDao;
import com.pouillos.suiviseries.entities.Episode;
import com.pouillos.suiviseries.entities.Saison;
import com.pouillos.suiviseries.entities.Serie;
import com.pouillos.suiviseries.recycler.adapter.RecyclerAdapterEpisode;
import com.pouillos.suiviseries.utils.BasicUtils;
import com.pouillos.suiviseries.utils.ItemClickSupport;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import icepick.Icepick;

public class AfficherEpisodeActivity extends NavDrawerActivity implements RecyclerAdapterEpisode.Listener {

    Saison saisonTransmise;
    
    @BindView(R.id.layoutName)
    TextInputLayout layoutName;
    @BindView(R.id.textName)
    TextInputEditText textName;

    int nbEpisode;
    List<Episode> listEpisode;

    @BindView(R.id.list_recycler_episode)
    RecyclerView list_recycler_episode;

    @BindView(R.id.fabDelete)
    FloatingActionButton fabDelete;

    private RecyclerAdapterEpisode adapterEpisode;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_episode);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        listEpisode = new ArrayList<>();
        nbEpisode = 0;
        layoutName.setEnabled(false);
        traiterIntent();
        setTitle("Liste des Episodes");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_add_serie).setChecked(true);
    }

    public void traiterIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("saisonId")) {
            Long saisonId = intent.getLongExtra("saisonId", 0);
            saisonTransmise = saisonDao.load(saisonId);
            fillAllFields();
            //identifier le nb de episodes de la saison
            listEpisode = episodeDao.queryRaw("where saison_Id = ?",saisonTransmise.getId().toString());
            nbEpisode = listEpisode.size();
            configureRecyclerView();
            configureOnClickRecyclerView();
            if(isDerniereSaison() && !saisonTransmise.getSerie().getFini()) {
                fabDelete.show();
            }
        }
    }

    @OnClick(R.id.fabDelete)
    public void setFabDeleteClick() {
        for (Episode episode : listEpisode) {
            episodeDao.delete(episode);
        }
        saisonDao.delete(saisonTransmise);
        if (isOnlySaison()) {
            serieDao.delete(saisonTransmise.getSerie());
            ouvrirActiviteSuivante(this, AccueilActivity.class,true);

        } else {
            ouvrirActiviteSuivante(this, AfficherSaisonActivity.class,"serieId",saisonTransmise.getSerie().getId(),true);

        }
    }

    private boolean isOnlySaison() {
        boolean bool = false;
        List<Saison> listSaison = saisonDao.queryRaw("where serie_Id = ?",saisonTransmise.getSerie().getId().toString());
        int nbSaison = listSaison.size();
        if (nbSaison == 0) {
            bool = true;
        }
        return bool;
    }

    private boolean isDerniereSaison() {
        boolean bool = false;
        List<Saison> listSaison = saisonDao.queryRaw("where serie_Id = ?",saisonTransmise.getSerie().getId().toString());
        int nbSaison = listSaison.size();
        if (nbSaison == saisonTransmise.getNumSaison()) {
            bool = true;
        }
        return bool;
    }

    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(list_recycler_episode, R.layout.recycler_list_episode)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Log.e("TAG", "Position : "+position);
                    }
                });
    }

    public void configureRecyclerView() {
        adapterEpisode = new RecyclerAdapterEpisode(listEpisode, this);
        list_recycler_episode.setAdapter(adapterEpisode);
        list_recycler_episode.setLayoutManager(new LinearLayoutManager(this));
    }

    private void fillAllFields() {
        textName.setText(saisonTransmise.getSerie().toString()+" - Saison "+BasicUtils.afficherChiffre(saisonTransmise.getNumSaison()));
    }

    @Override
    public void onClickEpisodeButton(int position) {
        Episode episode = listEpisode.get(position);
        episode.setVu(!episode.getVu());
        episodeDao.update(episode);
        QueryBuilder<Episode> queryBuilder =
                episodeDao.queryBuilder().where(
                        EpisodeDao.Properties.Vu.eq(true),
                        EpisodeDao.Properties.SaisonId.eq(saisonTransmise.getId()));
        long count = queryBuilder.buildCount().count();
        if (count == saisonTransmise.getNbEpisodes()) {
            saisonTransmise.setVu(true);
            saisonDao.update(saisonTransmise);
        }
        configureRecyclerView();
    }
}