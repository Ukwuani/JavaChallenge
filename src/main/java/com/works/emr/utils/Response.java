package com.works.emr.utils;

public class Response {
    private String message;
    public Response(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
}

// class PaginatedResponse {
//     List<PatientEntity> patients;
//     int fetchedItems;
//     Long total;
//     PaginatedResponse(List<PatientEntity> patients, int fetchedItems, Long total) {
//         this.patients = patients;
//         this.fetchedItems = fetchedItems;
//         this.total = total;
//     }
// }
