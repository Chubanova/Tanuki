package moera.ermais.google.com.tanuki.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * "Result":{
 * "code":0,
 * "message":"makeOrder"
 * }
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Result {
    int code = 0;
    String message = "makeOrder";
}
