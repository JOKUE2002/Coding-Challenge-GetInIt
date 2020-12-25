import java.util.ArrayList;

/**
 * Ein Transporter, welcher die Waren transportieren soll.
 */
public class Transporter {
    
    /**
     * Transporter Nummer
     */
    int number;

    /**
     * Maxmiale Zuladung des Transporters
     */
    int totalUsableWeight;

    /**
     * Gewicht des Fahrers
     */
    int driverWeight;

    /**
     * Alle zugeladenen Geraete
     */
    ArrayList<Geraet> freightLoaded;


    /**
     * Initialisiert einen dummy Transporter (0,0,0)
     */
    public Transporter() {
        number = 0;
        totalUsableWeight = 0;
        driverWeight = 0;

        freightLoaded = new ArrayList<Geraet>();
    }

    /**
     * Initialisiert einen Transporter mit gegebenen Werten
     */
    public Transporter(int number, int totalUsableWeight, int driverWeight) {
        this.number = number;
        this.totalUsableWeight = totalUsableWeight;
        this.driverWeight = driverWeight;

        freightLoaded = new ArrayList<Geraet>();
    }

    /**
     * Fuegt ein Frachtstueck hinzu. 
     * Sollte die Anzahl 0 sein, wird kein Frachtstuck eingefuegt.
     */
    public void addFreight(Geraet newGeraet, int count) {
        if(count <= 0){
            return;
        }

        freightLoaded.add(newGeraet.numberLoaded(count));
    }

    /**
     * Gibt die Summe der Prioritaeten zurueck, sodass ein Gesamtergebniss fuer den Transporter feststeht.
     */
    public double getTotalPrioritySum() {
        int sum = 0;
        
        for (Geraet geraet : freightLoaded) {
            sum += geraet.getPriority() * geraet.getNumberLoaded();
        }

        return sum;
    }

    /**
     * Gibt die verbleibende Zuladung zurueck.
     */
    public int getRemainingUsableWeight() {
        int sumLoaded = 0;
        
        for (Geraet geraet : freightLoaded) {
            sumLoaded += geraet.getNumberLoaded() * geraet.getWeight();
        }

        return (totalUsableWeight - driverWeight - sumLoaded);
    }

    /**
     * Gibt in der Konsole aus, was der Transporter geladen hat.
     */
	public void print() {
        System.out.println("***** Transporter No. " + number + " *****");

        System.out.println("* Remaining u.weight: " + getRemainingUsableWeight());
        System.out.println("* Freight: ");
        for (Geraet geraet : freightLoaded) {
            System.out.println("  * '" + geraet.getName() + "' - " + geraet.getNumberLoaded() + " (" + geraet.getPriority() + ")");
        }
        System.out.println("* Total value: " + getTotalPrioritySum());

        System.out.println("*****************************");
	}
}
