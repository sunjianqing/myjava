package com.jianqing.interview.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by jianqing_sun on 3/14/18.
 */
public class Tesla {
    private static final String dataPath = "/Users/jianqingsun/Downloads/coordinates.csv";
    private static final String stationPath = "/Users/jianqingsun/Downloads/centroids.csv";
    private static final int DATACNT = 1000000;
    private static final int SATATIONCNT = 1000;

    public static void main(String[] args) {
        Tesla tesla = new Tesla();

        try {
//            tesla.Q1();
//            tesla.Q2();
            tesla.Q3();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Q1() throws IOException {
        int cnt = computeCarCntWithMeters(5);
        System.out.println("Total cnt is " + cnt);    }

    private void Q2() throws IOException {
        int cnt = computeCarCntWithMeters(10);
        System.out.println("Total cnt is " + cnt);
    }

    private void Q3() throws IOException{

        double[][] data = readData(DATACNT, dataPath);
        double[][] stations = readData(SATATIONCNT, stationPath);

        double[] minDist = new double[DATACNT];
        PriorityQueue<Double> queue = new PriorityQueue<>();

        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; j < 1000; j++) {
                double dist = computeDist(data[i][0], data[i][1], stations[j][0], stations[j][1]);
                queue.add(dist);
            }
            minDist[i] = queue.peek();
            queue.clear();
        }

        Arrays.sort(minDist);
        double v = minDist[(int)(DATACNT * 0.8 - 1)];
        System.out.println(v);
    }

    private int computeCarCntWithMeters(int meters) throws IOException {

        double[][] data = readData(DATACNT, dataPath);
        double[][] stations = readData(SATATIONCNT, stationPath);

        int cnt = 0;
        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (computeDist(data[i][0], data[i][1], stations[j][0], stations[j][1]) <= meters) {
                    //System.out.println(String.format("%f %f %f %f ", data[i][0], data[i][1], stations[j][0], stations[j][1]));
                    cnt++;
                    break;
                }
            }
        }

        return cnt;
    }

    private double computeDist(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    private double[][] readData(int len, String filePath) throws IOException {

        double[][] data = new double[len][2];
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        reader.readLine();
        String line = null;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            if (!line.isEmpty()) {

            }
            String[] split = line.trim().split(",");

            double x = Double.valueOf(split[0]);
            double y = Double.valueOf(split[1]);
            data[i][0] = x;
            data[i][1] = y;
            i++;
        }

        reader.close();
        return data;
    }


}
