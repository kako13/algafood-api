package com.algaworks.algafood.core.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

public class MultiploValidator implements ConstraintValidator<Multiplo, Number> {

    private int numeroMultiplo;

    @Override
    public void initialize(Multiplo constraintAnnotation) {
        numeroMultiplo = constraintAnnotation.numero();
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext constraintValidatorContext) {

        boolean valido = true;

        if(value != null){
            var valorDecimal = BigDecimal.valueOf(value.doubleValue());
            var multiploDecimal = BigDecimal.valueOf(this.numeroMultiplo);

            BigDecimal resto = valorDecimal.remainder(multiploDecimal); //pega o resto da divisao
            valido = BigDecimal.ZERO.compareTo(resto) == 0;
        }

        return valido;
    }
}
