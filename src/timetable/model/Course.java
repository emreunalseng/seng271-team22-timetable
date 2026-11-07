package timetable.model;

/**
 * A Course is one subject in the curriculum.
 * Example: SENG101 "Introduction to Software Engineering", year 1,
 * 3 hours theory + 2 hours lab every week, 70 students, taught by Dr. Kaya.
 *
 * A course is NOT placed in the timetable directly.
 * Instead, we make one Session for its theory hours and one Session for its lab hours.
 */
public class Course {

    private String code;                  // course code, for example "SENG101"
    private String title;                 // course name, for example "Introduction to Software Engineering"
    private int yearGroup;                // year of the students: 1, 2, 3 or 4
    private Instructor instructor;        // the teacher of this course
    private int theoryHours;              // theory hours per week (0 if there is no theory)
    private int labHours;                 // lab hours per week (0 if there is no lab)
    private int studentCount;             // expected number of students
    private boolean labMayPrecedeTheory;  // true if the lab is allowed to come before the theory

    // Creates a new course.
    // By default the lab must come after the theory (rule SC-01),
    // so labMayPrecedeTheory starts as false.
    public Course(String code, String title, int yearGroup, Instructor instructor,
                  int theoryHours, int labHours, int studentCount) {
        this.code = code;
        this.title = title;
        this.yearGroup = yearGroup;
        this.instructor = instructor;
        this.theoryHours = theoryHours;
        this.labHours = labHours;
        this.studentCount = studentCount;
        this.labMayPrecedeTheory = false;
    }

    // ---------- Getters and setters ----------

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearGroup() {
        return yearGroup;
    }

    public void setYearGroup(int yearGroup) {
        this.yearGroup = yearGroup;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public int getTheoryHours() {
        return theoryHours;
    }

    public void setTheoryHours(int theoryHours) {
        this.theoryHours = theoryHours;
    }

    public int getLabHours() {
        return labHours;
    }

    public void setLabHours(int labHours) {
        this.labHours = labHours;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public boolean isLabMayPrecedeTheory() {
        return labMayPrecedeTheory;
    }

    public void setLabMayPrecedeTheory(boolean labMayPrecedeTheory) {
        this.labMayPrecedeTheory = labMayPrecedeTheory;
    }

    // ---------- Helper methods ----------

    // Returns true if the course has theory hours.
    public boolean hasTheory() {
        return theoryHours > 0;
    }

    // Returns true if the course has lab hours.
    public boolean hasLab() {
        return labHours > 0;
    }

    // Returns the course as text. Example: "SENG101 - Introduction to Software Engineering".
    @Override
    public String toString() {
        return code + " - " + title;
    }
}
