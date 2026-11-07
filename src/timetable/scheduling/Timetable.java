package timetable.scheduling;

import java.util.ArrayList;

import timetable.model.Course;
import timetable.model.Session;

/**
 * Timetable keeps ALL sessions of the department in one list.
 * Every session knows its own result (time, room, status, problem),
 * so the Timetable only has to keep the list and answer simple questions like:
 *   - Which sessions are placed?
 *   - Which sessions are not placed?
 *   - Which session is in this year group at this day and hour?
 *
 * Status: only the structure (the list, the constructor and the method declarations).
 * The methods are planned for code-v3.
 */
public class Timetable {

    private ArrayList<Session> sessions;   // all sessions (placed and not placed)

    // Creates an empty timetable.
    public Timetable() {
        this.sessions = new ArrayList<Session>();
    }

    // ---------- Making the sessions ----------

    // Makes the sessions from the courses. The old sessions are removed first.
    // A course with theory hours gives a THEORY session (-T).
    // A course with lab hours gives a LAB session (-L).
    public void createSessions(ArrayList<Course> courses) {
        // Planned for code-v3: this method is not implemented yet.
    }

    // ---------- Getting sessions ----------

    // Returns all sessions.
    public ArrayList<Session> getSessions() {
        return sessions;
    }

    // Returns only the sessions that have a time and a room.
    public ArrayList<Session> getScheduledSessions() {
        // Planned for code-v3: this method is not implemented yet.
        return new ArrayList<Session>();
    }

    // Returns only the sessions that do NOT have a time and a room.
    public ArrayList<Session> getUnscheduledSessions() {
        // Planned for code-v3: this method is not implemented yet.
        return new ArrayList<Session>();
    }

    // Returns the sessions of one year group (placed and not placed).
    public ArrayList<Session> getSessionsOfYear(int year) {
        // Planned for code-v3: this method is not implemented yet.
        return new ArrayList<Session>();
    }

    // Finds a session by its name, for example "SENG101-L". Returns null if there is no such session.
    public Session findSession(String sessionId) {
        // Planned for code-v3: this method is not implemented yet.
        return null;
    }

    // Finds the other session of the same course: the lab of a theory session, or the theory of a lab session.
    // Returns null if the course has only one session.
    public Session findPartner(Session session) {
        // Planned for code-v3: this method is not implemented yet.
        return null;
    }

    // Returns the placed session of a year group that is running at this day and hour.
    // Example: findSessionAt(2, "Mon", 10) asks "What does year 2 have on Monday from 10:00 to 11:00?"
    // Returns null if year 2 has nothing at that time.
    // (Rule HC-03 says a year group has no overlapping sessions, so there is at most one.)
    public Session findSessionAt(int year, String day, int hour) {
        // Planned for code-v3: this method is not implemented yet.
        return null;
    }
}
