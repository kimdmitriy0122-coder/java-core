package Lesson07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private static List<Place> allPlaces = new ArrayList<>();
    private static final ObjectOutputStream objectOutputStream;
    private static final ObjectInputStream objectInputStream;
    private static final File file = new File("1.txt");

    static {
        try {
            /**
             * запись в файл, т.к. базы на тот момент мы еще не проходили
             * */
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Object input = objectInputStream.readObject();
            if(input == null)
                allPlaces = new ArrayList<>();
            else
                allPlaces = (List<Place>) input;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void bookPlace(String fio, String placeCode) throws IOException {
        Place place = getPlace(placeCode);
        if (place.getStatus().equals(PlaceStatus.AVAILABLE) ||
            place.getStatus().equals(PlaceStatus.CANCELLED)) {
            place.setStatus(PlaceStatus.BOOKED);
            place.setFio(fio);
            place.setBookingDateTime(LocalDateTime.now());
        }
    }

    public void cancelBooking(String placeCode) throws IOException {
        Place place = getPlace(placeCode);

        if (place.getStatus().equals(PlaceStatus.BOOKED) ||
            place.getStatus().equals(PlaceStatus.PAYED)) {
            place.setStatus(PlaceStatus.CANCELLED);
        }
    }

    public void getInfoAboutPlace(String placeCode) throws IOException {
        Place place = getPlace(placeCode);
        System.out.println(place);
    }

    public List<Place> getAllPlaces() throws IOException {
        for(Place place : allPlaces){
            checkBookingDate(place);
        }
        return allPlaces;
    }

    public Place getPlace(String placeCode) throws IOException {
        Place place = getAllPlaces()
            .stream()
            .filter(p -> p.getPlaceCode().equals(placeCode))
            .findFirst()
            .orElse(null);
        if (place == null) {
            throw new Place.NoSuchPlaceException();
        }
        checkBookingDate(place);

        return place;
    }

    public void save() throws IOException {
        objectOutputStream.writeObject(allPlaces);
    }
    public void checkBookingDate(Place place) throws IOException {
        if(ChronoUnit.MINUTES.between(
            place.getBookingDateTime(),
            LocalDateTime.now()) < 24 && place.getStatus() == PlaceStatus.BOOKED)
            place.setStatus(PlaceStatus.AVAILABLE);
        save();
    }
}
