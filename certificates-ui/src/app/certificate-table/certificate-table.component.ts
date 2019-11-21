import { Component, OnInit } from '@angular/core';
import { CertificateService } from './../services/certificate.service'
import { CertificateDetailsService } from './../services/certificate-details.service'
import { Certificate } from "./../model/certificate"
import { Observable } from 'rxjs'

@Component({
  selector: 'app-certificate-table',
  templateUrl: './certificate-table.component.html',
  styleUrls: ['./certificate-table.component.css']
})
export class CertificateTableComponent implements OnInit {
 private certificates: Observable<Certificate[]>;

 constructor(private certificateService: CertificateService, private certificateDetailsService: CertificateDetailsService) { }

  ngOnInit() {
   this.certificates = this.certificateService.getCertificatesList();
  }

 /* Setting up the current certificate to be represented in html view.
  **/
  asHtml(certificate){
  this.certificateDetailsService.setCertificate(certificate);
  }

 /**
 *Setting up the Certificate object that has to be rendered in Xml view.
 **/
  asXml(certificate){
   this.certificateDetailsService.setXmlCertificate(certificate);
  }
}
