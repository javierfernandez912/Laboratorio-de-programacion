package TP2.Punto6;
public class Main {
    public static void main(String[] args) {
        CalculadorPromedios c1 = new CalculadorPromedios();
        try {
            c1.promediarAlumnos("TP2/Punto5/Calificaciones.xml", "TP2/Punto6", "promedioDeAlumnos"); 
            //los parametros son
            //ruta de donde agarra el xml a promediar
            //ruta donde va a guardar el nuevo archivo
            //nombre del nuevo archivo

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}