package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TriangleTest {

    private Triangle triangle;

    @DataProvider(name = "dataProviderForSidesLessOrEqZeroCheck")
    public Object[][] dataCheckSides(){
        return new Object[][]{
                {-3, 4, 5},
                {0, 4, 5},
                {3, -4, 5},
                {3, 0, 5},
                {3, 4, -5},
                {3, 4, 0}
        };
    }

    @DataProvider(name = "dataProviderForTriangleInequalityCheck")
    public Object[][] dataCheckTriangleInequality(){
        return new Object[][]{
                {3, 4, 10},
                {3, 4, 7},
                {1, 22, 5},
                {1, 6, 5},
                {9, 4, 5},
                {16, 3, 5},
                {0.001, 0.004, 0.003},
                {0.001, 0.02, 0.003},
                {0.001, 0.002, 0.003},
                {0.001, 0.002, 0.03},
                {0.005, 0.002, 0.003},
                {0.01, 0.002, 0.03},
        };
    }

    @DataProvider(name = "dataProviderForRightTriangleCheck")
    public Object[][] dataCheckTriangleRightSides(){
        return new Object[][]{
                {3, 4, 6},
                {10, 7, 7},
                {5, 5, 5},
                {3, 4, 5},
                {1.0, 1.0, Math.sqrt(2.0)},
        };
    }

    @Test(dataProvider = "dataProviderForSidesLessOrEqZeroCheck")
    public void testCheckTriangle_withSidesLessOrEqZero(double a, double b, double c){
        triangle = new Triangle(a, b, c);
        assertFalse(triangle.checkTriangle(), triangle.getMessage());
    }

    @Test(dataProvider = "dataProviderForTriangleInequalityCheck")
    public void testCheckTriangle_withSidesWrongForTriangleInequality(double a, double b, double c){
        triangle = new Triangle(a, b, c);
        assertFalse(triangle.checkTriangle(), triangle.getMessage());
    }

    @Test(dataProvider = "dataProviderForRightTriangleCheck")
    public void testCheckTriangle_withRightSides(double a, double b, double c){
        triangle = new Triangle(a, b, c);
        assertTrue(triangle.checkTriangle(), triangle.getMessage());
    }
    //------------------------------------------------------------------------------------------------------------------

    @DataProvider(name = "dataProviderForEquilateralTriangle")
    public Object[][] dataCheckEquilateralTriangle(){
        return new Object[][]{
                {3, 3, 3},
                {Math.sqrt(2), Math.sqrt(2), Math.sqrt(2)},
                {Math.pow(10, -20), Math.pow(10, -20), Math.pow(10, -20)},
                {Math.pow(10, 20), Math.pow(10, 20), Math.pow(10, 20)}
        };
    }

    @DataProvider(name = "dataProviderForIsoscelesTriangle")
    public Object[][] dataCheckIsoscelesTriangle(){
        return new Object[][]{
                {1, 3, 3},
                {3, 1, 3},
                {3, 3, 1},
                {Math.sqrt(2.0), Math.sqrt(2.0), Math.sqrt(3.0)},
                {Math.pow(1, -20), Math.pow(1, -20), Math.pow(2, -20)},
                {Math.pow(10, 20), Math.pow(11, 20), Math.pow(10, 20)}
        };
    }

    @DataProvider(name = "dataProviderForRectangularTriangle")
    public Object[][] dataCheckRectangularTriangle(){
        return new Object[][]{
                {3, 4, 5},
                {4, 5, 3},
                {5, 4, 3},
                {0.3, 0.4, 0.5},
                {5 * Math.pow(10, 20), 4 * Math.pow(10, 20), 3 * Math.pow(10, 20)},
                {4 * Math.pow(10, -20), 5 * Math.pow(10, -20), 3 * Math.pow(10, -20)}
        };
    }

    @DataProvider(name = "dataProviderForIsoscelesRectangularTriangle")
    public Object[][] dataCheckIsoscelesRectangularTriangle(){
        return new Object[][]{
                {Math.sqrt(2.0), 1.0, 1.0},
                {1.0, Math.sqrt(2.0), 1.0},
                {1.0, 1.0, Math.sqrt(2.0)},
        };
    }

    @DataProvider(name = "dataProviderForOrdinaryTriangle")
    public Object[][] dataCheckOrdinaryTriangle(){
        return new Object[][]{
                {15, 12, 5},
                {12, 5, 15},
                {5, 15, 12},
                {Math.pow(10, 20), Math.pow(11, 20), Math.pow(12, 20)},
                {Math.sqrt(13.0), Math.sqrt(10.0), Math.sqrt(17.0)},
        };
    }

    @Test(dataProvider = "dataProviderForEquilateralTriangle")
    public void testDetectTriangle_whereTriangleEquilateral(double a, double b, double c) throws Exception {
        triangle = new Triangle(a, b, c);
        assertEquals(triangle.detectTriangle(), triangle.TR_EQUILATERAL);
    }

    @Test(dataProvider = "dataProviderForIsoscelesTriangle")
    public void testDetectTriangle_whereTriangleIsosceles(double a, double b, double c) throws Exception {
        triangle = new Triangle(a, b, c);
        assertEquals(triangle.detectTriangle(), triangle.TR_ISOSCELES);
    }

    @Test(dataProvider = "dataProviderForRectangularTriangle")
    public void testDetectTriangle_whereTriangleRectangular(double a, double b, double c) throws Exception {
        triangle = new Triangle(a, b, c);
        assertEquals(triangle.detectTriangle(), triangle.TR_RECTANGULAR);
    }

    @Test(dataProvider = "dataProviderForIsoscelesRectangularTriangle")
    public void testDetectTriangle_whereTriangleIsoscelesRectangular(double a, double b, double c) throws Exception {
        triangle = new Triangle(a, b, c);
        assertEquals(triangle.detectTriangle(), triangle.TR_ISOSCELES|triangle.TR_RECTANGULAR);
    }

    @Test(dataProvider = "dataProviderForOrdinaryTriangle")
    public void testDetectTriangle_whereTriangleOrdinary(double a, double b, double c) throws Exception {
        triangle = new Triangle(a, b, c);
        assertEquals(triangle.detectTriangle(), triangle.TR_ORDYNARY);
    }

    //------------------------------------------------------------------------------------------------------------------

    @DataProvider(name = "dataProviderForTriangleSquare")
    public Object[][] dataCheckTriangleSquare(){
        return new Object[][]{
                {3, 4, 5, 6},
                {0.3, 0.4, 0.5, 0.06},
                {2, 2, 2, Math.sqrt(3.0)},
                {2 * Math.pow(10, -50), 2 * Math.pow(10, -50), 2 * Math.pow(10, -50), Math.sqrt(3.0) * Math.pow(10, -100)},
                {2 * Math.pow(10, 50), 2 * Math.pow(10, 50), 2 * Math.pow(10, 50), Math.sqrt(3.0) * Math.pow(10, 100)},
                {2 * Math.pow(10, 100), 2 * Math.pow(10, 100), 2 * Math.pow(10, 100), Math.sqrt(3.0) * Math.pow(10, 200)}
        };
    }

    @Test(dataProvider = "dataProviderForTriangleSquare")
    public void testGetSquare(double a, double b, double c, double res) throws Exception {
        triangle = new Triangle(a, b, c);
        assertEquals(triangle.getSquare(), res);
    }
}