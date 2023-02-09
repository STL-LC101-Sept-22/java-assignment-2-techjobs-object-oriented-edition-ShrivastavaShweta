package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester",new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(job.getName() instanceof String);
        assertEquals(job.getName(), "Product tester");

        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals(job.getEmployer().getValue(), "ACME");

        assertTrue(job.getLocation() instanceof Location);
        assertEquals(job.getLocation().getValue(), "Desert");

        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals(job.getPositionType().getValue(), "Quality control");

        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester",new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job job2 = new Job("Product tester",new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("Product tester",new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String output = job.toString();
        assertEquals(output.charAt(0), '\n');
        assertEquals(output.charAt(output.length()-1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job = new Job("Product tester",new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String output = job.toString();
        int id = job.getId();
        String expectedOutput = "\nID: " + id +
                "\nName: " + "Product tester"  +
                "\nEmployer: " + "ACME" +
                "\nLocation: " + "Desert" +
                "\nPosition Type: " + "Quality control" +
                "\nCore Competency: " + "Persistence" + "\n";

        assertEquals(output, expectedOutput);

//        assertTrue(output.contains("ID"));
//        assertTrue(output.contains("Name"));
//        assertTrue(output.contains("Employer"));
//        assertTrue(output.contains("Location"));
//        assertTrue(output.contains("Position Type"));
//        assertTrue(output.contains("Core Competency"));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job("Web Developer",new Employer(""), new Location("STL"),
                new PositionType(""), new CoreCompetency("Java"));

        String output = job.toString();
        int id = job.getId();
        String expectedOutput = "\nID: " + id +
                "\nName: " + "Web Developer"  +
                "\nEmployer: " + "Data not available" +
                "\nLocation: " + "STL" +
                "\nPosition Type: " + "Data not available" +
                "\nCore Competency: " + "Java" + "\n";

        assertEquals(output, expectedOutput);
    }



}
