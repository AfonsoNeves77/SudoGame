package org.example;

public class Sensor implements HumiditySensor,TempSensor {

    private String name;
    private SensorType sensorType;

   public Sensor(String name,SensorType st){
        this.name = name;
        this.sensorType = st;
   }

    @Override
    public String toString() {
        return "Sensor -> " +
                "name='" + name + '\'' +
                sensorType +
                '}';
    }

    @Override
    public double humidityMesurement() {
        return 0;
    }

    @Override
    public double tempMesurement() {
        return 0;
    }
}
