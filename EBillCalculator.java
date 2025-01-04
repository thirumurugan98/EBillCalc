import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EBillCalculator extends JFrame{
	 static JLabel out_lbl;
			//Components
	static	JLabel l1,l2;
	static	TextField t1,t2,t3;
	static	JButton b1;
	
	EBillCalculator(){
		
		setTitle("EB-Bill Calculator");
		setSize(500,500);

		
		l1=new JLabel("Current Reading Value");
		t1=new TextField();
		t1.setSize(100,30);
		l2=new JLabel("Previous Reading Value");
		t2=new TextField();
		t2.setSize(100,30);
		b1=new JButton("Submit");
		
		out_lbl=new JLabel();
		
		
		l1.setBounds(50,50,130,30);
		t1.setBounds(50,80,150,30);
		l2.setBounds(50,150,130,30);
		t2.setBounds(50,180,150,30);
		
		b1.setBounds(100,250,100,30);
		b1.setActionCommand("calculate");
		b1.addActionListener(new ButtonClickListener());
		
		
		out_lbl.setBounds(50,300,200,60);
		
		
		
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(b1);
		add(out_lbl);
		
		//FlowLayout mf=new FlowLayout();
		
		
		setLayout(null);
		setVisible(true);
	}
	
	
	
	
	
	
	
	public static void main(String args []){
		new EBillCalculator();
	}
	
	private class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();  
		 String outmsg="";
         
         if(command.equals("calculate")){
			 String currReadingText="";
			 currReadingText=EBillCalculator.t1.getText();
			 String prevReadingText="";
			 prevReadingText=EBillCalculator.t2.getText();
			 try{
			 if(currReadingText!=""&&prevReadingText!=""){
				int currReading=Integer.parseInt(currReadingText);
				int prevReading=Integer.parseInt(prevReadingText);
				//System.out.println(prevReading);
				//System.out.println(currReading);
				
				int total_runned_units=0;
				float unit_price=8.50f;
				total_runned_units=currReading-prevReading;
				
				if(total_runned_units!=0&&total_runned_units>0){
					//System.out.println(total_runned_units);
					float bill_amount=0.0f;
					bill_amount=total_runned_units*unit_price;
					if(bill_amount!=0.0f){
	
					outmsg="Your Bill Amount is "+String.format("Rs%,.2f /-", bill_amount); 	
					EBillCalculator.out_lbl.setText(outmsg);
					}
					
				}
				else{
					outmsg="Error ,Please check reading values";
					EBillCalculator.out_lbl.setText(outmsg);
				}
			 }
			 else{
				 outmsg="Reading values are mandatory";
					EBillCalculator.out_lbl.setText(outmsg);
			 }
			 }
			 catch(Exception e1){
					outmsg="Reading values are mandatory";
					EBillCalculator.out_lbl.setText(outmsg);	
			 }
		 }
 	
      }		
   }
}
	
