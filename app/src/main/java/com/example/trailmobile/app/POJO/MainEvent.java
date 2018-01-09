package com.example.trailmobile.app.POJO;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainEvent {

    @SerializedName("trail_event_id")
    @Expose
    private Integer trailEventId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("init_date")
    @Expose
    private String initDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("organization_id")
    @Expose
    private Integer organizationId;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("event_url")
    @Expose
    private String eventUrl;
    @SerializedName("competition")
    @Expose
    private List<Competition> competition = new ArrayList<Competition>();

    /**
     *
     * @return
     * The trailEventId
     */
    public Integer getTrailEventId() {
        return trailEventId;
    }

    /**
     *
     * @param trailEventId
     * The trail_event_id
     */
    public void setTrailEventId(Integer trailEventId) {
        this.trailEventId = trailEventId;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The initDate
     */
    public String getInitDate() {
        return initDate;
    }

    /**
     *
     * @param initDate
     * The init_date
     */
    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }

    /**
     *
     * @return
     * The endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     *
     * @param endDate
     * The end_date
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     *
     * @param shortName
     * The short_name
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     *
     * @return
     * The organizationId
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     *
     * @param organizationId
     * The organization_id
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     *
     * @return
     * The imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     *
     * @param imageUrl
     * The image_url
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     *
     * @return
     * The eventUrl
     */
    public String getEventUrl() {
        return eventUrl;
    }

    /**
     *
     * @param eventUrl
     * The event_url
     */
    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    /**
     *
     * @return
     * The competition
     */
    public List<Competition> getCompetition() {
        return competition;
    }

    /**
     *
     * @param competition
     * The competition
     */
    public void setCompetition(List<Competition> competition) {
        this.competition = competition;
    }

}
