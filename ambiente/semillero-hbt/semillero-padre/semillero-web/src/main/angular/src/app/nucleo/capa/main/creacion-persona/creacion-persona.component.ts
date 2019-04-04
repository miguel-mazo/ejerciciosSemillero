import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-creacion-persona',
  templateUrl: './creacion-persona.component.html',
  styleUrls: ['./creacion-persona.component.css']
})
export class CreacionPersonaComponent implements OnInit {

  id: String = "123";
  tipoID: String = "Cédula de ciudadanía";
  nombres: String = "Miguel Ángel";
  apellidos: String = "Benjumea Mazo";
  numeroID: String = "123456789";

  constructor() { }

  ngOnInit() {
  }

}
