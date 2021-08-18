package com.company;

import java.math.BigInteger;

public class WorkData {
    ScannedAssured assured;

    public void processing(String[] bytes){

        //String[] bytes =null;//= readScan.newportReader.data;
        if (bytes != null) {
            String tip = "";
            String npolis = "";
            String fio;
            String sex;
            String dr;
            String srok;
            String ecp;
//            for (int i = 0; i < bytes.length; i++) {
//                System.out.print(bytes[i] + " ");
//            }
            tip = bytes[0];
//            boolean startpolis = true;
            for (int i = 1; i <= 8; i++) {
//                        if(startpolis){
//                            if(bytes[i].equals("00")){
//                                continue;
//                            } else {
//                                startpolis=false;
//                            }
//                        }
                //BigInteger b =new BigInteger(new BigInteger(bytes[i]).toString(2),2);
                //String s=a.toString(2);
                npolis = npolis + bytes[i];
            }

            //System.out.println(tip);
            //System.out.println(npolis);
            //System.out.println();
            //Integer.toHexString(257400887000125).toUpperCase();
            //System.out.println(Converter.hexToBinary(npolis));
            //И снова отправляем запрос
//            long num = Long.parseLong(npolis, 16);
//            System.out.println("" + num);

            BigInteger num2 = new BigInteger(npolis, 16);
            assured.setNpolis(num2);
            System.out.println("" + num2);

        }
    }

    public WorkData(ScannedAssured assured) {
        this.assured = assured;
        System.out.println("create workdata");
    }
}
