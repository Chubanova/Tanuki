package moera.ermais.google.com.tanuki.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * "data": {
 * "deliveryType": "deliveryTypeRegular",
 * //значение не меняется
 * "comments": <КОММЕНТАРИЙ>,
 * "orderItems": [
 * {
 * "amount": <КОЛ-ВО
 * ТОВАРОВ>,
 * "itemId": "9",
 * //значение не меняется
 * "price": 110
 * //значение не меняется
 * }
 * ],
 * "persons": <КОЛ-ВО ПЕРСОН>,
 * "paymentMethod": <СПОСОБ ОПЛАТЫ>,  // (payment_encash - Наличными, payment_card_restaurant - Картой курьеру)
 * "notificationType": "СМС оповещение", //значение не меняется
 * "deliveryAddress": {
 * "cityId": "1",
 * //значение не меняется
 * "street": <УЛИЦА>,
 * "house": <ДОМ>,
 * "apartment": <КВАРТИРА>
 * },
 * "sender": {
 * "name": <ИМЯ>,
 * "phone": <ТЕЛЕФОН>
 * }
 * }
 * <p>
 * "data": {
 * "comments": "Комментарий",
 * "deliveryAddress": {
 * "apartment": "52",
 * "cityId": "1",
 * "house": "6",
 * "street": "Буракова"
 * },
 * "dateToDeliver": "20180824164119",
 * "deliveryType": "deliveryTypeRegular",
 * "notificationType": "СМС оповещение",
 * "orderItems": [
 * {
 * "amount": 4,
 * "itemId": "9",
 * "price": 110
 * }
 * ],
 * "paymentMethod": "payment_encash",
 * "persons": 2,
 * "sender": {
 * "name": "Михаил",
 * "phone": "+7 (903) 539-32-11"
 * }
 * }
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Data {
    String deliveryType = "deliveryTypeRegular";
    String dateToDeliver;
    String comments;
    int persons;
    String paymentMethod;
    String notificationType = "СМС оповещение";
    OrderItem[] orderItems;
    DeliveryAddress deliveryAddress;
    Sender sender;
}
