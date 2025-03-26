package com.ssnagin.lab5java.sem2.lab5.validation;

import com.ssnagin.lab5java.sem2.lab5.reflection.accessors.CombiningValueAccessorManager;
import com.ssnagin.lab5java.sem2.lab5.validation.factories.ValidatorFactory;
import com.ssnagin.lab5java.sem2.lab5.validation.validators.Validator;
import lombok.Getter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidationManager {

    @Getter
    private static final ValidationManager instance = new ValidationManager();

    private final List<ValidatorFactory> validatorFactories = new ArrayList<>();
    public void validate(Object object) {
        // Посмотреть все declaredFields
        // getterAccessor
        // fieldAccessor

        if (object == null) throw new IllegalArgumentException("Object cannot be null in validation");

        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            validateField(object, field);
        }
    }

    public void register(ValidatorFactory validatorFactory) {
        this.validatorFactories.add(validatorFactory);
    }

    public void validateField(Object object, Field field) {
        Annotation[] annotations = field.getAnnotations();

        for (Annotation annotation : annotations) {
            ValidatorFactory<?> validatorFactory = findCompatibleFactory(annotation.annotationType());

            if (validatorFactory != null) {
                CombiningValueAccessorManager.getDefaultInstance().accessValue(field.getType(), field, object);
            }
        }
    }

    private ValidatorFactory<?> findCompatibleFactory(Class<? extends Annotation> annotationType) {
        for (ValidatorFactory<?> factory : validatorFactories) {
            if (factory.isCompatibleWith(annotationType)) {
                return factory;
            }
        }
        return null;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void validateWithFactory(Object object, Field field, Annotation annotation, ValidatorFactory factory) {

        try {
            CombiningValueAccessorManager valueAccessorManager = new CombiningValueAccessorManager();

            Object fieldValue = valueAccessorManager.accessValue(field.getType(), field, object);

            Validator validator = factory.create(annotation);

            validator.validate(fieldValue);
        } catch (Exception e) {
            throw new ValidationException(
                    String.format("Validation failed for field '%s' in class %s: %s",
                            field.getName(),
                            object.getClass().getName(),
                            e.getMessage()),
                    e);
        }
    }
}
