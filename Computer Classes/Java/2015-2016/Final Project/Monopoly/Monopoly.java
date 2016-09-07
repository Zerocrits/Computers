import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.net.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.border.*;


public class Monopoly extends JApplet
{
	//sets the main menu, each player, dice, and cards
	Menu menu = new Menu();
	BuildPanel bp;
	ArrayList<Place> place = new ArrayList<Place>();
	Dice dice = new Dice();
	Player p1;
	Player p2;
	ArrayList<String> communityChest = new ArrayList<String>(); //Could change to String[]
	ArrayList<String> chance = new ArrayList<String>(); //Could change to String[]
	boolean hasRolled = false; //checks if player has rolled(helps for toggling player switch)

	//ending a turn

	JButton btnEnd = new JButton("       End Your Turn       ");

	Player player1;
	Player player2;

	//scroll log is individual messages sent to the current player


	//north panel
	JPanel north = new JPanel();
	JLabel money = new JLabel("Cash: 0", JLabel.CENTER);
	JLabel turn = new JLabel("Round: 1", JLabel.CENTER);
	int numRound = 1;
	private int maxRound = 10;

	//east panel
	JPanel east = new JPanel();
	JTextArea log = new JTextArea(60, 21);
	JScrollPane jspLog = new JScrollPane(log);

	//south panel
	JPanel south = new JPanel();
	JPanel playerMessage = new JPanel();
	JLabel message = new JLabel("Welcome to Monopoly!", JLabel.CENTER);
	JPanel command = new JPanel();
	ImageIcon die = new ImageIcon("Dice1");
	MiniMap map = new MiniMap();

	//commands
	private JButton btnBuy = new JButton("Buy Property");
	private JButton btnSell = new JButton("Sell A Property");
	private JButton btnShow = new JButton("Owned Cards");
	private JButton btnRoll = new JButton("Roll Dice");

	//sellList
	DefaultListModel model = new DefaultListModel();
	JList propertylist = new JList(model);
	JScrollPane sp = new JScrollPane(propertylist);
	private JButton okSell = new JButton("Sell Now?");

	//images
	BufferedImage img1 = null; //each image that gets painted onto the game board
	BufferedImage img2 = null;
	BufferedImage img3 = null;
	BufferedImage img4 = null;
	BufferedImage img5 = null;
	BufferedImage img6 = null;
	BufferedImage img7 = null;
	BufferedImage img8 = null;
	BufferedImage img9 = null;
	BufferedImage img10 = null;

	//these buttons show up next to round #
	private JButton pay = new JButton("Pay Fine");
	private JButton btnFJC = new JButton("Use Jail Card");


