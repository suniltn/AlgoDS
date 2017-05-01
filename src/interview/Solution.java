package interview;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.*;

// Change this class however you want. Print your output to STDOUT
public class Solution {


    Map<Integer, String> versionValueMap ;

    Map<String, Map<Integer, String>> AtributeMap ;

    Map<String, Map<Map<Integer, String>, String>> profileMap = new HashMap();


    public Solution() {

              Map<Integer, String> versionValueMap = new HashMap();

        Map<String, Map<Integer, String>> AtributeMap = new HashMap();

        Map<String, Map<Map<Integer, String>, String>> profileMap = new HashMap();


    }

    public void update(String profileId, String fieldName, String fieldValue) {

        if (profileMap != null) {

            if (profileMap.containsKey(profileId)) {

                Map attrMap = (Map) profileMap.get(profileId);

                if (attrMap != null) {

                    if (attrMap.containsKey(fieldName)) {

                        Map vmap = (Map) attrMap.get(fieldName);

                        if (vmap != null) {
                            int maxversion = 1;
                            for (Object obj : vmap.entrySet()) {

                                Map.Entry<Integer, String> e = (Map.Entry) obj;
                                if (e.getKey().intValue() > maxversion) {
                                    maxversion = e.getKey();
                                }

                            }
                            vmap.put(maxversion, fieldValue);
                            System.out.println("update " + profileId + " " + fieldName + " " + fieldValue);
                        }

                    }
                } else {
                    //field does not exist;
                }


            } else {
                //profile does not exisst;

            }
        }
    }

    public void getField(String profileId, int version, String fieldName) {

        if (profileMap != null) {

            if (profileMap.containsKey(profileId)) {

                Map attrMap = profileMap.get(profileId);

                if (attrMap != null) {

                    if (attrMap.containsKey(fieldName)) {

                        Map vmap = (Map) attrMap.get(fieldName);

                        if (vmap != null) {
                            int maxversion = 1;
                            for (Object obj : vmap.entrySet()) {

                                Map.Entry<Integer, String> e = (Map.Entry) obj;


                                if (e.getKey().intValue() == version) {
                                    System.out.println("Profile ID for" + profileId + "at version " + version + ":");
                                    System.out.println(fieldName + "  " + e.getValue());
                                }


                            }

                        }

                    }
                } else {
                    //field does not exist;
                }


            } else {
                //profile does not exisst;

            }
        }
    }


        public static void main (String args[]) throws Exception {
            Scanner in = new Scanner(System.in);
            Solution sol = new Solution();
            int N = in.nextInt();


            for (int i = 0; i < N; i++) {
                String queryType = in.next();
                String profileId = in.next();
                if ("update".equals(queryType)) {
                    String fieldName = in.next();
                    String fieldValue = in.next();
                    sol.update(profileId, fieldName, fieldValue);
                }else if ("getfield".equals(queryType)) {
                    int version = in.nextInt();
                    String fieldName = in.next();
                    sol.getField(profileId, version, fieldName);
                }
            }
        }
    }
