package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import implement.Calculation;
 

 
public class FinancialGoal extends JFrame implements ChangeListener {

	// -------------------------------- INSTANTIAT COMPONENTS--------------------------------

	String principal = "";
	String contributions = "";
	String goal = "";
	String dividend = "";

	int compoundedFrequnecy = 0;// used for the compounded frequency

	DecimalFormat df = new DecimalFormat("0.00");// Format to display the rate of return

	Calculation c;// object for

	// instantiate panels.
	JPanel centerPanel = new JPanel();
	JPanel southPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel spacer1 = new JPanel();
	JPanel logoPanel = new JPanel();


	// Default amounts to be used at start of program
	private double principalAmount = 1;
	private double goalAmount = 1;
	private double contributionsAmount = 0;
	private double dividendsAmount = 0;
	private double taxAmount = 0;

	// Instantiate JLabels
	JLabel principalLabel = new JLabel("PRINCIPAL");
	JLabel contributionsLabel = new JLabel("CONTRIBUTIONS");
	JLabel goalLabel = new JLabel("GOAL");
	JLabel taxableIncomeLabel = new JLabel("TAX RATE");
	JLabel reinvestLabel = new JLabel("Reinvest Dividends?");
	JLabel dividendAmmountLabel = new JLabel("QUARTERLY DIVIDEND AMMOUNT");
	JLabel compoundFrequencyLabel = new JLabel("COMPOUND FREQUENCY");
	JLabel calculatedGoalLabel = new JLabel();
	JLabel toMakeLabel = new JLabel();
	JLabel dailyTargetLabel = new JLabel();
	JLabel weeklyTargetLabel = new JLabel();
	JLabel monthlyTargetLabel = new JLabel();
	JLabel annualTargetLabel = new JLabel();
	JLabel sliderBeginLabel = new JLabel();
	JLabel logoLabel = new JLabel();
	JLabel principalDollarSign = new JLabel("$");
	JLabel contributionsDollarSign = new JLabel("$");
	JLabel goalDollarSign = new JLabel("$");
	JLabel dividendsDollarSign = new JLabel("$");
	JLabel taxPercentageSign = new JLabel("%");

	// instantiate JTextFields
	JFormattedTextField principalField = new JFormattedTextField();
	JFormattedTextField contributionsField = new JFormattedTextField();
	JFormattedTextField goalField = new JFormattedTextField();
	JFormattedTextField taxField = new JFormattedTextField();
	JFormattedTextField dividends = new JFormattedTextField();

	// instantiate JRadioButton
	JRadioButton dailyContributions = new JRadioButton("DAILY");
	JRadioButton weeklyContributions = new JRadioButton("WEEKLY");
	JRadioButton monthlyContributions = new JRadioButton("MONTHLY");
	JRadioButton annualContributions = new JRadioButton("ANNUAL");
	JRadioButton dailyCompound = new JRadioButton("DAILY");
	JRadioButton weeklyCompound = new JRadioButton("WEEKLY");
	JRadioButton monthlyCompound = new JRadioButton("MONTHLY");
	JRadioButton annualCompound = new JRadioButton("ANNUAL");

	// instantiate JCheckBox
	JCheckBox reinvestDividendsY = new JCheckBox("Yes");
	JCheckBox reinvestDividendsN = new JCheckBox("No");

	// instantiate JSlider
	static JSlider slider;

	// Button groups for the radio button
	ButtonGroup contributionsButtongroup = new ButtonGroup();
	ButtonGroup taxiableIncomeButtongroup = new ButtonGroup();
	ButtonGroup reinvestDividendButtongroup = new ButtonGroup();
	ButtonGroup compoundFrequencyButtongroup = new ButtonGroup();

	// -------------------------------- SET SIZES--------------------------------

	// set sizes for components.
	Dimension PrincipalSize = principalLabel.getPreferredSize();
	Dimension contributionSize = contributionsLabel.getPreferredSize();
	Dimension goalSize = goalLabel.getPreferredSize();
	Dimension taxableIncomeSize = taxableIncomeLabel.getPreferredSize();
	Dimension compoundFrequencyLabelSize = compoundFrequencyLabel.getPreferredSize();
	Dimension dailyContributionsSize = dailyContributions.getPreferredSize();
	Dimension weeklyContributionsSize = weeklyContributions.getPreferredSize();
	Dimension monthlyContributionsSize = monthlyContributions.getPreferredSize();
	Dimension annualContributionsSize = annualContributions.getPreferredSize();
	Dimension dailyCompoundSize = dailyCompound.getPreferredSize();
	Dimension weeklyCompoundSize = weeklyCompound.getPreferredSize();
	Dimension monthlyCompoundSize = monthlyCompound.getPreferredSize();
	Dimension annualCompoundSize = annualCompound.getPreferredSize();
	Dimension reinvestDividendsYSize = reinvestDividendsY.getPreferredSize();
	Dimension reinvestDividendsNSize = reinvestDividendsN.getPreferredSize();
	Dimension reinvestLabelSize = reinvestLabel.getPreferredSize();
	Dimension toMakeLabelSize = toMakeLabel.getPreferredSize();
	Dimension calculatedGoalLabelSize = calculatedGoalLabel.getPreferredSize();

