// Travail fait par :
//   NomEquipier1 - Matricule
//   NomEquipier2 - Matricule

package tp1;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import parser.JSONHandler;
import parser.XMLHandler;
import parser.objects.MainBody;

import org.w3c.dom.Document;

import javax.json.*;
import javax.json.stream.JsonParser;

/**
 * Fichier de base pour le Devoir1B du cours IFT287
 *
 * <pre>
 * 
 * Vincent Ducharme
 * Universite de Sherbrooke
 * Version 1.0 - 6 août 2016
 * IFT287 - Exploitation de BD relationnelles et OO
 * 
 * Ce programme permet de convertir un fichier JSON en son équivalent en XML.
 *
 * Paramètres du programme
 * 0- Nom du fichier JSON
 * 1- Nom du fichier XML
 * 
 * </pre>
 */
public class Devoir1B {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: java tp1.Devoir1B <fichierJSON> <fichierXML>");
			return;
		}

		String nomFichierJSON = args[0];
		String nomFichierXML = args[1];

		System.out.println("Debut de la conversion du fichier " + nomFichierJSON + " vers le fichier " + nomFichierXML);

		// Votre code de conversion devrait aller ici
		try {
			JSONHandler jh = new JSONHandler(nomFichierJSON);
			jh.parse();

			MainBody m = jh.getBody();

			// init DOM objects
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();

			doc.appendChild(m.toXML(doc));
			
			FileOutputStream output = new FileOutputStream(nomFichierXML);
			PrintStream out = new PrintStream(output);
			TransformerFactory allSpark = TransformerFactory.newInstance();
			Transformer optimusPrime = allSpark.newTransformer();

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(out);
			optimusPrime.transform(source, result);
		} catch (Exception e) {
			System.out.print("An error ocurred: ");
			e.printStackTrace();
		}

		System.out.println("Conversion terminee.");

	}

}
