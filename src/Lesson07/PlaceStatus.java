package Lesson07;

import java.io.Serializable;

public enum PlaceStatus implements Serializable {
    AVAILABLE,
    BOOKED,
    PAYED,
    CONFIRMED,
    CANCELLED;
}
