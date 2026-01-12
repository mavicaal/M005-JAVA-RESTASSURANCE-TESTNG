// src/main/java/com/api/models/BerryFirmness.java
package com.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BerryFirmness {
    private int id;
    private String name;

    @JsonProperty("berries")
    private List<BerryReference> berries;

    @JsonProperty("names")
    private List<NameReference> names;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BerryReference> getBerries() {
        return berries;
    }

    public void setBerries(List<BerryReference> berries) {
        this.berries = berries;
    }

    public List<NameReference> getNames() {
        return names;
    }

    public void setNames(List<NameReference> names) {
        this.names = names;
    }

    // Inner class for berry references
    public static class BerryReference {
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    // Inner class for name references
    public static class NameReference {
        private String name;
        private Language language;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Language getLanguage() {
            return language;
        }

        public void setLanguage(Language language) {
            this.language = language;
        }

        // Inner class for language
        public static class Language {
            private String name;
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
