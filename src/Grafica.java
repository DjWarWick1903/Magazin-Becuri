import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import javax.swing.event.*;
import java.util.List;
import java.util.ArrayList;

class Grafica {
  static class IUG extends JFrame {
	static boolean adminPriv = false;

	//componentele ferestrei principale
	static JPanel fereastraPr = new JPanel(new BorderLayout());
    static JPanel optiuni = new JPanel(new GridLayout(3,1));
    static JPanel nord = new JPanel(new GridLayout(1,3,3,3));
    static JList lista;
    static JScrollPane scroll;
    static JComboBox comboDist, comboLum, comboTip;
    static JButton cautare, adaugare, stergere;
    static JLabel descriere, image;
    static Becuri[] obiecte;
    static double pretIn;

    //componentele ferestrei de login
    static JPanel mainPanel, loginPanel, imagePanel, buttonPanel;
    static ImageIcon imagePathLog = new ImageIcon(new ImageIcon("logo.png").getImage().getScaledInstance(150, 160, Image.SCALE_DEFAULT));
    static JLabel user_label, password_label;
    static JLabel imagine = new JLabel(imagePathLog);
    static JTextField userName_text;
    static JPasswordField password_text;
    static JButton submit, cancel, nou;

    //componentele ferestrei de cont nou (unele elemente fiind folosite din cele login)
    static ImageIcon imagePath = new ImageIcon(new ImageIcon("logo.png").getImage().getScaledInstance(150, 160, Image.SCALE_DEFAULT));
    static JPanel contPanel, datePanel, imaginePanel, butoanePanel;
    static JLabel usnLabel, pwLabel, pwvLabel;
    static JTextField usnText;
    static JLabel imageP = new JLabel(imagePath);
    static JPasswordField pwText, pwvText;
    static JButton creare, cancelC;


    //componentele ferestrei de adaugare produse
    static JPanel date, mainPanelAdd,butoane;
	  static JLabel instructiuni, modelLab, prodLab, pretLab, distLab;
	  static JTextField model, prod, pret, dist;
  	static JButton submitAdd, cancelAdd;

    static String selectAOD = "Toate", selectAOT = "Toate", selectAOL = "Toate";
    static int total, totalFis;
    static List<Becuri> ls = new ArrayList<>();

