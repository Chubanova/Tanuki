package moera.ermais.google.com.tanuki.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * "OrderInfo":{
 * "orderNumber":<НОМЕР ЗАКАЗА>,
 * "messageTitle":<НОМЕР ЗАКАЗА>,
 * "message":<СООБЩЕНИЕ>,
 * "creationDate":<ДАТА СОЗДАНИЯ(unix timestamp)>
 * }
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderInfo {
   int orderNumber;
   String messageTitle;
   String message;
   String creationDate;

}
