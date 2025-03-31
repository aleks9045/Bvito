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
    private AdWithoutUserSchema adData;
    private SecureUserSchema user;

    public SecureAdSchema(AdWithoutUserSchema adData, SecureUserSchema user) {
        this.adData = adData;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SecureAdSchema that)) return false;
        return Objects.equals(getAdData(), that.getAdData()) && Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdData(), getUser());
    }

    @Override
    public String toString() {
        return "SecureAdSchema{" +
                "ad=" + adData +
                ", secureUserSchema=" + user +
                '}';
    }

    public AdWithoutUserSchema getAdData() {
        return adData;
    }

    public void setAdData(AdWithoutUserSchema adData) {
        this.adData = adData;
    }

    public SecureUserSchema getUser() {
        return user;
    }

    public void setUser(SecureUserSchema user) {
        this.user = user;
    }
}
