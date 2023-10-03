package com.algaworks.algafood.core.validation;

import com.fasterxml.jackson.core.io.BigDecimalParser;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ValidationException;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

public class ValorZeroIncluiDescricaoValidator implements ConstraintValidator<ValorZeroIncluiDescricao, Object> {

    String valorField;
    String descricaoField;
    String descricaoObrigatoria;

    @Override
    public void initialize(ValorZeroIncluiDescricao constraint) {
        valorField = constraint.valorField();
        descricaoField = constraint.descricaoField();
        descricaoObrigatoria = constraint.descricaoObrigatoria();
    }

    @Override
    public boolean isValid(Object classeAnotada, ConstraintValidatorContext constraintValidatorContext) {

        boolean valido = false;

        try {

            BigDecimal valor = BigDecimalParser.parse(
                    BeanUtils.getPropertyDescriptor(classeAnotada.getClass(), this.valorField)
                            .getReadMethod()
                            .invoke(classeAnotada).toString());

            String descricao = BeanUtils.getPropertyDescriptor(classeAnotada.getClass(), this.descricaoField)
                    .getReadMethod()
                    .invoke(classeAnotada).toString();

            if (valor != null && BigDecimal.ZERO.compareTo(valor) == 0 && descricao != null) {
                valido = descricao.toLowerCase().contains(this.descricaoObrigatoria.toLowerCase());
            }
            return valido;
        } catch (Exception e) {
            throw new ValidationException(e);
        }
    }
}
