
package com.example.albertsons.datamodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Var implements Parcelable
{

    @SerializedName("lf")
    @Expose
    private String lf;
    @SerializedName("freq")
    @Expose
    private Integer freq;
    @SerializedName("since")
    @Expose
    private Integer since;
    public final static Creator<Var> CREATOR = new Creator<Var>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Var createFromParcel(Parcel in) {
            return new Var(in);
        }

        public Var[] newArray(int size) {
            return (new Var[size]);
        }

    }
    ;

    protected Var(Parcel in) {
        this.lf = ((String) in.readValue((String.class.getClassLoader())));
        this.freq = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.since = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Var() {
    }

    /**
     * 
     * @param freq
     * @param lf
     * @param since
     */
    public Var(String lf, Integer freq, Integer since) {
        super();
        this.lf = lf;
        this.freq = freq;
        this.since = since;
    }

    public String getLf() {
        return lf;
    }

    public void setLf(String lf) {
        this.lf = lf;
    }

    public Integer getFreq() {
        return freq;
    }

    public void setFreq(Integer freq) {
        this.freq = freq;
    }

    public Integer getSince() {
        return since;
    }

    public void setSince(Integer since) {
        this.since = since;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(lf);
        dest.writeValue(freq);
        dest.writeValue(since);
    }

    public int describeContents() {
        return  0;
    }

}
