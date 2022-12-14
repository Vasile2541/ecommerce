package com.java.ecommerce.exceptions.errorModel;


import lombok.*;

// ApiValidationError is a class that extends ApiSubError and expresses validation problems encountered during the REST call.


@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
class ApiValidationError extends ApiSubError {
    //expresses validation problems encountered during the REST call.
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}