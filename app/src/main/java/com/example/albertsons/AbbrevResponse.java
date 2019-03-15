
package com.example.albertsons;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AbbrevResponse implements Parcelable
{

    @SerializedName("sf")
    @Expose
    private String sf;
    @SerializedName("lfs")
    @Expose
    private List<Lf> lfs = null;
    public final static Creator<AbbrevResponse> CREATOR = new Creator<AbbrevResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AbbrevResponse createFromParcel(Parcel in) {
            return new AbbrevResponse(in);
        }

        public AbbrevResponse[] newArray(int size) {
            return (new AbbrevResponse[size]);
        }

    }
    ;

    protected AbbrevResponse(Parcel in) {
        this.sf = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.lfs, (com.example.albertsons.Lf.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public AbbrevResponse() {
    }

    /**
     * 
     * @param lfs
     * @param sf
     */
    public AbbrevResponse(String sf, List<Lf> lfs) {
        super();
        this.sf = sf;
        this.lfs = lfs;
    }

    public String getSf() {
        return sf;
    }

    public void setSf(String sf) {
        this.sf = sf;
    }

    public List<Lf> getLfs() {
        return lfs;
    }

    public void setLfs(List<Lf> lfs) {
        this.lfs = lfs;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sf);
        dest.writeList(lfs);
    }

    public int describeContents() {
        return  0;
    }

}
