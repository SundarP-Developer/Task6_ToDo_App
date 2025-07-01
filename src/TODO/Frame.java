package TODO;

import java.awt.BorderLayout;	
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Frame extends JFrame {

	  private JFrame frame;
	    private DefaultListModel<String> taskListModel;
	    private JList<String> taskList;
	    private JTextField taskField;
	    private JButton addButton, deleteButton;

	    public Frame() {
	        frame = new JFrame("To-Do List");
	        frame.setSize(400, 400);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        taskListModel = new DefaultListModel<>();
	        taskList = new JList<>(taskListModel);
	        JScrollPane scrollPane = new JScrollPane(taskList);

	        taskField = new JTextField();
	        addButton = new JButton("Add Task");
	        deleteButton = new JButton("Delete Task");

	        JPanel inputPanel = new JPanel();
	        inputPanel.setLayout(new BorderLayout());
	        inputPanel.add(taskField, BorderLayout.CENTER);
	        inputPanel.add(addButton, BorderLayout.EAST);

	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new FlowLayout());
	        buttonPanel.add(deleteButton);

	        frame.setLayout(new BorderLayout());
	        frame.add(scrollPane, BorderLayout.CENTER);
	        frame.add(inputPanel, BorderLayout.NORTH);
	        frame.add(buttonPanel, BorderLayout.SOUTH);

	        addButton.addActionListener(e -> {
	            String task = taskField.getText().trim();
	            if (!task.isEmpty()) {
	                taskListModel.addElement(task);
	                taskField.setText("");
	            }
	        });

	        deleteButton.addActionListener(e -> {
	            int selectedIndex = taskList.getSelectedIndex();
	            if (selectedIndex != -1) {
	                taskListModel.remove(selectedIndex);
	            }
	        });

	        frame.setVisible(true);
	    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
