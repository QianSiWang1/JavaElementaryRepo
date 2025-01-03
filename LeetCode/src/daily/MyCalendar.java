package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 2025年1月2日
 * number 729
 * You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.
 * A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).
 * The event can be represented as a pair of integers startTime and endTime that represents a booking
 * on the half-open interval [startTime, endTime), the range of real numbers x such that startTime <= x < endTime.
 * Implement the MyCalendar class:
 * MyCalendar() Initializes the calendar object.
 * boolean book(int startTime, int endTime) Returns true if the event can be added to the calendar successfully
 * without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 */
public class MyCalendar {
    public static void main(String[] args) {
        MyCalendar myCalendarI = new MyCalendar();
        System.out.println(myCalendarI.book(10, 20));
        System.out.println(myCalendarI.book(15, 25));;
        System.out.println(myCalendarI.book(20, 30));;
    }
    List<int[]> booked;

    public MyCalendar() {
        booked = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                return false;
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }
}
