package us.hyalen.initial.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import us.hyalen.initial.service.AuthenticationService;
import us.hyalen.initial.service.LocationService;
import us.hyalen.initial.web.LocationController;

@ActiveProfiles({"test"})
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = LocationController.class)
// @WebMvcTest(controllers = LocationController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class LocationControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    LocationService locationService;

    @MockBean
    AuthenticationService authenticationService;

    @Test
    public void getAllLocations() throws Exception {
        mockMvc.perform(get("/locations/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(locationService, times(1)).retrieveLocations();
    }

    @Test
    public void getLocation() throws Exception {
        mockMvc.perform(get("/locations/1"))
                .andExpect(status().isOk());

        verify(locationService, times(1)).getLocationById(1);
    }
}
