import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CertificateUIComponent} from './certificate-ui/certificate-ui.component';

const routes: Routes = [
  { path: '', redirectTo: 'certificates', pathMatch: 'full' },
  { path: 'certificates', component: CertificateUIComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
