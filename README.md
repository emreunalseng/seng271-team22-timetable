# Department Course Timetable Management System

A Java console application that builds the weekly course timetable of the Software Engineering Department from input files, checks the scheduling constraints and reports the sessions it cannot place. The program is developed in steps: the current code version is **Code v1** (project skeleton and main menu).

## Team
| Name | GitHub |
| --- | --- |
| Arda AYDIN | [@the-forward](https://github.com/the-forward) |
| Emre ÜNAL | [@emreunalseng](https://github.com/emreunalseng) |

## Requirements
- Java 25 or later
- External libraries: none

## How to Compile and Run
From the repository root:

    javac -d out src/timetable/model/*.java src/timetable/io/*.java src/timetable/scheduling/*.java src/timetable/ui/*.java
    java -cp out timetable.ui.Main

The code is in four packages (`model`, `io`, `scheduling`, `ui`), so the main class is `timetable.ui.Main`. The commands work in PowerShell, cmd and bash. Start the program from the repository root, because it reads the folder `data/` from there.

### With IntelliJ IDEA
The shared settings in `.idea/` and `DepartmentTimetableSysyem.iml` are in Git: `src` is the Sources Root, the project uses JDK 25, and the run configuration **Main** starts `timetable.ui.Main` in the project folder.

1. Clone the repository: **File > New > Project from Version Control**, URL `https://github.com/emreunalseng/seng271-team22-timetable.git`.
2. If IntelliJ shows "Project JDK is not defined", click **Setup SDK** and choose your JDK 25.
3. Choose **Main** in the run list at the top right and click **Run**. The menu appears in the Run window.

| Problem | Solution |
| --- | --- |
| "Project JDK is not defined" | Click **Setup SDK** and choose JDK 25 (or **File > Project Structure > Project > SDK**). |
| "release version 25 not supported" | Your JDK is older than 25. Install JDK 25 and choose it as the project SDK. |
| **Main** is not in the run list | Open the project **folder** (not a single file). Then try **File > Reload All from Disk**. |

## Input Files
| File | Format | Content |
| --- | --- | --- |
| data/courses.csv | CSV | Courses and curriculum |
| data/instructors.txt | TXT | Instructor availability |
| data/rooms.csv | CSV | Rooms and laboratories |
| data/constraints.txt | TXT | Special scheduling requests |

The file formats are described in Section 5 of the SRS. The files are read from Code v2 on.

## Using the Application
| Menu option | What it does | Code version |
| --- | --- | --- |
| 1 | Load input data | planned for code-v2 |
| 2 | Generate timetable automatically | planned for code-v3 |
| 3 | View timetable by year group | planned for code-v4 |
| 4 | View all scheduled sessions | planned for code-v4 |
| 5 | View unscheduled sessions and warnings | planned for code-v4 |
| 6 | Modify / remove an assignment | planned for code-v5 |
| 7 | Generate classroom request email | planned for code-v6 |
| 8 | Save timetable to file | planned for code-v6 |
| 0 | Exit | works in code-v1 |

In Code v1 the menu itself works: it is shown again after every choice, a wrong choice gives the message `Invalid choice. Please type a number from 0 to 8.` and `0` closes the program. An option that is not implemented yet shows two lines, for example:

    "Load input data" is not implemented yet.
    This option is planned for code-v2.

## Outputs
Generated files will be saved in output/: the timetable summary and the classroom request e-mail drafts (planned for code-v6). Code v1 writes no files.

## Repository Structure
    docs/requirements/   SRS versions
    docs/design/         SDD versions, diagram pictures and diagram source files (draw.io)
    docs/testing/        Test results
    docs/checkpoints/    Checkpoint reports
    docs/team-agreement.md   Team agreement
    data/                Input files
    src/                 Java source code (src/timetable/model, io, scheduling, ui)
    output/              Generated timetables and emails
    .idea/, *.iml        Shared IntelliJ IDEA settings (personal settings are not in Git)

## Versions
| Version | Tag | Date | Summary |
| --- | --- | --- | --- |
| Code v1 | code-v1 | 10.11.2026 | Project skeleton and main menu |
| Code v2 | code-v2 | planned (Week 8) | Input file processing and object management |
| Code v3 | code-v3 | planned (Week 9) | Initial automatic scheduling algorithm and conflict detection |
| Code v4 | code-v4 | planned (Week 10) | Working core scheduling functionality (Checkpoint 2) |
| Code v5 | code-v5 | planned (Week 11) | Additional constraints, special requests, timetable modification |
| Code v6 | code-v6 | planned (Week 12) | Output, classroom requests, manual testing |
| Final | final | planned (Week 13) | Final release (Checkpoint 3) |

Every code version gets a Git tag and a release note on GitHub.

## Known Limitations
- Code v1 is the skeleton: only the main menu works. The 14 classes have their attributes, constructors and method declarations, but the method bodies of the file reader, the scheduler, the constraint checker and the output classes are not written yet.
- The planned scheduling algorithm is greedy: it will never move a placed session, so a session can stay unscheduled even if another timetable exists (SDD, Section 6.5).

## Documents
- SRS: docs/requirements/ (SRS-v1.pdf, SRS-v2.pdf)
- SDD: docs/design/ (SDD-v1.pdf, SDD-v2.pdf; class-diagram and flowchart as PNG and draw.io files)
- Checkpoint reports: docs/checkpoints/Checkpoint-1-Report.pdf
- Team agreement: docs/team-agreement.md
- Test results: docs/testing/Test-Results.pdf (planned for Week 12)
