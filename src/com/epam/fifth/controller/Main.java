package com.epam.fifth.controller;

import com.epam.fifth.action.parsing.TourDomBuilder;

public class Main {

    public static void main(String[] args) {

        TourDomBuilder domBuilder = new TourDomBuilder();
        domBuilder.buildSetTours("./data/voucher.xml");
        System.out.println(domBuilder.getTours());
    }
}
