import { Injectable } from '@angular/core';
import { Certificate } from "./../model/certificate"
import { HttpClient, HttpHeaders } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CertificateDetailsService {
  private certificate: Certificate;
  private xmlCertificate: Certificate;
  //URL for retrieving the certificate list
  private baseUrl = 'http://localhost:8080/api/certificates';

  constructor(private http: HttpClient) { }

  setCertificate(cert: Certificate){
  this.certificate = cert;
  }

  getCertificate(){
  return this.certificate;
  }

  setXmlCertificate(cert: Certificate){
  this.xmlCertificate = cert;
  }

 /**
 *Returns xml representation of already set xmlCertificate object.
 **/
  getXmlCertificateStr(){
   if(this.xmlCertificate != null){
      return "<id>" + this.xmlCertificate.id + "</id><type>" + this.xmlCertificate.typeValue +"</type><isin>"
                       + this.xmlCertificate.isin +"</isin><barrierLevel>" + this.xmlCertificate.barrierLevel
                       +"</barrierLevel><market>"+ this.xmlCertificate.market + "</market><currency>"
                       + this.xmlCertificate.currency + "</currency><issuer>" + this.xmlCertificate.issuer
                       + "</issuer><issuePrice>" + this.xmlCertificate.issuingPrice + "</issuePrice><currentPrice>"
                       + this.xmlCertificate.currentPrice+"</currentPrice>"
    } else{
      return "";
    }
  }

  getXmlCertificate(){
  return this.xmlCertificate;
  }


  /**
  * Function for exporting the xml file via http request.
  **/
  export() {
      return this.http.get(this.baseUrl,
          {responseType: 'blob'});
  }
}
