package com.inn.qms.aop;


import com.inn.qms.anotations.GeneratePID;
import com.inn.qms.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;



@Aspect
@Component
@Slf4j
public class PersonIdGeneratorAspect {
        private static int count = 0;

        @Pointcut("execution(* com.inn.qms.serviceimpl.PersonServiceImpl.*(..)) ||  @annotation(com.inn.qms.anotations.GeneratePID)")
        public void generatePIDAnnotation() {
        }

        @AfterReturning(pointcut = "generatePIDAnnotation()", returning = "personObject")
        public void generatePIDAfterCreate(Person personObject) {
            log.info("Inside PersonIdGeneratorAspect class generatePIDAfterCreate method");
            if (personObject != null) {
                GeneratePID annotation = personObject.getClass().getDeclaredAnnotation(GeneratePID.class);
                if (annotation != null) {
                    String prefix = annotation.prefix();
                    int numDigits = annotation.numDigits();
                    String pid = generatePID(prefix, numDigits); // Call the generatePID method to get the PID
                    personObject.setPid(pid);
                }
            }
        }

        private synchronized String generatePID(String prefix, int numDigits) {
            // Increment the count and format it with leading zeros
            String formatString = "%s%0" + numDigits + "d"; // Use "%s" to include the prefix
            String pid = String.format(formatString, prefix, ++count);
            return pid;

        }
    }


