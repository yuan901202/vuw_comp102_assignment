/* Code for COMP102 2011T2 Assignment 6
 * Name: pondy
 */

import comp102.*;
import java.awt.Color;

/** Exercise for defining objects.
    This program contains methods for testing Surprise, PartyBalloon,
    CameraAperture, and FlatAccount objects.
    It is all written for you, but you need to read it to see what the
    Surprise, PartyBalloon, CameraAperture, and FlatAccount classes should do
 */

public class ExerciseObjects implements UIButtonListener{


    /** Constructor to set up the user interface */
    public ExerciseObjects(){
	UI.addButton("Surprises", this);
	UI.addButton("PartyBalloons", this);
	UI.addButton("FlatAccounts", this);
	UI.addButton("Camera", this);
	UI.addButton("Tightropes", this);
	UI.addButton("Clear", this);
    }	


    /**  buttonPerformed method to respond to the buttons */
    public void buttonPerformed(String b){
	UI.clearText(); 
	if (b.equals("Surprises")){this.testSurprises();}
	else if (b.equals("PartyBalloons")){this.testPartyBalloons();}
	else if (b.equals("Camera")){this.testCameraAperture();}
	else if (b.equals("FlatAccounts")){this.testFlatAccounts();}
	else if (b.equals("Tightropes")){this.testTightropes();}
	else if (b.equals("Clear")){UI.clearText();UI.clearGraphics();}
    }



    /** Makes several Surprise objects, and calls methods on them */
    public void testSurprises(){
	Surprise s1 = new Surprise("Pumpkin");
	Surprise s2 = new Surprise("Squash");
	s1.sayBoo();
	s2.sayBoo();
	s1.sayBoo();
	Surprise s3 = new Surprise("Elephant");
	s3.sayBoo();
	s2.sayBoo();
	s1.sayBoo();
	//change the value in s1 to a new object  
	s1 = new Surprise("Ant");
	s1.sayBoo();
	s2.sayBoo();
	s3.sayBoo();
    }	

    /** Makes five pairs of PartyBalloon objects and makes them fly into the sky */
    public void testPartyBalloons(){
	UI.setColor(Color.black);
	UI.drawLine(0,400, 500, 400);
	int count = 0;
	while (count < 5){
	    PartyBalloon myBalloon = new PartyBalloon(Math.random()*500, 370, Color.getHSBColor((float)Math.random(),1,1));
	    PartyBalloon yourBalloon = new PartyBalloon(Math.random()*500, 370, Color.getHSBColor((float)Math.random(),1,1));
	    int steps = 0;
	    while (steps < 18){
		UI.sleep(200);
		myBalloon.riseLeft();
		yourBalloon.riseRight();
		steps = steps + 1;
	    }
	    count = count + 1;
	}
    }


    /** Makes two FlatAccount objects, and lets user record expenses and contributions */
    public void testFlatAccounts(){
	FlatAccount us = new FlatAccount("161 Kelburn Pde");
	FlatAccount them = new FlatAccount("172 Kelburn Pde");
	us.printBalances();
	them.printBalances();
	
	int tests = 0;
	while (tests<=6 & UI.askBoolean("Do more? (y/n): ") ){
	    // choose a flat:
            FlatAccount flat;
	    if (Math.random()<0.5) { flat = us; }
	    else { flat = them;}

	    //  expense or contribute
	    if (Math.random() < 0.5){
		String category = UI.askString("Type of expense for " + flat.getName() + " ('rent' or 'food')");
		double amt = UI.askDouble("Amount:");
		flat.expense(category, amt);
	    }
	    else {
		double amt = UI.askDouble("Amount to contribute to " + flat.getName() + ":");
		flat.contribute(amt);
	    }
	    UI.println("-------------------------");
	    flat.printBalances();
	    tests++;
	}	    
    }   

    /** Makes two Tightrope objects and raises the tightropes */
    public void testCameraAperture(){
	CameraAperture cam1 = new CameraAperture(150, 300); 
	CameraAperture cam2 = new CameraAperture(400, 200);
	UI.setColor(Color.black);
	int steps = 0;
	while (steps < 50){
	    // at random, choose camera and make it open or close
	    if (Math.random() <0.5){
		if (Math.random() <0.5){
		    cam1.open();
		}
		else {
		    cam1.close();
		}
	    }
	    else {
		if (Math.random() <0.5){
		    cam2.open();
		}
		else {
		    cam2.close();
		}
	    }
	    //pause
	    UI.sleep(200);
	    steps++;   //(shorthand for steps = steps + 1;
	}
    }



    /** Makes two Tightrope objects and raises the tightropes */
    public void testTightropes(){
	UI.setColor(new Color(0,100,0)); 
	UI.fillRect(0,400,600,10);  // the ground
	Tightrope training = new Tightrope(110, 100);  // horizontal center and width
	Tightrope perform = new Tightrope(400, 220);   // horizontal center and width
	int steps = 0;
	while (steps < 200){
	    // lift a random end of the training tightrope by a random amount
	    if (Math.random() <0.5){training.raiseLeft(Math.random()*10-3);}
	    else{training.raiseRight(Math.random()*10-3);}

	    // lift a random end of the perform tightrope by a random amount
	    if (Math.random() <0.5){perform.raiseLeft(Math.random()*15-5);}
	    else{perform.raiseRight(Math.random()*15-5);}

	    //pause
	    UI.sleep(60);
	    steps++;   //(shorthand for steps = steps + 1;
	}
    }



    /** Calls the constructor */
    public static void main(String[] args){
        new ExerciseObjects();
    }
}
