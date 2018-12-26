
package moera.ermais.google.com.tanuki.entity.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderInfo {

    @SerializedName("orderNumber")
    @Expose
    private Integer orderNumber;
    @SerializedName("messageTitle")
    @Expose
    private String messageTitle;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("creationDate")
    @Expose
    private String creationDate;
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("dateTitle")
    @Expose
    private String dateTitle;

    @SerializedName("orderStatus")
    @Expose
    private String orderStatus;
    @SerializedName("deliveryType")
    @Expose
    private String deliveryType;
    @SerializedName("type")
    @Expose
    private String type;

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDateTitle() {
        return dateTitle;
    }

    public void setDateTitle(String dateTitle) {
        this.dateTitle = dateTitle;
    }


    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
