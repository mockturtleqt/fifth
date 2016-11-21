package com.epam.fifth.action.parsing;

import com.epam.fifth.tour.TourVoucher;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

public class TourSaxBuilder {
    private static final Logger logger = Logger.getLogger(TourSaxBuilder.class);
    private Set<TourVoucher> tours;
    private TourHandler th;
    private XMLReader reader;

    public TourSaxBuilder() {
        th = new TourHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(th);
        } catch (SAXException e) {
            logger.error(e);
        }
    }

    public Set<TourVoucher> getTours() {
        return tours;
    }

    public void buildSetTours(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException | IOException e) {
            logger.error(e);
        }
        tours = th.getTours();
    }
}
