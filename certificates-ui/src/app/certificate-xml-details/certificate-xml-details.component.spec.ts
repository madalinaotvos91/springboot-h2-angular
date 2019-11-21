import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CertificateXmlDetailsComponent } from './certificate-xml-details.component';

describe('CertificateXmlDetailsComponent', () => {
  let component: CertificateXmlDetailsComponent;
  let fixture: ComponentFixture<CertificateXmlDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CertificateXmlDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CertificateXmlDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
