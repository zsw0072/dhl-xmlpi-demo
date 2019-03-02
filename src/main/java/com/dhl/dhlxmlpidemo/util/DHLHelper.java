package com.dhl.dhlxmlpidemo.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DHLHelper {

    public  static String getDhlDateTime(){

        String localTime = LocalDateTime.now().toString();
        StringBuffer sb = new StringBuffer();
        String finalDate = sb.append(localTime).append("+08:00").toString();
        return finalDate;
    }
}