	public void init()
	{
		setLayout(new BorderLayout());

		//load images
		Image build = getImage(getDocumentBase(), "Map.PNG");

		try
		{
			URL url1 = new URL(getDocumentBase(), "laptop.PNG");
			URL url2 = new URL(getDocumentBase(), "mouse.PNG");
			URL url3 = new URL(getDocumentBase(), "c1.PNG");
			URL url4 = new URL(getDocumentBase(), "c2.PNG");
			URL url5 = new URL(getDocumentBase(), "gotoJail.PNG");
			URL url6 = new URL(getDocumentBase(), "cornerinJail.PNG");
			URL url7 = new URL(getDocumentBase(), "Go.PNG");
			URL url8 = new URL(getDocumentBase(), "parking.PNG");
			URL url9 = new URL(getDocumentBase(), "cc1.PNG");
			URL url10 = new URL(getDocumentBase(), "cc2.PNG");
			img1 = ImageIO.read(url1);
			img2 = ImageIO.read(url2);
			img3 = ImageIO.read(url3);
			img4 = ImageIO.read(url4);
			img5 = ImageIO.read(url5);
			img6 = ImageIO.read(url6);
			img7 = ImageIO.read(url7);
			img8 = ImageIO.read(url8);
			img9 = ImageIO.read(url9);
			img10 = ImageIO.read(url10);
		} catch (IOException e) {}

		bp = new BuildPanel(build);

		addChestCards();
		addChanceCards();
		setTiles();

		for(Place p : place)
			bp.add(p);

		dice.addMouseListener(dt); //display thread
		setSize(1000,848);
		bp.add(dice);

		//East panel
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		east.setOpaque(true);
		east.setBackground(new Color(178,247,178));
		east.setBorder(new MatteBorder(3,6,3,6,new Color(50,126,52)));

		east.add(jspLog); //scroll panel
		east.add(btnEnd);

		//messages
		message.setFont(new Font("Britannic Bold", Font.BOLD, 12));
		message.setPreferredSize(new Dimension(250,100));
		message.setForeground(Color.black);

		//South panel setting
		playerMessage.setOpaque(true);
		playerMessage.setBackground(new Color(178,247,178));
		playerMessage.setLayout(new BoxLayout(playerMessage, BoxLayout.X_AXIS));
		playerMessage.add(message);

		//Commands
		command.setLayout(new GridLayout(2,3,2,2));
		command.setOpaque(true);
		command.setBackground(new Color(50,126,52));
		command.setPreferredSize(new Dimension(100,60));
		command.add(btnBuy);
		command.add(btnSell);
		command.add(btnShow);
		command.add(btnRoll);
		btnBuy.setEnabled(false);

		//South panel
		south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
		south.setOpaque(true);
		south.setBackground(new Color(178,247,178));
		south.setBorder(new MatteBorder(3,6,3,6,new Color(50,126,52)));
		south.add(map);
		south.add(playerMessage);
		south.add(command);

		//Top
		north.setLayout(new BoxLayout(north, BoxLayout.X_AXIS));
		north.setOpaque(true);
		north.setBackground(new Color(178,247,178));
		north.setBorder(new MatteBorder(3,6,3,6,new Color(50,126,52)));
		north.add(Box.createRigidArea(new Dimension(120, 1)));
		north.add(money);
		north.add(Box.createRigidArea(new Dimension(400, 1)));
		north.add(turn);

		//add the menu at the beginning
		add(menu);

		//add button and dice listener
		btnEnd.addActionListener(endList);
		btnBuy.addActionListener(buyList);
		btnSell.addActionListener(sellList);
		btnShow.addActionListener(showList);
		okSell.addActionListener(SellOK);
		btnRoll.addActionListener(diceList);
		pay.addActionListener(paytoJail);
		btnFJC.addActionListener(freeOutOfJail);
		log.setEditable(false);

	}

	//add the players
	public void addPlayer()
	{
		place.get(0).insert(p1);
		place.get(0).insert(p2);
	}

	//add Chest cards
	public void addChestCards()
	{
		communityChest.add(new String("Penalty"));
		communityChest.add(new String("Fined"));
		communityChest.add(new String("Pay"));
	}

	//add Chance cards
	public void addChanceCards()
	{
		chance.add(new String("Birthday"));
		chance.add(new String("Jail"));
		chance.add(new String("Payday"));
	}

	//method for setting up the game after the start button has been pressed
	public void startTheGame(int limit, String name1, String name2)
	{
		remove(menu);
		maxRound = limit;
		add(bp, BorderLayout.CENTER);
		add(east, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);
		add(north, BorderLayout.NORTH);
		p1 = new Player(name1, 1000, img1);
		p2 = new Player(name2, 1000, img2);
		player1 = p1;
		player2 = p2;
		addPlayer();
		log.append(player1.getName() +"'s turn\n");
		validate();
		repaint();
		money.setText("Cash: 1000");
	}

