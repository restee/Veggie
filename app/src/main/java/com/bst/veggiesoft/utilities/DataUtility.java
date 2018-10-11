package com.bst.veggiesoft.utilities;

import android.content.Context;
import android.util.Log;


import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class DataUtility {

    public static String longToString(Long longVal) {
        String flag = "";
        if (longVal != null) {
            flag = Long.toString(longVal);
        }

        return flag;
    }

    private static String convertToHex(byte[] data) {
        StringBuilder buf = new StringBuilder();
        for (byte b : data) {
            int halfbyte = (b >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                buf.append((0 <= halfbyte) && (halfbyte <= 9) ? (char) ('0' + halfbyte) : (char) ('a' + (halfbyte - 10)));
                halfbyte = b & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static String SHA256(String text) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] textBytes = text.getBytes("iso-8859-1");
            md.update(textBytes, 0, textBytes.length);
            byte[] sha1hash = md.digest();
            return convertToHex(sha1hash);
        } catch (Exception e) {
            e.printStackTrace();
            return text;
        }
    }

    public static boolean isEmailAddress(String val) {
        boolean flag = false;
        int counter = val.length() - 1;
        for (; counter > 0; counter--) {
            if (val.charAt(counter) == '.') {
                for (; counter > 0; counter--) {
                    if (val.charAt(counter) == '@' && counter > 0) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public static boolean isStringEmpty(String val) {
        if (val != null) {
            val = val.replaceAll("\\s+", "");
        }
        if (val == null || val.isEmpty() || val.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String replaceSpaceWithLine(String val) {
        String flag = "";

        if (val != null) {
            flag = val.replace(" ", "\n");
        }

        return flag;
    }

    public static Double stringToDouble(String string) {
        Double val = 0.0;
        try {
            val = Double.parseDouble(string);
        } catch (Exception e) {
            val = 0.0;
        }
        return val;
    }

    public static String doubleToString2DecWithSign(Double doubleVal) {
        String flag = "";
        if (doubleVal != null && doubleVal > 0) {
            flag = "+";
        }
        flag = flag + DataUtility.doubleToString2Dec(doubleVal);

        return flag;
    }

    public static String doubleToString2Dec(Double doubleVal) {
        DecimalFormat format = new DecimalFormat("0.00");
        String flag = "";

        try {
            flag = format.format(doubleVal);
        } catch (Exception e) {
            flag = "0.00";
        }

        return flag;
    }

    public static String doubleToLensRec(Double doubleVal) {
        String flag = "";
        if (doubleVal != null && doubleVal > 0) {
            flag += "+";
        }
        flag += doubleToString2Dec(doubleVal);

        return flag;
    }

    public static String doubleToString3Dec(Double doubleVal) {
        DecimalFormat format = new DecimalFormat("000");
        String flag = "";

        try {
            flag = format.format(doubleVal);
        } catch (Exception e) {
            flag = "000";
        }

        return flag;
    }

    public static String doubleToString(Double doubleVal) {
        String flag = "";

        try {
            flag = Double.toString(doubleVal);
        } catch (Exception e) {
            flag = "";
        }

        return flag;
    }

    public static String floatToString(Float doubleVal) {
        String flag = "";

        try {
            flag = Float.toString(doubleVal);
        } catch (Exception e) {
            flag = "";
        }

        return flag;
    }


    public static String getTimeStamp() {
        Date date = Calendar.getInstance().getTime();
        return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(date).toString();
    }


    public static Date getTimeStampDate() {
        Date date = Calendar.getInstance().getTime();
        return date;
    }

    public static Double getTimeStampDouble() {
        return (double) Calendar.getInstance().getTime().getTime();
    }

    public static Date mmddyyyyToDate(String date) {
        Date flag = null;
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        format.setLenient(false);
        try {
            flag = format.parse(date);
            Log.d("DATE", format.format(flag));
            Log.d("Date", flag.toString());
        } catch (Exception e) {
            flag = null;
            e.printStackTrace();
        }

        return flag;
    }

    public static Date ddmmyyyyToDate(String date) {
        Date flag = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            flag = format.parse(date);
            Log.d("DATE", format.format(flag));
            Log.d("Date", flag.toString());
        } catch (Exception e) {
            flag = null;
            e.printStackTrace();
        }

        return flag;
    }

    public static String mmddyyyyToString(Date date) {
        String flag = null;
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        try {
            flag = format.format(date);
        } catch (Exception e) {
            flag = null;
        }

        return flag;
    }

    public static String mmmddyyyyToString(Date date) {
        String flag = null;
        SimpleDateFormat format = new SimpleDateFormat("MMM-dd-yyyy");
        try {
            flag = format.format(date);
        } catch (Exception e) {
            flag = null;
        }

        return flag;
    }

    public static String dateToBirthdayString(Date date) {
        String flag = null;
        SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
        try {
            flag = format.format(date);
        } catch (Exception e) {
            flag = null;
        }

        return flag;
    }

    public static String dateToFormalDateTimeString(Date date) {
        String flag = null;
        SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy hh:mm a");
        try {
            flag = format.format(date);
        } catch (Exception e) {
            flag = null;
        }

        return flag;
    }

    public static String dateToDDMMYYYY_HHMMSS(Date date) {
        String flag = null;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        try {
            flag = format.format(date);
        } catch (Exception e) {
            flag = null;
        }

        return flag;
    }

    public static String dateToDDMMYYYY(Date date) {
        String flag = null;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            flag = format.format(date);
        } catch (Exception e) {
            flag = null;
        }

        return flag;
    }

    public static Date stringToDDMMYYYY(String date) {
        Date flag = null;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            flag = format.parse(date);
        } catch (Exception e) {
            flag = null;
        }

        return flag;
    }

    public static String ddmmyyyyToString(Date date) {
        String flag = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            flag = format.format(date);
        } catch (Exception e) {
            flag = null;
        }

        return flag;
    }

    public static String dateToYYYYMMDD(Date date) {
        String flag = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            flag = format.format(date);
        } catch (Exception e) {
            flag = null;
        }
        return flag;
    }

    public static String dateToYYYYMMDD_HHMMSS(Date date) {
        String flag = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        try {
            flag = format.format(date);
        } catch (Exception e) {
            flag = null;
        }

        return flag;
    }

    public static String dateToHHmmss(Date date) {
        String flag = null;
        SimpleDateFormat format = new SimpleDateFormat("HHmmss");
        try {
            flag = format.format(date);
        } catch (Exception e) {
            flag = null;
        }
        return flag;
    }


    public static String timestampToString(Date date) {
        String flag = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            flag = format.format(date);
        } catch (Exception e) {
            flag = null;
        }

        return flag;
    }

    public static Date stringToTimestamp(String string) {
        Date flag = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            flag = format.parse(string);
        } catch (Exception e) {
            flag = null;
        }

        return flag;
    }

    public static String intToString(Integer intVal) {
        String flag = "";
        try {
            flag = Integer.toString(intVal);
        } catch (Exception e) {
            flag = "";
        }

        return flag;
    }

    public static Float stringToFloat(String val) {
        Float flag = null;
        if (!isStringEmpty(val)) {
            flag = Float.parseFloat(val);
        }
        return flag;
    }

    public static Integer stringToInteger(String val) {
        Integer flag = null;
        if (!isStringEmpty(val)) {
            flag = Integer.parseInt(val);
        }
        return flag;
    }

    public static int getAge(Date date) {
        int age = 0;

        return age;
    }


    public static Date addDay(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, day);
        return c.getTime();
    }

    public static double inchesToMM(double in) {
        return in * 25.4;
    }

    public static String getTimezone() {
        Calendar cal = Calendar.getInstance();
        long milliDiff = cal.get(Calendar.ZONE_OFFSET);
        String[] ids = TimeZone.getAvailableIDs();
        String name = null;
        for (String id : ids) {
            TimeZone tz = TimeZone.getTimeZone(id);
            if (tz.getRawOffset() == milliDiff) {
                name = id;
                break;
            }
        }
        return name;
    }

    public static int getResId(String variableName, String resourceName, int localization, Context context) {
        variableName += "_" + localization;

        int id = context.getResources().getIdentifier(variableName, resourceName, context.getPackageName());
        return id;
    }

    public static String getSign(String text) {
        String flag = "";
        if (text != null) {
            flag = text.substring(0, 1);
        }
        if (!(flag.equals("-"))) {
            flag = "+";
        }

        return flag;
    }

    public static String getTimezoneVal(String text) {
        String flag = "";
        if (text != null) {
            flag = text.substring(0, 1);
            if (flag.equals("-") || flag.equals("+")) {
                flag = text.substring(1);
            } else {
                flag = text.substring(0);
            }
        }
        return flag;
    }

    public static boolean compareStrings(String string1, String string2) {
        boolean flag = false;
        if (string1 != null && string2 != null) {
            if (string1.equals(string2)) {
                flag = true;
            }
        } else if (string1 == null && string2 == null) {
            flag = true;
        }

        return flag;
    }
}
