
package com.epam.fifth.tour;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for accommodation complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="accommodation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stars">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
 *               &lt;pattern value="[1-5]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="food">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="None"/>
 *               &lt;enumeration value="Whole day"/>
 *               &lt;enumeration value="Breakfast only"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="guests-in-room">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxExclusive value="16"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="amenities" maxOccurs="unbounded" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tv"/>
 *               &lt;enumeration value="iron"/>
 *               &lt;enumeration value="elevator in building"/>
 *               &lt;enumeration value="hair dryer"/>
 *               &lt;enumeration value="washer"/>
 *               &lt;enumeration value="wi-fi"/>
 *               &lt;enumeration value="smoking allowed"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accommodation", propOrder = {
        "stars",
        "food",
        "guestsInRoom",
        "amenities"
})
public class Accommodation {

    protected int stars;
    @XmlElement(required = true)
    protected String food;
    @XmlElement(name = "guests-in-room")
    protected int guestsInRoom;
    protected List<String> amenities;

    /**
     * Gets the value of the stars property.
     */
    public int getStars() {
        return stars;
    }

    /**
     * Sets the value of the stars property.
     */
    public void setStars(int value) {
        this.stars = value;
    }

    /**
     * Gets the value of the food property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFood() {
        return food;
    }

    /**
     * Sets the value of the food property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFood(String value) {
        this.food = value;
    }

    /**
     * Gets the value of the guestsInRoom property.
     */
    public long getGuestsInRoom() {
        return guestsInRoom;
    }

    /**
     * Sets the value of the guestsInRoom property.
     */
    public void setGuestsInRoom(int value) {
        this.guestsInRoom = value;
    }

    /**
     * Gets the value of the amenities property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the amenities property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAmenities().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getAmenities() {
        if (amenities == null) {
            amenities = new ArrayList<String>();
        }
        return this.amenities;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "stars=" + stars +
                ", food='" + food + '\'' +
                ", guestsInRoom=" + guestsInRoom +
                ", amenities=" + amenities +
                '}';
    }
}