	// A constructor to modify Frame and add components in constructor

	FinancialGoal() {  
		 
		// set layout managers for panels

		centerPanel.setLayout(null);
		southPanel.setLayout(new FlowLayout());
		rightPanel.setLayout(new GridLayout(10, 0));

		// colors for modifying layout
//        centerPanel.setBackground(Color.yellow);
//        southPanel.setBackground(Color.red);
//        rightPanel.setBackground(Color.SILVER);

		// set frame layout
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setSize(850, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setResizable(true);
		this.setLocationRelativeTo(null);

		this.setVisible(true);
		this.setTitle("Financial Goals Application");

		// set default slider.
		slider = new JSlider(1, 40, 20);
		slider.setPreferredSize(new Dimension(500, 80));
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(5);
		slider.setPaintLabels(true);

		// set default values for text fields
		principalField.setValue(new Double(principalAmount));
		contributionsField.setValue(new Double(contributionsAmount));
		goalField.setValue(new Double(goalAmount));
		dividends.setValue(new Double(dividendsAmount));
		taxField.setValue(new Double(taxAmount));

		// ---------------- remove focus from buttons and
		// check-boxes.--------------------------

		annualCompound.setFocusable(false);
		dailyContributions.setFocusable(false);
		weeklyContributions.setFocusable(false);
		monthlyContributions.setFocusable(false);
		annualContributions.setFocusable(false);
		dailyCompound.setFocusable(false);
		weeklyCompound.setFocusable(false);
		monthlyCompound.setFocusable(false);
		annualCompound.setFocusable(false);
		reinvestDividendsY.setFocusable(false);
		reinvestDividendsN.setFocusable(false);

		// -------------------------------- SET BOUNDS--------------------------------

		// set bounds for JTextFields.
		principalField.setBounds(25, 20, 100, 30);
		contributionsField.setBounds(25, 70, 100, 30);
		goalField.setBounds(25, 120, 100, 30);
		taxField.setBounds(25, 170, 100, 30);
		dividends.setBounds(25, 220, 100, 30);

		// set bounds for JRadioButtons.
		dailyContributions.setBounds(130, 80, dailyContributionsSize.width, dailyContributionsSize.height);
		weeklyContributions.setBounds(190, 80, weeklyContributionsSize.width, weeklyContributionsSize.height);
		monthlyContributions.setBounds(265, 80, monthlyContributionsSize.width, monthlyContributionsSize.height);
		annualContributions.setBounds(350, 80, annualContributionsSize.width, annualContributionsSize.height);
		contributionsButtongroup.add(dailyContributions);
		contributionsButtongroup.add(weeklyContributions);
		contributionsButtongroup.add(monthlyContributions);
		contributionsButtongroup.add(annualContributions);

		// set the default selections
		annualContributions.setSelected(true);
		annualCompound.setSelected(true);
		reinvestDividendsN.setSelected(true);
		dividends.setEnabled(false);

		dailyCompound.setBounds(130, 280, dailyCompoundSize.width, dailyCompoundSize.height);
		weeklyCompound.setBounds(190, 280, weeklyCompoundSize.width, weeklyCompoundSize.height);
		monthlyCompound.setBounds(265, 280, monthlyCompoundSize.width, monthlyCompoundSize.height);
		annualCompound.setBounds(350, 280, annualCompoundSize.width, annualCompoundSize.height);
		compoundFrequencyButtongroup.add(dailyCompound);
		compoundFrequencyButtongroup.add(weeklyCompound);
		compoundFrequencyButtongroup.add(monthlyCompound);
		compoundFrequencyButtongroup.add(annualCompound);

		// set bounds for Labels.
		principalLabel.setBounds(130, 25, 120, PrincipalSize.height);
		contributionsLabel.setBounds(130, 65, 200, contributionSize.height);
		goalLabel.setBounds(130, 125, contributionSize.width, contributionSize.height);
		taxableIncomeLabel.setBounds(130, 175, taxableIncomeSize.width, taxableIncomeSize.height);
		reinvestLabel.setBounds(130, 234, 140, reinvestLabelSize.height);
		dividendAmmountLabel.setBounds(130, 215, 213, reinvestLabelSize.height);
		compoundFrequencyLabel.setBounds(130, 255, 200, compoundFrequencyLabelSize.height);
		toMakeLabel.setBounds(0, 0, toMakeLabelSize.width, toMakeLabelSize.height);
		// compoundFrequencyLabel.setBounds(130, 265, 150,
		// compoundFrequencyLabelSize.height);

		// set bounds for JCheckBox and add button group for checkboxes
		reinvestDividendsY.setBounds(248, 230, reinvestDividendsYSize.width, reinvestDividendsYSize.height);
		reinvestDividendsN.setBounds(295, 230, reinvestDividendsNSize.width, reinvestDividendsNSize.height);
		reinvestDividendButtongroup.add(reinvestDividendsY);
		reinvestDividendButtongroup.add(reinvestDividendsN);

		// -------------------------------- SLIDER --------------------------------

		// add slider to south panel
		southPanel.add(slider);
		southPanel.add(sliderBeginLabel);
		sliderBeginLabel.setFont(new Font("Cabrili", Font.PLAIN, 25));

		// -------------------------------- ADD COMPONENTS--------------------------------
		// add Panels
		this.add(logoPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(rightPanel, BorderLayout.EAST);
		rightPanel.setPreferredSize(new Dimension(400, 400));

		ImageIcon logo = new ImageIcon("src/image/logo.png"); // logo icon

		logoLabel = new JLabel(logo); // JLabel for the icon

		// add labels.

		logoPanel.add(logoLabel);
		centerPanel.add(principalLabel);
		centerPanel.add(contributionsLabel);
		centerPanel.add(goalLabel);
		centerPanel.add(taxableIncomeLabel);
		centerPanel.add(reinvestLabel);
		centerPanel.add(dividendAmmountLabel);
		centerPanel.add(compoundFrequencyLabel);
		principalDollarSign.setBounds(12, 10, 50, 50);
		centerPanel.add(principalDollarSign);
		contributionsDollarSign.setBounds(12, 58, 50, 50);
		centerPanel.add(contributionsDollarSign);
		goalDollarSign.setBounds(12, 108, 50, 50);
		centerPanel.add(goalDollarSign);
		dividendsDollarSign.setBounds(12, 208, 50, 50);
		centerPanel.add(dividendsDollarSign);
		taxPercentageSign.setBounds(12, 158, 50, 50);
		centerPanel.add(taxPercentageSign);

		// add JTextFields
		centerPanel.add(principalField);
		centerPanel.add(contributionsField);
		centerPanel.add(goalField);
		centerPanel.add(taxField);
		centerPanel.add(dividends);

		// add JRadioButtons
		centerPanel.add(dailyContributions);
		centerPanel.add(weeklyContributions);
		centerPanel.add(monthlyContributions);
		centerPanel.add(annualContributions);
		centerPanel.add(dailyCompound);
		centerPanel.add(weeklyCompound);
		centerPanel.add(monthlyCompound);
		centerPanel.add(annualCompound);

		// add JCheckBoxes
		centerPanel.add(reinvestDividendsY);
		centerPanel.add(reinvestDividendsN);

		// align labels.
		toMakeLabel.setHorizontalAlignment(JLabel.CENTER);
		calculatedGoalLabel.setHorizontalAlignment(JLabel.CENTER);
		dailyTargetLabel.setHorizontalAlignment(JLabel.CENTER);
		weeklyTargetLabel.setHorizontalAlignment(JLabel.CENTER);
		monthlyTargetLabel.setHorizontalAlignment(JLabel.CENTER);
		annualTargetLabel.setHorizontalAlignment(JLabel.CENTER);

		// add labels to right panel
		rightPanel.add(spacer1);

		// modify font for labels
		toMakeLabel.setFont(new Font("Cabrili", Font.BOLD, 20));
		calculatedGoalLabel.setFont(new Font("Cabrili", Font.BOLD, 20));
		dailyTargetLabel.setFont(new Font("Cabrili", Font.PLAIN, 15));
		weeklyTargetLabel.setFont(new Font("Cabrili", Font.PLAIN, 15));
		monthlyTargetLabel.setFont(new Font("Cabrili", Font.PLAIN, 15));
		annualTargetLabel.setFont(new Font("Cabrili", Font.PLAIN, 15));
		principalLabel.setFont(new Font("Cabrili", Font.BOLD, 12));
		contributionsLabel.setFont(new Font("Cabrili", Font.BOLD, 12));
		goalLabel.setFont(new Font("Cabrili", Font.BOLD, 12));
		taxableIncomeLabel.setFont(new Font("Cabrili", Font.BOLD, 12));
		reinvestLabel.setFont(new Font("Cabrili", Font.PLAIN, 12));
		dailyContributions.setFont(new Font("Cabrili", Font.PLAIN, 11));
		weeklyContributions.setFont(new Font("Cabrili", Font.PLAIN, 11));
		monthlyContributions.setFont(new Font("Cabrili", Font.PLAIN, 11));
		annualContributions.setFont(new Font("Cabrili", Font.PLAIN, 11));
		dailyCompound.setFont(new Font("Cabrili", Font.PLAIN, 11));
		weeklyCompound.setFont(new Font("Cabrili", Font.PLAIN, 11));
		monthlyCompound.setFont(new Font("Cabrili", Font.PLAIN, 11));
		annualCompound.setFont(new Font("Cabrili", Font.PLAIN, 11));

		rightPanel.add(calculatedGoalLabel);
		rightPanel.add(toMakeLabel);
		rightPanel.add(dailyTargetLabel);
		rightPanel.add(weeklyTargetLabel);
		rightPanel.add(monthlyTargetLabel);
		rightPanel.add(annualTargetLabel);

		JPanel calculateButtonPanel = new JPanel();//
		calculateButtonPanel.setPreferredSize(new Dimension(200, 25));
		rightPanel.add(calculateButtonPanel);

 

		// enables the dividends JTextField if "reinvestDividendsY" check-box is selected
		reinvestDividendsY.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ie) {
				dividends.setEnabled(ie.getStateChange() == ItemEvent.SELECTED);
			}
		});

