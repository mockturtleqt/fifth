package com.epam.fifth.action.parsing;

import com.epam.fifth.tour.*;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
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

    private TourVoucher buildTour(Element tourElement) {
        TourVoucher tour = new AdventureTourVoucher();
        tour.setName(tourElement.getAttribute("name"));
        tour.getCountry().add(getElementTextContent(tourElement, "country"));
        tour.setDuration(Integer.parseInt(getElementTextContent(tourElement, "duration")));
        tour.getTransportation().add(getElementTextContent(tourElement, "transportation"));
        tour.setPrice(getElementTextContent(tourElement, "price"));
        Accommodation accommodation = tour.getHotel();
        Element accommodationElement = (Element) tourElement.getElementsByTagName("hotel").item(0);
        accommodation.setStars(Integer.parseInt(getElementTextContent(accommodationElement, "stars")));
        accommodation.setFood(getElementTextContent(accommodationElement, "food"));
        accommodation.setGuestsInRoom(Integer.parseInt(getElementTextContent(accommodationElement, "guests-in-room")));
        accommodation.getAmenities().add(getElementTextContent(accommodationElement, "amenities"));
        return tour;
    }

    private TourVoucher buildAdventureTour(Element tourElement) {
        TourVoucher tour = buildTour(tourElement);
        ((AdventureTourVoucher) tour).getActivity().add(getElementTextContent(tourElement, "activity"));
        ((AdventureTourVoucher) tour).setGoal(tourElement.getAttribute("goal"));
        return tour;
    }

    private TourVoucher buildConcertTour(Element tourElement) {
        TourVoucher tour = buildTour(tourElement);
        ((ConcertTourVoucher) tour).getMusicGenre().add(getElementTextContent(tourElement, "music-genre"));
        ((ConcertTourVoucher) tour).setGoal(tourElement.getAttribute("goal"));
        return tour;
    }

    private TourVoucher buildMedicalTour(Element tourElement) {
        TourVoucher tour = buildTour(tourElement);
        ((MedicalTourVoucher) tour).getTreatment().add(getElementTextContent(tourElement, "treatment"));
        ((MedicalTourVoucher) tour).setGoal(tourElement.getAttribute("goal"));
        return tour;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
