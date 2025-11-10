package teste.pontta.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.pontta.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
