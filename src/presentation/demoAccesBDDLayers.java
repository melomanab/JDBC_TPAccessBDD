package presentation;



import java.util.ArrayList;

import DAO.ClientDao;
import domaine.Client;

public class demoAccesBDDLayers {

	public static void main(String[] args) {

	
		// --------------------------------------------
		// Acces à une BDD avec Java en 5 etapes
		// --------------------------------------------
		
		Client monClient;
		ClientDao daoClient;
		
		// ATTENTION: Erreur d'execution si id existe dejà
		int ID = 105;
		
		monClient = new Client(ID, "Moreno", "Beatriz", 27, 2);
		daoClient = new ClientDao();
		
		// --- Creer Client	
		System.out.println("--> CRUD(1)-CREATE:");
		boolean resCreate = daoClient.createClient(monClient);
		if (resCreate) {
			System.out.println("--- Client rajouté à la table 'client' avec succes <--\n");
		}

	
		// --- Retrieve Client	
		System.out.println("--> CRUD(2)-RETREIVE:");
		monClient = daoClient.getClient(ID);
		System.out.println("--- Infos client:" + monClient + " <--\n");

		
		// --- Update Client	
		System.out.println("--> CRUD(3)-UPDATE:");
		monClient.setNom("Cerutti");
		boolean resUpdate = daoClient.updateClient(monClient);
		if (resUpdate) {
		System.out.println("--- Client mis à jour avec succes <--\n");
		}
		
		// Check manuel
//		monClient = daoClient.getClient(ID);
//		System.out.println(monClient);
				
		// --- Delete Client	
		System.out.println("--> CRUD(4)-DELETE:");
		boolean resDelete = daoClient.deleteClient(monClient);
		if (resDelete) {
		System.out.println("--- Client effacé avec succes <--\n");
		}
			
		// --- getAll Clients	
		System.out.println("--> CRUD(5)-GETALL:");
		ArrayList<Client> mesClients;
		mesClients = daoClient.getAllClients() ;
		if(!mesClients.isEmpty()) {
			System.out.println("--- Liste de clients recuperée avec succes: ");
			for (Client c: mesClients) {
				System.out.println(c);
			}
			System.out.println("<--\n");
		}

	}
}


