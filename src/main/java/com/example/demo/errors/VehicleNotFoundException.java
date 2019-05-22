package com.example.demo.errors;

public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException() {}

    public VehicleNotFoundException(Long vehicleId ) {
        super("Vehicle: " +vehicleId +" not found.");
    }
}