	public void setTiles()
	{
		//bottom
		place.add(new Corner(1, 600, 600, "down", "GO!", img7));
		place.add(new Street(2, 540, 600, "down", "NY Ave", 80, new Color(94, 60, 49)));
		place.add(new CardPlace(3, 480, 600, "down", "Treasure", img9));
		place.add(new Street(4, 420, 600, "down", "Subway", 250, new Color(21, 39, 168)));
		place.add(new Street(5, 360, 600, "down", "Right Bldg", 505, Color.white));
		place.add(new Street(6, 300, 600, "down", "Left Bldg", 406, Color.white));
		place.add(new CardPlace(7, 240, 600, "down", "Question", img3));
		place.add(new Street(8, 180, 600, "down", "VA Ave", 80, new Color(94, 60, 49)));
		place.add(new Street(9, 120, 600, "down", "NJ Ave", 80, new Color(94, 60, 49)));
		place.add(new Corner(10, 0, 600, "down", "JAIL", img6));
		//left
		place.add(new Street(11, 0, 540, "left", "101", 120, new Color(233, 63, 174)));
		place.add(new Street(12, 0, 480, "left", "711", 140, Color.white));
		place.add(new Street(13, 0, 420, "left", "Train Station", 200, Color.white));
		place.add(new Street(14, 0, 360, "left", "502", 140, new Color(233, 63, 174)));
		place.add(new Street(15, 0, 300, "left", "411", 180, Color.gray));
		place.add(new Street(16, 0, 240, "left", "459", 180, new Color(233, 63, 174)));
		place.add(new Street(17, 0, 180, "left", "201", 180, Color.green));
		place.add(new CardPlace(18, 0, 120, "left", "Treasure", img10));
		//top
		place.add(new Corner(19, 0, 0, "up", "PARKING", img8));
		place.add(new Street(20, 120, 0, "up", "503", 220, Color.red));
		place.add(new CardPlace(21, 180, 0, "up", "Question", img3));
		place.add(new Street(22, 240, 0, "up", "Log Town", 200, Color.white));
		place.add(new Street(23, 300, 0, "up", "864", 240, Color.yellow));
		place.add(new Street(24, 360, 0, "up", "947", 240, Color.red));
		place.add(new Street(25, 420, 0, "up", "505", 320, Color.pink));
		place.add(new Street(26, 480, 0, "up", "747", 220, Color.blue));
		place.add(new Street(27, 540, 0, "up", "666", 220, Color.red));
		place.add(new Corner(28, 600, 0, "up", "GOTOJAIL", img5));
		//right
		place.add(new Street(29, 600, 120, "right", "Wishing Well", 200, Color.green));
		place.add(new CardPlace(30, 600, 180, "right", "Treasure", img10));
		place.add(new Street(31, 600, 240, "right", "Goo Lagoon", 200, Color.gray));
		place.add(new CardPlace(32, 600, 300, "right", "Question", img4));
		place.add(new Street(33, 600, 360, "right", "Memory Lane", 450, new Color(21, 39, 168)));
		place.add(new Street(34, 600, 420, "right", "Berdan Ave", 500, new Color(21, 39, 168)));
		place.add(new Street(35, 600, 480, "right", "South Park", 200, Color.white));
		place.add(new Street(36, 600, 540, "right", "Patty's Pub", 200, Color.yellow));
	}

