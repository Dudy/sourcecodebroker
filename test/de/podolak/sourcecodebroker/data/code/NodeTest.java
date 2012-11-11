package de.podolak.sourcecodebroker.data.code;

import de.podolak.sourcecodebroker.data.json.SerializationDemo;
import java.util.List;
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
public class NodeTest {
    
    public NodeTest() {
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
     * Test of getName method, of class Node.
     */
    @Ignore
    @Test
    public void testGetName() {
        System.out.println("getName");
        Node instance = new Node();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Node.
     */
    @Ignore
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Node instance = new Node();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getText method, of class Node.
     */
    @Ignore
    @Test
    public void testGetText() {
        System.out.println("getText");
        Node instance = new Node();
        String expResult = "";
        String result = instance.getText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setText method, of class Node.
     */
    @Ignore
    @Test
    public void testSetText() {
        System.out.println("setText");
        String text = "";
        Node instance = new Node();
        instance.setText(text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChildren method, of class Node.
     */
    @Ignore
    @Test
    public void testGetChildren() {
        System.out.println("getChildren");
        Node instance = new Node();
        List expResult = null;
        List result = instance.getChildren();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChildren method, of class Node.
     */
    @Ignore
    @Test
    public void testSetChildren() {
        System.out.println("setChildren");
        List<Node> children = null;
        Node instance = new Node();
        instance.setChildren(children);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addChild method, of class Node.
     */
    @Ignore
    @Test
    public void testAddChild() {
        System.out.println("addChild");
        Node child = null;
        Node instance = new Node();
        boolean expResult = false;
        boolean result = instance.addChild(child);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeChild method, of class Node.
     */
    @Ignore
    @Test
    public void testRemoveChild() {
        System.out.println("removeChild");
        Node child = null;
        Node instance = new Node();
        boolean expResult = false;
        boolean result = instance.removeChild(child);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfChildren method, of class Node.
     */
    @Ignore
    @Test
    public void testGetNumberOfChildren() {
        System.out.println("getNumberOfChildren");
        Node instance = new Node();
        int expResult = 0;
        int result = instance.getNumberOfChildren();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTextByPath method, of class Node.
     */
    @Test
    public void testGetTextByPath() {
        System.out.println("getTextByPath");
        String path = "de.podolak.demo.calculator.engine.complextype.Complex";
        Node instance = SerializationDemo.getDummyNode();
        String expResult = "package de.podolak.demo.calculator.engine.complextype;\npublic class Complex extends Number {\n\t\n\t@Override\n\tpublic int intValue() {\n\t\tthrow new UnsupportedOperationException(\"Not supported yet.\");\n\t}\n\t\n\t@Override\n\tpublic long longValue() {\n\t\tthrow new UnsupportedOperationException(\"Not supported yet.\");\n\t}\n\t\n\t@Override\n\tpublic float floatValue() {\n\t\tthrow new UnsupportedOperationException(\"Not supported yet.\");\n\t}\n\t\n\t@Override\n\tpublic double doubleValue() {\n\t\tthrow new UnsupportedOperationException(\"Not supported yet.\");\n\t}\n\n}";
        String result = instance.getTextByPath(path);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Node.
     */
    @Ignore
    @Test
    public void testToString() {
        System.out.println("toString");
        Node instance = new Node();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
