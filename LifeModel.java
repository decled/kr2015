import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TierTask;
import javax.swing.JPanel;

public class Lifemodel  extends Jpanel implements Observer{
static final int Statealive=1; statedeath=0;
Color Alive,Death;
JPanel [] [] Cells;
int grid_width; 
int grid_high;

Timer time =  new Timer;
