package org.example.bvito.schemas.users.out;

import org.example.bvito.models.Users;
import org.example.bvito.schemas.ads.out.AdWithoutUserSchema;
import org.example.bvito.schemas.ads.out.NoUserAdSchema;

import java.util.List;

/** User schema with list of appropriate advertisements
 * <p>
 *  Linked with {@link Users User model}<br>
 *  Linked with {@link AdWithoutUserSchema Advertisement without user field schema}
 *
 *  @author Aleksey
 */
public class UserAdsSchema {
    private SecureUserSchema user;
    private List<NoUserAdSchema> ads;

    public UserAdsSchema(SecureUserSchema user, List<NoUserAdSchema> ads) {
        this.user = user;
        this.ads = ads;
    }

    public SecureUserSchema getUser() {
        return user;
    }

    public void setUser(SecureUserSchema user) {
        this.user = user;
    }

    public List<NoUserAdSchema> getAds() {
        return ads;
    }

    public void setAds(List<NoUserAdSchema> ads) {
        this.ads = ads;
    }
}
