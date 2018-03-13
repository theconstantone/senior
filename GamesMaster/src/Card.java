import java.awt.Font;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Card extends JButton{
    private int id;
    private boolean matched = false;
    Font f = new Font("serif", Font.PLAIN, 36);

    public void setId(int id){
        this.id = id;
        
    }

    public int getId(){
        return this.id;
    }


    public void setMatched(boolean matched){
        this.matched = matched;
    }

    public boolean getMatched(){
        return this.matched;
    }
    
    public void changeFont(int x) {
    	
    }
}