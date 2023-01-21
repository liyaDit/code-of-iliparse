package justTrying;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class projectIT extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldInput;
	private JTextField textFieldOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					projectIT frame = new projectIT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public projectIT() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(projectIT.class.getResource("/icon/iconChanged.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 200, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(144, 238, 144));
		contentPane.setForeground(new Color(144, 238, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textFieldInput = new JTextField();
		textFieldInput.setBackground(new Color(147, 112, 219));
		textFieldInput.setForeground(new Color(0x00FF00));
		textFieldInput.setFont(new Font("Arial", Font.ITALIC, 25));
		textFieldInput.setColumns(10);
		
		final JButton buttonTextGenerator = new JButton("Generate cyrilic text");
		buttonTextGenerator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = textFieldInput.getText();
				
				String[] words = input.split(" ");
				String izklucheniq = "kaltsii pii bii shii dii mii shii pii ybii krii svii yvii trii cbii gnii genii skrii zavii izpii otbii izmii izbii zabii nabii bojii helii navii nadvii izvii dopii kalii napii litii zashii otvii popii vtrii obvii otkrii pokrii iztrii jrebii prebii razvii zakrii razkrii metodii stsenarii aluminii magnezii";//error mi here check the contains option
				String ioWords = "heloyin mario moite ofelio naistina idiot idiotut idiota idioti idiotite idiotkata idiotcheto idiotchetata idiotkite mafiot mafiotut mafiota mafioti mafiotite patriot patriotut patriotite patrioti patriota polyidiot polyidiotite polyidioti polyidiotut polyidiota";
				String izklucheniqMnChislo = "prepravi otpravi izpravi prepravi tozi rita pita razbi izbi zabravi si ybi napravi napi izpi nastupi zashtiti poqsni leti purdi stupi kupi natopi topi potopi izkupi podkupi zakupi oslepi zalepi cherpi ykrepi izpi tsepi potursi tursi nameri podseti pravi izvi bavi vurvi purvi obqvi ylovi zaqvi kurvi ostavi dobavi osinovi dolovi opravi rovi razrovi zarovi omalovaji podkrepi zakrepi gori dari diri bori prebori ydari otkri sviri ozari iztri kurti natopi potopi mulchi donosnichi sutrydnichi yvelichi preyvelichi nasochi sochi iztochi tochi natochi sgrabchi";
				
				String output = "";
				
				for (int f = 0; f < words.length; f++) {
					String el = words[f];
					for (int i = 0; i < el.length(); i++) {
						char letter = el.charAt(i);
						
						if (letter == 'a') {
							output += "à";
						}
						else if (letter == 'b') {
							output += "á";
						}
						else if (letter == 'v') {
							if (el.length() == 1) {
								output += "â";
								continue;
							}else {
								output += "â";
							}
						}
						else if (letter == 'g') {
							output += "ã";
						}
						else if (letter == 'd') {
							output += "ä";
						}
						else if (letter == 'e') {
							output += "å";
							
						}
						else if (letter == 'j') {
							output += "æ";
						}
						else if (letter == 'z') {
							output += "ç";
						}
						else if (letter == 'i') {
							
							if (ioWords.contains(el) && !el.equals("nai")) {
								output += "è";
								continue;
							}
							if (izklucheniq.contains(el) && i == el.length() - 1 && el.charAt(el.length() - 2) == 'i') {
									output += "é";
								continue;
							}
							
							boolean koitoFirst = false;

							
							if (el.equals("koito") && i == 2 || el.equals("chiito") && i == 3) {
								
								if (words[0] == el || el.equals("chiito")) {
									koitoFirst = true;
								}
								
								if (!koitoFirst) {
								String wordBeforeKoito = words[f - 1];
								
								if (izklucheniqMnChislo.contains(wordBeforeKoito)) {
									output += "é";
									continue;
								}
								
								char lastLetter = wordBeforeKoito.charAt(wordBeforeKoito.length() - 1);
								char penultimateLetter = wordBeforeKoito.charAt(wordBeforeKoito.length() - 2);  
								if (lastLetter == 'i') {
									output += "è";
									continue;
								}else if (lastLetter == 'e' && penultimateLetter == 't') {
									output += "è";
									continue;
								}else if (lastLetter == 'a' && penultimateLetter == 't' && wordBeforeKoito.charAt(wordBeforeKoito.length() - 3) == 'a' && wordBeforeKoito.charAt(wordBeforeKoito.length() - 4) == 't') {
									output += "è";
									continue;
								}else if (lastLetter == 'a' && penultimateLetter == 't') {
									output += "è";
									continue;
								}else {
									output += "é";
									continue;
								}
								}
							} 
							
							if (el.equals("koi")  && i == 2 || el.equals("chii")  && i == 3 || koitoFirst) {
								//tuk pravq tupotii ili puk ne
								
								if (el.equals("chiito") && i == 2) {
									output += "è";
									continue;
								}
								
								String wordAfterKoi = words[f + 1];
								
								if (izklucheniqMnChislo.contains(wordAfterKoi)) {
									output += "é";
									continue;
								}
								
								if (wordAfterKoi.length() == 1) {
									output += "é";
									continue;
								}
								
								char lastChar = wordAfterKoi.charAt(wordAfterKoi.length() - 1);
								char penultimateChar = wordAfterKoi.charAt(wordAfterKoi.length() - 2);
								
								if (wordAfterKoi.equals("se") && words[f + 2].charAt(words[f + 2].length() - 1) == 'a' && words[f + 2].charAt(words[f + 2].length() - 2) == 'h') {
									output += "è";
									continue;
								}
								if (wordAfterKoi.equals("shte") || wordAfterKoi.equals("ne") || wordAfterKoi.equals("me") || wordAfterKoi.equals("mi")) {
									String wordAfterAfterKoi = words[f + 2];
									char lastChar2word = wordAfterAfterKoi.charAt(wordAfterAfterKoi.length() - 1);
									char penultimate2Char = wordAfterAfterKoi.charAt(wordAfterAfterKoi.length() - 2);
									
									if (lastChar2word == 't' && penultimate2Char == 'q') {
										output += "è";
										continue;
									}else if (lastChar2word == 't' && penultimate2Char == 'a') {
										output += "è";
										continue;
									}else if (lastChar2word == 'i') {
										output += "è";
										continue;
									}else if (lastChar2word == 'a' && penultimate2Char == 'h') {
										output += "è";
										continue;
									}else {
										output += "é";
										continue;
									}
								}
								
								
									if (wordAfterKoi.equals("sa") || wordAfterKoi.equals("biha") || wordAfterKoi.equals("bqha")) {
										output += "è";
										continue;
									}else if (lastChar == 'a' && penultimateChar == 'h') {
										output += "è";
										continue;
									}else if (lastChar == 't' && penultimateChar == 'q') {
										output += "è";
										continue;
									}else if (lastChar == 'i' && penultimateChar == 'i') {
										output += "è";
										continue;
									}else if (lastChar == 't' && penultimateChar == 'a') {
										output += "è";
										continue;
									}else if (lastChar == 'i' && penultimateChar != 'i') {
										output += "è";
										continue;
									}
									else if (lastChar == 'a' && penultimateChar == 't') {
										output += "è";
										continue;
									}else {
										output += "é";
										continue;
									}
							}
							
							if (el.charAt(el.length() - 1) == 'e' && el.charAt(el.length() - 2) == 't' && el.charAt(el.length() - 3) == 'i' && el.charAt(el.length() - 4) == 'i') {
								if (i == el.charAt(el.length() - 3)) {
									output += "è";
								}else if (i == el.charAt(el.length() - 4)) {//instryktsiite
									output += "è";
								}else if (el.charAt(0) == 'i') {
									output += "è";
									continue;
								}
							}
							
							
							
							
							if (el.length() == 1) {
								output += "è";
								continue;
							}
							
							if (el.charAt(0) == letter && el.charAt(el.length() - 1) == letter) {
							if (i == 0) {
								if (el.charAt(1) == 'o' || el.charAt(1) == 'e' || el.charAt(1) == 'u' || el.charAt(1) == 'y' || el.charAt(1) == 'i') {
									output += "é";
								}else {
									output += "è";
								}
							}else if (i == el.length() - 1) {

								if (el.charAt(el.length() - 2) == 'o' || el.charAt(el.length() - 2) == 'e' || el.charAt(el.length() - 2) == 'u' || el.charAt(el.length() - 2) == 'y' || el.charAt(el.length() - 2) == 'a' || el.charAt(el.length() - 2) == 'q') {
									output += "é";
								}else {
									output += "è";
								}
							
							}//else if (/el.charAt(i + 1) == 'o') {
//								if (el.charAt(i - 1) == 'o' || el.charAt(i - 1) == 'e' || el.charAt(i - 1) == 'u' || el.charAt(i - 1) == 'y' || el.charAt(i - 1) == 'i') {
//									output += "é";
//								}else {
//									output += "ü";//kodut e za er maluk a ne za i kratko
//								}
//							}
							else {
								output += "è";
							}
							continue;
							}
						
							
							
							if (el.charAt(0) == letter && el.charAt(el.length() - 1) != letter) {//tuk
								if (el.charAt(i + 1) == 'o' || el.charAt(i + 1) == 'e' || el.charAt(i + 1) == 'u' || el.charAt(i + 1) == 'y' || el.charAt(i + 1) == 'i') {
									output += "é";
								}else {
									output += "è";
								}
							}
							
							else if (el.charAt(el.length() - 1) == letter && el.charAt(0) != letter){
								if (el.charAt(i - 1) == 'o' || el.charAt(i - 1) == 'e' || el.charAt(i - 1) == 'u' || el.charAt(i - 1) == 'y' || el.charAt(i - 1) == 'a') {
									output += "é";
								}else {
									output += "è";
								}
							}
							
							else if (el.charAt(i - 1) == 'a' || el.charAt(i - 1) == 'o' || el.charAt(i - 1) == 'e' || el.charAt(i - 1) == 'u' || el.charAt(i - 1) == 'y' || el.charAt(i - 1) == 'i' || el.charAt(i - 1) == 'q') {
								if (el.charAt(el.length() - 1) == 'e' && el.charAt(el.length() - 2) == 't' && el.charAt(el.length() - 3) == 'i' && el.charAt(el.length() - 4) == 'i' && i == el.length() - 3) {
									output += "è";
								}else {
									output += "é";
								}//promeneno
							}else if (el.charAt(i + 1) == 'o') {//|| el.charAt(i + 1) == 'e' || el.charAt(i + 1) == 'u' || el.charAt(i + 1) == 'y' || el.charAt(i + 1) == 'i' || el.charAt(i + 1) == 'a'
								if (el.charAt(i - 1) == 'o' || el.charAt(i - 1) == 'e' || el.charAt(i - 1) == 'u' || el.charAt(i - 1) == 'y' || el.charAt(i - 1) == 'i') {
									output += "é";
								}else {
									output += "ü";//kodut e za er maluk a ne za i kratko
								}
							}else {
								output += "è";
							}
							
							
							
						}
						else if (letter == 'k') {
							output += "ê";
						}
						else if (letter == 'l') {
							output += "ë";
						}
						else if (letter == 'm') {
							output += "ì";
						}
						else if (letter == 'n') {
							output += "í";
						}
						else if (letter == 'o') {
							output += "î";
						}
						else if (letter == 'p') {
							output += "ï";
						}
						else if (letter == 'r') {
							output += "ð";
						}
						else if (letter == 's') {
							
							if (el.length() == 1) {
								output += "ñ";
								continue;
							}
							if (el.length() == 2 && el.charAt(0) == 's' && el.charAt(1) == 'h') {
								output += "ø";
								continue;
							}
							if (el.length() == 3 && el.charAt(0) == 's' && el.charAt(1) == 'h' && el.charAt(2) == 't') {
								output += "ù";
								break; 
							}
							
							if (el.charAt(0) == letter && el.charAt(el.length() - 1) == letter) {
								if (i == 0) {
									if (el.charAt(i + 1) != 'h') {
										output += "ñ";
									}else if (el.charAt(i + 1) == 'h' && el.charAt(i + 2) == 't') { //ne e error line
										output += "ù";
									}else if (el.charAt(i + 1) == 'h' && el.charAt(i + 2) != 't') {
										output += "ø";
									}
								}else if (i == el.length() - 1) {
									if (el.charAt(i - 1) != 't') {
										output += "ñ";
									}else if (el.charAt(i - 1) == 't') {
										output += "ö";
									}
								}else if(el.charAt(i - 1) != 't' && el.charAt(i + 1) != 'h') {
									output += "c";
								}
								continue;
								}
							
							
							if (el.equals("shema")) {
								output += "c";
							}
							if (el.charAt(0) == letter && el.charAt(i + 1) != 'h') {
								if (el.charAt(0) == letter && el.charAt(i + 1) != 'h' && i != 0 && el.charAt(i - 1) == 't') {
									output += "ö";
								}else {
									output += "c";
								}
							}else if (el.charAt(el.length() - 1) == letter && el.charAt(i - 1) != 't') {
								output += "c";
							}
							
							else if (el.charAt(0) == 's' && el.charAt(1) == 'h' && el.charAt(el.length() - 1) == 'h' && el.charAt(el.length() - 2) == 's') {
								if (el.charAt(2) == 't' && i == 0) {
									output += "ù";
								}else {
									output += "ø";
								}// kogato dumata zapochva i zavurshva sus sh
							}
							else if (el.charAt(0) == letter && el.charAt(1) == 'h' && el.charAt(i + 2) != 't') {
								output += "ø";// kogato sh e na 1vo mqsto
							}
							
							else if (el.charAt(el.length() - 2) == 's' && el.charAt(el.length() - 1) == 'h' && i == el.length() - 2) {
								if (el.charAt(0) == 'h') {
									continue;
								}
								output += "ø";//kogato sh e na posledno mqsto
							}
							
							else if (el.charAt(0) == letter && el.charAt(1) == 'h' && el.charAt(2) == 't' && i == 0) {//error line//mai veche ne e error line
								output += "ù";// ako sht e purvo
							}
							
							
							else if (el.charAt(i - 1) == 't' && el.charAt(el.length() - 1) == 's') {
								output += "ö";
							}else if (el.charAt(i - 1) == 't' && el.charAt(el.length() - 1) != 's') {
								output += "ö";
							}
							

							else if (el.charAt(i + 1) == 'h' && el.charAt(i + 2) != 't') {
								output += "ø";//kogato e v sredata
							}
			
							
							else if (el.charAt(i + 1) == 'h' && el.charAt(i + 2) == 't' && el.charAt(el.length() - 2) != 'h') {//&& el.charAt(el.length() - 1) != 't'
								output += "ù";//ako sht e v sredata //ne e error line
							}
							
							
							
							else if (el.charAt(i - 1) == 't') {
								continue;
							}else if (el.charAt(i + 1) == 'h') {
								continue;
							}
							else {
								output += "c";
							}
						}
						else if (letter == 't') {

							
							
							if (el.charAt(0) == letter && el.charAt(el.length() - 1) == letter) {
								if (i == 0 && el.charAt(i + 1) != 's') {
									output += "ò";
								}else if (i == el.length() - 1) {
									if (el.charAt(i - 1) != 'h') {
										output += "ò";
									}else if (el.charAt(i - 1) == 'h' && el.charAt(i - 2) == 's'){
										output += "ù";//ne e error line
									}
								}
								continue;
								}
							
							
							if (el.length() == 2) {
								output += "ò";
								continue;
							}
							
							
							if (el.charAt(el.length() - 1) == letter && el.charAt(i - 1) == 'h' && el.charAt(i - 2) == 's' && i == el.length() - 1) {// && el.charAt(0) != 's'// error line
								output += "ù";// ako sht e posledno
							}
							
							

							else if (el.charAt(el.length() - 1) == letter && el.charAt(i - 1) != 'h') {
								output += "ò";
							}
							
							
							
							else if (el.charAt(0) == letter && el.charAt(i + 1) != 's') {
								output += "ò";
							}else if (el.charAt(i + 1) == 's') {
								continue;
							}else if (el.charAt(i - 1) == 'h' && el.charAt(i - 2) == 's') {
								continue;
							}else {
								output += "ò";
							}
						}
						else if (letter == 'y') {
							if (el.charAt(el.length() - 1) == letter) {
								output += "y";
							}else if (el.charAt(i + 1) == 'u') {
								output += "þ";
							}else {
								output += "y";
							}
						}
						else if (letter == 'f') {
							output += "ô";
						}
						else if (letter == 'h') {
							
							if (el.charAt(0) == letter && el.charAt(el.length() - 1) == letter && i == el.length() - 1) {
								if (el.charAt(el.length() - 2) == 's') {
									output += "ø";
								}else if (el.charAt(el.length() - 2) == 'c') {
									output += "÷";
								}else {
									output += "õ";
								}
								continue;
								}
							
							
							
							
							if (el.charAt(0) == letter) {
								output += "õ";
							}else if (el.charAt(i - 1) == 'c') {
								output += "÷";
							}else if (el.charAt(i - 1) == 's') {
								continue;
							}else {
								output += "õ";
							}
						}
						else if (letter == 'u') {
							if (el.charAt(0) == letter) {
								output += "ú";
							}else if (el.charAt(i - 1) != 'y') {
								output += "ú";
							}else {
								continue;
							}
						}
						else if (letter == 'y') {
							if (el.charAt(el.length() - 1) == letter) {
								output += "ó";
							} else if (el.charAt(i + 1) == 'u') {
								output += "þ";
							}else {
								continue;
							}
						}
						else if (letter == 'q') {
							output += "ÿ";
						}
						else if (letter == '.') {
							output += ".";
						}else if (letter == ',') {
							output += ",";
						}else if (letter == '-') {
							output += "-";
						}else if (letter == '?') {
							output += "?";
						}else if (letter == '!') {
							output += "!";
						}
					}
					output += " ";
				}
				textFieldOutput.setText(output);
			}
		});
		buttonTextGenerator.setBackground(new Color(204, 255, 204));
		buttonTextGenerator.setFont(new Font("Bell MT", Font.ITALIC, 35));
		buttonTextGenerator.setForeground(new Color(102,  0, 153));
		
		final JLabel Instructions = new JLabel("Type in latinic in the text field down below.");
		Instructions.setBackground(new Color(204, 153, 255));
		Instructions.setFont(new Font("Yu Gothic", Font.ITALIC, 28));
		Instructions.setForeground(new Color(102, 0, 153));
		
		textFieldOutput = new JTextField();
		textFieldOutput.setBackground(new Color(147, 112, 219));
		textFieldOutput.setForeground(new Color(0x00FF00));
		textFieldOutput.setFont(new Font("Arial", Font.ITALIC, 25));
		textFieldOutput.setColumns(10);
		
		final JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldOutput.setText("");
				textFieldInput.setText("");
			}
		});
		btnClear.setBackground(new Color(204, 255, 204));
		btnClear.setFont(new Font("Bell MT", Font.ITALIC, 35));
		btnClear.setForeground(new Color(102, 0, 153));
		
		final JComboBox comboBoxColors = new JComboBox();
		comboBoxColors.setFont(new Font("Yu Gothic", Font.ITALIC, 28));
		comboBoxColors.setBackground(new Color(204, 255, 204));
		comboBoxColors.setForeground(new Color(102, 0, 53));
		comboBoxColors.setModel(new DefaultComboBoxModel(new String[] {"original", "blue", "orange", "red", "green", "purple", "pink", "yellow", "white", "black"}));
		
		JButton btnChangeColor = new JButton("change color");
		btnChangeColor.setFont(new Font("Yu Gothic", Font.ITALIC, 20));
		btnChangeColor.setBackground(new Color(204, 255, 204));
		btnChangeColor.setForeground(new Color(102, 0, 53));
		
		btnChangeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedValue = comboBoxColors.getSelectedItem().toString();
				// "orange", "red", "green", "purple", "pink", "yellow", "white", "black"
				//b,r,w,g,blak,p, pink, y
				switch (selectedValue) {
				case "original"://ready
					textFieldInput.setBackground(new Color(147, 112, 219));//
					textFieldOutput.setBackground(new Color(147, 112, 219));//
					Instructions.setForeground(new Color(102, 0, 153));//
					buttonTextGenerator.setBackground(new Color(204, 255, 204));//
					btnClear.setBackground(new Color(204, 255, 204));//
					buttonTextGenerator.setForeground(new Color(102, 0, 153));//
					btnClear.setForeground(new Color(102, 0, 153));//
					textFieldInput.setForeground(new Color(0x00FF00));
					textFieldOutput.setForeground(new Color(0x00FF00));
					comboBoxColors.setBackground(new Color(204, 255, 204));//
					comboBoxColors.setForeground(new Color(102, 0, 53));//
					break;
				case "blue"://ready
					textFieldInput.setBackground(new Color(51, 153, 255));
					textFieldOutput.setBackground(new Color(51, 153, 255));
					Instructions.setForeground(new Color(51, 153, 255));
					buttonTextGenerator.setBackground(new Color(51, 153, 255));
					btnClear.setBackground(new Color(51, 153, 255));
					buttonTextGenerator.setForeground(new Color(8, 40, 201));
					btnClear.setForeground(new Color(8, 40, 201));
					textFieldInput.setForeground(new Color(8, 40, 201));
					textFieldOutput.setForeground(new Color(8, 40, 201));
					comboBoxColors.setBackground(new Color(51, 153, 255));
					comboBoxColors.setForeground(new Color(8, 40, 201));
					break;
				case "red"://ready
					textFieldInput.setBackground(new Color(222, 69, 64));
					textFieldOutput.setBackground(new Color(222, 69, 64));
					Instructions.setForeground(new Color(225, 0, 0));
					buttonTextGenerator.setBackground(new Color(222, 69, 64));
					btnClear.setBackground(new Color(222, 69, 64));
					buttonTextGenerator.setForeground(new Color(0, 0, 0));
					btnClear.setForeground(new Color(0, 0, 0));
					textFieldInput.setForeground(new Color(156, 25, 20));
					textFieldOutput.setForeground(new Color(156, 25, 20));
					comboBoxColors.setBackground(new Color(222, 69, 64));
					comboBoxColors.setForeground(new Color(0, 0, 0));
					break;
				case "purple"://ready
					textFieldInput.setBackground(new Color(102, 0, 153));
					textFieldOutput.setBackground(new Color(102, 0, 153));
					Instructions.setForeground(new Color(102, 0, 153));
					buttonTextGenerator.setBackground(new Color(102, 0, 153));
					btnClear.setBackground(new Color(102, 0, 153));
					buttonTextGenerator.setForeground(new Color(198, 101, 239));
					btnClear.setForeground(new Color(198, 101, 239));
					textFieldInput.setForeground(new Color(198, 101, 239));
					textFieldOutput.setForeground(new Color(198, 101, 239));
					comboBoxColors.setBackground(new Color(102, 0, 153));
					comboBoxColors.setForeground(new Color(198, 101, 239));
					break;
				case "pink"://ready
					textFieldInput.setBackground(new Color(255, 192, 203));
					textFieldOutput.setBackground(new Color(255, 192, 203));
					Instructions.setForeground(new Color(255, 20, 147));
					buttonTextGenerator.setBackground(new Color(255, 192, 203));
					btnClear.setBackground(new Color(255, 192, 203));
					buttonTextGenerator.setForeground(new Color(255, 20, 147));
					btnClear.setForeground(new Color(255, 20, 147));
					textFieldInput.setForeground(new Color(255, 20, 147));
					textFieldOutput.setForeground(new Color(255, 20, 147));
					comboBoxColors.setBackground(new Color(255, 192, 203));
					comboBoxColors.setForeground(new Color(255, 20, 147));
					break;
				case "yellow"://ready
					textFieldInput.setBackground(new Color(255, 255, 0));
					textFieldOutput.setBackground(new Color(255, 255, 0));
					Instructions.setForeground(new Color(0, 0, 0));
					buttonTextGenerator.setBackground(new Color(255, 255, 0));
					btnClear.setBackground(new Color(255, 255, 0));
					buttonTextGenerator.setForeground(new Color(0, 0, 0));
					btnClear.setForeground(new Color(0, 0, 0));
					textFieldInput.setForeground(new Color(175, 185, 34));
					textFieldOutput.setForeground(new Color(175, 185, 34));
					comboBoxColors.setBackground(new Color(255, 255, 0));
					comboBoxColors.setForeground(new Color(0, 0, 0));
					break;
				case "white"://ready
					textFieldInput.setBackground(new Color(255, 255, 255));
					textFieldOutput.setBackground(new Color(255, 255, 255));
					Instructions.setForeground(new Color(149, 149, 149));
					buttonTextGenerator.setBackground(new Color(255, 255, 255));
					btnClear.setBackground(new Color(255, 255, 255));
					buttonTextGenerator.setForeground(new Color(149, 149, 149));
					btnClear.setForeground(new Color(149, 149, 149));
					textFieldInput.setForeground(new Color(149, 149, 149));
					textFieldOutput.setForeground(new Color(149, 149, 149));
					comboBoxColors.setBackground(new Color(255, 255, 255));
					comboBoxColors.setForeground(new Color(149, 149, 149));
					break;
				case "black"://ready
					textFieldInput.setBackground(new Color(0, 0, 0));
					textFieldOutput.setBackground(new Color(0, 0, 0));
					Instructions.setForeground(new Color(0, 0, 0));
					buttonTextGenerator.setBackground(new Color(0, 0, 0));
					btnClear.setBackground(new Color(0, 0, 0));
					buttonTextGenerator.setForeground(new Color(255, 255, 255));
					btnClear.setForeground(new Color(255, 255, 255));
					textFieldInput.setForeground(new Color(255, 255, 255));
					textFieldOutput.setForeground(new Color(255, 255, 255));
					comboBoxColors.setBackground(new Color(0, 0, 0));
					comboBoxColors.setForeground(new Color(255, 255, 255));
					break;
				case "green"://ready
					textFieldInput.setBackground(new Color(0, 204, 0));
					textFieldOutput.setBackground(new Color(0, 204, 0));
					Instructions.setForeground(new Color(42, 122, 29));
					buttonTextGenerator.setBackground(new Color(0, 204, 0));
					btnClear.setBackground(new Color(0, 204, 0));
					buttonTextGenerator.setForeground(new Color(33, 104, 22));
					btnClear.setForeground(new Color(33, 104, 22));
					textFieldInput.setForeground(new Color(33, 104, 22));
					textFieldOutput.setForeground(new Color(33, 104, 22));
					comboBoxColors.setBackground(new Color(0, 204, 0));
					comboBoxColors.setForeground(new Color(33, 104, 22));
					break;
				case "orange"://ready
					textFieldInput.setBackground(new Color(247, 173, 23));
					textFieldOutput.setBackground(new Color(247, 173, 23));
					Instructions.setForeground(new Color(255, 102, 0));
					buttonTextGenerator.setBackground(new Color(247, 173, 23));
					btnClear.setBackground(new Color(247, 173, 23));
					buttonTextGenerator.setForeground(new Color(151, 104, 11));
					btnClear.setForeground(new Color(151, 104, 11));
					textFieldInput.setForeground(new Color(151, 104, 11));
					textFieldOutput.setForeground(new Color(151, 104, 11));
					comboBoxColors.setBackground(new Color(247, 173, 23));
					comboBoxColors.setForeground(new Color(151, 104, 11));
					break;
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(Instructions, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(212)
					.addComponent(btnClear, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
					.addGap(241))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldInput, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxColors, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnChangeColor, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
							.addGap(93)
							.addComponent(buttonTextGenerator, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
							.addGap(56)))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(textFieldOutput, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(Instructions, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(textFieldInput, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnChangeColor, GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxColors, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addComponent(buttonTextGenerator, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldOutput, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnClear, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
