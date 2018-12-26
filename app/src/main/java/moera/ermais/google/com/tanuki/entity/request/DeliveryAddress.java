package moera.ermais.google.com.tanuki.entity.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryAddress {

    @SerializedName("cityId")
    @Expose
    private String cityId;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("house")
    @Expose
    private String house;
    @SerializedName("apartment")
    @Expose
    private String apartment;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

}