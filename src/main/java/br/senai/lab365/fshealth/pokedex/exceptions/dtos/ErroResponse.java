package br.senai.lab365.fshealth.pokedex.exceptions.dtos;

import org.springframework.validation.FieldError;

/**
 * Representa a resposta de erro para validações e outros erros.
 */
public class ErroResponse {

    private String campo;
    private String mensagem;

    public ErroResponse() {}

    /**
     * Construtor que inicializa a partir de um FieldError.
     * @param fieldError O objeto FieldError com detalhes do erro de validação.
     */
    public ErroResponse(FieldError fieldError) {
        this.campo = fieldError.getField();
        this.mensagem = fieldError.getDefaultMessage();
    }

    /**
     * Construtor que inicializa diretamente campo e mensagem.
     * @param campo O nome do campo que gerou o erro.
     * @param mensagem A mensagem de erro.
     */
    public ErroResponse(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "ErroResponse{" +
                "campo='" + campo + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
