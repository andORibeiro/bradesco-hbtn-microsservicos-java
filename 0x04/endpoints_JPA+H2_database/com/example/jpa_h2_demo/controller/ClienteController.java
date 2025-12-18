package com.example.jpa_h2_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa_h2_demo.model.Cliente;
import com.example.jpa_h2_demo.repository.ClienteRepository;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        if (cliente.getTelefones() != null) {
            cliente.getTelefones().forEach(t -> t.setCliente(cliente));
        }
        if (cliente.getEnderecos() != null) {
            cliente.getEnderecos().forEach(e -> e.setCliente(cliente));
        }
        Cliente saved = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        return clienteRepository.findById(idClient)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient) {
        clienteRepository.deleteById(idClient);
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        clienteRepository.findById(id).ifPresent(existing -> {
            existing.setNome(cliente.getNome());
            existing.setIdade(cliente.getIdade());
            existing.setEmail(cliente.getEmail());
            existing.getTelefones().clear();
            if (cliente.getTelefones() != null) {
                cliente.getTelefones().forEach(t -> {
                    t.setCliente(existing);
                    existing.getTelefones().add(t);
                });
            }
            existing.getEnderecos().clear();
            if (cliente.getEnderecos() != null) {
                cliente.getEnderecos().forEach(e -> {
                    e.setCliente(existing);
                    existing.getEnderecos().add(e);
                });
            }
            clienteRepository.save(existing);
        });
    }
}

