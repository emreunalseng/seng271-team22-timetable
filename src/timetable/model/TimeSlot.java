package timetable.model;

/**
 * A TimeSlot is a period of time on one working day.
 * Example: Monday from 09:00 to 12:00 is day = "Mon", startHour = 9, endHour = 12.
 *
 * We use this class for three things:
 * - the time of a session (when the lesson happens),
 * - the times when an instructor is not available,
 * - the times when a room is not available.
 */
public class TimeSlot {

    // The five working days, in the correct order of the week.
    public static final String[] DAYS = {"Mon", "Tue", "Wed", "Thu", "Fri"};

    // The full day names, in the same order as DAYS (we use them in e-mails).
    public static final String[] FULL_DAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    // The day starts at 09:00.
    public static final int FIRST_HOUR = 9;

    // The day ends at 17:00. Every session must finish by this hour.
    public static final int LAST_HOUR = 17;

    private String day;      // short day name, for example "Mon"
    private int startHour;   // start hour, for example 9 means 09:00
    private int endHour;     // end hour, for example 12 means 12:00

    // Creates a new time slot.
    public TimeSlot(String day, int startHour, int endHour) {
        this.day = day;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    // ---------- Getters and setters ----------

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    // ---------- Helper methods ----------

    // Returns how many hours long this time slot is.
    // Example: 09:00-12:00 is 3 hours.
    public int getLength() {
        return endHour - startHour;
    }

    // Returns true if this time slot and the other time slot share at least one hour.
    // Example: Mon 09:00-12:00 and Mon 11:00-13:00 overlap (11:00-12:00 is shared).
    // Example: Mon 09:00-12:00 and Mon 12:00-14:00 do NOT overlap.
    public boolean overlaps(TimeSlot other) {
        // Different days can never overlap.
        if (!day.equals(other.getDay())) {
            return false;
        }
        // Same day: they overlap if this one starts before the other ends
        // AND the other one starts before this one ends.
        return startHour < other.getEndHour() && other.getStartHour() < endHour;
    }

    // Returns true if the other time slot is completely inside this time slot.
    // Example: Mon 09:00-17:00 contains Mon 10:00-12:00.
    public boolean contains(TimeSlot other) {
        if (!day.equals(other.getDay())) {
            return false;
        }
        return other.getStartHour() >= startHour && other.getEndHour() <= endHour;
    }

    // Returns true if this time slot is inside the working week:
    // Monday to Friday, between 09:00 and 17:00 (rule HC-04).
    public boolean isInWorkingHours() {
        if (getDayIndex(day) == -1) {
            return false; // not a working day
        }
        if (startHour < FIRST_HOUR || endHour > LAST_HOUR) {
            return false; // starts too early or ends too late
        }
        return startHour < endHour; // the slot must be at least one hour long
    }

    // Returns true if this time slot finishes before the other one starts.
    // We use it for rule SC-01 (theory should come before lab in the week).
    public boolean isBefore(TimeSlot other) {
        int thisDay = getDayIndex(day);
        int otherDay = getDayIndex(other.getDay());

        if (thisDay < otherDay) {
            return true;  // an earlier day in the week
        }
        if (thisDay > otherDay) {
            return false; // a later day in the week
        }
        // Same day: compare the hours.
        return endHour <= other.getStartHour();
    }

    // Returns the position of a day in the week: "Mon" = 0, "Tue" = 1, ... "Fri" = 4.
    // Returns -1 if the text is not a working day.
    public static int getDayIndex(String dayName) {
        for (int i = 0; i < DAYS.length; i++) {
            if (DAYS[i].equals(dayName)) {
                return i;
            }
        }
        return -1;
    }

    // Returns the full name of a day. Example: "Tue" becomes "Tuesday".
    // If the text is not a working day, it is returned without change.
    public static String getFullDayName(String dayName) {
        int index = getDayIndex(dayName);
        if (index == -1) {
            return dayName;
        }
        return FULL_DAYS[index];
    }

    // Writes a day in the same way as the DAYS list. Examples: "WED" becomes "Wed", "monday" becomes "Mon".
    public static String fixDay(String day) {
        if (day.length() < 3) {
            return day;
        }
        return day.substring(0, 1).toUpperCase() + day.substring(1, 3).toLowerCase();
    }

    // Changes an hour number into clock text. Example: 9 becomes "09:00".
    public static String formatHour(int hour) {
        if (hour < 10) {
            return "0" + hour + ":00";
        }
        return hour + ":00";
    }

    // Returns the time slot as text. Example: "Mon 09:00-12:00".
    @Override
    public String toString() {
        return day + " " + formatHour(startHour) + "-" + formatHour(endHour);
    }
}
