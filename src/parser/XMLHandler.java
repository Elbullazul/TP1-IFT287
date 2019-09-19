package parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import parser.objects.*;

public class XMLHandler extends DefaultHandler {
	private String node = null;

	private MainBody body;
	private HumanSystem system;
	private Flow flow;
	private Connectible connectible;
	private Connection connection;
	private Organ organ;

	public void startDocument() throws SAXException {
		System.out.println("Début du parsing");
	}

	public void endDocument() throws SAXException {
		System.out.println(body.toJSON());
		System.out.println("Fin du parsing");
	}

	public void startElement(String namespaceURI, String lname, String qname, Attributes attrs) throws SAXException {
		// universal attributes (Connection will have empty name)
		// we re-declare everything so we don't have to reset after each new element
		int id = 0;
		String name = "";
		
		// occurential attributes
		String type = "";
		
		double volume = 0.0f;
		double length = 0.0f;
		
		double startRadius = 0.0f;
		double endRadius = 0.0f;
		
		int systemId = 0;
		
		// assign attribute values if found in current node
		if (attrs != null) {
			for (int i = 0; i < attrs.getLength(); i++) {
				String aName = attrs.getLocalName(i);
				String aValue = attrs.getValue(i);
				
				switch (aName) {
				case "id":
				case "bodyID":
					id = Integer.parseInt(aValue);
					break;
				case "name":
				case "bodyName":
					name = aValue;
					break;
				case "type":
					type = aValue;
					break;
				case "volume":
					volume = Float.parseFloat(aValue);
					break;
				case "length":
					length = Float.parseFloat(aValue);
					break;
				case "startRadius":
					startRadius = Float.parseFloat(aValue);
					break;
				case "endRadius":
					endRadius = Float.parseFloat(aValue);
					break;
				case "systemID":
					systemId = Integer.parseInt(aValue);
					break;
				}
			}
		}

		// current node name
		node = qname;
		
		// instantiate the corresponding elements when necessary
		switch (node) {
		case "MainBody":
			body = new MainBody(name, id);
			break;
			
		case "System":
			system = new HumanSystem(name, id, type);
			body.addSystem(system);
			break;
			
		case "Flow":
			flow = new Flow(name, id);
			system.addFlow(flow);
			break;
			
		case "Atrium":
		case "Ventricle":
		case "Capillaries":
		case "Alveoli":
			connectible = new VolumeConnectible(name, id, node, volume);
			flow.addConnectible(connectible);
			break;
			
		case "Artery":
		case "Vein":
		case "AirConnectible":
			connectible = new TubeConnectible(name, id, node, startRadius, endRadius, length);
			flow.addConnectible(connectible);
			break;
			
		case "DigestiveTract":
		case "StomachTract":
		case "DuodenumTract":
		case "RectumTract":
		case "SalivaryDuct":
			connectible = new TractConnectible(name, id, node, length, volume);
			flow.addConnectible(connectible);
			break;
			
		case "Nose":
		case "BiDuct":
		case "Duct":
		case "DuctOverflowableJunction":
		case "DeversingDuct":
		case "InnerGallbladder":
			connectible = new Connectible(name, id, node);
			flow.addConnectible(connectible);
			break;
			
		case "Connection":
			connection = new Connection(name, id);
			flow.addConnection(connection);
			break;
			
		case "to":
			connection.addTargetId(id);
			break;
			
		case "Organ":
			organ = new Organ(name, id, systemId);
			body.addOrgan(organ);
			break;
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
//		System.out.println("Fin de l'élément " + qName);
	}
}