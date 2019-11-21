package com.app.repository;

import com.app.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * JPA repository of certificate database to java objects.
 * **/
public interface CertificatesRepository extends JpaRepository<Certificate, Long> {
}
