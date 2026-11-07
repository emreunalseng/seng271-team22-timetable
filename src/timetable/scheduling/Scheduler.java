package timetable.scheduling;

import java.util.ArrayList;

import timetable.model.Course;
import timetable.model.Room;
import timetable.model.Session;
import timetable.model.SpecialRequest;
import timetable.model.TimeSlot;

/**
 * Scheduler builds the timetable with a simple "greedy" algorithm.
 * Greedy means: for every session we choose ONE place and never move it again.
 *
 * The steps:
 *   1. Make the sessions from the courses.
 *   2. FIRST process the sessions with a MANDATORY fixed time (only that time is tried).
 *   3. THEN process all other sessions:
 *        a) If the session has a PREFERRED time, try that time first.
 *        b) Otherwise look at EVERY day, start hour and room (in this order).
 *           Only places that pass all HARD rules are possible.
 *           Among them we take the one with the FEWEST soft-rule warnings.
 *           If two places have the same number of warnings, the first one wins.
 *   4. If nothing works, the session stays unscheduled with the label
 *        NO ROOM     (a valid time exists, but no suitable room), or
 *        CONSTRAINT  (no valid time because of the hard rules).
 *
 * This simple algorithm does not always find the best timetable.
 * A session can fail even if a better timetable exists (we never move placed sessions).
 *
 * Status: only the structure. The algorithm is planned for code-v3 (first version),
 * code-v4 (working core) and code-v5 (fixed times first, fewest warnings).
 */
public class Scheduler {

    private ArrayList<Course> courses;
    private ArrayList<Room> rooms;
    private ArrayList<SpecialRequest> requests;
    private Timetable timetable;
    private ConstraintChecker checker;

    // Creates a scheduler. It makes its own Timetable and ConstraintChecker.
    public Scheduler(ArrayList<Course> courses, ArrayList<Room> rooms, ArrayList<SpecialRequest> requests) {
        this.courses = courses;
        this.rooms = rooms;
        this.requests = requests;
        this.timetable = new Timetable();
        this.checker = new ConstraintChecker(timetable, requests);
    }

    // Returns the timetable (with all the results).
    public Timetable getTimetable() {
        return timetable;
    }

    // Returns the checker. The menu uses it to check manual changes and to read the warnings.
    public ConstraintChecker getChecker() {
        return checker;
    }

    // ---------- The algorithm ----------

    // Makes the timetable. You can call it again to start from the beginning.
    public void generate() {
        // Planned for code-v3: this method is not implemented yet.
    }

    // Places a session that has a MANDATORY fixed time. Only this one time is tried.
    private void placeFixedSession(Session session) {
        // Planned for code-v5: this method is not implemented yet.
    }

    // Places a normal session. We look at the days, the hours and (inside findBestRoom) the rooms.
    private void placeNormalSession(Session session) {
        // Planned for code-v3: this method is not implemented yet.
    }

    // Loop 3: the rooms. Returns the room that passes all room rules and has the fewest warnings
    // (so the PREFERRED room of the session wins). If two rooms are equal, the first one wins.
    // Returns null if no room passes the room rules.
    private Room findBestRoom(Session session, TimeSlot slot) {
        // Planned for code-v3: this method is not implemented yet.
        return null;
    }

    // ---------- Helper for the classroom request (option 7) ----------

    // Finds the first time where the instructor and the year group are both free
    // (all TIME rules pass). Returns null if there is no such time.
    public TimeSlot findFreeTimeSlot(Session session) {
        // Planned for code-v6: this method is not implemented yet.
        return null;
    }

    // ---------- Reasons for NO ROOM ----------

    // Marks a session as NO ROOM and writes the best reason we can find.
    private void markNoRoom(Session session) {
        // Planned for code-v4: this method is not implemented yet.
    }
}
