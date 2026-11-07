package timetable.model;

import java.util.ArrayList;

/**
 * A Room is one classroom or one laboratory in the department.
 * Example: room "A101" is a CLASSROOM with 80 seats.
 */
public class Room {

    // The two room types we use.
    public static final String CLASSROOM = "CLASSROOM";   // for theory lessons
    public static final String LABORATORY = "LABORATORY"; // for lab lessons

    private String id;                           // room code, for example "A101"
    private String type;                         // CLASSROOM or LABORATORY
    private int capacity;                        // how many students can sit in the room
    private ArrayList<TimeSlot> unavailableSlots; // times when the room cannot be used

    // Creates a new room. At the start, the room is free at all times.
    public Room(String id, String type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.unavailableSlots = new ArrayList<TimeSlot>();
    }

    // ---------- Getters and setters ----------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<TimeSlot> getUnavailableSlots() {
        return unavailableSlots;
    }

    // ---------- Helper methods ----------

    // Adds a time when the room cannot be used (for example, a repair on Friday).
    public void addUnavailableSlot(TimeSlot slot) {
        unavailableSlots.add(slot);
    }

    // Returns true if the room is free for the whole time slot (rule HC-09).
    // It only checks the room's own closed times, not other sessions.
    public boolean isAvailable(TimeSlot slot) {
        for (int i = 0; i < unavailableSlots.size(); i++) {
            if (unavailableSlots.get(i).overlaps(slot)) {
                return false;
            }
        }
        return true;
    }

    // Returns true if the room has enough seats for the students (rule HC-05).
    public boolean canHold(int numberOfStudents) {
        return capacity >= numberOfStudents;
    }

    // Returns true if this room is a laboratory.
    public boolean isLaboratory() {
        return type.equals(LABORATORY);
    }

    // Returns the room as text. Example: "A101 (CLASSROOM, 80 seats)".
    @Override
    public String toString() {
        return id + " (" + type + ", " + capacity + " seats)";
    }
}
