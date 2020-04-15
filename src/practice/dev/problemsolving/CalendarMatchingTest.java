package practice.dev.problemsolving;

import java.util.*;
import org.junit.*;

public class CalendarMatchingTest {

    public boolean arraysEqual(List<CalendarMatching.StringMeeting> arr1, List<CalendarMatching.StringMeeting> arr2) {
        if (arr1.size() != arr2.size()) return false;

        for (int i = 0; i < arr1.size(); i++) {
            if (!arr1.get(i).start.equals(arr2.get(i).start)
                    || !arr1.get(i).end.equals(arr2.get(i).end)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void TestCase1() {
        List<CalendarMatching.StringMeeting> calendar1 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar1.add(new CalendarMatching.StringMeeting("9:00", "10:30"));
        calendar1.add(new CalendarMatching.StringMeeting("12:00", "13:00"));
        calendar1.add(new CalendarMatching.StringMeeting("16:00", "18:00"));

        CalendarMatching.StringMeeting dailyBounds1 = new CalendarMatching.StringMeeting("9:00", "20:00");

        List<CalendarMatching.StringMeeting> calendar2 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar2.add(new CalendarMatching.StringMeeting("10:00", "11:30"));
        calendar2.add(new CalendarMatching.StringMeeting("12:30", "14:30"));
        calendar2.add(new CalendarMatching.StringMeeting("14:30", "15:00"));
        calendar2.add(new CalendarMatching.StringMeeting("16:00", "17:00"));

        CalendarMatching.StringMeeting dailyBounds2 = new CalendarMatching.StringMeeting("10:00", "18:30");

        int meetingDuration = 30;

        List<CalendarMatching.StringMeeting> expected = new ArrayList<CalendarMatching.StringMeeting>();
        expected.add(new CalendarMatching.StringMeeting("11:30", "12:00"));
        expected.add(new CalendarMatching.StringMeeting("15:00", "16:00"));
        expected.add(new CalendarMatching.StringMeeting("18:00", "18:30"));

        List<CalendarMatching.StringMeeting> actual =
                CalendarMatching.calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
        Assert.assertTrue(arraysEqual(expected, actual));
    }

    @Test
    public void TestCase2() {
        List<CalendarMatching.StringMeeting> calendar1 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar1.add(new CalendarMatching.StringMeeting("9:00", "10:30"));
        calendar1.add(new CalendarMatching.StringMeeting("12:00", "13:00"));
        calendar1.add(new CalendarMatching.StringMeeting("16:00", "18:00"));

        CalendarMatching.StringMeeting dailyBounds1 = new CalendarMatching.StringMeeting("9:00", "20:00");

        List<CalendarMatching.StringMeeting> calendar2 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar2.add(new CalendarMatching.StringMeeting("10:00", "11:30"));
        calendar2.add(new CalendarMatching.StringMeeting("12:30", "14:30"));
        calendar2.add(new CalendarMatching.StringMeeting("14:30", "15:00"));
        calendar2.add(new CalendarMatching.StringMeeting("16:00", "17:00"));

        CalendarMatching.StringMeeting dailyBounds2 = new CalendarMatching.StringMeeting("10:00", "18:30");

        int meetingDuration = 45;

        List<CalendarMatching.StringMeeting> expected = new ArrayList<CalendarMatching.StringMeeting>();
        expected.add(new CalendarMatching.StringMeeting("15:00", "16:00"));

        List<CalendarMatching.StringMeeting> actual =
                CalendarMatching.calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
        Assert.assertTrue(arraysEqual(expected, actual));
    }

    @Test
    public void TestCase3() {
        List<CalendarMatching.StringMeeting> calendar1 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar1.add(new CalendarMatching.StringMeeting("9:00", "10:30"));
        calendar1.add(new CalendarMatching.StringMeeting("12:00", "13:00"));
        calendar1.add(new CalendarMatching.StringMeeting("16:00", "18:00"));

        CalendarMatching.StringMeeting dailyBounds1 = new CalendarMatching.StringMeeting("8:00", "20:00");

        List<CalendarMatching.StringMeeting> calendar2 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar2.add(new CalendarMatching.StringMeeting("10:00", "11:30"));
        calendar2.add(new CalendarMatching.StringMeeting("12:30", "14:30"));
        calendar2.add(new CalendarMatching.StringMeeting("14:30", "15:00"));
        calendar2.add(new CalendarMatching.StringMeeting("16:00", "17:00"));

        CalendarMatching.StringMeeting dailyBounds2 = new CalendarMatching.StringMeeting("7:00", "18:30");

        int meetingDuration = 45;

        List<CalendarMatching.StringMeeting> expected = new ArrayList<CalendarMatching.StringMeeting>();
        expected.add(new CalendarMatching.StringMeeting("8:00", "9:00"));
        expected.add(new CalendarMatching.StringMeeting("15:00", "16:00"));

        List<CalendarMatching.StringMeeting> actual =
                CalendarMatching.calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
        Assert.assertTrue(arraysEqual(expected, actual));
    }

    @Test
    public void TestCase4() {
        List<CalendarMatching.StringMeeting> calendar1 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar1.add(new CalendarMatching.StringMeeting("8:00", "10:30"));
        calendar1.add(new CalendarMatching.StringMeeting("11:30", "13:00"));
        calendar1.add(new CalendarMatching.StringMeeting("14:00", "16:00"));
        calendar1.add(new CalendarMatching.StringMeeting("16:00", "18:00"));

        CalendarMatching.StringMeeting dailyBounds1 = new CalendarMatching.StringMeeting("8:00", "18:00");

        List<CalendarMatching.StringMeeting> calendar2 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar2.add(new CalendarMatching.StringMeeting("10:00", "11:30"));
        calendar2.add(new CalendarMatching.StringMeeting("12:30", "14:30"));
        calendar2.add(new CalendarMatching.StringMeeting("14:30", "15:00"));
        calendar2.add(new CalendarMatching.StringMeeting("16:00", "17:00"));

        CalendarMatching.StringMeeting dailyBounds2 = new CalendarMatching.StringMeeting("7:00", "18:30");

        int meetingDuration = 15;

        List<CalendarMatching.StringMeeting> expected = new ArrayList<CalendarMatching.StringMeeting>();

        List<CalendarMatching.StringMeeting> actual =
                CalendarMatching.calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
        Assert.assertTrue(arraysEqual(expected, actual));
    }

    @Test
    public void TestCase5() {
        List<CalendarMatching.StringMeeting> calendar1 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar1.add(new CalendarMatching.StringMeeting("10:00", "10:30"));
        calendar1.add(new CalendarMatching.StringMeeting("10:45", "11:15"));
        calendar1.add(new CalendarMatching.StringMeeting("11:30", "13:00"));
        calendar1.add(new CalendarMatching.StringMeeting("14:15", "16:00"));
        calendar1.add(new CalendarMatching.StringMeeting("16:00", "18:00"));

        CalendarMatching.StringMeeting dailyBounds1 = new CalendarMatching.StringMeeting("9:30", "20:00");

        List<CalendarMatching.StringMeeting> calendar2 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar2.add(new CalendarMatching.StringMeeting("10:00", "11:00"));
        calendar2.add(new CalendarMatching.StringMeeting("12:30", "13:30"));
        calendar2.add(new CalendarMatching.StringMeeting("14:30", "15:00"));
        calendar2.add(new CalendarMatching.StringMeeting("16:00", "17:00"));

        CalendarMatching.StringMeeting dailyBounds2 = new CalendarMatching.StringMeeting("9:00", "18:30");

        int meetingDuration = 15;

        List<CalendarMatching.StringMeeting> expected = new ArrayList<CalendarMatching.StringMeeting>();
        expected.add(new CalendarMatching.StringMeeting("9:30", "10:00"));
        expected.add(new CalendarMatching.StringMeeting("11:15", "11:30"));
        expected.add(new CalendarMatching.StringMeeting("13:30", "14:15"));
        expected.add(new CalendarMatching.StringMeeting("18:00", "18:30"));

        List<CalendarMatching.StringMeeting> actual =
                CalendarMatching.calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
        Assert.assertTrue(arraysEqual(expected, actual));
    }

    @Test
    public void TestCase6() {
        List<CalendarMatching.StringMeeting> calendar1 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar1.add(new CalendarMatching.StringMeeting("10:00", "10:30"));
        calendar1.add(new CalendarMatching.StringMeeting("10:45", "11:15"));
        calendar1.add(new CalendarMatching.StringMeeting("11:30", "13:00"));
        calendar1.add(new CalendarMatching.StringMeeting("14:15", "16:00"));
        calendar1.add(new CalendarMatching.StringMeeting("16:00", "18:00"));

        CalendarMatching.StringMeeting dailyBounds1 = new CalendarMatching.StringMeeting("9:30", "20:00");

        List<CalendarMatching.StringMeeting> calendar2 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar2.add(new CalendarMatching.StringMeeting("10:00", "11:00"));
        calendar2.add(new CalendarMatching.StringMeeting("10:30", "20:30"));

        CalendarMatching.StringMeeting dailyBounds2 = new CalendarMatching.StringMeeting("9:00", "22:30");

        int meetingDuration = 60;

        List<CalendarMatching.StringMeeting> expected = new ArrayList<CalendarMatching.StringMeeting>();

        List<CalendarMatching.StringMeeting> actual =
                CalendarMatching.calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
        Assert.assertTrue(arraysEqual(expected, actual));
    }

    @Test
    public void TestCase7() {
        List<CalendarMatching.StringMeeting> calendar1 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar1.add(new CalendarMatching.StringMeeting("10:00", "10:30"));
        calendar1.add(new CalendarMatching.StringMeeting("10:45", "11:15"));
        calendar1.add(new CalendarMatching.StringMeeting("11:30", "13:00"));
        calendar1.add(new CalendarMatching.StringMeeting("14:15", "16:00"));
        calendar1.add(new CalendarMatching.StringMeeting("16:00", "18:00"));

        CalendarMatching.StringMeeting dailyBounds1 = new CalendarMatching.StringMeeting("9:30", "20:00");

        List<CalendarMatching.StringMeeting> calendar2 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar2.add(new CalendarMatching.StringMeeting("10:00", "11:00"));
        calendar2.add(new CalendarMatching.StringMeeting("10:30", "16:30"));

        CalendarMatching.StringMeeting dailyBounds2 = new CalendarMatching.StringMeeting("9:00", "22:30");

        int meetingDuration = 60;

        List<CalendarMatching.StringMeeting> expected = new ArrayList<CalendarMatching.StringMeeting>();
        expected.add(new CalendarMatching.StringMeeting("18:00", "20:00"));

        List<CalendarMatching.StringMeeting> actual =
                CalendarMatching.calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
        Assert.assertTrue(arraysEqual(expected, actual));
    }

    @Test
    public void TestCase8() {
        List<CalendarMatching.StringMeeting> calendar1 = new ArrayList<CalendarMatching.StringMeeting>();

        CalendarMatching.StringMeeting dailyBounds1 = new CalendarMatching.StringMeeting("9:30", "20:00");

        List<CalendarMatching.StringMeeting> calendar2 = new ArrayList<CalendarMatching.StringMeeting>();

        CalendarMatching.StringMeeting dailyBounds2 = new CalendarMatching.StringMeeting("9:00", "16:30");

        int meetingDuration = 60;

        List<CalendarMatching.StringMeeting> expected = new ArrayList<CalendarMatching.StringMeeting>();
        expected.add(new CalendarMatching.StringMeeting("9:30", "16:30"));

        List<CalendarMatching.StringMeeting> actual =
                CalendarMatching.calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
        Assert.assertTrue(arraysEqual(expected, actual));
    }

    @Test
    public void TestCase9() {
        List<CalendarMatching.StringMeeting> calendar1 = new ArrayList<CalendarMatching.StringMeeting>();

        CalendarMatching.StringMeeting dailyBounds1 = new CalendarMatching.StringMeeting("9:00", "16:30");

        List<CalendarMatching.StringMeeting> calendar2 = new ArrayList<CalendarMatching.StringMeeting>();

        CalendarMatching.StringMeeting dailyBounds2 = new CalendarMatching.StringMeeting("9:30", "20:00");

        int meetingDuration = 60;

        List<CalendarMatching.StringMeeting> expected = new ArrayList<CalendarMatching.StringMeeting>();
        expected.add(new CalendarMatching.StringMeeting("9:30", "16:30"));

        List<CalendarMatching.StringMeeting> actual =
                CalendarMatching.calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
        Assert.assertTrue(arraysEqual(expected, actual));
    }

    @Test
    public void TestCase10() {
        List<CalendarMatching.StringMeeting> calendar1 = new ArrayList<CalendarMatching.StringMeeting>();

        CalendarMatching.StringMeeting dailyBounds1 = new CalendarMatching.StringMeeting("9:30", "16:30");

        List<CalendarMatching.StringMeeting> calendar2 = new ArrayList<CalendarMatching.StringMeeting>();

        CalendarMatching.StringMeeting dailyBounds2 = new CalendarMatching.StringMeeting("9:30", "16:30");

        int meetingDuration = 60;

        List<CalendarMatching.StringMeeting> expected = new ArrayList<CalendarMatching.StringMeeting>();
        expected.add(new CalendarMatching.StringMeeting("9:30", "16:30"));

        List<CalendarMatching.StringMeeting> actual =
                CalendarMatching.calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
        Assert.assertTrue(arraysEqual(expected, actual));
    }

    @Test
    public void TestCase11() {
        List<CalendarMatching.StringMeeting> calendar1 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar1.add(new CalendarMatching.StringMeeting("7:00", "7:45"));
        calendar1.add(new CalendarMatching.StringMeeting("8:15", "8:30"));
        calendar1.add(new CalendarMatching.StringMeeting("9:00", "10:30"));
        calendar1.add(new CalendarMatching.StringMeeting("12:00", "14:00"));
        calendar1.add(new CalendarMatching.StringMeeting("14:00", "15:00"));
        calendar1.add(new CalendarMatching.StringMeeting("15:15", "15:30"));
        calendar1.add(new CalendarMatching.StringMeeting("16:30", "18:30"));
        calendar1.add(new CalendarMatching.StringMeeting("20:00", "21:00"));

        CalendarMatching.StringMeeting dailyBounds1 = new CalendarMatching.StringMeeting("6:30", "22:00");

        List<CalendarMatching.StringMeeting> calendar2 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar2.add(new CalendarMatching.StringMeeting("9:00", "10:00"));
        calendar2.add(new CalendarMatching.StringMeeting("11:15", "11:30"));
        calendar2.add(new CalendarMatching.StringMeeting("11:45", "17:00"));
        calendar2.add(new CalendarMatching.StringMeeting("17:30", "19:00"));
        calendar2.add(new CalendarMatching.StringMeeting("20:00", "22:15"));

        CalendarMatching.StringMeeting dailyBounds2 = new CalendarMatching.StringMeeting("8:00", "22:30");

        int meetingDuration = 30;

        List<CalendarMatching.StringMeeting> expected = new ArrayList<CalendarMatching.StringMeeting>();
        expected.add(new CalendarMatching.StringMeeting("8:30", "9:00"));
        expected.add(new CalendarMatching.StringMeeting("10:30", "11:15"));
        expected.add(new CalendarMatching.StringMeeting("19:00", "20:00"));

        List<CalendarMatching.StringMeeting> actual =
                CalendarMatching.calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
        Assert.assertTrue(arraysEqual(expected, actual));
    }
}
