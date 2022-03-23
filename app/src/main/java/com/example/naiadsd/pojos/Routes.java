package com.example.naiadsd.pojos;

import com.google.gson.annotations.SerializedName;

public class Routes {

    @SerializedName("Id")
    private int Id;

    @SerializedName("RouteName")
    private String RouteName;

    @SerializedName("RouteCode")
    private String RouteCode;

    @SerializedName("Driver")
    private String Driver;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRouteName() {
        return RouteName;
    }

    public void setRouteName(String routeName) {
        RouteName = routeName;
    }

    public String getRouteCode() {
        return RouteCode;
    }

    public void setRouteCode(String routeCode) {
        RouteCode = routeCode;
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }
}
