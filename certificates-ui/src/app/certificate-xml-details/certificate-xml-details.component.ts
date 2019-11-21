import { Component, OnInit } from '@angular/core';
import { CertificateDetailsService } from "./../services/certificate-details.service"
import { Certificate } from './../model/certificate';
import { Input } from '@angular/core';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-certificate-xml-details',
  templateUrl: './certificate-xml-details.component.html',
  styleUrls: ['./certificate-xml-details.component.css']
})
export class CertificateXmlDetailsComponent implements OnInit {
  private xmlCertificate: Certificate;
  private xmlCertificateStr: string = "";

  @Input()
  set xmlCertificateValue(certificate){
    this.xmlCertificateStr = this.certificateDetailsService.getXmlCertificateStr()
    this.xmlCertificate = certificate;
  }

  get xmlCertificateValue(){
  return this.xmlCertificate;
  }

  constructor(private certificateDetailsService : CertificateDetailsService) { }

  ngOnInit() {
  }

  /**
  *Function for downloading the xmlCurrCert object as certificate.xml file.
  **/
  download(){
   this.xmlCertificateStr = this.certificateDetailsService.getXmlCertificateStr();
   if(this.xmlCertificate.certType !== 2){
    this.certificateDetailsService.export().subscribe(xmlCertificateStr =>
     saveAs(new Blob([this.xmlCertificateStr], { type: "xml" }), 'certificate.xml'));
    }else{
     this.xmlCertificateStr = "Guarantee type certificates can not be exported!"
     }
  }


}
