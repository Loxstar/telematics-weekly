package com.theIronYard;

public class VehicleInfo {
    private int vin;
    private double odometer;
    private double consumption;
    private double lastOilChange;
    private double engineSize;


    public VehicleInfo(int vin, double odometer, double consumption,
                       double lastOilChange, double engineSize) {

    }

    public VehicleInfo() {
    }

    public int getVin() {
        return vin;
    }

    public double getOdometer() {
        return odometer;
    }

    public double getConsumption() {
        return consumption;
    }

    public double getLastOilChange() {
        return lastOilChange;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public void setLastOilChange(double lastOilChange) {
        this.lastOilChange = lastOilChange;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }
}
