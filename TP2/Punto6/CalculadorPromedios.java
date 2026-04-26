package TP2.Punto6;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.io.File;
import java.util.ArrayList;

public class CalculadorPromedios {

    public void promediarAlumnos(String ruta, String carpetaDestino, String nombreNuevoArchivo) throws Exception {

        File archivo = new File(ruta);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(archivo);
        doc.getDocumentElement().normalize();

        NodeList listaNodos = doc.getElementsByTagName("alumno");

        
        ArrayList<String> nombres = new ArrayList<>(); //son los alumnos a los que ya se les calculo el promedio
        ArrayList<Double> sumas = new ArrayList<>(); //cada indice es la suma de las notas de un alumno
        ArrayList<Integer> contadores = new ArrayList<>(); //cada indice es la cantidad de sumas de notas de un alumno

        double sumaGlobal = 0;
        int totalRegistros = 0; //para calcular el promedio de todos

        for (int i = 0; i < listaNodos.getLength(); i++) {
            Element e = (Element) listaNodos.item(i);

            String nombreLeido = e.getElementsByTagName("nombre").item(0).getTextContent().trim();
            double notaLeida = Double.parseDouble(e.getElementsByTagName("nota").item(0).getTextContent().trim());

            sumaGlobal = sumaGlobal + notaLeida;
            totalRegistros++;

            // Búsqueda manual en el vector de nombres
            int indice = -1;
            int j = 0;
            while(j < nombres.size() && indice != j){
                if (nombres.get(j).equalsIgnoreCase(nombreLeido)) {
                    indice = j;
                }
                else{
                    j++;
                }
            }
            

            if (indice != -1) {
                // actualiza los datos en la posicion encontrada
                sumas.set(indice, sumas.get(indice) + notaLeida);
                contadores.set(indice, contadores.get(indice) + 1);
            } else {
                // si el alumno no estaba antes, lo añade en el array de alumnos
                nombres.add(nombreLeido);
                sumas.add(notaLeida);
                contadores.add(1);
            }
        }

        generarXMLInforme(nombres, sumas, contadores, (sumaGlobal / totalRegistros), nombreNuevoArchivo, carpetaDestino);
        System.out.println("---------------------------------------------------------");
        imprimirPromedios(nombres, sumas, contadores);
        System.out.println("---------------------------------------------------------");
        imprimirPromedioTotal(sumaGlobal, totalRegistros);

    }


    private void imprimirPromedios(ArrayList<String> nombres, ArrayList<Double> sumas, ArrayList<Integer> contadores){
        System.out.println("PROMEDIOS INDIVIDUALES:");
        for (int i = 0; i < nombres.size(); i++) {
            double promedio = sumas.get(i) / contadores.get(i);
            System.out.println("Alumno: " + nombres.get(i) + " | Promedio: " + promedio);
        }
    }

    private void imprimirPromedioTotal(double sumaGlobal, int total) {
        if (total > 0) { //para que no existan divisiones por 0
            System.out.printf("Promedio de todas las notas: " + (sumaGlobal / total));
        }
    }

    // generador de nuevo xml
    private void generarXMLInforme(ArrayList<String> nombres, ArrayList<Double> sumas, ArrayList<Integer> contadores, double promedioGeneral, String nombreArchivo, String carpeta) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document docResult = db.newDocument();

        
        Element root = docResult.createElement("informe_promedios");
        docResult.appendChild(root);

        //guarda los promedios individuales
        for (int i = 0; i < nombres.size(); i++) {
            Element alumno = docResult.createElement("alumno");
            alumno.setAttribute("nombre", nombres.get(i));
            
            double promedio = sumas.get(i) / contadores.get(i);
            alumno.appendChild(docResult.createTextNode(String.valueOf(promedio)));
            
            root.appendChild(alumno);
        }

        // promedio total
        Element total = docResult.createElement("promedio_total");
        total.appendChild(docResult.createTextNode(String.valueOf(promedioGeneral)));
        root.appendChild(total);

        // Guarda el archivo
        File archivoDestino = new File(carpeta, nombreArchivo.concat(".xml"));
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Para que el xml no quede todo en una sola linea
        
        DOMSource source = new DOMSource(docResult);
        StreamResult result = new StreamResult(archivoDestino);
        transformer.transform(source, result);
        
        System.out.println("Se ha creado el archivo " + nombreArchivo.concat(".xml") + " con éxito.");
    }
}