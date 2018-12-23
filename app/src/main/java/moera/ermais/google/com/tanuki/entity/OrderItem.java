package moera.ermais.google.com.tanuki.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
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
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItem {
    int amount;
    String itemId = "9";
    int price = 110;


}
