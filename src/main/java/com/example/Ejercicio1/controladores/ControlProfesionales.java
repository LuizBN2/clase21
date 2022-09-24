package com.example.Ejercicio1.controladores;

import com.example.Ejercicio1.entidades.Paciente;
import com.example.Ejercicio1.entidades.Profesional;
import com.example.Ejercicio1.servicios.ServiciosPacientes;
import com.example.Ejercicio1.servicios.ServiciosProfesionales;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ControlProfesionales {
    /*

    ServiciosProfesionales servicesP;

    //constructor
    public ControlProfesionales(){
        this.servicesP = new ServiciosProfesionales();
    }

    @GetMapping("/verprofesionales")
    public Profesional ControlProfesionales(){
        return this.servicesP.getProfesionales();
    }

     */
    ServiciosProfesionales servicesProf;

    //cosntructor
    public ControlProfesionales(ServiciosProfesionales servicesProf){
        this.servicesProf = servicesProf;
    }

    /*
    @GetMapping("/profesionales/{id}")
    public Profesional LlamarProfesionales(@PathVariable Long id){
        return this.servicesProf.getLlamarProf(id);
    }

@PostMapping("/profesionales")
    public Profesional crearProfesionales(@RequestBody Profesional p){
        return this.servicesProf.crearProf(p);
    }

     */



    /*editar un registro
    @PutMapping("/profesionales/{id}")
    public Profesional actualizarProfesionales(@PathVariable Long id, @RequestBody Profesional actProfesional){
        return this.servicesProf.actualizarProf(id, actProfesional);
    }

@DeleteMapping("/profesionales/{id}")
    public Profesional eliminarProfesionales(@PathVariable(value = "id") Long id){
        return this.servicesProf.eliminarProf(id);
    }
     */

    @PostMapping("/profesionales")
    public RedirectView crearProfesionales(@ModelAttribute Profesional p, Model model){
        model.addAttribute(p);
        this.servicesProf.crearProf(p);
        return new RedirectView("/profesionales");
    }

    @PutMapping("/profesionales/{id}")
    public RedirectView actualizarProfesionales(@PathVariable Long id,  Profesional actProfesional) {
        this.servicesProf.actualizarProf(id, actProfesional);
        return new RedirectView("/profesionales");
    }

    //borrar un registro
    @DeleteMapping("/profesionales/{id}")
    public RedirectView eliminarProfesionales(@PathVariable(value = "id") Long id){
        this.servicesProf.eliminarProf(id);
        return new RedirectView("/profesionales");
    }

}
