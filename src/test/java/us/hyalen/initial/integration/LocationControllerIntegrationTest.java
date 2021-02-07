package us.hyalen.initial.integration;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import us.hyalen.initial.entity.Location;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
// The @SpringBootTest annotation is useful for integration testing and is chosen over @WebMvcTest
// because @SpringBootTest starts the full application context (including the server) and does not customize
// component scanning at all.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LocationControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllLocations() {
        ResponseEntity<List> response =
                this.restTemplate.getForEntity("http://localhost:" + port + "/locations/", List.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getLocationById() {
        ResponseEntity<Location> response =
                this.restTemplate.getForEntity("http://localhost:" + port + "/locations/1", Location.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
