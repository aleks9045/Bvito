package org.example.bvito.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer p_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "a_id", nullable = false)
    private Ads ads;

    @Column(name = "url", nullable = false)
    private String url;

    public Photos() {
    }

    public Photos(Integer p_id, Ads ads, String url) {
        this.p_id = p_id;
        this.ads = ads;
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photos photos)) return false;
        return Objects.equals(getP_id(), photos.getP_id()) && Objects.equals(getAds(), photos.getAds()) && Objects.equals(getUrl(), photos.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getP_id(), getAds(), getUrl());
    }

    @Override
    public String toString() {
        return "Photos{" +
                "p_id=" + p_id +
                ", ads=" + ads +
                ", url='" + url + '\'' +
                '}';
    }

    public static Photos newInstance() {
        return new Photos(1, Ads.newInstance(), "photos/KiaRia.png");
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public void setAds(Ads ads) {
        this.ads = ads;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getP_id() {
        return p_id;
    }

    public Ads getAds() {
        return ads;
    }

    public String getUrl() {
        return url;
    }
}
