package jstratego;

import jstratego.gui.game.StartScreen;

/**
 *
 * @author sebastiangrosse
 */
public class JStratego {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
            StartScreen.main(args);
	}
	//TODO Beachten die GUI kann eigentlich nichts und ist "strohdoof" sie soll nur dinge anzeigen und sich einen zug bis zur bestätigung merken
	//TODO ActionListener (eigene Klasse) für alle Spielphasen merkt sich zwei klicks und agiert entsprechend des letzen klicks
	//TODO refresher mit Werteübergabe - Element, das erneuert werden soll
	//TODO abstrakte Klasse für GUI-Elemente die dem refresher übergeben werden kann
	//TODO Klasse für Spielbrett und Infotable getrennt & komplettes Spielbrett in Game zusammenführen
	//TODO eigene Klasse für die felder auf dem Spielbrett, werden dann im spielbrett integriert
	//TODO Merken einer aktion in der move-phase bestätigen und ausführen der Logik erst durch click auf Zug beenden
	//TODO eigene KLasse für Change-GUI anzeigen des letzten kampfes falls geschehen.
}