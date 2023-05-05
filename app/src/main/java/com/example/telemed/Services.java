package com.example.telemed;

import com.google.gson.annotations.SerializedName;

public class Services {
    @SerializedName("services_name")
    private String services_name;

    public String getServiceName() { return services_name; }
}
