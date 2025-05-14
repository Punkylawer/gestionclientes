package com.example.gestionclientes.mapper;

import com.example.gestionclientes.dto.ClienteRequestDTO;
import com.example.gestionclientes.dto.ClienteResponseDTO;
import com.example.gestionclientes.model.Cliente;

import java.time.LocalDate;

public class ClienteMapper {

    // De DTO de solicitud a entidad
    public static Cliente toEntity(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());
        cliente.setTipoConsulta(dto.getTipoConsulta());
        cliente.setObservaciones(dto.getObservaciones());
        cliente.setFechaAlta(LocalDate.now()); // la seteo acá, no la manda el usuario
        return cliente;
    }

    // De entidad a DTO de respuesta
    public static ClienteResponseDTO toDTO(Cliente cliente) {
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setEmail(cliente.getEmail());
        dto.setTelefono(cliente.getTelefono());
        dto.setTipoConsulta(cliente.getTipoConsulta());
        dto.setObservaciones(cliente.getObservaciones());
        dto.setFechaAlta(cliente.getFechaAlta());
        return dto;
    }
}
