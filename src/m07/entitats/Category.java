/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m07.entitats;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author rvallez
 */
@Entity
@Table(name="category")
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByName", query = "SELECT c FROM Category c WHERE c.name=:name"),
    })
public class Category implements Serializable{
    @Id
    private int categoryId;
    private String name;
    private Timestamp lastUpdate;
    
    //fetch = FetchType.EAGER
    @ManyToMany( mappedBy = "categories", fetch = FetchType.EAGER)
    private Set<Film> films = new HashSet<Film>();

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryId=" + categoryId + ", name=" + name + ", lastUpdate=" + lastUpdate + ", films=" + films + '}';
    }

    
}
