package org.example;

public class SensorType {
    private String functionality;
    public SensorType(String functionality){
        this.functionality = functionality;
    }

    public String getFunctionality(){
        return String.valueOf(this.functionality);
    }

    @Override
    public String toString() {
        return "SensorType" +
                "functionality='" + functionality + '\'' +
                '}';
    }
}
