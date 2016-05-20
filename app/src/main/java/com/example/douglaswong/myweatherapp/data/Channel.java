package com.example.douglaswong.myweatherapp.data;

import org.json.JSONObject;

/**
 * Created by Douglas Wong on 5/18/2016.
 */
public class Channel implements JSONPopulator {
    private Item item;

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    private Units units;
    private Location location;

    public Units getUnits() {
        return units;
    }

    public Item getItem() {
        return item;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public void populate(JSONObject data) {
        units = new Units();
        units.populate(data.optJSONObject("units"));

        item = new Item();
        item.populate(data.optJSONObject("item"));

        location = new Location();
        location.populate(data.optJSONObject("location"));
    }
}