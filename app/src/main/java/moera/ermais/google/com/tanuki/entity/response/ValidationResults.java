package moera.ermais.google.com.tanuki.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * "ValidationResults":{
 * "Result":1
 * },
 * "ValidationResults":{
 * "Result":0,
 * "Errors":[
 * {
 * "Code":<ERROR CODE>,
 * "Message":<ERROR MESSAGE>
 * }
 * ]
 * }
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ValidationResults {
    int result;
    Error[] errors;
}
