package basic.multithreading.generic;

import java.util.ArrayList;
import java.util.List;

public class CheckMain {
    public static void main(String[] args) {
        try {
            CheckInterface c1 = (CheckInterface) Class.forName("basic.multithreading.generic.Check1").newInstance();
            CheckInterface c2 = (CheckInterface) Class.forName("basic.multithreading.generic.Check2").newInstance();
            List<CheckInterface> list  = new ArrayList<>();
            list.add(c1);
            list.add(c2);

            System.out.println("done");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
