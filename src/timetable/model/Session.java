package timetable.model;

/**
 * A Session is one teaching block of a course that we place in the timetable.
 * Every course gives us up to two sessions:
 *   - a THEORY session ("-T"), for example SENG101-T (3 hours, in a classroom)
 *   - a LAB session    ("-L"), for example SENG101-L (2 hours, in a laboratory)
 * All hours of one session are on the same day, one after another.
 *
 * A session also remembers its result:
 *   - if it is placed: its time slot and its room,
 *   - if it is not placed: its status, the broken rule and the reason.
 */
public class Session {

    // The two session types.
    public static final String THEORY = "T";
    public static final String LAB = "L";

    // The possible status values of a session.
    public static final String NOT_SCHEDULED = "NOT SCHEDULED"; // not tried yet
    public static final String SCHEDULED = "SCHEDULED";         // placed with a time and a room
    public static final String NO_ROOM = "NO ROOM";             // a time was free, but no suitable room
    public static final String CONSTRAINT = "CONSTRAINT";       // blocked by other hard rules
    public static final String REMOVED = "REMOVED";             // removed by the coordinator

    private Course course;        // the course this session belongs to
    private String type;          // THEORY ("T") or LAB ("L")
    private TimeSlot timeSlot;    // the given day and hours (null if not scheduled)
    private Room room;            // the given room (null if not scheduled)
    private String status;        // one of the status values above
    private String problemCode;   // the broken rule, for example "HC-05" (empty if no problem)
    private String reason;        // a short explanation of the problem (empty if no problem)

    // Creates a new session. At the start, it has no time and no room.
    public Session(Course course, String type) {
        this.course = course;
        this.type = type;
        this.timeSlot = null;
        this.room = null;
        this.status = NOT_SCHEDULED;
        this.problemCode = "";
        this.reason = "";
    }

    // ---------- Getters ----------
    // Note: there are no setters for timeSlot, room and status.
    // We change them only with assign(), markUnscheduled() and remove(),
    // so these fields always stay correct together.

    public Course getCourse() {
        return course;
    }

    public String getType() {
        return type;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Room getRoom() {
        return room;
    }

    public String getStatus() {
        return status;
    }

    public String getProblemCode() {
        return problemCode;
    }

    public String getReason() {
        return reason;
    }

    // ---------- Helper methods ----------

    // Returns the name of the session. Example: "SENG101-T".
    public String getId() {
        return course.getCode() + "-" + type;
    }

    // Returns true if this is a theory session.
    public boolean isTheory() {
        return type.equals(THEORY);
    }

    // Returns true if this is a lab session.
    public boolean isLab() {
        return type.equals(LAB);
    }

    // Returns how many hours long this session is.
    // A theory session uses the theory hours, a lab session uses the lab hours.
    public int getHours() {
        if (isTheory()) {
            return course.getTheoryHours();
        }
        return course.getLabHours();
    }

    // Returns the room type this session needs (rule HC-06).
    // Theory needs a CLASSROOM, lab needs a LABORATORY.
    public String getRequiredRoomType() {
        if (isTheory()) {
            return Room.CLASSROOM;
        }
        return Room.LABORATORY;
    }

    // The next three methods only ask the course, so other classes can write
    // session.getYearGroup() instead of session.getCourse().getYearGroup().

    public int getYearGroup() {
        return course.getYearGroup();
    }

    public int getStudentCount() {
        return course.getStudentCount();
    }

    public Instructor getInstructor() {
        return course.getInstructor();
    }

    // Returns true if the session has a time and a room.
    public boolean isScheduled() {
        return status.equals(SCHEDULED);
    }

    // Places the session at a time and in a room.
    // The rules must be checked BEFORE calling this method (by the ConstraintChecker).
    public void assign(TimeSlot newTimeSlot, Room newRoom) {
        this.timeSlot = newTimeSlot;
        this.room = newRoom;
        this.status = SCHEDULED;
        this.problemCode = "";
        this.reason = "";
    }

    // Marks the session as not placed and saves why.
    // Example: markUnscheduled(Session.NO_ROOM, "HC-05", "No laboratory with capacity >= 70")
    public void markUnscheduled(String newStatus, String newProblemCode, String newReason) {
        this.timeSlot = null;
        this.room = null;
        this.status = newStatus;
        this.problemCode = newProblemCode;
        this.reason = newReason;
    }

    // Removes the session from the timetable because the coordinator asked for it.
    public void remove() {
        markUnscheduled(REMOVED, "", "Removed by the coordinator");
    }

    // Returns the session as text.
    // Example (placed):     "SENG101-T Mon 09:00-12:00 A101"
    // Example (not placed): "SENG101-L [NO ROOM] HC-05: No laboratory with capacity >= 70"
    @Override
    public String toString() {
        if (isScheduled()) {
            return getId() + " " + timeSlot + " " + room.getId();
        }
        String text = getId() + " [" + status + "]";
        if (!problemCode.equals("")) {
            text = text + " " + problemCode + ":";
        }
        if (!reason.equals("")) {
            text = text + " " + reason;
        }
        return text;
    }
}