    //metoda care actualizeaza lista de produse la schimbarea unui comboBox
    private static void update() {
    	Becuri[] prod = obiecte;
    	ls.clear();
    	int nr = 0;

    	for(int i = 0; i < totalFis; i++) {
    		if((prod[i].getModel().equals(selectAOT)) && (prod[i].getLumina().equals(selectAOL)) && (prod[i].getDist().equals(selectAOD))) {
    			nr++;
    		}
    		else
    		if((prod[i].getModel().equals(selectAOT)) && (prod[i].getLumina().equals(selectAOL)) && ("Toate" == selectAOD)) {
    			nr++;
    		}
    		else
    		if((prod[i].getModel().equals(selectAOT)) && ("Toate" == selectAOL) && (prod[i].getDist().equals(selectAOD))) {
    			nr++;
    		}
    		else
    		if(("Toate" == selectAOT) && (prod[i].getLumina().equals(selectAOL)) && (prod[i].getDist().equals(selectAOD))) {
    			nr++;
    		}
    		else
        	if(("Toate" == selectAOT) && (prod[i].getLumina().equals(selectAOL)) && ("Toate" == selectAOD)) {
        		nr++;
        	}
        	else
            if((prod[i].getModel().equals(selectAOT)) && ("Toate" == selectAOL) && ("Toate" == selectAOD)) {
            	nr++;
            }
            else
            if(("Toate" == selectAOT) && ("Toate" == selectAOL) &&  (prod[i].getDist().equals(selectAOD))) {
                nr++;
            }
    		else
    		if(("Toate" == selectAOT) && ("Toate" == selectAOL) && ("Toate" == selectAOD)) {
    			nr = totalFis;
    			i = totalFis-1;
    		}
    	}

    	total = nr;

    	String[] com = new String[nr];
    	int nr1 = 0;
    	for(int i = 0; i < totalFis; i++) {
    		if((prod[i].getModel().equals(selectAOT)) && (prod[i].getLumina().equals(selectAOL)) && (prod[i].getDist().equals(selectAOD)) && (nr1 < nr)) {
    			com[nr1] = prod[i].getAfisare();
    			ls.add(nr1,prod[i]);
    			nr1++;
    		}
    		else
    		if((prod[i].getModel().equals(selectAOT)) && (prod[i].getLumina().equals(selectAOL)) && ("Toate" == selectAOD)) {
    			com[nr1] = prod[i].getAfisare();
    			ls.add(nr1,prod[i]);
    			nr1++;
    		}
    		else
    		if((prod[i].getModel().equals(selectAOT)) && ("Toate" == selectAOL) && (prod[i].getDist().equals(selectAOD)) && (nr1 < nr)) {
    			com[nr1] = prod[i].getAfisare();
    			ls.add(nr1,prod[i]);
    			nr1++;
    		}
    		else
    		if(("Toate" == selectAOT) && (prod[i].getLumina().equals(selectAOL)) && (prod[i].getDist().equals(selectAOD)) && (nr1 < nr)) {
    			com[nr1] = prod[i].getAfisare();
    			ls.add(nr1,prod[i]);
    			nr1++;
    		}
    		else
    		if(("Toate" == selectAOT) && (prod[i].getLumina().equals(selectAOL)) && ("Toate" == selectAOD) && (nr1 < nr)) {
    			com[nr1] = prod[i].getAfisare();
    			ls.add(nr1,prod[i]);
    			nr1++;
    		}
    		else
            if((prod[i].getModel().equals(selectAOT)) && ("Toate" == selectAOL) && ("Toate" == selectAOD) && (nr1 < nr)) {
        		com[nr1] = prod[i].getAfisare();
        		ls.add(nr1,prod[i]);
        		nr1++;
        	}
        	else
            if(("Toate" == selectAOT) && ("Toate" == selectAOL) &&  (prod[i].getDist().equals(selectAOD)) && (nr1 < nr)) {
            	com[nr1] = prod[i].getAfisare();
            	ls.add(nr1,prod[i]);
            	nr1++;
            }
    		else
    		if(("Toate" == selectAOT) && ("Toate" == selectAOL) && ("Toate" == selectAOD)) {
    			com[i] = prod[i].getAfisare();
    			ls.add(i,prod[i]);
    		}
    	}

      lista.setListData(com);
      scroll.setViewportView(lista);
    }

    //metoda care actualizeaza lista de produse la cautarea dupa pret
    private static void updatePret() {
    	Becuri[] prod = obiecte;
    	ls.clear();
    	int nr = 0;
    	for(int i = 0; i < totalFis; i++)
    		if(prod[i].getPret() <= pretIn)
    			nr++;

    	total = nr;

    	String[] com = new String[nr];
    	int nr1 = 0;

    	for(int i = 0; i < totalFis; i++)
    	{
    		if((prod[i].getPret() <= pretIn) && (nr1 < nr)) {
    		com[nr1] = prod[i].getAfisare();
			ls.add(nr1,prod[i]);
			nr1++;
    		}
    	}

    	if(comboTip.getSelectedItem() != "Toate")
    	comboTip.setSelectedItem("Toate");
    	if(comboLum.getSelectedItem() != "Toate")
    	comboLum.setSelectedItem("Toate");
    	if(comboDist.getSelectedItem() != "Toate")
    	comboDist.setSelectedItem("Toate");

    	lista.setListData(com);
    	scroll.setViewportView(lista);
    }

