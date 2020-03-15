package com.example.paging.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Converter {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
    static SimpleDateFormat remainingFormat = new SimpleDateFormat( "HH 'Hours,' mm 'Minutes,' ss 'Seconds'");


    public static Date parseToDate(String date) throws ParseException {
        Date date1 = sdf.parse(date);
        return date1;
    }

    public static String getRemaining(long miliseconds) {
        return remainingFormat.format(miliseconds);
    }

}
