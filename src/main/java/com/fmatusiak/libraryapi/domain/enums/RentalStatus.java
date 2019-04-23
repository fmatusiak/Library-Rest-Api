package com.fmatusiak.libraryapi.domain.enums;

public enum RentalStatus {
    AVAILABLE("available"), RENTED("rented");

    private String status;

    RentalStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

