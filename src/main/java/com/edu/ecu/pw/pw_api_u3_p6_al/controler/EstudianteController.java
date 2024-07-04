package com.edu.ecu.pw.pw_api_u3_p6_al.controler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.edu.ecu.pw.pw_api_u3_p6_al.modelo.Estudiante;
import com.edu.ecu.pw.pw_api_u3_p6_al.service.IEstudianteService;

import jakarta.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(path = "/estudiantes")

public class EstudianteController {

    @Autowired
    private IEstudianteService estudianteService;

    //http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes
    @PostMapping
    public void guardar(@RequestBody Estudiante est){

        //Estudiante est = new Estudiante();
        //est.setNombre("Andres");
        //est.setApellido("Lugmaña");
        //est.setFechaNacimiento(LocalDateTime.of(2000, 07, 27, 0, 0));
        this.estudianteService.guardar(est);
    }
    //http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes/3
    @PutMapping(path="/{id}")
    public void actualizar(@RequestBody Estudiante est, @PathVariable Integer id){
        est.setId(id);
        this.estudianteService.actualizar(est);
    }
    //http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes/3
    @PatchMapping(path = "/{id}")
    public void actualizarParcial(@RequestBody Estudiante est, @PathVariable Integer id){
        est.setId(id);
        Estudiante est2 = this.estudianteService.buscar(est.getId());
        if(est.getNombre()!=null){
            est2.setNombre(est.getNombre());
        }
        if(est.getApellido()!=null){
            est2.setApellido(est.getApellido());
        }
        if(est.getFechaNacimiento()!=null){
            est2.setFechaNacimiento(est.getFechaNacimiento());
        }
        this.estudianteService.actualizar(est2);
    }
    //http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes/3
    @DeleteMapping(path = "/{id}")
    public void borrar(@PathVariable Integer id){
        this.estudianteService.borrar(id);
    }
    //http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/3/nuevo
    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes/3
    @GetMapping(path = "/{id}")
    public Estudiante buscar(@PathVariable Integer id){
        return this.estudianteService.buscar(id);
    } 
    //http://localhost:8080/API/v1.0/Matricula/estudiantes/bucarByGenero?genero=F&edad=35
    @GetMapping(path = "/bucarByGenero")
    public List<Estudiante> buscarByGenero(@RequestParam String genero, @RequestParam Integer edad){
        System.out.println("edad: "+edad);
        List<Estudiante> lista = this.estudianteService.buscarByGenero(genero);
        return lista;
    }
        
    @GetMapping(path = "/bucarMixto/{id}")
    public Estudiante buscarMixto(@PathVariable Integer id, @RequestParam String test){
        System.out.println("dato: "+test);
        System.out.println("dato: "+id);
        return this.estudianteService.buscar(id);
    }


}
