//Kevin Ramirez
//5.13.2021
//this creates the main game where the game is played

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JProgressBar;

public class GameWindow extends JFrame {
	//all my variables and game items
	private JPanel contentPane;
	private JLabel narrationText;
	private JLabel mPlayer;
	private JLabel fPlayer;
	private JLabel Pokeball;
	private JLabel Pokeball2;
	private JLabel snivy;
	private JLabel snivyName;
	private JLabel mPlayerMain;
	private JLabel bottomBackNone;
	private JButton textContinueButton;
	private JButton sendOut;
	private JButton attackMenuButton;
	private JLabel selectMenu;
	private JLabel attackingMenu;
	Timer stopwatch2;
	Timer stopwatch;
	int count = 0;
	int count2 = 0;
	int turnCounter = 0;
	int delay = 1000;
	int snivyHealthLV = 1;
	int eeveeHealthLV = 2;
	int takeDown = 1;
	int swift = 2;
	int quickAttack = 3;
	int tackle = 4;
	private JLabel eevee;
	private JLabel rightHP;
	private JLabel leftHP;
	private JButton partyButton;
	private JButton runButton;
	private JButton bagButton;
	private JButton backButton;
	private JButton moveOne;
	private JButton move2;
	private JButton move3;
	private JButton move4;
	Music selectSound;
	Music move1Sound;
	Music move2Sound;
	Music move3Sound;
	Music move4Sound;
	Music move5Sound;
	Music move6Sound;
	Music move7Sound;
	private JLabel eeveeName;
	private JLabel levelLeft;
	private JLabel levelRight;
	private JProgressBar snivyBar;
	private JProgressBar eeveeBar;
	PokemonData object;
	private JLabel eeveeMaxHP;
	private JLabel eeveeCurrentHP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow frame = new GameWindow();
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
	public GameWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//I used this to call info and algorithms from the PokeData class
		object = new PokemonData(100, 100);

		//all these objects labels, music, buttons, and text are created and are only visible when used
		eeveeBar = new JProgressBar();
		eeveeBar.setForeground(new Color(0, 255, 0));
		eeveeBar.setVisible(false);
		eeveeBar.setValue(400);
		eeveeBar.setBounds(677, 305, 97, 6);
		contentPane.add(eeveeBar);
		
		//creates enemy health bar
		snivyBar = new JProgressBar();
		snivyBar.setForeground(new Color(0, 255, 0));
		snivyBar.setVisible(false);
		snivyBar.setValue(350);
		snivyBar.setBounds(79, 95, 110, 6);
		contentPane.add(snivyBar);

		//creates your health bar
		eeveeCurrentHP = new JLabel("100");
		eeveeCurrentHP.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		eeveeCurrentHP.setForeground(new Color(0, 0, 0));
		eeveeCurrentHP.setVisible(false);
		eeveeCurrentHP.setBounds(687, 313, 45, 13);
		contentPane.add(eeveeCurrentHP);
		
		//creates a max label
		eeveeMaxHP = new JLabel("100");
		eeveeMaxHP.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		eeveeMaxHP.setForeground(new Color(0, 0, 0));
		eeveeMaxHP.setVisible(false);
		eeveeMaxHP.setBounds(729, 313, 45, 13);
		contentPane.add(eeveeMaxHP);

		//creates a level label for enemy
		levelLeft = new JLabel("36");
		levelLeft.setVisible(false);
		levelLeft.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		levelLeft.setForeground(Color.BLACK);
		levelLeft.setBounds(152, 76, 45, 13);
		contentPane.add(levelLeft);

		//creates a level label for you
		levelRight = new JLabel("41");
		levelRight.setVisible(false);
		levelRight.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		levelRight.setForeground(Color.BLACK);
		levelRight.setBounds(742, 288, 45, 13);
		contentPane.add(levelRight);

		//creates a name label for enemy
		snivyName = new JLabel("Snivy");
		snivyName.setVisible(false);
		snivyName.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		snivyName.setForeground(Color.BLACK);
		snivyName.setBounds(53, 76, 45, 13);
		contentPane.add(snivyName);

		//creates a name label for you
		eeveeName = new JLabel("Eevee");
		eeveeName.setVisible(false);
		eeveeName.setForeground(Color.BLACK);
		eeveeName.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		eeveeName.setBounds(629, 288, 45, 13);
		contentPane.add(eeveeName);

