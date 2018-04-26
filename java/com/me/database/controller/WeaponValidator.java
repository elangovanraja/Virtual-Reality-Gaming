package com.me.database.controller;
import com.me.database.pojo.Guns;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

@Component
public class WeaponValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Guns.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Guns gun = (Guns) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weaponId", "error.invalid.user", "Weapon ID Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weaponName", "error.invalid.user", "Weapon Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gameId", "error.invalid.user", "Game ID Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.password", "Description Required");
    }
}
