package wad;

import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.*;
import static org.junit.Assert.assertTrue;

public class AliveTest {

    @Points("04-04.1")
    @Test
    public void hasGithub() {
        assertTrue(WepaProjectApplication.githubUrl().contains("github.com/"));
    }

    @Points("04-04.2")
    @Test
    public void hasTravis() {
        assertTrue(WepaProjectApplication.travisUrl().contains("travis-ci.org/"));
    }

    @Points("04-04.3")
    @Test
    public void hasHerokuapp() {
        assertTrue(WepaProjectApplication.herokuUrl().contains("herokuapp.com"));
    }

}
