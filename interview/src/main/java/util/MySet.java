package util;

import java.util.*;

/**
 * Created by jianqsun on 4/16/14.
 */
public class MySet{
    public static void main(String[] args){
       Set<Integer> myset = new HashSet<Integer>();
       myset.add(1);
       myset.add(2);
       myset.add(3);
       myset.add(4);
       myset.add(5);

       List<Set<Integer>> l = split(myset, 4);

       for(Set<Integer> s: l){
           System.out.println(Arrays.toString(s.toArray()));
       }

    }

    public static <T> List<Set<T>> split(Set<T> original, int count) {
        // Create a list of sets to return.
        ArrayList<Set<T>> l = new ArrayList<Set<T>>(count);

        // Create an iterator for the original set.
        Iterator<T> it = original.iterator();

        // Calculate required number for each set.
        int each = original.size() / count + 1;

        // Loop for each new set.
        for (int i=0; i<count; i++) {
            // Create the set.
            HashSet<T> s = new HashSet<T>(each);

            // Add to the list.
            l.add(s);

            // Loop over each element.
            for (int j=0; j<each && it.hasNext(); j++) {
                // Add the element to the set.
                s.add(it.next());
            }
        }
        return l;
    }
}
