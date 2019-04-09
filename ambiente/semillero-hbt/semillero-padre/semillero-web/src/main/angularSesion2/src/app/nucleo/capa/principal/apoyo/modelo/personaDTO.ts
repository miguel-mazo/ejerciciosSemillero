export interface PersonaDTO {   

    id: string;
    nombre: string;
    apellido: string;
    tipoIdentificacion: string;
    numeroIdentificacion: number | string;
    numeroTelefonico: number;
    edad : number;
    fechaNacimiento : string;
    mayorEdad:boolean;
    estado: string;
    sexo:string;
    rol: string;
}