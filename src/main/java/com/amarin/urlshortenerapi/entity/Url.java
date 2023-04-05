package com.amarin.urlshortenerapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "url")
public class Url {

    @Id
    @GeneratedValue(generator = RandomLongGenerator.generatorName)
    @GenericGenerator(name = RandomLongGenerator.generatorName, strategy = "com.amarin.urlshortenerapi.entity.RandomLongGenerator")
    private long id;

    @Column(nullable = false)
    private String longUrl;

    @Column(nullable = false)
    private Date createdDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Url [id=" + id + ", longUrl=" + longUrl + ", createdDate=" + createdDate + "]";
    }
}