	//listener for the dice
	Action diceList = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			if(hasRolled)
			{
				log.append("You have already thrown the dice\n");
				return;
			}
			Random random = new Random();
			int roll = random.nextInt(6)+1;
			if(player1.isinJail)
			{
				if(roll == 6)
				{
					player1.isinJail = false;
					log.append("You Were Released From Jail!\n");
					north.remove(pay); //paid fine
					north.remove(btnFJC); //use free jail card
				}
				else
					log.append("You Rolled Less Than 6!\n");

				dice.setAmount(roll);
				hasRolled = true;
				btnBuy.setEnabled(false);
				btnRoll.setEnabled(false);
				btnEnd.setEnabled(true);
				return;
			}
			for(Place p : place)
			{
				if(p.checkPOS(player1))
					p.putinJail(player1);
			}
			player1.setPlan(roll); //checks roll
			for(Place p : place)
			{
				if(p.getNum() == player1.getPlan())
					p.insert(player1);
			}
			dice.setAmount(roll);
			hasRolled = true;
			log.append(player1.getName() + "'s rolled a " + dice.getAmount() + "\n");
			runPlaceEvents();
			btnBuy.setEnabled(true);
			btnRoll.setEnabled(false);
			btnEnd.setEnabled(true);
		}
	};

	//what happens after a player has thrown the dice
	public void runPlaceEvents()
	{
		Place pl = place.get(player1.getPlan()-1);
		javax.swing.Timer time;
		if(pl instanceof Street || pl instanceof ResourcePlace) //instance of references back to check name of card
		{
			message.setText("Room: " + pl.getName());
			message.setForeground(pl.getColor());
		}

		else if(pl.getName().equals("JAIL"))
			log.append("Just visiting the Jail\n");

		else if(pl.getName().equals("GOTOJAIL"))
		{
			log.append("You are now in Jail!");
			btnEnd.setEnabled(false);
			time = new javax.swing.Timer(1000, goinJail);
			time.setRepeats(false);
			time.start();
		}

		if(player2.propertyExists(pl))
		{
			int penalty = pl.getCost()/2; //penalty for landing on their spot
			log.append("" + player2.getName() +" Own's this spot. You must pay them $" + penalty + "!\n");
			player1.setMoney(-(penalty));
			player2.setMoney(penalty);
			money.setText("Cash: " + player1.getMoney());
		}

		else if(pl.getName().equals("PARKING"))
			log.append("Just parking for free\n"); //plan for more interaction from this spot

		else if(pl instanceof CardPlace) //when you land on a chest/chance spot
		{								//Implement Cardlayout with image showing what card was selected.
			btnEnd.setEnabled(false);
			if(pl.getName().equals("Treasure"))
			{
				time = new javax.swing.Timer(1000, drawChest);
				time.setRepeats(false);
				log.append("*Reaches for Community Chest Card*\n");
				time.start();
			}
			else if(pl.getName().equals("Question"))
			{
				time = new javax.swing.Timer(1000, drawChance);
				time.setRepeats(false);
				log.append("*Reaches for Chance Card*\n");
				time.start();
			}
		}
		if(pl.getName().equals("GO!") || player1.hasRounded())
		{
			player1.setMoney(200);
			money.setText("Cash: " + player1.getMoney());
			log.append(player1.getName()+" has passed GO and collects $200!\n");
		}
	}

	//Player goes to jail
	Action goinJail = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			for(Place p : place)
			{
				if(p.checkPOS(player1))
					p.putinJail(player1);
			}
			place.get(9).insert(player1);
			player1.isinJail = true;
			player1.setDirectPosition(10);
			btnEnd.setEnabled(true);
			btnBuy.setEnabled(false);
			btnRoll.setEnabled(false);
		}
	};

	//there are three ways to leave jail, roll a six on the dice, pay 200 or use a "Free Jail Card(FJC)"

	//player pays to get out of jail
	Action paytoJail = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			player1.setMoney(-200);
			money.setText("Cash: " + player1.getMoney());
			player1.isinJail = false;
			log.append("You are free now!\n");
			north.remove(pay);
			north.remove(btnFJC);
			btnRoll.setEnabled(false);
			hasRolled = true;
		}
	};

	//player uses a "Free out of Jail" card
	Action freeOutOfJail = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			player1.isinJail = false;
			player1.haveJC = false;
			log.append("You are free now!\n");
			north.remove(pay);
			north.remove(btnFJC);
			btnRoll.setEnabled(false);
			hasRolled = true;
		}
	};

	//RandomouseListener draw a Community Chest Card
	Action drawChest = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			//playerMessage.setBackground(Color.blue); //sets background of playermessage
			message.setForeground(Color.red);
			log.append("Card Picked up!\n");
			Random random = new Random();
			int i = random.nextInt(3);
			String phrase = communityChest.get(i);

			if(phrase.equals("Penalty"))
			{
				message.setText("Tax Time! You owe $80!");
				player1.setMoney(-80);
				money.setText("Cash: " + String.valueOf(player1.getMoney()));
			}
			else if(phrase.equals("Fined"))
			{
				message.setText("You're Being Audited! You must pay $100!");
				player1.setMoney(-100);
				money.setText("Cash: " + String.valueOf(player1.getMoney()));
			}
			else if(phrase.equals("Pay"))
			{
				message.setText("Income tax refunded. $200 collected!");
				player1.setMoney(200);
				money.setText("Cash: " + String.valueOf(player1.getMoney()));
			}
			btnEnd.setEnabled(true);
		}
	};

	//RandomouseListener draw a Chance card
	Action drawChance = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			//playerMessage.setBackground(Color.orange); //Sets the background of playermessage
			message.setForeground(Color.red);
			log.append("Your card reads:!\n");
			Random random = new Random();
			int size = chance.size();
			int i = random.nextInt(size);
			String phrase = chance.get(i);

			if(phrase.equals("Birthday"))
			{
				message.setText("Happy Birthday " + player1.getName() + "!\n");
				player1.setMoney(20);
				player2.setMoney(-20);
				money.setText("Cash: " + String.valueOf(player1.getMoney()));
			}
			else if(phrase.equals("Jail"))
			{
				message.setText("A Corrupt Politician dropped something...\nYou now have a Free Jail card!\n");
				player1.haveJC = true;
			}
			else if(phrase.equals("Payday"))
			{
				message.setText("Your tenants pay you for being such a good landlord!\n");
				ArrayList<Place> property = player1.getProperty();
				int cash = 0;
				for(Place p : property)
					cash += 10; //pays $10 for each house owned
				player1.setMoney(cash);
				money.setText("Cash: " + String.valueOf(player1.getMoney()));
			}
			btnEnd.setEnabled(true);
		}
	};

	//lists all cards player selected owns
	Action showList = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			playerMessage.removeAll();
			playerMessage.add(message);
			message.setText("Tracking Cards...");
			message.setForeground(Color.black);
			ArrayList<Place> property = player1.getProperty();
			log.append("---------------Cards Owned---------------\n\n");
			for(Place p : property)
			{
				log.append("-----------------------------------------\n");
				log.append("  Room : " + p.getName() + "\n  Cost: " + p.getCost() + "\n  Sell cost: " + (p.getCost()/2)+"\n");
			}
		}
	};

	//Listener to the sell button
	Action sellList = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			playerMessage.removeAll();
			playerMessage.add(sp);
			playerMessage.add(okSell);
			sp.setPreferredSize(new Dimension(100,100));
			model.clear();
			ArrayList<Place> property = player1.getProperty();
			for(Place p : property) //adds owned properties to list
			{
				model.addElement(p);
			}
		}
	};

	//listener to the sell button
	Action SellOK = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			Place p =(Place) propertylist.getSelectedValue();
			if(p == null)
				return;
			log.append("Room " + p.getName() + " sold to the Bank\n");
			player1.sellProperty(p);
			model.removeElement(p);
			player1.setMoney((p.getCost() /2));
			money.setText("Cash: " + player1.getMoney());
			p.setBorderColor(Color.black);
			map.setColorOnBrick(p.getNum(), Color.white);
		}
	};

	//After emd turn button, swaps between "player1" and "player2"

	//listener to the "End turn" button
	Action endList = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			if(!hasRolled)
			{
				log.append("You have not thrown the dice!\n");
				return;
			}
			playerMessage.removeAll();
			playerMessage.add(message);
			message.setText("Roll The Dice!");
			message.setForeground(Color.black);
			if(player1 == p1)
			{
				player1 = p2;
				player2 = p1;
			}
			else if(player1 == p2)
			{
				player1 = p1;
				player2 = p2;
				turn.setText("Round: " + String.valueOf(++numRound));

			}
			if(numRound == maxRound)
			{
				log.setText("Round: Limit Reached!");
				if(player1.getMoney()>player2.getMoney())
					message.setText(player1.getName()+" Won the Game!!!");
				else if(player2.getMoney()>player1.getMoney())
					message.setText(player2.getName()+" Won the Game!!!");
				else
					message.setText("Game Tied...!");
				disableAll();
				return;
			}
			hasRolled = false;
			log.setText(player1.getName() + "'s turn\n");
			int cash = player1.getMoney()+player1.getIncome();
			player1.setMoney(player1.getIncome());
			money.setText("Cash: " + String.valueOf(cash));

			if(player1.isinJail)
			{
				log.append("You must roll a 6\n or pay $200 to get out!\n");
				if(player1.getMoney() >= 200)
					north.add(pay);
				if(player1.haveJC)
					north.add(btnFJC);
			}
			else
			{
				north.remove(btnFJC);
				north.remove(pay);
			}

			btnBuy.setEnabled(false);
			btnRoll.setEnabled(true);
		}
	};

	//Listener to the "Buy" button
	Action buyList = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			Place p = place.get(player1.getPlan()-1);
			playerMessage.removeAll();
			playerMessage.add(message);
			if(player1.propertyExists(p))
			{
				log.append("You already own " + p.getName()+"!\n");
				return;
			}
			else if(p instanceof Corner || p instanceof CardPlace)
			{
				log.append("You cannot buy that!\n");
				return;
			}
			else if(player2.propertyExists(p))
			{
				log.append(p.getName()+" is already ownd by "+player2.getName()+"!\n");
				return;
			}
			else if(player1.getMoney() < p.getCost())
			{
				log.append("Insufficient amount of money!\n");
				return;
			}
			message.setForeground(p.getColor());
			message.setText(p.getName());
			player1.buyProperty(p);
			if(player1 == p1)
			{
				p.setBorderColor(Color.blue);
				map.setColorOnBrick(p.getNum(), Color.blue);
			}
			else if(player1 == p2)
			{
				p.setBorderColor(Color.red);
				map.setColorOnBrick(p.getNum(), Color.red);
			}

			player1.setMoney(-(p.getCost()));
			money.setText("Cash: " + String.valueOf(player1.getMoney()));
			log.append(player1.getName() + "'s has bought "+p.getName()+"\n");
			btnBuy.setEnabled(false);
		}
	};

	//MouseListener to the dice
	MouseListener dt = new MouseAdapter()
	{
		public void mouseClicked(MouseEvent e)
		{
			if(hasRolled)
			{
				log.append("You have already thrown the dice!\n");
				return;
			}
			btnEnd.setEnabled(false);
			javax.swing.Timer time = new javax.swing.Timer(2000, diceList);
			log.append(player1.getName()+" is throwing the dice\n");
			time.setRepeats(false);
			time.start();
		}
	};

	//method disabling all the buttons after the end of the game
	public void disableAll()
	{
		btnBuy.setEnabled(false);
		btnSell.setEnabled(false);
		btnShow.setEnabled(false);
		btnRoll.setEnabled(false);
		remove(pay);
		remove(btnFJC);
		btnEnd.setEnabled(false);
		dice.removeMouseListener(dt);
	}

	//main menu
	class Menu extends JPanel
	{
		private ImageIcon imgMonopoly = new ImageIcon("monopoly.PNG");
		private JLabel title = new JLabel(imgMonopoly);
		private JPanel menu = new JPanel();
		private JButton btnStart = new JButton();
		private JLabel startText = new JLabel("Start new game", JLabel.CENTER);

		private JPanel game = new JPanel();
		private JTextField name1 = new JTextField(9);
		private JTextField name2 = new JTextField(9);
		private String[] limits = {"100000", "100","80","60", "40", "20"};
		private JComboBox box = new JComboBox(limits); //dropdown menu
		private JLabel start = new JLabel("Start Game", JLabel.CENTER);
		private JLabel back = new JLabel("Back", JLabel.CENTER);

		public Menu()
		{
			setLayout(new GridLayout(2,1,10,10));
			setOpaque(true);
			setBackground(new Color(178,247,178));
			title.setFont(new Font("Arial Black", Font.BOLD, 60));
			btnStart = new JButton("Start");
			btnStart.setFont(new Font("Britannic Bold", Font.BOLD, 132));
			title.setForeground(Color.white);
			title.setOpaque(true);
			title.setBackground(Color.red);
			title.setBorder(new MatteBorder(5,5,5,5,Color.white));
			add(title);

			menu.setLayout(new GridLayout(1,0));
			menu.setOpaque(true);
			menu.setBackground(new Color(178,247,178));
			menu.add(btnStart);
			add(menu);

			game.setLayout(new BoxLayout(game, BoxLayout.Y_AXIS));
			game.setOpaque(true);
			game.setBackground(new Color(178,247,178));
			name1.setFont(new Font("Serif", Font.BOLD, 23));
			name2.setFont(new Font("Serif", Font.BOLD, 23));
			name1.setMinimumSize(name1.getPreferredSize());
			name2.setMinimumSize(name2.getPreferredSize());
			box.setPreferredSize(new Dimension(100,20));
			game.add(new JLabel("Player 1", JLabel.CENTER));
			game.add(name1);
			game.add(new JLabel("Player 2", JLabel.CENTER));
			game.add(name2);
			game.add(new JLabel("Choose Round limit"));
			game.add(box);
			game.add(start);
			game.add(back);
			back.addMouseListener(mouseListener);
			start.addMouseListener(mouseListener);
			btnStart.addActionListener(new ButtonListener());
		}

		private class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				Object source = new Object();
				source = event.getSource();
				if(source == btnStart)
				{
					remove(menu);
					add(game); //removes main menu layout and launches the game
					validate(); //validates container and subcomponents
					repaint();
					btnStart.setForeground(Color.black);
				}
			}
		}

		MouseListener mouseListener = new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				JLabel source = (JLabel)e.getSource();
				source.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				source.setForeground(Color.red);
			}

			public void mouseExited(MouseEvent e)
			{
				JLabel source = (JLabel)e.getSource();
				source.setForeground(Color.black);
			}
			public void mouseClicked(MouseEvent e)
			{
				Object source = new Object();
				source = e.getSource();
				if(source == back)
				{
					remove(game);
					add(menu);
					validate();
					repaint();
					back.setForeground(Color.black);
				}
				else if(source == start)
				{
					String player1 = name1.getText();
					String player2 = name2.getText();
					String roundLength = (String)box.getSelectedItem();
					int numberRounds = Integer.parseInt(roundLength);
					startTheGame(numberRounds, player1, player2);
				}
			}
		};
	}
}









