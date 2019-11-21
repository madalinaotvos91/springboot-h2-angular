import { Component, OnInit } from '@angular/core';
import { CertificateService } from "./../services/certificate.service";
import { CertificateDetailsService } from "./../services/certificate-details.service";
import { Certificate } from "./../model/certificate";
import { Input } from '@angular/core';

@Component({
  selector: 'app-certificate-details',
  templateUrl: './certificate-details.component.html',
  styleUrls: ['./certificate-details.component.css']
})
export class CertificateDetailsComponent implements OnInit {
  private certificate : Certificate ;

  @Input() set currentCertificate(cert: Certificate ){
      this.certificate = this.certificateDetailsService.getCertificate();
  }

  get currentCertificate(){
    return this.certificate;
  }

  // Inline initialization for certificate types
  private certificateTypes = {0:'Standard',1:'Bonus',2:'Guarantee'};
  // Regular expression for number only needed for pattern of input fields
   private onlyNumbers = /^-?\d*\.?\d{0,9}$/;

  constructor(private certificateService : CertificateService, private certificateDetailsService: CertificateDetailsService) { }


  ngOnInit() {
  }

  /**
  *Calling the createOrUpdate function of service object, refreshing the ui after all.
  **/
  createOrUpdateCertificate(){
    this.certificateService.createOrUpdateCertificate( JSON.stringify(this.certificate))
                    .subscribe(res =>{ console.log(res); },
                               err => {
                                   console.log(err.message);
                               });
     this.refresh();
  }

   /**
    *Refresh function, work around for table refresh, for some reason the table was not refreshing even if initialli
    * it was bound to ngModel.
    **/
    refresh(): void {
        window.location.reload();
    }

    reset(){
    this.certificateDetailsService.setXmlCertificate(null);
     this.certificateDetailsService.setCertificate(null);
    }
}
