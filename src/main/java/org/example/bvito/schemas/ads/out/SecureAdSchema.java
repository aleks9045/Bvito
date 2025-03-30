package org.example.bvito.schemas.ads.out;

import org.example.bvito.schemas.users.out.SecureUserSchema;

import java.util.Objects;

/** Secure advertisement schema
 * <p>
 *  Linked with {@link org.example.bvito.schemas.ads.out.AdWithoutUserSchema Secure advertisement schema}
 *  Linked with {@link org.example.bvito.schemas.ads.out.SecureAdSchema Secure advertisement schema}
 *  @author Aleksey
 */
public class SecureAdSchema {
    private AdWithoutUserSchema ad_data;
    private SecureUserSchema user;

    public SecureAdSchema(AdWithoutUserSchema ad_data, SecureUserSchema user) {
        this.ad_data = ad_data;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SecureAdSchema that)) return false;
        return Objects.equals(getAd_data(), that.getAd_data()) && Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAd_data(), getUser());
    }

    @Override
    public String toString() {
        return "SecureAdSchema{" +
                "ad=" + ad_data +
                ", secureUserSchema=" + user +
                '}';
    }

    public AdWithoutUserSchema getAd_data() {
        return ad_data;
    }

    public void setAd_data(AdWithoutUserSchema ad_data) {
        this.ad_data = ad_data;
    }

    public SecureUserSchema getUser() {
        return user;
    }

    public void setUser(SecureUserSchema user) {
        this.user = user;
    }
}
