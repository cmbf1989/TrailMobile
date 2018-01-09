package com.example.trailmobile.app.POJO;

/**
 * Created by utilizador on 24/07/2016.
 */

import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("gpx_src")
    @Expose
    private String gpxSrc;
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("placeholder")
    @Expose
    private String placeholder;
    @SerializedName("max_participants")
    @Expose
    private String maxParticipants;
    @SerializedName("regulation")
    @Expose
    private String regulation;
    @SerializedName("local")
    @Expose
    private String local;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("start_inscriptions")
    @Expose
    private String startInscriptions;
    @SerializedName("end_inscriptions")
    @Expose
    private String endInscriptions;
    @SerializedName("min_age")
    @Expose
    private String minAge;
    @SerializedName("organization_id")
    @Expose
    private String organizationId;
    @SerializedName("max_wait_list")
    @Expose
    private Object maxWaitList;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("has_form")
    @Expose
    private String hasForm;
    @SerializedName("default_payment_id")
    @Expose
    private String defaultPaymentId;
    @SerializedName("event_photo")
    @Expose
    private String eventPhoto;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("submit_at")
    @Expose
    private Object submitAt;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
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
     * The gpxSrc
     */
    public String getGpxSrc() {
        return gpxSrc;
    }

    /**
     *
     * @param gpxSrc
     * The gpx_src
     */
    public void setGpxSrc(String gpxSrc) {
        this.gpxSrc = gpxSrc;
    }

    /**
     *
     * @return
     * The distance
     */
    public String getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     * The distance
     */
    public void setDistance(String distance) {
        this.distance = distance;
    }

    /**
     *
     * @return
     * The placeholder
     */
    public String getPlaceholder() {
        return placeholder;
    }

    /**
     *
     * @param placeholder
     * The placeholder
     */
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    /**
     *
     * @return
     * The maxParticipants
     */
    public String getMaxParticipants() {
        return maxParticipants;
    }

    /**
     *
     * @param maxParticipants
     * The max_participants
     */
    public void setMaxParticipants(String maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    /**
     *
     * @return
     * The regulation
     */
    public String getRegulation() {
        return regulation;
    }

    /**
     *
     * @param regulation
     * The regulation
     */
    public void setRegulation(String regulation) {
        this.regulation = regulation;
    }

    /**
     *
     * @return
     * The local
     */
    public String getLocal() {
        return local;
    }

    /**
     *
     * @param local
     * The local
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     * The start_date
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
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
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The startInscriptions
     */
    public String getStartInscriptions() {
        return startInscriptions;
    }

    /**
     *
     * @param startInscriptions
     * The start_inscriptions
     */
    public void setStartInscriptions(String startInscriptions) {
        this.startInscriptions = startInscriptions;
    }

    /**
     *
     * @return
     * The endInscriptions
     */
    public String getEndInscriptions() {
        return endInscriptions;
    }

    /**
     *
     * @param endInscriptions
     * The end_inscriptions
     */
    public void setEndInscriptions(String endInscriptions) {
        this.endInscriptions = endInscriptions;
    }

    /**
     *
     * @return
     * The minAge
     */
    public String getMinAge() {
        return minAge;
    }

    /**
     *
     * @param minAge
     * The min_age
     */
    public void setMinAge(String minAge) {
        this.minAge = minAge;
    }

    /**
     *
     * @return
     * The organizationId
     */
    public String getOrganizationId() {
        return organizationId;
    }

    /**
     *
     * @param organizationId
     * The organization_id
     */
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    /**
     *
     * @return
     * The maxWaitList
     */
    public Object getMaxWaitList() {
        return maxWaitList;
    }

    /**
     *
     * @param maxWaitList
     * The max_wait_list
     */
    public void setMaxWaitList(Object maxWaitList) {
        this.maxWaitList = maxWaitList;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The hasForm
     */
    public String getHasForm() {
        return hasForm;
    }

    /**
     *
     * @param hasForm
     * The has_form
     */
    public void setHasForm(String hasForm) {
        this.hasForm = hasForm;
    }

    /**
     *
     * @return
     * The defaultPaymentId
     */
    public String getDefaultPaymentId() {
        return defaultPaymentId;
    }

    /**
     *
     * @param defaultPaymentId
     * The default_payment_id
     */
    public void setDefaultPaymentId(String defaultPaymentId) {
        this.defaultPaymentId = defaultPaymentId;
    }

    /**
     *
     * @return
     * The eventPhoto
     */
    public String getEventPhoto() {
        return eventPhoto;
    }

    /**
     *
     * @param eventPhoto
     * The event_photo
     */
    public void setEventPhoto(String eventPhoto) {
        this.eventPhoto = eventPhoto;
    }

    /**
     *
     * @return
     * The state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     * The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     * The submitAt
     */
    public Object getSubmitAt() {
        return submitAt;
    }

    /**
     *
     * @param submitAt
     * The submit_at
     */
    public void setSubmitAt(Object submitAt) {
        this.submitAt = submitAt;
    }

}
