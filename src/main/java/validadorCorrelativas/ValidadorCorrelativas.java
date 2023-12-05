package validadorCorrelativas;

import validadorCorrelativas.clases.Alumno;
import validadorCorrelativas.clases.Inscripcion;
import validadorCorrelativas.clases.Materia;

public class ValidadorCorrelativas {

    public static void main(String[] args) {
        ValidadorCorrelativas validadorCorrelativas = new ValidadorCorrelativas();
        validadorCorrelativas.run();
    }

    public void run() {
        Alumno alumno1 = new Alumno();
        Materia materia1 = new Materia(Materias.HISTORIA);

        Alumno alumno2 = new Alumno();
        Materia materia2 = new Materia(Materias.MATEMATICA2);
        materia2.agregarCorrelativas(new Materia(Materias.MATEMATICA1));
        alumno2.agregarMateriaAprobada(new Materia(Materias.LENGUA1));

        Inscripcion inscripcion1 = new Inscripcion(alumno1, materia1);
        String inscripto1 = inscripcion1.aprobada() ? "Inscripto" : "No inscripto";
        System.out.println("La inscripcion 1 esta: " + inscripto1);

        Inscripcion inscripcion2 = new Inscripcion(alumno2, materia2);
        String inscripto2 = inscripcion2.aprobada() ? "Inscripto" : "No inscripto";
        System.out.println("La inscripcion 2 esta: " + inscripto2);

    }

}