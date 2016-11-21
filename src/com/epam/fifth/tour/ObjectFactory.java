
package com.epam.fifth.tour;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.epam.fifth.tour package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MedicalTour_QNAME = new QName("", "medical-com.epam.fifth.tour");
    private final static QName _AdventureTour_QNAME = new QName("", "adventure-com.epam.fifth.tour");
    private final static QName _Tour_QNAME = new QName("", "com/epam/fifth/tour");
    private final static QName _ConcertTour_QNAME = new QName("", "concert-com.epam.fifth.tour");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epam.fifth.tour
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TouristVouchers }
     */
    public TouristVouchers createTouristVouchers() {
        return new TouristVouchers();
    }

    /**
     * Create an instance of {@link TourVoucher }
     */
    public TourVoucher createTourVoucher() {
        return new TourVoucher();
    }

    /**
     * Create an instance of {@link MedicalTourVoucher }
     */
    public MedicalTourVoucher createMedicalTourVoucher() {
        return new MedicalTourVoucher();
    }

    /**
     * Create an instance of {@link AdventureTourVoucher }
     */
    public AdventureTourVoucher createAdventureTourVoucher() {
        return new AdventureTourVoucher();
    }

    /**
     * Create an instance of {@link ConcertTourVoucher }
     */
    public ConcertTourVoucher createConcertTourVoucher() {
        return new ConcertTourVoucher();
    }

    /**
     * Create an instance of {@link Accommodation }
     */
    public Accommodation createAccommodation() {
        return new Accommodation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedicalTourVoucher }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "medical-com.epam.fifth.tour", substitutionHeadNamespace = "", substitutionHeadName = "com/epam/fifth/tour")
    public JAXBElement<MedicalTourVoucher> createMedicalTour(MedicalTourVoucher value) {
        return new JAXBElement<MedicalTourVoucher>(_MedicalTour_QNAME, MedicalTourVoucher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdventureTourVoucher }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "adventure-com.epam.fifth.tour", substitutionHeadNamespace = "", substitutionHeadName = "com/epam/fifth/tour")
    public JAXBElement<AdventureTourVoucher> createAdventureTour(AdventureTourVoucher value) {
        return new JAXBElement<AdventureTourVoucher>(_AdventureTour_QNAME, AdventureTourVoucher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TourVoucher }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "com/epam/fifth/tour")
    public JAXBElement<TourVoucher> createTour(TourVoucher value) {
        return new JAXBElement<TourVoucher>(_Tour_QNAME, TourVoucher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConcertTourVoucher }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "concert-com.epam.fifth.tour", substitutionHeadNamespace = "", substitutionHeadName = "com/epam/fifth/tour")
    public JAXBElement<ConcertTourVoucher> createConcertTour(ConcertTourVoucher value) {
        return new JAXBElement<ConcertTourVoucher>(_ConcertTour_QNAME, ConcertTourVoucher.class, null, value);
    }

}
