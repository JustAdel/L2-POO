package gui;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import infos.ToScan;
import infos.ToScanList;

/**
 * @author Adel Représente l'ensemble des éléments sélectionnés pour l'analyse.
 */
public class EntriesPanel extends JPanel {

	private static final Font LABEL_FONT = new Font(Font.MONOSPACED, Font.BOLD, 12);

	protected JLabel instructionLabel = new JLabel("Add objects for scan by clicking on the 'add' button.");
	protected JLabel selectedLabel = new JLabel("Selected for scanning:");

	protected JButton runButton;

	// protected JButton clearButton = new JButton("clear");
	// private ToScanList list;

	public EntriesPanel(ToScanList list, JButton runButton) {
		this.runButton = runButton;
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);
		initActions();
		instructionLabel.setFont(LABEL_FONT);
		layoutEntries(list);

	}

	private void initActions() {
		// clearButton.addActionListener(new ClearAction());

	}

	/**
	 * @param list Affiche un message par défaut si aucun élément n'est sélectionné
	 *             (i.e. si list.isEmpty()).
	 * 
	 *             Génère dynamiquement les composants graphiques (EntryPanel)
	 *             correspondant respectivement aux fichiers sélectionnés.
	 */
	public void layoutEntries(ToScanList list) {
		removeAll();
		JPanel tmp = new JPanel();
		if (list.isEmpty()) {
			runButton.setEnabled(false);
			FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
			tmp.setLayout(flow);
			tmp.add(instructionLabel);
			add(tmp);
		} else {
			FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
			// Message introductif
			tmp.setLayout(flow);
			tmp.add(selectedLabel);
			add(tmp);
			// Parcours de list
			for (ToScan file : list.getScanList()) {
				EntryPanel eqPanel = new EntryPanel(file, list, this);
				add(eqPanel);
			}
			runButton.setEnabled(true);
		}
		revalidate();
		repaint();
	}

	/*
	 * private class ClearAction implements ActionListener { //ajout futur d'un
	 * bouton pour désélectionner tous les éléments.
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * 
	 * 
	 * } }
	 */
}
