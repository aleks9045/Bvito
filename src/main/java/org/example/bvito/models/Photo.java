package org.example.bvito.models;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Objects;

/**
 *  Represents photo model
 *  @author Aleksey
 */
@Entity
@Table(name = "photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer photoId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "a_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ad ad;

    @Column(name = "url", nullable = false)
    private String url;

    public Photo() {}

    public Photo(Integer photoId, Ad ad, String url) {
        this.photoId = photoId;
        this.ad = ad;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Photos{" +
                "p_id=" + photoId +
                ", aId=" + ad +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo photo)) return false;
        return Objects.equals(photoId, photo.photoId) && Objects.equals(ad, photo.ad) && Objects.equals(url, photo.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoId, ad, url);
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public Ad getaAd() {
        return ad;
    }

    public void setaAd(Ad aId) {
        this.ad = aId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
