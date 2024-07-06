package com.edu.ecu.pw.pw_api_u3_p6_al.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.ecu.pw.pw_api_u3_p6_al.modelo.Materia;
import com.edu.ecu.pw.pw_api_u3_p6_al.service.IMateriaService;

import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping(path = "/materias")
public class MateriaController {

    @Autowired
    private IMateriaService materiaService;

    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/materias
    @PostMapping
    public void guardar(@RequestBody Materia mat){
        this.materiaService.guardar(mat);
    }
    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/materias/1
    @PutMapping(path = "/{id}")
    public void actualizar(@RequestBody Materia mat, @PathVariable Integer id){
        mat.setId(id);
        this.materiaService.actualizar(mat);
    }
    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/materias/1
    @PatchMapping(path = "/{id}")
    public void actualizarParcial(@RequestBody Materia mat, @PathVariable Integer id){
        mat.setId(id);
        Materia mat2 = this.materiaService.buscar(mat.getId());
        if (mat.getNombre() != null) {
            mat2.setNombre(mat.getNombre());
        }
        if (mat.getCodigo() != null) {
            mat2.setCodigo(mat.getCodigo());
        }
        if (mat.getCupos() != null) {
            mat2.setCupos(mat.getCupos());
        }
        if (mat.getHoras() != null) {
            mat2.setHoras(mat.getHoras());
        }
        if (mat.getProfesor() != null) {
            mat2.setProfesor(mat.getProfesor());
        }

        this.materiaService.actualizar(mat2);

    }

    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/materias/1
    @DeleteMapping(path = "/{id}")
    public void borrar(@PathVariable Integer id){
        this.materiaService.buscar(id);
    }

    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/materias/1
    @GetMapping(path = "/{id}")
    public Materia buscar(@PathVariable Integer id){
        return this.materiaService.buscar(id);
    }

    //Nivel 1 http://localhost:8080/API/v1.0/Matricula/materias/codigo?codigo=MAT01
    @GetMapping(path = "/codigo")
    public List<Materia> buscarByCodigo(@RequestParam String codigo){
        List<Materia> lista = this.materiaService.buscarByCodigo(codigo);
        return lista;
    }
    
}
