package br.senai.lab365.fshealth.pokedex.exceptions;

import br.senai.lab365.fshealth.pokedex.exceptions.dtos.ErroResponse;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    private static final Logger LOGGER = LogManager.getLogger(TratadorDeErros.class);

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> trataEntidadeNaoEncontrada() {
        LOGGER.error("Entidade não encontrada.");
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ErroResponse> trataChaveDuplicada(DuplicateKeyException exception) {
        ErroResponse erro = new ErroResponse("numero", exception.getMessage());

        LOGGER.error("Chave duplicada: {}", exception.getMessage(), exception);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroResponse>> trataErroValidacao(MethodArgumentNotValidException exception) {
        List<ErroResponse> responseList = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(ErroResponse::new)
                .collect(Collectors.toList());

        responseList.forEach(
                errorResponse -> LOGGER.warn("Campo obrigatório faltando: {}", errorResponse.getCampo()));

        return ResponseEntity.badRequest().body(responseList);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResponse> trataEnumInvalido(HttpMessageNotReadableException exception) {
        ErroResponse response = new ErroResponse("tipo", exception.getLocalizedMessage());

        LOGGER.error("Erro ao ler a mensagem: {}", exception.getLocalizedMessage(), exception);

        return ResponseEntity.badRequest().body(response);
    }
}
