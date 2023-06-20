package helpers;

import java.security.SecureRandom;
import java.util.Base64;

public class Helper {

    public static String gerarHash() {
        byte[] randomBytes = new byte[7];

        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(randomBytes);

        String hash = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);

        if (hash.length() > 10) {
            hash = hash.substring(0, 10);
        }

        return hash;
    }
}
