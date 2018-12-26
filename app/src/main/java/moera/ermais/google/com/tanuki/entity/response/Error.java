package moera.ermais.google.com.tanuki.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * {
 * "Code":<ERROR CODE>,
 * "Message":<ERROR MESSAGE>
 * }
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Error {
    String Code;
    String message;
}
