/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m07.entitats;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author rvallez
 */
@Entity
@Table(name="film", schema="shakila")
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f"),
    @NamedQuery(name = "Film.findById", query = "SELECT f FROM Film f WHERE f.filmId=:filmId"),
    })
public class Film implements Serializable{
    @Id
    private int filmId;
    private String title;
    private String Description;
    private String releaseYear;
    @NaturalId
    private int languageId;
    @NaturalId
    @Column(nullable=true)
    private Integer originalLanguageId;
    private int rentalDuration;
    private float rentalRate;
    private int length;
    private float replacementCost;
    private String rating;
    private String specialFeatures;
    private Timestamp lastUpdate;
    
    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinTable(
            name = "film_category",
            joinColumns = { @JoinColumn(name = "film_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") }
    )
    private Set<Category> categories = new HashSet<Category>();

    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinTable(
            name = "inventory",
            joinColumns = { @JoinColumn(name = "film_id") },
            inverseJoinColumns = { @JoinColumn(name = "inventory_id") }
    )
    private List<Store> stores = new ArrayList<Store>();
    
    
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(int originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public float getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(float rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLenght() {
        return length;
    }

    public void setLenght(int lenght) {
        this.length = lenght;
    }

    public float getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(float replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    @Override
    public String toString() {
        return "Film{" + "filmId=" + filmId + ", title=" + title + ", Description=" + Description + ", releaseYear=" + releaseYear + ", languageId=" + languageId + ", originalLanguageId=" + originalLanguageId + ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate + ", length=" + length + ", replacementCost=" + replacementCost + ", rating=" + rating + ", specialFeatures=" + specialFeatures + ", lastUpdate=" + lastUpdate + ", categories=" + categories + '}';
    }
}
