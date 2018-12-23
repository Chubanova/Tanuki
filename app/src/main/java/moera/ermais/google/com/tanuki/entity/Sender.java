package moera.ermais.google.com.tanuki.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * "sender": {
 * "name": <ИМЯ>,
 * "phone": <ТЕЛЕФОН>
 * }
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sender {
    String name;
    String phone;

}
