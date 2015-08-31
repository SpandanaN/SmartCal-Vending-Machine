package SmartCalPackage;

import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LinearGradientPaint;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

public class UserGUI2 {

	private static JFrame frmUserGui;
	private JTextField TotalAmtTF;
	private JTextField AmtInsertedTF;
	private JTextField ChangeTF;
	private JTextField cardAmtTF;
	private JTextField cardNumTF;
	private JTextField cardBalTF;
	private static JTextField TotalTF;
	private static JPanel VendingMachinePanel;
	private static JPanel panel;
	private JPanel PurchasePanel;
	private JPanel SuggestionsPanel;
	private JPanel MoneyPanel;
	private JPanel CardPanel;
	private JPanel ExistingCardPanel;
	private JPanel NewCardPanel;
	private JPanel PaymentPanel;
	private JPanel QueryPanel;
	private JPanel AllItemsInfoPanel;
	private JPanel SearchPanel;
	private JPanel itemsPanel;
	private static JRadioButton[] buttons;
	private static ButtonGroup group = new ButtonGroup();
	private static ButtonGroup infoGroup = new ButtonGroup();
	private static double total = 0;
	private static Machine machine = null;
	private JTextField totalTF;
	private JTextField amtTF;
	private JTextField balanceTF;
	private double cardAmt = 0;
	private JTextField item1CalTF;
	private JTextField item1SugarTF;
	private JTextField item2CalTF;
	private JTextField item2SugarTF;
	private JTextField item3CalTF;
	private JTextField item3SugarTF;
	private List<ItemsForSale> queryItems = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI2 window = new UserGUI2();
					window.frmUserGui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public UserGUI2() throws IOException, ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	private void initialize() throws IOException, ClassNotFoundException {
		frmUserGui = new JFrame();
		frmUserGui.setFont(new Font("Dialog", Font.BOLD, 12));
		frmUserGui.setBackground(Color.WHITE);
		frmUserGui.setTitle("User");
		frmUserGui.setBounds(100, 100, 559, 356);
		frmUserGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUserGui.getContentPane().setLayout(new CardLayout(0, 0));
		//frmUserGui.setUndecorated(true);
		
		VendingMachinePanel = new JPanel();
		VendingMachinePanel.setBorder(new LineBorder(null, 2, true));
		VendingMachinePanel.setBackground(new Color(193, 224, 219));
		frmUserGui.getContentPane().add(VendingMachinePanel, "name_444948060346158");
		VendingMachinePanel.setLayout(null);
		VendingMachinePanel.setVisible(true);
		
		JLabel lblSmartVendingMachine = new JLabel("Welcome to SmartCal");
		lblSmartVendingMachine.setFont(new Font("Bradley Hand", Font.BOLD, 24));
		lblSmartVendingMachine.setHorizontalAlignment(SwingConstants.CENTER);
		lblSmartVendingMachine.setBounds(90, 6, 368, 31);
		VendingMachinePanel.add(lblSmartVendingMachine);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblTotal.setBounds(175, 65, 61, 16);
		VendingMachinePanel.add(lblTotal);
		
		TotalTF = new JTextField();
		TotalTF.setEditable(false);
		TotalTF.setBounds(248, 58, 134, 28);
		VendingMachinePanel.add(TotalTF);
		TotalTF.setColumns(10);
		TotalTF.setText(Double.toString(total));
		
		panel = new JPanel();
		panel.setBackground(new Color(193, 224, 219));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Select an item", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(21, 112, 519, 160);
		VendingMachinePanel.add(panel);
		
		//Adding items to the display
		revalidateScreen();
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setFont(new Font("Bradley Hand", Font.PLAIN, 20));
		btnPurchase.setBackground(Color.WHITE);
		btnPurchase.setBorderPainted(false);
		btnPurchase.setOpaque(true);
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					machine.CheckMachineState();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(frmUserGui, machine.purchase());
				VendingMachinePanel.setVisible(false);
				PurchasePanel.setVisible(true);
			}
		});
		btnPurchase.setBounds(126, 284, 134, 29);
		VendingMachinePanel.add(btnPurchase);
		
		JButton btnSuggestions = new JButton("Nutritional Info");
		btnSuggestions.setBackground(Color.WHITE);
		btnSuggestions.setBorderPainted(false);
		btnSuggestions.setOpaque(true);
		btnSuggestions.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnSuggestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendingMachinePanel.setVisible(false);
				SuggestionsPanel.setVisible(true);
			}
		});
		btnSuggestions.setBounds(331, 285, 158, 29);
		VendingMachinePanel.add(btnSuggestions);
		
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
		VendingMachinePanel.add(btnCancel);
		
		JButton btnRefresh = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/refresh.png")).getImage();
		btnRefresh.setIcon(new ImageIcon(img));
		btnRefresh.setBorderPainted(false); 
		btnRefresh.setContentAreaFilled(false); 
		btnRefresh.setFocusPainted(false); 
		btnRefresh.setOpaque(false);
		btnRefresh.setBounds(513, 6, 40, 29);
		VendingMachinePanel.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					revalidateScreen();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				frmUserGui.getContentPane().validate();
				frmUserGui.getContentPane().repaint();
				VendingMachinePanel.validate();
				VendingMachinePanel.repaint();
			}
		});
		
		PurchasePanel = new JPanel();
		PurchasePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		PurchasePanel.setBackground(new Color(193, 224, 219));
		frmUserGui.getContentPane().add(PurchasePanel, "name_444951491350727");
		PurchasePanel.setLayout(null);
		PurchasePanel.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("How would you like to pay?");
		lblNewLabel.setFont(new Font("Bradley Hand", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(144, 19, 285, 35);
		PurchasePanel.add(lblNewLabel);
		
		JButton btnCoins = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/coins.png")).getImage();
		btnCoins.setIcon(new ImageIcon(img));
		btnCoins.setBorderPainted(false); 
		btnCoins.setContentAreaFilled(false); 
		btnCoins.setFocusPainted(false); 
		btnCoins.setOpaque(false);
		btnCoins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchasePanel.setVisible(false);
				String t = String.format( "%.2f", total);
				TotalAmtTF.setText(t);
				MoneyPanel.setVisible(true);
			}
		});
		btnCoins.setBounds(144, 133, 77, 72);
		PurchasePanel.add(btnCoins);
		
		JButton btnBills = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/bills.png")).getImage();
		btnBills.setIcon(new ImageIcon(img));
		btnBills.setBorderPainted(false); 
		btnBills.setContentAreaFilled(false); 
		btnBills.setFocusPainted(false); 
		btnBills.setOpaque(false);
		btnBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchasePanel.setVisible(false);
				String t = String.format( "%.2f", total);
				TotalAmtTF.setText(t);
				MoneyPanel.setVisible(true);
			}
		});
		btnBills.setBounds(260, 133, 85, 72);
		PurchasePanel.add(btnBills);
		
		JButton btnCard = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/card.png")).getImage();
		btnCard.setIcon(new ImageIcon(img));
		btnCard.setBorderPainted(false); 
		btnCard.setContentAreaFilled(false); 
		btnCard.setFocusPainted(false); 
		btnCard.setOpaque(false);
		btnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchasePanel.setVisible(false);
				String t = String.format( "%.2f", total);
				cardAmtTF.setText(t);
				CardPanel.setVisible(true);
			}
		});
		btnCard.setBounds(374, 133, 85, 72);
		PurchasePanel.add(btnCard);
		
		JButton btnBack = new JButton("");
		btnBack.setBorderPainted(false); 
		btnBack.setContentAreaFilled(false); 
		btnBack.setFocusPainted(false); 
		btnBack.setOpaque(false);
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(img));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PurchasePanel.setVisible(false);
				VendingMachinePanel.setVisible(true);
			}
		});
		btnBack.setBounds(6, 6, 37, 42);
		PurchasePanel.add(btnBack);
		
		MoneyPanel = new JPanel();
		MoneyPanel.setBackground(new Color(193, 224, 219));
		MoneyPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		frmUserGui.getContentPane().add(MoneyPanel, "name_445199863511003");
		MoneyPanel.setLayout(null);
		MoneyPanel.setVisible(false);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblTotalAmount.setBounds(144, 89, 117, 16);
		MoneyPanel.add(lblTotalAmount);
		
		TotalAmtTF = new JTextField();
		TotalAmtTF.setEditable(false);
		TotalAmtTF.setBounds(278, 82, 134, 28);
		MoneyPanel.add(TotalAmtTF);
		TotalAmtTF.setColumns(10);
		
		JLabel lblAmountInserted = new JLabel("Amount Inserted");
		lblAmountInserted.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblAmountInserted.setBounds(125, 140, 146, 16);
		MoneyPanel.add(lblAmountInserted);
		
		AmtInsertedTF = new JTextField();
		AmtInsertedTF.setBounds(278, 134, 134, 28);
		MoneyPanel.add(AmtInsertedTF);
		AmtInsertedTF.setColumns(10);
		AmtInsertedTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amtInserted = Double.parseDouble(AmtInsertedTF.getText());
				Payment payment = new MoneyPayment(total, amtInserted, new MoneyImpl());
				double change = payment.getChange();
				String t = String.format( "%.2f", change);
				ChangeTF.setText(t);
			}
		});

		JLabel lblChange = new JLabel("Change");
		lblChange.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblChange.setBounds(190, 187, 74, 16);
		MoneyPanel.add(lblChange);
		
		ChangeTF = new JTextField();
		ChangeTF.setEditable(false);
		ChangeTF.setBounds(278, 180, 134, 28);
		MoneyPanel.add(ChangeTF);
		ChangeTF.setColumns(10);
		
		JButton btnPay = new JButton("Pay");
		btnPay.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnPay.setBackground(Color.WHITE);
		btnPay.setBorderPainted(false);
		btnPay.setOpaque(true);
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Database.updateCashInMachine(2, Double.parseDouble(ChangeTF.getText()));
				} catch (NumberFormatException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();

				}
				double amtInserted = Double.parseDouble(AmtInsertedTF.getText());
				Payment payment = new MoneyPayment(total, amtInserted, new MoneyImpl());
				double change = payment.getChange();
				ChangeTF.setText(Double.toString(change));
				if(change < 0){
					JOptionPane.showMessageDialog(frmUserGui, "Amount inserted not sufficient to purchase the item");
				} else {
					JOptionPane.showMessageDialog(frmUserGui, "Please take your item.");
					//Update the count of the item
					String actionCmd = group.getSelection().getActionCommand();
					String item = actionCmd.substring(0, actionCmd.indexOf(" "));
					CountObserver admin = new CountObserver(machine);
					if(machine.getA1Item().equals(item)){
						machine.setA1Count(machine.getA1Count() - 1);
					} else if(machine.getA2Item().equals(item)){
						machine.setA2Count(machine.getA2Count() - 1);
					} else if(machine.getA3Item().equals(item)){
						machine.setA3Count(machine.getA3Count() - 1);
					} 
					try {
						Database.updateMachineInfo(2, machine);
					} catch (Exception e1) {
						e1.printStackTrace();
					} 
					//Update the total cost of that machine
					try {
						Database.updateCostOfMachine(2, total);
						Database.updateCountOfItems(item);
					} catch (Exception e1) {
						e1.printStackTrace();
					} 
					MoneyPanel.setVisible(false);
					clearMachinePanel();
					VendingMachinePanel.setVisible(true);
				}
			}
		});
		btnPay.setBounds(227, 241, 117, 29);
		MoneyPanel.add(btnPay);
		
		JButton btnNewButton = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setBorderPainted(false); 
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton.setFocusPainted(false); 
		btnNewButton.setOpaque(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MoneyPanel.setVisible(false);
				PurchasePanel.setVisible(true);
			}
		});
		btnNewButton.setBounds(6, 0, 42, 40);
		MoneyPanel.add(btnNewButton);
		
		CardPanel = new JPanel();
		CardPanel.setBackground(new Color(193, 224, 219));
		CardPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		frmUserGui.getContentPane().add(CardPanel, "name_445562712899041");
		CardPanel.setLayout(new CardLayout(0, 0));
		CardPanel.setVisible(false);
		
		ExistingCardPanel = new JPanel();
		ExistingCardPanel.setBackground(new Color(193, 224, 219));
		CardPanel.add(ExistingCardPanel, "name_445607027429854");
		ExistingCardPanel.setLayout(null);
		ExistingCardPanel.setVisible(false);
		
		JLabel lblTotalAmount_1 = new JLabel("Total Amount");
		lblTotalAmount_1.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblTotalAmount_1.setBounds(122, 74, 117, 16);
		ExistingCardPanel.add(lblTotalAmount_1);
		
		cardAmtTF = new JTextField();
		cardAmtTF.setEditable(false);
		cardAmtTF.setBounds(272, 67, 134, 28);
		ExistingCardPanel.add(cardAmtTF);
		cardAmtTF.setColumns(10);
		
		JLabel lblEnterYourCard = new JLabel("Enter your card #");
		lblEnterYourCard.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblEnterYourCard.setBounds(92, 126, 147, 16);
		ExistingCardPanel.add(lblEnterYourCard);
		
		cardNumTF = new JTextField();
		cardNumTF.setBounds(272, 120, 134, 28);
		ExistingCardPanel.add(cardNumTF);
		cardNumTF.setColumns(10);
		
		JLabel lblBalanceOnYour = new JLabel("Balance on your card");
		lblBalanceOnYour.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblBalanceOnYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalanceOnYour.setBounds(197, 180, 170, 16);
		ExistingCardPanel.add(lblBalanceOnYour);
		
		cardBalTF = new JTextField();
		cardBalTF.setEditable(false);
		cardBalTF.setBounds(222, 208, 134, 28);
		ExistingCardPanel.add(cardBalTF);
		cardBalTF.setColumns(10);
		
		cardNumTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cardId = Integer.parseInt(cardNumTF.getText());
				SmartCalCard card = null;
				try {
					card = Database.fetchCard(cardId);
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				double amtOnCard = card.getBalance();
				Payment payment = new CardPayment(total, amtOnCard, new CardImpl());
				double change = payment.getChange();
				cardBalTF.setText(" ");
				String t = String.format( "%.2f", change);
				cardBalTF.setText(t);
			}
		});
		
		JButton btnPay_1 = new JButton("Pay");
		btnPay_1.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnPay_1.setBackground(Color.WHITE);
		btnPay_1.setBorderPainted(false);
		btnPay_1.setOpaque(true);
		btnPay_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cardId = Integer.parseInt(cardNumTF.getText());
				SmartCalCard card = null;
				try {
					card = Database.fetchCard(cardId);
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				double amtOnCard = card.getBalance();
				Payment payment = new CardPayment(total, amtOnCard, new CardImpl());
				double change = payment.getChange();
				cardBalTF.setText(Double.toString(change));
				if(change < 0){
					JOptionPane.showMessageDialog(frmUserGui, "Not enough balance on card");
				} else {
					JOptionPane.showMessageDialog(frmUserGui, "Please take your item.");
					card.setBalance(total);
					try {
						Database.updateCardInfo(cardId, card);
					} catch (Exception e1) {
						e1.printStackTrace();
					} 
					//Update the count of the item
					String actionCmd = group.getSelection().getActionCommand();
					String item = actionCmd.substring(0, actionCmd.indexOf(" "));
					if(machine.getA1Item().equals(item)){
						machine.setA1Count(machine.getA1Count() - 1);
					} else if(machine.getA2Item().equals(item)){
						machine.setA2Count(machine.getA2Count() - 1);
					} else if(machine.getA3Item().equals(item)){
						machine.setA3Count(machine.getA3Count() - 1);
					} 
					try {
						Database.updateMachineInfo(2, machine);
					} catch (Exception e1) {
						e1.printStackTrace();
					} 
					//Update the total cost of that machine
					try {
						Database.updateCostOfMachine(2, total);
						Database.updateCountOfItems(item);
					} catch (Exception e1) {
						e1.printStackTrace();
					} 
					CardPanel.setVisible(false);
					ExistingCardPanel.setVisible(false);
					clearMachinePanel();
					VendingMachinePanel.setVisible(true);
				}
			}
		});
		btnPay_1.setBounds(122, 260, 117, 29);
		ExistingCardPanel.add(btnPay_1);
		
		JButton btnBuyNewCard = new JButton("Buy New Card");
		btnBuyNewCard.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnBuyNewCard.setBackground(Color.WHITE);
		btnBuyNewCard.setBorderPainted(false);
		btnBuyNewCard.setOpaque(true);
		btnBuyNewCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExistingCardPanel.setVisible(false);
				NewCardPanel.setVisible(true);
			}
		});
		btnBuyNewCard.setBounds(308, 260, 147, 29);
		ExistingCardPanel.add(btnBuyNewCard);
		
		JButton btnBack_2 = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack_2.setIcon(new ImageIcon(img));
		btnBack_2.setBorderPainted(false); 
		btnBack_2.setContentAreaFilled(false); 
		btnBack_2.setFocusPainted(false); 
		btnBack_2.setOpaque(false);
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExistingCardPanel.setVisible(false);
				PurchasePanel.setVisible(true);
			}
		});
		btnBack_2.setBounds(16, 6, 30, 28);
		ExistingCardPanel.add(btnBack_2);
		
		NewCardPanel = new JPanel();
		NewCardPanel.setBackground(new Color(193, 224, 219));
		CardPanel.add(NewCardPanel, "name_445626786542870");
		NewCardPanel.setLayout(null);
		NewCardPanel.setVisible(false);
		
		JLabel lblBuySmartcalCard = new JLabel("Buy SmartCal Card");
		lblBuySmartcalCard.setFont(new Font("Bradley Hand", Font.BOLD, 24));
		lblBuySmartcalCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuySmartcalCard.setBounds(172, 6, 253, 33);
		NewCardPanel.add(lblBuySmartcalCard);
		
		JLabel lblSelectTheValue = new JLabel("Select the value of card you want to purchase");
		lblSelectTheValue.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblSelectTheValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectTheValue.setBounds(110, 82, 362, 29);
		NewCardPanel.add(lblSelectTheValue);
		
		JButton button = new JButton("$10");
		button.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		button.setBackground(Color.WHITE);
		button.setBorderPainted(false);
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardAmt = 10;
				NewCardPanel.setVisible(false);
				totalTF.setText("10");
				PaymentPanel.setVisible(true);
			}
		});
		button.setBounds(87, 163, 117, 29);
		NewCardPanel.add(button);
		
		JButton button_1 = new JButton("$20");
		button_1.setBackground(Color.WHITE);
		button_1.setBorderPainted(false);
		button_1.setOpaque(true);
		button_1.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardAmt = 20;
				NewCardPanel.setVisible(false);
				totalTF.setText("20");
				PaymentPanel.setVisible(true);
			}
		});
		button_1.setBounds(237, 163, 117, 29);
		NewCardPanel.add(button_1);
		
		JButton button_2 = new JButton("$50");
		button_2.setBackground(Color.WHITE);
		button_2.setBorderPainted(false);
		button_2.setOpaque(true);
		button_2.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardAmt = 50;
				NewCardPanel.setVisible(false);
				totalTF.setText("50");
				PaymentPanel.setVisible(true);
			}
		});
		button_2.setBounds(380, 163, 117, 29);
		NewCardPanel.add(button_2);
		
		JButton btnBack_1 = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack_1.setIcon(new ImageIcon(img));
		btnBack_1.setBorderPainted(false); 
		btnBack_1.setContentAreaFilled(false); 
		btnBack_1.setFocusPainted(false); 
		btnBack_1.setOpaque(false);
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCardPanel.setVisible(false);
				ExistingCardPanel.setVisible(true);
			}
		});
		btnBack_1.setBounds(6, 6, 40, 29);
		NewCardPanel.add(btnBack_1);
		
		PaymentPanel = new JPanel();
		PaymentPanel.setBackground(new Color(193, 224, 219));
		CardPanel.add(PaymentPanel, "name_109866056890715");
		PaymentPanel.setLayout(null);
		PaymentPanel.setVisible(false);
		
		JLabel lblBuyNewCard = new JLabel("Buy New Card");
		lblBuyNewCard.setFont(new Font("Bradley Hand", Font.BOLD, 24));
		lblBuyNewCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuyNewCard.setBounds(86, 6, 326, 39);
		PaymentPanel.add(lblBuyNewCard);
		
		JLabel lblTotalAmount_2 = new JLabel("Total Amount");
		lblTotalAmount_2.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblTotalAmount_2.setBounds(97, 79, 117, 16);
		PaymentPanel.add(lblTotalAmount_2);
		
		totalTF = new JTextField();
		totalTF.setEditable(false);
		totalTF.setBounds(247, 72, 134, 28);
		PaymentPanel.add(totalTF);
		totalTF.setColumns(10);
		
		JLabel lblAmountInserted_1 = new JLabel("Amount Inserted");
		lblAmountInserted_1.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblAmountInserted_1.setBounds(86, 126, 149, 16);
		PaymentPanel.add(lblAmountInserted_1);
		
		amtTF = new JTextField();
		amtTF.setBounds(247, 120, 134, 28);
		PaymentPanel.add(amtTF);
		amtTF.setColumns(10);
		amtTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Text=" + AmtInsertedTF.getText());
				double amtInserted = Double.parseDouble(amtTF.getText());
				Payment payment = new MoneyPayment(cardAmt, amtInserted, new MoneyImpl());
				double change = payment.getChange();
				balanceTF.setText(Double.toString(change));
			}
		});
		
		JLabel lblChange_1 = new JLabel("Change");
		lblChange_1.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblChange_1.setBounds(153, 177, 61, 16);
		PaymentPanel.add(lblChange_1);
		
		balanceTF = new JTextField();
		balanceTF.setEditable(false);
		balanceTF.setBounds(247, 170, 134, 28);
		PaymentPanel.add(balanceTF);
		balanceTF.setColumns(10);
		
		JButton btnPay_2 = new JButton("Pay");
		btnPay_2.setBackground(Color.WHITE);
		btnPay_2.setBorderPainted(false);
		btnPay_2.setOpaque(true);
		btnPay_2.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnPay_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SmartCalCard card = null;
				try {
					if(cardAmt == 10) {
						card = new SmartCalCard10(Database.getCardId());
					} else if(cardAmt == 20) {
						card = new SmartCalCard20(Database.getCardId());
					} else if(cardAmt == 50) {
						card = new SmartCalCard50(Database.getCardId());
					} 
					double amtInserted = Double.parseDouble(amtTF.getText());
					Payment payment = new MoneyPayment(cardAmt, amtInserted, new MoneyImpl());
					double change = payment.getChange();
					ChangeTF.setText(Double.toString(change));
					if(change < 0){
						JOptionPane.showMessageDialog(frmUserGui, "Amount inserted not sufficient to purchase the card");
					} else {
						Database.addCard(card);
						Database.setCardId();
						JOptionPane.showMessageDialog(frmUserGui, "Please use the following number to purchase items " + card.getCardId());
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				PaymentPanel.setVisible(false);
				ExistingCardPanel.setVisible(true);
			}
		});
		btnPay_2.setBounds(199, 235, 117, 29);
		PaymentPanel.add(btnPay_2);
		
		JButton btnBack_3 = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack_3.setIcon(new ImageIcon(img));
		btnBack_3.setBorderPainted(false); 
		btnBack_3.setContentAreaFilled(false); 
		btnBack_3.setFocusPainted(false); 
		btnBack_3.setOpaque(false);
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack_3.setBounds(6, 6, 40, 29);
		PaymentPanel.add(btnBack_3);
		
		SuggestionsPanel = new JPanel();
		SuggestionsPanel.setBackground(new Color(193, 224, 219));
		SuggestionsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		frmUserGui.getContentPane().add(SuggestionsPanel, "name_446038145764003");
		SuggestionsPanel.setLayout(null);
		
		JLabel lblNutrionalInfo = new JLabel("Nutritional Info");
		lblNutrionalInfo.setFont(new Font("Bradley Hand", Font.BOLD, 24));
		lblNutrionalInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNutrionalInfo.setBounds(172, 16, 243, 34);
		SuggestionsPanel.add(lblNutrionalInfo);
		
		JButton btnGetInfoFor = new JButton("Get Info for all Items");
		btnGetInfoFor.setFont(new Font("Bradley Hand", Font.PLAIN, 16));
		btnGetInfoFor.setBackground(Color.WHITE);
		btnGetInfoFor.setBorderPainted(false);
		btnGetInfoFor.setOpaque(true);
		btnGetInfoFor.setBounds(79, 143, 194, 29);
		SuggestionsPanel.add(btnGetInfoFor);
		
		JButton btnQueryBasedOn = new JButton("Query based on info");
		btnQueryBasedOn.setFont(new Font("Bradley Hand", Font.PLAIN, 16));
		btnQueryBasedOn.setBackground(Color.WHITE);
		btnQueryBasedOn.setBorderPainted(false);
		btnQueryBasedOn.setOpaque(true);
		btnQueryBasedOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuggestionsPanel.setVisible(false);
				QueryPanel.setVisible(true);
			}
		});
		btnQueryBasedOn.setBounds(285, 143, 202, 29);
		SuggestionsPanel.add(btnQueryBasedOn);
		
		JButton btnNewButton_1 = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img));
		btnNewButton_1.setBorderPainted(false); 
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton_1.setFocusPainted(false); 
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuggestionsPanel.setVisible(false);
				VendingMachinePanel.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(6, 6, 37, 29);
		SuggestionsPanel.add(btnNewButton_1);
		
		AllItemsInfoPanel = new JPanel();
		AllItemsInfoPanel.setBackground(new Color(193, 224, 219));
		AllItemsInfoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		frmUserGui.getContentPane().add(AllItemsInfoPanel, "name_185099892541024");
		AllItemsInfoPanel.setLayout(null);
		AllItemsInfoPanel.setVisible(false);
		
		JLabel lblAllItems = new JLabel("All Items");
		lblAllItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllItems.setFont(new Font("Bradley Hand", Font.BOLD, 24));
		lblAllItems.setBounds(231, 6, 129, 32);
		AllItemsInfoPanel.add(lblAllItems);
		
		final JLabel item1Label = new JLabel("New label");
		item1Label.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		item1Label.setBounds(95, 116, 79, 16);
		AllItemsInfoPanel.add(item1Label);
		
		final JLabel item2Label = new JLabel("New label");
		item2Label.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		item2Label.setBounds(95, 167, 79, 16);
		AllItemsInfoPanel.add(item2Label);
		
		final JLabel item3Label = new JLabel("New label");
		item3Label.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		item3Label.setBounds(95, 218, 79, 16);
		AllItemsInfoPanel.add(item3Label);
		
		item1CalTF = new JTextField();
		item1CalTF.setEditable(false);
		item1CalTF.setBounds(186, 110, 134, 28);
		AllItemsInfoPanel.add(item1CalTF);
		item1CalTF.setColumns(10);
		
		JLabel lblCalories = new JLabel("Calories");
		lblCalories.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblCalories.setBounds(219, 82, 73, 16);
		AllItemsInfoPanel.add(lblCalories);
		
		JLabel lblSugar = new JLabel("Sugar");
		lblSugar.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblSugar.setBounds(358, 82, 61, 16);
		AllItemsInfoPanel.add(lblSugar);
		
		item1SugarTF = new JTextField();
		item1SugarTF.setEditable(false);
		item1SugarTF.setBounds(326, 110, 134, 28);
		AllItemsInfoPanel.add(item1SugarTF);
		item1SugarTF.setColumns(10);
		
		item2CalTF = new JTextField();
		item2CalTF.setEditable(false);
		item2CalTF.setBounds(186, 161, 134, 28);
		AllItemsInfoPanel.add(item2CalTF);
		item2CalTF.setColumns(10);
		
		item2SugarTF = new JTextField();
		item2SugarTF.setEditable(false);
		item2SugarTF.setBounds(326, 161, 134, 28);
		AllItemsInfoPanel.add(item2SugarTF);
		item2SugarTF.setColumns(10);
		
		item3CalTF = new JTextField();
		item3CalTF.setEditable(false);
		item3CalTF.setBounds(186, 212, 134, 28);
		AllItemsInfoPanel.add(item3CalTF);
		item3CalTF.setColumns(10);
		
		item3SugarTF = new JTextField();
		item3SugarTF.setEditable(false);
		item3SugarTF.setBounds(326, 212, 134, 28);
		AllItemsInfoPanel.add(item3SugarTF);
		item3SugarTF.setColumns(10);
		
		JButton btnBack_4 = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack_4.setIcon(new ImageIcon(img));
		btnBack_4.setBorderPainted(false); 
		btnBack_4.setContentAreaFilled(false); 
		btnBack_4.setFocusPainted(false); 
		btnBack.setOpaque(false);
		btnBack_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllItemsInfoPanel.setVisible(false);
				VendingMachinePanel.setVisible(true);
			}
		});
		btnBack_4.setBounds(6, 6, 40, 29);
		AllItemsInfoPanel.add(btnBack_4);
		
		QueryPanel = new JPanel();
		QueryPanel.setBackground(new Color(193, 224, 219));
		QueryPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		frmUserGui.getContentPane().add(QueryPanel, "name_186176932050078");
		QueryPanel.setLayout(null);
		
		JLabel lblSuggestions = new JLabel("Suggestions");
		lblSuggestions.setFont(new Font("Bradley Hand", Font.BOLD, 24));
		lblSuggestions.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuggestions.setBounds(206, 6, 213, 37);
		QueryPanel.add(lblSuggestions);
		
		JButton btnSearch = new JButton("Query");
		btnSearch.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBorderPainted(false);
		btnSearch.setOpaque(true);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryPanel.setVisible(false);
				itemsPanel.removeAll();
				int calories = 0, sugar = 0;
				int y = 75;
				List<ItemsForSale> queryList = new ArrayList<ItemsForSale>();
				String action = infoGroup.getSelection().getActionCommand();
				try {
					queryItems = Database.getItemsFromList();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				if(action.equals("Calories < 200")) {
					calories = 200;
					for(ItemsForSale item : queryItems) {
						if(item.getCalories() < calories){
							queryList.add(item);
						}
					}
				} else if(action.equals("Calories < 500")) {
					calories = 500;
					for(ItemsForSale item : queryItems) {
						if(item.getCalories() < calories){
							queryList.add(item);
						}
					}
				} else if(action.equals("Low Sugar")) {
					sugar = 50;
					for(ItemsForSale item : queryItems) {
						if(item.getSugarLevels() < sugar){
							queryList.add(item);
						}
					}
				}
				for(ItemsForSale item : queryList){
					JLabel label = new JLabel();
					JLabel breaklb = new JLabel();
					if(item.getItemName().equals(machine.getA1Item()) || item.getItemName().equals(machine.getA2Item())
							|| item.getItemName().equals(machine.getA3Item())) {
						label.setText(item.getItemName());
						breaklb.setText("<html><br><br></html>");
						label.setVisible(true);
						breaklb.setVisible(true);
						label.setBounds(203, y, 90, 16);
						y += 25;
						breaklb.setBounds(203, y, 90, 16);
						y += 25;
						itemsPanel.add(label);
						itemsPanel.add(breaklb);
						SearchPanel.validate();
						SearchPanel.repaint();
					}
				}
				SearchPanel.setVisible(true);
			}
		});
		btnSearch.setBounds(231, 245, 117, 29);
		QueryPanel.add(btnSearch);
		
		JButton btnBack_5 = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack_5.setIcon(new ImageIcon(img));
		btnBack_5.setBorderPainted(false); 
		btnBack_5.setContentAreaFilled(false); 
		btnBack_5.setFocusPainted(false); 
		btnBack_5.setOpaque(false);
		btnBack_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryPanel.setVisible(false);
				VendingMachinePanel.setVisible(true);
			}
		});
		btnBack_5.setBounds(6, 6, 40, 29);
		QueryPanel.add(btnBack_5);
		
		JRadioButton rdbtnCalories = new JRadioButton("Calories < 200");
		rdbtnCalories.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		rdbtnCalories.setBounds(46, 150, 156, 23);
		QueryPanel.add(rdbtnCalories);
		rdbtnCalories.setActionCommand("Calories < 200");
		infoGroup.add(rdbtnCalories);
		
		JRadioButton rdbtnCalories_1 = new JRadioButton("Calories < 500");
		rdbtnCalories_1.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		rdbtnCalories_1.setBounds(214, 150, 156, 23);
		QueryPanel.add(rdbtnCalories_1);
		rdbtnCalories_1.setActionCommand("Calories < 500");
		infoGroup.add(rdbtnCalories_1);
		
		JRadioButton rdbtnLowSugar = new JRadioButton("Low Sugar");
		rdbtnLowSugar.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		rdbtnLowSugar.setBounds(382, 150, 141, 23);
		QueryPanel.add(rdbtnLowSugar);
		rdbtnLowSugar.setActionCommand("Low Sugar");
		infoGroup.add(rdbtnLowSugar);
		
		SearchPanel = new JPanel();
		SearchPanel.setBackground(new Color(193, 224, 219));
		SearchPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		frmUserGui.getContentPane().add(SearchPanel, "name_188944247497743");
		SearchPanel.setLayout(null);
		SearchPanel.setVisible(false);
		
		JLabel lblItemsBasedOn = new JLabel("Items based on your query");
		lblItemsBasedOn.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemsBasedOn.setFont(new Font("Bradley Hand", Font.PLAIN, 18));
		lblItemsBasedOn.setBounds(194, 6, 218, 30);
		SearchPanel.add(lblItemsBasedOn);
		
		JButton btnBack_6 = new JButton("");
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack_6.setIcon(new ImageIcon(img));
		btnBack_6.setBorderPainted(false); 
		btnBack_6.setContentAreaFilled(false); 
		btnBack_6.setFocusPainted(false); 
		btnBack_6.setOpaque(false);
		btnBack_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPanel.setVisible(false);
				VendingMachinePanel.setVisible(true);
			}
		});
		btnBack_6.setBounds(6, 6, 34, 29);
		SearchPanel.add(btnBack_6);
		
		itemsPanel = new JPanel();
		itemsPanel.setBackground(new Color(193, 224, 219));
		itemsPanel.setBounds(259, 72, 76, 152);
		SearchPanel.add(itemsPanel);
		SuggestionsPanel.setVisible(false);
		QueryPanel.setVisible(false);
		
		btnGetInfoFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuggestionsPanel.setVisible(false);
				item1Label.setText(machine.getA1Item());
				item2Label.setText(machine.getA2Item());
				item3Label.setText(machine.getA3Item());
				try {
					item1CalTF.setText(Integer.toString(getItemFromDB(machine.getA1Item()).getCalories()));
					item2CalTF.setText(Integer.toString(getItemFromDB(machine.getA2Item()).getCalories()));
					item3CalTF.setText(Integer.toString(getItemFromDB(machine.getA3Item()).getCalories()));
					item1SugarTF.setText(Integer.toString(getItemFromDB(machine.getA1Item()).getSugarLevels()));
					item2SugarTF.setText(Integer.toString(getItemFromDB(machine.getA2Item()).getSugarLevels()));
					item3SugarTF.setText(Integer.toString(getItemFromDB(machine.getA3Item()).getSugarLevels()));
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				AllItemsInfoPanel.setVisible(true);
			}
		});
	}

	private static void revalidateScreen() throws IOException, ClassNotFoundException {
		panel.removeAll();
		try {
			machine = Database.retrieveMachine(2);
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		ActionListener sliceActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton aButton = (AbstractButton) actionEvent.getSource();
				updateTotalCost();
			}
		};
		buttons=new JRadioButton[3];
		ItemsForSale item = getItemFromDB(machine.getA1Item());
		final JRadioButton btn1 = new JRadioButton(item.getItemName() + " " + String.format( "%.2f",item.getCost()));
		btn1.setFont(new Font("Bradley Hand", Font.PLAIN, 20));
		btn1.setActionCommand(item.getItemName() + " " + String.format( "%.2f",item.getCost()));
		buttons[0]=btn1;
		panel.add(btn1);
		group.add(btn1);
		btn1.addActionListener(sliceActionListener);
		JButton btnItem = new JButton("");
		Image img = item.getImage();
		btnItem.setIcon(new ImageIcon(img));
		btnItem.setBorderPainted(false); 
		btnItem.setContentAreaFilled(false); 
		btnItem.setFocusPainted(false); 
		btnItem.setOpaque(false);
		panel.add(btnItem);
		
		item = getItemFromDB(machine.getA2Item());
		
		final JRadioButton btn2 = new JRadioButton(item.getItemName() + " " + String.format( "%.2f",item.getCost()));
		btn2.setFont(new Font("Bradley Hand", Font.PLAIN, 20));
		btn2.setActionCommand(item.getItemName() + " " + String.format( "%.2f",item.getCost()));
		buttons[1]=btn2;
		panel.add(btn2);
		group.add(btn2);
		btn2.addActionListener(sliceActionListener);
		JButton btnItem2 = new JButton("");
		img = item.getImage();
		btnItem2.setIcon(new ImageIcon(img));
		btnItem2.setBorderPainted(false); 
		btnItem2.setContentAreaFilled(false); 
		btnItem2.setFocusPainted(false); 
		btnItem2.setOpaque(false);
		panel.add(btnItem2);
		
		item = getItemFromDB(machine.getA3Item());
		final JRadioButton btn3 = new JRadioButton(item.getItemName() + " " + String.format( "%.2f",item.getCost()));
		btn3.setFont(new Font("Bradley Hand", Font.PLAIN, 20));
		btn3.setActionCommand(item.getItemName() + " " + String.format( "%.2f",item.getCost()));
		buttons[2]=btn3;
		panel.add(btn3);
		group.add(btn3);
		btn3.addActionListener(sliceActionListener);
		JButton btnItem3 = new JButton("");
		img = item.getImage();
		btnItem3.setIcon(new ImageIcon(img));
		btnItem3.setBorderPainted(false); 
		btnItem3.setContentAreaFilled(false); 
		btnItem3.setFocusPainted(false); 
		btnItem3.setOpaque(false);
		panel.add(btnItem3);
	}
	
	private static ItemsForSale getItemFromDB(String itemName) throws IOException, ClassNotFoundException{
		List<ItemsForSale> allItems = Database.getItemsFromList();
		for(ItemsForSale eachItem : allItems){
			if(eachItem.getItemName().equals(itemName)){
				return eachItem;
			}
		}
		return null;
	}
	
	private static void updateTotalCost() {
		String item = group.getSelection().getActionCommand();
		String costString = item.substring(item.indexOf(" ") + 1, item.length());
		total = Double.parseDouble(costString);
		String t = String.format( "%.2f", total);
		TotalTF.setText(t); 
	}
	
	private void clearMachinePanel(){
		TotalTF.setText("");
		group.clearSelection();
		clearFields();
	}
	
	private void clearFields(){
		TotalAmtTF.setText("");
		AmtInsertedTF.setText("");
		ChangeTF.setText("");
		cardAmtTF.setText("");
		cardBalTF.setText("");
		cardNumTF.setText("");
	}
}

	
