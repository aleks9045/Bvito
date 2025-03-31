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
public class Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "a_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ads ad;

    @Column(name = "url", nullable = false)
    private String url;

    public Photos() {}

    public Photos(Integer pId, Ads ad, String url) {
        this.pId = pId;
        this.ad = ad;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Photos{" +
                "p_id=" + pId +
                ", aId=" + ad +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photos photos)) return false;
        return Objects.equals(pId, photos.pId) && Objects.equals(ad, photos.ad) && Objects.equals(url, photos.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pId, ad, url);
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer p_id) {
        this.pId = p_id;
    }

    public Ads getaAd() {
        return ad;
    }

    public void setaAd(Ads aId) {
        this.ad = aId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
