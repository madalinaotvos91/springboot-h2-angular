import { Observable } from "rxjs";
import { CertificateService } from "./../services/certificate.service";
import { CertificateDetailsService } from "./../services/certificate-details.service"
import { Certificate } from "./../model/certificate";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-certificate-ui",
  templateUrl: "./certificate-ui.component.html",
  styleUrls: ["./certificate-ui.component.css"]
})
export class CertificateUIComponent implements OnInit {
  // List of certificates that are displayed in the table
  private certificates: Observable<Certificate[]>;

  constructor(private certificateService: CertificateService, private certificateDetailsService: CertificateDetailsService ) {}

  /**
  * Ng on component initialization function
  */
  ngOnInit() {
  }


 getSelectedCertificate(){
 return this.certificateDetailsService.getCertificate();
 }

  getSelectedXmlCertificate(){
  return this.certificateDetailsService.getXmlCertificate();
  }


 /**
 * Resetting the objects to initial values.
 **/
  reset(){
  this.certificateDetailsService.setCertificate(null);
  this.certificateDetailsService.setXmlCertificate(null);
  }
}
