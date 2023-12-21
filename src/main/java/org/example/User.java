package org.example;

public class User {

    private String name;
    private House myHouse;

    public User(String name) {
        this.name = name;
        this.myHouse = createHouse();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House createHouse(){
           return new House();
    }
    public void configureHouseLocation(int zipCode,int geoLocation, String Address){
        this.myHouse.setLocation(zipCode,geoLocation,Address);
    }

    public House getMyHouse() {
        return myHouse;
    }


}
