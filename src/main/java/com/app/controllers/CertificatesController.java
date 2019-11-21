package com.app.controllers;

import com.app.model.Certificate;
import com.app.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/api")
@Component
/**
 * Controller that implements the api's post and get functions for retrieving the certificate list and creatOrUpdate certificate.
 * Cross origin is set to allow requests from angular default port.
 * **/
public class CertificatesController {
     @Autowired
    CertificateService certificateService;

     /**
      * Get function for retrieving the certificate list.
      * */
    @RequestMapping(value = "/certificates", method = RequestMethod.GET)
    public ResponseEntity<List<Certificate>> listAll() {
        List<Certificate> certList = certificateService.findAll();
        if (certList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Certificate>>(certList, HttpStatus.OK);
    }

     /**
     * Post function for create a or update function for certificate object. If id is set then the certificate will be updated otherwise created.
     */
    @RequestMapping(value = "/certificate/", method = RequestMethod.POST,  headers = "Accept=application/json")
    public ResponseEntity<?> createOrUpdateCertificate(@RequestBody Certificate certificate, UriComponentsBuilder ucBuilder) {
        Certificate cert =  certificateService.createOrUpdate(certificate);
        return new ResponseEntity<Certificate>(cert, HttpStatus.OK);
    }
    }