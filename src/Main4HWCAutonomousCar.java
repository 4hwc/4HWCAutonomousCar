import com.autonomouscar.view.BienvenueAxivIt;
import com.autonomouscar.view.MenuAxivIt;

public class Main4HWCAutonomousCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println(Integer.valueOf("4").intValue());

		BienvenueAxivIt fenBienvenue = new BienvenueAxivIt(); // Première
																// fenêtre

		BienvenueAxivIt.voixBienvenueAxivIt(); // Voix de bienvenue première
												// fenêtre

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		fenBienvenue.setVisible(false); // Fermeture de la première fenêtre

		new MenuAxivIt(); // Affichage deuxième fenêtre de
							// menu

		// MenuAxivIt.voixMenuAxivIt();

	}

}
