package timetable.scheduling;

import java.util.ArrayList;

import timetable.model.Room;
import timetable.model.Session;
import timetable.model.SpecialRequest;
import timetable.model.TimeSlot;

/**
 * ConstraintChecker checks the 11 hard constraints (HC-01 ... HC-11).
 *
 * How it works:
 *  - Every rule has its own small method, for example checkInstructorConflict().
 *  - A check method returns TRUE if the rule is OK (no problem).
 *  - A check method returns FALSE if the rule is broken.
 *    In this case it also saves the rule code (for example "HC-01") and a short
 *    reason. We can read them with getProblemCode() and getProblemReason().
 *
 * We split the rules in two groups:
 *  - TIME rules (about the day and hour): HC-04, HC-08, HC-01, HC-03, HC-07, HC-10
 *  - ROOM rules (about the room):         HC-11, HC-06, HC-05, HC-09, HC-02
 * checkTimeRules() and checkRoomRules() run a whole group.
 *
 * The same checker can be used for the automatic scheduling and for a manual change.
 *
 * Status: only the structure: every rule has its method declaration.
 * The checks are planned for code-v3 (HC-01 to HC-04), code-v4 (HC-05, HC-06)
 * and code-v5 (HC-07 to HC-11 and the soft rules).
 */
public class ConstraintChecker {

    private Timetable timetable;                 // all sessions (to look for conflicts)
    private ArrayList<SpecialRequest> requests;  // all special requests
    private String problemCode;                  // the code of the last broken rule
    private String problemReason;                // the reason of the last broken rule

    // Creates a checker.
    public ConstraintChecker(Timetable timetable, ArrayList<SpecialRequest> requests) {
        this.timetable = timetable;
        this.requests = requests;
        this.problemCode = "";
        this.problemReason = "";
    }

    // ---------- Reading the last problem ----------

    // Returns the code of the last broken rule. Example: "HC-01".
    public String getProblemCode() {
        return problemCode;
    }

    // Returns the reason of the last broken rule.
    public String getProblemReason() {
        return problemReason;
    }

    // ---------- Groups of rules ----------

    // Checks all TIME rules for a session at a time. Returns true if all are OK.
    public boolean checkTimeRules(Session session, TimeSlot slot) {
        // Planned for code-v3: the rules are not checked yet, so the answer is always "no problem".
        return true;
    }

    // Checks all ROOM rules for a session in a room at a time. Returns true if all are OK.
    public boolean checkRoomRules(Session session, TimeSlot slot, Room room) {
        // Planned for code-v3: the rules are not checked yet, so the answer is always "no problem".
        return true;
    }

    // ---------- The 11 hard constraints ----------

    // HC-01: An instructor cannot teach two sessions at the same time.
    public boolean checkInstructorConflict(Session session, TimeSlot slot) {
        // Planned for code-v3: this rule is not checked yet, so the answer is always "no problem".
        return true;
    }

    // HC-02: A room cannot be used by two sessions at the same time.
    public boolean checkRoomConflict(Session session, TimeSlot slot, Room room) {
        // Planned for code-v3: this rule is not checked yet, so the answer is always "no problem".
        return true;
    }

    // HC-03: Sessions of the same year group cannot overlap.
    public boolean checkYearGroupConflict(Session session, TimeSlot slot) {
        // Planned for code-v3: this rule is not checked yet, so the answer is always "no problem".
        return true;
    }

    // HC-04: Sessions must be between 09:00 and 17:00, Monday to Friday.
    public boolean checkWorkingHours(TimeSlot slot) {
        // Planned for code-v3: this rule is not checked yet, so the answer is always "no problem".
        return true;
    }

    // HC-05: The room must have enough seats for the students.
    public boolean checkRoomCapacity(Session session, Room room) {
        // Planned for code-v4: this rule is not checked yet, so the answer is always "no problem".
        return true;
    }

    // HC-06: The room type must match the session (theory = classroom, lab = laboratory).
    public boolean checkRoomType(Session session, Room room) {
        // Planned for code-v4: this rule is not checked yet, so the answer is always "no problem".
        return true;
    }

    // HC-07: The instructor must be available. This includes the MANDATORY
    // INSTRUCTOR_UNAVAILABLE special requests of the course.
    public boolean checkInstructorAvailability(Session session, TimeSlot slot) {
        // Planned for code-v5: this rule is not checked yet, so the answer is always "no problem".
        return true;
    }

