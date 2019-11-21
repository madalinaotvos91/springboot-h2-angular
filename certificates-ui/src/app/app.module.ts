import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CertificateUIComponent } from './certificate-ui/certificate-ui.component';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { CertificateTableComponent } from './certificate-table/certificate-table.component';
import { CertificateDetailsComponent } from './certificate-details/certificate-details.component';
import { CertificateXmlDetailsComponent } from './certificate-xml-details/certificate-xml-details.component';
@NgModule({
  declarations: [
    AppComponent,
    CertificateUIComponent,
    CertificateTableComponent,
    CertificateDetailsComponent,
    CertificateXmlDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
