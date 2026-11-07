package timetable.io;

import java.util.ArrayList;

import timetable.scheduling.Timetable;

/**
 * TimetableExporter makes the texts of the timetable (the weekly table and the lists)
 * and writes texts to files.
 *
 * The menu prints the same texts on the screen. So the screen and the file always look the same.
 * The "make..." methods return a text. They do not print anything.
 *
 * Status: only the structure. The texts are planned for code-v4 (the warning list
 * for code-v5) and the saving of files for code-v6.
 */
public class TimetableExporter {

    // The name of the summary file (option 8).
    public static final String SUMMARY_FILE_NAME = "timetable_summary.txt";

    // ---------- Making the texts ----------

    // Makes the weekly table of one year group, with the session details under it.
    public String makeYearText(Timetable timetable, int year) {
        // Planned for code-v4: this method is not implemented yet.
        return "";
    }

    // Makes the list of all placed sessions.
    public String makeScheduledList(Timetable timetable) {
        // Planned for code-v4: this method is not implemented yet.
        return "";
    }

    // Makes the list of all sessions that are not placed, with the problem type and the reason.
    public String makeUnscheduledList(Timetable timetable) {
        // Planned for code-v4: this method is not implemented yet.
        return "";
    }

    // Makes the list of the soft-constraint warnings.
    public String makeWarningList(ArrayList<String> warnings) {
        // Planned for code-v5: this method is not implemented yet.
        return "";
    }

    // ---------- Writing files ----------

    // Saves the whole timetable in ONE text file: the weekly tables of the four year groups,
    // the list of scheduled sessions, the list of unscheduled sessions and the warnings.
    // Returns true if the file was saved.
    public boolean saveSummary(Timetable timetable, ArrayList<String> warnings, String folder) {
        // Planned for code-v6: this method is not implemented yet.
        return false;
    }

    // Writes a text into a file. The folder is created if it does not exist.
    // Returns true if the file was saved, and false if there was a problem (the program does not crash).
    public boolean writeTextFile(String folder, String fileName, String text) {
        // Planned for code-v6: this method is not implemented yet.
        return false;
    }
}
