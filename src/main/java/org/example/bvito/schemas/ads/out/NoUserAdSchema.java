package org.example.bvito.schemas.ads.out;

import java.util.List;
import java.util.Objects;

/**
 * @author Aleksey
 */
public class NoUserAdSchema {
    private AdWithoutUserSchema ad_data;
    private List<String> photo_url_list;

    public NoUserAdSchema(AdWithoutUserSchema ad_data, List<String> photo_url_list) {
        this.ad_data = ad_data;
        this.photo_url_list = photo_url_list;
    }

    @Override
    public String toString() {
        return "NoUserAdSchema{" +
                "ad_data=" + ad_data +
                ", photo_url_list=" + photo_url_list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoUserAdSchema that)) return false;
        return Objects.equals(ad_data, that.ad_data) && Objects.equals(photo_url_list, that.photo_url_list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ad_data, photo_url_list);
    }

    public AdWithoutUserSchema getAd_data() {
        return ad_data;
    }

    public void setAd_data(AdWithoutUserSchema ad_data) {
        this.ad_data = ad_data;
    }

    public List<String> getPhoto_url_list() {
        return photo_url_list;
    }

    public void setPhoto_url_list(List<String> photo_url_list) {
        this.photo_url_list = photo_url_list;
    }
}
