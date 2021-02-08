package com.pouillos.suiviseries.entities;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;



import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.converter.PropertyConverter;

import java.io.IOException;
import java.util.List;

import com.pouillos.suiviseries.enumeration.Langage;
import com.pouillos.suiviseries.dao.DaoSession;
import com.pouillos.suiviseries.dao.SerieDao;
import com.pouillos.suiviseries.dao.SuiviDao;

@Entity
public class Suivi implements Comparable<Suivi> {

    @Id
    private Long id;

    private long serieId;
    @ToOne(joinProperty = "serieId")
    private Serie serie;

    private int saison;
    private int episode;

    @Convert(converter = LangageConverter.class, columnType = String.class)
    private Langage langage;

    boolean vu;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 170848578)
    private transient SuiviDao myDao;





    @Generated(hash = 1990933851)
    public Suivi(Long id, long serieId, int saison, int episode, Langage langage,
            boolean vu) {
        this.id = id;
        this.serieId = serieId;
        this.saison = saison;
        this.episode = episode;
        this.langage = langage;
        this.vu = vu;
    }

    @Generated(hash = 1535704729)
    public Suivi() {
    }





    @Generated(hash = 801892098)
    private transient Long serie__resolvedKey;





    @Override
    public String toString() {
        String string = "";
        string += this.getSerie()+" - ";
        if (this.getSaison()<10) {
            string += "0";
        }
        string += this.getSaison()+" - ";


        return string;
    }

    @Override
    public int compareTo(Suivi o) {
        return this.getSerie().compareTo(o.getSerie());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getSerieId() {
        return this.serieId;
    }

    public void setSerieId(long serieId) {
        this.serieId = serieId;
    }

    public int getSaison() {
        return this.saison;
    }

    public void setSaison(int saison) {
        this.saison = saison;
    }

    public int getEpisode() {
        return this.episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public Langage getLangage() {
        return this.langage;
    }

    public void setLangage(Langage langage) {
        this.langage = langage;
    }

    public boolean getVu() {
        return this.vu;
    }

    public void setVu(boolean vu) {
        this.vu = vu;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 806585660)
    public Serie getSerie() {
        long __key = this.serieId;
        if (serie__resolvedKey == null || !serie__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SerieDao targetDao = daoSession.getSerieDao();
            Serie serieNew = targetDao.load(__key);
            synchronized (this) {
                serie = serieNew;
                serie__resolvedKey = __key;
            }
        }
        return serie;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1786307989)
    public void setSerie(@NotNull Serie serie) {
        if (serie == null) {
            throw new DaoException(
                    "To-one property 'serieId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.serie = serie;
            serieId = serie.getId();
            serie__resolvedKey = serieId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 233158676)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSuiviDao() : null;
    }





    public static class LangageConverter implements PropertyConverter<Langage, String> {
        @Override
        public Langage convertToEntityProperty(String databaseValue) {
            return Langage.valueOf(databaseValue);
        }

        @Override
        public String convertToDatabaseValue(Langage entityProperty) {
            return entityProperty.name();
        }
    }
    
}