    // HC-08: A session with a MANDATORY fixed time must be at exactly that time.
    public boolean checkFixedTime(Session session, TimeSlot slot) {
        // Planned for code-v5: this rule is not checked yet, so the answer is always "no problem".
        return true;
    }

    // HC-09: A room cannot be used when it is not available (closed).
    public boolean checkRoomAvailability(Room room, TimeSlot slot) {
        // Planned for code-v5: this rule is not checked yet, so the answer is always "no problem".
        return true;
    }

    // HC-10: A year group cannot have a session in a time that is blocked by a MANDATORY request.
    public boolean checkBlockedTime(Session session, TimeSlot slot) {
        // Planned for code-v5: this rule is not checked yet, so the answer is always "no problem".
        return true;
    }

    // HC-11: A session with a MANDATORY room request can only use that room.
    public boolean checkRequiredRoom(Session session, Room room) {
        // Planned for code-v5: this rule is not checked yet, so the answer is always "no problem".
        return true;
    }

    // ---------- Soft constraints (warnings) ----------
    //
    // A soft rule is only a wish. If it is broken, the session is still placed,
    // but the user sees a WARNING.
    // The soft check methods return an EMPTY text ("") if everything is fine,
    // or a warning text that starts with the rule code (for example "SC-02: ...").

    // Checks all soft rules for a session at a time and in a room.
    // Returns a list of warning texts. An empty list means: no warnings.
    public ArrayList<String> checkSoftRules(Session session, TimeSlot slot, Room room) {
        // Planned for code-v5: this method is not implemented yet.
        return new ArrayList<String>();
    }

    // Finds all warnings of the whole timetable (for all placed sessions).
    public ArrayList<String> findAllWarnings() {
        // Planned for code-v5: this method is not implemented yet.
        return new ArrayList<String>();
    }

    // SC-01: The theory session should be before the lab session of the same course.
    // A LAB_BEFORE_THEORY request switches this rule off for the course.
    public String checkTheoryBeforeLab(Session session, TimeSlot slot) {
        // Planned for code-v5: this method is not implemented yet.
        return "";
    }

    // SC-02: The session should be at a time that the instructor prefers.
    public String checkInstructorPreference(Session session, TimeSlot slot) {
        // Planned for code-v5: this method is not implemented yet.
        return "";
    }

    // SC-03: A year group should not have a big idle gap between two sessions on the same day.
    // We look at the session in its new place together with the other sessions of the same year and day.
    public String checkGaps(Session session, TimeSlot slot) {
        // Planned for code-v5: this method is not implemented yet.
        return "";
    }

    // SC-05 (time): PREFERRED requests about time.
    //   FIXED_TIME             -> the session should be exactly at that time
    //   INSTRUCTOR_UNAVAILABLE -> the instructor should not teach at that time
    //   BLOCKED_TIME           -> the year group should have no session at that time
    public String checkPreferredTime(Session session, TimeSlot slot) {
        // Planned for code-v5: this method is not implemented yet.
        return "";
    }

    // SC-05 (room): a PREFERRED REQUIRED_ROOM request. The session should use that room.
    public String checkPreferredRoom(Session session, Room room) {
        // Planned for code-v5: this method is not implemented yet.
        return "";
    }

    // ---------- Looking for special requests ----------

    // Returns the MANDATORY FIXED_TIME request of a session. Returns null if there is none.
    public SpecialRequest findFixedTimeRequest(Session session) {
        // Planned for code-v5: this method is not implemented yet.
        return null;
    }

    // Returns the PREFERRED FIXED_TIME request of a session. Returns null if there is none.
    public SpecialRequest findPreferredTimeRequest(Session session) {
        // Planned for code-v5: this method is not implemented yet.
        return null;
    }

    // Returns the room code of the PREFERRED REQUIRED_ROOM request of a session.
    // Returns null if there is none.
    public String getPreferredRoomId(Session session) {
        // Planned for code-v5: this method is not implemented yet.
        return null;
    }

    // Returns the room code of the MANDATORY REQUIRED_ROOM request of a session.
    // Returns null if there is none.
    public String getRequiredRoomId(Session session) {
        // Planned for code-v5: this method is not implemented yet.
        return null;
    }
}
