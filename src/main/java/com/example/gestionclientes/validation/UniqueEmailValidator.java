package com.example.gestionclientes.validation;

import com.example.gestionclientes.repository.ClienteRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private static ApplicationContext context;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (email == null) return false;

        ClienteRepository clienteRepository = context.getBean(ClienteRepository.class);
        return !clienteRepository.existsByEmail(email);
    }
}
