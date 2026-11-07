package timetable.model;

/**
 * A SpecialRequest is an extra rule from the file constraints.txt.
 * Example: "SENG301-T must be on Wednesday 13:00-16:00" (MANDATORY, FIXED_TIME).
 *
 * MANDATORY requests are hard rules: they must never be broken.
 * PREFERRED requests are soft rules: we try them first, and show a warning if we cannot.
 *
 * What "target" means depends on the request type:
 *   FIXED_TIME             -> a session,   for example "SENG301-T"   (uses timeSlot)
 *   REQUIRED_ROOM          -> a session,   for example "SENG401-L"   (uses roomId)
 *   INSTRUCTOR_UNAVAILABLE -> a course,    for example "SENG201"     (uses timeSlot)
 *   LAB_BEFORE_THEORY      -> a course,    for example "SENG302"     (no extra value)
 *   BLOCKED_TIME           -> a year group, for example "3"          (uses timeSlot)
 */
public class SpecialRequest {

    // The two priorities.
    public static final String MANDATORY = "MANDATORY";
    public static final String PREFERRED = "PREFERRED";

    // The five request types we support.
    public static final String FIXED_TIME = "FIXED_TIME";                         // rule HC-08
    public static final String REQUIRED_ROOM = "REQUIRED_ROOM";                   // rule HC-11
    public static final String INSTRUCTOR_UNAVAILABLE = "INSTRUCTOR_UNAVAILABLE"; // rule HC-07
    public static final String LAB_BEFORE_THEORY = "LAB_BEFORE_THEORY";           // turns off SC-01
    public static final String BLOCKED_TIME = "BLOCKED_TIME";                     // rule HC-10

    private String priority;   // MANDATORY or PREFERRED
    private String type;       // one of the five types above
    private String target;     // the session, course or year group the request is about
    private TimeSlot timeSlot; // the time of the request (null if not needed)
    private String roomId;     // the room of the request (null if not needed)
    private String note;       // a short note from the coordinator (can be empty)

    // Creates a new special request. The time, room and note can be set later.
    public SpecialRequest(String priority, String type, String target) {
        this.priority = priority;
        this.type = type;
        this.target = target;
        this.timeSlot = null;
        this.roomId = null;
        this.note = "";
    }

    // ---------- Getters and setters ----------

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // ---------- Helper methods ----------

    // Returns true if this request is a hard rule.
    public boolean isMandatory() {
        return priority.equals(MANDATORY);
    }

    // Returns the request as text.
    // Example: "MANDATORY FIXED_TIME SENG301-T Wed 13:00-16:00"
    @Override
    public String toString() {
        String text = priority + " " + type + " " + target;
        if (timeSlot != null) {
            text = text + " " + timeSlot;
        }
        if (roomId != null) {
            text = text + " " + roomId;
        }
        return text;
    }
}
