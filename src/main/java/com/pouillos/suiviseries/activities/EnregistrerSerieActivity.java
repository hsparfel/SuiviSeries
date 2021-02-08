package com.pouillos.suiviseries.activities;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pouillos.suiviseries.R;
import com.pouillos.suiviseries.activities.afficher.AfficherEtablissementActivity;
import com.pouillos.suiviseries.dao.EtablissementDao;
import com.pouillos.suiviseries.entities.Etablissement;
import com.pouillos.suiviseries.entities.Serie;
import com.pouillos.suiviseries.entities.TypeEtablissement;
import com.pouillos.suiviseries.recycler.adapter.RecyclerAdapterEtablissement;
import com.pouillos.suiviseries.utils.ItemClickSupport;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import icepick.Icepick;
import icepick.State;

public class EnregistrerSerieActivity extends NavDrawerActivity {

    @BindView(R.id.textName)
    TextInputEditText textName;
    @BindView(R.id.layoutName)
    TextInputLayout layoutName;

    @BindView(R.id.fabSave)
    FloatingActionButton fabSave;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_enregistrer_serie);
        // 6 - Configure all views
        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        setTitle("Enregistrer Serie");

        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_search_etablissement).setChecked(true);
    }

    @OnClick(R.id.fabSave)
    public void fabSaveClick() {
        if (verifChamps() && !isExistant()) {
            Serie serie = new Serie();
            serie.setNom(textName.getText().toString().toUpperCase());
            Long serieId = serieDao.insert(serie);
            //todo ouvrir activite afficher avec intent serieId
        }
    }

    public boolean verifChamps() {
        boolean bool = true;
        if (!TextUtils.isEmpty(textName.getText()) && !isFilled(textName.getText())) {
            layoutName.setError(getString(R.string.not_valid));
            bool = false;
        } else {
            layoutName.setError(null);
        }
        return bool;
    }

    public boolean isExistant() {
        boolean bool = false;
        List<Serie> listSerie = serieDao.queryRaw("where name = ?",textName.getText().toString().toUpperCase());
        if (listSerie.size()>0) {
            layoutName.setError(getString(R.string.text_already_exist));
            bool = false;
        } else {
            layoutName.setError(null);
        }
        return bool;
    }
}
