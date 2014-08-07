package util;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jianqsun on 6/7/14.
 */
public class HashTest {


    public static void main(String[] args){
        Set<MyObj> set = new HashSet<MyObj>();

        set.add(new MyObj(1));
        set.add(new MyObj(2));

        System.out.println(set.size());
    }


}

class MyObj{
    public int id;

    MyObj(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyObj myObj = (MyObj) o;

        if (id != myObj.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
