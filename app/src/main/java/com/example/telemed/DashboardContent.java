package com.example.telemed;

public class DashboardContent {

    private int resourceId;
    private String title;
    private String count;


    public DashboardContent(int resourceId, String title, String count){
        this.resourceId = resourceId;
        this.title= title;
        this.count= count;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) { this.count    = count;
    }



}
