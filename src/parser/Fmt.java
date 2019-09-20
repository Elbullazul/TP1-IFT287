package parser;

public abstract class Fmt {
	public static String ind = "";
	public static String spacer = "  ";
	
	public static void addSpace() { Fmt.ind += Fmt.spacer; }
	public static void delSpace() { Fmt.ind = Fmt.ind.substring(0, Fmt.ind.length() - 2); }
}
