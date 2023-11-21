package br.com.stockflowservice.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorModel {

    private HttpStatus status;
    private List<String> errors;

    public ApiErrorModel(HttpStatus status, String error) {
        super();
        this.status = status;
        errors = Collections.singletonList(error);
    }
}
