package melomanab.presentation;


import java.util.ArrayList;


import melomanab.domaine.Client;
import melomanab.service.ServiceClient;

public class Main {

	public static void main(String[] args) {

	
		// --------------------------------------------
		// Acces à une BDD avec Java en 5 etapes
		// --------------------------------------------
		
		Client monClient;
		ServiceClient servC;
		
		// ATTENTION: Erreur d'execution si id existe dejà
		int ID = 106;	
		monClient = new Client(ID, "Moreno", "Beatriz", 27, 2);
		servC = new ServiceClient();
		
		// --- Creer Client	
		System.out.println("--> CRUD(1)-CREATE:");
		boolean resCreate = servC.createNewClient(monClient);
		
		String message = resCreate ? "--- Insert realisé avec succes <--\n"
				: "--- Erreur rencontré lors du Insert <--\n";
		System.out.println(message);
		

		// --- Retrieve Client	
		System.out.println("--> CRUD(2)-RETREIVE:");
		Client clientRetrieved = servC.getOneClient(monClient);
		System.out.println("--- Infos client:\t" + clientRetrieved + " <--\n");

	
		// --- Update Client	
		System.out.println("--> CRUD(3)-UPDATE:");
		monClient.setNom("Cerutti");
		boolean resUpdate = servC.updateOneClient(monClient);
		
		String messageUpdate = resUpdate ? "--- Client mis à jour avec succes <--\n"
				: "--- Erreur rencontré lors de la mise à jour <--\n";
		
		System.out.println(messageUpdate);
		
		
		// Check manuel
		monClient = servC.getOneClient(monClient);
		System.out.println(monClient);
				
		// --- Delete Client	
		System.out.println("--> CRUD(4)-DELETE:");
		boolean resDelete = servC.deleteOneClient(monClient);
		
		String messageDelete = resDelete ? "--- Client effacé avec succes <--\n"
				: "--- Erreur rencontré lors de la suppresion <--\n";
		
		System.out.println(messageDelete);

				
		// --- getAll Clients	
		System.out.println("--> CRUD(5)-GETALL:");
		ArrayList<Client> mesClients;
		mesClients = servC.getListeClients() ;
		if(!mesClients.isEmpty()) {
			System.out.println("--- Liste de clients recuperée avec succes: ");
			for (Client c: mesClients) {
				System.out.println(c);
			}
			System.out.println("<--\n");
		}
/*
*/
	}
}


