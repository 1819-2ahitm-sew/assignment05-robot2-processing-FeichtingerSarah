package at.htl.robot.gui;
import at.htl.robot.model.*;
import processing.core.PApplet;

public class Main extends PApplet {

    int leftMargin = 20;
    int upperMargin = 50;
    int boxLength = 50;
    Robot robot;
    Roberta roberta;

    String t = "T";
    String r = "R";



    // Hier die Member-Attribute eintragen

    public static void main(String[] args)
    {
        PApplet.main("at.htl.robot.gui.Main", args);
    }

    public void settings()
    {
        size(800, 800);
    }

    public void setup()
    {
        background(200);

        robot = new Robot();
        robot.setX(1);
        robot.setY(1);

        roberta = new Roberta();
        roberta.setX(10);
        roberta.setY(1);
    }



    public void draw()
    {

        for (int i = 0; i < 11; i++) {
            line(leftMargin,
                    upperMargin + i * boxLength,
                    leftMargin + 10 * boxLength,
                    upperMargin + i * boxLength
            );

            line(leftMargin + i * boxLength, upperMargin,
                    leftMargin + i * boxLength,
                    upperMargin + 10 * boxLength
            );

            if(robot.getX() != 0 && robot.getX()!= 11 && robot.getY() != 0 && robot.getY() != 11)
            {
                drawRobot(robot);
            }

            if(roberta.getX() != 0 && roberta.getX()!= 11 && roberta.getY() != 0 && roberta.getY() != 11)
            {
                drawRoberta(roberta);
            }

        }
    }

    /**
     * Erstellen Sie eine eigene Methode, mittels der der Roboter am Bildschirm gezeichnet wird
     * Die Angabe zu Position des Roboters am Spielfeld erhalten Sie aus dem Roboter-Objekt, welches
     * als Parameter übergeben wird.
     *
     * @param robot Objekt des zu zeichnenden Roboters
     */


    public void drawRobot(Robot robot)
    {
        if(robot.getMode() == Mode.RESTRICT)
        {
            drawRobotCharakter(r, robot);
        }

        else if(robot.getMode() == Mode.TELEPORT)
        {
            drawRobotCharakter(t, robot);
        }
    }

    public void drawRoberta(Roberta roberta)
    {
        if(roberta.getModi() == Modi.RESTRICT2)
        {
            drawRobertaCharakter(r, roberta);
        }

        else if(roberta.getModi() == Modi.TELEPORT2)
        {
            drawRobertaCharakter(t, roberta);
        }
    }


    public void drawRobotCharakter(String mode, Robot robot)
    {
        int boxCenterX = leftMargin + robot.getX() * boxLength - boxLength / 2;
        int boxCenterY = upperMargin + robot.getY() * boxLength - boxLength / 2;
        textSize(15);

        if(robot.getDirection() == Direction.SOUTH)
        {
            textAlign(CENTER);
                /*ellipse(boxCenterX ,
                        boxCenterY,
                        (int) (boxLength * 0.8),
                        (int) (boxLength * 0.8));*/

            //pushMatrix();
            fill(255);
            //noStroke();
            ellipse(boxCenterX, boxCenterY, (int) (boxLength * 0.8), (int) (boxLength * 0.8));
            fill(0, 100, 0);
            text(mode, boxCenterX, boxCenterY + 15F);
            //popMatrix();
        }
        else if(robot.getDirection() == Direction.NORTH)
        {
            textAlign(CENTER);
            fill(255);
            ellipse(boxCenterX, boxCenterY, (int) (boxLength * 0.8), (int) (boxLength * 0.8));
            fill(0, 100, 0);
            text(mode, boxCenterX, boxCenterY);
        }
        else if(robot.getDirection() == Direction.EAST)
        {
            fill(255);
            //noStroke();
            ellipse(boxCenterX, boxCenterY, (int) (boxLength * 0.8), (int) (boxLength * 0.8));
            fill(0, 100, 0);
            text(mode, boxCenterX + 10F, boxCenterY);
        }
        else if(robot.getDirection() == Direction.WEST)
        {
            fill(255);
            //noStroke();
            ellipse(boxCenterX, boxCenterY, (int) (boxLength * 0.8), (int) (boxLength * 0.8));
            fill(0, 100, 0);
            text(mode, boxCenterX - 10F, boxCenterY);
        }
    }


