import comp102.*;

/** Program for testing the PaintCalculator program */

// You do not need to use this 

public class TestPaintCalculator implements UIButtonListener{

    private PaintCalculator pc = new PaintCalculator();
 
    public TestPaintCalculator(){
	UI.addButton("Core", this); 
	UI.addButton("Completion", this);
    }
	
    public void buttonPerformed(String b){
	UI.clearGraphics();
	if (b.equals("Core")) pc.calculatePaintCore();
	else if (b.equals("Completion")) pc.calculatePaintCompletion();
    }

    public static void main(String[] args){
        new TestPaintCalculator();
    }

}
