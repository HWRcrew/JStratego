//TODO siehe comment
/**
 * Spiel wird gestartet; -> Gamephase SetupRed; Spieler Rot platziert seine
 * Figuren (Klick auf Label im Infobereich, danach Auswahl "Standort"); dabei
 * Counter pro Figur runterzählen; Zusatz: Spieler platziert Figur auf bereits
 * belegtem Feld: alte Figur geht zurück; Achtung: Platzierung nur in den 4
 * oberen Reihen
 *
 * Spieler Rot beendet per Button seine Platzierung; -> Gamepahse Change, da
 * dort auch nur alle Figuren verdeckt werden. Figuren von Spieler Rot werden
 * verdeckt; Spieler Blau beginnt durch Klick auf Button Platzierung; Iconfarbe
 * auf blau ändern; Counter zurücksetzen; Platzierung analog Spieler Rot; ->
 * Gamephase Change;
 *
 * Spieler Rot beginnt mit Klick auf Button das eigentliche Spiel; Auswahl
 * Figur, holen von Liste erreichbarer Felder; wenn 0: Fehlermeldung, sonst
 * anzeigen der Felder durch roten Rahmen; Spieler wählt Zielfeld; wenn Zielfeld
 * erreichbar, Setzen der Figur, eventuell Kampf, sonst Fehlermeldung;
 *
 * -> Gamephase Change. Verdecken aller Figuren. Zuletzt bewegte wird mit Rahmen
 * markiert; nach Kampf: beteiligte Figuren, egal ob Angreifer oder Verteidiger,
 * werden aufgedeckt gelassen. Spieler Blau beginnt mit Klick auf Button seinen
 * Spielzug. Erst jetzt "löschen" der unterlegenen Figur. Entfernen des
 * zuletzt-bewegt-Rahmens. Analog Spieler Rot;
 *
 * Wiederholen, bis Flagge besiegt wird oder nur stationäre Figuren vorhanden
 * sind.
 *
 * Anzeige MsgBox Spieler x hat gewonnen. Aufdecken aller verbliebenen Figuren.
 * Aktionsbutton grau.
 *
 * Dauerhaft: Button Neues Spiel: Abfrage durch MsgBox, danach Aufrufen
 * Startbildschirm zwecks Namenseingabe.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.gui.game;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import jstratego.logic.game.Field;
import jstratego.logic.game.Game;
import jstratego.logic.game.Gamephase;
import jstratego.logic.game.Player;

import jstratego.logic.pieces.*;

/**
 *
 * @author Tim
 */
public class PlayBoard extends javax.swing.JFrame {

    static Game currentGame = null;
    static JLabel[][] fieldArray = new JLabel[10][10];
    static Border highlighted = new LineBorder(java.awt.Color.red, 3, false);
    static int[] figureCounter = null;
    static Piece pieceToPlace = null;

    /**
     * Creates new form Board
     */
    public PlayBoard() {
        this.setContentPane(new BackgroundPanelMain());
        setResizable(false);
        initComponents();
        fillFieldArray();
        placementLabelVisible(false);
        PlayGame();
    }

    public final void fillFieldArray() {
        fieldArray[0][0] = f00;
        fieldArray[0][1] = f01;
        fieldArray[0][2] = f02;
        fieldArray[0][3] = f03;
        fieldArray[0][4] = f04;
        fieldArray[0][5] = f05;
        fieldArray[0][6] = f06;
        fieldArray[0][7] = f07;
        fieldArray[0][8] = f08;
        fieldArray[0][9] = f09;
        fieldArray[1][0] = f10;
        fieldArray[1][1] = f11;
        fieldArray[1][2] = f12;
        fieldArray[1][3] = f13;
        fieldArray[1][4] = f14;
        fieldArray[1][5] = f15;
        fieldArray[1][6] = f16;
        fieldArray[1][7] = f17;
        fieldArray[1][8] = f18;
        fieldArray[1][9] = f19;
        fieldArray[2][0] = f20;
        fieldArray[2][1] = f21;
        fieldArray[2][2] = f22;
        fieldArray[2][3] = f23;
        fieldArray[2][4] = f24;
        fieldArray[2][5] = f25;
        fieldArray[2][6] = f26;
        fieldArray[2][7] = f27;
        fieldArray[2][8] = f28;
        fieldArray[2][9] = f29;
        fieldArray[3][0] = f30;
        fieldArray[3][1] = f31;
        fieldArray[3][2] = f32;
        fieldArray[3][3] = f33;
        fieldArray[3][4] = f34;
        fieldArray[3][5] = f35;
        fieldArray[3][6] = f36;
        fieldArray[3][7] = f37;
        fieldArray[3][8] = f38;
        fieldArray[3][9] = f39;
        fieldArray[4][0] = f40;
        fieldArray[4][1] = f41;//lakes skipped
        fieldArray[4][4] = f44;
        fieldArray[4][5] = f45;
        fieldArray[4][8] = f48;
        fieldArray[4][9] = f49;
        fieldArray[5][0] = f50;
        fieldArray[5][1] = f51;
        fieldArray[5][4] = f54;
        fieldArray[5][5] = f55;
        fieldArray[5][8] = f58;
        fieldArray[5][9] = f59;
        fieldArray[6][0] = f60;
        fieldArray[6][1] = f61;
        fieldArray[6][2] = f62;
        fieldArray[6][3] = f63;
        fieldArray[6][4] = f64;
        fieldArray[6][5] = f65;
        fieldArray[6][6] = f66;
        fieldArray[6][7] = f67;
        fieldArray[6][8] = f68;
        fieldArray[6][9] = f69;
        fieldArray[7][0] = f70;
        fieldArray[7][1] = f71;
        fieldArray[7][2] = f72;
        fieldArray[7][3] = f73;
        fieldArray[7][4] = f74;
        fieldArray[7][5] = f75;
        fieldArray[7][6] = f76;
        fieldArray[7][7] = f77;
        fieldArray[7][8] = f78;
        fieldArray[7][9] = f79;
        fieldArray[8][0] = f80;
        fieldArray[8][1] = f81;
        fieldArray[8][2] = f82;
        fieldArray[8][3] = f83;
        fieldArray[8][4] = f84;
        fieldArray[8][5] = f85;
        fieldArray[8][6] = f86;
        fieldArray[8][7] = f87;
        fieldArray[8][8] = f88;
        fieldArray[8][9] = f89;
        fieldArray[9][0] = f90;
        fieldArray[9][1] = f91;
        fieldArray[9][2] = f92;
        fieldArray[9][3] = f93;
        fieldArray[9][4] = f94;
        fieldArray[9][5] = f95;
        fieldArray[9][6] = f96;
        fieldArray[9][7] = f97;
        fieldArray[9][8] = f98;
        fieldArray[9][9] = f99;
    }

    public final void PlayGame() {
        if (currentGame.gameState.getCurrentGamephase().equals(Gamephase.SETUPred)) {

            if (figureCounter == null) {
                preparePlacement();
                setInfoIconColor(Color.RED);
                labelPlayer.setText(currentGame.gameState.getPlayerWithMove().name + ", bitte Figuren platzieren.");
                buttonSet.setText("Platzierung beenden");

            } else {
                currentGame.switchGamephase(Gamephase.CHANGE);
                updateIcons();
//                currentGame.switchPlayer();
                buttonSet.setText("Platzierung beginnen");
                labelPlayer.setText("Wechsel zu " + currentGame.gameState.getPlayerWithMove().name);
            }
        } else if (currentGame.gameState.getCurrentGamephase().equals(Gamephase.CHANGE)) {
            if (currentGame.gameState.getLastGamephase().equals(Gamephase.SETUPred)) {
                preparePlacement();
                setInfoIconColor(Color.BLUE);
                currentGame.switchGamephase(Gamephase.SETUPblue);
                labelPlayer.setText(currentGame.gameState.getPlayerWithMove().name + ", bitte Figuren platzieren.");
                buttonSet.setText("Platzierung beenden");
            }
        }

    }

    /**
     * Sets additional information labels visible or hides them. Important
     * before and after figure placing.
     */
    public final void placementLabelVisible(boolean value) {

        labelFlagPlace.setVisible(value);
        labelMarshalPlace.setVisible(value);
        labelGeneralPlace.setVisible(value);
        labelColonelPlace.setVisible(value);
        labelMajorPlace.setVisible(value);
        labelCaptainPlace.setVisible(value);
        labelLieutenantPlace.setVisible(value);
        labelSergeantPlace.setVisible(value);
        labelMinerPlace.setVisible(value);
        labelScoutPlace.setVisible(value);
        labelSpyPlace.setVisible(value);
        labelBombPlace.setVisible(value);

        labelFlagNumber.setVisible(value);
        labelMarshalNumber.setVisible(value);
        labelGeneralNumber.setVisible(value);
        labelColonelNumber.setVisible(value);
        labelMajorNumber.setVisible(value);
        labelCaptainNumber.setVisible(value);
        labelLieutenantNumber.setVisible(value);
        labelSergeantNumber.setVisible(value);
        labelMinerNumber.setVisible(value);
        labelScoutNumber.setVisible(value);
        labelSpyNumber.setVisible(value);
        labelBombNumber.setVisible(value);
    }

    /**
     * Resets figures-placed-counter and shows information label, using
     * placementLabelVisible(true). Sets array with allowed numbers of each
     * piece. Order: Flag, Marshal, General, Colonel, Major, Captain,
     * Lieutenant, Sergeant, Miner, Scout, Spy, Bomb
     */
    public void preparePlacement() {

        figureCounter = new int[]{1, 1, 1, 2, 3, 4, 4, 4, 5, 8, 1, 6};

        placementLabelVisible(true);
        updatePlacementLabel();
    }

