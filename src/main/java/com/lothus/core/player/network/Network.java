package com.lothus.core.player.network;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Network {

    private String ipv4;

    private String country;
    private String states;
    private String city;

    private String isp;

    public Network() {

    }

    public Network(String ipv4, String country, String states, String city, String isp) {
        this.ipv4 = ipv4;
        this.country = country;
        this.states = states;
        this.city = city;
        this.isp = isp;
    }
}
