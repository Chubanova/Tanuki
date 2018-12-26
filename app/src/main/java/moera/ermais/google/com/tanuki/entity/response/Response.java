package moera.ermais.google.com.tanuki.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *  "method":"makeOrder",
 "Result":{
 "code":0,
 "message":"makeOrder"
 }
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Response {
    String method = "makeOrder";
    Result result;
}
