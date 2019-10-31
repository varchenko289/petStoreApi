package io.swagger.petstore.dto.pet;

import java.util.List;

public class Pet {

    private int id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    public Pet() {

    }

    public Pet(String name, int id, Category category, String status, List<Tag> tags, List<String> photoUrls) {
        this.photoUrls = photoUrls;
        this.name = name;
        this.id = id;
        this.category = category;
        this.tags = tags;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        io.swagger.petstore.dto.pet.Pet pet = (io.swagger.petstore.dto.pet.Pet) o;
        return id == pet.id &&
                java.util.Objects.equals(category, pet.category) &&
                java.util.Objects.equals(name, pet.name) &&
                java.util.Objects.equals(photoUrls, pet.photoUrls) &&
                java.util.Objects.equals(tags, pet.tags) &&
                java.util.Objects.equals(status, pet.status);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, category, name, photoUrls, tags, status);
    }
}
