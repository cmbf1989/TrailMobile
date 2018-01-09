package com.example.trailmobile.app.POJO;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public  class  Result {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("event_id")
    @Expose
    private String eventId;
    @SerializedName("payment_id")
    @Expose
    private String paymentId;
    @SerializedName("extra_values")
    @Expose
    private String extraValues;
    @SerializedName("emergency_contact_name")
    @Expose
    private String emergencyContactName;
    @SerializedName("emergency_contact")
    @Expose
    private String emergencyContact;
    @SerializedName("inscription_start")
    @Expose
    private String inscriptionStart;
    @SerializedName("inscription_end")
    @Expose
    private String inscriptionEnd;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("checkin")
    @Expose
    private String checkin;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("birthdate")
    @Expose
    private String birthdate;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("identification_number")
    @Expose
    private String identificationNumber;
    @SerializedName("age_category")
    @Expose
    private String ageCategory;
    @SerializedName("certificate")
    @Expose
    private Object certificate;
    @SerializedName("event")
    @Expose
    private Event event;
    @SerializedName("payment")
    @Expose
    private Payment payment;
    @SerializedName("main_event")
    @Expose
    private Event mainEvent;

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
     * The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * The user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     * The eventId
     */
    public String getEventId() {
        return eventId;
    }

    /**
     *
     * @param eventId
     * The event_id
     */
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    /**
     *
     * @return
     * The paymentId
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     *
     * @param paymentId
     * The payment_id
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     *
     * @return
     * The extraValues
     */
    public String getExtraValues() {
        return extraValues;
    }

    /**
     *
     * @param extraValues
     * The extra_values
     */
    public void setExtraValues(String extraValues) {
        this.extraValues = extraValues;
    }

    /**
     *
     * @return
     * The emergencyContactName
     */
    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    /**
     *
     * @param emergencyContactName
     * The emergency_contact_name
     */
    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    /**
     *
     * @return
     * The emergencyContact
     */
    public String getEmergencyContact() {
        return emergencyContact;
    }

    /**
     *
     * @param emergencyContact
     * The emergency_contact
     */
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    /**
     *
     * @return
     * The inscriptionStart
     */
    public String getInscriptionStart() {
        return inscriptionStart;
    }

    /**
     *
     * @param inscriptionStart
     * The inscription_start
     */
    public void setInscriptionStart(String inscriptionStart) {
        this.inscriptionStart = inscriptionStart;
    }

    /**
     *
     * @return
     * The inscriptionEnd
     */
    public String getInscriptionEnd() {
        return inscriptionEnd;
    }

    /**
     *
     * @param inscriptionEnd
     * The inscription_end
     */
    public void setInscriptionEnd(String inscriptionEnd) {
        this.inscriptionEnd = inscriptionEnd;
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
     * The checkin
     */
    public String getCheckin() {
        return checkin;
    }

    /**
     *
     * @param checkin
     * The checkin
     */
    public void setCheckin(String checkin) {
        this.checkin = checkin;
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
     * The surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param surname
     * The surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *
     * @return
     * The birthdate
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     *
     * @param birthdate
     * The birthdate
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
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
     * The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     * The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     * The identificationNumber
     */
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     *
     * @param identificationNumber
     * The identification_number
     */
    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    /**
     *
     * @return
     * The ageCategory
     */
    public String getAgeCategory() {
        return ageCategory;
    }

    /**
     *
     * @param ageCategory
     * The age_category
     */
    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    /**
     *
     * @return
     * The certificate
     */
    public Object getCertificate() {
        return certificate;
    }

    /**
     *
     * @param certificate
     * The certificate
     */
    public void setCertificate(Object certificate) {
        this.certificate = certificate;
    }

    /**
     *
     * @return
     * The event
     */
    public Event getEvent() {
        return event;
    }

    /**
     *
     * @param event
     * The event
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     *
     * @return
     * The payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     *
     * @param payment
     * The payment
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     *
     * @return
     * The mainEvent
     */
    public Event getMainEvent() {
        return mainEvent;
    }

    /**
     *
     * @param mainEvent
     * The main_event
     */
    public void setMainEvent(Event mainEvent) {
        this.mainEvent = mainEvent;
    }

}
