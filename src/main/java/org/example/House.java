package org.example;

import java.util.ArrayList;
import java.util.List;

public class House {
    private Location location;
    private List<Room> roomList;
    private List<SensorType> sensorTypeList;
    public House(int zipCode,int geoLocation,String Address){
        this.location = new Location(zipCode,geoLocation,Address);
        roomList = new ArrayList<>();
        sensorTypeList = new ArrayList<>();
    }

    public House() {
        this.location = new Location(0,0, "");
        roomList = new ArrayList<>();
        sensorTypeList = new ArrayList<>();
    }

    public void setLocation(int zipCode,int geoLocation,String Address) {
        this.location.setAddress(Address);
        this.location.setZipCode(zipCode);
        this.location.setGeoLocation(geoLocation);
    }

    public void addRoomToHouse(String name, int houseFloor, double width, double height){
        Room room = new Room(name,houseFloor,width,height);
        this.roomList.add(room);

    }
    public void addTypeOfSensor(String functionality){
       SensorType sensorType = new SensorType(functionality);
       this.sensorTypeList.add(sensorType);

    }

    public void addSensorToARoom(String name,String room,String functionality){

        Room selectedRoom = null;
        for (Room r : roomList){
            if(r.getName().equals(room)){
                selectedRoom = r;
                break;
            }
        }
        SensorType st = null;
        for (SensorType sensorType : sensorTypeList){
            if(sensorType.getFunctionality().equals(functionality.toLowerCase())){
                st = sensorType;
                break;
            }
        }

        if(st.getFunctionality().equals("temperature")){
            TempSensor ts = new Sensor(name,st);
            selectedRoom.addTempSensorToRoom(ts);
        }
        if(st.getFunctionality().equals("humidity")){
            HumiditySensor hs = new Sensor(name,st);
            selectedRoom.addHumiditySensorToRoom(hs);
        }

    }

    public List<SensorType> getSensorTypeList() {
        return new ArrayList<>(sensorTypeList);
    }

    public List<Room> getRoomList() {
        return new ArrayList<>(this.roomList);
    }

    @Override
    public String toString() {
        return "House{" +
                "location=" + location +
                '}';
    }


}
