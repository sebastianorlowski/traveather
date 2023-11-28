package com.traveather.waypoint.service.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class WaypointMessaging {

    private BigDecimal latitude;
    private BigDecimal longitude;
    private String country;
    private String city;
    private String capital;
    private Integer area;
    private Integer population;
    private String currency;
}
