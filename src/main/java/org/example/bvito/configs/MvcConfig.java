package org.example.bvito.configs;

import org.example.bvito.service.photos.utils.PhotoProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Aleksey
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    private final PhotoProperties photoProperties;

    public MvcConfig(PhotoProperties photoProperties) {
        this.photoProperties = photoProperties;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/ad_photos/**")
                .addResourceLocations("file:" + photoProperties.getLocation())
                .setCacheControl(CacheControl.noCache());
    }
}
