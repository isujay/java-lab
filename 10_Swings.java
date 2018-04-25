import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class EmployeeDataEntry {
	private static Color black;
	public static void main(String[] args) 
	{
		int i,j;
		
		JFrame frameobj = new JFrame();  				//creating frame
		frameobj.setSize(500, 500);  					//declaring frame size
		frameobj.setLayout( new GridLayout(5,2) );		//layout is set to the frame created
		
		JPanel p[] = new JPanel[10];		
		for( i =0; i < 10; i++)
			p[i] = new JPanel();
		
		String words[]  = new String[]{ "NAME", "ID", "DOJ", "DOB" };
		JLabel l[] = new JLabel[4];
		for( i = 0; i < 4; i++)
			l[i] = new JLabel( words[i] );
	
		JTextField[] f = new JTextField[4];	
		for( i = 0; i < 4; i++)
		{	
			f[i] = new JTextField();
			f[i].setPreferredSize(new Dimension(200,30));
		}	

		JButton b1 = new JButton("SUBMIT");
		JButton b2 = new JButton("RESET");
		
		b1.addActionListener(new ActionListener()
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				File fileobj=new File("./EmployeeData.txt");
				try 
				{
					FileWriter fw=new FileWriter(fileobj.getAbsoluteFile(),true);
					
					String details = "";
					for(int i = 0; i <4; i++)
						details += l[i].getText() + " " +  f[i].getText() + "\n";
				
					System.out.println(details);
					fw.write(details);
					fw.close();
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}	
			}
		});
		
		b2.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				for( int i = 0; i < 4; i++)
					f[i].setText(null);
			}
		});
		
		i = 0; j = 0;
		while( i < 8 )
		{
			p[i++].add( l[j] );
			p[i++].add( f[j] );
			j++;
		}
			
		p[8].add(b1);		p[9].add(b2);

		for( i = 0; i < 4; i++)
			l[i].setBorder( BorderFactory.createLineBorder(black,10));
		
		for( i = 0; i <10; i++)
			frameobj.add( p[i] );
	
		frameobj.setVisible(true);
	}
}
