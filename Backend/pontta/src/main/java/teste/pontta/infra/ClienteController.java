package teste.pontta.infra;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.pontta.application.dto.ClienteRequestDTO;
import teste.pontta.application.dto.ClienteResponseDTO;
import teste.pontta.application.dto.ClienteUpdateDTO;
import teste.pontta.application.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

   @PostMapping
   public ResponseEntity<ClienteResponseDTO> criar(@RequestBody @Valid ClienteRequestDTO dto){
        ClienteResponseDTO clienteCriado = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
   }

   @GetMapping
    public ResponseEntity<Page<ClienteResponseDTO>> listarTodos(Pageable pageable){
        Page<ClienteResponseDTO> listaDeClientes = service.listarTodos(pageable);
        return ResponseEntity.ok(listaDeClientes);
   }

   @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> encontrarPorId(@PathVariable Long id){
        ClienteResponseDTO clienteEncontrado = service.encontrarPorId(id);
        return ResponseEntity.ok(clienteEncontrado);
   }

   @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteUpdateDTO dto){
        ClienteResponseDTO clienteAtualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(clienteAtualizado);
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
   }

}
