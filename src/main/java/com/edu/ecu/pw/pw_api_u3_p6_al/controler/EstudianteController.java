package com.edu.ecu.pw.pw_api_u3_p6_al.controler;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RestController;

import com.edu.ecu.pw.pw_api_u3_p6_al.modelo.Estudiante;
import com.edu.ecu.pw.pw_api_u3_p6_al.service.IEstudianteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping(path = "/estudiantes")

public class EstudianteController {

    @Autowired
    private IEstudianteService estudianteService;

    //http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
    @PostMapping(path = "/guardar")
    public void guardar(){
        Estudiante est = new Estudiante();
        est.setNombre("Andres");
        est.setApellido("Lugmaña");
        est.setFechaNacimiento(LocalDateTime.of(2000, 07, 27, 0, 0));
        this.estudianteService.guardar(est);
    }
    //http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
    @PutMapping(path="/actualizar")
    public void actualizar(){
        Estudiante est = new Estudiante();
        est.setNombre("Arelis");
        est.setApellido("Cacuango");
        est.setFechaNacimiento(LocalDateTime.of(2002, 9, 04, 0, 0));
        this.estudianteService.actualizar(est);
    }
    //http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
    @PatchMapping(path = "/actualizarParcial")
    public void actualizarParcial(){
        Estudiante est = this.estudianteService.buscar(1);
        est.setNombre("Felipe");
        this.estudianteService.actualizar(est);
    }
    //http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
    @DeleteMapping(path = "/borrar")
    public void borrar(){
        this.estudianteService.borrar(1);
    }
    //http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
    @GetMapping(path = "/buscar")
    public Estudiante buscar(){
        return this.estudianteService.buscar(1);
    } 
}
