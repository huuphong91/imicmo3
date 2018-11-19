package com.phongtoanhuu.hhh.imicmo3.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationEntity {
    @SerializedName("LocationId")
    @Expose
    private String LocationId;
    @SerializedName("LocationName")
    @Expose
    private String LocationName;
    @SerializedName("LocationDescription")
    @Expose
    private String LocationDescription;

    public LocationEntity(String locationId, String locationName, String locationDescription) {
        LocationId = locationId;
        LocationName = locationName;
        LocationDescription = locationDescription;
    }

    public String getLocationId() {
        return LocationId;
    }

    public void setLocationId(String locationId) {
        LocationId = locationId;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String locationName) {
        LocationName = locationName;
    }

    public String getLocationDescription() {
        return LocationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        LocationDescription = locationDescription;
    }
}
