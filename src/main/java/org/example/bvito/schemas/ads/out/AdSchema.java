package org.example.bvito.schemas.ads.out;

import java.util.List;

/** Advertisement schema that has secure user schema and list of photos
 * <p>
 *  Linked with {@link org.example.bvito.schemas.ads.out.SecureAdSchema Secure advertisement schema}
 *  @author Aleksey
 */
public class AdSchema {
    private SecureAdSchema ad;
    private List<String> photo_url_list;

    public AdSchema(SecureAdSchema ad, List<String> photo_url_list) {
        this.ad = ad;
        this.photo_url_list = photo_url_list;
    }

    public SecureAdSchema getAd() {
        return ad;
    }

    public void setAd(SecureAdSchema ad) {
        this.ad = ad;
    }

    public List<String> getPhoto_url_list() {
        return photo_url_list;
    }

    public void setPhoto_url_list(List<String> photo_url_list) {
        this.photo_url_list = photo_url_list;
    }
}
