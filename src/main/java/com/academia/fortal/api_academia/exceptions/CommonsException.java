package com.academia.fortal.api_academia.exceptions;

import com.academia.fortal.api_academia.domain.dto.MessageDTO;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class CommonsException extends RuntimeException {

    private static final long serialVersionUID = -4694258578216919456L;

    protected HttpStatus status;
    protected String key;
    protected String text;

    public ResponseEntity<MessageDTO> getMessageError() {
        return ResponseEntity.status(status).body(new MessageDTO(text, key));
    }
}
