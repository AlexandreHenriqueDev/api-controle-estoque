package br.com.treinamento.backend.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse implements Serializable {

    private final static long serialVersionUID = -5792044812871535594L;

    private Date timestamp;
    private String message;
    private String details;

}
