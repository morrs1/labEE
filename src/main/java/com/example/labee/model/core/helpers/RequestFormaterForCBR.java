package com.example.labee.model.core.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class RequestFormaterForCBR {
    public static String format(Map<String, String> parameters) {
        String url = "https://www.cbr.ru/scripts/";
        String startData = parameters.get("startDate");
        String endData = parameters.get("endDate");

        if (parameters.get("category").equals("metals")) {
            url += "xml_metall.asp?date_req1=" + convertDateFormat(startData) + "&date_req2=" + convertDateFormat(endData);
        }else {
            url += "XML_dynamic.asp?date_req1=" + convertDateFormat(startData) + "&date_req2=" + convertDateFormat(endData)
                    + "&VAL_NM_RQ=R01235";
        }

        System.out.println(url);
        return url;
    }

    public static String convertDateFormat(String dateStr) {
        System.out.println(dateStr);
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = inputFormat.parse(dateStr);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
