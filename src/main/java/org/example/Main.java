package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InstantiationException {
      /*GameController gameController = new GameController(2);
      gameController.startGame();
        WordGameController wb = new WordGameController(1);
        wb.gameLogic(3, "cats","coff",0,0,0,3);

        WordBoard ok = new WordBoard(1);
        System.out.println(Arrays.toString(ok.wordExists("cats".toCharArray())));
        System.out.println(Arrays.toString(ok.wordExists("coff".toCharArray())));
        String[] friends = {"Hugo","Mariana", "Tiago","André"};
        List<String> friendsArray = new ArrayList<>(Arrays.asList(friends));
        friendsArray.add(friends[0]);

        System.out.println(friendsArray.size());
        for(String s : friendsArray){
            System.out.println(s);
        }

        friendsArray.add(0,"lol");
        for(String s : friendsArray){
            System.out.println(s);
        }
        friendsArray.set(1,"set");
        System.out.println(friendsArray);
       friendsArray.stream()
                .filter(e -> e.equals("Hugo"))
                .forEach(System.out::println);

    */

        //Add house
       House myHouse = new House();
       System.out.println(myHouse);

       //Edit Location
       myHouse.setLocation(12,55,"Porto");
       System.out.println(myHouse);

       //AddRoom to house
      myHouse.addRoomToHouse("BedRoom",2,22.3,33);

      //GetRoomList
        //Versao encapsulada
        System.out.println(myHouse.getRoomList());

        //defineSensorType
        myHouse.addTypeOfSensor("temperature");

        //add teSesorToROOM

        myHouse.addSensorToARoom("TempSensorOne","BedRoom","temperature");

        Room selectedRoom = null;
        for (Room r : myHouse.getRoomList()){
            if(r.getName().equals("BedRoom")){
                selectedRoom = r;
                break;
            }
        }
        System.out.println(selectedRoom.getSensorList());

        //add tempSensorToRoom
        System.out.println(myHouse.getSensorTypeList());

        TempSensor TS = new Sensor("TempSensor",new SensorType("temperature"));
        TS.tempMesurement();














    }
}