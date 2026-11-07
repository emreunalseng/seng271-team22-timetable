package timetable.ui;

import java.util.Scanner;

import timetable.io.DataLoader;
import timetable.io.TimetableExporter;
import timetable.model.Room;
import timetable.model.Session;
import timetable.model.TimeSlot;
import timetable.scheduling.ConstraintChecker;
import timetable.scheduling.Scheduler;
import timetable.scheduling.Timetable;

/**
 * ConsoleMenu shows the main menu and does what the user chooses.
 * Status: the menu itself works. It is shown again and again,
 * a wrong choice gives a clear message and option 0 closes the program.
 * The options 1 to 8 only show a message. They are planned for code-v2 to code-v6.
 */
public class ConsoleMenu {

    // The folder that contains our input files.
    private static final String DATA_FOLDER = "data";

    // The folder where we save the output files. It is created if it does not exist.
    private static final String OUTPUT_FOLDER = "output";

    private Scanner scanner;             // reads what the user types
    private DataLoader dataLoader;       // reads the files and keeps the loaded data
    private TimetableExporter exporter;  // makes the texts of the timetable and writes files
    private boolean inputEnded;          // true if the keyboard input has ended (no more lines)
    private boolean dataLoaded;          // true after option 1 worked
    private Scheduler scheduler;         // made by option 2 (null before option 2)
    private Timetable timetable;         // the result of option 2 (null before option 2)
    private ConstraintChecker checker;   // the rule checker of the scheduler (null before option 2)

    // Creates the menu. The Scanner reads from the keyboard (System.in).
    public ConsoleMenu() {
        this.scanner = new Scanner(System.in);
        this.dataLoader = new DataLoader(DATA_FOLDER);
        this.exporter = new TimetableExporter();
        this.inputEnded = false;
        this.dataLoaded = false;
        this.scheduler = null;
        this.timetable = null;
        this.checker = null;
    }

    // Runs the menu again and again until the user chooses 0.
    public void start() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readNumber("Select an option: ");

            // If there is no more input, we leave the program (like option 0).
            if (inputEnded) {
                System.out.println();
                choice = 0;
            }

            switch (choice) {
                case 1:
                    loadData();
                    break;
                case 2:
                    generateTimetable();
                    break;
                case 3:
                    viewYearTimetable();
                    break;
                case 4:
                    viewScheduledSessions();
                    break;
                case 5:
                    viewUnscheduledSessions();
                    break;
                case 6:
                    modifyAssignment();
                    break;
                case 7:
                    createClassroomRequest();
                    break;
                case 8:
                    saveTimetable();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please type a number from 0 to 8.");
                    break;
            }
        }

        scanner.close();
    }

    // ---------- Menu and input ----------

    // Prints the main menu.
    private void printMenu() {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("     DEPARTMENT COURSE TIMETABLE MANAGEMENT SYSTEM");
        System.out.println("                Software Engineering Department");
        System.out.println();
        System.out.println("==================================================");
        System.out.println(" 1. Load input data");
        System.out.println(" 2. Generate timetable automatically");
        System.out.println(" 3. View timetable by year group");
        System.out.println(" 4. View all scheduled sessions");
        System.out.println(" 5. View unscheduled sessions and warnings");
        System.out.println(" 6. Modify / remove an assignment");
        System.out.println(" 7. Generate classroom request email");
        System.out.println(" 8. Save timetable to file");
        System.out.println(" 0. Exit");
        System.out.println();
        System.out.println("--------------------------------------------------");
    }

    // Reads one line from the keyboard and removes the spaces at the start and the end.
    // If the keyboard input has ended (for example the user pressed Ctrl+Z), it returns ""
    // and remembers this in "inputEnded". So the program does not crash.
    private String readLine() {
        if (!scanner.hasNextLine()) {
            inputEnded = true;
            return "";
        }
        return scanner.nextLine().trim();
    }

    // Shows a question and reads a number. Returns -1 if the user did not type a number.
    private int readNumber(String question) {
        System.out.print(question);
        String text = readLine();

        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Shows a message for a menu option that does not work in this version.
    // Example: showNotImplemented("Load input data", "code-v2")
    private void showNotImplemented(String optionName, String plannedVersion) {
        System.out.println();
        System.out.println("\"" + optionName + "\" is not implemented yet.");
        System.out.println("This option is planned for " + plannedVersion + ".");
    }

    // ---------- Option 1 ----------

    // Option 1: reads the input files and shows what was loaded.
    private void loadData() {
        showNotImplemented("Load input data", "code-v2");
    }

    // ---------- Option 2 ----------

    // Option 2: runs the scheduler and shows the result of every session, the warnings and a summary.
    private void generateTimetable() {
        showNotImplemented("Generate timetable automatically", "code-v3");
    }

    // ---------- Option 3 ----------

    // Option 3: shows the weekly table of one year group.
    private void viewYearTimetable() {
        showNotImplemented("View timetable by year group", "code-v4");
    }

    // ---------- Option 4 ----------

    // Option 4: lists all sessions that have a time and a room.
    private void viewScheduledSessions() {
        showNotImplemented("View all scheduled sessions", "code-v4");
    }

    // ---------- Option 5 ----------

    // Option 5: lists all sessions that do NOT have a time and a room, and the soft-constraint warnings.
    private void viewUnscheduledSessions() {
        showNotImplemented("View unscheduled sessions and warnings", "code-v4");
    }

    // ---------- Option 6 ----------

    // Option 6: the user chooses a placed session and then moves it or removes it.
    private void modifyAssignment() {
        showNotImplemented("Modify / remove an assignment", "code-v5");
    }

    // Checks a change and applies it if it is allowed. Returns true if the change was applied.
    //
    // How it works:
    //   1. Remember the old time and room.
    //   2. Take the session out of the timetable for a moment, so it cannot clash with itself.
    //   3. Check the HARD rules. If one is broken: put the old time and room back and stop.
    //   4. Check the SOFT rules. If there are warnings: show them and ask the user.
    //   5. Apply the change, or put the old time and room back.
    private boolean tryChange(Session session, TimeSlot newSlot, Room newRoom) {
        // Planned for code-v5: this method is not implemented yet.
        return false;
    }

    // ---------- Option 7 ----------

    // Option 7: makes an e-mail draft for a session that has NO ROOM.
    private void createClassroomRequest() {
        showNotImplemented("Generate classroom request email", "code-v6");
    }

    // ---------- Option 8 ----------

    // Option 8: saves the whole timetable in one text file.
    private void saveTimetable() {
        showNotImplemented("Save timetable to file", "code-v6");
    }
}