    //metoda care afla care gestioneaza informatiile noi si adauga produsul rezultat in fisier
    private static void addCont(Becuri obj) {
    	try {
    	ArrayList<ArrayList> inst = readInstante();
		  ArrayList<BecLED> led = (ArrayList<BecLED>) inst.get(0);
	  	ArrayList<BecClasic> clasic = (ArrayList<BecClasic>) inst.get(1);
		  ArrayList<BecEconomic> eco = (ArrayList<BecEconomic>) inst.get(2);
	  	ArrayList<BecNeon> neon = (ArrayList<BecNeon>) inst.get(3);

		  if(obj.getModel().equals("LED"))
			  led.add((BecLED)obj);
		  else
		  if(obj.getModel().equals("Clasic"))
			  clasic.add((BecClasic)obj);
	  	else
		  if(obj.getModel().equals("Economic"))
			  eco.add((BecEconomic)obj);
	  	else
		  if(obj.getModel().equals("Neon"))
			  neon.add((BecNeon)obj);

	  	inst.clear();

		  inst.add(led);
	  	inst.add(clasic);
	  	inst.add(eco);
	  	inst.add(neon);
	  	writeInst(inst);

	  	continut();
	  	update();

    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    //metoda care sterge un produs din fisier
    private static void deleteInstante(Becuri obj) {
    	try {
    	  ArrayList<ArrayList> inst = readInstante();
    	  ArrayList<BecLED> led = (ArrayList<BecLED>) inst.get(0);
    	  ArrayList<BecClasic> clasic = (ArrayList<BecClasic>) inst.get(1);
    	  ArrayList<BecEconomic> eco = (ArrayList<BecEconomic>) inst.get(2);
    	  ArrayList<BecNeon> neon = (ArrayList<BecNeon>) inst.get(3);

    	  if(obj.getModel().equals("LED"))
    		  for(int i = 0; i < led.size(); i++) {
    			  if(led.get(i).getID() == obj.getID())
    			     led.remove(led.get(i));
    		  }
    	  else if(obj.getModel().equals("Clasic"))
    		  for(int i = 0; i < clasic.size(); i++) {
    			  if(clasic.get(i).getID() == obj.getID())
    			     clasic.remove(clasic.get(i));
    		  }
    	  else if(obj.getModel().equals("Economic"))
    		  for(int i = 0; i < eco.size(); i++) {
    			  if(eco.get(i).getID() == obj.getID())
    			     eco.remove(eco.get(i));
    		  }
    	  else if(obj.getModel().equals("Neon"))
    		  for(int i = 0; i < neon.size(); i++) {
    			  if(neon.get(i).getID() == obj.getID())
    			     neon.remove(neon.get(i));
    		  }

    	  inst.clear();

    	  inst.add(led);
    	  inst.add(clasic);
    	  inst.add(eco);
    	  inst.add(neon);

    	  writeInst(inst);
    	} catch (Exception e) {
    	  e.printStackTrace();
    	}
    	}

    //metoda propriu zisa ce introduce un produs nou in fisier
    private static void writeInst(ArrayList<ArrayList> instante) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Produse.bin"));
			oos.writeObject(instante);
			oos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

    //metoda care citeste si aduce produsele din fisier
    private static void continut() {
    	try {
    		ArrayList<ArrayList> inst = readInstante();
    		ArrayList<BecLED> led = (ArrayList<BecLED>) inst.get(0);
    		ArrayList<BecClasic> clasic = (ArrayList<BecClasic>) inst.get(1);
    		ArrayList<BecEconomic> eco = (ArrayList<BecEconomic>) inst.get(2);
    		ArrayList<BecNeon> neon = (ArrayList<BecNeon>) inst.get(3);

    		totalFis = led.size() + clasic.size() + eco.size() + neon.size();
    		Becuri[] prod = new Becuri[totalFis];
    		int nr = 0;

    		for(int i = 0; i < led.size(); i++) {
    			prod[nr] = led.get(i);
    			nr++;
    		}

    		for(int i = 0; i < clasic.size(); i++) {
    			prod[nr] = clasic.get(i);
    			nr++;
    		}

    		for(int i = 0; i < eco.size(); i++) {
    			prod[nr] = eco.get(i);
    			nr++;
    		}

    		for(int i = 0; i < neon.size(); i++) {
    			prod[nr] = neon.get(i);
    			nr++;
    		}

    		obiecte = prod;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    private static String[] convOb(Becuri[] obj) {
      String nume[] = new String[total];
      for(int i = 0; i < total; i++)
        nume[i] = obj[i].getAfisare();
      return nume;
    }

    //constructorul clasei de interfata
    IUG(String titlu) {
      super(titlu);
      InitMenu();
      InitLog();
      InitNou();
      InitAdd();
    }

    //metoda care genereaza panoul de creare cont
    private void InitNou() {
    	//Username
    	usnLabel = new JLabel();
    	usnLabel.setText("Username: ");
    	usnText = new JTextField();

    	//Password
    	pwLabel = new JLabel();
    	pwLabel.setText("Password: ");
    	pwText = new JPasswordField();

    	//Password check
    	pwvLabel = new JLabel();
    	pwvLabel.setText("Confirmati: ");
    	pwvText = new JPasswordField();

    	datePanel = new JPanel(new GridLayout(3,2,2,2));
    	datePanel.add(usnLabel);
    	datePanel.add(usnText);
    	datePanel.add(pwLabel);
    	datePanel.add(pwText);
    	datePanel.add(pwvLabel);
    	datePanel.add(pwvText);

    	//Buttons
    	creare = new JButton("Creare cont");
    	cancelC = new JButton("Cancel");
    	butoanePanel = new JPanel(new GridLayout(1,2));
    	butoanePanel.add(creare);
    	butoanePanel.add(cancelC);

    	contPanel = new JPanel(new BorderLayout());
    	contPanel.add(imageP,BorderLayout.NORTH);
    	contPanel.add(datePanel,BorderLayout.CENTER);

    	//adaugarea ascultatorilor
    	creare.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if((!usnText.getText().isEmpty()) && (!pwText.getText().isEmpty()) && (pwText.getText().equals(pwvText.getText())))
    			{
    				try {
    				Conturi cont = new Conturi(usnText.getText(), pwText.getText());
    				ArrayList<Conturi> lista = readAcc();
    				lista.add(cont);
    				writeAcc(lista);
    				JOptionPane.showMessageDialog(contPanel, "Buna " + usnText.getText() + "!");
    		    	adminPriv = true;
    		    	changePanel(fereastraPr);
    		    	setTitle("Produse");
    		    	setSize(400,400);
    				} catch(Exception ex) {
    					ex.printStackTrace();
    				}
    			}
    			else if((usnText.getText().isEmpty()) || (pwText.getText().isEmpty()) || (pwvText.getText().isEmpty()))
    				JOptionPane.showMessageDialog(contPanel, "Completati toate casutele!");
    			else if(!pwText.getText().equals(pwvText.getText()))
    				JOptionPane.showMessageDialog(contPanel, "Introduceti aceeasi parola in ambele casute!");
    		}
    	});

    	cancelC.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			changePanel(mainPanel);
    			setTitle("Login");
    			setSize(300,280);
    		}
    	});

