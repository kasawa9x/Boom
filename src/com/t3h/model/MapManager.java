package com.t3h.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class MapManager {
    public static ArrayList<Map> readMap(String name) {
        ArrayList<Map> arr = new ArrayList<>();
        try {
            File file = new File("src/maps/" + name);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int i = 0;
            String line = bufferedReader.readLine();
            while (line != null) {
                for (int j = 0; j < line.length(); j++) {
                    int bit = Integer.parseInt(line.charAt(j) + "");
                    if (bit > 0) {
                        int x = j * 52;
                        int y = i * 58; //60==height
                        Map m = new Map(x,y,bit);
                        arr.add(m);
                    }
                }
                i++;
                line = bufferedReader.readLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arr;
    }
}
