
package com.epam.fifth.tour;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}com.epam.fifth.tour" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "com/epam/fifth/tour"
})
@XmlRootElement(name = "tourist-vouchers")
public class TouristVouchers {

    @XmlElementRef(name = "com/epam/fifth/tour", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TourVoucher>> tour;

    /**
     * Gets the value of the com.epam.fifth.tour property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the com.epam.fifth.tour property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTour().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TourVoucher }{@code >}
     * {@link JAXBElement }{@code <}{@link MedicalTourVoucher }{@code >}
     * {@link JAXBElement }{@code <}{@link AdventureTourVoucher }{@code >}
     * {@link JAXBElement }{@code <}{@link ConcertTourVoucher }{@code >}
     */
    public List<JAXBElement<? extends TourVoucher>> getTour() {
        if (tour == null) {
            tour = new ArrayList<JAXBElement<? extends TourVoucher>>();
        }
        return this.tour;
    }

}
