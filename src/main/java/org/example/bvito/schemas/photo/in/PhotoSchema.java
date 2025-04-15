package org.example.bvito.schemas.photo.in;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.multipart.MultipartFile;

/**
 * Default photo schema
 * <p>
 * Uses for upload photo and bind it with advertisement
 * @author Aleksey
 */
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PhotoSchema {
    @Schema(description = "Ad id")
    @Positive
    @NotNull
    private Integer adId;

    @Schema(description = "Image file to upload",
            type = "string",
            format = "binary")
    @NotNull
    private MultipartFile file;

    public @Positive @NotNull Integer getadId() {
        return adId;
    }

    public void setadId(@Positive @NotNull Integer aId) {
        this.adId = aId;
    }

    public @NotNull MultipartFile getFile() {
        return file;
    }

    public void setFile(@NotNull MultipartFile file) {
        this.file = file;
    }
}
