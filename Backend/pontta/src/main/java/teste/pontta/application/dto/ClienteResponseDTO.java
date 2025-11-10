package teste.pontta.application.dto;

import teste.pontta.domain.model.Cliente;

public class ClienteResponseDTO {

    private Long id;

    private String nome;

    private String email;

    public ClienteResponseDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public ClienteResponseDTO(Cliente salvo) {

        this.id = salvo.getId();
        this.nome = salvo.getNome();
        this.email = salvo.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
