package parser;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLObject {
	private Document doc;
	
	public XMLObject(Document doc) {
		this.doc = doc;
	}
	
	public Attr newAttribute(String name, String val) {
		Attr a = this.doc.createAttribute(name);
		a.setValue(val);
		
		return a;
	}
	
	public Attr newAttribute(String name, Integer val) {
		Attr a = this.doc.createAttribute(name);
		a.setValue(val.toString());
		
		return a;
	}
	
	public Attr newAttribute(String name, Double val) {
		Attr a = this.doc.createAttribute(name);
		a.setValue(val.toString());
		
		return a;
	}

	public Element newElement(String tagName) {
		return this.doc.createElement(tagName);
	}
}
