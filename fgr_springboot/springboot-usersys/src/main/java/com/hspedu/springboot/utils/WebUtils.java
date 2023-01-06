package com.hspedu.springboot.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class WebUtils {

    public static String UPLOAD_FILE_DIRECTORY = "static/images/upload/";
    public static String getYearMonthDay(){//生成当前日期目录
        LocalDateTime ldt = LocalDateTime.now();
        int year = ldt.getYear();
        int monthValue = ldt.getMonthValue();
        int dayOfMonth = ldt.getDayOfMonth();

//        new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        String yearMonthDay = year + "/" + monthValue + "/" + dayOfMonth + "/";
        return UPLOAD_FILE_DIRECTORY + yearMonthDay;
    }
}
