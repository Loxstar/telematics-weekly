package com.theIronYard;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TelematicsService {
    static void report(VehicleInfo vehicleInfo) {
        // Write the VehicleInfo to a file as json
        // using the VIN as the name of the file and
        // a "json" extension (e.g. "234235435.json").
        // The file will overwrite any existing files for the same VIN.
        File f = new File(vehicleInfo.getVin() + ".json");
        try {
            // write to a new file
            FileWriter fw = new FileWriter(f);

            // convert our vehicleInfo to json
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vehicleInfo);

            fw.write(json);
            fw.close();


            // GOAL: Build an arraylist of VehicleInfo objects
            // we'll get our vehicle info info from all the json files
            // in the current directory
            ArrayList<VehicleInfo> vehicleInfos = new ArrayList<>();

            // read from all json files
            File file = new File(".");
            for (File currentFile : file.listFiles()) {
                if (currentFile.getName().endsWith(".json")) {
                    // get the json from the file
                    String fileJson = getDataFromFile(currentFile);


                    // convert that json to a VehicleInfo object
                    ObjectMapper om = new ObjectMapper();
                    VehicleInfo vi = om.readValue(fileJson, VehicleInfo.class);
                    vehicleInfos.add(vi);
                    // what do we do with vi?
                    // put it inside of an arraylist.
                }
            }

            double odom = 0;
            double consump = 0;
            double oil = 0;
            double engine = 0;

            for (int i = 0; i < vehicleInfos.size(); i++) {
                consump += vehicleInfos.get(i).getConsumption();
                odom += vehicleInfos.get(i).getOdometer();
                oil += vehicleInfos.get(i).getLastOilChange();
                engine += vehicleInfos.get(i).getEngineSize();
            }
            System.out.println("The average Odometer reading is " + odom / vehicleInfos.size() + ".");
            System.out.println("The average fuel consumption is " + consump / vehicleInfos.size() + ".");
            System.out.println("The average oil change is " + oil / vehicleInfos.size() + ".");
            System.out.println("The average engine size is " + engine / vehicleInfos.size() + ".");

            // when we get to this point, we should have a populated arraylist of VehicleInfos

            // we can use this list to write values to our html

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getDataFromFile(File f) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(f);

        // read the file that is passed in as a string and return that instead of ""
        String results = "";
        // while fileScanner hasNext(),
        while (fileScanner.hasNext()) {
            results = fileScanner.nextLine();
        }
        // add the next line from the file
        // to results

        return results;
    }

    // TODO: maybe write a "writeDataToFile method??????"
}
