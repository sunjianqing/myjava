package interview;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 11/24/13
 * Time: 10:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        //a = "11" b="1"
        int alength = a.length();
        int blength = b.length();
        ArrayList<String> al = new ArrayList<String>();
        int carryBit = 0;
        while(alength >0 && blength >0){
            int currentVal = carryBit + ( a.charAt(alength-1) - '0' ) + ( b.charAt(blength-1) - '0') ;
            if(currentVal > 1 ){
                carryBit = 1;
                currentVal = currentVal - 2;
            }
            else{
                carryBit = 0;
            }
            al.add(0, String.valueOf(currentVal));
            alength--;
            blength--;
        }

        while(alength >0){
            int currentVal = a.charAt(alength-1)-'0'+carryBit;
            if(currentVal > 1 ){
                carryBit = 1;
                currentVal = 0;
            }
            else{
                carryBit = 0;
            }
            al.add(0,String.valueOf(currentVal));
            alength--;
        }

        while(blength > 0){
            int currentVal = b.charAt(blength-1)-'0'+carryBit;
            if(currentVal > 1 ){
                carryBit = 1;
                currentVal = 0;
            }
            else{
                carryBit = 0;
            }
            al.add(0,String.valueOf(currentVal));

            blength--;
        }

        if(carryBit > 0 ){
            al.add(0,"1");
        }

        Iterator<String> it = al.iterator();
        StringBuffer sb = new StringBuffer();
        while(it.hasNext()){
            sb.append(it.next());
        }

        return sb.toString();

    }

    public static void main(String[] args){
        AddBinary ab = new AddBinary();
        String res = ab.addBinary("11","101");
        System.out.println(res);

        res = ab.addBinary("11","11");
        System.out.println(res);

        res = ab.addBinary("11","10000001");
        System.out.println(res);

        res = ab.addBinary("1111","1111");
        System.out.println(res);

    }
}
