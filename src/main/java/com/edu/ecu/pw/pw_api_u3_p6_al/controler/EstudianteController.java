package com.edu.ecu.pw.pw_api_u3_p6_al.controler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.edu.ecu.pw.pw_api_u3_p6_al.modelo.Estudiante;
import com.edu.ecu.pw.pw_api_u3_p6_al.service.IEstudianteService;
import com.edu.ecu.pw.pw_api_u3_p6_al.service.IMateriaService;
import com.edu.ecu.pw.pw_api_u3_p6_al.service.to.EstudianteTO;
import com.edu.ecu.pw.pw_api_u3_p6_al.service.to.MateriaTO;

import jakarta.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
 


@RestController
@RequestMapping(path = "/estudiantes")

public class EstudianteController {

    @Autowired
    private IEstudianteService estudianteService;

    @Autowired
    private IMateriaService materiaService;

    //http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes

    // NIVEL 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/texto/plano
	@GetMapping(path = "/texto/plano")
	public String prueba() {
		String prueba = "TEXTO DE PRUEBA";
		return prueba;
		
	}
    @PostMapping(produces=MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante est){

        //Estudiante est = new Estudiante();
        //est.setNombre("Andres");
        //est.setApellido("Lugmaña");
        //est.setFechaNacimiento(LocalDateTime.of(2000, 07, 27, 0, 0));
        this.estudianteService.guardar(est);
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("mensaje", "Estudiante guardado exitosamente");
        return new ResponseEntity<>(est, cabeceras, 201);
    }
    //http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes/3
    @PutMapping(path="/{cedula}", produces=MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante est, @PathVariable String cedula){
        est.setCedula(cedula);;
        this.estudianteService.actualizar(est);
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("mensaje", "Estudiante actualizado exitosamente");
        return new ResponseEntity<>(est, cabeceras, 238);
    }
    //http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes/3
    @PatchMapping(path = "/{cedula}",produces=MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudiante> actualizarParcial(@RequestBody Estudiante est, @PathVariable String cedula){
        est.setCedula(cedula);
        Estudiante est2 = this.estudianteService.buscar(est.getCedula());
        if (est.getNombre() != null) {
            est2.setNombre(est.getNombre());
        }
        if (est.getApellido() != null) {
            est2.setApellido(est.getApellido());
        }
        if (est.getFechaNacimiento() != null) {
            est2.setFechaNacimiento(est.getFechaNacimiento());
        }
        if (est.getGenero() != null) {
            est2.setGenero(est.getGenero());
        }
        this.estudianteService.actualizar(est2);
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("data", "Estudiante actualizado parcialmente");
        return new ResponseEntity<>(est2, cabeceras, 239);
    }

    //http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes/3
    @DeleteMapping(path = "/{cedula}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> borrar(@PathVariable String cedula){
        this.estudianteService.borrar(cedula);
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("data", "Estudiante borrado exitosamente");
        return new ResponseEntity<>("Borrado", cabeceras, 240);
    }
    //http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/3/nuevo
    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes/3
    @GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Estudiante> buscarById(@PathVariable String cedula){
        //return ResponseEntity.status(240).body(this.estudianteService.buscar(id));
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("data", "Se Encontro el estudiante");
        return new ResponseEntity<>(this.estudianteService.buscar(cedula),cabeceras,236);
    } 
    //http://localhost:8080/API/v1.0/Matricula/estudiantes/bucarByGenero?genero=F&edad=35
    // debe hacer alucion al filtro pero no debe etener la accion o estar en infinitivo
    //Nivel 1 : //http://localhost:8080/API/v1.0/Matricula/estudiantes/genero?genero=F
    @GetMapping(path = "/genero", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Estudiante> buscarByGenero(@RequestParam String genero){
        List<Estudiante> lista = this.estudianteService.buscarByGenero(genero);
        return lista;
    }
        
    //Nivel 1 : //http://localhost:8080/API/v1.0/Matricula/estudiantes/mixto/3?test=holaMundoXD
    @GetMapping(path = "/mixto/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Estudiante buscarMixto(@PathVariable String cedula, @RequestParam String test){
        System.out.println("dato: "+test);
        System.out.println("dato: "+cedula);
        return this.estudianteService.buscar(cedula);
    }
    //http://localhost:8080/API/v1.0/Matricula/estudiantes/hateoas/8
    @GetMapping(path = "/hateoas/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EstudianteTO buscarHateoas(@PathVariable String cedula){
        EstudianteTO est = this.estudianteService.buscarPorID(cedula);
        //List<MateriaTO> lista = this.materiaService.buscarByEstudiante(id);
        //est.setMaterias(lista);
        Link myLink = linkTo(methodOn(EstudianteController.class).buscarMateriasPorIdEstudiante(cedula)).withRel("susMaterias");
        est.add(myLink);

        Link myLink2 = linkTo(methodOn(EstudianteController.class).buscarById(cedula)).withSelfRel();

        est.add(myLink2);
        return est;
    }

    public List<MateriaTO> buscarPorEstudiante(@PathVariable String cedula){
		return this.materiaService.buscarByEstudiante(cedula);
	}

    @GetMapping(path = "/{cedula}/materias")
    public List<MateriaTO> buscarMateriasPorIdEstudiante(@PathVariable String cedula){
        return this.materiaService.buscarByEstudiante(cedula);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Estudiante> buscarByGenero(){
        List<Estudiante> lista = this.estudianteService.seleccionarTodos();
        return lista;
    }

    


}
