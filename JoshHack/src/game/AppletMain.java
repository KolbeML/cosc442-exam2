package game;

import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import asciiPanel.AsciiPanel;
import ui.Screen;
import ui.StartScreen;

/**
 * The Class AppletMain.
 */
public class AppletMain extends Applet implements KeyListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2560255315130084198L;

	/** The terminal. */
	private AsciiPanel terminal;

	/** The screen. */
	private Screen screen;

	/**
	 * Instantiates a new applet main.
	 */
	public AppletMain() {
		terminal = new AsciiPanel();
		add(terminal);
		screen = new StartScreen();
		addKeyListener(this);
		repaint();
	}

	/**
	 * The init - sets up the terminal
	 */
	@Override
	public void init() {
		super.init();
		setSize(terminal.getWidth() + 20, terminal.getHeight() + 20);
	}

	@Override
	public void repaint() {
		terminal.clear();
		screen.displayOutput(terminal);
		super.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		screen = screen.respondToUserInput(e);
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
