    import java.awt.geom.*;     // for Point2D.Double
    import java.util.ArrayList; // for ArrayList
    import gpdraw.*;            // for DrawingTool
/**
 * Write a description of class Hexagon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IrregularPolygon
{       // for DrawingTool
        private ArrayList <Point2D.Double> myPolygon = new ArrayList<>();
        private SketchPad myPaper;
        private DrawingTool myPencil;
        // constructors
        public IrregularPolygon() {
            myPaper = new SketchPad(500, 500);
            myPencil = new DrawingTool(myPaper);
            ArrayList <Point2D.Double> myPolygon;
        }

        // public methods
        public void add(Point2D.Double aPoint) {
            myPolygon.add(aPoint);
        }

        public void draw() { 
            myPencil.up();
            myPencil.move(myPolygon.get(0).getX() , myPolygon.get(0).getY());
            myPencil.down();
            for(int z = 0; z < myPolygon.size() - 1; z++){
                myPencil.move(myPolygon.get(z + 1).getX() , myPolygon.get(z + 1).getY());
            }
            myPencil.move(myPolygon.get(0).getX() , myPolygon.get(0).getY());
        }
        public String getName(){
            return "Nate Huey";
        }
        public double perimeter() { 
            int perm = 0;
            if(myPolygon.size() <= 2){
                return -1;
            }
            for(int z = 0; z < myPolygon.size() - 1; z++){
                perm += myPolygon.get(z).distance(myPolygon.get(z + 1));
            }
            return perm + myPolygon.get(myPolygon.size() - 1).distance(myPolygon.get(0));
        }

        public double area() {
            int a = 0;
            if(myPolygon.size() <= 2){
                return -1;
            }
            for(int z = 0; z < myPolygon.size() - 1; z++){
                a += Math.abs(.5 * (myPolygon.get(z).getX() * myPolygon.get(z + 1).getY() + myPolygon.get(z).getY() * myPolygon.get(z + 1).getX()));
            }
            return a + Math.abs(.5 * (myPolygon.get(myPolygon.size() - 1).getX() * myPolygon.get(0).getY() + myPolygon.get(myPolygon.size() - 1).getY() * myPolygon.get(0).getX()));
        }
    }

