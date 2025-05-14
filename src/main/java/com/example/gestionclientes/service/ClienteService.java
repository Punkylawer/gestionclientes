package com.example.gestionclientes.service;

import com.example.gestionclientes.dto.ClienteRequestDTO;
import com.example.gestionclientes.dto.ClienteResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {

    ClienteResponseDTO crearCliente(ClienteRequestDTO request);

    List<ClienteResponseDTO> obtenerTodos();

    ClienteResponseDTO obtenerPorId(Long id);

    void eliminarPorId(Long id);

    ClienteResponseDTO actualizarCliente(Long id, ClienteRequestDTO request);

    List<ClienteResponseDTO> buscarPorApellido(String apellido);

    List<ClienteResponseDTO> buscarPorTipoConsulta(String tipoConsulta);

    Page<ClienteResponseDTO> obtenerPaginado(Pageable pageable);

}
