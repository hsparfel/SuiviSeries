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

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pouillos.suiviseries.R;
import com.pouillos.suiviseries.dao.EpisodeDao;
import com.pouillos.suiviseries.entities.Episode;
import com.pouillos.suiviseries.entities.Saison;
import com.pouillos.suiviseries.recycler.adapter.RecyclerAdapterEpisode;
import com.pouillos.suiviseries.utils.BasicUtils;
import com.pouillos.suiviseries.utils.ItemClickSupport;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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
        }
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
        //episodeDao.queryRaw("select * from ");
        //HomeItem2 homeItem2Dao = ((Application) context.getApplicationContext()).getDaoSession().getHomeItem2Dao();
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

