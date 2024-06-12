
package com.reylulu.webapp.controladores;

import com.reylulu.webapp.entidades.Alumno;
import com.reylulu.webapp.entidades.Inscripcion;
import com.reylulu.webapp.entidades.Materia;
import com.reylulu.webapp.negocio.DataService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class InscripcionController {
   private List<Inscripcion> inscripcionesList = new ArrayList<>();
   private List<Alumno> alumnosList = new ArrayList<>();
   private List<Materia> materiasList = new ArrayList<>();
   private Inscripcion inscripcion = new Inscripcion();
   private Inscripcion selectedInscripcion;
   @EJB
   DataService servicio;

   public InscripcionController() {
   }

   @PostConstruct
   public void cargarInscripciones() {
      this.inscripcionesList = this.servicio.getInscripciones();
      this.alumnosList = this.servicio.getAlumnos();
      this.materiasList = this.servicio.getMaterias();
      inscripcion = new Inscripcion();
      this.inscripcion.setAlumno(new Alumno()); // Inicializar Alumno
      this.inscripcion.setMateria(new Materia()); // Inicializar Materia
   }

   public void guardarInscripcion() {
      /*System.out.println("Guardando inscripción: " + this.inscripcion);
      System.out.println("Alumno: " + this.inscripcion.getAlumno());
      System.out.println("Materia: " + this.inscripcion.getMateria());

      if (this.inscripcion.getId() != null) {
         this.servicio.editInscripcion(this.inscripcion);
      } else {
         this.servicio.saveInscripcion(this.inscripcion);
      }
      this.inscripcion = new Inscripcion();
      this.inscripcion.setAlumno(new Alumno()); // Inicializar Alumno después de guardar
      this.inscripcion.setMateria(new Materia()); // Inicializar Materia después de guardar
      this.cargarInscripciones();
*/
      this.servicio.saveInscripcion(this.inscripcion);
       this.inscripcion = new Inscripcion();
      this.inscripcion.setAlumno(new Alumno()); // Inicializar Alumno después de guardar
      this.inscripcion.setMateria(new Materia()); // Inicializar Materia después de guardar
      this.cargarInscripciones();
   }

   public void llenarFormEditar(Inscripcion inscripcion) {
      this.inscripcion.setId(inscripcion.getId());
      this.inscripcion.setAlumno(inscripcion.getAlumno());
      this.inscripcion.setMateria(inscripcion.getMateria());
      this.inscripcion.setCiclo(inscripcion.getCiclo());
      this.inscripcion.setAnio(inscripcion.getAnio());
      this.inscripcion.setFechaInscripcion(inscripcion.getFechaInscripcion());
   }

   public void eliminarInscripcion(Inscripcion inscripcion) {
      this.servicio.deleteInscripcion(inscripcion);
      this.cargarInscripciones();
   }

   public List<Inscripcion> getInscripcionesList() {
      return this.inscripcionesList;
   }

   public void setInscripcionesList(List<Inscripcion> inscripcionesList) {
      this.inscripcionesList = inscripcionesList;
   }

   public void setInscripcion(Inscripcion inscripcion) {
      this.inscripcion = inscripcion;
   }

   public Inscripcion getInscripcion() {
      return this.inscripcion;
   }

   public Inscripcion getSelectedInscripcion() {
      return this.selectedInscripcion;
   }

   public void setSelectedInscripcion(Inscripcion selectedInscripcion) {
      this.selectedInscripcion = selectedInscripcion;
   }

   public List<Alumno> getAlumnosList() {
      return this.alumnosList;
   }

   public void setAlumnosList(List<Alumno> alumnosList) {
      this.alumnosList = alumnosList;
   }

   public List<Materia> getMateriasList() {
      return this.materiasList;
   }

   public void setMateriasList(List<Materia> materiasList) {
      this.materiasList = materiasList;
   }
}