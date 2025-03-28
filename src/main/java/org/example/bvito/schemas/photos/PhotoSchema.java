package org.example.bvito.schemas.photos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Aleksey
 */
public class PhotoSchema {
    @Schema(description = "Ad id")
    @Positive
    @NotNull
    private Integer a_id;

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

    public @NotNull Integer getA_id() {
        return a_id;
    }

    public void setA_id(@NotNull Integer a_id) {
        this.a_id = a_id;
    }
}