    public void updatePlacementLabel() {
        labelFlagNumber.setText(String.valueOf(figureCounter[0]));
        labelMarshalNumber.setText(String.valueOf(figureCounter[1]));
        labelGeneralNumber.setText(String.valueOf(figureCounter[2]));
        labelColonelNumber.setText(String.valueOf(figureCounter[3]));
        labelMajorNumber.setText(String.valueOf(figureCounter[4]));
        labelCaptainNumber.setText(String.valueOf(figureCounter[5]));
        labelLieutenantNumber.setText(String.valueOf(figureCounter[6]));
        labelSergeantNumber.setText(String.valueOf(figureCounter[7]));
        labelMinerNumber.setText(String.valueOf(figureCounter[8]));
        labelScoutNumber.setText(String.valueOf(figureCounter[9]));
        labelSpyNumber.setText(String.valueOf(figureCounter[10]));
        labelBombNumber.setText(String.valueOf(figureCounter[11]));
    }

    /**
     * Changes color of icons in infoarea to fit current player.
     */
    public void setInfoIconColor(Color playerColor) {

        String path = ("_" + playerColor + ".png");

        labelFlagIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/" + "flag" + path)));
        labelMarshalIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/" + "marshal" + path)));
        labelGeneralIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/" + "general" + path)));
        labelColonelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/" + "colonel" + path)));
        labelMajorIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/" + "major" + path)));
        labelCaptainIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/" + "captain" + path)));
        labelLieutenantIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/" + "lieutenant" + path)));
        labelSergeantIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/" + "sergeant" + path)));
        labelMinerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/" + "miner" + path)));
        labelScoutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/" + "scout" + path)));
        labelSpyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/" + "spy" + path)));
        labelBombIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/" + "bomb" + path)));

    }

    /**
     * Reads piece from board in current game and sets icon of corresponding
     * field.
     */
    public void updateIcons() {
        String iconName = "";
        String pieceType = "";
        String pieceColor = "";

        for (int x = 0; x <= 9; x++) {
            for (int y = 0; y <= 9; y++) {
                if (!currentGame.playBoard.board[x][y].isBlocked()) {
                    if (currentGame.playBoard.board[x][y].getPiece() == null) {
                        fieldArray[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png")));
                    } else {
                        pieceType = currentGame.playBoard.board[x][y].getPiece().getClass().getSimpleName();
                        pieceColor = currentGame.playBoard.board[x][y].getPiece().color.toString();
                        iconName = "/jstratego/gui/img/" + pieceType.toLowerCase() + "_" + pieceColor.toLowerCase() + ".png";
                        fieldArray[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource(iconName)));
                    }
                }
            }
        }


    }

    public void resetBorders() {
        for (int x = 0; x <= 9; x++) {
            for (int y = 0; y <= 9; y++) {
                fieldArray[x][y].setBorder(null);
            }
        }
    }

    public void showReachable(Field start) {

        int x = 0;
        int y = 0;

        List<Field> reachableFields = currentGame.playBoard.reachableFields(start);
        if (reachableFields.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Diese Figur kann nicht bewegt werden. Bitte andere wählen.", "Fehler", ERROR);
        } else {
            for (int i = 0; i < reachableFields.size(); i++) {
                x = reachableFields.get(i).getX();
                y = reachableFields.get(i).getY();
                fieldArray[x][y].setBorder(highlighted);
            }

        }
    }

    public boolean placeable() {
        String pieceName = pieceToPlace.getClass().getSimpleName();

        if (pieceName.equalsIgnoreCase("Flag") && (figureCounter[0] > 0)) {
            return true;
        } else if (pieceName.equalsIgnoreCase("Marshal") && (figureCounter[1] > 0)) {
            return true;
        } else if (pieceName.equalsIgnoreCase("General") && (figureCounter[2] > 0)) {
            return true;
        } else if (pieceName.equalsIgnoreCase("Colonel") && (figureCounter[3] > 0)) {
            return true;
        } else if (pieceName.equalsIgnoreCase("Major") && (figureCounter[4] > 0)) {
            return true;
        } else if (pieceName.equalsIgnoreCase("Captain") && (figureCounter[5] > 0)) {
            return true;
        } else if (pieceName.equalsIgnoreCase("Lieutenant") && (figureCounter[6] > 0)) {
            return true;
        } else if (pieceName.equalsIgnoreCase("Sergeant") && (figureCounter[7] > 0)) {
            return true;
        } else if (pieceName.equalsIgnoreCase("Miner") && (figureCounter[8] > 0)) {
            return true;
        } else if (pieceName.equalsIgnoreCase("Scout") && (figureCounter[9] > 0)) {
            return true;
        } else if (pieceName.equalsIgnoreCase("Spy") && (figureCounter[10] > 0)) {
            return true;
        } else if (pieceName.equalsIgnoreCase("Bomb") && (figureCounter[11] > 0)) {
            return true;
        } else {
            return false;
        }
    }

