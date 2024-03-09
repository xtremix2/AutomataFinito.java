
package AutomatasUnidad5;

// Importar la clase HashMap para usar mapas 

import java.util.HashMap; 

  

// Definir la clase AutomataFinito 

public class AutomataFinito { 

  

    // Atributos de la clase 

    private String[] alfabeto; // El alfabeto del autómata 

    private String[] estados; // Los estados del autómata 

    private String estadoInicial; // El estado inicial del autómata 

    private String[] estadosFinales; // Los estados finales del autómata 

    private HashMap<String, HashMap<String, String>> funcionTransicion; // La función de transición del autómata 

  

    // Constructor de la clase 

    public AutomataFinito(String[] alfabeto, String[] estados, String estadoInicial, String[] estadosFinales, 

            HashMap<String, HashMap<String, String>> funcionTransicion) { 

        this.alfabeto = alfabeto; 

        this.estados = estados; 

        this.estadoInicial = estadoInicial; 

        this.estadosFinales = estadosFinales; 

        this.funcionTransicion = funcionTransicion; 

    } 

  

    // Método que verifica si una cadena pertenece al lenguaje del autómata 

    public boolean aceptarCadena(String cadena) { 

        // Inicializar el estado actual con el estado inicial 

        String estadoActual = estadoInicial; 

        // Recorrer cada símbolo de la cadena 

        for (int i = 0; i < cadena.length(); i++) { 

            // Obtener el símbolo actual 

            String simbolo = cadena.substring(i, i + 1); 

            // Verificar si el símbolo pertenece al alfabeto 

            if (perteneceAlfabeto(simbolo)) { 

                // Obtener el estado siguiente según la función de transición 

                String estadoSiguiente = funcionTransicion.get(estadoActual).get(simbolo); 

                // Actualizar el estado actual con el estado siguiente 

                estadoActual = estadoSiguiente; 

            } else { 

                // Si el símbolo no pertenece al alfabeto, rechazar la cadena 

                return false; 

            } 

        } 

        // Verificar si el estado actual es final 

        if (esFinal(estadoActual)) { 

            // Si el estado actual es final, aceptar la cadena 

            return true; 

        } else { 

            // Si el estado actual no es final, rechazar la cadena 

            return false; 

        } 

    } 

  

    // Método que verifica si un símbolo pertenece al alfabeto 

    public boolean perteneceAlfabeto(String simbolo) { 

        // Recorrer cada símbolo del alfabeto 

        for (int i = 0; i < alfabeto.length; i++) { 

            // Comparar el símbolo con el símbolo del alfabeto 

            if (simbolo.equals(alfabeto[i])) { 

                // Si son iguales, retornar verdadero 

                return true; 

            } 

        } 

        // Si no se encontró el símbolo, retornar falso 

        return false; 

    } 

  

    // Método que verifica si un estado es final 

    public boolean esFinal(String estado) { 

        // Recorrer cada estado final 

        for (int i = 0; i < estadosFinales.length; i++) { 

            // Comparar el estado con el estado final 

            if (estado.equals(estadosFinales[i])) { 

                // Si son iguales, retornar verdadero 

                return true; 

            } 

        } 

        // Si no se encontró el estado, retornar falso 

        return false; 

    } 

  

    // Método principal para probar el autómata 

    public static void main(String[] args) { 

        // Definir el alfabeto del autómata 

        String[] alfabeto = { "0", "1" }; 

        // Definir los estados del autómata 

        String[] estados = { "q0", "q1", "q2", "q3" }; 

        // Definir el estado inicial del autómata 

        String estadoInicial = "q0"; 

        // Definir los estados finales del autómata 

        String[] estadosFinales = { "q3" }; 

        // Definir la función de transición del autómata usando mapas anidados 

        HashMap<String, HashMap<String, String>> funcionTransicion = new HashMap<>(); 

        funcionTransicion.put("q0", new HashMap<>()); 

        funcionTransicion.put("q1", new HashMap<>()); 

        funcionTransicion.put("q2", new HashMap<>()); 

        funcionTransicion.put("q3", new HashMap<>()); 

        funcionTransicion.get("q0").put("0", "q1"); 

        funcionTransicion.get("q0").put("1", "q0"); 

        funcionTransicion.get("q1").put("0", "q2"); 

        funcionTransicion.get("q1").put("1", "q0"); 

        funcionTransicion.get("q2").put("0", "q2"); 

        funcionTransicion.get("q2").put("1", "q3"); 

        funcionTransicion.get("q3").put("0", "q3"); 

        funcionTransicion.get("q3").put("1", "q3"); 

        // Crear un objeto de la clase AutomataFinito con los datos anteriores 

        AutomataFinito af = new AutomataFinito(alfabeto, estados, estadoInicial, estadosFinales, funcionTransicion); 

        // Probar algunas cadenas con el método aceptarCadena 

        System.out.println(af.aceptarCadena("001")); // true 

        System.out.println(af.aceptarCadena("010")); // false 

        System.out.println(af.aceptarCadena("10011")); // true 

        System.out.println(af.aceptarCadena("10101")); // false 

    } 

} 