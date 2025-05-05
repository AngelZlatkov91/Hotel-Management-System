package Gateway.validation.Gateway.validation.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
@Configuration
public class RestApiUrl {

    @Bean
    public RestClient restClient (ApiUrl apiUrl) {
        return RestClient.builder()
                .baseUrl(apiUrl.getApiUrl())
                .defaultHeader("Content-type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

}
