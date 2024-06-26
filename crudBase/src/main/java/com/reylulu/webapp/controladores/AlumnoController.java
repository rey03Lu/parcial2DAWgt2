package com.reylulu.webapp.controladores;

import com.reylulu.webapp.entidades.Alumno;
import com.reylulu.webapp.negocio.DataService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author reylulu
 */
@Named
@RequestScoped
public class AlumnoController {
    private List<Alumno> alumnosList = new ArrayList<>();
    
    private Alumno alumno = new Alumno();
    private Alumno selectedAlumno; // Nueva propiedad
    
    @EJB DataService servicio;
    
    @PostConstruct
    public void cargarAlumnos(){
        alumnosList = servicio.getAlumnos();
    }
    
    public void guardarAlumno() {
        if (alumno.getId()!=null) {
            servicio.editAlumno(alumno);
        }else{
            servicio.saveAlumno(alumno);
        }
        alumno = new Alumno();
        cargarAlumnos();
    }
    
    public void llenarFormEditar(Alumno alumno){
        this.alumno.setId(alumno.getId());
        this.alumno.setNombre(alumno.getNombre());
        this.alumno.setCarnet(alumno.getCarnet());
    }
    
    public void eliminarAlumno(Alumno alumno){
        servicio.deleteAlumno(alumno);
        cargarAlumnos();
    }
    
    public List<Alumno> getAlumnosList(){
        return alumnosList;
    }
    
    public void setAlumnosList(List<Alumno> alumnosList){
        this.alumnosList = alumnosList;
    }
    
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }
    
    public Alumno getSelectedAlumno() { // Getter para selectedAlumno
        return selectedAlumno;
    }

    public void setSelectedAlumno(Alumno selectedAlumno) { // Setter para selectedAlumno
        this.selectedAlumno = selectedAlumno;
    }
}
