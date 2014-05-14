package util;

/**
 * Created by jianqsun on 5/12/14.
 */
public class ObjTest {

    public static void main(String[] args){
        ObjTest test = new ObjTest();
        test.run();
    }

    public void run(){
        MyObj obj1 = new MyObj();
        obj1.value = 1;
        MyObj obj2 = new MyObj();
        obj2 = obj1;
        obj2.value = 2;
        System.out.println(obj1.value);
        System.out.println(obj2.value);

    }

    private class MyObj{
        int value;
        ObjTest next;
    }
}
