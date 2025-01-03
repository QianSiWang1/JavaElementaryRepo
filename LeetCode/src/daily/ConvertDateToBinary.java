package daily;

/**
 * 2025年1月1日
 * number 3280
 * You are given a string date representing a Gregorian calendar date in the yyyy-mm-dd format.
 * date can be written in its binary representation obtained by converting year, month,
 * and day to their binary representations without any leading zeroes and writing them down in year-month-day format.
 * Return the binary representation of date.
 */

public class ConvertDateToBinary {
    public static void main(String[] args) {
        String date = "2080-02-29";
        System.out.println(convertDateToBinary(date));
    }

    public static String binary(int x){
        StringBuilder sb = new StringBuilder();
        for(; x !=0 ; x >>= 1){
            sb.append(x & 1);
        }
        return sb.reverse().toString();
    }

    public static String convertDateToBinary(String date){
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        return binary(year) + "-" + binary(month) + "-" + binary(day);
    }

}
