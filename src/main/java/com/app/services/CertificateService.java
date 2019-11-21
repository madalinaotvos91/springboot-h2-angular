package com.app.services;

import com.app.model.Certificate;
import com.app.repository.CertificatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("certificateService")
@Transactional
/**
 * Direct access to jpa repository in order to query objects.
 * */
public class CertificateService {
    @Autowired
    private CertificatesRepository certificateRepository;

    /**
     * Retrieves all the Certificate objects fro database side.
     * */
    public List<Certificate> findAll() {
        return certificateRepository.findAll();
    }

    /**
     * Create or update function for Certificate type. If id is set and the object id exists, then update, otherwise create.
     * */
    public Certificate createOrUpdate(Certificate certificate){
       return certificateRepository.save(certificate);
    }
}
