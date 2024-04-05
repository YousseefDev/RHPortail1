package com.example.version1.requests;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/requests")
@RequiredArgsConstructor
public class ApiRequestController {
    private final RequestService requestService;

    @GetMapping
    public ResponseEntity<List<Request>> getAll() {
        List<Request> requests = requestService.getAllRequest();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Request> create(@RequestBody Request request) {
        Request createdRequest = requestService.createRequest(request);
        return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getOne(@PathVariable Long id) {
        Request request = requestService.getRequestById(id);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> update(@PathVariable Long id, @RequestBody Request request) {
        Request updatedRequest = requestService.updateRequest(id, request);
        return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        requestService.deleteRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/autorisations")
    public ResponseEntity<List<Request>> getRequestAutorisationsChefHierarchique() {
        // Appel à une méthode du service pour récupérer les demandes d'autorisations gérées par le chef hiérarchique
        List<Request> requests = requestService.getRequestAutorisationsChefHierarchique();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @GetMapping("/conges")
    public ResponseEntity<List<Request>> getRequestCongesChefHierarchique() {
        // Appel à une méthode du service pour récupérer les demandes de congés gérées par le chef hiérarchique
        List<Request> requests = requestService.getRequestCongesChefHierarchique();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @GetMapping("/mutations")
    public ResponseEntity<List<Request>> getRequestMutationsChefHierarchique() {
        // Appel à une méthode du service pour récupérer les demandes de mutations gérées par le chef hiérarchique
        List<Request> requests = requestService.getRequestMutationsChefHierarchique();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    // Autres endpoints pour gérer les demandes



}



