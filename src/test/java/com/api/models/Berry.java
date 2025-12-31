// java
// `src/main/java/com/api/models/Berry.java`
package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Berry {
    private int id;
    private String name;

    @JsonProperty("growth_time")
    private int growthTime;

    private int size;

    private Firmness firmness;

    private List<Flavor> flavors;

    // new field to match the API's "item" object
    private Item item;

    // getters/setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getGrowthTime() { return growthTime; }
    public void setGrowthTime(int growthTime) { this.growthTime = growthTime; }

    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }

    public Firmness getFirmness() { return firmness; }
    public void setFirmness(Firmness firmness) { this.firmness = firmness; }

    public List<Flavor> getFlavors() { return flavors; }
    public void setFlavors(List<Flavor> flavors) { this.flavors = flavors; }

    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    public static class Firmness {
        private String name;
        private String url;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
    }

    public static class Flavor {
        private int potency;
        private FlavorItem flavor;

        public int getPotency() { return potency; }
        public void setPotency(int potency) { this.potency = potency; }

        public FlavorItem getFlavor() { return flavor; }
        public void setFlavor(FlavorItem flavor) { this.flavor = flavor; }

        public static class FlavorItem {
            private String name;
            private String url;

            public String getName() { return name; }
            public void setName(String name) { this.name = name; }
            public String getUrl() { return url; }
            public void setUrl(String url) { this.url = url; }
        }
    }

    // new nested class to represent the "item" object in the API response
    public static class Item {
        private String name;
        private String url;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
    }
}