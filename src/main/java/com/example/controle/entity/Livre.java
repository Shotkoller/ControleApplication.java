package com.example.controle.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Livre {

    private @Id @GeneratedValue Long id;
    @Column(length=50,nullable=false)
    private String titre;
    @Column(nullable=false,updatable=false)
    private String maison_edition;
    @Column(name="date_sortie", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date date_sortie;
    @Column(nullable=false)
    private String Auteur;
    @Column(nullable=false)
    private int nombre_page;
    @Column(nullable=false)
    @Temporal(TemporalType.DATE)
    private Date date_dernier_consultation;
    @Column(unique=true,nullable=false,updatable=false)
    private int Isbn;
    @Column(nullable=false)
    private boolean disponible;

    Livre(){}

    public Livre(String titre, String maison_edition, Date date_sortie, String auteur, int nbr_page, int isbn, boolean dispo, Date date_dernier_consultation)
    {
        this.titre = titre;
        this.maison_edition = maison_edition;
        this.date_sortie = date_sortie;
        this.Auteur = auteur;
        this.nombre_page = nbr_page;
        this.date_dernier_consultation = date_dernier_consultation;
        this.Isbn = isbn;
        this.disponible = dispo;

    }

    public Long getId()
    {
        return this.id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getTitre()
    {
        return this.titre;
    }
    public void setTitre(String titre)
    {
        this.titre = titre;
    }
    public String getMaisonEdition()
    {
        return this.maison_edition;
    }
    public void setMaisonEdition(String mson_edition)
    {
        this.maison_edition = mson_edition;
    }
    public Date getDate_sortie()
    {
        return this.date_sortie;
    }
    public void SetDateSortie(Date sortie)
    {
        this.date_sortie = sortie;
    }
    public String getAuteur()
    {
        return this.Auteur;
    }
    public void setAuteur(String Auteur)
    {
        this.Auteur = Auteur;
    }
    public int getNbr_page()
    {
        return this.nombre_page;
    }
    public void SetNbrPage(int nbrpage)
    {
        this.nombre_page = nbrpage;
    }
    public int getIsbn()
    {
        return this.Isbn;
    }
    public void setIsbn(int isbn)
    {
        this.Isbn = isbn;
    }
    public boolean getIsDispo()
    {
        return this.disponible;
    }
    public void setIsDispo(boolean dispo)
    {
        this.disponible = dispo;
    }
    public Date getDateDernierConsu()
    {
        return this.date_dernier_consultation;
    }
    public void setDateDernierConsu(Date drn_consu)
    {
        this.date_dernier_consultation = drn_consu;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Livre))
            return false;
        Livre livre = (Livre) o;
        return Objects.equals(this.id, livre.id) && Objects.equals(this.titre, livre.titre)
                && Objects.equals(this.maison_edition, livre.maison_edition)&& Objects.equals(this.Isbn, livre.Isbn) && Objects.equals(this.Auteur, livre.Auteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.titre, this.maison_edition,this.date_sortie,this.Isbn,this.nombre_page,this.Isbn,this.Auteur,this.disponible);
    }



}