package com.Javaguide.springbootrestapiwithDB.generator;

import java.io.Serializable;
import java.util.Random;

import com.Javaguide.springbootrestapiwithDB.Repository.UserRepository;
import com.Javaguide.springbootrestapiwithDB.services.UserService;
import org.hibernate.HibernateException;
import org.hibernate.boot.jaxb.SourceType;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomIdGenerator implements IdentifierGenerator {
    @Autowired
    private UserService serv;
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 5;

        Random random = new Random();
        String customId;
        boolean isUnique = false;

        do {
            StringBuilder tempCustomId = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                tempCustomId.append(characters.charAt(index));
            }
            customId = tempCustomId.toString();

            // Check if the generated ID is unique in the database
            // Example: You would use your repository to check for uniqueness
            System.out.println("Id-"+ customId);
           //boolean exists = serv.existsByCustomId(customId);
            //System.out.println("Status-    "+ exists);

            // For demonstration purposes, let's assume the ID is unique each time
            isUnique = true;
        } while (!isUnique);

        return customId;
    }
}
