package com.jianqing.interview.basic;

import java.util.*;

/**
 * Created by jianqingsun on 1/23/18.
 */
public class Tesla {
    public static void main(String[] args) {
        List<String> data = Arrays.asList("abcde","abcde","abcde","abfde","vecde","apcdk","apcdk");
        Tesla tesla = new Tesla();
        tesla.mostKlocaion(data, 2);

    }

    public void mostKlocaion(List<String> data, int k) {

        PriorityQueue<Location> queue = new PriorityQueue<Location>(new Comparator<Location>(){
            public int compare(Location l1, Location l2){
                if(l1.cnt < l2.cnt){
                    return -1;
                }
                else if(l1.cnt > l2.cnt){
                    return 1;
                }
                else
                    return 0;
            }
        });

        Map<String, Location> map = new HashMap<>();

        for(String geohash : data) {
            Location l = null;
            if(map.containsKey(geohash)){
                l = map.get(geohash);
                l.cnt++;
            }
            else{
                l = new Location(geohash, 1);
                map.put(geohash, l);
            }
        }

        for(Location location : map.values()){
            if(queue.size() >= k){
                Location tmp = queue.peek();
                if(tmp.cnt < location.cnt){
                    queue.remove();
                    queue.add(location);
                }
            }
            else{
                queue.add(location);
            }
        }


        // print result
        while(!queue.isEmpty()){
            System.out.println(queue.poll().geohash);
        }

    }
}

class Location{
    String geohash;
    int cnt;

    public Location(String geohash, int cnt) {
        this.geohash = geohash;
        this.cnt = cnt;
    }
}
