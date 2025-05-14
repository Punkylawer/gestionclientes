package com.example.gestionclientes.service;

import com.example.gestionclientes.dto.ClienteRequestDTO;
import com.example.gestionclientes.dto.ClienteResponseDTO;
import com.example.gestionclientes.exception.ResourceNotFoundException;
import com.example.gestionclientes.mapper.ClienteMapper;
import com.example.gestionclientes.model.Cliente;
import com.example.gestionclientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteResponseDTO crearCliente(ClienteRequestDTO request) {
        if (clienteRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Ya existe un cliente con ese email.");
        }
        Cliente cliente = ClienteMapper.toEntity(request);
        Cliente guardado = clienteRepository.save(cliente);
        return ClienteMapper.toDTO(guardado);
    }

    @Override
    public List<ClienteResponseDTO> obtenerTodos() {
        return clienteRepository.findAll().stream()
                .map(ClienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteResponseDTO obtenerPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + id));
        return ClienteMapper.toDTO(cliente);
    }

    @Override
    public void eliminarPorId(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("No existe un cliente con ese ID.");
        }
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteResponseDTO actualizarCliente(Long id, ClienteRequestDTO request) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + id));

        cliente.setNombre(request.getNombre());
        cliente.setApellido(request.getApellido());
        cliente.setEmail(request.getEmail());
        cliente.setTelefono(request.getTelefono());
        cliente.setTipoConsulta(request.getTipoConsulta());
        cliente.setObservaciones(request.getObservaciones());

        Cliente actualizado = clienteRepository.save(cliente);
        return ClienteMapper.toDTO(actualizado);
    }

    @Override
    public List<ClienteResponseDTO> buscarPorApellido(String apellido) {
        return clienteRepository.findByApellidoContainingIgnoreCase(apellido).stream()
                .map(ClienteMapper::toDTO)
                .toList();
    }

    @Override
    public List<ClienteResponseDTO> buscarPorTipoConsulta(String tipoConsulta) {
        return clienteRepository.findByTipoConsultaIgnoreCase(tipoConsulta).stream()
                .map(ClienteMapper::toDTO)
                .toList();
    }


    @Override
    public Page<ClienteResponseDTO> obtenerPaginado(Pageable pageable) {
        return clienteRepository.findAll(pageable)
                .map(ClienteMapper::toDTO);
    }



}
