import { TestBed } from '@angular/core/testing';

import { CertificateDetailsService } from './certificate-details.service';

describe('CertificateDetailsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CertificateDetailsService = TestBed.get(CertificateDetailsService);
    expect(service).toBeTruthy();
  });
});
