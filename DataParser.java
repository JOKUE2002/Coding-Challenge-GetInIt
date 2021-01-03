import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * Liest eine .CSV Datei mit den entsprechenden Daten aus.
 */
public class DataParser {
    
    /**
     * Die ausgewaehlte Datei
     */
    private String selectedFile = "";

    /**
     * Liest eine gegebene Datei
     */
    public DataParser(String inputFile) {
        this.selectedFile = inputFile;
    }

    /**
     * Liest eine Datei.
     * Ruft dazu einen JFileChooser auf, welcher den Nutzer eine Datei waehlen laesst.
     */
    public DataParser() {
        try {
            EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    String folder = System.getProperty("user.dir");
                    JFileChooser fc = new JFileChooser(folder);
                    fc.showOpenDialog(null);
                    selectedFile = fc.getSelectedFile().getAbsolutePath();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(this.selectedFile);
    }

    /**
     * Liest die Datei. Gibt eine ArrayList mit den Geraeten zurueck.
     */
    public ArrayList<Geraet> parseFile() {
        ArrayList<Geraet> buffer = new ArrayList<Geraet>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(selectedFile));

            String line = "";
            while((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                
                Geraet tmp = new Geraet(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), Integer.valueOf(parts[3]));

                buffer.add(tmp);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer;
    }
}
