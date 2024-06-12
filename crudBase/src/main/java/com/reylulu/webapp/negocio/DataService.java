package com.reylulu.webapp.negocio;

import com.reylulu.webapp.entidades.Alumno;
import com.reylulu.webapp.entidades.Inscripcion;
import com.reylulu.webapp.entidades.Inscripcion;
import com.reylulu.webapp.entidades.Materia;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author reylulu
 */
@Stateless
public class DataService {
    
    @PersistenceContext(unitName = "pu")
    EntityManager entityManager;
    
    //METODO PARA LISTAR ALUMNOS
    public List<Alumno> getAlumnos(){
        //ORDENA POR ID DESDE EL MENOR HASTA EL MAYOR
        Query query = entityManager.createQuery("SELECT e FROM Alumno e ORDER BY e.id DESC");
        List<Alumno> alumnos = query.getResultList();
        return alumnos;
    }
    // METODO PARA ALMACENAR ALUMNOS
    @Transactional //PARA QUE SEA ATOMICA
    public void saveAlumno(Alumno alumno){
        entityManager.persist(alumno);
    }
    //METODO PARA MODIFICAR ALUMNOS
    @Transactional
    public void editAlumno(Alumno alumno){
        entityManager.merge(alumno);
    }
    //METODO PARA ELIMINAR ALUMNOS, SI HAY UN ERROR HACE UN ROLLBACK
    @Transactional
    public void deleteAlumno(Alumno alumno){
        Alumno alumnoEliminar = entityManager.find(Alumno.class, alumno.getId());
        entityManager.remove(alumnoEliminar);
    }
    ///////////////////// MATERIA /////////////////////////
    //METODO PARA LISTAR MATERIAS
    public List<Materia> getMaterias(){
        //ORDENA POR ID DESDE EL MENOR HASTA EL MAYOR
        Query query = entityManager.createQuery("SELECT e FROM Materia e ORDER BY e.id DESC");
        List<Materia> materias = query.getResultList();
        return materias;
    }
    // METODO PARA ALMACENAR MATERIAS
    @Transactional //PARA QUE SEA ATOMICA
    public void saveMateria(Materia materia){
        entityManager.persist(materia);
    }
    //METODO PARA MODIFICAR MATERIAS
    @Transactional
    public void editMateria(Materia materia){
        entityManager.merge(materia);
    }
    //METODO PARA ELIMINAR MATERIAS, SI HAY UN ERROR HACE UN ROLLBACK
    @Transactional
    public void deleteMateria(Materia materia){
        Materia materiaEliminar = entityManager.find(Materia.class, materia.getId());
        entityManager.remove(materiaEliminar);
    }
    
    //METODO PARA LISTAR Inscripciones
     public List<Inscripcion> getInscripciones() {
        Query query = entityManager.createQuery("SELECT e FROM Inscripcion e ORDER BY e.id DESC");
        List<Inscripcion> inscripciones = query.getResultList();
        return inscripciones;
    }
    
    // METODO PARA ALMACENAR Inscripciones
    @Transactional
    public void saveInscripcion(Inscripcion inscripcion) {
        entityManager.persist(inscripcion);
    }
    
    // METODO PARA Modificar Inscripciones
    @Transactional
    public void editInscripcion(Inscripcion inscripcion) {
        entityManager.merge(inscripcion);
    }
    
    //METODO PARA ELIMINAR INSCRIPCIONES, SI HAY UN ERROR HACE UN ROLLBACK
    @Transactional
    public void deleteInscripcion(Inscripcion inscripcion) {
        Inscripcion inscripcionEliminar = entityManager.find(Inscripcion.class, inscripcion.getId());
        entityManager.remove(inscripcionEliminar);
    }
}
