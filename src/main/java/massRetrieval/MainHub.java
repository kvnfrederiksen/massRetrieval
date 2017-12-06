package massRetrieval;
import java.awt.EventQueue;

public class MainHub 
{//start class
	
	public static void main(String... args)
	{//start main
		
		EventQueue.invokeLater(new Runnable()
		{
	
			@Override
			public void run()
			{
				
				UserInterface ui = new UserInterface();
				ui.setVisible(true);
			}
			
		});
		
    }//end main
}//end class