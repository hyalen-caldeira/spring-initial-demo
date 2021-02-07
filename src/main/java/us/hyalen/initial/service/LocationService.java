package us.hyalen.initial.service;

import org.springframework.stereotype.Service;
import us.hyalen.initial.entity.Location;

import java.util.List;

@Service
public interface LocationService {
    List<Location> retrieveLocations();
    List<String> findAllNames();
    List<String> findAllAddresses();
    Location getLocationById(long id);
    String getNameById(Long id);
}