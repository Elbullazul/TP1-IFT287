// Travail fait par :
//   Martin Roy - roym2245
//   Christian Medel - medc2402

package tp1;

import java.io.PrintWriter;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import parser.XMLHandler;
import parser.objects.MainBody;

/**
 * Fichier de base pour le Devoir1A du cours IFT287
 *
 * <pre>
 * 
 * Vincent Ducharme
 * Universite de Sherbrooke
 * Version 1.0 - 6 août 2016
 * IFT287 - Exploitation de BD relationnelles et OO
 * 
 * Ce programme permet de convertir un fichier XML en son équivalent en JSON.
 *
 * Paramètres du programme
 * 0- Nom du fichier XML
 * 1- Nom du fichier JSON
 * 
 * </pre>
 */
public class Devoir1A
{

	public static void main(String[] args)
	{
		if (args.length < 2)
		{
			System.out.println("Usage: java tp1.Devoir1A <fichierXML> <fichierJSON>");
			return;
		}

		String nomFichierXML = args[0];
		String nomFichierJSON = args[1];

		System.out.println("Debut de la conversion du fichier " + nomFichierXML + " vers le fichier " + nomFichierJSON);

		// Votre code de conversion devrait aller ici
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();

			XMLHandler handler = new XMLHandler();
			parser.parse(nomFichierXML, handler);
			MainBody m = handler.getBody();
			
			try (PrintWriter out = new PrintWriter(nomFichierJSON)) {
				out.println(m.toJSON().toString());
			}

		} catch (Exception e) {
			System.out.print("An error ocurred: ");
			e.printStackTrace();
		}

		System.out.println("Conversion terminee.");
	}

}