    public void callMove(JLabel field) {

        if ((currentGame.gameState.getCurrentGamephase() == jstratego.logic.game.Gamephase.SETUPblue)
                || (currentGame.gameState.getCurrentGamephase() == jstratego.logic.game.Gamephase.SETUPred)) {
            if ((!(field.getName().length() == 3) || (field.getName().startsWith("S"))) && pieceToPlace == null) {
                String pieceName = field.getName();
                Color tempColor = currentGame.gameState.getPlayerWithMove().playerColor;

                if (pieceName.equalsIgnoreCase("Flag")) {
                    pieceToPlace = new Flag(tempColor, true, false);
                } else if (pieceName.equalsIgnoreCase("Marshal")) {
                    pieceToPlace = new Marshal(tempColor, true, false);
                } else if (pieceName.equalsIgnoreCase("General")) {
                    pieceToPlace = new General(tempColor, true, false);
                } else if (pieceName.equalsIgnoreCase("Colonel")) {
                    pieceToPlace = new Colonel(tempColor, true, false);
                } else if (pieceName.equalsIgnoreCase("Major")) {
                    pieceToPlace = new Major(tempColor, true, false);
                } else if (pieceName.equalsIgnoreCase("Captain")) {
                    pieceToPlace = new Captain(tempColor, true, false);
                } else if (pieceName.equalsIgnoreCase("Lieutenant")) {
                    pieceToPlace = new Lieutenant(tempColor, true, false);
                } else if (pieceName.equalsIgnoreCase("Sergeant")) {
                    pieceToPlace = new Sergeant(tempColor, true, false);
                } else if (pieceName.equalsIgnoreCase("Miner")) {
                    pieceToPlace = new Miner(tempColor, true, false);
                } else if (pieceName.equalsIgnoreCase("Scout")) {
                    pieceToPlace = new Scout(tempColor, true, false);
                } else if (pieceName.equalsIgnoreCase("Spy")) {
                    pieceToPlace = new Spy(tempColor, true, false);
                } else if (pieceName.equalsIgnoreCase("Bomb")) {
                    pieceToPlace = new Bomb(tempColor, true, false);
                }

                labelPlayer.setText(pieceToPlace.name + " platzieren.");

            } else {
                if ((field.getName().length() == 3) && !field.getName().startsWith("S") && pieceToPlace != null) {
                    int x = Integer.parseInt(field.getName().substring(1, 2));
                    int y = Integer.parseInt(field.getName().substring(2));
                    try {
                        if (placeable()) {
                            currentGame.playBoard.board[x][y].setPiece(pieceToPlace, currentGame.gameState);

                            String pieceName = pieceToPlace.getClass().getSimpleName();

                            if (pieceName.equalsIgnoreCase("Flag")) {
                                figureCounter[0]--;
                            } else if (pieceName.equalsIgnoreCase("Marshal")) {
                                figureCounter[1]--;
                            } else if (pieceName.equalsIgnoreCase("General")) {
                                figureCounter[2]--;
                            } else if (pieceName.equalsIgnoreCase("Colonel")) {
                                figureCounter[3]--;
                            } else if (pieceName.equalsIgnoreCase("Major")) {
                                figureCounter[4]--;
                            } else if (pieceName.equalsIgnoreCase("Captain")) {
                                figureCounter[5]--;
                            } else if (pieceName.equalsIgnoreCase("Lieutenant")) {
                                figureCounter[6]--;
                            } else if (pieceName.equalsIgnoreCase("Sergeant")) {
                                figureCounter[7]--;
                            } else if (pieceName.equalsIgnoreCase("Miner")) {
                                figureCounter[8]--;
                            } else if (pieceName.equalsIgnoreCase("Scout")) {
                                figureCounter[9]--;
                            } else if (pieceName.equalsIgnoreCase("Spy")) {
                                figureCounter[10]--;
                            } else if (pieceName.equalsIgnoreCase("Bomb")) {
                                figureCounter[11]--;
                            }
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Platzierung hier nicht möglich.", "Fehler", JOptionPane.ERROR_MESSAGE);
                    }
                    pieceToPlace = null;
                    updatePlacementLabel();
                    updateIcons();
                    labelPlayer.setText(currentGame.gameState.getPlayerWithMove().name + ", bitte Figuren platzieren.");
                }
            }


        } else {
            if (currentGame.gameState.getCurrentGamephase().equals(Gamephase.MOVEblue)
                    || currentGame.gameState.getCurrentGamephase().equals(Gamephase.MOVEred)) {
                {
                    int x = field.getName().charAt(1);
                    int y = field.getName().charAt(2);

                    if (currentGame.gameState.getChallenger() == null) {
                        currentGame.gameState.setChallenger(currentGame.playBoard.board[x][y].getPiece());
                    } else {
                        currentGame.gameState.setDefender(currentGame.playBoard.board[x][y].getPiece());
                    }
                }
            } else {
                //TODO Klick auf Feld bei Spielerwechsel abfangen
            }//end if move

        }//end if setup
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelGame = new javax.swing.JPanel();
        f00 = new javax.swing.JLabel();
        f01 = new javax.swing.JLabel();
        f02 = new javax.swing.JLabel();
        f03 = new javax.swing.JLabel();
        f04 = new javax.swing.JLabel();
        f06 = new javax.swing.JLabel();
        f07 = new javax.swing.JLabel();
        f05 = new javax.swing.JLabel();
        f09 = new javax.swing.JLabel();
        f08 = new javax.swing.JLabel();
        f10 = new javax.swing.JLabel();
        f15 = new javax.swing.JLabel();
        f14 = new javax.swing.JLabel();
        f13 = new javax.swing.JLabel();
        f12 = new javax.swing.JLabel();
        f11 = new javax.swing.JLabel();
        f17 = new javax.swing.JLabel();
        f16 = new javax.swing.JLabel();
        f19 = new javax.swing.JLabel();
        f18 = new javax.swing.JLabel();
        f37 = new javax.swing.JLabel();
        f38 = new javax.swing.JLabel();
        f32 = new javax.swing.JLabel();
        f31 = new javax.swing.JLabel();
        f34 = new javax.swing.JLabel();
        f33 = new javax.swing.JLabel();
        f30 = new javax.swing.JLabel();
        f35 = new javax.swing.JLabel();
        f29 = new javax.swing.JLabel();
        f28 = new javax.swing.JLabel();
        f39 = new javax.swing.JLabel();
        f20 = new javax.swing.JLabel();
        f36 = new javax.swing.JLabel();
        f25 = new javax.swing.JLabel();
        f24 = new javax.swing.JLabel();
        f23 = new javax.swing.JLabel();
        f22 = new javax.swing.JLabel();
        f21 = new javax.swing.JLabel();
        f27 = new javax.swing.JLabel();
        f26 = new javax.swing.JLabel();
        f44 = new javax.swing.JLabel();
        f41 = new javax.swing.JLabel();
        f47 = new javax.swing.JLabel();
        f42 = new javax.swing.JLabel();
        f56 = new javax.swing.JLabel();
        f54 = new javax.swing.JLabel();
        f59 = new javax.swing.JLabel();
        f51 = new javax.swing.JLabel();
        f57 = new javax.swing.JLabel();
        f50 = new javax.swing.JLabel();
        f46 = new javax.swing.JLabel();
        f45 = new javax.swing.JLabel();
        f58 = new javax.swing.JLabel();
        f48 = new javax.swing.JLabel();
        f52 = new javax.swing.JLabel();
        f40 = new javax.swing.JLabel();
        f55 = new javax.swing.JLabel();
        f53 = new javax.swing.JLabel();
        f49 = new javax.swing.JLabel();
        f43 = new javax.swing.JLabel();
        f76 = new javax.swing.JLabel();
        f65 = new javax.swing.JLabel();
        f79 = new javax.swing.JLabel();
        f60 = new javax.swing.JLabel();
        f62 = new javax.swing.JLabel();
        f64 = new javax.swing.JLabel();
        f63 = new javax.swing.JLabel();
        f84 = new javax.swing.JLabel();
        f66 = new javax.swing.JLabel();
        f67 = new javax.swing.JLabel();
        f61 = new javax.swing.JLabel();
        f77 = new javax.swing.JLabel();
        f78 = new javax.swing.JLabel();
        f72 = new javax.swing.JLabel();
        f71 = new javax.swing.JLabel();
        f74 = new javax.swing.JLabel();
        f73 = new javax.swing.JLabel();
        f70 = new javax.swing.JLabel();
        f75 = new javax.swing.JLabel();
        f68 = new javax.swing.JLabel();
        f69 = new javax.swing.JLabel();
        f95 = new javax.swing.JLabel();
        f80 = new javax.swing.JLabel();
        f92 = new javax.swing.JLabel();
        f88 = new javax.swing.JLabel();
        f98 = new javax.swing.JLabel();
        f83 = new javax.swing.JLabel();
        f93 = new javax.swing.JLabel();
        f89 = new javax.swing.JLabel();
        f99 = new javax.swing.JLabel();
        f94 = new javax.swing.JLabel();
        f87 = new javax.swing.JLabel();
        f81 = new javax.swing.JLabel();
        f96 = new javax.swing.JLabel();
        f82 = new javax.swing.JLabel();
        f97 = new javax.swing.JLabel();
        f90 = new javax.swing.JLabel();
        f86 = new javax.swing.JLabel();
        f85 = new javax.swing.JLabel();
        f91 = new javax.swing.JLabel();
        panelInfoArea = new javax.swing.JPanel();
        labelBannerInfoArea = new javax.swing.JLabel();
        buttonSet = new javax.swing.JButton();
        buttonRestart = new javax.swing.JButton();
        panelInfoAreaRight = new javax.swing.JPanel();
        labelMinerPlace = new javax.swing.JLabel();
        labelScoutName = new javax.swing.JLabel();
        labelBombName = new javax.swing.JLabel();
        labelSergeantIcon = new javax.swing.JLabel();
        labelMinerName = new javax.swing.JLabel();
        labelBombPlace = new javax.swing.JLabel();
        labelBombIcon = new javax.swing.JLabel();
        labelMinerIcon = new javax.swing.JLabel();
        labelSergeantName = new javax.swing.JLabel();
        labelSpyPlace = new javax.swing.JLabel();
        labelScoutIcon = new javax.swing.JLabel();
        labelLieutenantPlace = new javax.swing.JLabel();
        labelScoutPlace = new javax.swing.JLabel();
        labelSpyIcon = new javax.swing.JLabel();
        labelSpyName = new javax.swing.JLabel();
        labelLieutenantIcon = new javax.swing.JLabel();
        labelLieutenantName = new javax.swing.JLabel();
        labelSergeantPlace = new javax.swing.JLabel();
        labelLieutenantNumber = new javax.swing.JLabel();
        labelSergeantNumber = new javax.swing.JLabel();
        labelMinerNumber = new javax.swing.JLabel();
        labelScoutNumber = new javax.swing.JLabel();
        labelSpyNumber = new javax.swing.JLabel();
        labelBombNumber = new javax.swing.JLabel();
        panelInfoAreaLeft = new javax.swing.JPanel();
        labelMarshalIcon = new javax.swing.JLabel();
        labelColonelName = new javax.swing.JLabel();
        labelCaptainPlace = new javax.swing.JLabel();
        labelCaptainName = new javax.swing.JLabel();
        labelGeneralPlace = new javax.swing.JLabel();
        labelFlagIcon = new javax.swing.JLabel();
        labelCaptainIcon = new javax.swing.JLabel();
        labelFlagPlace = new javax.swing.JLabel();
        labelMarshalName = new javax.swing.JLabel();
        labelMajorName = new javax.swing.JLabel();
        labelGeneralName = new javax.swing.JLabel();
        labelMarshalPlace = new javax.swing.JLabel();
        labelMajorPlace = new javax.swing.JLabel();
        labelFlagName = new javax.swing.JLabel();
        labelGeneralIcon = new javax.swing.JLabel();
        labelColonelIcon = new javax.swing.JLabel();
        labelColonelPlace = new javax.swing.JLabel();
        labelMajorIcon = new javax.swing.JLabel();
        labelFlagNumber = new javax.swing.JLabel();
        labelMarshalNumber = new javax.swing.JLabel();
        labelGeneralNumber = new javax.swing.JLabel();
        labelColonelNumber = new javax.swing.JLabel();
        labelMajorNumber = new javax.swing.JLabel();
        labelCaptainNumber = new javax.swing.JLabel();
        labelPlayer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGame.setOpaque(false);
        panelGame.setLayout(new java.awt.GridBagLayout());

        f00.setBackground(java.awt.Color.white);
        f00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f00.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f00.setName("f00");
        f00.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f00MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelGame.add(f00, gridBagConstraints);

        f01.setBackground(java.awt.Color.white);
        f01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f01.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f01.setName("f01");
        f01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f01MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelGame.add(f01, gridBagConstraints);

        f02.setBackground(java.awt.Color.white);
        f02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f02.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f02.setName("f02");
        f02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f02MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelGame.add(f02, gridBagConstraints);

        f03.setBackground(java.awt.Color.white);
        f03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f03.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f03.setName("f03");
        f03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f03MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelGame.add(f03, gridBagConstraints);

        f04.setBackground(java.awt.Color.white);
        f04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f04.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f04.setName("f04");
        f04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f04MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelGame.add(f04, gridBagConstraints);

        f06.setBackground(java.awt.Color.white);
        f06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f06.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f06.setName("f06");
        f06.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f06MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelGame.add(f06, gridBagConstraints);

        f07.setBackground(java.awt.Color.white);
        f07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f07.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f07.setName("f07");
        f07.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f07MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelGame.add(f07, gridBagConstraints);

        f05.setBackground(java.awt.Color.white);
        f05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f05.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f05.setName("f05");
        f05.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f05MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelGame.add(f05, gridBagConstraints);

        f09.setBackground(java.awt.Color.white);
        f09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f09.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f09.setName("f09");
        f09.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f09MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        panelGame.add(f09, gridBagConstraints);

        f08.setBackground(java.awt.Color.white);
        f08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f08.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f08.setName("f08");
        f08.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f08MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelGame.add(f08, gridBagConstraints);

        f10.setBackground(java.awt.Color.white);
        f10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f10.setName("f10");
        f10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f10MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelGame.add(f10, gridBagConstraints);

        f15.setBackground(java.awt.Color.white);
        f15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f15.setName("f15");
        f15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f15MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f15, gridBagConstraints);

        f14.setBackground(java.awt.Color.white);
        f14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f14.setName("f14");
        f14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f14MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f14, gridBagConstraints);

