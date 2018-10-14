package at.htl.robot.model;

public class Roberta {
    private int x;
    private int y;
    private Directa directa = Directa.SOUTH;
    private Modi modi = Modi.RESTRICT2;


    // Getter&Setter

    public void stepForward(){

        if (this.directa == Directa.SOUTH)
        {
            y++;
        }

        if (this.directa == Directa.EAST)
        {
            x++;
        }

        if (this.directa == Directa.NORTH)
        {
            y--;
        }

        if (this.directa == Directa.WEST)
        {
            x--;
        }

    }



    public void rotateLeft(){

        if (this.directa == Directa.SOUTH)
        {
            this.directa = Directa.EAST;
        }

        else if (this.directa == Directa.EAST)
        {
            this.directa = Directa.NORTH;
        }

        else if (this.directa == Directa.NORTH)
        {
            this.directa = Directa.WEST;
        }

        else if (this.directa == Directa.WEST)
        {
            this.directa = Directa.SOUTH;
        }

    }

    public void changeMode()
    {
        if(this.modi == Modi.RESTRICT2)
        {
            this.modi = Modi.TELEPORT2;
        }
        else if (this.modi == Modi.TELEPORT2)
        {
            this.modi = Modi.RESTRICT2;
        }
    }



    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public void setX(int xValue)
    {
        this.x = xValue;
    }

    public void setY(int yValue)
    {
        this.y = yValue;
    }



    public Directa getDirecta()
    {
        return this.directa;
    }

    public Modi getModi()
    {
        return this.modi;
    }

}
