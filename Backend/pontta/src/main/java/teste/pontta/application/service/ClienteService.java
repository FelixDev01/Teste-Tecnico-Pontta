package teste.pontta.application.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teste.pontta.application.dto.ClienteRequestDTO;
import teste.pontta.application.dto.ClienteResponseDTO;
import teste.pontta.application.dto.ClienteUpdateDTO;
import teste.pontta.application.exception.ClienteNotFound;
import teste.pontta.domain.model.Cliente;
import teste.pontta.domain.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ClienteResponseDTO criar(ClienteRequestDTO dto){
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());

        Cliente salvo = repository.save(cliente);
        return new ClienteResponseDTO(salvo);
    }

    public Page<ClienteResponseDTO> listarTodos(Pageable pageable){
        return repository.findAll(pageable).map(ClienteResponseDTO::new);
    }

    public ClienteResponseDTO encontrarPorId(Long id){
        Cliente cliente = repository.findById(id)
                .orElseThrow(()-> new ClienteNotFound(id));
        return new ClienteResponseDTO(cliente);
    }

    @Transactional
    public ClienteResponseDTO atualizar(Long id, ClienteUpdateDTO dto){
        Cliente cliente = repository.findById(id)
                .orElseThrow(()-> new ClienteNotFound(id));
        cliente.setEmail(dto.getEmail());
        Cliente atualizado = repository.save(cliente);
        return new ClienteResponseDTO(atualizado);
    }

    @Transactional
    public void deletar(Long id){
        Cliente cliente = repository.findById(id)
                .orElseThrow(()-> new ClienteNotFound(id));
        repository.delete(cliente);
    }
}
