package us.hyalen.initial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.hyalen.initial.Exception.LocationNameNotFoundException;
import us.hyalen.initial.entity.Location;
import us.hyalen.initial.repository.LocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<Location> retrieveLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    @Override
    public List<String> findAllNames() {
        return locationRepository.findAllNames();
    }

    @Override
    public List<String> findAllAddresses() {
        return locationRepository.findAllAddresses();
    }

    @Override
    public Location getLocationById(long id) {
        Optional<Location> optionalLocation = locationRepository.findById(id);

        if(optionalLocation.isPresent())
            return optionalLocation.get();
        else
            throw new RuntimeException();
    }


    @Override
    public String getNameById(Long id) {
        Optional<String> optionalName = Optional.ofNullable(locationRepository.findNameById(id));
        String name = optionalName.orElseThrow(LocationNameNotFoundException::new);
        return name;
    }
}