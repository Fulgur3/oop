package Devices;
import java.util.*;

public abstract class Device {

    private String name;
    private int power;
    private int year;
    private boolean deviceTurn;

    public Device(String name,  int year, int power, boolean deviceTurn) {
        this.name= name;
        this.power = power;
        this.year = year;
        this.deviceTurn = deviceTurn;
    }


    public String getName() {
        return name;
    }

    public void setName(){
        this.name=name;
    }

    public int getPower() {
        return power;
    }

    public int getYear() { return year; }

    public void setYear(){
        this.year=year;
    }

    public void setTurn(){
        this.deviceTurn=deviceTurn;
    }
    public void setPower(){
        this.power=power;
    }
    public boolean getDeviceTurn() {
        return deviceTurn;
    }

    public void setDeviceTurn(boolean deviceTurn) {
        this.deviceTurn = deviceTurn;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", year=" + year +
                ", deviceTurn=" + deviceTurn +
                '}';
    }
}