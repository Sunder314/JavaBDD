package Class.TimeConversion;

import java.sql.Time;

public class TimeConversion {
    /**
     * Supprime les fractions de secondes d'une chaîne de temps
     * Exemple : "00:12:34.0000000" -> "00:12:34"
     *
     * @param timeString La chaîne d'entrée contenant un temps
     * @return La chaîne sans fractions de secondes
     */
    public static String removeFraction(String timeString) {
        // Si la chaîne contient un point, tronquer à ce niveau
        if (timeString.contains(".")) {
            return timeString.split("\\.")[0]; // Garde uniquement "HH:mm:ss"
        }
        return timeString; // Retourne la chaîne inchangée si elle n'a pas de "."
    }
}


