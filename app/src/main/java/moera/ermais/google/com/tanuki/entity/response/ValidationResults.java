
package moera.ermais.google.com.tanuki.entity.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ValidationResults {

    @SerializedName("Result")
    @Expose
    private Boolean result;
    @SerializedName("Errors")
    @Expose
    private List<Error> errors = null;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

}