        f13.setBackground(java.awt.Color.white);
        f13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f13.setName("f13");
        f13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f13MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f13, gridBagConstraints);

        f12.setBackground(java.awt.Color.white);
        f12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f12.setName("f12");
        f12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f12MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f12, gridBagConstraints);

        f11.setBackground(java.awt.Color.white);
        f11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f11.setName("f11");
        f11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f11MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f11, gridBagConstraints);

        f17.setBackground(java.awt.Color.white);
        f17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f17.setName("f17");
        f17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f17MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f17, gridBagConstraints);

        f16.setBackground(java.awt.Color.white);
        f16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f16.setName("f16");
        f16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f16MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f16, gridBagConstraints);

        f19.setBackground(java.awt.Color.white);
        f19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f19.setName("f19");
        f19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f19MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelGame.add(f19, gridBagConstraints);

        f18.setBackground(java.awt.Color.white);
        f18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f18.setName("f18");
        f18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f18MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f18, gridBagConstraints);

        f37.setBackground(java.awt.Color.white);
        f37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f37.setName("f37");
        f37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f37MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f37, gridBagConstraints);

        f38.setBackground(java.awt.Color.white);
        f38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f38.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f38.setName("f38");
        f38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f38MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f38, gridBagConstraints);

        f32.setBackground(java.awt.Color.white);
        f32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f32.setName("f32");
        f32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f32MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f32, gridBagConstraints);

        f31.setBackground(java.awt.Color.white);
        f31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f31.setName("f31");
        f31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f31MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f31, gridBagConstraints);

        f34.setBackground(java.awt.Color.white);
        f34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f34.setName("f34");
        f34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f34MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f34, gridBagConstraints);

        f33.setBackground(java.awt.Color.white);
        f33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f33.setName("f33");
        f33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f33MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f33, gridBagConstraints);

        f30.setBackground(java.awt.Color.white);
        f30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f30.setName("f30");
        f30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f30MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelGame.add(f30, gridBagConstraints);

        f35.setBackground(java.awt.Color.white);
        f35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f35.setName("f35");
        f35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f35MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f35, gridBagConstraints);

        f29.setBackground(java.awt.Color.white);
        f29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f29.setName("f29");
        f29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f29MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelGame.add(f29, gridBagConstraints);

        f28.setBackground(java.awt.Color.white);
        f28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f28.setName("f28");
        f28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f28MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f28, gridBagConstraints);

        f39.setBackground(java.awt.Color.white);
        f39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f39.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f39.setName("f39");
        f39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f39MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelGame.add(f39, gridBagConstraints);

        f20.setBackground(java.awt.Color.white);
        f20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f20.setName("f20");
        f20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f20MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelGame.add(f20, gridBagConstraints);

        f36.setBackground(java.awt.Color.white);
        f36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f36.setName("f36");
        f36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f36MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f36, gridBagConstraints);

        f25.setBackground(java.awt.Color.white);
        f25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f25.setName("f25");
        f25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f25MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f25, gridBagConstraints);

        f24.setBackground(java.awt.Color.white);
        f24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f24.setName("f24");
        f24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f24MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f24, gridBagConstraints);

        f23.setBackground(java.awt.Color.white);
        f23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f23.setName("f23");
        f23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f23MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f23, gridBagConstraints);

        f22.setBackground(java.awt.Color.white);
        f22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f22.setName("f22");
        f22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f22MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f22, gridBagConstraints);

        f21.setBackground(java.awt.Color.white);
        f21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f21.setName("f21");
        f21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f21MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f21, gridBagConstraints);

        f27.setBackground(java.awt.Color.white);
        f27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f27.setName("f27");
        f27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f27MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f27, gridBagConstraints);

        f26.setBackground(java.awt.Color.white);
        f26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f26.setName("f26");
        f26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f26MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f26, gridBagConstraints);

        f44.setBackground(java.awt.Color.white);
        f44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f44.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f44.setName("f44");
        f44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f44MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f44, gridBagConstraints);

        f41.setBackground(java.awt.Color.white);
        f41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f41.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f41.setName("f41");
        f41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f41MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f41, gridBagConstraints);

        f47.setBackground(java.awt.Color.white);
        f47.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f47, gridBagConstraints);

        f42.setBackground(java.awt.Color.white);
        f42.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f42, gridBagConstraints);

        f56.setBackground(java.awt.Color.white);
        f56.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f56, gridBagConstraints);

        f54.setBackground(java.awt.Color.white);
        f54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f54.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f54.setName("f54");
        f54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f54MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f54, gridBagConstraints);

        f59.setBackground(java.awt.Color.white);
        f59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f59.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f59.setName("f59");
        f59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f59MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelGame.add(f59, gridBagConstraints);

        f51.setBackground(java.awt.Color.white);
        f51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f51.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f51.setName("f51");
        f51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f51MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f51, gridBagConstraints);

        f57.setBackground(java.awt.Color.white);
        f57.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f57, gridBagConstraints);

        f50.setBackground(java.awt.Color.white);
        f50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f50.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f50.setName("f50");
        f50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f50MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelGame.add(f50, gridBagConstraints);

        f46.setBackground(java.awt.Color.white);
        f46.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f46, gridBagConstraints);

        f45.setBackground(java.awt.Color.white);
        f45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f45.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f45.setName("f45");
        f45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f45MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f45, gridBagConstraints);

        f58.setBackground(java.awt.Color.white);
        f58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f58.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f58.setName("f58");
        f58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f58MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f58, gridBagConstraints);

        f48.setBackground(java.awt.Color.white);
        f48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f48.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f48.setName("f48");
        f48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f48MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f48, gridBagConstraints);

        f52.setBackground(java.awt.Color.white);
        f52.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f52, gridBagConstraints);

        f40.setBackground(java.awt.Color.white);
        f40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f40.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f40.setName("f40");
        f40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f40MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelGame.add(f40, gridBagConstraints);

        f55.setBackground(java.awt.Color.white);
        f55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f55.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f55.setName("f55");
        f55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f55MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f55, gridBagConstraints);

        f53.setBackground(java.awt.Color.white);
        f53.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f53, gridBagConstraints);

        f49.setBackground(java.awt.Color.white);
        f49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f49.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f49.setName("f49");
        f49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f49MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelGame.add(f49, gridBagConstraints);

        f43.setBackground(java.awt.Color.white);
        f43.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f43, gridBagConstraints);

        f76.setBackground(java.awt.Color.white);
        f76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f76.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f76.setName("f76");
        f76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f76MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f76, gridBagConstraints);

        f65.setBackground(java.awt.Color.white);
        f65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f65.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f65.setName("f65");
        f65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f65MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f65, gridBagConstraints);

        f79.setBackground(java.awt.Color.white);
        f79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f79.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f79.setName("f79");
        f79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f79MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelGame.add(f79, gridBagConstraints);

        f60.setBackground(java.awt.Color.white);
        f60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f60.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f60.setName("f60");
        f60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f60MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelGame.add(f60, gridBagConstraints);

        f62.setBackground(java.awt.Color.white);
        f62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f62.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f62.setName("f62");
        f62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f62MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f62, gridBagConstraints);

        f64.setBackground(java.awt.Color.white);
        f64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f64.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f64.setName("f64");
        f64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f64MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f64, gridBagConstraints);

        f63.setBackground(java.awt.Color.white);
        f63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f63.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f63.setName("f63");
        f63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f63MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f63, gridBagConstraints);

        f84.setBackground(java.awt.Color.white);
        f84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f84.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f84.setName("f84");
        f84.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f84MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f84, gridBagConstraints);

        f66.setBackground(java.awt.Color.white);
        f66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f66.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f66.setName("f66");
        f66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f66MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f66, gridBagConstraints);

        f67.setBackground(java.awt.Color.white);
        f67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f67.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f67.setName("f67");
        f67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f67MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f67, gridBagConstraints);

        f61.setBackground(java.awt.Color.white);
        f61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f61.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f61.setName("f61");
        f61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f61MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f61, gridBagConstraints);

        f77.setBackground(java.awt.Color.white);
        f77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f77.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f77.setName("f77");
        f77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f77MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f77, gridBagConstraints);

        f78.setBackground(java.awt.Color.white);
        f78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f78.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f78.setName("f78");
        f78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f78MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f78, gridBagConstraints);

        f72.setBackground(java.awt.Color.white);
        f72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f72.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f72.setName("f72");
        f72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f72MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f72, gridBagConstraints);

        f71.setBackground(java.awt.Color.white);
        f71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f71.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f71.setName("f71");
        f71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f71MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f71, gridBagConstraints);

        f74.setBackground(java.awt.Color.white);
        f74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f74.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f74.setName("f74");
        f74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f74MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f74, gridBagConstraints);

        f73.setBackground(java.awt.Color.white);
        f73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f73.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f73.setName("f73");
        f73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f73MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f73, gridBagConstraints);

        f70.setBackground(java.awt.Color.white);
        f70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f70.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f70.setName("f70");
        f70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f70MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelGame.add(f70, gridBagConstraints);

        f75.setBackground(java.awt.Color.white);
        f75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f75.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f75.setName("f75");
        f75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f75MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f75, gridBagConstraints);

        f68.setBackground(java.awt.Color.white);
        f68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f68.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f68.setName("f68");
        f68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f68MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f68, gridBagConstraints);

        f69.setBackground(java.awt.Color.white);
        f69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f69.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f69.setName("f69");
        f69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f69MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelGame.add(f69, gridBagConstraints);

        f95.setBackground(java.awt.Color.white);
        f95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f95.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f95.setName("f95");
        f95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f95MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelGame.add(f95, gridBagConstraints);

        f80.setBackground(java.awt.Color.white);
        f80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f80.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f80.setName("f80");
        f80.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f80MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelGame.add(f80, gridBagConstraints);

        f92.setBackground(java.awt.Color.white);
        f92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f92.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f92.setName("f92");
        f92.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f92MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelGame.add(f92, gridBagConstraints);

        f88.setBackground(java.awt.Color.white);
        f88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f88.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f88.setName("f88");
        f88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f88MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f88, gridBagConstraints);

        f98.setBackground(java.awt.Color.white);
        f98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f98.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f98.setName("f98");
        f98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f98MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelGame.add(f98, gridBagConstraints);

        f83.setBackground(java.awt.Color.white);
        f83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f83.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f83.setName("f83");
        f83.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f83MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f83, gridBagConstraints);

        f93.setBackground(java.awt.Color.white);
        f93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f93.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f93.setName("f93");
        f93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f93MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelGame.add(f93, gridBagConstraints);

        f89.setBackground(java.awt.Color.white);
        f89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f89.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f89.setName("f89");
        f89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f89MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelGame.add(f89, gridBagConstraints);

        f99.setBackground(java.awt.Color.white);
        f99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f99.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f99.setName("f99");
        f99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f99MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelGame.add(f99, gridBagConstraints);

        f94.setBackground(java.awt.Color.white);
        f94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f94.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f94.setName("f94");
        f94.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f94MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelGame.add(f94, gridBagConstraints);

        f87.setBackground(java.awt.Color.white);
        f87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f87.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f87.setName("f87");
        f87.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f87MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f87, gridBagConstraints);

        f81.setBackground(java.awt.Color.white);
        f81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f81.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f81.setName("f81");
        f81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f81MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f81, gridBagConstraints);

        f96.setBackground(java.awt.Color.white);
        f96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f96.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f96.setName("f96");
        f96.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f96MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelGame.add(f96, gridBagConstraints);

        f82.setBackground(java.awt.Color.white);
        f82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f82.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f82.setName("f82");
        f82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f82MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f82, gridBagConstraints);

        f97.setBackground(java.awt.Color.white);
        f97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f97.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f97.setName("f97");
        f97.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f97MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelGame.add(f97, gridBagConstraints);

        f90.setBackground(java.awt.Color.white);
        f90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f90.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f90.setName("f90");
        f90.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f90MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        panelGame.add(f90, gridBagConstraints);

        f86.setBackground(java.awt.Color.white);
        f86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f86.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f86.setName("f86");
        f86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f86MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f86, gridBagConstraints);

        f85.setBackground(java.awt.Color.white);
        f85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f85.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f85.setName("f85");
        f85.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f85MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelGame.add(f85, gridBagConstraints);

        f91.setBackground(java.awt.Color.white);
        f91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/blank.png"))); // NOI18N
        f91.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f91.setName("f91");
        f91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f91MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelGame.add(f91, gridBagConstraints);

        panelInfoArea.setOpaque(false);
        panelInfoArea.setPreferredSize(new java.awt.Dimension(394, 712));

        labelBannerInfoArea.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        labelBannerInfoArea.setForeground(new java.awt.Color(255, 255, 0));
        labelBannerInfoArea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBannerInfoArea.setText(" ");

        buttonSet.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        buttonSet.setText("Zug ausführen");
        buttonSet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSetMouseClicked(evt);
            }
        });

        buttonRestart.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        buttonRestart.setText("Neues Spiel starten");
        buttonRestart.setMaximumSize(new java.awt.Dimension(155, 29));
        buttonRestart.setMinimumSize(new java.awt.Dimension(155, 29));
        buttonRestart.setPreferredSize(new java.awt.Dimension(155, 29));
        buttonRestart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRestartMouseClicked(evt);
            }
        });

        panelInfoAreaRight.setOpaque(false);

        labelMinerPlace.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelMinerPlace.setForeground(new java.awt.Color(255, 255, 0));
        labelMinerPlace.setText("zu platzieren:");

        labelScoutName.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        labelScoutName.setForeground(new java.awt.Color(255, 255, 0));
        labelScoutName.setText("Aufklärer");

        labelBombName.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        labelBombName.setForeground(new java.awt.Color(255, 255, 0));
        labelBombName.setText("Bombe");

        labelSergeantIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/sergeant_blue.png"))); // NOI18N
        labelSergeantIcon.setName("sergeant");
        labelSergeantIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSergeantIconMouseClicked(evt);
            }
        });

        labelMinerName.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        labelMinerName.setForeground(new java.awt.Color(255, 255, 0));
        labelMinerName.setText("Mineur");

        labelBombPlace.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelBombPlace.setForeground(new java.awt.Color(255, 255, 0));
        labelBombPlace.setText("zu platzieren:");

        labelBombIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/bomb_blue.png"))); // NOI18N
        labelBombIcon.setName("bomb");
        labelBombIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBombIconMouseClicked(evt);
            }
        });

        labelMinerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/miner_blue.png"))); // NOI18N
        labelMinerIcon.setName("miner");
        labelMinerIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMinerIconMouseClicked(evt);
            }
        });

        labelSergeantName.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        labelSergeantName.setForeground(new java.awt.Color(255, 255, 0));
        labelSergeantName.setText("Unteroffizier");

        labelSpyPlace.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelSpyPlace.setForeground(new java.awt.Color(255, 255, 0));
        labelSpyPlace.setText("zu platzieren:");

        labelScoutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/scout_blue.png"))); // NOI18N
        labelScoutIcon.setName("scout");
        labelScoutIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelScoutIconMouseClicked(evt);
            }
        });

        labelLieutenantPlace.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelLieutenantPlace.setForeground(new java.awt.Color(255, 255, 0));
        labelLieutenantPlace.setText("zu platzieren:");

        labelScoutPlace.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelScoutPlace.setForeground(new java.awt.Color(255, 255, 0));
        labelScoutPlace.setText("zu platzieren:");

        labelSpyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/spy_blue.png"))); // NOI18N
        labelSpyIcon.setName("Spy");
        labelSpyIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSpyIconMouseClicked(evt);
            }
        });

        labelSpyName.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        labelSpyName.setForeground(new java.awt.Color(255, 255, 0));
        labelSpyName.setText("Spion");

        labelLieutenantIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/lieutenant_blue.png"))); // NOI18N
        labelLieutenantIcon.setName("lieutenant");
        labelLieutenantIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLieutenantIconMouseClicked(evt);
            }
        });

        labelLieutenantName.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        labelLieutenantName.setForeground(new java.awt.Color(255, 255, 0));
        labelLieutenantName.setText("Leutnant");

        labelSergeantPlace.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelSergeantPlace.setForeground(new java.awt.Color(255, 255, 0));
        labelSergeantPlace.setText("zu platzieren:");

        labelLieutenantNumber.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelLieutenantNumber.setForeground(new java.awt.Color(255, 255, 0));
        labelLieutenantNumber.setText("jLabel1");

        labelSergeantNumber.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelSergeantNumber.setForeground(new java.awt.Color(255, 255, 0));
        labelSergeantNumber.setText("jLabel2");

        labelMinerNumber.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelMinerNumber.setForeground(new java.awt.Color(255, 255, 0));
        labelMinerNumber.setText("jLabel3");

        labelScoutNumber.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelScoutNumber.setForeground(new java.awt.Color(255, 255, 0));
        labelScoutNumber.setText("jLabel4");

        labelSpyNumber.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelSpyNumber.setForeground(new java.awt.Color(255, 255, 0));
        labelSpyNumber.setText("jLabel5");

        labelBombNumber.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelBombNumber.setForeground(new java.awt.Color(255, 255, 0));
        labelBombNumber.setText("jLabel6");

        javax.swing.GroupLayout panelInfoAreaRightLayout = new javax.swing.GroupLayout(panelInfoAreaRight);
        panelInfoAreaRight.setLayout(panelInfoAreaRightLayout);
        panelInfoAreaRightLayout.setHorizontalGroup(
            panelInfoAreaRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoAreaRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoAreaRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoAreaRightLayout.createSequentialGroup()
                        .addComponent(labelLieutenantIcon)
                        .addGap(6, 6, 6)
                        .addGroup(panelInfoAreaRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelLieutenantName)
                            .addComponent(labelLieutenantPlace)
                            .addComponent(labelLieutenantNumber)))
                    .addGroup(panelInfoAreaRightLayout.createSequentialGroup()
                        .addComponent(labelSergeantIcon)
                        .addGap(6, 6, 6)
                        .addGroup(panelInfoAreaRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSergeantName)
                            .addComponent(labelSergeantPlace)
                            .addComponent(labelSergeantNumber)))
                    .addGroup(panelInfoAreaRightLayout.createSequentialGroup()
                        .addComponent(labelMinerIcon)
                        .addGap(6, 6, 6)
                        .addGroup(panelInfoAreaRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMinerName)
                            .addComponent(labelMinerPlace)
                            .addComponent(labelMinerNumber)))
                    .addGroup(panelInfoAreaRightLayout.createSequentialGroup()
                        .addComponent(labelScoutIcon)
                        .addGap(6, 6, 6)
                        .addGroup(panelInfoAreaRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelScoutName)
                            .addComponent(labelScoutPlace)
                            .addComponent(labelScoutNumber)))
                    .addGroup(panelInfoAreaRightLayout.createSequentialGroup()
                        .addComponent(labelSpyIcon)
                        .addGap(6, 6, 6)
                        .addGroup(panelInfoAreaRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSpyName)
                            .addComponent(labelSpyPlace)
                            .addComponent(labelSpyNumber)))
                    .addGroup(panelInfoAreaRightLayout.createSequentialGroup()
                        .addComponent(labelBombIcon)
                        .addGap(6, 6, 6)
                        .addGroup(panelInfoAreaRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBombName)
                            .addComponent(labelBombPlace)
                            .addComponent(labelBombNumber))))
                .addContainerGap())
        );
        panelInfoAreaRightLayout.setVerticalGroup(
            panelInfoAreaRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoAreaRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoAreaRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLieutenantIcon)
                    .addGroup(panelInfoAreaRightLayout.createSequentialGroup()
                        .addComponent(labelLieutenantName)
                        .addGap(6, 6, 6)
                        .addComponent(labelLieutenantPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelLieutenantNumber)))
                .addGap(6, 6, 6)
                .addGroup(panelInfoAreaRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSergeantIcon)
                    .addGroup(panelInfoAreaRightLayout.createSequentialGroup()
                        .addComponent(labelSergeantName)
                        .addGap(6, 6, 6)
                        .addComponent(labelSergeantPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSergeantNumber)))
                .addGap(6, 6, 6)
                .addGroup(panelInfoAreaRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMinerIcon)
                    .addGroup(panelInfoAreaRightLayout.createSequentialGroup()
                        .addComponent(labelMinerName)
                        .addGap(6, 6, 6)
                        .addComponent(labelMinerPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMinerNumber)))
                .addGap(6, 6, 6)
                .addGroup(panelInfoAreaRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelScoutIcon)
                    .addGroup(panelInfoAreaRightLayout.createSequentialGroup()
                        .addComponent(labelScoutName)
                        .addGap(6, 6, 6)
                        .addComponent(labelScoutPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelScoutNumber)))
                .addGap(6, 6, 6)
                .addGroup(panelInfoAreaRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSpyIcon)
                    .addGroup(panelInfoAreaRightLayout.createSequentialGroup()
                        .addComponent(labelSpyName)
                        .addGap(6, 6, 6)
                        .addComponent(labelSpyPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSpyNumber)))
                .addGap(6, 6, 6)
                .addGroup(panelInfoAreaRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelBombIcon)
                    .addGroup(panelInfoAreaRightLayout.createSequentialGroup()
                        .addComponent(labelBombName)
                        .addGap(6, 6, 6)
                        .addComponent(labelBombPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelBombNumber)))
                .addContainerGap())
        );

        panelInfoAreaLeft.setBackground(new java.awt.Color(0, 0, 0));
        panelInfoAreaLeft.setForeground(new java.awt.Color(255, 255, 0));
        panelInfoAreaLeft.setOpaque(false);

        labelMarshalIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/marshal_blue.png"))); // NOI18N
        labelMarshalIcon.setName("marshal");
        labelMarshalIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMarshalIconMouseClicked(evt);
            }
        });

        labelColonelName.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        labelColonelName.setForeground(new java.awt.Color(255, 255, 0));
        labelColonelName.setText("Oberst");

        labelCaptainPlace.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelCaptainPlace.setForeground(new java.awt.Color(255, 255, 0));
        labelCaptainPlace.setText("zu platzieren:");

        labelCaptainName.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        labelCaptainName.setForeground(new java.awt.Color(255, 255, 0));
        labelCaptainName.setText("Hauptmann");

        labelGeneralPlace.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelGeneralPlace.setForeground(new java.awt.Color(255, 255, 0));
        labelGeneralPlace.setText("zu platzieren:");

        labelFlagIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/flag_blue.png"))); // NOI18N
        labelFlagIcon.setName("flag");
        labelFlagIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelFlagIconMouseClicked(evt);
            }
        });

        labelCaptainIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/captain_blue.png"))); // NOI18N
        labelCaptainIcon.setName("captain");
        labelCaptainIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCaptainIconMouseClicked(evt);
            }
        });

        labelFlagPlace.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelFlagPlace.setForeground(new java.awt.Color(255, 255, 0));
        labelFlagPlace.setText("zu platzieren:");

        labelMarshalName.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        labelMarshalName.setForeground(new java.awt.Color(255, 255, 0));
        labelMarshalName.setText("Feldmarschall");

        labelMajorName.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        labelMajorName.setForeground(new java.awt.Color(255, 255, 0));
        labelMajorName.setText("Major");

        labelGeneralName.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        labelGeneralName.setForeground(new java.awt.Color(255, 255, 0));
        labelGeneralName.setText("General");

        labelMarshalPlace.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelMarshalPlace.setForeground(new java.awt.Color(255, 255, 0));
        labelMarshalPlace.setText("zu platzieren:");

        labelMajorPlace.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelMajorPlace.setForeground(new java.awt.Color(255, 255, 0));
        labelMajorPlace.setText("zu platzieren:");

        labelFlagName.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        labelFlagName.setForeground(new java.awt.Color(255, 255, 0));
        labelFlagName.setText("Flagge");

        labelGeneralIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/general_blue.png"))); // NOI18N
        labelGeneralIcon.setName("general");
        labelGeneralIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelGeneralIconMouseClicked(evt);
            }
        });

        labelColonelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/colonel_blue.png"))); // NOI18N
        labelColonelIcon.setName("colonel");
        labelColonelIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelColonelIconMouseClicked(evt);
            }
        });

        labelColonelPlace.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelColonelPlace.setForeground(new java.awt.Color(255, 255, 0));
        labelColonelPlace.setText("zu platzieren:");

        labelMajorIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jstratego/gui/img/major_blue.png"))); // NOI18N
        labelMajorIcon.setName("major");
        labelMajorIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMajorIconMouseClicked(evt);
            }
        });

        labelFlagNumber.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelFlagNumber.setForeground(new java.awt.Color(255, 255, 0));
        labelFlagNumber.setText("jLabel1");

        labelMarshalNumber.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelMarshalNumber.setForeground(new java.awt.Color(255, 255, 0));
        labelMarshalNumber.setText("jLabel1");

        labelGeneralNumber.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelGeneralNumber.setForeground(new java.awt.Color(255, 255, 0));
        labelGeneralNumber.setText("jLabel1");

        labelColonelNumber.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelColonelNumber.setForeground(new java.awt.Color(255, 255, 0));
        labelColonelNumber.setText("jLabel2");

        labelMajorNumber.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelMajorNumber.setForeground(new java.awt.Color(255, 255, 0));
        labelMajorNumber.setText("jLabel3");

        labelCaptainNumber.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelCaptainNumber.setForeground(new java.awt.Color(255, 255, 0));
        labelCaptainNumber.setText("jLabel4");

        javax.swing.GroupLayout panelInfoAreaLeftLayout = new javax.swing.GroupLayout(panelInfoAreaLeft);
        panelInfoAreaLeft.setLayout(panelInfoAreaLeftLayout);
        panelInfoAreaLeftLayout.setHorizontalGroup(
            panelInfoAreaLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoAreaLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoAreaLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoAreaLeftLayout.createSequentialGroup()
                        .addComponent(labelFlagIcon)
                        .addGap(6, 6, 6)
                        .addGroup(panelInfoAreaLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelFlagName)
                            .addComponent(labelFlagPlace)
                            .addComponent(labelFlagNumber)))
                    .addGroup(panelInfoAreaLeftLayout.createSequentialGroup()
                        .addComponent(labelMarshalIcon)
                        .addGap(6, 6, 6)
                        .addGroup(panelInfoAreaLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMarshalName)
                            .addComponent(labelMarshalPlace)
                            .addComponent(labelMarshalNumber)))
                    .addGroup(panelInfoAreaLeftLayout.createSequentialGroup()
                        .addComponent(labelGeneralIcon)
                        .addGap(6, 6, 6)
                        .addGroup(panelInfoAreaLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelGeneralName)
                            .addComponent(labelGeneralPlace)
                            .addComponent(labelGeneralNumber)))
                    .addGroup(panelInfoAreaLeftLayout.createSequentialGroup()
                        .addComponent(labelColonelIcon)
                        .addGap(6, 6, 6)
                        .addGroup(panelInfoAreaLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelColonelName)
                            .addComponent(labelColonelPlace)
                            .addComponent(labelColonelNumber)))
                    .addGroup(panelInfoAreaLeftLayout.createSequentialGroup()
                        .addComponent(labelMajorIcon)
                        .addGap(6, 6, 6)
                        .addGroup(panelInfoAreaLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMajorName)
                            .addComponent(labelMajorPlace)
                            .addComponent(labelMajorNumber)))
                    .addGroup(panelInfoAreaLeftLayout.createSequentialGroup()
                        .addComponent(labelCaptainIcon)
                        .addGap(6, 6, 6)
                        .addGroup(panelInfoAreaLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCaptainName)
                            .addComponent(labelCaptainPlace)
                            .addComponent(labelCaptainNumber))))
                .addContainerGap())
        );
        panelInfoAreaLeftLayout.setVerticalGroup(
            panelInfoAreaLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoAreaLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoAreaLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFlagIcon)
                    .addGroup(panelInfoAreaLeftLayout.createSequentialGroup()
                        .addComponent(labelFlagName)
                        .addGap(6, 6, 6)
                        .addComponent(labelFlagPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelFlagNumber)))
                .addGap(6, 6, 6)
                .addGroup(panelInfoAreaLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMarshalIcon)
                    .addGroup(panelInfoAreaLeftLayout.createSequentialGroup()
                        .addComponent(labelMarshalName)
                        .addGap(6, 6, 6)
                        .addComponent(labelMarshalPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMarshalNumber)))
                .addGap(6, 6, 6)
                .addGroup(panelInfoAreaLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelGeneralIcon)
                    .addGroup(panelInfoAreaLeftLayout.createSequentialGroup()
                        .addComponent(labelGeneralName)
                        .addGap(6, 6, 6)
                        .addComponent(labelGeneralPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelGeneralNumber)))
                .addGap(6, 6, 6)
                .addGroup(panelInfoAreaLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelColonelIcon)
                    .addGroup(panelInfoAreaLeftLayout.createSequentialGroup()
                        .addComponent(labelColonelName)
                        .addGap(6, 6, 6)
                        .addComponent(labelColonelPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelColonelNumber)))
                .addGap(6, 6, 6)
                .addGroup(panelInfoAreaLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMajorIcon)
                    .addGroup(panelInfoAreaLeftLayout.createSequentialGroup()
                        .addComponent(labelMajorName)
                        .addGap(6, 6, 6)
                        .addComponent(labelMajorPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMajorNumber)))
                .addGap(6, 6, 6)
                .addGroup(panelInfoAreaLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCaptainIcon)
                    .addGroup(panelInfoAreaLeftLayout.createSequentialGroup()
                        .addComponent(labelCaptainName)
                        .addGap(6, 6, 6)
                        .addComponent(labelCaptainPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCaptainNumber)))
                .addContainerGap())
        );

        labelPlayer.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        labelPlayer.setForeground(new java.awt.Color(255, 255, 0));
        labelPlayer.setText("Spieler am Zug: XX Maximallänge beachten XXXXXXXX");

        javax.swing.GroupLayout panelInfoAreaLayout = new javax.swing.GroupLayout(panelInfoArea);
        panelInfoArea.setLayout(panelInfoAreaLayout);
        panelInfoAreaLayout.setHorizontalGroup(
            panelInfoAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoAreaLayout.createSequentialGroup()
                .addComponent(labelBannerInfoArea, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(panelInfoAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoAreaLayout.createSequentialGroup()
                        .addGroup(panelInfoAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelInfoAreaLayout.createSequentialGroup()
                                .addComponent(panelInfoAreaLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelInfoAreaRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonRestart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonSet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labelPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelInfoAreaLayout.setVerticalGroup(
            panelInfoAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoAreaLayout.createSequentialGroup()
                .addComponent(labelBannerInfoArea, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPlayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(panelInfoAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInfoAreaLeft, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelInfoAreaRight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSet, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInfoArea, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGame, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelInfoArea, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//<editor-fold defaultstate="collapsed" desc=" MouseClickedEvents of all functional items">
    private void f34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f34MouseClicked
        callMove(f34);
    }//GEN-LAST:event_f34MouseClicked

    private void f33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f33MouseClicked
        callMove(f33);
    }//GEN-LAST:event_f33MouseClicked

    private void f00MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f00MouseClicked
        callMove(f00);
    }//GEN-LAST:event_f00MouseClicked

    private void f01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f01MouseClicked
        callMove(f01);
    }//GEN-LAST:event_f01MouseClicked

    private void f02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f02MouseClicked
        callMove(f02);
    }//GEN-LAST:event_f02MouseClicked

    private void f03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f03MouseClicked
        callMove(f03);
    }//GEN-LAST:event_f03MouseClicked

    private void f04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f04MouseClicked
        callMove(f04);
    }//GEN-LAST:event_f04MouseClicked

    private void f05MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f05MouseClicked
        callMove(f05);
    }//GEN-LAST:event_f05MouseClicked

    private void f06MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f06MouseClicked
        callMove(f06);
    }//GEN-LAST:event_f06MouseClicked

    private void f07MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f07MouseClicked
        callMove(f07);
    }//GEN-LAST:event_f07MouseClicked

    private void f08MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f08MouseClicked
        callMove(f08);
    }//GEN-LAST:event_f08MouseClicked

    private void f09MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f09MouseClicked
        callMove(f09);
    }//GEN-LAST:event_f09MouseClicked

    private void f10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f10MouseClicked
        callMove(f10);
    }//GEN-LAST:event_f10MouseClicked

    private void f11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f11MouseClicked
        callMove(f11);
    }//GEN-LAST:event_f11MouseClicked

    private void f12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f12MouseClicked
        callMove(f12);
    }//GEN-LAST:event_f12MouseClicked

    private void f13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f13MouseClicked
        callMove(f13);
    }//GEN-LAST:event_f13MouseClicked

    private void f14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f14MouseClicked
        callMove(f14);
    }//GEN-LAST:event_f14MouseClicked

    private void f15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f15MouseClicked
        callMove(f15);
    }//GEN-LAST:event_f15MouseClicked

    private void f16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f16MouseClicked
        callMove(f16);
    }//GEN-LAST:event_f16MouseClicked

    private void f17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f17MouseClicked
        callMove(f17);
    }//GEN-LAST:event_f17MouseClicked

    private void f18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f18MouseClicked
        callMove(f18);
    }//GEN-LAST:event_f18MouseClicked

    private void f19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f19MouseClicked
        callMove(f19);
    }//GEN-LAST:event_f19MouseClicked

    private void f20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f20MouseClicked
        callMove(f20);
    }//GEN-LAST:event_f20MouseClicked

    private void f21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f21MouseClicked
        callMove(f21);
    }//GEN-LAST:event_f21MouseClicked

    private void f22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f22MouseClicked
        callMove(f22);
    }//GEN-LAST:event_f22MouseClicked

    private void f23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f23MouseClicked
        callMove(f23);
    }//GEN-LAST:event_f23MouseClicked

    private void f24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f24MouseClicked
        callMove(f24);
    }//GEN-LAST:event_f24MouseClicked

    private void f25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f25MouseClicked
        callMove(f25);
    }//GEN-LAST:event_f25MouseClicked

    private void f26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f26MouseClicked
        callMove(f26);
    }//GEN-LAST:event_f26MouseClicked

    private void f27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f27MouseClicked
        callMove(f27);
    }//GEN-LAST:event_f27MouseClicked

    private void f28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f28MouseClicked
        callMove(f28);
    }//GEN-LAST:event_f28MouseClicked

    private void f29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f29MouseClicked
        callMove(f29);
    }//GEN-LAST:event_f29MouseClicked

    private void f30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f30MouseClicked
        callMove(f30);
    }//GEN-LAST:event_f30MouseClicked

    private void f31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f31MouseClicked
        callMove(f31);
    }//GEN-LAST:event_f31MouseClicked

    private void f32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f32MouseClicked
        callMove(f32);
    }//GEN-LAST:event_f32MouseClicked

    private void f35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f35MouseClicked
        callMove(f35);
    }//GEN-LAST:event_f35MouseClicked

    private void f36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f36MouseClicked
        callMove(f36);
    }//GEN-LAST:event_f36MouseClicked

    private void f37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f37MouseClicked
        callMove(f37);
    }//GEN-LAST:event_f37MouseClicked

    private void f38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f38MouseClicked
        callMove(f38);
    }//GEN-LAST:event_f38MouseClicked

    private void f39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f39MouseClicked
        callMove(f39);
    }//GEN-LAST:event_f39MouseClicked

    private void f40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f40MouseClicked
        callMove(f40);
    }//GEN-LAST:event_f40MouseClicked

    private void f41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f41MouseClicked
        callMove(f41);
    }//GEN-LAST:event_f41MouseClicked

    private void f44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f44MouseClicked
        callMove(f44);
    }//GEN-LAST:event_f44MouseClicked

    private void f45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f45MouseClicked
        callMove(f45);
    }//GEN-LAST:event_f45MouseClicked

    private void f48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f48MouseClicked
        callMove(f48);
    }//GEN-LAST:event_f48MouseClicked

    private void f49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f49MouseClicked
        callMove(f49);
    }//GEN-LAST:event_f49MouseClicked

    private void f50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f50MouseClicked
        callMove(f50);
    }//GEN-LAST:event_f50MouseClicked

    private void f51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f51MouseClicked
        callMove(f51);
    }//GEN-LAST:event_f51MouseClicked

    private void f54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f54MouseClicked
        callMove(f54);
    }//GEN-LAST:event_f54MouseClicked

    private void f55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f55MouseClicked
        callMove(f55);
    }//GEN-LAST:event_f55MouseClicked

    private void f58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f58MouseClicked
        callMove(f58);
    }//GEN-LAST:event_f58MouseClicked

    private void f59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f59MouseClicked
        callMove(f59);
    }//GEN-LAST:event_f59MouseClicked

    private void f60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f60MouseClicked
        callMove(f60);
    }//GEN-LAST:event_f60MouseClicked

    private void f61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f61MouseClicked
        callMove(f61);
    }//GEN-LAST:event_f61MouseClicked

    private void f62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f62MouseClicked
        callMove(f62);
    }//GEN-LAST:event_f62MouseClicked

    private void f63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f63MouseClicked
        callMove(f63);
    }//GEN-LAST:event_f63MouseClicked

    private void f64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f64MouseClicked
        callMove(f64);
    }//GEN-LAST:event_f64MouseClicked

    private void f65MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f65MouseClicked
        callMove(f65);
    }//GEN-LAST:event_f65MouseClicked

    private void f66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f66MouseClicked
        callMove(f66);
    }//GEN-LAST:event_f66MouseClicked

    private void f67MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f67MouseClicked
        callMove(f67);
    }//GEN-LAST:event_f67MouseClicked

    private void f68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f68MouseClicked
        callMove(f68);
    }//GEN-LAST:event_f68MouseClicked

    private void f69MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f69MouseClicked
        callMove(f69);
    }//GEN-LAST:event_f69MouseClicked

    private void f70MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f70MouseClicked
        callMove(f70);
    }//GEN-LAST:event_f70MouseClicked

    private void f71MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f71MouseClicked
        callMove(f71);
    }//GEN-LAST:event_f71MouseClicked

    private void f72MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f72MouseClicked
        callMove(f72);
    }//GEN-LAST:event_f72MouseClicked

    private void f73MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f73MouseClicked
        callMove(f73);
    }//GEN-LAST:event_f73MouseClicked

    private void f74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f74MouseClicked
        callMove(f74);
    }//GEN-LAST:event_f74MouseClicked

    private void f75MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f75MouseClicked
        callMove(f75);
    }//GEN-LAST:event_f75MouseClicked

    private void f76MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f76MouseClicked
        callMove(f76);
    }//GEN-LAST:event_f76MouseClicked

    private void f77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f77MouseClicked
        callMove(f77);
    }//GEN-LAST:event_f77MouseClicked

    private void f78MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f78MouseClicked
        callMove(f78);
    }//GEN-LAST:event_f78MouseClicked

    private void f79MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f79MouseClicked
        callMove(f79);
    }//GEN-LAST:event_f79MouseClicked

    private void f80MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f80MouseClicked
        callMove(f80);
    }//GEN-LAST:event_f80MouseClicked

    private void f81MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f81MouseClicked
        callMove(f81);
    }//GEN-LAST:event_f81MouseClicked

    private void f82MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f82MouseClicked
        callMove(f82);
    }//GEN-LAST:event_f82MouseClicked

    private void f83MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f83MouseClicked
        callMove(f83);
    }//GEN-LAST:event_f83MouseClicked

    private void f84MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f84MouseClicked
        callMove(f84);
    }//GEN-LAST:event_f84MouseClicked

    private void f85MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f85MouseClicked
        callMove(f85);
    }//GEN-LAST:event_f85MouseClicked

    private void f86MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f86MouseClicked
        callMove(f86);
    }//GEN-LAST:event_f86MouseClicked

    private void f87MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f87MouseClicked
        callMove(f87);
    }//GEN-LAST:event_f87MouseClicked

    private void f88MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f88MouseClicked
        callMove(f88);
    }//GEN-LAST:event_f88MouseClicked

    private void f89MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f89MouseClicked
        callMove(f89);
    }//GEN-LAST:event_f89MouseClicked

    private void f90MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f90MouseClicked
        callMove(f90);
    }//GEN-LAST:event_f90MouseClicked

    private void f91MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f91MouseClicked
        callMove(f91);
    }//GEN-LAST:event_f91MouseClicked

    private void f92MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f92MouseClicked
        callMove(f92);
    }//GEN-LAST:event_f92MouseClicked

    private void f93MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f93MouseClicked
        callMove(f93);
    }//GEN-LAST:event_f93MouseClicked

    private void f94MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f94MouseClicked
        callMove(f94);
    }//GEN-LAST:event_f94MouseClicked

    private void f95MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f95MouseClicked
        callMove(f95);
    }//GEN-LAST:event_f95MouseClicked

    private void f96MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f96MouseClicked
        callMove(f96);
    }//GEN-LAST:event_f96MouseClicked

    private void f97MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f97MouseClicked
        callMove(f97);
    }//GEN-LAST:event_f97MouseClicked

    private void f98MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f98MouseClicked
        callMove(f98);
    }//GEN-LAST:event_f98MouseClicked

    private void f99MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f99MouseClicked
        callMove(f99);
    }//GEN-LAST:event_f99MouseClicked

    /*
     * Restarts game at every time.
     */
    private void buttonRestartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRestartMouseClicked

        int confirm = JOptionPane.showConfirmDialog(null, "Wirklich neues Spiel starten?", "Neues Spiel", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            jstratego.gui.game.StartScreen.main(null);
            setVisible(false);
        }
    }//GEN-LAST:event_buttonRestartMouseClicked

    private void labelFlagIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFlagIconMouseClicked
        callMove(labelFlagIcon);
    }//GEN-LAST:event_labelFlagIconMouseClicked

    private void labelMarshalIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMarshalIconMouseClicked
        callMove(labelMarshalIcon);
    }//GEN-LAST:event_labelMarshalIconMouseClicked

    private void labelGeneralIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelGeneralIconMouseClicked
        callMove(labelGeneralIcon);
    }//GEN-LAST:event_labelGeneralIconMouseClicked

    private void buttonSetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSetMouseClicked
        PlayGame();
    }//GEN-LAST:event_buttonSetMouseClicked

    private void labelColonelIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelColonelIconMouseClicked
        callMove(labelColonelIcon);
    }//GEN-LAST:event_labelColonelIconMouseClicked

    private void labelMajorIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMajorIconMouseClicked
        callMove(labelMajorIcon);
    }//GEN-LAST:event_labelMajorIconMouseClicked

    private void labelCaptainIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCaptainIconMouseClicked
        callMove(labelCaptainIcon);
    }//GEN-LAST:event_labelCaptainIconMouseClicked

    private void labelLieutenantIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLieutenantIconMouseClicked
        callMove(labelLieutenantIcon);
    }//GEN-LAST:event_labelLieutenantIconMouseClicked

    private void labelSergeantIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSergeantIconMouseClicked
        callMove(labelSergeantIcon);
    }//GEN-LAST:event_labelSergeantIconMouseClicked

    private void labelMinerIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMinerIconMouseClicked
        callMove(labelMinerIcon);
    }//GEN-LAST:event_labelMinerIconMouseClicked

    private void labelScoutIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelScoutIconMouseClicked
        callMove(labelScoutIcon);
    }//GEN-LAST:event_labelScoutIconMouseClicked

    private void labelSpyIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSpyIconMouseClicked
        callMove(labelSpyIcon);
    }//GEN-LAST:event_labelSpyIconMouseClicked

    private void labelBombIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBombIconMouseClicked
        callMove(labelBombIcon);
    }//GEN-LAST:event_labelBombIconMouseClicked
