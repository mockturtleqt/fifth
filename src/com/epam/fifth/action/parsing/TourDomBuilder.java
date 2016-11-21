package com.epam.fifth.action.parsing;

import com.epam.fifth.tour.*;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.epam.fifth.action.parsing.TourEnum.*;

public class TourDomBuilder {
    private static final Logger logger = Logger.getLogger(TourDomBuilder.class);
    private Set<TourVoucher> tours;
    private DocumentBuilder docBuilder;

    public TourDomBuilder() {
        this.tours = new HashSet<TourVoucher>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error(e);
        }
    }

    public Set<TourVoucher> getTours() {
        return tours;
    }

    public void buildSetTours(String fileName) {
        Document doc;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList adventureTourList = root.getElementsByTagName(ADVENTURE_TOUR.getValue());
            for (int i = 0; i < adventureTourList.getLength(); i++) {
                Element tourElement = (Element) adventureTourList.item(i);
                TourVoucher tour = buildAdventureTour(tourElement);
                tours.add(tour);
            }

            NodeList concertTourList = root.getElementsByTagName(CONCERT_TOUR.getValue());
            for (int i = 0; i < concertTourList.getLength(); i++) {
                Element tourElement = (Element) concertTourList.item(i);
                TourVoucher tour = buildConcertTour(tourElement);
                tours.add(tour);
            }

            NodeList medicalTourList = root.getElementsByTagName(MEDICAL_TOUR.getValue());
            for (int i = 0; i < medicalTourList.getLength(); i++) {
                Element tourElement = (Element) medicalTourList.item(i);
                TourVoucher tour = buildMedicalTour(tourElement);
                tours.add(tour);
            }
        } catch (IOException | SAXException e) {
            logger.error(e);
        }
    }

    private TourVoucher fillTour(TourVoucher tour, Element tourElement) {
        tour.setName(tourElement.getAttribute(NAME.getValue()));
        tour.getCountry().addAll(getElementTextContent(tourElement, COUNTRY.getValue()));
        tour.setDuration(Integer.parseInt(getElementTextContent(tourElement, DURATION.getValue()).get(0)));
        tour.getTransportation().addAll(getElementTextContent(tourElement, TRANSPORTATION.getValue()));
        tour.setPrice(getElementTextContent(tourElement, PRICE.getValue()).get(0));
        Accommodation accommodation = new Accommodation();
        Element accommodationElement = (Element) tourElement.getElementsByTagName(HOTEL.getValue()).item(0);
        accommodation.setStars(Integer.parseInt(getElementTextContent(accommodationElement, STARS.getValue()).get(0)));
        accommodation.setFood(getElementTextContent(accommodationElement, FOOD.getValue()).get(0));
        accommodation.setGuestsInRoom(Integer.parseInt(getElementTextContent(accommodationElement, GUESTS_IN_ROOM.getValue()).get(0)));
        accommodation.getAmenities().addAll(getElementTextContent(accommodationElement, AMENITIES.getValue()));
        tour.setHotel(accommodation);
        return tour;
    }

    private TourVoucher buildAdventureTour(Element tourElement) {
        TourVoucher tour = new AdventureTourVoucher();
        fillTour(tour, tourElement);
        ((AdventureTourVoucher) tour).getActivity().addAll(getElementTextContent(tourElement, ACTIVITY.getValue()));
        ((AdventureTourVoucher) tour).setGoal(tourElement.getAttribute(GOAL.getValue()));
        return tour;
    }

    private TourVoucher buildConcertTour(Element tourElement) {
        TourVoucher tour = new ConcertTourVoucher();
        fillTour(tour, tourElement);
        ((ConcertTourVoucher) tour).getMusicGenre().addAll(getElementTextContent(tourElement, MUSIC_GENRE.getValue()));
        ((ConcertTourVoucher) tour).setGoal(tourElement.getAttribute(GOAL.getValue()));
        return tour;
    }

    private TourVoucher buildMedicalTour(Element tourElement) {
        TourVoucher tour = new MedicalTourVoucher();
        fillTour(tour, tourElement);
        ((MedicalTourVoucher) tour).getTreatment().addAll(getElementTextContent(tourElement, TREATMENT.getValue()));
        ((MedicalTourVoucher) tour).setGoal(tourElement.getAttribute(GOAL.getValue()));
        return tour;
    }

    private static List<String> getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        List<String> textContent = new ArrayList<>();
        for (int i = 0; i < nList.getLength(); i++) {
            textContent.add(nList.item(i).getTextContent());
        }
        return textContent;
    }
}
