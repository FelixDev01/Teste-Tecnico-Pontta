package teste.pontta.application.dto;

import jakarta.validation.constraints.Email;

public class ClienteUpdateDTO {

    @Email(message = "Formato de email invalido")
    private String email;

    public ClienteUpdateDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
