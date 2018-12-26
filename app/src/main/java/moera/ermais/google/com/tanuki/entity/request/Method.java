package moera.ermais.google.com.tanuki.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * "name": "makeOrder",
 * "mode": "getData",
 * "mtime": 0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Method {
    String name = "makeOrder";
    String mode = "getData";
    int mtime = 0;


}
