package moera.ermais.google.com.tanuki.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * "header": {
 * "version": "2.0",
 * //значение не меняется
 * "userId": <UDID>,
 * "debugMode": true,
 * "agent": {
 * "device":”desktop”,
 * "version":”Chromium 68.0.3440.75”
 * }
 * }
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Header {
    String version= "2.0";
    String userId;
    boolean  debugMode= true;
    Agent agent;


}
