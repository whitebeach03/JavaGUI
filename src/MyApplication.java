import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


public class MyApplication extends JFrame {
	private JMenuBar menuBar;
	private JMenu fillColorMenu;
	private JMenu lineColorMenu;
	private JMenu lineWidthMenu;
	private JMenu backColorMenu;

	JComboBox<String> comboBox;
	
	MyCanvas canvas;
	StateManager stateManager;
	Mediator mediator;
	MyDrawing selectedDrawings;
	static Vector<MyDrawing> drawings;
	int x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, w, h;
	
	public MyApplication() {
		super("My Application");
		canvas = new MyCanvas();
		mediator = canvas.mediator;
		drawings = mediator.drawings;
		canvas.setBackground(Color.white);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		fillColorMenu = new JMenu("FillColor");
		lineColorMenu = new JMenu("LineColor");
		backColorMenu = new JMenu("BackColor");
		lineWidthMenu = new JMenu("LineWidth");

		menuBar.add(fillColorMenu); //塗り色メニュー
		menuBar.add(lineColorMenu); //線の色メニュー
		menuBar.add(backColorMenu);
		menuBar.add(lineWidthMenu); //線の太さメニュー
	
		JPanel jp = new JPanel();
		JPanel jp2 = new JPanel();
		jp.setLayout(new FlowLayout());
		
        stateManager = new StateManager(mediator);
        //色アイテム
        RedItem redItem = new RedItem(stateManager);
		fillColorMenu.add(redItem);
		RedItem2 redItem2 = new RedItem2(stateManager);
		lineColorMenu.add(redItem2);
		RedItem3 redItem3 = new RedItem3(stateManager);
		backColorMenu.add(redItem3);
		BlueItem blueItem = new BlueItem(stateManager);
		fillColorMenu.add(blueItem);
		BlueItem2 blueItem2 = new BlueItem2(stateManager);
		lineColorMenu.add(blueItem2);
		BlueItem3 blueItem3 = new BlueItem3(stateManager);
		backColorMenu.add(blueItem3);
		GreenItem greenItem = new GreenItem(stateManager);
		fillColorMenu.add(greenItem);
		GreenItem2 greenItem2 = new GreenItem2(stateManager);
		lineColorMenu.add(greenItem2);
		GreenItem3 greenItem3 = new GreenItem3(stateManager);
		backColorMenu.add(greenItem3);
		YellowItem yellowItem = new YellowItem(stateManager);
		fillColorMenu.add(yellowItem);
		YellowItem2 yellowItem2 = new YellowItem2(stateManager);
		lineColorMenu.add(yellowItem2);
		YellowItem3 yellowItem3 = new YellowItem3(stateManager);
		backColorMenu.add(yellowItem3);
		WhiteItem whiteItem = new WhiteItem(stateManager);
		fillColorMenu.add(whiteItem);
		WhiteItem2 whiteItem2 = new WhiteItem2(stateManager);
		lineColorMenu.add(whiteItem2);
		WhiteItem3 whiteItem3 = new WhiteItem3(stateManager);
		backColorMenu.add(whiteItem3);
		OtherFillColorItem otherFillColorItem = new OtherFillColorItem(stateManager);
		fillColorMenu.add(otherFillColorItem);
		OtherLineColorItem otherLineColorItem = new OtherLineColorItem(stateManager);
		lineColorMenu.add(otherLineColorItem);
		OtherBackColorItem otherBackColorItem = new OtherBackColorItem(stateManager);
		backColorMenu.add(otherBackColorItem);
		//線幅アイテム
		WidthItem1 widthItem1 = new WidthItem1(stateManager);
		lineWidthMenu.add(widthItem1);
		WidthItem5 widthItem5 = new WidthItem5(stateManager);
		lineWidthMenu.add(widthItem5);
		WidthItem10 widthItem10 = new WidthItem10(stateManager);
		lineWidthMenu.add(widthItem10);
		WidthItem15 widthItem15 = new WidthItem15(stateManager);
		lineWidthMenu.add(widthItem15);
		WidthItem20 widthItem20 = new WidthItem20(stateManager);
		lineWidthMenu.add(widthItem20);
		//各種ボタン
        SelectButton selectButton = new SelectButton(stateManager); 
		jp.add(selectButton);		
		DeleteButton deleteButton = new DeleteButton(stateManager);
		jp.add(deleteButton);
		CutButton cutButton = new CutButton(stateManager);
		jp.add(cutButton);
		CopyButton copyButton = new CopyButton(stateManager);
		jp.add(copyButton);
		ShadowButton shadowButton = new ShadowButton(stateManager);
		jp.add(shadowButton);
		ImageButton imageButton = new ImageButton(stateManager);
		jp.add(imageButton);
		OvalButton ovalButton = new OvalButton(stateManager);
		jp.add(ovalButton);
		HendecagonalButton hendecagonalButton = new HendecagonalButton(stateManager);
		jp.add(hendecagonalButton);
		TriangleButton triangleButton = new TriangleButton(stateManager);
		jp.add(triangleButton);
		SaveButton saveButton = new SaveButton(stateManager);
		jp2.add(saveButton);
		LoadButton loadButton = new LoadButton(stateManager);
		jp2.add(loadButton);
		//TASK5
		DashCheckBox dashCheckBox = new DashCheckBox(stateManager);
		jp.add(dashCheckBox);
		FrontCheckBox frontCheckBox = new FrontCheckBox(stateManager);
		jp.add(frontCheckBox);
		BackCheckBox backCheckBox = new BackCheckBox(stateManager);
		jp.add(backCheckBox);
		AlphaCheckBox alphaCheck = new AlphaCheckBox(stateManager);
		jp.add(alphaCheck);
		
		comboBox = new JComboBox<>();
		comboBox.setEditable(true);
		comboBox.addActionListener( new AlphaActionListener() );
		comboBox.addItem("255");
		comboBox.addItem("200");
		comboBox.addItem("100");
		comboBox.addItem("80");
		comboBox.addItem("50");
		jp.add(comboBox);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(jp, BorderLayout.NORTH);
		getContentPane().add(jp2, BorderLayout.SOUTH);
		getContentPane().add(canvas, BorderLayout.CENTER);
			
		canvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				x1 = e.getX();
				y1 = e.getY();
				stateManager.mouseDown(x1, y1);
			}
			public void mouseClicked(MouseEvent e) { //ペースト
				int button = e.getButton();
				if (button == MouseEvent.BUTTON3) {
					x3 = e.getX();
					y3 = e.getY();				
					mediator.paste(x3, y3);
				}
			}
			public void mouseReleased(MouseEvent e) {
				x4 = e.getX();
				y4 = e.getY();
				stateManager.mouseUp(x4, y4);
			}
		});
		canvas.addMouseMotionListener(new MouseMotionAdapter() { 
			public void mouseDragged(MouseEvent e) {
				x2 = e.getX();
				y2 = e.getY();
				stateManager.mouseDrag(x2, y2);
			}
			public void mouseMoved(MouseEvent e) {
				x5 = e.getX();
				y5 = e.getY();
				stateManager.mouseMove(x5, y5);
			}
		});

		this.addWindowListener(new WindowAdapter() {
			//ウインドウ閉じたら終了
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(300, 400);
	}
	
	public static void main(String[] args) {
		MyApplication app = new MyApplication();
		app.pack();
		app.setVisible(true);
	}
	
	class AlphaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!e.getActionCommand().equals("comboBoxChanged")) {
				return;
			}
			ComboBoxEditor editor = comboBox.getEditor();
			
			if (mediator.getAlpha()) {
				try {
					int num = Integer.parseInt((String) editor.getItem());
					if (0 <= num && num <= 255) {
						mediator.setAlphaNum(num);
						for (MyDrawing d: mediator.selectedDrawings) {
							int r = d.fillColor.getRed();
							int g = d.fillColor.getGreen();
							int b = d.fillColor.getBlue();
							
							d.setFillColor(new Color(r, g, b, num));
							
							mediator.repaint();
						}
					}
					else {
						System.out.println("入力値が範囲外です");
					}
				} catch (NumberFormatException e1) {
					System.out.println("値が入力されていません");
				}
			}
		}
	}
}
