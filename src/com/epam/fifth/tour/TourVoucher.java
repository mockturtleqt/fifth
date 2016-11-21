
package com.epam.fifth.tour;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for com.epam.fifth.tour-voucher complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="com.epam.fifth.tour-voucher">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hotel" type="{}accommodation"/>
 *         &lt;element name="country" maxOccurs="unbounded">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Russia"/>
 *               &lt;enumeration value="Ukraine"/>
 *               &lt;enumeration value="Poland"/>
 *               &lt;enumeration value="Lithuania"/>
 *               &lt;enumeration value="Latvia"/>
 *               &lt;enumeration value="France"/>
 *               &lt;enumeration value="Germany"/>
 *               &lt;enumeration value="Sweden"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="transportation" maxOccurs="unbounded">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="bus"/>
 *               &lt;enumeration value="plane"/>
 *               &lt;enumeration value="train"/>
 *               &lt;enumeration value="ship"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="price">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[$��]\d{0,8}(\.\d{1,4})?"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "com.epam.fifth.tour-voucher", propOrder = {
        "hotel",
        "country",
        "duration",
        "transportation",
        "price"
})
@XmlSeeAlso({
        MedicalTourVoucher.class,
        AdventureTourVoucher.class,
        ConcertTourVoucher.class
})
public class TourVoucher {

    @XmlElement(required = true)
    protected Accommodation hotel;
    @XmlElement(required = true)
    protected List<String> country;
    @XmlSchemaType(name = "unsignedInt")
    protected int duration;
    @XmlElement(required = true)
    protected List<String> transportation;
    @XmlElement(required = true)
    protected String price;
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String name;

    /**
     * Gets the value of the hotel property.
     *
     * @return possible object is
     * {@link Accommodation }
     */
    public Accommodation getHotel() {
        return hotel;
    }

    /**
     * Sets the value of the hotel property.
     *
     * @param value allowed object is
     *              {@link Accommodation }
     */
    public void setHotel(Accommodation value) {
        this.hotel = value;
    }

    /**
     * Gets the value of the country property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the country property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCountry().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getCountry() {
        if (country == null) {
            country = new ArrayList<String>();
        }
        return this.country;
    }

    /**
     * Gets the value of the duration property.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     */
    public void setDuration(int value) {
        this.duration = value;
    }

    /**
     * Gets the value of the transportation property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transportation property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransportation().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getTransportation() {
        if (transportation == null) {
            transportation = new ArrayList<String>();
        }
        return this.transportation;
    }

    /**
     * Gets the value of the price property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPrice(String value) {
        this.price = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public String toString() {
        return "TourVoucher{" +
                "hotel=" + hotel +
                ", country=" + country +
                ", duration=" + duration +
                ", transportation=" + transportation +
                ", price='" + price + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
