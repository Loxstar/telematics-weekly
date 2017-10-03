package com.theIronYard;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);

        // Scanner is gonna do input stuff

        // Make a new VehicleInfo object
        VehicleInfo vh = new VehicleInfo();

        // These 3 lines set the vin
        System.out.println("What is the vin number?");
        int vin = in.nextInt();
        vh.setVin(vin);

        System.out.println("What is the odometer?");
        double od = in.nextDouble();
        vh.setOdometer(od);


        System.out.println("What is the consumption?");
        double con = in.nextDouble();
        vh.setConsumption(con);


        System.out.println("What is the last oil change?");
        double last = in.nextDouble();
        vh.setLastOilChange(last);


        System.out.println("What is the engine size?");
        double eng = in.nextDouble();
        vh.setEngineSize(eng);



        // For each field in VehicleInfo,
        // use the scanner to read in values
        // and populate the object

        TelematicsService.report(vh);
    }


}
