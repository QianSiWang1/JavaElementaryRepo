package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 2025年1月3日
 * number 731
 * You are implementing a program to use as your calendar.
 * We can add a new event if adding the event will not cause a triple booking.
 * A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all the three events.).
 * The event can be represented as a pair of integers startTime and endTime that represents a booking on the half-open interval [startTime, endTime), the range of real numbers x such that startTime <= x < endTime.
 * Implement the MyCalendarTwo class:
 * MyCalendarTwo() Initializes the calendar object.
 * boolean book(int startTime, int endTime) Returns true
 * if the event can be added to the calendar successfully without causing a triple booking.
 * Otherwise, return false and do not add the event to the calendar.
 */
public class MyCalendarTwo {
    public static void main(String[] args) {

    }

    List<int[]> booked;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        booked = new ArrayList<int[]>();
        overlaps = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : overlaps) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                return false;
            }
        }
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                overlaps.add(new int[]{Math.max(l, start), Math.min(r, end)});
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }
}
