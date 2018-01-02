package com.deckerchan.blog.entities.storage;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

public final class AccessRecord {
    @Id
    private UUID id;
    private Date accessDate;
    private String browserName;
    private String osName;
    private String device;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
