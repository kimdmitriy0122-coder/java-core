package Lesson06;

import lombok.Data;

import java.io.Serializable;
import java.util.NoSuchElementException;

@Data
public class Place implements Serializable {
    private String fio, placeCode;
    private PlaceClass placeClass;
    private PlaceStatus status;

    static class NoSuchPlaceException extends NoSuchElementException {
        String message = "there is no such place";
    }
}
