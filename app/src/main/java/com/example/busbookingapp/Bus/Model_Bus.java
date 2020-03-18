package com.example.busbookingapp.Bus;

public class Model_Bus {

    private String bus_name;
    private String bus_desc;
    private String bus_arrival_time;
    private String bus_reach_time;
    private String bus_ticket_price;
    private String bus_total_seats;

    public Model_Bus(String bus_name, String bus_desc, String bus_arrival_time, String bus_reach_time, String bus_ticket_price, String bus_total_seats) {
        this.bus_name = bus_name;
        this.bus_desc = bus_desc;
        this.bus_arrival_time = bus_arrival_time;
        this.bus_reach_time = bus_reach_time;
        this.bus_ticket_price = bus_ticket_price;
        this.bus_total_seats = bus_total_seats;
    }

    public String getBus_name() {
        return bus_name;
    }

    public String getBus_desc() {
        return bus_desc;
    }

    public String getBus_arrival_time() {
        return bus_arrival_time;
    }

    public String getBus_reach_time() {
        return bus_reach_time;
    }

    public String getBus_ticket_price() {
        return bus_ticket_price;
    }

    public String getBus_total_seats() {
        return bus_total_seats;
    }
}
