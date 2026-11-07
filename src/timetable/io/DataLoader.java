package timetable.io;

import java.util.ArrayList;

import timetable.model.Course;
import timetable.model.Instructor;
import timetable.model.Room;
import timetable.model.SpecialRequest;

/**
 * DataLoader reads the four input files and makes the objects of our program.
 *
 *   instructors.txt -> Instructor objects
 *   rooms.csv       -> Room objects
 *   courses.csv     -> Course objects
 *   constraints.txt -> SpecialRequest objects
 *
 * The loaded objects are kept inside the DataLoader, in simple ArrayLists.
 * If a line has bad data, we do NOT stop the program.
 * We skip that line and save a warning message in the "warnings" list.
 *
 * Status: only the structure (fields, constructor, getters and method declarations).
 * The reading and checking of the four files is planned for code-v2.
 */
public class DataLoader {

    private String dataFolder;                   // the folder with the files, for example "data"
    private ArrayList<Course> courses;           // all loaded courses
    private ArrayList<Instructor> instructors;   // all loaded instructors
    private ArrayList<Room> rooms;               // all loaded rooms
    private ArrayList<SpecialRequest> requests;  // all loaded special requests
    private ArrayList<String> warnings;          // all warning and error messages

    // Creates a new DataLoader. All lists are empty at the start.
    public DataLoader(String dataFolder) {
        this.dataFolder = dataFolder;
        this.courses = new ArrayList<Course>();
        this.instructors = new ArrayList<Instructor>();
        this.rooms = new ArrayList<Room>();
        this.requests = new ArrayList<SpecialRequest>();
        this.warnings = new ArrayList<String>();
    }

    // ---------- Getters ----------

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<SpecialRequest> getRequests() {
        return requests;
    }

    public ArrayList<String> getWarnings() {
        return warnings;
    }

    // ---------- Main method ----------

    // Reads all files. Returns true if the data was loaded.
    // Returns false if a required file is missing. In this case, the old data is kept.
    // The order is important: a course needs its instructor, and a request needs
    // its course and its room. So we load instructors and rooms first.
    public boolean loadAll() {
        // Planned for code-v2: this method is not implemented yet.
        return false;
    }

    // ---------- Reading the files ----------

    // Reads instructors.txt. Line format: id,name,courses,unavailable,preferred
    // Example: I01,Dr. Kaya,SENG101;SENG203,Mon 09:00-12:00,MORNING
    public void loadInstructors() {
        // Planned for code-v2: this method is not implemented yet.
    }

    // Reads rooms.csv. Line format: roomCode,type,capacity,unavailable
    // Example: B202,LABORATORY,50,Fri 09:00-17:00
    public void loadRooms() {
        // Planned for code-v2: this method is not implemented yet.
    }

    // Reads courses.csv. Line format: code,title,year,instructor,theoryHours,labHours,students
    // Example: SENG101,Introduction to Software Engineering,1,Dr. Kaya,3,2,70
    // The instructor can be written as a name ("Dr. Kaya") or as an id ("I01").
    public void loadCourses() {
        // Planned for code-v2: this method is not implemented yet.
    }

    // Reads constraints.txt. Line format: PRIORITY | TYPE | TARGET | VALUE | NOTE
    // Example: MANDATORY | FIXED_TIME | SENG301-T | Wed 13:00-16:00 | Wednesday afternoon
    // This file is optional. If it is missing, we only show a warning.
    public void loadRequests() {
        // Planned for code-v2: this method is not implemented yet.
    }

    // ---------- Finding objects ----------

    // Finds an instructor by id or by name. Returns null if there is no such instructor.
    public Instructor findInstructor(String idOrName) {
        // Planned for code-v2: this method is not implemented yet.
        return null;
    }

    // Finds a course by its code. Returns null if there is no such course.
    public Course findCourse(String code) {
        // Planned for code-v2: this method is not implemented yet.
        return null;
    }

    // Finds a room by its code. Returns null if there is no such room.
    public Room findRoom(String roomId) {
        // Planned for code-v2: this method is not implemented yet.
        return null;
    }
}
