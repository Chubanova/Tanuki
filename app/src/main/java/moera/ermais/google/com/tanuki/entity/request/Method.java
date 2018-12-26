package moera.ermais.google.com.tanuki.entity.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Method {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("mtime")
    @Expose
    private Integer mtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getMtime() {
        return mtime;
    }

    public void setMtime(Integer mtime) {
        this.mtime = mtime;
    }

}
