package website.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import website.model.User;
import website.model.UserRequest;

@Component
public class UserClient {
    private final String baseUrl;
    private final String createPath;
    private final String getPath;
    private final RestTemplate restTemplate;

    public UserClient(
            @Value("${user-service.hostname}") String hostname,
            @Value("${user-service.context-path}") String contextPath,
            @Value("${user-service.create-path}") String createPath,
            @Value("${user-service.get-path}") String getPath,
            RestTemplate restTemplate) {
        this.baseUrl = hostname + contextPath;
        this.createPath = createPath;
        this.getPath = getPath;
        this.restTemplate = restTemplate;
    }

    public User createUser(final UserRequest userRequest) {
        return restTemplate.exchange(
                RequestEntity
                        .post(UriComponentsBuilder.fromHttpUrl(baseUrl).path(createPath).build().toUri())
                        .body(userRequest), User.class
        ).getBody();
    }

    public User getUser(final String id) {
        return restTemplate.exchange(
                RequestEntity
                        .get(UriComponentsBuilder.fromHttpUrl(baseUrl).path(getPath).queryParam("id", id).build().toUri())
                        .build(),User.class)
                .getBody();
    }

    public User getUser(final UserRequest userRequest) {
        return restTemplate.exchange(
                RequestEntity
                        .post(UriComponentsBuilder.fromHttpUrl(baseUrl).path(getPath).build().toUri())
                        .body(userRequest), User.class
        ).getBody();
    }
}
