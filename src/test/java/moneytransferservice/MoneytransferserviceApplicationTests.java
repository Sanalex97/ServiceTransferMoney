package moneytransferservice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MoneytransferserviceApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;

    @Container
    private static final GenericContainer<?> backend = new GenericContainer<>("mymoneytransfer:1.0")
            .withExposedPorts(8080);

    @Container
    private static final GenericContainer<?> frontend = new GenericContainer<>("front:latest")
            .withExposedPorts(3000).dependsOn(backend);

    @BeforeAll
    public static void setUp() {
        backend.start();
        frontend.start();
    }

    @Test
    void contextLoads() {
        ResponseEntity<String> backendEntity = restTemplate.getForEntity("http://localhost:" +
                backend.getMappedPort(8080) + "/transfer", String.class);
        System.out.println(backendEntity.getBody());

        ResponseEntity<String> frontEntity = restTemplate.getForEntity("http://localhost:" +
                frontend.getMappedPort(3000) + "/transfer", String.class);
        System.out.println(frontEntity.getBody());
    }

}
