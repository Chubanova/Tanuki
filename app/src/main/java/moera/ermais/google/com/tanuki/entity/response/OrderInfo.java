
package moera.ermais.google.com.tanuki.entity.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderInfo {

    @SerializedName("orderNumber")
    @Expose
    private Integer orderNumber;
    @SerializedName("messageTitle")
    @Expose
    private Integer messageTitle;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("creationDate")
    @Expose
    private String creationDate;

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(Integer messageTitle) {
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

}
