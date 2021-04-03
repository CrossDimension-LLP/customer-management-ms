package com.octopus.customerManagement.businessLogic.implementation;

import com.octopus.customerManagement.businessLogic.interfaces.IUtility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility implements IUtility {

    public String IdGenerator() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(date);

        String splitter[] = strDate.split("-");
        String dater = String.join("", splitter);
        String spliter[] = dater.split(":");
        dater = String.join("", spliter);
        spliter = dater.split(" ");
        dater = String.join("", spliter);

        return dater;
    }
}
