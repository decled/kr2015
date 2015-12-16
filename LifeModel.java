import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
impot java.util.Observer;
import java.util.Timer;
import java.util.TierTask;
import javax.swing.JPanel;

public class Lifemodel  extends Jpanel implements Observer{
static final int Statealive=1; statedeath=0;
Color Alive,Death;
JPanel [] [] Cells;
int gridwidth; 
int gridhighth;

Timer time =  new Timer;
