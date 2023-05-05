package com.example.telemed;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("service_name")
    private String service_name;

    public String getServiceName(){return service_name;}

    @SerializedName("hospital_name")
    private String hospital_name;

    public String getHospitalName(){return hospital_name;}
}
