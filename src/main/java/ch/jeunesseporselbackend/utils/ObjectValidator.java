package ch.jeunesseporselbackend.utils;

import java.lang.reflect.Field;

public class ObjectValidator {
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
}
