package com.deckerchan.blog.entities.storage;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

public final class AccessRecord {
    @Id
    private UUID id;
    private Date accessDate;
    private String address;
    private String appCodeName;
    private String vendor;
    private String platform;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAppCodeName() {
        return appCodeName;
    }

    public void setAppCodeName(String appCodeName) {
        this.appCodeName = appCodeName;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getPlatform()  {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