		//creates a poke info display for enemy
		String ememyHP = "ememyhealth.png";
		ImageIcon badHealth = new ImageIcon(ememyHP);

		rightHP = new JLabel(badHealth);
		rightHP.setVisible(false);
		rightHP.setBounds(0, 45, 238, 78);
		contentPane.add(rightHP);

		//creates a poke info display for you
		String friendlyHP = "yourhealthFinal.png";
		ImageIcon goodHealth = new ImageIcon(friendlyHP);

		leftHP = new JLabel(goodHealth);
		leftHP.setVisible(false);
		leftHP.setBounds(536, 268, 238, 78);
		contentPane.add(leftHP);

		//creates a eevee sprite
		String poggers = "EeveeSprite.gif";
		ImageIcon pokemon2 = new ImageIcon(poggers);

		eevee = new JLabel(pokemon2);
		eevee.setVisible(false);
		eevee.setBounds(146, 268, 110, 100);
		contentPane.add(eevee);

		//creates a snivy sprite
		String yoo = "SnivySprite.gif";
		ImageIcon pokemon1 = new ImageIcon(yoo);

		snivy = new JLabel(pokemon1);
		snivy.setVisible(false);
		snivy.setBounds(541, 131, 110, 100);
		contentPane.add(snivy);

		//creates a pokeball sprite
		String ball2 = "PokeballSprite2.gif";
		ImageIcon spinningball2 = new ImageIcon(ball2);

		Pokeball2 = new JLabel(spinningball2);
		Pokeball2.setVisible(false);
		Pokeball2.setBounds(234, 148, 45, 37);
		contentPane.add(Pokeball2);
		
		//creates another pokeball sprite
		String ball = "PokeballSprite.gif";
		ImageIcon spinningball = new ImageIcon(ball);

		Pokeball = new JLabel(spinningball);
		Pokeball.setVisible(false);
		Pokeball.setBounds(556, 174, 45, 37);
		contentPane.add(Pokeball);

		//creates female sprite
		String fCPU = "FTrainerSprite.gif";
		ImageIcon CPU = new ImageIcon(fCPU);

		fPlayer = new JLabel(CPU);
		fPlayer.setVisible(true);
		fPlayer.setBounds(481, -16, 238, 247);
		contentPane.add(fPlayer);

		//creates male sprite
		String picture = "MTrainerSprite.gif";
		ImageIcon playerMain = new ImageIcon(picture);

		mPlayerMain = new JLabel(playerMain);
		mPlayerMain.setVisible(false);
		mPlayerMain.setBounds(61, 134, 193, 234);
		contentPane.add(mPlayerMain);

		//creates male still image
		String pic = "Animation1.png";
		ImageIcon player = new ImageIcon(pic);

		mPlayer = new JLabel(player);
		mPlayer.setVisible(true);
		mPlayer.setBounds(61, 134, 193, 234);
		contentPane.add(mPlayer);

		//This is where all the constantly used auido files are made
		String filepath = "BattleMusic.wav";
		Music musicObject = new Music();
		musicObject.playMusic(filepath);

		String click = "ButtonPress.wav";
		selectSound = new Music();

		String move1 = "Tackle.wav";
		move1Sound = new Music();

		String moveTwo = "Take Down.wav";
		move2Sound = new Music();

		String moveThree = "Swift.wav";
		move3Sound = new Music();

		String moveFour = "Quick Attack.wav";
		move4Sound = new Music();

		String moveFive = "Mega Drain.wav";
		move5Sound = new Music();

		String moveSix = "Vine Whip.wav";
		move6Sound = new Music();

		String moveSeven = "Slam.wav";
		move7Sound = new Music();

		//creates the arena background
		String url = "PokemonBattleBackground.png";
		ImageIcon background = new ImageIcon(url);

		JLabel battleBack = new JLabel(background);
		battleBack.setBounds(0, 0, 787, 368);
		contentPane.add(battleBack);

		//creates the center text box for the player to read
		narrationText = new JLabel();
		narrationText.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		narrationText.setText("A new Trainer has appeared!");
		narrationText.setForeground(Color.WHITE);
		narrationText.setBounds(10, 378, 551, 37);
		contentPane.add(narrationText);

