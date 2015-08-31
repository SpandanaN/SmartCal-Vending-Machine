package SmartCalPackage;

//Showing count of items
//Increasing count in edit
//Smart cal card - new GUIs
//On the count of items and smartcal cards a observer pattern could be used.
//For creating the new items - Factory method or builder maybe
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.AbstractButton;

import java.io.IOException;
import java.lang.reflect.*;

import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JComboBox;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.Color;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;

public class AdminGUI {

	private JFrame frmAdmin;
	private ButtonGroup group;
	private JTextField UsernameTF;
	private JPasswordField PasswordTF;
	private JTextField MachineRetrieveTF;
	private JPanel panelLogin;
	private JPanel panelMachine;
	private JPanel panelNewMachine;
	private JPanel panelAddNewItem;
	private JPanel panelAdmin;
	private JPanel panelMonitoring;
	private JPanel panelStatistics;
	private JPanel panelBarChart;
	private JPanel itemsPanel;
	private JPanel panelItems;
	private JTextField costTF;
	private JTextField caloriesTF;
	private JTextField item1costTF;
	private JTextField item1caloriesTF;
	private JTextField item1sugarTF;
	private JTextField item2costTF;
	private JTextField item2caloriesTF;
	private JTextField item2sugarTF;
	private JTextField item3costTF;
	private JTextField item3caloriesTF;
	private JTextField item3sugarTF;
	private JTextField item4costTF;
	private JTextField item4caloriesTF;
	private JTextField item4sugarTF;
	private JTextField item5costTF;
	private JTextField item5caloriesTF;
	private JTextField item5sugarTF;
	private JTextField item6costTF;
	private JTextField item6caloriesTF;
	private JTextField item6sugarTF;
	private String itemToEdit;
	private JPanel panelItem;
	private JTextField sugarTF;
	private JComboBox comboBoxTF;
	private JComboBox comboBox_1;
	//private JTextField A1ItemTF;
	private JTextField A2ItemTF;
	private JTextField A3ItemTF;
	private JTextField A1CountTF;
	private JTextField A2CountTF;
	private JTextField A3CountTF;
	private static int machineID = 1;
	private JTextField MachineIdTF;
	private JTextField A1ItemTF;
	private JTextField countTF;
	private JButton btnBack_5;
	private static int attempts = 0;
	private JLabel lblMachine;
	private JLabel label;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JButton btnBack_6;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI window = new AdminGUI();
					window.frmAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public AdminGUI() throws ClassNotFoundException, IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, IOException {
		frmAdmin = new JFrame();
		frmAdmin.setTitle("Admin");
		frmAdmin.setBounds(100, 100, 545, 337);
		frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdmin.getContentPane().setLayout(new CardLayout(0, 0));
		
		//Login window
		panelLogin = new JPanel();
		panelLogin.setBackground(new Color(255, 255, 255));
		frmAdmin.getContentPane().add(panelLogin, "name_126211528581146");
		panelLogin.setLayout(null);
		panelLogin.setVisible(true);
		
		panelMonitoring = new JPanel();
		panelMonitoring.setBackground(new Color(255, 255, 255));
		frmAdmin.getContentPane().add(panelMonitoring, "name_1439835088248639000");
		panelMonitoring.setLayout(null);
		panelMonitoring.setVisible(false);
		
		JButton btnCancel = new JButton("");
		Image img = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
		btnCancel.setIcon(new ImageIcon(img));
		btnCancel.setBorderPainted(false); 
		btnCancel.setContentAreaFilled(false); 
		btnCancel.setFocusPainted(false); 
		btnCancel.setOpaque(false);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(6, 6, 30, 31);
		panelMonitoring.add(btnCancel);
		
		JButton btnMachineInfo = new JButton("Machines Info");
		btnMachineInfo.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnMachineInfo.setBackground(new Color(193, 224, 219));
		btnMachineInfo.setBorderPainted(false);
		btnMachineInfo.setOpaque(true);
		btnMachineInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMachine.setVisible(true);
				panelMonitoring.setVisible(false);
			}
		});
		btnMachineInfo.setBounds(52, 140, 157, 29);
		panelMonitoring.add(btnMachineInfo);
		
		JButton btnItemsInfo = new JButton("Items Info");
		btnItemsInfo.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnItemsInfo.setBackground(new Color(193, 224, 219));
		btnItemsInfo.setBorderPainted(false);
		btnItemsInfo.setOpaque(true);
		btnItemsInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMonitoring.setVisible(false);
				List<ItemsForSale> items = null;
				try {
					items = Database.getItemsFromList();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				for(ItemsForSale item : items){

					if(item.getItemName().equals("Soda")){

						item1costTF.setText(Double.toString(item.getCost()));

						item1caloriesTF.setText(String.valueOf(item.getCalories()));

						item1sugarTF.setText(String.valueOf(item.getSugarLevels()));

					}

					else if(item.getItemName().equals("Chips")){

						item2costTF.setText(Double.toString(item.getCost()));

						item2caloriesTF.setText(String.valueOf(item.getCalories()));

						item2sugarTF.setText(String.valueOf(item.getSugarLevels()));

					}

					else if(item.getItemName().equals("Chocolates")){

						item3costTF.setText(Double.toString(item.getCost()));

						item3caloriesTF.setText(String.valueOf(item.getCalories()));

						item3sugarTF.setText(String.valueOf(item.getSugarLevels()));

					}

					else if(item.getItemName().equals("Biscuits")){

						item4costTF.setText(Double.toString(item.getCost()));

						item4caloriesTF.setText(String.valueOf(item.getCalories()));

						item4sugarTF.setText(String.valueOf(item.getSugarLevels()));

					}

					else if(item.getItemName().equals("Sandwich")){

						item5costTF.setText(Double.toString(item.getCost()));

						item5caloriesTF.setText(String.valueOf(item.getCalories()));

						item5sugarTF.setText(String.valueOf(item.getSugarLevels()));

					}

					else if(item.getItemName().equals("Water")){

						item6costTF.setText(Double.toString(item.getCost()));

						item6caloriesTF.setText(String.valueOf(item.getCalories()));

						item6sugarTF.setText(String.valueOf(item.getSugarLevels()));

					}


				}
				panelItems.setVisible(true);
			}
		});
		btnItemsInfo.setBounds(221, 140, 134, 29);
		panelMonitoring.add(btnItemsInfo);
		
		JButton btnLogs = new JButton("Statistics");
		btnLogs.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnLogs.setBackground(new Color(193, 224, 219));
		btnLogs.setBorderPainted(false);
		btnLogs.setOpaque(true);
		btnLogs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMonitoring.setVisible(false);
				panelStatistics.setVisible(true);
			}
		});
		btnLogs.setBounds(367, 140, 138, 29);
		panelMonitoring.add(btnLogs);
		
		//Machine information window
		panelMachine = new JPanel();
		panelMachine.setBackground(new Color(255, 255, 255));
		frmAdmin.getContentPane().add(panelMachine, "name_126214754270446");
		panelMachine.setLayout(null);
		panelMachine.setVisible(false);
		
		panelNewMachine = new JPanel();
		panelNewMachine.setBackground(new Color(255, 255, 255));
		frmAdmin.getContentPane().add(panelNewMachine, "name_466659759445660");
		panelNewMachine.setLayout(null);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblItemName.setBounds(164, 62, 86, 16);
		panelNewMachine.add(lblItemName);
		
		JLabel lblA = new JLabel("A1");
		lblA.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblA.setBounds(82, 96, 61, 16);
		panelNewMachine.add(lblA);
		
		JLabel lblA_1 = new JLabel("A2");
		lblA_1.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblA_1.setBounds(82, 130, 61, 16);
		panelNewMachine.add(lblA_1);
		
		JLabel lblA_2 = new JLabel("A3");
		lblA_2.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblA_2.setBounds(82, 162, 61, 16);
		panelNewMachine.add(lblA_2);
		
		
		
		A2ItemTF = new JTextField();
		A2ItemTF.setBounds(147, 124, 134, 28);
		panelNewMachine.add(A2ItemTF);
		A2ItemTF.setColumns(10);
		
		A3ItemTF = new JTextField();
		A3ItemTF.setBounds(147, 156, 134, 28);
		panelNewMachine.add(A3ItemTF);
		A3ItemTF.setColumns(10);
		
		JLabel lblCount_1 = new JLabel("Count");
		lblCount_1.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblCount_1.setBounds(364, 62, 61, 16);
		panelNewMachine.add(lblCount_1);
		
		A1CountTF = new JTextField();
		A1CountTF.setBounds(334, 90, 134, 28);
		panelNewMachine.add(A1CountTF);
		A1CountTF.setColumns(10);
		
		A2CountTF = new JTextField();
		A2CountTF.setBounds(334, 124, 134, 28);
		panelNewMachine.add(A2CountTF);
		A2CountTF.setColumns(10);
		
		A3CountTF = new JTextField();
		A3CountTF.setBounds(334, 156, 134, 28);
		panelNewMachine.add(A3CountTF);
		A3CountTF.setColumns(10);
		
		JButton btnCreateMachine = new JButton("Create Machine");
		btnCreateMachine.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnCreateMachine.setBackground(new Color(193, 224, 219));
		btnCreateMachine.setBorderPainted(false);
		btnCreateMachine.setOpaque(true);
		btnCreateMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineBuilder machine1;
				Machine newMachine = null;
				try {
					machine1 = new SmartVendingMachineBuilder();
					AdminDirector admin=new AdminDirector(machine1);
					admin.makeMachine();
					newMachine=admin.getMachine();
				} catch (Exception e3) {
					e3.printStackTrace();
				} 
				try {
					newMachine.setMachineId(Database.getMachineId());
				} catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				newMachine.setA1Item(A1ItemTF.getText());
				if(A1ItemTF.getText()=="Soda"){
					ItemsForSale soda=new Soda();
					newMachine.addItems(soda);
				}
				else if(A1ItemTF.getText()=="Chips"){
					ItemsForSale chips=new Chips();
					newMachine.addItems(chips);
				}
				else if(A1ItemTF.getText()=="Biscuits"){
					ItemsForSale biscuits=new Biscuits();
					newMachine.addItems(biscuits);
				}
				else if(A1ItemTF.getText()=="Sandwich"){
					ItemsForSale sandwich=new Sandwich();
					newMachine.addItems(sandwich);
				}
				newMachine.setA1Count(Integer.parseInt(A1CountTF.getText()));
				newMachine.setA2Item(A2ItemTF.getText());
				if(A2ItemTF.getText()=="Soda"){
					ItemsForSale soda=new Soda();
					newMachine.addItems(soda);
				}
				else if(A2ItemTF.getText()=="Chips"){
					ItemsForSale chips=new Chips();
					newMachine.addItems(chips);
				}
				else if(A2ItemTF.getText()=="Biscuits"){
					ItemsForSale biscuits=new Biscuits();
					newMachine.addItems(biscuits);
				}
				else if(A2ItemTF.getText()=="Sandwich"){
					ItemsForSale sandwich=new Sandwich();
					newMachine.addItems(sandwich);
				}
				newMachine.setA2Count(Integer.parseInt(A2CountTF.getText()));
				newMachine.setA3Item(A3ItemTF.getText());
				if(A3ItemTF.getText()=="Soda"){
					ItemsForSale soda=new Soda();
					newMachine.addItems(soda);
				}
				else if(A3ItemTF.getText()=="Chips"){
					ItemsForSale chips=new Chips();
					newMachine.addItems(chips);
				}
				else if(A3ItemTF.getText()=="Biscuits"){
					ItemsForSale biscuits=new Biscuits();
					newMachine.addItems(biscuits);
				}
				else if(A3ItemTF.getText()=="Sandwich"){
					ItemsForSale sandwich=new Sandwich();
					newMachine.addItems(sandwich);
				}
				newMachine.setA3Count(Integer.parseInt(A3CountTF.getText()));
				System.out.println("Details about A1 slot : \nItem Name: "+newMachine.getA1Item()+"\nCount : "+newMachine.getA1Count());
				System.out.println("Details about A2 slot : \nItem Name: "+newMachine.getA2Item()+"\nCount : "+newMachine.getA2Count());
				System.out.println("Details about A3 slot : \nItem Name: "+newMachine.getA3Item()+"\nCount : "+newMachine.getA3Count());
				System.out.println(newMachine.itemsAvailable.size());
				try {
					try {
						Database.addMachine(newMachine);
						Database.updateCostOfMachine(newMachine.id, 0);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Database.setMachineId();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				A1ItemTF.setText("");
				A2ItemTF.setText("");
				A3ItemTF.setText("");
				A1CountTF.setText(" ");
				A2CountTF.setText(" ");
				A3CountTF.setText(" ");
				MachineIdTF.setText(" ");
				panelNewMachine.setVisible(false);
				panelMachine.setVisible(true);
			}
		});
		btnCreateMachine.setBounds(110, 233, 171, 29);
		panelNewMachine.add(btnCreateMachine);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnClear.setBackground(new Color(193, 224, 219));
		btnClear.setBorderPainted(false);
		btnClear.setOpaque(true);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				A1ItemTF.setText(" ");
				A2ItemTF.setText(" ");
				A3ItemTF.setText(" ");
				A1CountTF.setText(" ");
				A2CountTF.setText(" ");
				A3CountTF.setText(" ");
			}
		});
		btnClear.setBounds(334, 233, 117, 29);
		panelNewMachine.add(btnClear);
		
		JButton btnBack_2 = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack_2.setIcon(new ImageIcon(img));
		btnBack_2.setBorderPainted(false); 
		btnBack_2.setContentAreaFilled(false); 
		btnBack_2.setFocusPainted(false); 
		btnBack_2.setOpaque(false);
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNewMachine.setVisible(false);
				panelMachine.setVisible(true);
			}
		});
		btnBack_2.setBounds(6, 6, 33, 29);
		panelNewMachine.add(btnBack_2);
		
		JLabel lblMachineWithId = new JLabel("Machine with ID");
		lblMachineWithId.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblMachineWithId.setBounds(130, 28, 146, 16);
		panelNewMachine.add(lblMachineWithId);
		
		MachineIdTF = new JTextField();
		MachineIdTF.setEditable(false);
		MachineIdTF.setBounds(264, 22, 134, 28);
		panelNewMachine.add(MachineIdTF);
		MachineIdTF.setColumns(10);
		MachineIdTF.setText(Integer.toString(machineID));
		
		A1ItemTF = new JTextField();
		A1ItemTF.setBounds(147, 90, 134, 28);
		panelNewMachine.add(A1ItemTF);
		A1ItemTF.setColumns(10);
		
		
		panelItems = new JPanel();
		panelItems.setBackground(new Color(255, 255, 255));
		frmAdmin.getContentPane().add(panelItems, "name_1439835112734692000");
		panelItems.setLayout(null);
		panelItems.setVisible(false);
		
		JLabel lblItemsInfo = new JLabel("Items Info");
		lblItemsInfo.setFont(new Font("Bradley Hand", Font.PLAIN, 20));
		lblItemsInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemsInfo.setBounds(215, 16, 124, 16);
		panelItems.add(lblItemsInfo);
		
		JLabel lblItemName1 = new JLabel("Item Name");
		lblItemName1.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblItemName1.setBounds(29, 53, 87, 16);
		panelItems.add(lblItemName1);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblPrice.setBounds(156, 53, 61, 16);
		panelItems.add(lblPrice);
		
		JLabel lblCalories = new JLabel("Calories");
		lblCalories.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblCalories.setBounds(254, 53, 76, 16);
		panelItems.add(lblCalories);
		
		JLabel lblSugar = new JLabel("Sugar");
		lblSugar.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblSugar.setBounds(381, 53, 61, 16);
		panelItems.add(lblSugar);
		
		List<ItemsForSale> items = Database.getItemsFromList();
		item1costTF = new JTextField();
		item1costTF.setEditable(false);
		item1costTF.setBounds(141, 81, 76, 28);
		panelItems.add(item1costTF);
		item1costTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Soda")){
				item1costTF.setText(Double.toString(item.getCost()));
			}
		}
		
		
		item1caloriesTF = new JTextField();
		item1caloriesTF.setEditable(false);
		item1caloriesTF.setBounds(229, 81, 110, 28);
		panelItems.add(item1caloriesTF);
		item1caloriesTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Soda")){
				item1caloriesTF.setText(String.valueOf(item.getCalories()));
			}
		}
		
		
		item1sugarTF = new JTextField();
		item1sugarTF.setEditable(false);
		item1sugarTF.setBounds(354, 81, 110, 28);
		panelItems.add(item1sugarTF);
		item1sugarTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Soda")){
				item1sugarTF.setText(String.valueOf(item.getSugarLevels()));
			}
		}
		
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnEdit.setBackground(new Color(193, 224, 219));
		btnEdit.setBorderPainted(false);
		btnEdit.setOpaque(true);
		btnEdit.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//logic
				panelItems.setVisible(false);
				panelItem.setVisible(true);
			}
		});
		btnEdit.setBounds(198, 267, 117, 29);
		panelItems.add(btnEdit);
		
		JButton btnBack_4 = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack_4.setIcon(new ImageIcon(img));
		btnBack_4.setBorderPainted(false); 
		btnBack_4.setContentAreaFilled(false); 
		btnBack_4.setFocusPainted(false); 
		btnBack_4.setOpaque(false);
		btnBack_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelItems.setVisible(false);
				panelMonitoring.setVisible(true);
			}
		});
		btnBack_4.setBounds(6, 6, 38, 26);
		panelItems.add(btnBack_4);
		
		item2costTF = new JTextField();
		item2costTF.setEditable(false);
		item2costTF.setBounds(141, 111, 76, 28);
		panelItems.add(item2costTF);
		item2costTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Chips")){
				item2costTF.setText(Double.toString(item.getCost()));
			}
		}
		
		item2caloriesTF = new JTextField();
		item2caloriesTF.setEditable(false);
		item2caloriesTF.setBounds(229, 111, 110, 28);
		panelItems.add(item2caloriesTF);
		item2caloriesTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Chips")){
				item2caloriesTF.setText(String.valueOf(item.getCalories()));
			}
		}
		
		item2sugarTF = new JTextField();
		item2sugarTF.setEditable(false);
		item2sugarTF.setBounds(354, 111, 110, 28);
		panelItems.add(item2sugarTF);
		item2sugarTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Chips")){
				item2sugarTF.setText(String.valueOf(item.getSugarLevels()));
			}
		}
		
		item3costTF = new JTextField();
		item3costTF.setEditable(false);
		item3costTF.setBounds(142, 138, 75, 28);
		panelItems.add(item3costTF);
		item3costTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Chocolates")){
				item3costTF.setText(Double.toString(item.getCost()));
			}
		}

		
		item3caloriesTF = new JTextField();
		item3caloriesTF.setEditable(false);
		item3caloriesTF.setBounds(229, 138, 110, 28);
		panelItems.add(item3caloriesTF);
		item3caloriesTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Chocolates")){
				item3caloriesTF.setText(String.valueOf(item.getCalories()));
			}
		}
		
		item3sugarTF = new JTextField();
		item3sugarTF.setEditable(false);
		item3sugarTF.setBounds(354, 138, 110, 28);
		panelItems.add(item3sugarTF);
		item3sugarTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Chocolates")){
				item3sugarTF.setText(String.valueOf(item.getSugarLevels()));
			}
		}
		
		item4costTF = new JTextField();
		item4costTF.setEditable(false);
		item4costTF.setBounds(142, 167, 75, 28);
		panelItems.add(item4costTF);
		item4costTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Biscuits")){
				item4costTF.setText(Double.toString(item.getCost()));
			}
		}

		
		item4caloriesTF = new JTextField();
		item4caloriesTF.setEditable(false);
		item4caloriesTF.setBounds(229, 167, 110, 28);
		panelItems.add(item4caloriesTF);
		item4caloriesTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Biscuits")){
				item4caloriesTF.setText(String.valueOf(item.getCalories()));
			}
		}
		
		item4sugarTF = new JTextField();
		item4sugarTF.setEditable(false);
		item4sugarTF.setBounds(354, 167, 110, 28);
		panelItems.add(item4sugarTF);
		item4sugarTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Biscuits")){
				item4sugarTF.setText(String.valueOf(item.getSugarLevels()));
			}
		}
		
		item5costTF = new JTextField();
		item5costTF.setEditable(false);
		item5costTF.setBounds(142, 196, 75, 28);
		panelItems.add(item5costTF);
		item5costTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Sandwich")){
				item5costTF.setText(Double.toString(item.getCost()));
			}
		}
		
		item5caloriesTF = new JTextField();
		item5caloriesTF.setEditable(false);
		item5caloriesTF.setBounds(229, 196, 110, 28);
		panelItems.add(item5caloriesTF);
		item5caloriesTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Sandwich")){
				item5caloriesTF.setText(String.valueOf(item.getCalories()));
			}
		}
		
		item5sugarTF = new JTextField();
		item5sugarTF.setEditable(false);
		item5sugarTF.setBounds(354, 196, 110, 28);
		panelItems.add(item5sugarTF);
		item5sugarTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Sandwich")){
				item5sugarTF.setText(String.valueOf(item.getSugarLevels()));
			}
		}
		
		item6costTF = new JTextField();
		item6costTF.setEditable(false);
		item6costTF.setBounds(142, 221, 75, 28);
		panelItems.add(item6costTF);
		item6costTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Water")){
				item6costTF.setText(Double.toString(item.getCost()));
			}
		}
		
		item6caloriesTF = new JTextField();
		item6caloriesTF.setEditable(false);
		item6caloriesTF.setBounds(229, 221, 110, 28);
		panelItems.add(item6caloriesTF);
		item6caloriesTF.setColumns(10);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Water")){
				item6caloriesTF.setText(String.valueOf(item.getCalories()));
			}
		}
		
		item6sugarTF = new JTextField();
		item6sugarTF.setEditable(false);
		item6sugarTF.setBounds(354, 221, 110, 28);
		panelItems.add(item6sugarTF);
		item6sugarTF.setColumns(10);
		
		JLabel lblSoda = new JLabel("Soda");
		lblSoda.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblSoda.setBounds(39, 87, 61, 16);
		panelItems.add(lblSoda);
		
		JLabel lblChips = new JLabel("Chips");
		lblChips.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblChips.setBounds(39, 117, 61, 16);
		panelItems.add(lblChips);
		
		JLabel lblChocolates = new JLabel("Chocolates");
		lblChocolates.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblChocolates.setBounds(40, 144, 90, 16);
		panelItems.add(lblChocolates);
		
		JLabel lblBiscuits = new JLabel("Biscuits");
		lblBiscuits.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblBiscuits.setBounds(39, 173, 77, 16);
		panelItems.add(lblBiscuits);
		
		JLabel lblSandwich = new JLabel("Sandwich");
		lblSandwich.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblSandwich.setBounds(39, 202, 91, 16);
		panelItems.add(lblSandwich);
		
		JLabel lblWater = new JLabel("Water");
		lblWater.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblWater.setBounds(39, 227, 61, 16);
		panelItems.add(lblWater);
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Water")){
				item6sugarTF.setText(String.valueOf(item.getSugarLevels()));
			}
		}
		
		
		//Admin window for a particular machine
		panelAdmin = new JPanel();
		panelAdmin.setBackground(new Color(255, 255, 255));
		frmAdmin.getContentPane().add(panelAdmin, "name_126218795468104");
		panelAdmin.setLayout(null);
		panelAdmin.setVisible(false);
		
		//Edit item panel
		panelItem = new JPanel();
		panelItem.setBackground(new Color(255, 255, 255));
		frmAdmin.getContentPane().add(panelItem, "name_269856321115023");
		panelItem.setLayout(null);
		
		/* Username and password in the login window
		 * Start of login window code
		 */
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setBounds(113, 74, 84, 16);
		panelLogin.add(UsernameLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setBounds(115, 125, 61, 16);
		panelLogin.add(PasswordLabel);
		
		UsernameTF = new JTextField();
		UsernameTF.setBounds(233, 68, 134, 28);
		panelLogin.add(UsernameTF);
		UsernameTF.setColumns(10);
		UsernameTF.setText("myAdmin2015");
		
		PasswordTF = new JPasswordField();
		PasswordTF.setBounds(233, 119, 134, 28);
		panelLogin.add(PasswordTF);
		PasswordTF.setColumns(10);
		PasswordTF.setText("123456");
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Bradley Hand", Font.PLAIN, 20));
		btnLogin.setBackground(new Color(193, 224, 219));
		btnLogin.setBorderPainted(false);
		btnLogin.setOpaque(true);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passText=new String(PasswordTF.getPassword());
				MonitoringSystem ms = new MonitoringSystem(new SuccessfulLogin());
				MonitoringSystem msInvalid = new MonitoringSystem(new InvalidLogin());
				if (ms.authenticateLogin(UsernameTF.getText(), passText)){
					panelMonitoring.setVisible(true);
					panelLogin.setVisible(false); 
				}
				else{
					attempts++;
					if (attempts > 5 && msInvalid.authenticateLogin(UsernameTF.getText(), passText)) {
						panelLogin.setVisible(false);
						panelMonitoring.setVisible(true);
					} else {
						panelLogin.setVisible(true);
					}
				}
				
			}
		});
		btnLogin.setBounds(196, 197, 117, 29);
		panelLogin.add(btnLogin);
		/* End of login window code
		 * 
		 */
		/* Start of Machine window code
		 * 
		 */
		JLabel lblMachineId = new JLabel("Machine ID");
		lblMachineId.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblMachineId.setBounds(114, 119, 113, 16);
		panelMachine.add(lblMachineId);
		
		MachineRetrieveTF = new JTextField();
		MachineRetrieveTF.setBounds(263, 113, 134, 28);
		panelMachine.add(MachineRetrieveTF);
		MachineRetrieveTF.setColumns(10);
		
		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnRetrieve.setBackground(new Color(193, 224, 219));
		btnRetrieve.setBorderPainted(false);
		btnRetrieve.setOpaque(true);
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(MachineRetrieveTF.getText());
				panelMachine.setVisible(false);
				panelAdmin.setVisible(true);
				revalidateScreen(id);
				/*itemsPanel.removeAll();
				Machine machine=null;
				try {
					machine = Database.retrieveMachine(id);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				group = new ButtonGroup();
				final JRadioButton[] buttons=new JRadioButton[6];
				int i=0;
				final JRadioButton btn1 = new JRadioButton(machine.getA1Item()+"(Count : " + machine.getA1Count() + ")");
				btn1.setActionCommand(machine.getA1Item());
				buttons[0]=btn1;
				group.add(btn1);
				itemsPanel.add(btn1);
				final JRadioButton btn2 = new JRadioButton(machine.getA2Item()+"(Count : " + machine.getA2Count() + ")");
				btn2.setActionCommand(machine.getA2Item());
				buttons[1]=btn2;
				group.add(btn2);
				itemsPanel.add(btn2);
				final JRadioButton btn3 = new JRadioButton(machine.getA3Item()+"(Count : " + machine.getA3Count() + ")");
				btn3.setActionCommand(machine.getA3Item());
				buttons[2]=btn3;
				group.add(btn3);
				itemsPanel.add(btn3);
				
				try {
					textField.setText(Double.toString(Database.getBalanceOfMachine(Integer.parseInt(MachineRetrieveTF.getText()))));
				} catch (Exception e1) {
					e1.printStackTrace();
				} */
			
			}
			
		});
		btnRetrieve.setBounds(120, 200, 117, 29);
		panelMachine.add(btnRetrieve);
		
		JButton btnAddNewMachine = new JButton("Add New Machine");
		btnAddNewMachine.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnAddNewMachine.setBackground(new Color(193, 224, 219));
		btnAddNewMachine.setBorderPainted(false);
		btnAddNewMachine.setOpaque(true);
		btnAddNewMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MachineIdTF.setText(Integer.toString(Database.getMachineId()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				panelMachine.setVisible(false);
				panelNewMachine.setVisible(true);
			}
				
		});
		btnAddNewMachine.setBounds(263, 200, 193, 29);
		panelMachine.add(btnAddNewMachine);
		
		
		btnBack_5 = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack_5.setIcon(new ImageIcon(img));
		btnBack_5.setBorderPainted(false); 
		btnBack_5.setContentAreaFilled(false); 
		btnBack_5.setFocusPainted(false); 
		btnBack_5.setOpaque(false);
		btnBack_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMachine.setVisible(false);
				panelMonitoring.setVisible(true);
			}
		});
		btnBack_5.setBounds(6, 6, 31, 29);
		panelMachine.add(btnBack_5);
		/* End of machine window code
		 * 
		 */
		/* Start of Admin window
		 * 
		 */
		JLabel lblSmartVendingMachine = new JLabel("Smart Vending Machine");
		lblSmartVendingMachine.setHorizontalAlignment(SwingConstants.CENTER);
		lblSmartVendingMachine.setFont(new Font("Bradley Hand", Font.BOLD, 24));
		lblSmartVendingMachine.setBounds(123, 6, 339, 30);
		panelAdmin.add(lblSmartVendingMachine);
		
		itemsPanel = new JPanel();
		itemsPanel.setBackground(new Color(255, 255, 255));
		itemsPanel.setBounds(25, 102, 497, 119);
		panelAdmin.add(itemsPanel);
		
		JButton btnAddNewItem = new JButton("Add New Item");
		btnAddNewItem.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnAddNewItem.setBackground(new Color(193, 224, 219));
		btnAddNewItem.setBorderPainted(false);
		btnAddNewItem.setOpaque(true);
		btnAddNewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAdmin.setVisible(false);
				panelAddNewItem.setVisible(true);
			}
		});
		btnAddNewItem.setBounds(117, 257, 154, 29);
		panelAdmin.add(btnAddNewItem);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnLogout.setBackground(new Color(193, 224, 219));
		btnLogout.setBorderPainted(false);
		btnLogout.setOpaque(true);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setBounds(312, 257, 117, 29);
		panelAdmin.add(btnLogout);
		
		JButton btnBack = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(img));
		btnBack.setBorderPainted(false); 
		btnBack.setContentAreaFilled(false); 
		btnBack.setFocusPainted(false); 
		btnBack.setOpaque(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMachine.setVisible(true);
				panelAdmin.setVisible(false);
			}
		});
		btnBack.setBounds(6, 6, 31, 29);
		panelAdmin.add(btnBack);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblBalance.setBounds(143, 58, 73, 16);
		panelAdmin.add(lblBalance);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(228, 48, 134, 28);
		panelAdmin.add(textField);
		textField.setColumns(10);
		
		JButton btnRefresh = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/refresh.png")).getImage();
		btnRefresh.setIcon(new ImageIcon(img));
		btnRefresh.setBorderPainted(false); 
		btnRefresh.setContentAreaFilled(false); 
		btnRefresh.setFocusPainted(false); 
		btnRefresh.setOpaque(false);
		btnRefresh.setBounds(499, 6, 40, 29);
		panelAdmin.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					revalidateScreen(Integer.parseInt(MachineRetrieveTF.getText()));
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				frmAdmin.getContentPane().validate();
				frmAdmin.getContentPane().repaint();
				panelAdmin.validate();
				panelAdmin.repaint();
			}
		});
		
		
		JLabel lblItem = new JLabel("Item");
		lblItem.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblItem.setBounds(117, 71, 61, 16);
		panelItem.add(lblItem);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblCost.setBounds(117, 118, 61, 16);
		panelItem.add(lblCost);
		
		JLabel Calories = new JLabel("Calories");
		Calories.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		Calories.setBounds(117, 161, 116, 16);
		panelItem.add(Calories);
		
		JLabel lblEditItem = new JLabel("Edit Item");
		lblEditItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditItem.setFont(new Font("Bradley Hand", Font.BOLD, 24));
		lblEditItem.setBounds(208, 17, 151, 16);
		panelItem.add(lblEditItem);
		
		String[] items_list={"Soda","Chips","Biscuits","Sandwich","Water","Chocolates"};
		final JComboBox comboBoxTF = new JComboBox(items_list);
		comboBoxTF.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		comboBoxTF.setBounds(245, 67, 199, 27);
		comboBoxTF.setEditable(false);
		comboBoxTF.setSelectedItem("Soda");
		panelItem.add(comboBoxTF);
		
		
		
		costTF = new JTextField();
		costTF.setBounds(245, 112, 198, 28);
		panelItem.add(costTF);
		costTF.setColumns(10);
		
		
		caloriesTF = new JTextField();
		caloriesTF.setBounds(245, 155, 198, 28);
		panelItem.add(caloriesTF);
		caloriesTF.setColumns(10);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnSave.setBackground(new Color(193, 224, 219));
		btnSave.setBorderPainted(false);
		btnSave.setOpaque(true);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ItemsForSale> items = null;
				try {
					items = Database.getItemsFromList();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(comboBoxTF.getSelectedItem().toString().equals("Soda")){
						for(ItemsForSale item : items){
							if(item.getItemName().equals("Soda")){
								item.setCost(Double.parseDouble(costTF.getText()));
								item.setCalories(Integer.parseInt(caloriesTF.getText()));
								item.setSugar(Integer.parseInt(sugarTF.getText()));
								try {
									//Database.addItemToList(item);
									Database.updateItemInfo("Soda", item);
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}}}
				
				else if(comboBoxTF.getSelectedItem().toString().equals("Chips")){		
					for(ItemsForSale item : items){
						if(item.getItemName().equals("Chips")){
							item.setCost(Double.parseDouble(costTF.getText()));
							item.setCalories(Integer.parseInt(caloriesTF.getText()));
							item.setSugar(Integer.parseInt(sugarTF.getText()));
							try {
								Database.updateItemInfo("Chips", item);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}}}
				
				else if(comboBoxTF.getSelectedItem().toString().equals("Chocolates")){		
					for(ItemsForSale item : items){
						 if(item.getItemName().equals("Chocolates")){
								item.setCost(Double.parseDouble(costTF.getText()));
								item.setCalories(Integer.parseInt(caloriesTF.getText()));
								item.setSugar(Integer.parseInt(sugarTF.getText()));
								try {
									Database.updateItemInfo("Chocolates", item);
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}}}
				
				else if(comboBoxTF.getSelectedItem().toString().equals("Biscuits")){		
					for(ItemsForSale item : items){
							if(item.getItemName().equals("Biscuits")){
								item.setCost(Double.parseDouble(costTF.getText()));
								item.setCalories(Integer.parseInt(caloriesTF.getText()));
								item.setSugar(Integer.parseInt(sugarTF.getText()));
								try {
									Database.updateItemInfo("Biscuits", item);
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}}}
				
				else if(comboBoxTF.getSelectedItem().toString().equals("Water")){		
					for(ItemsForSale item : items){
							if(item.getItemName().equals("Water")){
								item.setCost(Double.parseDouble(costTF.getText()));
								item.setCalories(Integer.parseInt(caloriesTF.getText()));
								item.setSugar(Integer.parseInt(sugarTF.getText()));
								try {
									Database.updateItemInfo("Water", item);
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}}}
				
				else if(comboBoxTF.getSelectedItem().toString().equals("Sandwich")){		
					for(ItemsForSale item : items){
							if(item.getItemName().equals("Sandwich")){
								item.setCost(Double.parseDouble(costTF.getText()));
								item.setCalories(Integer.parseInt(caloriesTF.getText()));
								item.setSugar(Integer.parseInt(sugarTF.getText()));
								try {
									Database.updateItemInfo("Sandwich", item);
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
				}
				panelItem.setVisible(false);
				
				for(ItemsForSale item : items){

					if(item.getItemName().equals("Soda")){
						item1costTF.setText(Double.toString(item.getCost()));
						item1caloriesTF.setText(String.valueOf(item.getCalories()));
						item1sugarTF.setText(String.valueOf(item.getSugarLevels()));
					} else if(item.getItemName().equals("Chips")){
						item2costTF.setText(Double.toString(item.getCost()));
						item2caloriesTF.setText(String.valueOf(item.getCalories()));
						item2sugarTF.setText(String.valueOf(item.getSugarLevels()));
					} else if(item.getItemName().equals("Chocolates")){
						item3costTF.setText(Double.toString(item.getCost()));
						item3caloriesTF.setText(String.valueOf(item.getCalories()));
						item3sugarTF.setText(String.valueOf(item.getSugarLevels()));
					}

					else if(item.getItemName().equals("Biscuits")){

					item4costTF.setText(Double.toString(item.getCost()));

					item4caloriesTF.setText(String.valueOf(item.getCalories()));

					item4sugarTF.setText(String.valueOf(item.getSugarLevels()));

					}

					else if(item.getItemName().equals("Sandwich")){

					item5costTF.setText(Double.toString(item.getCost()));

					item5caloriesTF.setText(String.valueOf(item.getCalories()));

					item5sugarTF.setText(String.valueOf(item.getSugarLevels()));

					}

					else if(item.getItemName().equals("Water")){

					item6costTF.setText(Double.toString(item.getCost()));

					item6caloriesTF.setText(String.valueOf(item.getCalories()));

					item6sugarTF.setText(String.valueOf(item.getSugarLevels()));

					}


					}
				panelItems.setVisible(true);
				
			}
		});
		btnSave.setBounds(224, 246, 117, 29);
		panelItem.add(btnSave);
		
		JButton btnBack_1 = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack_1.setIcon(new ImageIcon(img));
		btnBack_1.setBorderPainted(false); 
		btnBack_1.setContentAreaFilled(false); 
		btnBack_1.setFocusPainted(false); 
		btnBack_1.setOpaque(false);
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelItem.setVisible(false);
				panelItems.setVisible(true);
			}
		});
		btnBack_1.setBounds(6, 6, 35, 29);
		panelItem.add(btnBack_1);
		
		JLabel sugarlevel = new JLabel("Sugar level");
		sugarlevel.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		sugarlevel.setBounds(117, 203, 97, 16);
		panelItem.add(sugarlevel);
		
		sugarTF = new JTextField();
		sugarTF.setBounds(245, 191, 198, 28);
		panelItem.add(sugarTF);
		sugarTF.setColumns(10);
		
		panelAddNewItem = new JPanel();
		panelAddNewItem.setBackground(new Color(255, 255, 255));
		frmAdmin.getContentPane().add(panelAddNewItem, "name_1439838165973654000");
		panelAddNewItem.setLayout(null);
		panelAddNewItem.setVisible(false);
		
		
		
		String[] items_slots={"A1 slot","A2 slot","A3 slot"};
		final JComboBox slotComboTF = new JComboBox(items_slots);
		slotComboTF.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		slotComboTF.setBounds(271, 86, 134, 27);
		comboBoxTF.setEditable(false);
		panelAddNewItem.add(slotComboTF);
		
		JLabel lblSlot = new JLabel("Slot");
		lblSlot.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblSlot.setBounds(119, 90, 61, 16);
		panelAddNewItem.add(lblSlot);
		
		JLabel lblItem_1 = new JLabel("Item");
		lblItem_1.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblItem_1.setBounds(119, 129, 61, 16);
		panelAddNewItem.add(lblItem_1);
		
		
		String[] itemsList={"Soda","Chips","Biscuits","Sandwich","Water","Chocolates"};
		final JComboBox itemComboTF = new JComboBox(itemsList);
		itemComboTF.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		itemComboTF.setBounds(271, 125, 134, 27);
		comboBoxTF.setEditable(false);
		comboBoxTF.setSelectedItem("Soda");
		panelAddNewItem.add(itemComboTF);
		
		JLabel lblCount = new JLabel("Count");
		lblCount.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblCount.setBounds(119, 169, 61, 16);
		panelAddNewItem.add(lblCount);
		
		countTF = new JTextField();
		countTF.setBounds(271, 163, 134, 28);
		panelAddNewItem.add(countTF);
		countTF.setColumns(10);
		
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnSave_1.setBackground(new Color(193, 224, 219));
		btnSave_1.setBorderPainted(false);
		btnSave_1.setOpaque(true);
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(MachineRetrieveTF.getText());
				Machine machine=null;
				try {
					machine=Database.retrieveMachine(id);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Machine newmachine=new Machine();
				//newmachine.setMachineId(id);
				if(slotComboTF.getSelectedItem().equals("A1 slot")){
					if(itemComboTF.getSelectedItem().equals("Soda")){
						machine.setA1Item("Soda");
						machine.setA1Count(Integer.parseInt(countTF.getText()));
					}
					else if(itemComboTF.getSelectedItem().equals("Chips")){
						machine.setA1Item("Chips");
						machine.setA1Count(Integer.parseInt(countTF.getText()));
					}
					else if(itemComboTF.getSelectedItem().equals("Biscuits")){
						machine.setA1Item("Biscuits");
						machine.setA1Count(Integer.parseInt(countTF.getText()));
					}
					else if(itemComboTF.getSelectedItem().equals("Chocolates")){
						machine.setA1Item("Chocolates");
						machine.setA1Count(Integer.parseInt(countTF.getText()));
					}
					else if(itemComboTF.getSelectedItem().equals("Water")){
						machine.setA1Item("Water");
						machine.setA1Count(Integer.parseInt(countTF.getText()));
					}
					else if(itemComboTF.getSelectedItem().equals("Sandwich")){
						machine.setA1Item("Sandwich");
						machine.setA1Count(Integer.parseInt(countTF.getText()));
					}
				}
				
				else if(slotComboTF.getSelectedItem().equals("A2 slot")){
					if(itemComboTF.getSelectedItem().equals("Soda")){
						machine.setA2Item("Soda");
						machine.setA2Count(Integer.parseInt(countTF.getText()));
					}
					else if(itemComboTF.getSelectedItem().equals("Chips")){
						machine.setA2Item("Chips");
						machine.setA2Count(Integer.parseInt(countTF.getText()));
					}
					else if(itemComboTF.getSelectedItem().equals("Biscuits")){
						machine.setA2Item("Biscuits");
						machine.setA2Count(Integer.parseInt(countTF.getText()));
					}
					else if(itemComboTF.getSelectedItem().equals("Chocolates")){
						machine.setA2Item("Chocolates");
						machine.setA2Count(Integer.parseInt(countTF.getText()));
					}
					else if(itemComboTF.getSelectedItem().equals("Water")){
						machine.setA2Item("Water");
						machine.setA2Count(Integer.parseInt(countTF.getText()));
					}
					else if(itemComboTF.getSelectedItem().equals("Sandwich")){
						machine.setA2Item("Sandwich");
						machine.setA2Count(Integer.parseInt(countTF.getText()));
					}
				}
				
				else if(slotComboTF.getSelectedItem().equals("A3 slot")){
					if(itemComboTF.getSelectedItem().equals("Soda")){
						machine.setA3Item("Soda");
						machine.setA3Count(Integer.parseInt(countTF.getText()));
					}
					else if(itemComboTF.getSelectedItem().equals("Chips")){
						machine.setA3Item("Chips");
						machine.setA3Count(Integer.parseInt(countTF.getText()));
					}
					else if(itemComboTF.getSelectedItem().equals("Biscuits")){
						machine.setA3Item("Biscuits");
						machine.setA3Count(Integer.parseInt(countTF.getText()));
					}
					else if(itemComboTF.getSelectedItem().equals("Chocolates")){
						machine.setA3Item("Chocolates");
						machine.setA3Count(Integer.parseInt(countTF.getText()));
					}
					else if(itemComboTF.getSelectedItem().equals("Water")){
						machine.setA3Item("Water");
						machine.setA3Count(Integer.parseInt(countTF.getText()));
					}
					else if(itemComboTF.getSelectedItem().equals("Sandwich")){
						machine.setA3Item("Sandwich");
						machine.setA3Count(Integer.parseInt(countTF.getText()));
					}
				}
				try {
					Database.updateMachineInfo(id, machine);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/*newmachine.setMachineId(machine.getMachineId());
				machine.setMachineId(0);
				try {
					Database.addMachine(newmachine);
					Database.addMachine(machine);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				panelAddNewItem.setVisible(false);
				panelMachine.setVisible(true);
				
			}
		});
		btnSave_1.setBounds(214, 218, 117, 29);
		panelAddNewItem.add(btnSave_1);
		
		JButton btnBack_3 = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack_3.setIcon(new ImageIcon(img));
		btnBack_3.setBorderPainted(false); 
		btnBack_3.setContentAreaFilled(false); 
		btnBack_3.setFocusPainted(false); 
		btnBack_3.setOpaque(false);
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddNewItem.setVisible(false);
				panelAdmin.setVisible(true);
			}
		});
		btnBack_3.setBounds(6, 6, 29, 29);
		panelAddNewItem.add(btnBack_3);
		
		JLabel lblAddNewItem = new JLabel("Add New Item");
		lblAddNewItem.setFont(new Font("Bradley Hand", Font.PLAIN, 24));
		lblAddNewItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewItem.setBounds(186, 6, 192, 37);
		panelAddNewItem.add(lblAddNewItem);
		
		panelStatistics = new JPanel();
		panelStatistics.setBackground(new Color(255, 255, 255));
		frmAdmin.getContentPane().add(panelStatistics, "name_14773520192856");
		panelStatistics.setLayout(null);
		
		panelStatistics.removeAll();
		
		btnBack_6 = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack_6.setIcon(new ImageIcon(img));
		btnBack_6.setBorderPainted(false); 
		btnBack_6.setContentAreaFilled(false); 
		btnBack_6.setFocusPainted(false); 
		btnBack_6.setOpaque(false);
		btnBack_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelStatistics.setVisible(false);
				panelMonitoring.setVisible(true);
			}
		});
		btnBack_6.setBounds(6, 6, 32, 29);
		panelStatistics.add(btnBack_6);
		
		panelBarChart = new JPanel();
		panelBarChart.setBounds(23, 91, 501, 206);
		panelStatistics.add(panelBarChart);
		panelBarChart.setLayout(new BorderLayout(0, 0));
		
		JButton btnTotalEarnings = new JButton("Total Sales");
		btnTotalEarnings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				try {
					Set<Machine> machines = Database.getAllMachines();
					for(Machine mac : machines){
						double earning = Database.getEarningsOfMachine(mac.id);
						dataset.setValue(earning, "Total Earnings", "Machine "+mac.id);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
				JFreeChart barChart = ChartFactory.createBarChart("Total Sales", "Machines", "Total Sales", dataset, PlotOrientation.VERTICAL, false, true, false);
				CategoryPlot cat = barChart.getCategoryPlot();
				cat.setRangeGridlinePaint(Color.ORANGE);
				ChartPanel barPanel = new ChartPanel(barChart);
				panelBarChart.removeAll();
				panelBarChart.add(barPanel, BorderLayout.CENTER);
				panelBarChart.validate();
				panelBarChart.setVisible(true);
			}
		});
		btnTotalEarnings.setBounds(103, 26, 117, 29);
		panelStatistics.add(btnTotalEarnings);
		
		JButton btnPopularItem = new JButton("Popular Items");
		btnPopularItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultPieDataset dataset = new DefaultPieDataset();
				try {
					List<ItemsForSale> items = Database.getItemsFromList();
					for(ItemsForSale i : items){
						int count = Database.getCountOfItem(i.getItemName());
						dataset.setValue(i.getItemName()+":"+count, count);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				JFreeChart pieChart = ChartFactory.createPieChart3D("Popular Items", dataset, true, true, true);
				PiePlot3D pie = (PiePlot3D) pieChart.getPlot();
				ChartPanel piePanel = new ChartPanel(pieChart);
				panelBarChart.removeAll();
				panelBarChart.add(piePanel, BorderLayout.CENTER);
				panelBarChart.validate();
				panelBarChart.setVisible(true);
			}
		});
		btnPopularItem.setBounds(311, 26, 117, 29);
		panelStatistics.add(btnPopularItem);
		panelBarChart.setVisible(false);
		
	
	}
	
	private void displayItemInfo() throws IOException, ClassNotFoundException{
		List<ItemsForSale> items = Database.getItemsFromList();
		for(ItemsForSale item : items){
			if(item.getItemName().equals("Soda")){
				item1costTF.setText(Double.toString(item.getCost()));
				item1caloriesTF.setText(String.valueOf(item.getCalories()));
				item1sugarTF.setText(String.valueOf(item.getSugarLevels()));
			}
		}
	}
	
	private void getStatistics() throws IOException, ClassNotFoundException {
		panelStatistics.removeAll();
		JLabel lblTotalEarnings = new JLabel("Total Earnings");
		lblTotalEarnings.setBounds(194, 6, 142, 35);
		panelStatistics.add(lblTotalEarnings);
		
		JLabel lblTotalEarnings_1 = new JLabel("Total Earnings");
		lblTotalEarnings_1.setBounds(274, 65, 109, 16);
		panelStatistics.add(lblTotalEarnings_1);
		
		btnBack_6 = new JButton("");
		Image img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack_6.setIcon(new ImageIcon(img));
		btnBack_6.setBorderPainted(false); 
		btnBack_6.setContentAreaFilled(false); 
		btnBack_6.setFocusPainted(false); 
		btnBack_6.setOpaque(false);
		btnBack_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelStatistics.setVisible(false);
				panelMonitoring.setVisible(true);
			}
		});
		btnBack_6.setBounds(6, 6, 32, 29);
		panelStatistics.add(btnBack_6);
		
		int y = 95;
		int x = 124;
		
		Set<Machine> machine = Database.getAllMachines();
		for(Machine mac : machine){
			double earnings = Database.getEarningsOfMachine(mac.id);
			JLabel machineLabel = new JLabel();
			JLabel earningsLabel = new JLabel();
			machineLabel.setText("Machine " + Integer.toString(mac.id));
			earningsLabel.setText("$" + Double.toString(earnings));
			machineLabel.setBounds(x, y, 83, 16);
			panelStatistics.add(machineLabel);
			x += 150;
			earningsLabel.setBounds(x, y, 72, 16);
			panelStatistics.add(earningsLabel);
			y += 30;
			x = 124;
		}
	}
	
	private void revalidateScreen(int id) {
		itemsPanel.removeAll();
		Machine machine=null;
		try {
			machine = Database.retrieveMachine(id);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		group = new ButtonGroup();
		final JRadioButton[] buttons=new JRadioButton[6];
		int i=0;
		final JRadioButton btn1 = new JRadioButton(machine.getA1Item()+"(Count : " + machine.getA1Count() + ")");
		btn1.setActionCommand(machine.getA1Item());
		buttons[0]=btn1;
		group.add(btn1);
		itemsPanel.add(btn1);
		final JRadioButton btn2 = new JRadioButton(machine.getA2Item()+"(Count : " + machine.getA2Count() + ")");
		btn2.setActionCommand(machine.getA2Item());
		buttons[1]=btn2;
		group.add(btn2);
		itemsPanel.add(btn2);
		final JRadioButton btn3 = new JRadioButton(machine.getA3Item()+"(Count : " + machine.getA3Count() + ")");
		btn3.setActionCommand(machine.getA3Item());
		buttons[2]=btn3;
		group.add(btn3);
		itemsPanel.add(btn3);
		
		try {
			textField.setText(Double.toString(Database.getBalanceOfMachine(Integer.parseInt(MachineRetrieveTF.getText()))));
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
	}
}





