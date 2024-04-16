package com.inn.qms.aop;


import com.inn.qms.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;


@Aspect
@Component
@Slf4j
public class PersonIdGeneratorAspect {

    private static final Logger logger = LogManager.getLogger(PersonIdGeneratorAspect.class);
    private static final AtomicInteger counter = new AtomicInteger(1);

    @AfterReturning(pointcut = "execution(* *(..)) && @annotation(com.inn.qms.anotations.PIDGenerater)", returning = "person")
    public void generateId(Person person) throws IllegalAccessException {
        logger.info("inside aspect");
        logger.debug("Aspect triggered for entity: {}", person.getClass().getSimpleName());


        Field[] fields = person.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(com.inn.qms.anotations.PIDGenerater.class)) {
                field.setAccessible(true);
                com.inn.qms.anotations.PIDGenerater generatedIdAnnotation = field.getAnnotation(com.inn.qms.anotations.PIDGenerater.class);
                String prefix = generatedIdAnnotation.prefix();
                int numDigits = generatedIdAnnotation.numDigits();
                int id = counter.getAndIncrement();
                String formattedId = String.format(prefix + "%0" + numDigits + "d", id);
                logger.info("formattedId {}",formattedId);
                field.set(person, formattedId);
            }
        }
    }
}
