package com.example.trailmobile.app.POJO;

/**
 * Created by utilizador on 24/07/2016.
 */


        import java.util.ArrayList;
        import java.util.List;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;


public class JsonResponse <T>  {

    @SerializedName("result")
    @Expose
    private List<T> result = new ArrayList<T>();
    @SerializedName("error")
    @Expose
    private Boolean error;

    /**
     *
     * @return
     * The result
     */
    public List<T> getResult() {
        return result;
    }

    /**
     *
     * @param result
     * The result
     */
    public void setResult(List<T> result) {
        this.result = result;
    }

    /**
     *
     * @return
     * The error
     */
    public Boolean getError() {
        return error;
    }

    /**
     *
     * @param error
     * The error
     */
    public void setError(Boolean error) {
        this.error = error;
    }

}