    	contPanel.add(butoanePanel,BorderLayout.SOUTH);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //metoda care creeaza panoul de login
    private void InitLog() {
    	//Username
        user_label = new JLabel();
        user_label.setText("Username: ");
        userName_text = new JTextField();

        //Password
        password_label = new JLabel();
        password_label.setText("Password: ");
        password_text = new JPasswordField();

        loginPanel = new JPanel(new GridLayout(2,2,2,2));
        loginPanel.add(user_label);
        loginPanel.add(userName_text);
        loginPanel.add(password_label);
        loginPanel.add(password_text);

        //Buttons
        nou = new JButton("Cont nou");
        submit = new JButton("Submit");
        cancel = new JButton("Cancel");
        buttonPanel = new JPanel(new GridLayout(1,3));
        buttonPanel.add(submit);
        buttonPanel.add(nou);
        buttonPanel.add(cancel);

        //Introducerea componentelor in fereastra
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(imagine,BorderLayout.NORTH);
        mainPanel.add(loginPanel,BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding listeners to components...
        submit.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        		 try {
        		    String userName = userName_text.getText();
        		    String password = password_text.getText();
        		    ArrayList<Conturi> conturi = readAcc();
        		    int nr = 0;
        		    boolean conditie = false;

        		    while(nr < conturi.size()) {
        		    if(userName.trim().equals(conturi.get(nr).getUser()) && password.trim().equals(conturi.get(nr).getPass())) {
        		    	JOptionPane.showMessageDialog(mainPanel, "Buna " + userName + "!");
        		    	adminPriv = true;
        		    	conditie = true;
        		    	changePanel(fereastraPr);
        		    	setTitle("Produse");
        		    	setSize(400,400);
        		    	break;
        		    }
        		    nr++;
        		    }

        		    if(conditie == false)
        		    	if(userName.trim().equals("admin") && password.trim().equals("admin"))
        		    	{
        		    		JOptionPane.showMessageDialog(mainPanel, "Buna " + userName + "!");
            		    	adminPriv = true;
            		    	changePanel(fereastraPr);
            		    	setTitle("Produse");
            		    	setSize(400,400);
        		    	}
        		    	else
        		    	{
        		    		String dialog = new String("Utilizator inexistent");
            		    	JOptionPane.showMessageDialog(mainPanel, dialog);
        		    	}
        		  }	catch(Exception ex) {
        			  ex.printStackTrace();
        		  }
        	 }
        });

        nou.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		changePanel(contPanel);
        		setSize(300,300);
        		setTitle("Cont nou");
        	}
        });

        cancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		changePanel(fereastraPr);
        		setTitle("Produse");
        		setSize(400,400);
        	}
        });

        mainPanel.add(buttonPanel,BorderLayout.SOUTH);
    }

    //metoda care creeaza panoul meniului principal
    private void InitMenu() {
    	continut();
        String[] comp = convOb(obiecte);
        lista = new JList(comp);
        lista.setBorder(BorderFactory.createTitledBorder("Lista produselor"));
        lista.addListSelectionListener(new ListSelectionListener() {
      	  public void valueChanged(ListSelectionEvent e) {
      		for(int i = 0; i < total; i++) {
      			Becuri b = ls.get(i);
      			String a = lista.getSelectedValue().toString();
      			if(b.getAfisare().equals(a)) {
      				descriere.setText("<html>" + b.getDescriere() + "</html>");
      				break;
      			}
      		}
      	 }
        });

        //crearea zonei de nord
        stergere = new JButton("Sterge un produs");
        cautare = new JButton("Cauta dupa pret");
        adaugare = new JButton("Adauga un produs");
        nord.add(stergere);
        nord.add(cautare);
        nord.add(adaugare);

        //adaugarea ascultatorului pentru butonul de cautare dupa pret
        stergere.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(lista.getSelectedValue() == null)
        		JOptionPane.showMessageDialog(fereastraPr, "Alegeti un produs!");
        		else {
        		String a = lista.getSelectedValue().toString();
        		for(int i = 0; i < totalFis; i++) {
        			if(obiecte[i].getAfisare().equals(lista.getSelectedValue().toString())) {
        				deleteInstante(obiecte[i]);
        				continut();
        		    	update();
        		    	if(totalFis == 0)
        		    		descriere.setText("Selectati un articol.");
        			}
        		}
        		}
        	}
        });

        cautare.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		pretIn = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduceti un pret: "));
        		if(pretIn > 0)
        		updatePret();
        		else if(pretIn <= 0)
        	    {
        			String dialog = new String("Introduceti o suma mai mare decat 0!");
		    	    JOptionPane.showMessageDialog(fereastraPr, dialog);
		    	}
        	}
        });

        //adaugarea ascultatorului pentru butonul de adaugare
        adaugare.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(adminPriv == false) {
        			changePanel(mainPanel);
        		    setSize(300,280);
        		    setTitle("Login");
        		}
        		else if(adminPriv == true) {
        			changePanel(mainPanelAdd);
        			setSize(300,200);
        	  		setTitle("Adaugare produse");
        		}
        	}
        });

        fereastraPr.add(nord,BorderLayout.NORTH);

        //crearea panoului cu produsele aferente
        scroll = new JScrollPane(lista);
        fereastraPr.add(scroll, BorderLayout.CENTER);
        update();

        //Se creeaza listele ascunse ale optiunilor
        String tipuri[] = {"Toate", "LED", "Neon", "Clasic", "Economic"};
        String distribuitori[] = {"Toate", "EMAG", "Flanco", "Altex"};
        String producatori[] = {"Toate", "neutra", "calda", "rece"};
        comboTip = new JComboBox<String>(tipuri);
        comboTip.setBorder(BorderFactory.createTitledBorder("Tipuri becuri"));
        comboTip.addActionListener(new ActionListener () {
      	  public void actionPerformed(ActionEvent e) {
      		  selectAOT = comboTip.getSelectedItem().toString();
      		  update();
      	  }
        });
        optiuni.add(comboTip);

        comboLum = new JComboBox(producatori);
        comboLum.setBorder(BorderFactory.createTitledBorder("Tipuri lumina"));
        comboLum.addActionListener(new ActionListener () {
      	  public void actionPerformed(ActionEvent e) {
      		selectAOL = comboLum.getSelectedItem().toString();
    	    	update();
      	  }
        });
        optiuni.add(comboLum);

        comboDist = new JComboBox(distribuitori);
        comboDist.setBorder(BorderFactory.createTitledBorder("Distribuitori"));
        comboDist.addActionListener(new ActionListener () {
      	  public void actionPerformed(ActionEvent e) {
      		selectAOD = comboDist.getSelectedItem().toString();
    	    	update();
      	  }
        });
        optiuni.add(comboDist);

        fereastraPr.add(optiuni,BorderLayout.EAST);

        // crearea unui label unde se descriu produsele
        descriere = new JLabel("Selectati un articol.");
        descriere.setPreferredSize(new Dimension(400,60));
        descriere.setBorder(BorderFactory.createTitledBorder("Descrierea produselor"));
        fereastraPr.add(descriere, BorderLayout.SOUTH);

        changePanel(fereastraPr);
        setTitle("Produse");
        setSize(500,400);
    }

    //metoda care creeaza panoul de adaugare produse
    private void InitAdd() {
    	model = new JTextField();
  		prod = new JTextField();
  		pret = new JTextField();
  		dist = new JTextField();
  		date = new JPanel(new GridLayout(4,4,2,2));
  		modelLab = new JLabel("Modelul: ");
  		prodLab = new JLabel("Producator: ");
  		pretLab = new JLabel("Pret: ");
  		distLab = new JLabel("Distribuitor: ");

  		date.add(modelLab);
  		date.add(model);
  		date.add(prodLab);
  		date.add(prod);
  		date.add(distLab);
  		date.add(dist);
  		date.add(pretLab);
  		date.add(pret);

  		submitAdd = new JButton("Submit");
  		cancelAdd = new JButton("Cancel");
  		submitAdd.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				String dialog = new String("Produs adaugat!");
  				Becuri nou = new Becuri();
  				int id;

  				if(totalFis == 0)
  					id = 0;
  				else
  					id = obiecte[totalFis-1].getID();

  				if(model.getText().equals("LED"))
  					nou = new BecLED(id++,prod.getText(),Double.parseDouble(pret.getText()),dist.getText());
  				else
  				if(model.getText().equals("Clasic"))
  					nou = new BecClasic(id++,prod.getText(),Double.parseDouble(pret.getText()),dist.getText());
  				else
  				if(model.getText().equals("Economic"))
  					nou = new BecEconomic(id++,prod.getText(),Double.parseDouble(pret.getText()),dist.getText());
  				else
  				if(model.getText().equals("Neon"))
  					nou = new BecNeon(id++,prod.getText(),Double.parseDouble(pret.getText()),dist.getText());

  				addCont(nou);
  		    	JOptionPane.showMessageDialog(mainPanelAdd, dialog);
  			}
  		});

  		cancelAdd.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				changePanel(fereastraPr);
  				setTitle("Produse");
  				setSize(400,400);
  			}
  		});

  		butoane = new JPanel(new GridLayout(1,2,2,2));
  		butoane.add(submitAdd);
  		butoane.add(cancelAdd);

  		instructiuni = new JLabel("Introduceti un produs.");
  		mainPanelAdd = new JPanel(new BorderLayout());
  		mainPanelAdd.add(instructiuni,BorderLayout.NORTH);
  		mainPanelAdd.add(date,BorderLayout.CENTER);
  		mainPanelAdd.add(butoane,BorderLayout.SOUTH);
    }

    //metoda care face tranzitia intre panouri
    void changePanel(JPanel panel) {
	    getContentPane().removeAll();
	    getContentPane().add(panel, BorderLayout.CENTER);
	    getContentPane().doLayout();
	    update(getGraphics());
	    setVisible(true);
	}
}

  //metoda care scrie in fisier un cont nou
  static void writeAcc(ArrayList<Conturi> instante) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Accounts.bin"));
			oos.writeObject(instante);
			oos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

   //metoda care citeste toate conturile din fisier si le aduce in program
   static ArrayList<Conturi> readAcc() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Accounts.bin"));
		ArrayList<Conturi> instante = (ArrayList<Conturi>) ois.readObject();
		ois.close();
		return instante;
	}

    static void writeInstante(ArrayList<ArrayList> instante) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Produse.bin"));
			oos.writeObject(instante);
			oos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

    static ArrayList<ArrayList> createInstante() {
		ArrayList<ArrayList> instante = new ArrayList<ArrayList>();
		instante.add(initialiseLED());
		instante.add(initialiseClasic());
		instante.add(initialiseEco());
		instante.add(initialiseNeon());
		return instante;
	}

  //metoda care citeste produsele din fisier si le aduce in program
	private static ArrayList<ArrayList> readInstante() throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Produse.bin"));
		ArrayList<ArrayList> instante = (ArrayList<ArrayList>) ois.readObject();
		ois.close();
      return instante;
	}

	private static ArrayList<BecLED> initialiseLED() {
		ArrayList<BecLED> prod = new ArrayList<BecLED>();
		prod.add(new BecLED(1,"Philips", 35, "EMAG"));
	    prod.add(new BecLED(2,"Philips",39.99, "Flanco"));
	    prod.add(new BecLED(3,"Philips", 29.99, "Altex"));
	    prod.add(new BecLED(4,"Star-Light",59, "EMAG"));
	    prod.add(new BecLED(5,"Star-Light",40, "Flanco"));
	    prod.add(new BecLED(6,"Star-Light",29, "Altex"));
	    prod.add(new BecLED(7,"TP-Link",40, "EMAG"));
	    prod.add(new BecLED(8,"TP-Link", 15, "Flanco"));
	    prod.add(new BecLED(9,"TP-Link", 29, "Altex"));
	    return prod;
	}

	private static ArrayList<BecClasic> initialiseClasic() {
		ArrayList<BecClasic> prod = new ArrayList<BecClasic>();
		 prod.add(new BecClasic(10,"Philips", 3.99, "Altex"));
		    prod.add(new BecClasic(11,"Philips", 4.99, "Flanco"));
		    prod.add(new BecClasic(12,"Philips", 3.87, "EMAG"));
		    prod.add(new BecClasic(13,"Star-Light", 5, "EMAG"));
		    prod.add(new BecClasic(14,"Star-Light", 6, "Altex"));
		    prod.add(new BecClasic(15,"Star-Light", 6, "Flanco"));
		    prod.add(new BecClasic(16,"TP-Link", 10, "Altex"));
		    prod.add(new BecClasic(17,"TP-Link", 11, "Flanco"));
		    prod.add(new BecClasic(18,"TP-Link", 9, "EMAG"));
		    return prod;
	}

	private static ArrayList<BecNeon> initialiseNeon() {
		ArrayList<BecNeon> prod = new ArrayList<BecNeon>();
		prod.add(new BecNeon(19,"TP-Link", 50, "Altex"));
	    prod.add(new BecNeon(20,"Star-Light", 60, "Flanco"));
	    prod.add(new BecNeon(21,"Philips", 45, "EMAG"));
	    return prod;
	}

	private static ArrayList<BecEconomic> initialiseEco() {
		ArrayList<BecEconomic> prod = new ArrayList<BecEconomic>();
		prod.add(new BecEconomic(22,"TP-Link", 30, "Altex"));
	    prod.add(new BecEconomic(23,"Philips", 35.99, "EMAG"));
	    prod.add(new BecEconomic(24,"Star-Light", 29.99, "Flanco"));
	    return prod;
	}

  //metoda main unde incepe programul
	public static void main(String args[]) {
	  //writeInstante(createInstante());
	  IUG iug = new IUG("Proiect");
	  iug.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //se inchide programul daca inchidem fereastra
	  iug.setLocation(400,400);
  }
}