		// ActionListner for the radio buttons to detect input
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				double dailyTarget = 0;
				double weeklyTarget = 0;
				double monthlyTarget = 0;
				double annualTarget = 0;

				try {
					//if all values are correct 
					if (correctPrincipalValue()&& correctContributionsValue() &&
							 correctGoalValue() &&correctTaxValue()&&correctDividendsValue()) {

						c = new Calculation(Integer.parseInt(principal), slider.getValue(),
								Integer.parseInt(contributions), Double.parseDouble(dividend),
								Integer.parseInt(taxField.getText()));

						c.updatePrincipalValue(annualContributions.isSelected(), monthlyContributions.isSelected(),
								weeklyContributions.isSelected(), dailyContributions.isSelected(),
								reinvestDividendsY.isSelected());
						updateCompoundedFrequnecy();
						c.calculateRateOfReturn(slider.getValue(), compoundedFrequnecy, Integer.parseInt(goal));

						dailyTarget = c.getDailyRateOfReturn();
						weeklyTarget = c.getWeeklyRateOfReturn();
						monthlyTarget = c.getMonthlyRateOfReturn();
						annualTarget = c.getAnnualRateOfReturn();

						fixFont();
						dailyTargetLabel.setText("Your Daily Target is " + df.format((dailyTarget)) + "%");
						weeklyTargetLabel.setText("Your Weekly Target is " + df.format((weeklyTarget)) + "%");
						monthlyTargetLabel.setText("Your Monthly Target is " + df.format((monthlyTarget)) + "%");
						annualTargetLabel.setText("Your Annual Target is " + df.format((annualTarget)) + "%");

					}
					else {
						
						toMakeLabel.setText(""); //if the slider was used 
					}
				} catch (NumberFormatException e1) {

					toMakeLabel.setText("");
					dailyTargetLabel.setText("Error");
					dailyTargetLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
					dailyTargetLabel.setForeground(Color.red);
					weeklyTargetLabel.setText("Please make sure all the values entered are");
					monthlyTargetLabel.setText("correct before using the radiobuttons ");
					annualTargetLabel.setText("");

				}

			}

		};

		// Adding action listener to the buttons
		dailyContributions.addActionListener(listener);
		weeklyContributions.addActionListener(listener);
		monthlyContributions.addActionListener(listener);
		annualContributions.addActionListener(listener);
		dailyCompound.addActionListener(listener);
		weeklyCompound.addActionListener(listener);
		monthlyCompound.addActionListener(listener);
		annualCompound.addActionListener(listener);

		// key listener to receive key events from principal text field
		principalField.addKeyListener(new KeyAdapter() {

			// Invoked when a key has been released.
			public void keyReleased(KeyEvent e) {
				double dailyTarget = 0;
				double weeklyTarget = 0;
				double monthlyTarget = 0;
				double annualTarget = 0;

			 

					// Exception to handle incorrect user input
					try {
						// if other values aren't correct 
						if (correctContributionsValue() == false || correctGoalValue() == false || correctTaxValue() == false
								|| correctDividendsValue()== false ) {
							toMakeLabel.setText(""); //if the slider was used 
							// do nothing since the user didn't enter correct values
						} else {
						// Making sure user input is between 0 to a million in a whole dollar amount
						if (principalField.getText().matches("^[0-9]\\d*$")
								&& Integer.parseInt(principalField.getText()) < 1000000) {

							c = new Calculation(Integer.parseInt(principal), slider.getValue(),
									Integer.parseInt(contributions), Double.parseDouble(dividend),
									Integer.parseInt(taxField.getText()));

							c.updatePrincipalValue(annualContributions.isSelected(), monthlyContributions.isSelected(),
									weeklyContributions.isSelected(), dailyContributions.isSelected(),
									reinvestDividendsY.isSelected());
							updateCompoundedFrequnecy();
							c.calculateRateOfReturn(slider.getValue(), compoundedFrequnecy, Integer.parseInt(goal));

							dailyTarget = c.getDailyRateOfReturn();
							weeklyTarget = c.getWeeklyRateOfReturn();
							monthlyTarget = c.getMonthlyRateOfReturn();
							annualTarget = c.getAnnualRateOfReturn();

							fixFont();
							dailyTargetLabel.setText("Your Daily Target is " + df.format((dailyTarget)) + "%");
							weeklyTargetLabel.setText("Your Weekly Target is " + df.format((weeklyTarget)) + "%");
							monthlyTargetLabel.setText("Your Monthly Target is " + df.format((monthlyTarget)) + "%");
							annualTargetLabel.setText("Your Annual Target is " + df.format((annualTarget)) + "%");

						} else {

							throw new NumberFormatException("");
						}
						
					}

					}

					catch (NumberFormatException e1) {
						
						toMakeLabel.setText("");
						dailyTargetLabel.setText("Error");
						dailyTargetLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
						dailyTargetLabel.setForeground(Color.red);
						weeklyTargetLabel.setText("Please enter a principal amount from");
						weeklyTargetLabel.setFont(new Font("Cabrili", Font.PLAIN, 19));
						monthlyTargetLabel.setText("$0 - $1,000,000 in a whole dollar amount");
						monthlyTargetLabel.setFont(new Font("Cabrili", Font.PLAIN, 19));
						annualTargetLabel.setText("");

					}

				

			}

		});

		// key listener to receive key events from contributions text field
		contributionsField.addKeyListener(new KeyAdapter() {

			// Invoked when a key has been released.
			public void keyReleased(KeyEvent e) {
				double dailyTarget = 0;
				double weeklyTarget = 0;
				double monthlyTarget = 0;
				double annualTarget = 0;

				  
					// Exception to handle incorrect user input
					try {
						// if other values aren't correct 
						if (correctPrincipalValue() == false || correctGoalValue() == false || correctTaxValue() == false
								|| correctDividendsValue() == false) {
							
							toMakeLabel.setText(""); //if the slider was used 
							// do nothing since the user didn't enter correct values
						}else {
						// Making sure user input is between 0 to a million in a whole dollar amount
						if (contributionsField.getText().matches("^[0-9]\\d*$")
								&& Integer.parseInt(contributionsField.getText()) < 1000000) {

							c = new Calculation(Integer.parseInt(principal), slider.getValue(),
									Integer.parseInt(contributions), Double.parseDouble(dividend),
									Integer.parseInt(taxField.getText()));

							c.updatePrincipalValue(annualContributions.isSelected(), monthlyContributions.isSelected(),
									weeklyContributions.isSelected(), dailyContributions.isSelected(),
									reinvestDividendsY.isSelected());
							updateCompoundedFrequnecy();
							c.calculateRateOfReturn(slider.getValue(), compoundedFrequnecy, Integer.parseInt(goal));

							dailyTarget = c.getDailyRateOfReturn();
							weeklyTarget = c.getWeeklyRateOfReturn();
							monthlyTarget = c.getMonthlyRateOfReturn();
							annualTarget = c.getAnnualRateOfReturn();

							fixFont();
							dailyTargetLabel.setText("Your Daily Target is " + df.format((dailyTarget)) + "%");
							weeklyTargetLabel.setText("Your Weekly Target is " + df.format((weeklyTarget)) + "%");
							monthlyTargetLabel.setText("Your Monthly Target is " + df.format((monthlyTarget)) + "%");
							annualTargetLabel.setText("Your Annual Target is " + df.format((annualTarget)) + "%");

						}

						else {

							throw new NumberFormatException("");
						}
						
					}

					}

					catch (NumberFormatException e1) {
						
						toMakeLabel.setText("");
						dailyTargetLabel.setText("Error");
						dailyTargetLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
						dailyTargetLabel.setForeground(Color.red);
						weeklyTargetLabel.setText("Please enter a contribution amount");
						weeklyTargetLabel.setFont(new Font("Cabrili", Font.PLAIN, 19));
						monthlyTargetLabel.setText("$0 - $1,000,000 in a whole dollar amount");
						monthlyTargetLabel.setFont(new Font("Cabrili", Font.PLAIN, 19));
						annualTargetLabel.setText("");
					}

				
			}
		});

		// key listener to receive key events from goal text field
		goalField.addKeyListener(new KeyAdapter() {

			// Invoked when a key has been released.
			public void keyReleased(KeyEvent e) {
				double dailyTarget = 0;
				double weeklyTarget = 0;
				double monthlyTarget = 0;
				double annualTarget = 0;

				 
				 
			 
				// Exception to handle incorrect user input
				try {

					if (correctPrincipalValue() == false || correctContributionsValue() == false
							|| correctTaxValue() == false || correctDividendsValue() == false) {
						toMakeLabel.setText(""); //if the slider was used 
						// do nothing since the user didn't enter correct values
					}else {
					// Making sure user input is between 1 to a million in a whole dollar amount
					if (goalField.getText().matches("^(?!0+$)\\d+$") && Integer.parseInt(goalField.getText()) < 1000000)

					{

						c = new Calculation(Integer.parseInt(principal), slider.getValue(),
								Integer.parseInt(contributions), Double.parseDouble(dividend),
								Integer.parseInt(taxField.getText()));

						c.updatePrincipalValue(annualContributions.isSelected(), monthlyContributions.isSelected(),
								weeklyContributions.isSelected(), dailyContributions.isSelected(),
								reinvestDividendsY.isSelected());
						updateCompoundedFrequnecy();
						c.calculateRateOfReturn(slider.getValue(), compoundedFrequnecy, Integer.parseInt(goal));

						dailyTarget = c.getDailyRateOfReturn();
						weeklyTarget = c.getWeeklyRateOfReturn();
						monthlyTarget = c.getMonthlyRateOfReturn();
						annualTarget = c.getAnnualRateOfReturn();

						fixFont();
						dailyTargetLabel.setText("Your Daily Target is " + df.format((dailyTarget)) + "%");
						weeklyTargetLabel.setText("Your Weekly Target is " + df.format((weeklyTarget)) + "%");
						monthlyTargetLabel.setText("Your Monthly Target is " + df.format((monthlyTarget)) + "%");
						annualTargetLabel.setText("Your Annual Target is " + df.format((annualTarget)) + "%");

					} else {
						throw new NumberFormatException("");
					}
					
				}
				}
				

				catch (NumberFormatException e1) {
					
					toMakeLabel.setText("");
					dailyTargetLabel.setText("Error");
					dailyTargetLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
					dailyTargetLabel.setForeground(Color.red);
					weeklyTargetLabel.setText("Please enter a goal amount");
					weeklyTargetLabel.setFont(new Font("Cabrili", Font.PLAIN, 19));
					monthlyTargetLabel.setText("$1 - $1,000,000 in a whole dollar amount");
					monthlyTargetLabel.setFont(new Font("Cabrili", Font.PLAIN, 19));
					annualTargetLabel.setText("");

				}
			}
		

			
		});

		// key listener to receive key events from tax text field
		taxField.addKeyListener(new KeyAdapter() {

			// Invoked when a key has been released.
			public void keyReleased(KeyEvent e) {
				double dailyTarget = 0;
				double weeklyTarget = 0;
				double monthlyTarget = 0;
				double annualTarget = 0;

				 
			

			 

					// Exception to handle incorrect user input
					try {
						if (taxField.getText().equals("") || correctPrincipalValue() == false
								|| correctContributionsValue() == false || correctGoalValue() == false
								|| correctDividendsValue() == false) {
							toMakeLabel.setText(""); //if the slider was used 
							
							// do nothing since taxField aren't required to be entered 
							// and other values aren't correct 
						}else {
						// Making sure the tax rate entered is between 0 to 100
						if (taxField.getText().matches("^[0-9]*\\.?[0-9]+$")
								&& Integer.parseInt(taxField.getText()) < 100) {

							c = new Calculation(Double.parseDouble(principal), slider.getValue(),
									Integer.parseInt(contributions), Double.parseDouble(dividend),
									Double.parseDouble(taxField.getText()));

							c.updatePrincipalValue(annualContributions.isSelected(), monthlyContributions.isSelected(),
									weeklyContributions.isSelected(), dailyContributions.isSelected(),
									reinvestDividendsY.isSelected());
							updateCompoundedFrequnecy();
							c.calculateRateOfReturn(slider.getValue(), compoundedFrequnecy, Integer.parseInt(goal));

							dailyTarget = c.getDailyRateOfReturn();
							weeklyTarget = c.getWeeklyRateOfReturn();
							monthlyTarget = c.getMonthlyRateOfReturn();
							annualTarget = c.getAnnualRateOfReturn();
							fixFont();
							dailyTargetLabel.setText("Your Daily Target is " + df.format((dailyTarget)) + "%");
							weeklyTargetLabel.setText("Your Weekly Target is " + df.format((weeklyTarget)) + "%");
							monthlyTargetLabel.setText("Your Monthly Target is " + df.format((monthlyTarget)) + "%");
							annualTargetLabel.setText("Your Annual Target is " + df.format((annualTarget)) + "%");

						}

						else {
							throw new NumberFormatException("");
						}

						}
					}

					catch (NumberFormatException e1) {
						
						toMakeLabel.setText("");
						dailyTargetLabel.setText("Error");
						dailyTargetLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));
						dailyTargetLabel.setForeground(Color.red);
						weeklyTargetLabel.setText("Please enter a correct tax amount");
						weeklyTargetLabel.setFont(new Font("Cabrili", Font.PLAIN, 19));
						monthlyTargetLabel.setText("");
						annualTargetLabel.setText("");

					}

				}
			
		});

		// key listener to receive key events from dividends text field
		dividends.addKeyListener(new KeyAdapter() {

			// Invoked when a key has been released.
			public void keyReleased(KeyEvent e) {
				double dailyTarget = 0;
				double weeklyTarget = 0;
				double monthlyTarget = 0;
				double annualTarget = 0;

				 
			 

				 
					// Exception to handle incorrect user input

					try {
						if (dividends.getText().equals("") || correctPrincipalValue() == false
								|| correctContributionsValue() == false || correctGoalValue() == false
								|| correctTaxValue() == false) {
							toMakeLabel.setText(""); //if the slider was used 
							// do nothing since dividends aren't required to be entered 
							// and other values aren't correct 

						}else {
						 
						// Making sure the user entered a proper numeric value
						if (dividends.getText().matches("^[0-9]*\\.?[0-9]+$")) {

							c = new Calculation(Integer.parseInt(principal), slider.getValue(),
									Integer.parseInt(contributions), Double.parseDouble(dividend),
									Integer.parseInt(taxField.getText()));

							c.updatePrincipalValue(annualContributions.isSelected(), monthlyContributions.isSelected(),
									weeklyContributions.isSelected(), dailyContributions.isSelected(),
									reinvestDividendsY.isSelected());
							updateCompoundedFrequnecy();
							c.calculateRateOfReturn(slider.getValue(), compoundedFrequnecy, Integer.parseInt(goal));

							dailyTarget = c.getDailyRateOfReturn();
							weeklyTarget = c.getWeeklyRateOfReturn();
							monthlyTarget = c.getMonthlyRateOfReturn();
							annualTarget = c.getAnnualRateOfReturn();

							fixFont();
							dailyTargetLabel.setText("Your Daily Target is " + df.format((dailyTarget)) + "%");
							weeklyTargetLabel.setText("Your Weekly Target is " + df.format((weeklyTarget)) + "%");
							monthlyTargetLabel.setText("Your Monthly Target is " + df.format((monthlyTarget)) + "%");
							annualTargetLabel.setText("Your Annual Target is " + df.format((annualTarget)) + "%");

						} else {

							throw new NumberFormatException("");
						}
					}
					}
					catch (NumberFormatException e1) {

						toMakeLabel.setText("");
						dailyTargetLabel.setText("Error");
						dailyTargetLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
						dailyTargetLabel.setForeground(Color.red);
						weeklyTargetLabel.setText("Please enter a correct dividends amount");
						monthlyTargetLabel.setText("");
						annualTargetLabel.setText("");

					}

				}

			
		});

		slider.addChangeListener(this);// adds changed values for the slider

	}

	// Invoked when the slider is moved
	public void stateChanged(ChangeEvent e) {

		double dailyTarget = 0;
		double weeklyTarget = 0;
		double monthlyTarget = 0;
		double annualTarget = 0;

		try {
				//if all values are correct 
			if (correctPrincipalValue() && correctContributionsValue() && correctGoalValue() && correctTaxValue()
					&& correctDividendsValue()) {

				c = new Calculation(Integer.parseInt(principal), slider.getValue(), Integer.parseInt(contributions),
						Double.parseDouble(dividend), Integer.parseInt(taxField.getText()));

				c.updatePrincipalValue(annualContributions.isSelected(), monthlyContributions.isSelected(),
						weeklyContributions.isSelected(), dailyContributions.isSelected(),
						reinvestDividendsY.isSelected());
				updateCompoundedFrequnecy();
				c.calculateRateOfReturn(slider.getValue(), compoundedFrequnecy, Integer.parseInt(goal));

				dailyTarget = c.getDailyRateOfReturn();
				weeklyTarget = c.getWeeklyRateOfReturn();
				monthlyTarget = c.getMonthlyRateOfReturn();
				annualTarget = c.getAnnualRateOfReturn();

				fixFont();
				dailyTargetLabel.setText("Your Daily Target is " + df.format((dailyTarget)) + "%");
				weeklyTargetLabel.setText("Your Weekly Target is " + df.format((weeklyTarget)) + "%");
				monthlyTargetLabel.setText("Your Monthly Target is " + df.format((monthlyTarget)) + "%");
				annualTargetLabel.setText("Your Annual Target is " + df.format((annualTarget)) + "%");

				toMakeLabel.setText(String.valueOf(slider.getValue() + " year goal Milestones"));
				sliderBeginLabel.setText(String.valueOf(slider.getValue() + " years"));
			}

		} catch (NumberFormatException e1) {

			toMakeLabel.setText("");
			dailyTargetLabel.setText("Error");
			dailyTargetLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
			dailyTargetLabel.setForeground(Color.red);
			weeklyTargetLabel.setText("Please make sure all the values entered are correct");
			monthlyTargetLabel.setText("correct before using the slider ");
			annualTargetLabel.setText("");
			
		}

	}

 
	// set the compounded frequency
	private void updateCompoundedFrequnecy() {

		if (annualCompound.isSelected()) {

			compoundedFrequnecy = 1;
		}
		if (monthlyCompound.isSelected()) {

			compoundedFrequnecy = 12;
		}
		if (weeklyCompound.isSelected()) {

			compoundedFrequnecy = 52;
		}
		if (dailyCompound.isSelected()) {

			compoundedFrequnecy = 360;
		}

	}

	// reset fonts when transitioning back from exception
	private void fixFont() {

		dailyTargetLabel.setForeground(null);
		dailyTargetLabel.setFont(new Font("Cabrili", Font.PLAIN, 16));
		weeklyTargetLabel.setFont(new Font("Cabrili", Font.PLAIN, 16));
		monthlyTargetLabel.setFont(new Font("Cabrili", Font.PLAIN, 16));
		annualTargetLabel.setFont(new Font("Cabrili", Font.PLAIN, 16));

	}

	
	private boolean correctPrincipalValue() {
		removeCommas();
		return principal.matches("^[0-9]\\d*$") && Integer.parseInt(principal) < 1000000;
	}

	private boolean correctContributionsValue() {
		removeCommas();

		return contributions.matches("^[0-9]\\d*$") && Integer.parseInt(contributions) < 1000000;
	}

	private boolean correctGoalValue() {
		removeCommas();
		return goal.matches("^[1-9]\\d*$") && Integer.parseInt(goal) < 1000000;

	}

	private boolean correctTaxValue() {
		removeCommas();

		return taxField.getText().matches("^[0-9]*\\.?[0-9]+$") && Integer.parseInt(taxField.getText()) < 100;

	}

	private boolean correctDividendsValue() {

		removeCommas();

		return goal.matches("^[0-9]*\\.?[0-9]+$");
	}

	//remove commas
	private void removeCommas() {

		// if "," exist replace it with "" before using the string
		principal = principalField.getText().replace(",", "");
		contributions = contributionsField.getText().replace(",", "");
		goal = goalField.getText().replace(",", "");
		dividend = dividends.getText().replace(",", "");

	}

 
 

}
