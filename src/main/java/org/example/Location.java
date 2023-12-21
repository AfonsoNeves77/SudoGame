package org.example;

public class Location {

    private int zipCode;
    private int geoLocation;
    private String Address;

    protected Location(int zipCode,int geoLocation,String Address){
        this.zipCode = zipCode;
        this.geoLocation = geoLocation;
        this.Address = Address;
    }

    public Location() {

    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setGeoLocation(int geoLocation) {
        this.geoLocation = geoLocation;
    }


    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Location{" +
                "zipCode=" + zipCode +
                ", geoLocation=" + geoLocation +
                ", Address='" + Address + '\'' +
                '}';
    }
}
