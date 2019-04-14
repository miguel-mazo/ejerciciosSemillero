import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { AbstractService } from '../template.service';
import { VehiculoServicioDTO } from '../../capa/principal/gestion_vehiculos/modelo/vehiculoServicioDTO';
import { PersonaServicioDTO } from '../../capa/principal/gestion_vehiculos/modelo/personaServicioDTO';
import { MarcaServicioDTO } from '../../capa/principal/gestion_vehiculos/modelo/marcaServicioDTO';
import { LineaServicioDTO } from '../../capa/principal/gestion_vehiculos/modelo/lineaServicioDTO';

@Injectable({
  providedIn: 'root'
})
export class ConsultaVehiculosService extends AbstractService {
	
  public vehiculo: VehiculoServicioDTO;
  public listaVehiculoDTO: VehiculoServicioDTO[];
  
  /**
   * Constructor
   */
  constructor(injector: Injector) {
    super(injector);
  }

 public consultarPersonas(tipoID: string, numID: string):  Observable<PersonaServicioDTO[]> {
 	return this.get<PersonaServicioDTO[]>("/semillero-servicios", "/ConsultasRest/consultarPersonas",
	{
        "tipoID":tipoID, 
        "numID":numID,
      });
 }
 
 //Cambiar rest
 public consultarListaVehiculos() : Observable<VehiculoServicioDTO> { 
  	return this.get<VehiculoServicioDTO>("/semillero-servicios", "/ConsultasRest/consultarVehiculos");
 }

  public consultarMarcas() : Observable<MarcaServicioDTO[]> { 
    return this.get<MarcaServicioDTO[]>("/semillero-servicios", "/ConsultasRest/consultarMarcas");
  }
  
  public consultarLineasPorMarca(idMarca: number) : Observable<LineaServicioDTO[]> { 
	  return this.get<LineaServicioDTO[]>("/semillero-servicios", "/ConsultasRest/consultarLineasPorMarca",
	    {
	      "idMarca" : idMarca.toString()
      }
    );
  }

  public consultarVehiculo(placa: string) : Observable<VehiculoServicioDTO> { 
	  return this.get<VehiculoServicioDTO>("/semillero-servicios", "/ConsultasRest/consultarVehiculo",
	      {
	        "placa":placa
	      });
  }

  public consultarMarcaLinea(idMarca : number, idLinea: number) : Observable<VehiculoServicioDTO[]> { 
    if(idMarca == null){
      idMarca = -1;
    }

    if(idLinea == null){
      idLinea = -1;
    }
	  return this.get<VehiculoServicioDTO[]>("/semillero-servicios", "/ConsultasRest/consultarMarcaLinea",
	      {
          "idMarca":idMarca.toString(),
          "idLinea":idLinea.toString()
	      });
  }

  public editarVehiculo(vehiculo: VehiculoServicioDTO){
    return this.put("/semillero-servicios", "/ConsultasRest/editarVehiculo", vehiculo);
  }

  public borrarVehiculo(vehiculo: VehiculoServicioDTO){
    return this.delete("/semillero-servicios", "/ConsultasRest/borrarVehiculo/" + vehiculo.idVehiculo);
  }

}
