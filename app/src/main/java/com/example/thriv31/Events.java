package com.example.thriv31;

public class Events {
    private String name;
    private String date;
    private String time;
    private String venue;

    public Events(String name, String date, String time, String venue) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.venue = venue;
    }

    // Getters
    public String getName() { return name; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getVenue() { return venue; }
}

