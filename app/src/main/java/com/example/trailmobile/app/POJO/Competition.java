package com.example.trailmobile.app.POJO;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Competition {

    @SerializedName("competition_id")
    @Expose
    private Integer competitionId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("init_date")
    @Expose
    private String initDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("total_distance")
    @Expose
    private String totalDistance;
    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("color_code")
    @Expose
    private String colorCode;
    @SerializedName("kml_file_name")
    @Expose
    private String kmlFileName;
    @SerializedName("trail_event_trail_event_id")
    @Expose
    private Integer trailEventTrailEventId;
    @SerializedName("long_name")
    @Expose
    private String longName;
    @SerializedName("max_inscriptions")
    @Expose
    private Integer maxInscriptions;

    /**
     *
     * @return
     * The competitionId
     */
    public Integer getCompetitionId() {
        return competitionId;
    }

    /**
     *
     * @param competitionId
     * The competition_id
     */
    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
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
     * The totalDistance
     */
    public String getTotalDistance() {
        return totalDistance;
    }

    /**
     *
     * @param totalDistance
     * The total_distance
     */
    public void setTotalDistance(String totalDistance) {
        this.totalDistance = totalDistance;
    }

    /**
     *
     * @return
     * The active
     */
    public Integer getActive() {
        return active;
    }

    /**
     *
     * @param active
     * The active
     */
    public void setActive(Integer active) {
        this.active = active;
    }

    /**
     *
     * @return
     * The colorCode
     */
    public String getColorCode() {
        return colorCode;
    }

    /**
     *
     * @param colorCode
     * The color_code
     */
    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    /**
     *
     * @return
     * The kmlFileName
     */
    public String getKmlFileName() {
        return kmlFileName;
    }

    /**
     *
     * @param kmlFileName
     * The kml_file_name
     */
    public void setKmlFileName(String kmlFileName) {
        this.kmlFileName = kmlFileName;
    }

    /**
     *
     * @return
     * The trailEventTrailEventId
     */
    public Integer getTrailEventTrailEventId() {
        return trailEventTrailEventId;
    }

    /**
     *
     * @param trailEventTrailEventId
     * The trail_event_trail_event_id
     */
    public void setTrailEventTrailEventId(Integer trailEventTrailEventId) {
        this.trailEventTrailEventId = trailEventTrailEventId;
    }

    /**
     *
     * @return
     * The longName
     */
    public String getLongName() {
        return longName;
    }

    /**
     *
     * @param longName
     * The long_name
     */
    public void setLongName(String longName) {
        this.longName = longName;
    }

    /**
     *
     * @return
     * The maxInscriptions
     */
    public Integer getMaxInscriptions() {
        return maxInscriptions;
    }

    /**
     *
     * @param maxInscriptions
     * The max_inscriptions
     */
    public void setMaxInscriptions(Integer maxInscriptions) {
        this.maxInscriptions = maxInscriptions;
    }

}