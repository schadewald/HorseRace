import javafx.scene.shape.Rectangle;
/**
 * Chad Schadewald
 * Horse.java
 * Project 3
 */
public class Horse
{
    Rectangle[] horse = new Rectangle[4];
    public Horse()
        {
            this.horse[0] = drawBody();
            this.horse[1] = drawFrontLegs();
            this.horse[2] = drawBackLegs();
            this.horse[3] = drawHead();
        }
    private Rectangle drawBody()
    {
        return new Rectangle(5, 40, 45, 20);
    }
    private Rectangle drawFrontLegs()
    {
        return new Rectangle(40, 60, 10, 10);
    }
    private Rectangle drawBackLegs()
    {
        return new Rectangle(5, 60, 10,10);
    }
    private Rectangle drawHead()
    {
        return new Rectangle(45, 30, 20, 10);
    }
    public Rectangle getBody()
    {
        return this.horse[0];
    }
    public Rectangle getHead()
    {
        return this.horse[3];
    }
    public Rectangle getFrontLegs()
    {
        return this.horse[1];
    }
    public Rectangle getBackLegs()
    {
        return this.horse[2];
    }
}
