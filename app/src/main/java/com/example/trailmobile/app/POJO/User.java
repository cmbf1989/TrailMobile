package com.example.trailmobile.app.POJO;

/**
 * Created by utilizador on 06/08/2016.
 */

import com.google.gson.annotations.SerializedName;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("athlete_id")
    @Expose
    private String athleteId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("nacionality")
    @Expose
    private String nacionality;
    @SerializedName("regional")
    @Expose
    private Integer regional;
    @SerializedName("language")
    @Expose
    private Object language;
    @SerializedName("identification_type")
    @Expose
    private Object identificationType;
    @SerializedName("identification_id")
    @Expose
    private String identificationId;
    @SerializedName("phone_number1")
    @Expose
    private String phoneNumber1;
    @SerializedName("phone_number2")
    @Expose
    private String phoneNumber2;
    @SerializedName("phone_number3")
    @Expose
    private String phoneNumber3;
    @SerializedName("postal_code")
    @Expose
    private String postalCode;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("previous_participated_events")
    @Expose
    private Object previousParticipatedEvents;
    @SerializedName("nif")
    @Expose
    private String nif;
    @SerializedName("atrp_number")
    @Expose
    private Object atrpNumber;
    @SerializedName("raking_name")
    @Expose
    private String rakingName;
    @SerializedName("extra_info")
    @Expose
    private Object extraInfo;
    @SerializedName("previous_participated_event")
    @Expose
    private Object previousParticipatedEvent;
    @SerializedName("previous_participated_event_link")
    @Expose
    private Object previousParticipatedEventLink;
    @SerializedName("extra_info2")
    @Expose
    private Object extraInfo2;
    @SerializedName("raking_name_last")
    @Expose
    private String rakingNameLast;
    @SerializedName("fcmp_number")
    @Expose
    private String fcmpNumber;
    @SerializedName("name_phone_number3")
    @Expose
    private Object namePhoneNumber3;

    /**
     *
     * @return
     * The athleteId
     */
    public String getAthleteId() {
        return athleteId;
    }

    /**
     *
     * @param athleteId
     * The athlete_id
     */
    public void setAthleteId(String athleteId) {
        this.athleteId = athleteId;
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
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     *
     * @param birthday
     * The birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     *
     * @return
     * The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     * The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     * The nacionality
     */
    public String getNacionality() {
        return nacionality;
    }

    /**
     *
     * @param nacionality
     * The nacionality
     */
    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    /**
     *
     * @return
     * The regional
     */
    public Integer getRegional() {
        return regional;
    }

    /**
     *
     * @param regional
     * The regional
     */
    public void setRegional(Integer regional) {
        this.regional = regional;
    }

    /**
     *
     * @return
     * The language
     */
    public Object getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     * The language
     */
    public void setLanguage(Object language) {
        this.language = language;
    }

    /**
     *
     * @return
     * The identificationType
     */
    public Object getIdentificationType() {
        return identificationType;
    }

    /**
     *
     * @param identificationType
     * The identification_type
     */
    public void setIdentificationType(Object identificationType) {
        this.identificationType = identificationType;
    }

    /**
     *
     * @return
     * The identificationId
     */
    public String getIdentificationId() {
        return identificationId;
    }

    /**
     *
     * @param identificationId
     * The identification_id
     */
    public void setIdentificationId(String identificationId) {
        this.identificationId = identificationId;
    }

    /**
     *
     * @return
     * The phoneNumber1
     */
    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    /**
     *
     * @param phoneNumber1
     * The phone_number1
     */
    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    /**
     *
     * @return
     * The phoneNumber2
     */
    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    /**
     *
     * @param phoneNumber2
     * The phone_number2
     */
    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    /**
     *
     * @return
     * The phoneNumber3
     */
    public String getPhoneNumber3() {
        return phoneNumber3;
    }

    /**
     *
     * @param phoneNumber3
     * The phone_number3
     */
    public void setPhoneNumber3(String phoneNumber3) {
        this.phoneNumber3 = phoneNumber3;
    }

    /**
     *
     * @return
     * The postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     *
     * @param postalCode
     * The postal_code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     *
     * @return
     * The address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     * The previousParticipatedEvents
     */
    public Object getPreviousParticipatedEvents() {
        return previousParticipatedEvents;
    }

    /**
     *
     * @param previousParticipatedEvents
     * The previous_participated_events
     */
    public void setPreviousParticipatedEvents(Object previousParticipatedEvents) {
        this.previousParticipatedEvents = previousParticipatedEvents;
    }

    /**
     *
     * @return
     * The nif
     */
    public String getNif() {
        return nif;
    }

    /**
     *
     * @param nif
     * The nif
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     *
     * @return
     * The atrpNumber
     */
    public Object getAtrpNumber() {
        return atrpNumber;
    }

    /**
     *
     * @param atrpNumber
     * The atrp_number
     */
    public void setAtrpNumber(Object atrpNumber) {
        this.atrpNumber = atrpNumber;
    }

    /**
     *
     * @return
     * The rakingName
     */
    public String getRakingName() {
        return rakingName;
    }

    /**
     *
     * @param rakingName
     * The raking_name
     */
    public void setRakingName(String rakingName) {
        this.rakingName = rakingName;
    }

    /**
     *
     * @return
     * The extraInfo
     */
    public Object getExtraInfo() {
        return extraInfo;
    }

    /**
     *
     * @param extraInfo
     * The extra_info
     */
    public void setExtraInfo(Object extraInfo) {
        this.extraInfo = extraInfo;
    }

    /**
     *
     * @return
     * The previousParticipatedEvent
     */
    public Object getPreviousParticipatedEvent() {
        return previousParticipatedEvent;
    }

    /**
     *
     * @param previousParticipatedEvent
     * The previous_participated_event
     */
    public void setPreviousParticipatedEvent(Object previousParticipatedEvent) {
        this.previousParticipatedEvent = previousParticipatedEvent;
    }

    /**
     *
     * @return
     * The previousParticipatedEventLink
     */
    public Object getPreviousParticipatedEventLink() {
        return previousParticipatedEventLink;
    }

    /**
     *
     * @param previousParticipatedEventLink
     * The previous_participated_event_link
     */
    public void setPreviousParticipatedEventLink(Object previousParticipatedEventLink) {
        this.previousParticipatedEventLink = previousParticipatedEventLink;
    }

    /**
     *
     * @return
     * The extraInfo2
     */
    public Object getExtraInfo2() {
        return extraInfo2;
    }

    /**
     *
     * @param extraInfo2
     * The extra_info2
     */
    public void setExtraInfo2(Object extraInfo2) {
        this.extraInfo2 = extraInfo2;
    }

    /**
     *
     * @return
     * The rakingNameLast
     */
    public String getRakingNameLast() {
        return rakingNameLast;
    }

    /**
     *
     * @param rakingNameLast
     * The raking_name_last
     */
    public void setRakingNameLast(String rakingNameLast) {
        this.rakingNameLast = rakingNameLast;
    }

    /**
     *
     * @return
     * The fcmpNumber
     */
    public String getFcmpNumber() {
        return fcmpNumber;
    }

    /**
     *
     * @param fcmpNumber
     * The fcmp_number
     */
    public void setFcmpNumber(String fcmpNumber) {
        this.fcmpNumber = fcmpNumber;
    }

    /**
     *
     * @return
     * The namePhoneNumber3
     */
    public Object getNamePhoneNumber3() {
        return namePhoneNumber3;
    }

    /**
     *
     * @param namePhoneNumber3
     * The name_phone_number3
     */
    public void setNamePhoneNumber3(Object namePhoneNumber3) {
        this.namePhoneNumber3 = namePhoneNumber3;
    }

}
