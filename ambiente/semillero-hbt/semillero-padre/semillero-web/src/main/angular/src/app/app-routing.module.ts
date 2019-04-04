import { NgModule, Pipe } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CapaComponent } from './nucleo/capa/capa.component';
import { EncabezadoComponent } from './nucleo/capa/encabezado/encabezado.component';
import { MainComponent } from './nucleo/capa/main/main.component';
import { PiepaginaComponent } from './nucleo/capa/piepagina/piepagina.component';
import { CreacionPersonaComponent } from './nucleo/capa/main/creacion-persona/creacion-persona.component';

const routes: Routes = [
  { path: 'capa', component:CapaComponent },
  { path: 'encabezado', component:EncabezadoComponent },
  { path: 'main', component:MainComponent },
  { path: 'pie', component:PiepaginaComponent },
  { path: 'creacion-persona', component:CreacionPersonaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
