package validadorCorrelativas.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import validadorCorrelativas.clases.exceptions.SinMateriasAprobadasException;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {

    private List<Materia> materiasAprobadas = new ArrayList<>();

    public void agregarMateriaAprobada(Materia materia) {
        this.materiasAprobadas.add(materia);
    }

    public boolean materiaEstaAprobada(Materia materia) throws SinMateriasAprobadasException {

        boolean aprobada = false;

        if (!this.materiasAprobadas.contains(materia)) {
            throw new SinMateriasAprobadasException(this.getClass().getName());
        } else {
            aprobada = true;
        }

        return aprobada;

    }

}
