import comp102.*;

public class TestCartoonStrip implements UIButtonListener{

    private CartoonStrip prog = new CartoonStrip();

    public TestCartoonStrip(){
	UI.addButton("Clear",this);
	UI.addButton("Animate",this);
	UI.addButton("Dance",this);
    }	

    public void buttonPerformed(String b){
	if (b.equals("Clear")){UI.clearGraphics();}
	else if (b.equals("Animate")){this.prog.animate();}
	else if (b.equals("Dance")){this.prog.dance();}
    }

    public static void main(String[] args){
	new TestCartoonStrip();
    }


}
