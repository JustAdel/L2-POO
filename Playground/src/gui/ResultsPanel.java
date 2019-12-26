package gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

import infos.ResultSave;

/**
 * @author Adel Génère le composant graphique responsable de l'affichage des
 *         résultats d'une analyse.
 */
public class ResultsPanel extends JPanel {
	private static final Font LABEL_FONT = new Font(Font.MONOSPACED, Font.BOLD, 12);

	private JLabel summaryLabel;

	private JButton detailedReportButton = new JButton("detailed report");
	private JButton saveResultsButton = new JButton("save results");

	private ResultSave list;

	/**
	 * @param list
	 */
	public ResultsPanel(ResultSave list) {

		this.list = list;

		initLayout();

		initStyle();

		initActions();
	}

	private void initStyle() {
		summaryLabel.setFont(LABEL_FONT);
		//detailedReportButton.setFont(BUTTON_FONT);
	}

	private void initLayout() {
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
		this.setLayout(flow);
		summaryLabel = new JLabel();
		summaryLabel.setFont(LABEL_FONT);
		this.add(summaryLabel);
		update(list);
	}

	private void initActions() {
		detailedReportButton.addActionListener(new ReportAction());
		saveResultsButton.addActionListener(new SaveAction());
	}

	/**
	 * @param list Affiche un résumé du résultat lorsqu'il est dispobible (i.e.
	 *             lorsque la liste est non vide), avec la possibilité de consulter
	 *             le détail.
	 */
	public void update(ResultSave list) {
		if (!list.isEmpty()) {
			this.list = list;
			summaryLabel.setText(list.summarize());
			add(detailedReportButton);
			add(saveResultsButton);
		}
	}

	private class ReportAction implements ActionListener {
		/**
		 * Ouvre une nouvelle fenêtre contenant un rapport détaillé des résultats de
		 * l'analyse.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			new ReportFrame(list);
		}
	}
	
	private class SaveAction implements ActionListener {
		/**
		 * Ouvre une nouvelle fenêtre contenant un rapport détaillé des résultats de
		 * l'analyse.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setDialogTitle("Choose where results should be saved");
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int returnValue = jfc.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				list.save(jfc.getSelectedFile().getPath());
			}
		}
	}
}