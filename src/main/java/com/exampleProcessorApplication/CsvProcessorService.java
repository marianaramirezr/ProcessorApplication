package com.exampleProcessorApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exampleProcessorApplication.ValidationClient;
import com.exampleProcessorApplication.Person;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CsvProcessorService {
    @Autowired
    private ValidationClient validationClient;

    // Procesa el archivo CSV y lo envía al servicio de validación
    public String processCsv(String filePath) {
        try {
            // Leer todas las líneas del archivo CSV
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            // Convertir cada línea a un objeto "Person" y validarla
            List<Person> persons = lines.stream()
                    .map(line -> parseLineToPerson(line))
                    .collect(Collectors.toList());

            // Enviar cada registro al servicio de validación
            long validCount = persons.stream()
                    .filter(person -> validationClient.validatePerson(person))
                    .count();

            return "Registros válidos: " + validCount + "/" + persons.size();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al procesar el archivo CSV.";
        }
    }

    // Método para convertir una línea de CSV en un objeto Person
    private Person parseLineToPerson(String line) {
        // Suponiendo que el CSV está separado por comas y tiene el formato: email,fechaNacimiento,titulo
        String[] fields = line.split(",");
        return new Person(fields[0],
                fields[1],
                fields[2]);
    }
}


