package com.epam.fifth.action.parsing;

import com.epam.fifth.tour.*;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static com.epam.fifth.action.parsing.TourEnum.*;

public class TourStaxBuilder {
    private final static Logger logger = Logger.getLogger(TourStaxBuilder.class);
    private HashSet<TourVoucher> tours = new HashSet<>();
    private XMLInputFactory inputFactory;

    public TourStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public Set<TourVoucher> getTours() {
        return tours;
    }

    public void buildSetTours(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    name = name.toUpperCase().replace('-', '_');
                    if (ADVENTURE_TOUR.getValue().equals(name) || CONCERT_TOUR.getValue().equals(name) || MEDICAL_TOUR.getValue().equals(name)) {
                        TourVoucher tour = buildTour(reader, name);
                        tours.add(tour);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            logger.error(e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }

    private TourVoucher buildTour(XMLStreamReader reader, String tourName) throws XMLStreamException {
        TourVoucher tour = null;
        if (ADVENTURE_TOUR.getValue().equals(tourName)) {
            tour = new AdventureTourVoucher();
            ((AdventureTourVoucher) tour).setGoal(reader.getAttributeValue(null, GOAL.getValue()));
        } else if (CONCERT_TOUR.getValue().equals(tourName)) {
            tour = new ConcertTourVoucher();
            ((ConcertTourVoucher) tour).setGoal(reader.getAttributeValue(null, GOAL.getValue()));
        } else if (MEDICAL_TOUR.getValue().equals(tourName)) {
            tour = new MedicalTourVoucher();
            ((MedicalTourVoucher) tour).setGoal(reader.getAttributeValue(null, GOAL.getValue()));
        }

        tour.setName(reader.getAttributeValue(null, NAME.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TourEnum.valueOf(name.toUpperCase().replace('-', '_'))) {
                        case COUNTRY:
                            tour.getCountry().add(getXMLText(reader));
                            break;
                        case DURATION:
                            tour.setDuration(Integer.parseInt(getXMLText(reader)));
                            break;
                        case TRANSPORTATION:
                            tour.getTransportation().add(getXMLText(reader));
                            break;
                        case PRICE:
                            tour.setPrice(getXMLText(reader));
                            break;
                        case HOTEL:
                            tour.setHotel(getXMLAccomodation(reader));
                            break;
                        case ACTIVITY:
                            ((AdventureTourVoucher) tour).getActivity().add(getXMLText(reader));
                            break;
                        case TREATMENT:
                            ((MedicalTourVoucher) tour).getTreatment().add(getXMLText(reader));
                            break;
                        case MUSIC_GENRE:
                            ((ConcertTourVoucher) tour).getMusicGenre().add(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    name = name.toUpperCase().replace('-', '_');
                    if (ADVENTURE_TOUR.getValue().equals(name) || CONCERT_TOUR.getValue().equals(name) || MEDICAL_TOUR.getValue().equals(name)) {
                        return tour;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }

    private Accommodation getXMLAccomodation(XMLStreamReader reader) throws XMLStreamException {
        Accommodation accommodation = new Accommodation();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TourEnum.valueOf(name.toUpperCase().replace('-', '_'))) {
                        case STARS:
                            accommodation.setStars(Integer.parseInt(getXMLText(reader)));
                            break;
                        case FOOD:
                            accommodation.setFood(getXMLText(reader));
                            break;
                        case GUESTS_IN_ROOM:
                            accommodation.setGuestsInRoom(Integer.parseInt(getXMLText(reader)));
                            break;
                        case AMENITIES:
                            accommodation.getAmenities().add(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (HOTEL.equals(TourEnum.valueOf(name.toUpperCase()))) {
                        return accommodation;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}

