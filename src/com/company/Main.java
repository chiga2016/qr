package com.company;
public class Main {
    public static void main(String[] args) {
        ReadScan readScan = new ReadScan();
        ScannedAssured assured = new ScannedAssured();
        WorkData workData = new WorkData(assured);
        readScan.read(workData);
        //System.out.println(assured);
   }
}


