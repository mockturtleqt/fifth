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
            NodeList adventureTourList = root.getElementsByTagName("adventure-tour");
            for (int i = 0; i < adventureTourList.getLength(); i++) {
                Element tourElement = (Element) adventureTourList.item(i);
                TourVoucher tour = buildAdventureTour(tourElement);
                tours.add(tour);
            }

            NodeList concertTourList = root.getElementsByTagName("concert-tour");
            for (int i = 0; i < concertTourList.getLength(); i++) {
                Element tourElement = (Element) concertTourList.item(i);
                TourVoucher tour = buildConcertTour(tourElement);
                tours.add(tour);
            }

            NodeList medicalTourList = root.getElementsByTagName("medical-tour");
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
        tour.setName(tourElement.getAttribute("name"));
        tour.getCountry().addAll(getElementTextContent(tourElement, "country"));
        tour.setDuration(Integer.parseInt(getElementTextContent(tourElement, "duration").get(0)));
        tour.getTransportation().addAll(getElementTextContent(tourElement, "transportation"));
        tour.setPrice(getElementTextContent(tourElement, "price").get(0));
        Accommodation accommodation = new Accommodation();
        Element accommodationElement = (Element) tourElement.getElementsByTagName("hotel").item(0);
        accommodation.setStars(Integer.parseInt(getElementTextContent(accommodationElement, "stars").get(0)));
        accommodation.setFood(getElementTextContent(accommodationElement, "food").get(0));
        accommodation.setGuestsInRoom(Integer.parseInt(getElementTextContent(accommodationElement, "guests-in-room").get(0)));
        accommodation.getAmenities().addAll(getElementTextContent(accommodationElement, "amenities"));
        tour.setHotel(accommodation);
        return tour;
    }

    private TourVoucher buildAdventureTour(Element tourElement) {
        TourVoucher tour = new AdventureTourVoucher();
        fillTour(tour, tourElement);
        ((AdventureTourVoucher) tour).getActivity().addAll(getElementTextContent(tourElement, "activity"));
        ((AdventureTourVoucher) tour).setGoal(tourElement.getAttribute("goal"));
        return tour;
    }

    private TourVoucher buildConcertTour(Element tourElement) {
        TourVoucher tour = new ConcertTourVoucher();
        fillTour(tour, tourElement);
        ((ConcertTourVoucher) tour).getMusicGenre().addAll(getElementTextContent(tourElement, "music-genre"));
        ((ConcertTourVoucher) tour).setGoal(tourElement.getAttribute("goal"));
        return tour;
    }

    private TourVoucher buildMedicalTour(Element tourElement) {
        TourVoucher tour = new MedicalTourVoucher();
        fillTour(tour, tourElement);
        ((MedicalTourVoucher) tour).getTreatment().addAll(getElementTextContent(tourElement, "treatment"));
        ((MedicalTourVoucher) tour).setGoal(tourElement.getAttribute("goal"));
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
