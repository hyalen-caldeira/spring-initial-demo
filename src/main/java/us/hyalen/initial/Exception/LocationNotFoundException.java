package us.hyalen.initial.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Location not found")
public class LocationNotFoundException extends RuntimeException {
    private Map<String, Object> extensions = new HashMap<>();

    public LocationNotFoundException(String message, Long invalidLocationId) {
        super(message);
        extensions.put("invalidLocationId", invalidLocationId);
    }
}