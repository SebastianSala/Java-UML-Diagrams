package validadorCorrelativas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import validadorCorrelativas.clases.Alumno;
import validadorCorrelativas.clases.Inscripcion;
import validadorCorrelativas.clases.Materia;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidadorCorrelativasTest {

    private Alumno alumno;
    private Materia materia;
    private Inscripcion inscripcion;

    @BeforeEach
    public void inicializacionPrueba() {
//        this.alumno = new Alumno();
//        this.materia = new Materia();
//        this.inscripcion = new Inscripcion();
    }

    @Order(1)
    @Test
    public void alumnoInscribeAMateriaSinCorrelativaNecesariaSatisfactoriamente() {

        this.alumno = new Alumno();
        this.materia = new Materia(Materias.HISTORIA);
        this.inscripcion = new Inscripcion(alumno, materia);

        boolean expected = true;
        assertEquals(expected, this.inscripcion.aprobada());

    }

    @Order(2)
    @Test
    public void alumnoConMateriasAprobadasInscribeAMateriaConCorrelativaNecesariaSatisfactoriamente() {

        //        List<Materia> materias = List.of(new Materia(), new Materia());
        this.alumno = new Alumno(
                new ArrayList<>(List.of(new Materia(Materias.MATEMATICA1), new Materia(Materias.LENGUA1)))
        );
        this.materia = new Materia(Materias.MATEMATICA2);
        this.materia.agregarCorrelativas(new Materia(Materias.MATEMATICA1));
        this.materia.agregarCorrelativas(List.of(new Materia(Materias.MATEMATICA1), new Materia(Materias.LENGUA1)));


        this.inscripcion = new Inscripcion(alumno, materia);

        boolean expected = true;
        assertEquals(expected, this.inscripcion.aprobada());

    }

    @Order(3)
    @Test
    public void alumnoConMateriasNoAprobadasInscribeAMateriaConCorrelativaNecesariaFallando() {

        this.alumno = new Alumno(List.of(new Materia(Materias.LENGUA1)));

        this.materia = new Materia(Materias.LENGUA3);
        materia.agregarCorrelativas(new Materia(Materias.LENGUA2));

        this.inscripcion = new Inscripcion(alumno, materia);

        boolean expected = false;
        assertEquals(expected, this.inscripcion.aprobada());

    }

}
