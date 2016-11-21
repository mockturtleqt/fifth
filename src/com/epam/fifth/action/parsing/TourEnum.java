package com.epam.fifth.action.parsing;

public enum TourEnum {
    TOURIST_VOUCHERS("tourist-vouchers"),
    ADVENTURE_TOUR("adventure-tour"),
    MEDICAL_TOUR("medical-tour"),
    CONCERT_TOUR("concert-tour"),
    //TOUR_VOUCHER("tour-voucher"), //TOUR("tour")
    HOTEL("hotel"),
    STARS("stars"),
    FOOD("food"),
    GUESTS_IN_ROOM("guests-in-room"),
    AMENITIES("amenities"),
    COUNTRY("country"),
    DURATION("duration"),
    TRANSPORTATION("transportation"),
    PRICE("price"),
    ACTIVITY("activity"),
    MUSIC_GENRE("music-genre"),
    TREATMENT("treatment"),
    GOAL("goal"),
    NAME("name");

    private String value;

    private TourEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
