
package com.epam.fifth.tour;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for adventure-com.epam.fifth.tour-voucher complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="adventure-com.epam.fifth.tour-voucher">
 *   &lt;complexContent>
 *     &lt;extension base="{}com.epam.fifth.tour-voucher">
 *       &lt;sequence>
 *         &lt;element name="activity" maxOccurs="unbounded">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="hiking"/>
 *               &lt;enumeration value="biking"/>
 *               &lt;enumeration value="swimming"/>
 *               &lt;enumeration value="snow-boarding"/>
 *               &lt;enumeration value="skiing"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="goal" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" default="adventure" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "adventure-com.epam.fifth.tour-voucher", propOrder = {
        "activity"
})
public class AdventureTourVoucher
        extends TourVoucher {

    @XmlElement(required = true)
    protected List<String> activity;
    @XmlAttribute(name = "goal")
    @XmlSchemaType(name = "anySimpleType")
    protected String goal;

    /**
     * Gets the value of the activity property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activity property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivity().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getActivity() {
        if (activity == null) {
            activity = new ArrayList<String>();
        }
        return this.activity;
    }

    /**
     * Gets the value of the goal property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGoal() {
        if (goal == null) {
            return "adventure";
        } else {
            return goal;
        }
    }

    /**
     * Sets the value of the goal property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGoal(String value) {
        if (value == null) {
            this.goal = "adventure";
        } else {
            this.goal = value;
        }
    }

    @Override
    public String toString() {
        return "AdventureTourVoucher{" +
                super.toString() +
                "activity=" + activity +
                ", goal='" + goal + '\'' +
                '}' + '\n';
    }
}
