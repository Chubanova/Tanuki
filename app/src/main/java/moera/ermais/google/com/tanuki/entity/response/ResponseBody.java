package moera.ermais.google.com.tanuki.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * "ResponseBody":{
 "ValidationResults":{
 "Result":1
 },
 "OrderInfo":{
 "orderNumber":<НОМЕР ЗАКАЗА>,
 "messageTitle":<НОМЕР ЗАКАЗА>,
 "message":<СООБЩЕНИЕ>,
 "creationDate":<ДАТА СОЗДАНИЯ(unix timestamp)>
 }
 }
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseBody {
    ValidationResults validationResults;
    OrderInfo orderInfo;

}
