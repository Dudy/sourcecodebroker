package de.podolak.sourcecodebroker.data.json;

import de.podolak.sourcecodebroker.data.Project;
import de.podolak.sourcecodebroker.data.code.Node;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Dude
 */
public class SerializationDemoTest {
    
    public SerializationDemoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of write method, of class SerializationDemo.
     */
    @Ignore
    @Test
    public void testWrite() {
        System.out.println("write");
        Project project = null;
        SerializationDemo.write(project);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class SerializationDemo.
     */
    @Ignore
    @Test
    public void testToString() {
        System.out.println("toString");
        Project project = null;
        String expResult = "";
        String result = SerializationDemo.toString(project);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class SerializationDemo.
     */
    @Ignore
    @Test
    public void testRead_0args() {
        System.out.println("read");
        Project expResult = null;
        Project result = SerializationDemo.read();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readNode method, of class SerializationDemo.
     */
    @Ignore
    @Test
    public void testReadNode() {
        System.out.println("readNode");
        Node expResult = null;
        Node result = SerializationDemo.readNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class SerializationDemo.
     */
    @Ignore
    @Test
    public void testRead_String() {
        System.out.println("read");
        String jsonText = "";
        Project expResult = null;
        Project result = SerializationDemo.read(jsonText);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDummyProject method, of class SerializationDemo.
     */
    @Test
    public void testGetDummyProject() {
        System.out.println("getDummyProject");
        Project expResult = null;
        Project result = SerializationDemo.getDummyProject();
        
        System.out.println(result);
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDummyNode method, of class SerializationDemo.
     */
    @Ignore
    @Test
    public void testGetDummyNode() {
        System.out.println("getDummyNode");
        Node expResult = null;
        Node result = SerializationDemo.getDummyNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
