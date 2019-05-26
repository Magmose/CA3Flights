package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {
    public static void main(String[] args) {
        
        Persistence.generateSchema("pu", null);
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
//        DBFacade dbf = new DBFacade(emf);
    }
}
