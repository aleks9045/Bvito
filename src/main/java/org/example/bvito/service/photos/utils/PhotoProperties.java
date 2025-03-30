package org.example.bvito.service.photos.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Contains upload folder for photos
 * @author Aleksey
 */
@ConfigurationProperties("photo")
public class PhotoProperties {
    @Value("${photos.upload-dir}")
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
