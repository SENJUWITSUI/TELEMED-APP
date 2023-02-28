package com.example.telemed;

public class Hakbang {

    private String resourceId,step,description;


    public Hakbang(String resourceId, String step, String description){
        this.resourceId = resourceId;
        this.step = step;
        this.description = description;
    }

    public String getResourceId() {
        return resourceId;
    }
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return step;
    }
    public void setTitle(String title) {
        this.step = step;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String title) {
        this.description = description;
    }
}
