package com.lothus.core.utils.checker;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lothus.core.player.network.Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class IpChecker extends Network {

    private JsonObject apiResponse;

    public IpChecker(String ip) {
        try {
            URL url = new URL("http://ip-api.com/json/" + ip);
            URLConnection connection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                responseBuilder.append(inputLine);
            }
            in.close();
            String response = responseBuilder.toString();
            JsonElement resFinal = new JsonParser().parse(response);
            this.apiResponse = resFinal.getAsJsonObject();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getCity() {
        return this.apiResponse.get("city").getAsString();
    }
    @Override
    public String getCountry() {
        return this.apiResponse.get("country").getAsString();
    }
    @Override
    public String getStates() {
        return this.apiResponse.get("regionName").getAsString();
    }
    @Override
    public String getIsp() {
        return this.apiResponse.get("isp").getAsString();
    }
}
