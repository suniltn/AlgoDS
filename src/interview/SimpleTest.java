package interview;

import snapchat.Interview1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stipturn on 4/7/17.
 */
public class SimpleTest {


       Map<Integer,ArrayList<String>> map = new HashMap();


    public static void main(String[] args ) {


        SimpleTest obj = new SimpleTest();


        ArrayList<String> list = new ArrayList();
        list.add("sunil");

        obj. map.put(1,list);

        ArrayList<String> newlist =obj. map.get(1);
        newlist.add("sowmus");

        System.out.print(obj.map.get(1).toString());


        SimpleTest obj2 = new SimpleTest();

        ArrayList<String> list2 = new ArrayList();
        list2.add("sunil");

        obj2. map.put(1,list2);
        ArrayList<String> newlist2 =obj2. map.get(1);
        newlist2.add("sowmus");
        System.out.print(obj2.map.get(1).toString());

    }
}
