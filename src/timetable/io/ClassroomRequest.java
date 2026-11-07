package timetable.io;

import timetable.model.Session;
import timetable.model.TimeSlot;

/**
 * ClassroomRequest makes the e-mail draft that the coordinator can send to the
 * Student Affairs Office when a session has NO ROOM.
 * The program NEVER sends the e-mail. It only makes the text (and the menu can save it in a file).
 *
 * Status: only the structure. The e-mail text is planned for code-v6.
 */
public class ClassroomRequest {

    private Session session;          // the session that has no room
    private TimeSlot suggestedSlot;   // the time we suggest (null if no free time was found)

    // Creates a request for one session.
    public ClassroomRequest(Session session, TimeSlot suggestedSlot) {
        this.session = session;
        this.suggestedSlot = suggestedSlot;
    }

    // Returns the name of the room type of a session in simple words: "Laboratory" or "Classroom".
    public static String getRoomTypeName(Session session) {
        // Planned for code-v6: this method is not implemented yet.
        return "";
    }

    // Returns the file name for this e-mail. Example: "classroom_request_SENG201.txt".
    public String getFileName() {
        // Planned for code-v6: this method is not implemented yet.
        return "";
    }

    // Makes the text of the e-mail.
    public String getEmailText() {
        // Planned for code-v6: this method is not implemented yet.
        return "";
    }
}
