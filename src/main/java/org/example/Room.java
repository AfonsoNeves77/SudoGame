package org.example;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private int houseFloor;
    private double width;
    private double height;
    private List<Object> sensorList;

    public Room(String name, int houseFloor, double width, double height) {
        this.name = name;
        this.houseFloor = houseFloor;
        this.width = width;
        this.height = height;
        sensorList = new ArrayList<>();
    }

    public String getName() {
        return String.valueOf(name);
    }

    public void addTempSensorToRoom(TempSensor sensor){
        this.sensorList.add(sensor);
    }
    public void addHumiditySensorToRoom(HumiditySensor sensor){
        this.sensorList.add(sensor);
    }

    public List<Object> getSensorList() {
        return new ArrayList<>(sensorList);
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", houseFloor=" + houseFloor +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
