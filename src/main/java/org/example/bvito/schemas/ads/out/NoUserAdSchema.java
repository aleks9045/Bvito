package org.example.bvito.schemas.ads.out;

import java.util.List;
import java.util.Objects;

/** Advertisement schema that has no user field and has list of photos
 * <p>
 *  Linked with {@link org.example.bvito.schemas.ads.out.AdWithoutUserSchema Advertisement without user schema}
 *  @author Aleksey
 */
public class NoUserAdSchema {
    private AdWithoutUserSchema adData;
    private List<String> photoUrlList;

    public NoUserAdSchema(AdWithoutUserSchema adData, List<String> photoUrlList) {
        this.adData = adData;
        this.photoUrlList = photoUrlList;
    }

    @Override
    public String toString() {
        return "NoUserAdSchema{" +
                "ad_data=" + adData +
                ", photo_url_list=" + photoUrlList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoUserAdSchema that)) return false;
        return Objects.equals(adData, that.adData) && Objects.equals(photoUrlList, that.photoUrlList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adData, photoUrlList);
    }

    public AdWithoutUserSchema getAdData() {
        return adData;
    }

    public void setAdData(AdWithoutUserSchema adData) {
        this.adData = adData;
    }

    public List<String> getPhotoUrlList() {
        return photoUrlList;
    }

    public void setPhotoUrlList(List<String> photoUrlList) {
        this.photoUrlList = photoUrlList;
    }
}