//</editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(Game game) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;








                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        currentGame = game;
        currentGame.gameState.setLastGamephase(null);

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PlayBoard().setVisible(true);
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRestart;
    private javax.swing.JButton buttonSet;
    private javax.swing.JLabel f00;
    private javax.swing.JLabel f01;
    private javax.swing.JLabel f02;
    private javax.swing.JLabel f03;
    private javax.swing.JLabel f04;
    private javax.swing.JLabel f05;
    private javax.swing.JLabel f06;
    private javax.swing.JLabel f07;
    private javax.swing.JLabel f08;
    private javax.swing.JLabel f09;
    private javax.swing.JLabel f10;
    private javax.swing.JLabel f11;
    private javax.swing.JLabel f12;
    private javax.swing.JLabel f13;
    private javax.swing.JLabel f14;
    private javax.swing.JLabel f15;
    private javax.swing.JLabel f16;
    private javax.swing.JLabel f17;
    private javax.swing.JLabel f18;
    private javax.swing.JLabel f19;
    private javax.swing.JLabel f20;
    private javax.swing.JLabel f21;
    private javax.swing.JLabel f22;
    private javax.swing.JLabel f23;
    private javax.swing.JLabel f24;
    private javax.swing.JLabel f25;
    private javax.swing.JLabel f26;
    private javax.swing.JLabel f27;
    private javax.swing.JLabel f28;
    private javax.swing.JLabel f29;
    private javax.swing.JLabel f30;
    private javax.swing.JLabel f31;
    private javax.swing.JLabel f32;
    private javax.swing.JLabel f33;
    private javax.swing.JLabel f34;
    private javax.swing.JLabel f35;
    private javax.swing.JLabel f36;
    private javax.swing.JLabel f37;
    private javax.swing.JLabel f38;
    private javax.swing.JLabel f39;
    private javax.swing.JLabel f40;
    private javax.swing.JLabel f41;
    private javax.swing.JLabel f42;
    private javax.swing.JLabel f43;
    private javax.swing.JLabel f44;
    private javax.swing.JLabel f45;
    private javax.swing.JLabel f46;
    private javax.swing.JLabel f47;
    private javax.swing.JLabel f48;
    private javax.swing.JLabel f49;
    private javax.swing.JLabel f50;
    private javax.swing.JLabel f51;
    private javax.swing.JLabel f52;
    private javax.swing.JLabel f53;
    private javax.swing.JLabel f54;
    private javax.swing.JLabel f55;
    private javax.swing.JLabel f56;
    private javax.swing.JLabel f57;
    private javax.swing.JLabel f58;
    private javax.swing.JLabel f59;
    private javax.swing.JLabel f60;
    private javax.swing.JLabel f61;
    private javax.swing.JLabel f62;
    private javax.swing.JLabel f63;
    private javax.swing.JLabel f64;
    private javax.swing.JLabel f65;
    private javax.swing.JLabel f66;
    private javax.swing.JLabel f67;
    private javax.swing.JLabel f68;
    private javax.swing.JLabel f69;
    private javax.swing.JLabel f70;
    private javax.swing.JLabel f71;
    private javax.swing.JLabel f72;
    private javax.swing.JLabel f73;
    private javax.swing.JLabel f74;
    private javax.swing.JLabel f75;
    private javax.swing.JLabel f76;
    private javax.swing.JLabel f77;
    private javax.swing.JLabel f78;
    private javax.swing.JLabel f79;
    private javax.swing.JLabel f80;
    private javax.swing.JLabel f81;
    private javax.swing.JLabel f82;
    private javax.swing.JLabel f83;
    private javax.swing.JLabel f84;
    private javax.swing.JLabel f85;
    private javax.swing.JLabel f86;
    private javax.swing.JLabel f87;
    private javax.swing.JLabel f88;
    private javax.swing.JLabel f89;
    private javax.swing.JLabel f90;
    private javax.swing.JLabel f91;
    private javax.swing.JLabel f92;
    private javax.swing.JLabel f93;
    private javax.swing.JLabel f94;
    private javax.swing.JLabel f95;
    private javax.swing.JLabel f96;
    private javax.swing.JLabel f97;
    private javax.swing.JLabel f98;
    private javax.swing.JLabel f99;
    private javax.swing.JLabel labelBannerInfoArea;
    private javax.swing.JLabel labelBombIcon;
    private javax.swing.JLabel labelBombName;
    private javax.swing.JLabel labelBombNumber;
    private javax.swing.JLabel labelBombPlace;
    private javax.swing.JLabel labelCaptainIcon;
    private javax.swing.JLabel labelCaptainName;
    private javax.swing.JLabel labelCaptainNumber;
    private javax.swing.JLabel labelCaptainPlace;
    private javax.swing.JLabel labelColonelIcon;
    private javax.swing.JLabel labelColonelName;
    private javax.swing.JLabel labelColonelNumber;
    private javax.swing.JLabel labelColonelPlace;
    private javax.swing.JLabel labelFlagIcon;
    private javax.swing.JLabel labelFlagName;
    private javax.swing.JLabel labelFlagNumber;
    private javax.swing.JLabel labelFlagPlace;
    private javax.swing.JLabel labelGeneralIcon;
    private javax.swing.JLabel labelGeneralName;
    private javax.swing.JLabel labelGeneralNumber;
    private javax.swing.JLabel labelGeneralPlace;
    private javax.swing.JLabel labelLieutenantIcon;
    private javax.swing.JLabel labelLieutenantName;
    private javax.swing.JLabel labelLieutenantNumber;
    private javax.swing.JLabel labelLieutenantPlace;
    private javax.swing.JLabel labelMajorIcon;
    private javax.swing.JLabel labelMajorName;
    private javax.swing.JLabel labelMajorNumber;
    private javax.swing.JLabel labelMajorPlace;
    private javax.swing.JLabel labelMarshalIcon;
    private javax.swing.JLabel labelMarshalName;
    private javax.swing.JLabel labelMarshalNumber;
    private javax.swing.JLabel labelMarshalPlace;
    private javax.swing.JLabel labelMinerIcon;
    private javax.swing.JLabel labelMinerName;
    private javax.swing.JLabel labelMinerNumber;
    private javax.swing.JLabel labelMinerPlace;
    private javax.swing.JLabel labelPlayer;
    private javax.swing.JLabel labelScoutIcon;
    private javax.swing.JLabel labelScoutName;
    private javax.swing.JLabel labelScoutNumber;
    private javax.swing.JLabel labelScoutPlace;
    private javax.swing.JLabel labelSergeantIcon;
    private javax.swing.JLabel labelSergeantName;
    private javax.swing.JLabel labelSergeantNumber;
    private javax.swing.JLabel labelSergeantPlace;
    private javax.swing.JLabel labelSpyIcon;
    private javax.swing.JLabel labelSpyName;
    private javax.swing.JLabel labelSpyNumber;
    private javax.swing.JLabel labelSpyPlace;
    private javax.swing.JPanel panelGame;
    private javax.swing.JPanel panelInfoArea;
    private javax.swing.JPanel panelInfoAreaLeft;
    private javax.swing.JPanel panelInfoAreaRight;
    // End of variables declaration//GEN-END:variables
}
