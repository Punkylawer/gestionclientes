package com.example.gestionclientes.controller;

import com.example.gestionclientes.dto.ClienteRequestDTO;
import com.example.gestionclientes.dto.ClienteResponseDTO;
import com.example.gestionclientes.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // POST: Crear nuevo cliente
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> crearCliente(@Valid @RequestBody ClienteRequestDTO request) {
        ClienteResponseDTO creado = clienteService.crearCliente(request);
        return ResponseEntity.ok(creado);
    }

    // GET: Obtener todos los clientes - Agrego paginación limitando el listado.
    @GetMapping
    public ResponseEntity<Page<ClienteResponseDTO>> listarClientes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String dir
    ) {
        Sort.Direction direction = dir.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort));
        return ResponseEntity.ok(clienteService.obtenerPaginado(pageable));
    }


    // GET: Obtener cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> obtenerCliente(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.obtenerPorId(id));
    }

    // PUT: Actualizar cliente por ID
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> actualizarCliente(
            @PathVariable Long id,
            @Valid @RequestBody ClienteRequestDTO request) {
        return ResponseEntity.ok(clienteService.actualizarCliente(id, request));
    }

    // DELETE: Eliminar cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    //ENDPOINTS - Métodos para filtrado por apellido y por tipo de consulta.

    @GetMapping("/buscar-por-apellido")
    public ResponseEntity<List<ClienteResponseDTO>> buscarPorApellido(
            @RequestParam String apellido) {
        return ResponseEntity.ok(clienteService.buscarPorApellido(apellido));
    }

    @GetMapping("/buscar-por-tipo-consulta")
    public ResponseEntity<List<ClienteResponseDTO>> buscarPorTipoConsulta(
            @RequestParam String tipoConsulta) {
        return ResponseEntity.ok(clienteService.buscarPorTipoConsulta(tipoConsulta));
    }

}
