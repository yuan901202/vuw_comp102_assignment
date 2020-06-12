import comp102.*;

/** Program for testing the FlagDrawer program */

// You do not need to use this 

public class TestFlagDrawer implements UIButtonListener{

    private FlagDrawer fd = new FlagDrawer();
 
    public TestFlagDrawer(){
	//CORE
	UI.addButton("Norway", this); 
	UI.addButton("Maldives", this);

	//COMPLETION
	UI.addButton("Greenland", this);

	//CHALLENGE
	UI.addButton("Jamaica", this);
    }
	
    public void buttonPerformed(String b){
	UI.clearGraphics();
	if (b.equals("Norway")) fd.norwayFlag();
	else if (b.equals("Maldives")) fd.maldivesFlag();
	else if (b.equals("Greenland")) fd.greenlandFlag();
	else if (b.equals("Jamaica")) fd.jamaicaFlag();
    }

    public static void main(String[] args){
	new TestFlagDrawer();
    }

}
