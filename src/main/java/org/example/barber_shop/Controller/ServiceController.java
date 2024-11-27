package org.example.barber_shop.Controller;

import lombok.RequiredArgsConstructor;
import org.example.barber_shop.DTO.ApiResponse;
import org.example.barber_shop.DTO.Service.ServiceRequest;
import org.example.barber_shop.Service.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController()
@RequestMapping("/api/service")
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceService serviceService;

    @PostMapping(value = "/add-service", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<?> addService(@ModelAttribute ServiceRequest serviceRequest) throws IOException {
        return new ApiResponse<>(
                HttpStatus.CREATED.value(), "SERVICE CREATED", serviceService.addService(serviceRequest)
        );
    }

    @GetMapping("/get-all-services")
    public ApiResponse<?> getAllServices() {
        return new ApiResponse<>(
                HttpStatus.OK.value(), "SERVICES", serviceService.getAllServices()
        );
    }
}
