package Gateway.validation.Gateway.validation.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api.baseurl")
public class ApiUrl {

    private String apiUrl;
    public String getApiUrl() {
        return apiUrl;
    }

    public ApiUrl setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
        return this;
    }
}
