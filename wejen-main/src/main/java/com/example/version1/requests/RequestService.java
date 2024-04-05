package com.example.version1.requests;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;

    public List<Request> getAllRequest() {
        return requestRepository.findAll();
    }

    public Request createRequest(Request request) {
        return requestRepository.save(request);
    }

    public Request getRequestById(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found."));
    }

    public Request updateRequest(Long id, Request updatedRequest) {
        Request request = getRequestById(id);
        request.setTitle(updatedRequest.getTitle());
        request.setDescription(updatedRequest.getDescription());
        request.setValid(updatedRequest.isValid());
        return requestRepository.save(request);
    }

    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }


    public List<Request> getRequestByTypeAndServiceAndStatue(String typeRequest, String service, String statue) {
        return requestRepository.findByTypeRequestAndServiceAndStatue(typeRequest, service, statue);
    }

    public List<Request> getRequestAutorisationsChefHierarchique() {
        return requestRepository.findByTypeRequestAndServiceAndStatue("AUTORISATION", "ServiceXYZ", "EN_ATTENTE");
    }

    public List<Request> getRequestCongesChefHierarchique() {
        return requestRepository.findByTypeRequestAndServiceAndStatue("CONGE", "ServiceXYZ", "EN_ATTENTE");
    }

    public List<Request> getRequestMutationsChefHierarchique() {
        return requestRepository.findByTypeRequestAndServiceAndStatue("MUTATION", "ServiceXYZ", "EN_ATTENTE");
    }


}
