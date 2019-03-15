
package com.example.albertsons;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lf implements Parcelable
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
    @SerializedName("vars")
    @Expose
    private List<Var> vars = null;
    public final static Creator<Lf> CREATOR = new Creator<Lf>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Lf createFromParcel(Parcel in) {
            return new Lf(in);
        }

        public Lf[] newArray(int size) {
            return (new Lf[size]);
        }

    }
    ;

    protected Lf(Parcel in) {
        this.lf = ((String) in.readValue((String.class.getClassLoader())));
        this.freq = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.since = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.vars, (com.example.albertsons.Var.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Lf() {
    }

    /**
     * 
     * @param vars
     * @param freq
     * @param lf
     * @param since
     */
    public Lf(String lf, Integer freq, Integer since, List<Var> vars) {
        super();
        this.lf = lf;
        this.freq = freq;
        this.since = since;
        this.vars = vars;
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

    public List<Var> getVars() {
        return vars;
    }

    public void setVars(List<Var> vars) {
        this.vars = vars;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(lf);
        dest.writeValue(freq);
        dest.writeValue(since);
        dest.writeList(vars);
    }

    public int describeContents() {
        return  0;
    }

}
