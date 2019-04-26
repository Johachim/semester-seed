package utils;

import entity.Role;
import entity.User;
import javax.persistence.EntityManager;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManager em = PuSelector.getEntityManagerFactory("pu").createEntityManager();
       
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    
    //throw new UnsupportedOperationException("REMOVE THIS LINE, WHEN YOU HAVE READ WARNING");
    
    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    User user = new User("user", "1234");
    user.addRole(userRole);
    User admin = new User("admin", "1234");
    admin.addRole(adminRole);
    User both = new User("user_admin", "1234");
    both.addRole(userRole);
    both.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("1234"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1234"));
    System.out.println("Created TEST Users");
   
  }

}