    public void drawRobertaCharakter(String modi, Roberta roberta)
    {
        int boxCenterX = leftMargin + roberta.getX() * boxLength - boxLength / 2;
        int boxCenterY = upperMargin + roberta.getY() * boxLength - boxLength / 2;
        textSize(15);

        if(roberta.getDirecta() == Directa.SOUTH)
        {
            textAlign(CENTER);
                /*ellipse(boxCenterX ,
                        boxCenterY,
                        (int) (boxLength * 0.8),
                        (int) (boxLength * 0.8));*/

            //pushMatrix();
            fill(255, 8, 127);
            //noStroke();
            ellipse(boxCenterX, boxCenterY, (int) (boxLength * 0.8), (int) (boxLength * 0.8));
            fill(0);
            text(modi, boxCenterX, boxCenterY + 15F);
            //popMatrix();
        }
        else if(roberta.getDirecta() == Directa.NORTH)
        {
            textAlign(CENTER);
            fill(58, 47, 215);
            ellipse(boxCenterX, boxCenterY, (int) (boxLength * 0.8), (int) (boxLength * 0.8));
            fill(0);
            text(modi, boxCenterX, boxCenterY);
        }
        else if(roberta.getDirecta() == Directa.EAST)
        {
            fill(155, 239, 5);
            //noStroke();
            ellipse(boxCenterX, boxCenterY, (int) (boxLength * 0.8), (int) (boxLength * 0.8));
            fill(0);
            text(modi, boxCenterX + 10F, boxCenterY);
        }
        else if(roberta.getDirecta() == Directa.WEST)
        {
            fill(255, 241, 56);
            //noStroke();
            ellipse(boxCenterX, boxCenterY, (int) (boxLength * 0.8), (int) (boxLength * 0.8));
            fill(0);
            text(modi, boxCenterX - 10F, boxCenterY);
        }
    }


    /**

     * Erstellen Sie eine eigene Methode zum Löschen des Bildschirms

     */

    public void deleteAll()
    {
        background(209);
    }



    /**

     * In dieser Methode reagieren Sie auf die Tasten

     */

    public void keyPressed()
    {
        println("pressed " + key + " " + keyCode);

        if (key == 'w' || key == 'W')
        {
            robot.changeMode();
        }
        else if (key == 'a' || key == 'A')
        {
            if (robot.getX() == 0 || robot.getX() == 11 || robot.getY() == 0 || robot.getY() == 11)
            {
                wall();
            }
            else
            {
                robot.stepForward();
                deleteAll();
            }

        }
        else if (key == 's' || key == 'S')
        {
            robot.rotateLeft();
        }




        if (key == 'p' || key == 'P')
        {
            roberta.changeMode();
        }
        else if (key == 'ä' || key == 'Ä')
        {
            if (roberta.getX() == 0 || roberta.getX() == 11 || roberta.getY() == 0 || roberta.getY() == 11)
            {
                walli();
            }
            else
            {
                roberta.stepForward();
                deleteAll();
            }

        }
        else if (key == 'ö' || key == 'Ö')
        {
            roberta.rotateLeft();
        }

    }

    public void wall()
    {
        if(robot.getMode() == Mode.TELEPORT) {
            if (robot.getX() == 0)
            {
                robot.setX(10);
            }
            else if(robot.getX() == 11)
            {
                robot.setX(1);
            }
            else if(robot.getY() == 0)
            {
                robot.setY(10);
            }
            else if (robot.getY() == 11)
            {
                robot.setY(1);
            }
        }
        else if(robot.getMode() == Mode.RESTRICT)
        {
            if (robot.getX() == 0)
            {
                robot.setX(1);
            }
            else if(robot.getX() == 11)
            {
                robot.setX(10);
            }
            else if(robot.getY() == 0)
            {
                robot.setY(1);
            }
            else if (robot.getY() == 11)
            {
                robot.setY(10);
            }
        }
    }

    public void walli()
    {
        if(roberta.getModi() == Modi.TELEPORT2) {
            if (roberta.getX() == 0)
            {
                roberta.setX(10);
            }
            else if(roberta.getX() == 11)
            {
                roberta.setX(1);
            }
            else if(roberta.getY() == 0)
            {
                roberta.setY(10);
            }
            else if (roberta.getY() == 11)
            {
                roberta.setY(1);
            }
        }
        else if(roberta.getModi() == Modi.RESTRICT2)
        {
            if (roberta.getX() == 0)
            {
                roberta.setX(1);
            }
            else if(roberta.getX() == 11)
            {
                roberta.setX(10);
            }
            else if(roberta.getY() == 0)
            {
                roberta.setY(1);
            }
            else if (roberta.getY() == 11)
            {
                roberta.setY(10);
            }
        }
    }

}