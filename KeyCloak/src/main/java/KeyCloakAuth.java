import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@EnableAutoConfiguration
@SpringBootApplication
public class KeyCloakAuth {

    public static void main (String[] args) {
        SpringApplication.run(KeyCloakAuth.class, args);
        Keycloak kc = Keycloak.getInstance(
                "http://localhost:8080/auth", "master", "admin", "admin",
                "admin-cli");

      System.out.println(kc.realm("master").users().get("darsh"));

       /* CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue("test123");
        UserRepresentation user = new UserRepresentation();
        user.setUsername("testuser");
        user.setFirstName("Test");
        user.setLastName("User");
        user.setCredentials(Arrays.asList(credential));
        user.setEnabled(true) ;
        kc.realm("master").users().create(user);*/
    }
}
