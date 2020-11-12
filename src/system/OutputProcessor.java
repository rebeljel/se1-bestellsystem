package system;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import datamodel.Customer;
import datamodel.Order;
import datamodel.OrderItem;

final class OutputProcessor implements Components.OutputProcessor{

	private final int printLineWidth = 100;
	
	private Components.InventoryManager inventoryManager;
	private Components.OrderProcessor orderProcessor;

	public OutputProcessor(Components.InventoryManager inventoryManager, Components.OrderProcessor orderProcessor) {
		this.inventoryManager = inventoryManager;
		this.orderProcessor = orderProcessor;
	}

	@Override
	public void printOrders(List<Order> orders, boolean printVAT) {
		StringBuffer sbAllOrders = new StringBuffer( "-------------" );
		StringBuffer sbLineItem = new StringBuffer();
		 
		long totalPrice = 0;
		
		for (Order o : orders) {
			String itemSpecs = "";
			String fmtPrice = "";
			long price = 0;

			for (OrderItem item : o.getItems()) {
				itemSpecs += item.getUnitsOrdered() + "x " + item.getDescription() + ", ";
				price += item.getArticle().getUnitPrice()*item.getUnitsOrdered();
				fmtPrice = fmtPrice(price, "EUR", 14);
			}
			totalPrice += price;
			itemSpecs = itemSpecs.substring(0, itemSpecs.lastIndexOf(", "));
			
			Customer customer = o.getCustomer();
			String customerName = splitName(customer, singleName(customer) );
			
			sbLineItem = fmtLine( "#" + o.getID() + ", " + customerName + "'s Bestellung: " + itemSpecs, fmtPrice, printLineWidth);
			sbAllOrders.append( "\n" );
			sbAllOrders.append( sbLineItem );
		}
		
		long vat = 0;
		
		if (printVAT == true) {
			vat = orderProcessor.vat(totalPrice, 1);
		}
		else {
			vat = 0;
		}

		String fmtPriceTotal = pad( fmtPrice( totalPrice, "", " EUR" ), 14, true );
		String fmtVATTotal = pad( fmtPrice( vat, "", " EUR" ), 14, true );

		sbAllOrders.append( "\n" )
		.append( fmtLine( "-------------", "-------------", printLineWidth ) )
		.append( "\n" )
		.append( fmtLine( "Gesamtwert aller Bestellungen:", fmtPriceTotal, printLineWidth ) )
		.append( "\n")
		.append( fmtLine( "Im Gesamtbetrag erhaltene Mehrwertsteuer (19%):", fmtVATTotal, printLineWidth ) );

		System.out.println( sbAllOrders.toString() );
		}
	

	@Override
	public void printInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String fmtPrice(long price, String currency) {
		String fmtPrice = pad( fmtPrice( price, "", " " + currency ), 14, true );
		return fmtPrice;
	}

	@Override
	public String fmtPrice(long price, String currency, int width) {
		String fmtPrice = pad( fmtPrice( price, "", " " + currency ), 14, true );
		return fmtPrice;
	}
	
	private String fmtPrice( long price, String prefix, String postfix ) {
		StringBuffer fmtPriceSB = new StringBuffer();
		if( prefix != null ) {
			fmtPriceSB.append( prefix );
		}

		fmtPriceSB = fmtPrice( fmtPriceSB, price );

		if( postfix != null ) {
			fmtPriceSB.append( postfix );
		}
		return fmtPriceSB.toString();
	}
	
	private StringBuffer fmtPrice( StringBuffer sb, long price ) {
		if( sb == null ) {
			sb = new StringBuffer();
		}
		double dblPrice = ( (double)price ) / 100.0;			// convert cent to Euro
		DecimalFormat df = new DecimalFormat( "#,##0.00",
			new DecimalFormatSymbols( new Locale( "de" ) ) );	// rounds double to 2 digits

		String fmtPrice = df.format( dblPrice );				// convert result to String in DecimalFormat
		sb.append( fmtPrice );
		return sb;
	}
	

	@Override
	public StringBuffer fmtLine(String leftStr, String rightStr, int totalWidth) {
		StringBuffer sb = new StringBuffer( leftStr );
		int shiftable = 0;		// leading spaces before first digit
		for( int i=1; rightStr.charAt( i ) == ' ' && i < rightStr.length(); i++ ) {
			shiftable++;
		}
		final int tab1 = totalWidth - rightStr.length() + 1;	// - ( seperator? 3 : 0 );
		int sbLen = sb.length();
		int excess = sbLen - tab1 + 1;
		int shift2 = excess - Math.max( 0, excess - shiftable );
		if( shift2 > 0 ) {
			rightStr = rightStr.substring( shift2, rightStr.length() );
			excess -= shift2;
		}
		if( excess > 0 ) {
			switch( excess ) {
			case 1:	sb.delete( sbLen - excess, sbLen ); break;
			case 2: sb.delete( sbLen - excess - 2 , sbLen ); sb.append( ".." ); break;
			default: sb.delete( sbLen - excess - 3, sbLen ); sb.append( "..." ); break;
			}
		}
		String strLineItem = String.format( "%-" + ( tab1 - 1 ) + "s%s", sb.toString(), rightStr );
		sb.setLength( 0 );
		sb.append( strLineItem );
		return sb;
	}
	
	private String pad( String str, int width, boolean rightAligned ) {
		String fmtter = ( rightAligned? "%" : "%-" ) + width + "s";
		String padded = String.format( fmtter, str );
		return padded;
	}

	@Override
	public String splitName(Customer customer, String name) {
		String name2 = customer.getLastName();
		
		String lastName = "";
		String firstName = "";
		
 		String[] splittedName = name2.split("\\s+");
 		
		if (splittedName.length > 1) {
			if (splittedName.length > 2) {
				lastName = splittedName[2];
				firstName = splittedName[0] + " " + splittedName[1];
			}
			
			else {
				lastName = splittedName[1];
				firstName = splittedName[0];
			}
			
		}
				
		else {
			firstName = name;
		}
		
		if (firstName.contains(",")) {
			String temp = "";
			temp = lastName; 
			String sName = name.substring(0, name.indexOf(',')+1).trim();
			firstName = firstName.replace(sName, "").trim() + " " + temp;
			lastName = "" + sName;
			lastName = lastName.replaceAll(",", "");
		}
		
		String[] fname = firstName.split(" ");
		if (fname.length == 1) {
			firstName = fname[0].trim();
		}
		if (fname.length > 1) {
			firstName = fname[0] + " " + fname[1].trim();
		}
		
		customer.setLastName(lastName);
		customer.setFirstName(firstName);
		return singleName(customer);

	}

	@Override
	public String singleName(Customer customer) {
		
		return customer.getLastName() + ", " + customer.getFirstName();
	}
	

}
