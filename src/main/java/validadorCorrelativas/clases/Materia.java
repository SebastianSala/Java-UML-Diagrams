package validadorCorrelativas.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import validadorCorrelativas.enums.Materias;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Materia {

//    private String nombre;
    private Materias nombre;
    private List<Materia> materiasCorrelativas = new ArrayList<>();

    public Materia(Materias nombre) {
        this.nombre = nombre;
    }

    public void agregarCorrelativas(List<Materia> materias) {
        this.materiasCorrelativas.addAll(materias);
    }

    public void agregarCorrelativas(Materia materia) {
        this.materiasCorrelativas.add(materia);
    }

    public boolean tieneCorrelativas() {
        return !this.materiasCorrelativas.isEmpty();
    }

}
