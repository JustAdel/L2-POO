package gui;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import infos.ToScan;
import infos.ToScanList;

public class EnquiriesPanel extends JPanel {
	private static final Font LABEL_FONT = new Font(Font.MONOSPACED, Font.BOLD, 12);
	protected JLabel instructionLabel = new JLabel("Ajoutez des objets.");
	//protected JButton clearButton = new JButton("clear");
	//private ToScanList list;
	public EnquiriesPanel(ToScanList list) {
		
		 BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		 this.setLayout(layout);
		 initActions();
		 instructionLabel.setFont(LABEL_FONT);
	}
	
	 private void initActions() {
		 //clearButton.addActionListener(new ClearAction());
		
	}

	public void layoutEnquiries(ToScanList list) {
	    if(list.isEmpty()) {
	    	add(instructionLabel);
	    }else {
	    	for (ToScan file : list.getScanList()) {
		        EnquiryPanel eqPanel = new EnquiryPanel(file, list);
		        add(eqPanel);
		     }
	    }
	     revalidate();
	 }
	/*
	private class ClearAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			
		}
	}*/
}
