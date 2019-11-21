import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Certificate } from "./../model/certificate";
import { map } from 'rxjs/operators';
import { RequestOptions } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class CertificateService {

  //URL for retrieving the certificate list
  private baseUrl = 'http://localhost:8080/api/certificates';

  //URL for post certificate createOrUpdate
  private crudUrl = 'http://localhost:8080/api/certificate/';

  constructor(private http: HttpClient) { }

  /**
  * Get function for retrieving the certificates list.
  **/
  getCertificatesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  /**
  * Post function for createOrUpdate certificate, headers are set to contentType json object.
  **/
  createOrUpdateCertificate(certificate:string): Observable<any> {
      let headers = new HttpHeaders({
          'Content-Type': 'application/json'});
      let options = { headers: headers };
      let res = this.http.post(this.crudUrl, certificate, options);
      return res;
  }
}
