package com.example.version1.requests;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

List<Request> findByTypeRequestAndServiceAndStatue(String typeRequest, String service, String statue);

}
