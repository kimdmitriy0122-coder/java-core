package lesson05.courses;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Course {
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();
    private Map<LocalDateTime, List<Attendance>> attendanceJournal = new HashMap<>();
    private Map<LocalDateTime, List<Mark>> markJournal = new HashMap<>();

    Course(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void setAttendanceJournal(LocalDateTime date, Student student, boolean isAttendance) {
        if(!isStudentInList(student)){
            throw new IllegalArgumentException("Student is not in list");
        }

        List<Attendance> checkJournalForDate = attendanceJournal.get(date);
        if(checkJournalForDate.isEmpty()){
            checkJournalForDate = new ArrayList<>();
            Attendance journal = new Attendance();
            journal.setStudent(student);
            journal.setAttended(isAttendance);
            checkJournalForDate.add(journal);
        }
        attendanceJournal.put(date, checkJournalForDate);
    }

    public void setMarkJournal(LocalDateTime date, Student student, int mark) {
        if(mark > 5 || mark < 0){
            throw new IllegalArgumentException("Invalid mark. It must be between 0 and 5");
        }
        if(!isStudentInList(student)){
            throw new IllegalArgumentException("Student is not in list");
        }

        List<Mark> checkJournalForDate = markJournal.get(date);
        if(checkJournalForDate.isEmpty()){
            checkJournalForDate = new ArrayList<>();
            Mark journal = new Mark();
            journal.setStudent(student);
            journal.setMark(mark);
            checkJournalForDate.add(journal);
        }
        markJournal.put(date, checkJournalForDate);
    }

    public boolean isStudentInList(Student student) {
        return students.contains(student);
    }

}
