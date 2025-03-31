package org.example.bvito.schemas.photos.in;

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
public class PhotoSchema {
    @Schema(description = "Ad id")
    @Positive
    @NotNull
    private Integer aId;

    @Schema(description = "Image file to upload",
            type = "string",
            format = "binary")
    @NotNull
    private MultipartFile file;



    public @NotNull MultipartFile getFile() {
        return file;
    }

    public void setFile(@NotNull MultipartFile file) {
        this.file = file;
    }

    public @NotNull Integer getaId() {
        return aId;
    }

    public void setaId(@NotNull Integer aId) {
        this.aId = aId;
    }
}
