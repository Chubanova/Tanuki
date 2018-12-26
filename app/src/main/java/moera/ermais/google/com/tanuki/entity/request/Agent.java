package moera.ermais.google.com.tanuki.entity.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Agent {

    @SerializedName("device")
    @Expose
    private String device;
    @SerializedName("version")
    @Expose
    private String version;

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}