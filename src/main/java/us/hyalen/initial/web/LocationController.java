package us.hyalen.initial.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.hyalen.initial.entity.Location;
import us.hyalen.initial.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private LocationService locationService;

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping()
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> list = locationService.retrieveLocations();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        Location location = locationService.getLocationById(id);

        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllNames() {
        List<String> list = locationService.findAllNames();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<String>> getAllAddresses() {
        List<String> list = locationService.findAllAddresses();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}/name")
    public ResponseEntity<String> getNameById(@PathVariable Long id) {
        String name = locationService.getNameById(id);

        return new ResponseEntity<>(name, HttpStatus.OK);
    }
}