		//creates a button to send out pokemon and start the battle animation
		sendOut = new JButton("Send Pokemon");
		sendOut.setForeground(Color.WHITE);
		sendOut.setVisible(false);
		sendOut.setBackground(Color.DARK_GRAY);
		sendOut.setBorder(new LineBorder(new Color(255, 0, 0), 3));
		sendOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectSound.playMusic(click);
				pokeballAnimation2(1, 2);
			}
		});
		sendOut.setBounds(465, 414, 142, 21);
		contentPane.add(sendOut);

		//creates a button to start the battle
		textContinueButton = new JButton("Ok");
		textContinueButton.setForeground(Color.WHITE);
		textContinueButton.setBorder(new LineBorder(new Color(255, 0, 0), 3));
		textContinueButton.setBackground(Color.GRAY);
		textContinueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectSound.playMusic(click);
				pokeballAnimation(1, 2);

			}
		});
		textContinueButton.setBounds(352, 414, 85, 21);
		contentPane.add(textContinueButton);

		//creates the attack menu button
		attackMenuButton = new JButton("");
		attackMenuButton.setVisible(false);
		attackMenuButton.setRequestFocusEnabled(false);
		attackMenuButton.setContentAreaFilled(false);
		attackMenuButton.setBorderPainted(false);
		attackMenuButton.setForeground(new Color(0, 0, 0));
		attackMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectSound.playMusic(click);
				attackMenuButton.setVisible(false); //making things visible and invisible is how i made my menus
				selectMenu.setVisible(false);
				attackingMenu.setVisible(true);
				bagButton.setVisible(false);
				runButton.setVisible(false);
				partyButton.setVisible(false);
				backButton.setVisible(true);
				moveOne.setVisible(true);
				move2.setVisible(true);
				move3.setVisible(true);
				move4.setVisible(true);
			}
		});
		attackMenuButton.setBounds(290, 545, 199, 64);
		contentPane.add(attackMenuButton);

		//creates the back button
		backButton = new JButton("");
		backButton.setVisible(false);
		backButton.setRequestFocusEnabled(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setForeground(new Color(0, 0, 0));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectSound.playMusic(click);
				backButton.setVisible(false);
				selectMenu.setVisible(true);
				bagButton.setVisible(true);
				runButton.setVisible(true);
				partyButton.setVisible(true);
				moveOne.setVisible(false);
				move2.setVisible(false);
				move3.setVisible(false);
				move4.setVisible(false);
				attackMenuButton.setVisible(true);

			}
		});
		backButton.setBounds(568, 681, 168, 82);
		contentPane.add(backButton);

		//creates party button
		partyButton = new JButton("");
		partyButton.setVisible(false);
		partyButton.setRequestFocusEnabled(false);
		partyButton.setContentAreaFilled(false);
		partyButton.setBorderPainted(false);
		partyButton.setForeground(new Color(0, 0, 0));
		partyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectSound.playMusic(click);
				narrationText.setText("You only have 1 Pokemon in your party!");
			}
		});
		partyButton.setBounds(568, 681, 168, 82);
		contentPane.add(partyButton);

		//creates a run button
		runButton = new JButton("");
		runButton.setVisible(false);
		runButton.setRequestFocusEnabled(false);
		runButton.setContentAreaFilled(false);
		runButton.setBorderPainted(false);
		runButton.setForeground(new Color(0, 0, 0));
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectSound.playMusic(click);
				narrationText.setText("You can't run from a Trainer battle!");
			}
		});
		runButton.setBounds(305, 681, 168, 82);
		contentPane.add(runButton);

		//creates a bag button
		bagButton = new JButton("");
		bagButton.setVisible(false);
		bagButton.setRequestFocusEnabled(false);
		bagButton.setContentAreaFilled(false);
		bagButton.setBorderPainted(false);
		bagButton.setForeground(new Color(0, 0, 0));
		bagButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectSound.playMusic(click);
				narrationText.setText("This feature is not implemented yet!");
			}
		});
		bagButton.setBounds(45, 681, 168, 82);
		contentPane.add(bagButton);

		//all the buttons that attack are here
		move4 = new JButton("Tackle");
		move4.setVisible(false);
		move4.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		move4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		move4.setBackground(new Color(192, 192, 192));
		move4.setForeground(new Color(0, 0, 0));
		move4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectSound.playMusic(click);
				narrationText.setText("Eevee used Tackle!");
				object.tackle(snivyHealthLV);
				move1Sound.playMusic(move1);
				int i = object.getSnivyHealthLV1();
				fillSnivy(i);
				moveTurn(3, 3, turnCounter);
				turnCounter ++;
				bottomBackNone.setVisible(true);
				attackingMenu.setVisible(false);
				move4.setVisible(false);
				move3.setVisible(false);
				move2.setVisible(false);
				moveOne.setVisible(false);
				backButton.setVisible(false);
			}
		});
		move4.setBounds(53, 577, 286, 64);
		contentPane.add(move4);

		move3 = new JButton("Quick Attack");
		move3.setVisible(false);
		move3.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		move3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		move3.setBackground(new Color(192, 192, 192));
		move3.setForeground(new Color(0, 0, 0));
		move3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectSound.playMusic(click);
				narrationText.setText("Eevee used Quick Attack!");
				object.quickAttack(snivyHealthLV);
				move4Sound.playMusic(moveFour);
				int i = object.getSnivyHealthLV1();
				fillSnivy(i);
				moveTurn(3, 2, turnCounter);
				turnCounter ++;
				bottomBackNone.setVisible(true);
				attackingMenu.setVisible(false);
				move4.setVisible(false);
				move3.setVisible(false);
				move2.setVisible(false);
				moveOne.setVisible(false);
				backButton.setVisible(false);
			}
		});
		move3.setBounds(442, 577, 286, 64);
		contentPane.add(move3);

		move2 = new JButton("Swift");
		move2.setVisible(false);
		move2.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		move2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		move2.setBackground(new Color(192, 192, 192));
		move2.setForeground(new Color(0, 0, 0));
		move2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectSound.playMusic(click);
				narrationText.setText("Eevee used Swift!");
				move3Sound.playMusic(moveThree);
				object.swift(snivyHealthLV);
				int i = object.getSnivyHealthLV1();
				fillSnivy(i);
				moveTurn(3, 2, turnCounter);
				turnCounter ++;
				bottomBackNone.setVisible(true);
				attackingMenu.setVisible(false);
				move4.setVisible(false);
				move3.setVisible(false);
				move2.setVisible(false);
				moveOne.setVisible(false);
				backButton.setVisible(false);
			}
		});
		move2.setBounds(442, 491, 286, 64);
		contentPane.add(move2);

		moveOne = new JButton("Takedown");
		moveOne.setVisible(false);
		moveOne.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		moveOne.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		moveOne.setBackground(new Color(192, 192, 192));
		moveOne.setForeground(new Color(0, 0, 0));
		moveOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectSound.playMusic(click);
				narrationText.setText("Eevee used Take Down!");
				move2Sound.playMusic(moveTwo);
				object.takeDown(snivyHealthLV);
				int i = object.getSnivyHealthLV1();
				fillSnivy(i);
				moveTurn(3, 2, turnCounter);
				turnCounter ++;
				bottomBackNone.setVisible(true);
				attackingMenu.setVisible(false);
				move4.setVisible(false);
				move3.setVisible(false);
				move2.setVisible(false);
				moveOne.setVisible(false);
				backButton.setVisible(false);
			}
		});
		moveOne.setBounds(53, 491, 286, 64);
		contentPane.add(moveOne);

		//creates the surrounding box around the game player text 
		JLabel blackTextBack = new JLabel("");
		blackTextBack.setBorder(new LineBorder(Color.RED, 3, true));
		blackTextBack.setVerticalAlignment(SwingConstants.TOP);
		blackTextBack.setOpaque(true);
		blackTextBack.setForeground(Color.WHITE);
		blackTextBack.setBackground(Color.DARK_GRAY);
		blackTextBack.setBounds(0, 368, 787, 78);
		contentPane.add(blackTextBack);

		//creates the image used for the select menu
		String bottomSelect = "selectMenu.png";
		ImageIcon menuSelect = new ImageIcon(bottomSelect);

		selectMenu = new JLabel(menuSelect);
		selectMenu.setVisible(false);
		selectMenu.setBackground(Color.GRAY);
		selectMenu.setBounds(0, 445, 776, 318);
		contentPane.add(selectMenu);

		//creates the image used for the move select menu
		String attackMenuSelect = "moveselect.png";
		ImageIcon menuAttack = new ImageIcon(attackMenuSelect);

		attackingMenu = new JLabel(menuAttack);
		attackingMenu.setVisible(false);
		attackingMenu.setBackground(Color.GRAY);
		attackingMenu.setBounds(0, 445, 776, 318);
		contentPane.add(attackingMenu);


		//creates the image used for the empty menu
		String bottom = "emptymenuFinal.png";
		ImageIcon emptyMenu = new ImageIcon(bottom);

		bottomBackNone = new JLabel(emptyMenu);
		bottomBackNone.setVisible(true);
		bottomBackNone.setBackground(Color.GRAY);
		bottomBackNone.setBounds(0, 445, 776, 318);
		contentPane.add(bottomBackNone);

	}
	//this is a method that starts the game intro animation once "OK" is pressed
	public void pokeballAnimation(int countPassed, int countPassed2) {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count == 0) {
					stopwatch.stop();
					textContinueButton.setVisible(false);
					fPlayer.setVisible(false);
					Pokeball.setVisible(true);
					String ballThrow = "PokeballSoundEffect.wav";
					Music pokeThrow = new Music();
					pokeThrow.playMusic(ballThrow);
					stopwatch2.start();
					if(count2 == 0) {
						stopwatch2.stop();
						snivy.setVisible(true);
						narrationText.setText("She chose Snivy!");
						Pokeball.setVisible(false);
						String snivyCry = "CrySnivy.wav";
						Music pokemon1Cry = new Music();
						pokemon1Cry.playMusic(snivyCry);
						rightHP.setVisible(true);
						levelLeft.setVisible(true);
						snivyBar.setVisible(true);
						snivyName.setVisible(true);
						sendOut.setVisible(true);

					}
					else {
						count2 --;
					}

				}
				else {
					textContinueButton.setText(": " + count);
					count --;

				}
			}
		};
		stopwatch = new Timer(delay, action);
		stopwatch.setInitialDelay(0);
		stopwatch.start();
		count = countPassed;

		stopwatch2 = new Timer(delay, action);
		stopwatch2.setInitialDelay(0);
		count2 = countPassed2;

	}

	//this is a method that starts the rest of the game intro animation once "send pokemon" is pressed
	public void pokeballAnimation2(int countPassed, int countPassed2) {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count == 0) {
					stopwatch.stop();
					mPlayer.setVisible(false);
					mPlayerMain.setVisible(true);
					Pokeball2.setVisible(true);
					String ballThrow = "PokeballSoundEffect.wav";
					Music pokeThrow = new Music();
					pokeThrow.playMusic(ballThrow);
					narrationText.setText("Go, Eevee! I choose you!");
					sendOut.setVisible(false);
					stopwatch2.start();
					if(count2 == 0) {
						mPlayerMain.setVisible(false);
						stopwatch2.stop();
						Pokeball2.setVisible(false);
						eevee.setVisible(true);
						String eeveeCry = "CryEevee.wav";
						Music pokemon2Cry = new Music();
						pokemon2Cry.playMusic(eeveeCry);
						leftHP.setVisible(true);
						eeveeName.setVisible(true);
						eeveeBar.setVisible(true);
						levelRight.setVisible(true);
						eeveeMaxHP.setVisible(true);
						eeveeCurrentHP.setVisible(true);
						narrationText.setText("What is Eevee going to do?");
						selectMenu.setVisible(true);
						attackMenuButton.setVisible(true);
						bagButton.setVisible(true);
						runButton.setVisible(true);
						partyButton.setVisible(true);

					}
					else {
						count2 --;
					}

				}
				else {
					textContinueButton.setText(": " + count);
					count --;

				}
			}
		};
		stopwatch = new Timer(delay, action);
		stopwatch.setInitialDelay(0);
		stopwatch.start();
		count = countPassed;

		stopwatch2 = new Timer(delay, action);
		stopwatch2.setInitialDelay(0);
		count2 = countPassed2;

	}
	//this method is what the snivy health bar use to determine how much health it currently has
	public void fillSnivy(int health) {
		String death = "DeathSound.wav";
		Music deathSound = new Music();
		if(health <= 50) {
			snivyBar.setForeground(new Color(255, 255, 0));
		}
		if(health <= 33) {
			snivyBar.setForeground(new Color(255, 0, 0));
		}
		if(health <= 0) {
			snivy.setVisible(false);
			String snivyCry = "CrySnivy.wav";
			Music pokemon1Cry = new Music();
			pokemon1Cry.playMusic(snivyCry);
			deathSound.playMusic(death);
			narrationText.setText("You WON the Game!");
		}
		snivyBar.setValue(health);
	}

	//this method is what the eevee health bar use to determine how much health it currently has
	public void fillEevee(int health) {
		String death = "DeathSound.wav";
		Music deathSound = new Music();
		if(health <= 50) {
			eeveeBar.setForeground(new Color(255, 255, 0));
		}
		if(health <= 33) {
			eeveeBar.setForeground(new Color(255, 0, 0));
		}
		if(health <= 0) {
			eevee.setVisible(false);
			String eeveeCry = "CryEevee.wav";
			Music pokemon2Cry = new Music();
			pokemon2Cry.playMusic(eeveeCry);
			deathSound.playMusic(death);
			narrationText.setText("You LOST the Game!");
		}
		eeveeBar.setValue(health);
	}

	//this HUGE method creates the turns after a move is pressed. It also continues the game and counts the turns played.
	public void moveTurn(int countPassed, int countPassed2, int tCounter) {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count == 0) {
					stopwatch.stop();
					if(tCounter == 0) {
						narrationText.setText("Snivy used Tackle!");
						String move1 = "Tackle.wav";
						move1Sound = new Music();
						move1Sound.playMusic(move1);
						object.tackle(eeveeHealthLV);
						int i = object.getEeveeHealthLV2();
						String s = Integer.toString(i);
						eeveeCurrentHP.setText(s);
						fillEevee(i);
						backButton.setVisible(false);
						selectMenu.setVisible(true);
						bagButton.setVisible(true);
						runButton.setVisible(true);
						partyButton.setVisible(true);
						moveOne.setVisible(false);
						move2.setVisible(false);
						move3.setVisible(false);
						move4.setVisible(false);
						attackMenuButton.setVisible(true);
						
					}

					if(tCounter == 1) {
						int j = object.getSnivyHealthLV1();
						if(j > 0) {
						narrationText.setText("Snivy used Mega Drain!");
						String moveFive = "Mega Drain.wav";
						move5Sound = new Music();
						move5Sound.playMusic(moveFive);
						object.megaDrain(eeveeHealthLV);
						int i = object.getEeveeHealthLV2();
						String s = Integer.toString(i);
						eeveeCurrentHP.setText(s);
						fillEevee(i);
						String k = Integer.toString(j);
						fillSnivy(j);
						}
						
						backButton.setVisible(false);
						selectMenu.setVisible(true);
						bagButton.setVisible(true);
						runButton.setVisible(true);
						partyButton.setVisible(true);
						moveOne.setVisible(false);
						move2.setVisible(false);
						move3.setVisible(false);
						move4.setVisible(false);
						attackMenuButton.setVisible(true);
					}
					
					if(tCounter == 2) {
						int j = object.getSnivyHealthLV1();
						if(j > 0) {
						narrationText.setText("Snivy used Slam!");
						String moveFive = "Slam.wav";
						move5Sound = new Music();
						move5Sound.playMusic(moveFive);
						object.vineWhip(eeveeHealthLV);
						int i = object.getEeveeHealthLV2();
						String s = Integer.toString(i);
						eeveeCurrentHP.setText(s);
						fillEevee(i);
						}
						
						backButton.setVisible(false);
						selectMenu.setVisible(true);
						bagButton.setVisible(true);
						runButton.setVisible(true);
						partyButton.setVisible(true);
						moveOne.setVisible(false);
						move2.setVisible(false);
						move3.setVisible(false);
						move4.setVisible(false);
						attackMenuButton.setVisible(true);
					}
					
					if(tCounter == 3) {
						int j = object.getSnivyHealthLV1();
						if(j > 0) {
						narrationText.setText("Snivy used Vine Whip!");
						String moveFive = "Vine Whip.wav";
						move5Sound = new Music();
						move5Sound.playMusic(moveFive);
						object.vineWhip(eeveeHealthLV);
						int i = object.getEeveeHealthLV2();
						String s = Integer.toString(i);
						eeveeCurrentHP.setText(s);
						fillEevee(i);
						}
						
						backButton.setVisible(false);
						selectMenu.setVisible(true);
						bagButton.setVisible(true);
						runButton.setVisible(true);
						partyButton.setVisible(true);
						moveOne.setVisible(false);
						move2.setVisible(false);
						move3.setVisible(false);
						move4.setVisible(false);
						attackMenuButton.setVisible(true);
					}
					
					if(tCounter == 4) {
						int j = object.getSnivyHealthLV1();
						if(j > 0) {
						narrationText.setText("Snivy used Slam!");
						String moveFive = "Slam.wav";
						move5Sound = new Music();
						move5Sound.playMusic(moveFive);
						object.vineWhip(eeveeHealthLV);
						int i = object.getEeveeHealthLV2();
						String s = Integer.toString(i);
						eeveeCurrentHP.setText(s);
						fillEevee(i);
						}
						
						backButton.setVisible(false);
						selectMenu.setVisible(true);
						bagButton.setVisible(true);
						runButton.setVisible(true);
						partyButton.setVisible(true);
						moveOne.setVisible(false);
						move2.setVisible(false);
						move3.setVisible(false);
						move4.setVisible(false);
						attackMenuButton.setVisible(true);
					}
					
					if(tCounter == 5) {
						int j = object.getSnivyHealthLV1();
						if(j > 0) {
						narrationText.setText("Snivy used Tackle!");
						String move1 = "Tackle.wav";
						move1Sound = new Music();
						move1Sound.playMusic(move1);
						object.tackle(eeveeHealthLV);
						int i = object.getEeveeHealthLV2();
						String s = Integer.toString(i);
						eeveeCurrentHP.setText(s);
						fillEevee(i);
						}
						
						backButton.setVisible(false);
						selectMenu.setVisible(true);
						bagButton.setVisible(true);
						runButton.setVisible(true);
						partyButton.setVisible(true);
						moveOne.setVisible(false);
						move2.setVisible(false);
						move3.setVisible(false);
						move4.setVisible(false);
						attackMenuButton.setVisible(true);
						
					}
					
					if(tCounter == 6) {
						int j = object.getSnivyHealthLV1();
						if(j > 0) {
						narrationText.setText("Snivy used Vine Whip!");
						String moveFive = "Vine Whip.wav";
						move5Sound = new Music();
						move5Sound.playMusic(moveFive);
						object.vineWhip(eeveeHealthLV);
						int i = object.getEeveeHealthLV2();
						String s = Integer.toString(i);
						eeveeCurrentHP.setText(s);
						fillEevee(i);
						}
						
						backButton.setVisible(false);
						selectMenu.setVisible(true);
						bagButton.setVisible(true);
						runButton.setVisible(true);
						partyButton.setVisible(true);
						moveOne.setVisible(false);
						move2.setVisible(false);
						move3.setVisible(false);
						move4.setVisible(false);
						attackMenuButton.setVisible(true);
					}

					stopwatch2.start();
					if(count2 == 0) {
						stopwatch2.stop();
						int i = object.getEeveeHealthLV2();
						int j = object.getSnivyHealthLV1();
						if(i <= 0 ) {
							narrationText.setText("You LOST the Game!");
							backButton.setVisible(false);
							selectMenu.setVisible(false);
							bagButton.setVisible(false);
							runButton.setVisible(false);
							partyButton.setVisible(false);
							moveOne.setVisible(false);
							move2.setVisible(false);
							move3.setVisible(false);
							move4.setVisible(false);
							attackMenuButton.setVisible(false);
							bottomBackNone.setVisible(true);
						}
						if (j <= 0) {
							narrationText.setText("You WON the Game!");
							backButton.setVisible(false);
							selectMenu.setVisible(false);
							bagButton.setVisible(false);
							runButton.setVisible(false);
							partyButton.setVisible(false);
							moveOne.setVisible(false);
							move2.setVisible(false);
							move3.setVisible(false);
							move4.setVisible(false);
							attackMenuButton.setVisible(false);
							bottomBackNone.setVisible(true);
						}
					}
					else {
						count2 --;
					}

				}
				else {
					textContinueButton.setText(": " + count);
					count --;

				}
			}
		};
		stopwatch = new Timer(delay, action);
		stopwatch.setInitialDelay(0);
		stopwatch.start();
		count = countPassed;

		stopwatch2 = new Timer(delay, action);
		stopwatch2.setInitialDelay(0);
		count2 = countPassed2;

	}
}
