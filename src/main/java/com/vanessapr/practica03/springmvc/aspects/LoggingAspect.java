package com.vanessapr.practica03.springmvc.aspects;

import com.vanessapr.practica03.springmvc.beans.Client;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
    public static final Logger logger = Logger.getLogger(LoggingAspect.class);

    @After("execution(* com.vanessapr.practica03.springmvc.services.impl.*Service*.save*(..)) ||" +
            "execution(* com.vanessapr.practica03.springmvc.services.impl.*Service*.update*(..)) ||" +
            "execution(* com.vanessapr.practica03.springmvc.services.impl.*Service*.find*(..)) ||" +
            "execution(* com.vanessapr.practica03.springmvc.services.impl.*Service*.remove*(..))")
    public void audit(JoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        Object[] parameters = joinPoint.getArgs();

        if (method.startsWith("save")) {
            logger.info("New client saving...");
        } else if (method.startsWith("update")) {
            Client client = (Client) parameters[0];
            logger.info("Updating client with ID -> " + client.getId());
        } else if (method.startsWith("remove")) {
            int id = (int) parameters[0];
            logger.info("Deleting client with ID -> " + id);
        }  else if (method.startsWith("findAll")) {
            logger.info("Listing clients...");
        } else if (method.startsWith("find")) {
            int id = (int) parameters[0];
            logger.info("Searching client ID -> " + id);
        }
    }
}
