package com.pouillos.suiviseries.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

@Entity
public class Serie implements Comparable<Serie> {

    @Id
    private Long id;

    @NotNull
    private String nom;

    @Generated(hash = 1189692625)
    public Serie(Long id, @NotNull String nom) {
        this.id = id;
        this.nom = nom;
    }

    @Generated(hash = 1219348851)
    public Serie() {
    }

    @Override
    public int compareTo(Serie o) {
        return this.getNom().compareTo(o.getNom());
    }

    @Override
    public String toString() {
        return nom;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
