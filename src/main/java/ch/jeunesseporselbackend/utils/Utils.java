package ch.jeunesseporselbackend.utils;

import java.lang.reflect.Field;
import java.time.Duration;
import java.time.LocalDateTime;

public class Utils {
    public static boolean hasNoEmptyFields(Object obj) throws IllegalAccessException {
        if (obj == null) {
            return false; // L'objet ne doit pas être nul
        }

        // Parcourir tous les champs de la classe
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true); // Permet d'accéder aux champs privés
            Object value = field.get(obj); // Récupère la valeur du champ

            if (value == null) {
                return false; // Champ nul
            }

            if (value instanceof String && ((String) value).isEmpty()) {
                return false; // Champ String vide
            }
        }
        return true; // Tous les champs sont non nuls et non vides
    }

    public static boolean isDateOlderThan5Minutes(LocalDateTime storedDateTime) {
        // Obtenez l'heure actuelle
        LocalDateTime now = LocalDateTime.now();

        // Calculez la différence en minutes
        Duration duration = Duration.between(storedDateTime, now);
        // Vérifiez si la durée est inférieur à 5 minutes
        return duration.toMinutes() < 5;
    }
}
