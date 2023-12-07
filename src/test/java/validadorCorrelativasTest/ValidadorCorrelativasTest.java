package validadorCorrelativasTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import validadorCorrelativas.clases.exceptions.SinMateriasAprobadasException;
import validadorCorrelativas.enums.Materias;
import validadorCorrelativas.clases.Alumno;
import validadorCorrelativas.clases.Inscripcion;
import validadorCorrelativas.clases.Materia;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ValidadorCorrelativasTest {

    private Alumno alumno;
    private Materia materia;
    private Inscripcion inscripcion;

    @BeforeEach
    public void inicializacionPrueba() {
        this.alumno = null;
        this.materia = null;
        this.inscripcion = null;
    }

    @Order(1)
    @Test
    public void alumnoInscribeAMateriaSinCorrelativaNecesariaSatisfactoriamente() throws SinMateriasAprobadasException {

        this.alumno = new Alumno();
        this.materia = new Materia(Materias.HISTORIA);
        this.inscripcion = new Inscripcion(alumno, materia);

        assertTrue(this.inscripcion.aprobada());
    }

    @Order(2)
    @Test
    public void alumnoConMateriasAprobadasInscribeAMateriaConCorrelativaNecesariaSatisfactoriamente() throws SinMateriasAprobadasException {

        //        List<Materia> materias = List.of(new Materia(), new Materia());
        this.alumno = new Alumno(
                new ArrayList<>(List.of(new Materia(Materias.MATEMATICA1), new Materia(Materias.LENGUA1)))
        );
        this.materia = new Materia(Materias.MATEMATICA2);
//        this.materia.agregarCorrelativas(new Materia(Materias.MATEMATICA1));
        this.materia.agregarCorrelativas(List.of(new Materia(Materias.MATEMATICA1), new Materia(Materias.LENGUA1)));


        this.inscripcion = new Inscripcion(alumno, materia);

        assertTrue(this.inscripcion.aprobada());
    }

    @Order(3)
    @Test
    public void alumnoConMateriasNoAprobadasInscribeAMateriaConCorrelativaNecesariaFallando() throws SinMateriasAprobadasException {

        this.alumno = new Alumno(List.of(new Materia(Materias.LENGUA1)));

        this.materia = new Materia(Materias.LENGUA3);
        materia.agregarCorrelativas(new Materia(Materias.LENGUA2));

        this.inscripcion = new Inscripcion(alumno, materia);

//        assertThrowsExactly(SinMateriasAprobadasException.class, () -> this.inscripcion.aprobada());
        assertFalse(this.inscripcion.aprobada());
    }

}
