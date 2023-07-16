package fr.souhail.adverts.dto;

import javax.validation.constraints.NotBlank;

public class AdvertDto {

    @NotBlank
    private String description;

    @NotBlank
    private String type;

    @NotBlank
    private String status;

    @NotBlank
    private String imageUrl;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
