package lesson05.courses;

import lombok.Data;

@Data
public class Attendance {
    private Student student;
    private boolean attended;
}
