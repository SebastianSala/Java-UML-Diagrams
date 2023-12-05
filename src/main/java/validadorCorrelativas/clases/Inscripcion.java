package validadorCorrelativas.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inscripcion {

    private Alumno alumno;
    private Materia materia;

    public boolean aprobada() {
        return ( this.alumnoPuedeInscribirAMateria(this.alumno, this.materia) );
    }

    private boolean alumnoPuedeInscribirAMateria(Alumno alumno, Materia materia) {

        boolean aproboCorrelativas;

        if (!materia.tieneCorrelativas()) {
//            return true;
            // if there is no correlative materias required, then the alumno can inscribir.
            aproboCorrelativas = true;
        } else {
            aproboCorrelativas =
                    materia.getMateriasCorrelativas().stream().filter(materiaCorrelativa -> alumno.getMateriasAprobadas().contains(materiaCorrelativa)).count() == materia.getMateriasCorrelativas().size();
        }

        return aproboCorrelativas;

    }


}
