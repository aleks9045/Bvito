package org.example.bvito.schemas.ad.out;

import java.util.List;

/** Advertisement schema that has secure user schema and list of photos
 * <p>
 *  Linked with {@link org.example.bvito.schemas.ad.out.SecureAdSchema Secure advertisement schema}
 *  @author Aleksey
 */
public class AdSchemaOut {
    private SecureAdSchema ad;
    private List<String> photoUrlList;

    public AdSchemaOut(SecureAdSchema ad, List<String> photoUrlList) {
        this.ad = ad;
        this.photoUrlList = photoUrlList;
    }

    public SecureAdSchema getAd() {
        return ad;
    }

    public void setAd(SecureAdSchema ad) {
        this.ad = ad;
    }

    public List<String> getPhotoUrlList() {
        return photoUrlList;
    }

    public void setPhotoUrlList(List<String> photoUrlList) {
        this.photoUrlList = photoUrlList;
    }
}
