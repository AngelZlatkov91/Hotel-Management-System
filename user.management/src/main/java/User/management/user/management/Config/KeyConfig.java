package User.management.user.management.Config;

import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeyConfig {

    @Bean
    public RSAKey rsaKey() {
        return Jwks.generateRsa();
    }
}
