package Lesson07;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.NoSuchElementException;

@Data
public class Place implements Serializable {
    private String fio, placeCode;
    private PlaceClass placeClass;
    private PlaceStatus status;
    private LocalDateTime bookingDateTime;

    static class NoSuchPlaceException extends NoSuchElementException {
        String message = "there is no such place";
    }
}
