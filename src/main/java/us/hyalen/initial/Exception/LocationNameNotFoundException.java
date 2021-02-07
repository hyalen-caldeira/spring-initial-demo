package us.hyalen.initial.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Location name not found")
public class LocationNameNotFoundException extends RuntimeException {
    public LocationNameNotFoundException() {
    }

    public LocationNameNotFoundException(String message) {
        super(message);
    }
}