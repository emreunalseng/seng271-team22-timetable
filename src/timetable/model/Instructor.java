package timetable.model;

import java.util.ArrayList;

/**
 * An Instructor is a teacher who gives one or more courses.
 * Example: instructor "I01", Dr. Kaya, teaches SENG101 and SENG203,
 * and is not available on Monday 09:00-12:00.
 */
public class Instructor {

    // The possible teaching time preferences (used for rule SC-02).
    public static final String MORNING = "MORNING";     // likes to teach before 12:00
    public static final String AFTERNOON = "AFTERNOON"; // likes to teach after 13:00
    public static final String NO_PREFERENCE = "NONE";  // any time is fine

    private String id;                            // instructor ID, for example "I01"
    private String name;                          // full name, for example "Dr. Kaya"
    private ArrayList<String> courseCodes;        // codes of the courses this instructor teaches
    private ArrayList<TimeSlot> unavailableSlots; // times when the instructor cannot teach
    private String preferredTime;                 // MORNING, AFTERNOON or NONE

    // Creates a new instructor. At the start, the instructor has no courses,
    // is free at all times and has no time preference.
    public Instructor(String id, String name) {
        this.id = id;
        this.name = name;
        this.courseCodes = new ArrayList<String>();
        this.unavailableSlots = new ArrayList<TimeSlot>();
        this.preferredTime = NO_PREFERENCE;
    }

    // ---------- Getters and setters ----------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getCourseCodes() {
        return courseCodes;
    }

    public ArrayList<TimeSlot> getUnavailableSlots() {
        return unavailableSlots;
    }

    public String getPreferredTime() {
        return preferredTime;
    }

    public void setPreferredTime(String preferredTime) {
        this.preferredTime = preferredTime;
    }

    // ---------- Helper methods ----------

    // Adds the code of a course that this instructor teaches.
    public void addCourseCode(String courseCode) {
        courseCodes.add(courseCode);
    }

    // Adds a time when the instructor cannot teach.
    public void addUnavailableSlot(TimeSlot slot) {
        unavailableSlots.add(slot);
    }

    // Returns true if the instructor can teach during the whole time slot (rule HC-07).
    // It only checks the instructor's own busy times, not other sessions.
    public boolean isAvailable(TimeSlot slot) {
        for (int i = 0; i < unavailableSlots.size(); i++) {
            if (unavailableSlots.get(i).overlaps(slot)) {
                return false;
            }
        }
        return true;
    }

    // Returns true if the time slot matches the instructor's preferred time (rule SC-02).
    // MORNING   = the session ends at 12:00 or earlier.
    // AFTERNOON = the session starts at 13:00 or later.
    // NONE      = every time is fine.
    public boolean prefers(TimeSlot slot) {
        if (preferredTime.equals(MORNING)) {
            return slot.getEndHour() <= 12;
        }
        if (preferredTime.equals(AFTERNOON)) {
            return slot.getStartHour() >= 13;
        }
        return true;
    }

    // Returns the instructor as text. Example: "I01 - Dr. Kaya".
    @Override
    public String toString() {
        return id + " - " + name;
    }
}
