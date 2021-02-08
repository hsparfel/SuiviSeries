package com.pouillos.suiviseries.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

@Entity
public class ContactIgnore implements Comparable<ContactIgnore>{

    @Id
    private Long id;

    @NotNull
    private String idPP;

    private String fichierImport;

    private int numLigne;



    @Generated(hash = 409989920)
    public ContactIgnore(Long id, @NotNull String idPP, String fichierImport,
            int numLigne) {
        this.id = id;
        this.idPP = idPP;
        this.fichierImport = fichierImport;
        this.numLigne = numLigne;
    }

    @Generated(hash = 1137428311)
    public ContactIgnore() {
    }



    @Override
    public String toString() {
        return idPP+" - "+fichierImport;
    }

    @Override
    public int compareTo(ContactIgnore o) {
        return this.idPP.compareTo(o.idPP);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdPP() {
        return this.idPP;
    }

    public void setIdPP(String idPP) {
        this.idPP = idPP;
    }

    public String getFichierImport() {
        return this.fichierImport;
    }

    public void setFichierImport(String fichierImport) {
        this.fichierImport = fichierImport;
    }

    public int getNumLigne() {
        return this.numLigne;
    }

    public void setNumLigne(int numLigne) {
        this.numLigne = numLigne;
    }

    

}
