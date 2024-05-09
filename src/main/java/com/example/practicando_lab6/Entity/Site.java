package com.example.practicando_lab6.Entity;

import jakarta.persistence.*;


@Entity
@Table(name ="site")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SiteId")
    private int siteId;
    private String siteName;
    @JoinColumn(name="LocationId")
    @ManyToOne
    private Location location;
    private String intallationDate;
    private String latitude;
    private String longitude;

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getIntallationDate() {
        return intallationDate;
    }

    public void setIntallationDate(String intallationDate) {
        this.intallationDate = intallationDate;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
