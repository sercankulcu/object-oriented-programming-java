
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;

public class Editor extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea textArea;
	JFrame frame;
	@SuppressWarnings("deprecation")
	// Constructor
	public Editor()
	{
		// Create a frame
		frame = new JFrame("editor");
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		textArea = new JTextArea();
		JMenuBar menubar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		// Create menu items
		JMenuItem menuNew = new JMenuItem("New");
		JMenuItem menuOpen = new JMenuItem("Open");
		JMenuItem menuSave = new JMenuItem("Save");
		JMenuItem menuPrint = new JMenuItem("Print");
		// Add action listener
		menuNew.addActionListener(this);
		menuOpen.addActionListener(this);
		menuSave.addActionListener(this);
		menuPrint.addActionListener(this);
		
		menuFile.add(menuNew);
		menuFile.add(menuOpen);
		menuFile.add(menuSave);
		menuFile.add(menuPrint);
		// Create amenu for menu
		JMenu menuEdit = new JMenu("Edit");
		// Create menu items
		JMenuItem menuCut = new JMenuItem("Cut");
		JMenuItem menuCopy = new JMenuItem("Copy");
		JMenuItem menuPaste = new JMenuItem("Paste");
		// Add action listener
		menuCut.addActionListener(this);
		menuCopy.addActionListener(this);
		menuPaste.addActionListener(this);
		
		menuEdit.add(menuCopy);
		menuEdit.add(menuCut);
		menuEdit.add(menuPaste);
		
		JMenuItem menuClose = new JMenuItem("Close");
		menuClose.addActionListener(this);
		
		menubar.add(menuFile);
		menubar.add(menuEdit);
		menubar.add(menuClose);
		
		frame.setJMenuBar(menubar);
		frame.add(textArea);
		frame.setSize(500, 500);
		frame.show();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		System.out.println(s);
		
		if (s.equals("Cut")) {
			textArea.cut();
		} else if (s.equals("Copy")) {
			textArea.copy();
		} else if (s.equals("Paste")) {
			textArea.paste();
		} else if (s.equals("Save")) {
			
			JFileChooser filechooser = new JFileChooser("c:");
			int result = filechooser.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = new File(filechooser.getSelectedFile().getAbsolutePath());
				try {
					FileWriter filewriter = new FileWriter(file, false);
					BufferedWriter writer = new BufferedWriter(filewriter);
					writer.write(textArea.getText());
					writer.flush();
					writer.close();
				}
				catch (Exception evt) {
					JOptionPane.showMessageDialog(frame, evt.getMessage());
				}
			} else { // If the user cancelled the operation
				JOptionPane.showMessageDialog(frame, "User cancelled the save operation");
			}
		} else if (s.equals("Print")) {
			try {
				textArea.print();
			}
			catch (Exception evt) {
				JOptionPane.showMessageDialog(frame, evt.getMessage());
			}
		} else if (s.equals("Open")) {
			
			JFileChooser filechooser = new JFileChooser("c:");
			int result = filechooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = new File(filechooser.getSelectedFile().getAbsolutePath());
				try {
					String line = "", all = "";
					FileReader filereader = new FileReader(file);
					BufferedReader reader = new BufferedReader(filereader);
					all = reader.readLine();
					while ((line = reader.readLine()) != null) {
						all = all + "\n" + line;
					}
					reader.close();
					textArea.setText(all);
				} catch (Exception evt) {
					JOptionPane.showMessageDialog(frame, evt.getMessage());
				}
			} else { // If the user cancelled the operation
				JOptionPane.showMessageDialog(frame, "User cancelled the open operation");
			}
		} else if (s.equals("New")) {
			textArea.setText("");
		} else if (s.equals("Close")) {
			frame.setVisible(false);
		}
	}
	// Main class
	public static void main(String args[])
	{
		Editor e = new Editor();
	}
}
