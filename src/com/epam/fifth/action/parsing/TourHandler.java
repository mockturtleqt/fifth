package com.epam.fifth.action.parsing;

import com.epam.fifth.tour.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static com.epam.fifth.action.parsing.TourEnum.*;

public class TourHandler extends DefaultHandler {
    private Set<TourVoucher> tours;
    private TourVoucher current = null;
    private TourEnum currentEnum = null;
    private EnumSet<TourEnum> withText;

    public TourHandler() {
        tours = new HashSet<TourVoucher>();
        withText = EnumSet.range(TourEnum.HOTEL, TourEnum.TREATMENT);
    }

    public Set<TourVoucher> getTours() {
        return tours;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        switch (localName) {
            case "adventure-tour":
                current = new AdventureTourVoucher();
                current.setName(attrs.getValue(0));
                ((AdventureTourVoucher) current).setGoal(attrs.getValue(1));
                break;
            case "concert-tour":
                current = new ConcertTourVoucher();
                current.setName(attrs.getValue(0));
                ((ConcertTourVoucher) current).setGoal(attrs.getValue(1));
                break;
            case "medical-tour":
                current = new MedicalTourVoucher();
                current.setName(attrs.getValue(0));
                ((MedicalTourVoucher) current).setGoal(attrs.getValue(1));
                break;
            default:
                TourEnum temp = TourEnum.valueOf(localName.toUpperCase().replace('-', '_'));
                if (withText.contains(temp)) {
                    currentEnum = temp;
                }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (MEDICAL_TOUR.getValue().equals(localName) || CONCERT_TOUR.getValue().equals(localName) || ADVENTURE_TOUR.getValue().equals(localName)) {
            tours.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case HOTEL:
                    current.setHotel(new Accommodation());
                    break;
                case COUNTRY:
                    current.getCountry().add(s);
                    break;
                case DURATION:
                    current.setDuration(Integer.parseInt(s));
                    break;
                case TRANSPORTATION:
                    current.getTransportation().add(s);
                    break;
                case PRICE:
                    current.setPrice(s);
                    break;
                case STARS:
                    current.getHotel().setStars(Integer.parseInt(s));
                    break;
                case FOOD:
                    current.getHotel().setFood(s);
                    break;
                case GUESTS_IN_ROOM:
                    current.getHotel().setGuestsInRoom(Integer.parseInt(s));
                    break;
                case AMENITIES:
                    current.getHotel().getAmenities().add(s);
                    break;
                case ACTIVITY:
                    ((AdventureTourVoucher) current).getActivity().add(s);
                    break;
                case TREATMENT:
                    ((MedicalTourVoucher) current).getTreatment().add(s);
                    break;
                case MUSIC_GENRE:
                    ((ConcertTourVoucher) current).getMusicGenre().add(s);
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}

