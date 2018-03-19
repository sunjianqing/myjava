package com.jianqing.interview.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by jianqing_sun on 3/14/18.
 */
public class Tesla {
    private static final String dataPath = "/Users/jianqingsun/Downloads/coordinates.csv";
    private static final String stationPath = "/Users/jianqingsun/Downloads/centroids.csv";
    private static final int DATACNT = 200000;
    private static final int SATATIONCNT = 1000;

    public static void main(String[] args) {
        Tesla tesla = new Tesla();

        try {
//            tesla.Q1();
//            tesla.Q2();
//            tesla.Q3();
            tesla.Q4();
//            Map<Integer, Set<Integer>> stationMap = new HashMap<>(); // stationId -> cars closed to me
//            Set<Integer> set1 = new HashSet<>();
//            Set<Integer> set2 = new HashSet<>();
//
//            set1.add(1);
//            set1.add(2);
//            set1.add(3);
//            set1.add(4);
//
//            set2.add(5);
//            set2.add(6);
//            set2.add(7);
//
//            stationMap.put(1, set1);
//            stationMap.put(2, set2);
//
//            tesla.swap(stationMap,1,2,2,6);
            System.out.println("hello ");
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

        for (int i = 0; i < DATACNT; i++) {
            for (int j = 0; j < SATATIONCNT; j++) {
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

    private void Q4() throws IOException{
        double[][] data = readData(DATACNT, dataPath);
        double[][] stations = readData(SATATIONCNT, stationPath);

        Map<Integer, List<Integer>> carStationsMap = new HashMap<>(); // carId -> sorted station ids
        Map<Integer, List<Integer>> carmap = new HashMap<>();

        Map<Integer, Set<Integer>> stationMap = new HashMap<>(); // stationId -> cars closed to me
        Set<Integer> nextCarSet = new HashSet<>();
        for(int i = 0; i < DATACNT; i++){
            nextCarSet.add(i);
        }
        int round = 1;
        while(!nextCarSet.isEmpty()) {
            System.out.println("round number " + round);
            Q4Init(stationMap, carStationsMap, data, stations, nextCarSet, round);
            round++;
        }

        System.out.println("round number " + round);

        int potencialMoveCnt = 0;
        Map<Integer, List<Integer>> opt = new HashMap<>();

        for(Map.Entry<Integer, Set<Integer>> entry : stationMap.entrySet() ){
            // find cars whose nearest station is not current one
            int stationId = entry.getKey();
            System.out.println("Station id " + stationId);
            Set<Integer> carsInCurrentStations = entry.getValue();

            for(Integer carId : carsInCurrentStations){
                if(carStationsMap.get(carId).get(0) != stationId){
                    List<Integer> carList = opt.getOrDefault(stationId, new ArrayList<>());
                    carList.add(carId);
                    opt.put(stationId, carList);
                }
            }
        }


        // check transfer station improve ?
        // 有 464 个车站要调整
        Map<Integer, List<Integer>> adjustedOpt = new HashMap<>();

        for(Map.Entry<Integer, List<Integer>> entry : opt.entrySet()) {
            List<Delta> deltasList = new ArrayList<>();
            int stationId = entry.getKey();
            for(Integer carId: entry.getValue()){
                Integer nearestStationId = carStationsMap.get(carId).get(0);
                double nearestDist = computeDist(data[carId][0], data[carId][1], stations[nearestStationId][0], stations[nearestStationId][1]);
                double currentDist = computeDist(data[carId][0], data[carId][1], stations[stationId][0], stations[stationId][1]);
                deltasList.add(new Delta(carId, nearestStationId, stationId, nearestDist - currentDist));
            }

            Collections.sort(deltasList, new DeltaComparator());
            List<Integer> orderedCarIds = new ArrayList<>();

            for(Delta delta : deltasList){
                orderedCarIds.add(delta.carIndex);
            }

            adjustedOpt.put(stationId, orderedCarIds);
        }

        int swapCnt = 0;
        int kmeansRound = 0;
        while(kmeansRound < 10){
            kmeansRound ++;
            Set<Integer> stationSet = new HashSet<>(adjustedOpt.keySet());
            for (Integer stationId : stationSet) {
                List<Integer> cars = new ArrayList(adjustedOpt.get(stationId));
                for (Integer carId : cars) {
                    List<Integer> mySortedStations = carStationsMap.get(carId);
                    int candidateStation1 = -1;
                    int candidateStation2 = -1;

                    int index = 0;
                    for(;index < mySortedStations.size(); index++){
                        Integer cid = mySortedStations.get(index);
                        if(!adjustedOpt.containsKey(cid)){
                            continue;
                        }

                        if(cid != stationId ){
                            while(index < mySortedStations.size() - kmeansRound){
                                if(candidateStation1 == -1 && adjustedOpt.containsKey(mySortedStations.get(index)) && mySortedStations.get(index).compareTo(stationId) != 0 ){
                                    candidateStation1 = mySortedStations.get(index);
                                }

                                if(candidateStation1 != -1 && candidateStation2 == -1 && adjustedOpt.containsKey(mySortedStations.get(index+kmeansRound))
                                        && mySortedStations.get(index + kmeansRound).compareTo(stationId) != 0
                                        && mySortedStations.get(index + kmeansRound).compareTo(candidateStation1) != 0  ){

                                    candidateStation2 = mySortedStations.get(index + kmeansRound);
                                }

                                if(candidateStation1 > -1 && candidateStation2 > -1 && candidateStation1 != candidateStation2)
                                    break;

                                index++;
                            }
                        }
                    }
                    if(stationId.compareTo(candidateStation1) == 0 || stationId.compareTo(candidateStation2) == 0)
                        throw  new RuntimeException("carId " + carId + "has duplicate sorted station " + stationId + " " + candidateStation1 + " " + candidateStation2 );


                    boolean found = false;
                    int removeCarIdFromOpt1 = -1;
                    int removeCarIdFromOpt2 = -1;
                    if(candidateStation1 != -1 && candidateStation2 != -1 && candidateStation1 != candidateStation2){
                        for(Integer carId1 : adjustedOpt.get(candidateStation1)){
                            if(!found){
                                for(Integer carId2: adjustedOpt.get(candidateStation2)){
                                    if(shouldTransfer(data, stations, stationId, candidateStation1, candidateStation2, carId, carId1, carId2, stationMap)){
                                        swapCnt++;
                                        found = true;
                                        System.out.println("Reassign car id " + carId + " for station " + stationId);
                                        removeCarIdFromOpt1 = carId1;
                                        removeCarIdFromOpt2 = carId2;

                                        break;
                                    }
                                }
                            }
                            else{
                                break;
                            }
                        }
                    }


                    if(found) {
                        // 删掉最上层的那个循环
                        adjustedOpt.get(stationId).remove(new Integer(carId));
                        adjustedOpt.get(candidateStation1).remove(new Integer(removeCarIdFromOpt1));
                        adjustedOpt.get(candidateStation2).remove(new Integer(removeCarIdFromOpt2));
                    }

                }
            }
            System.out.println("swap cnt is " + swapCnt);
            swapCnt = 0;

        }

        // compute Radius


        System.out.println("Potencial mv cnt " + potencialMoveCnt);
//        for(Map.Entry<Integer, PriorityQueue<IdxDist>> entry : map.entrySet()){
//            System.out.println("Station " + entry.getKey() + " Radius " + entry.getValue().peek().dist);
//        }

    }

    private void swap(Map<Integer, Set<Integer>> stationMap, int oldStationId, int newStationId, int oldCarId, int newCarId){


        if(!stationMap.get(oldStationId).remove(new Integer(oldCarId))){
            throw new RuntimeException("Exception Remove from station " + oldStationId + "with car " + oldCarId);
        }

        stationMap.get(oldStationId).add(new Integer(newCarId));

        System.out.println(String.format("remove %s from station %s, add %s to station %s", oldCarId, oldStationId, newCarId, oldStationId));
//        stationMap.get(newStationId).add(oldCarId);

//        if(!stationMap.get(newStationId).remove(new Integer(newCarId))){
//            throw new RuntimeException("Exception Remove from station " + newStationId + "with car " + newCarId);
//        }

    }

    private boolean shouldTransfer(double[][] data, double[][] stations, int oldStationId, int newStationId, int oldCarId, int candidateCarId){
        double oldCarToOldStatdist = computeDist(data[oldCarId][0],data[oldCarId][1],stations[oldStationId][0], stations[oldStationId][1]);
        double oldCarToNewStatdist = computeDist(data[oldCarId][0],data[oldCarId][1],stations[newStationId][0], stations[newStationId][1]);

        double newCarToOldStatdist = computeDist(data[candidateCarId][0],data[candidateCarId][1],stations[oldStationId][0], stations[oldStationId][1]);
        double newCarToNewStatdist = computeDist(data[candidateCarId][0],data[candidateCarId][1],stations[newStationId][0], stations[newStationId][1]);

        if(oldCarToNewStatdist < oldCarToOldStatdist && newCarToOldStatdist <  newCarToNewStatdist){
            return true;
        }
        else
            return false;
    }

    private boolean shouldTransfer(double[][] data, double[][] stations, int station1, int station2, int station3, int carId1,int carId2,int carId3, Map<Integer, Set<Integer>> stationMap){
        double oldDist1 = computeDist(data[carId1][0],data[carId1][1],stations[station1][0], stations[station1][1]);
        double oldDist2 = computeDist(data[carId2][0],data[carId2][1],stations[station2][0], stations[station2][1]);
        double oldDist3 = computeDist(data[carId3][0],data[carId3][1],stations[station3][0], stations[station3][1]);

        double newDist12 = computeDist(data[carId1][0],data[carId1][1],stations[station2][0], stations[station2][1]);
        double newDist23 = computeDist(data[carId2][0],data[carId2][1],stations[station3][0], stations[station3][1]);
        double newDist31 = computeDist(data[carId3][0],data[carId3][1],stations[station1][0], stations[station1][1]);


        double newDist13 = computeDist(data[carId1][0],data[carId1][1],stations[station3][0], stations[station3][1]);
        double newDist21 = computeDist(data[carId2][0],data[carId2][1],stations[station1][0], stations[station1][1]);
        double newDist32 = computeDist(data[carId3][0],data[carId3][1],stations[station2][0], stations[station2][1]);

        if(newDist12 + newDist23 + newDist31 < oldDist1 + oldDist2 + oldDist3 ||  newDist13 + newDist21 + newDist32 < oldDist1 + oldDist2 + oldDist3){
            if(newDist12 + newDist23 + newDist31 < newDist13 + newDist21 + newDist32){
                swap(stationMap, station1, station2, carId1, carId2);
                swap(stationMap, station2, station3, carId2, carId3);
                swap(stationMap, station3, station1, carId3, carId1);
            }
            else {
                swap(stationMap, station1, station3, carId1, carId3);
                swap(stationMap, station2, station1, carId2, carId1);
                swap(stationMap, station3, station2, carId3, carId2);
            }

            return true;
        }
        else
            return false;
    }


    private void Q4Init(Map<Integer, Set<Integer>> stationMap, Map<Integer, List<Integer>> carStationsMap, double[][] data, double[][] stations, Set<Integer> nextCarSet, int round){
        List<Delta> deltasList = new ArrayList<>();

        for (int i = 0; i < DATACNT; i++) {
            if(!nextCarSet.contains(i)){
                continue;
            }
            System.out.println("Processing " + i );
            PriorityQueue<IdxDist> queue;
            List<Integer> sidList;
            if(carStationsMap.containsKey(i)){
                sidList = carStationsMap.get(i);
            }
            else{
                queue = new PriorityQueue<>(new Comparator<IdxDist>() {
                    @Override
                    public int compare(IdxDist o1, IdxDist o2) {
                        if(o1.dist == o2.dist)
                            return 0;
                        else
                            return o1.dist > o2.dist ? 1 : -1;
                    }
                });
                for (int j = 0; j < SATATIONCNT; j++) {
                    double dist = computeDist(data[i][0], data[i][1], stations[j][0], stations[j][1]);
                    IdxDist idxDist = new IdxDist(j, dist);
                    queue.add(idxDist);
                }

                sidList = new ArrayList<>();
                while (!queue.isEmpty()){
                    sidList.add(queue.poll().idx);
                }

                carStationsMap.put(i, sidList);

            }
            int nearestStationId = -1;
            double nearestDist = 0.0;

            int furthestStationId =  nearestStationId;
            double furthestDist = nearestDist;
            int r = 1;
            while (r <= SATATIONCNT){

                if(r == round){
                    nearestStationId = sidList.get(r-1);
                    nearestDist = computeDist(data[i][0], data[i][1], stations[nearestStationId][0], stations[nearestStationId][1]);
                }
                if(r == SATATIONCNT){
                    furthestStationId = sidList.get(r-1);
                    furthestDist = computeDist(data[i][0], data[i][1], stations[furthestStationId][0], stations[furthestStationId][1]);
                }
                r++;
            }

            deltasList.add(new Delta(i, nearestStationId, furthestStationId, nearestDist - furthestDist));

        }

        Collections.sort(deltasList, new DeltaComparator());

        // assign cars to stations
        Set<Integer> tmpSet = new HashSet<>();
        for(Delta d: deltasList){
            Set<Integer> carSet = stationMap.getOrDefault(d.nearestStation, new HashSet<Integer>());
            if(carSet.size() < 200){
                carSet.add(d.carIndex);
                stationMap.put(d.nearestStation, carSet);
            }
            else{
                tmpSet.add(d.carIndex);
            }
        }

        nextCarSet.retainAll(tmpSet);
    }

    class Delta{
        int carIndex;
        int nearestStation;
        int furthestStation;
        double delta;

        public Delta(int carIndex, int primaryStation, int furthestStation, double delta) {
            this.carIndex = carIndex;
            this.nearestStation = primaryStation;
            this.furthestStation = furthestStation;
            this.delta = delta;
        }
    }

    class DeltaComparator implements Comparator<Delta>{

        @Override
        public int compare(Delta o1, Delta o2) {
            if(o1.delta == o2.delta)
                return 0;
            else{
                return o1.delta < o2.delta ? -1 : 1;
            }
        }
    }

    class IdxDist {
        int idx; // index
        double dist; // dist to station

        public IdxDist(int cidx, double dist) {
            this.idx = cidx;
            this.dist = dist;
        }
    }

    private int computeCarCntWithMeters(int meters) throws IOException {

        double[][] data = readData(DATACNT, dataPath);
        double[][] stations = readData(SATATIONCNT, stationPath);

        int cnt = 0;
        for (int i = 0; i < DATACNT; i++) {
            for (int j = 0; j < SATATIONCNT; j++) {
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
