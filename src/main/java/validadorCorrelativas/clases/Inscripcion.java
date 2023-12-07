package validadorCorrelativas.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import validadorCorrelativas.clases.exceptions.SinMateriasAprobadasException;
import validadorCorrelativas.enums.Materias;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inscripcion {

    private Alumno alumno;
    private Materia materia;

    public boolean aprobada() throws SinMateriasAprobadasException {
        return (this.alumnoPuedeInscribirAMateria(this.alumno, this.materia));
    }

    private boolean alumnoPuedeInscribirAMateria(Alumno alumno, Materia materia) throws SinMateriasAprobadasException {

        boolean aproboCorrelativas;

        if (!materia.tieneCorrelativas()) {
            // if there is no correlative materias required, then the alumno can inscribir.
            aproboCorrelativas = true;
        } else {

            aproboCorrelativas = materia.getMateriasCorrelativas().stream()
                                .allMatch(materiaCorrelativa ->

                            {
                                try {
                                    return alumno.materiaEstaAprobada(materiaCorrelativa);
                                } catch (SinMateriasAprobadasException e) {
                                    System.out.println("Exception arrojada: El alumno no tiene todas las materias correlativas aprobadas");
                                    return false;
                                }
                            });
//            alumno.materiaEstaAprobada(new Materia(Materias.HISTORIA));
//            aproboCorrelativas = true;
        }
        return aproboCorrelativas;

    }


}
