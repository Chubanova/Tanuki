package moera.ermais.google.com.tanuki.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * "deliveryAddress": {
 * "cityId": "1",
 * //значение не меняется
 * "street": <УЛИЦА>,
 * "house": <ДОМ>,
 * "apartment": <КВАРТИРА>
 * },
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeliveryAddress {
    String cityId = "1";
    String street;
    String house;
    String apartment;


}
