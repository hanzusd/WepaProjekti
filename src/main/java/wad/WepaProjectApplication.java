package wad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WepaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WepaProjectApplication.class, args);
    }

    public static String githubUrl() {
        return "https://github.com/hanzusd/WepaProjekti.git";
    }

    public static String travisUrl() {
        return "https://travis-ci.org/hanzusd/WepaProjekti.svg?branch=master";
    }

    public static String herokuUrl() {
        return "https://lit-savannah-97328.herokuapp.com/";
    }
}
