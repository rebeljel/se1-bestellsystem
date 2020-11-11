package application;

import java.util.*;
import datamodel.*;
import system.*;

public class Application_2 {

	public static void main(String[] args) {
			
		System.out.println("SE2-Bestellsystem");

		ComponentFactory componentFactory = ComponentFactory.getInstance();
		Components.OutputProcessor outputProcessor = componentFactory.getOutputProcessor();
		Components.DataFactory dataFactory = componentFactory.getDataFactory();

		Customer cEric = dataFactory.createCustomer("Eric Schulz-Mueller", "eric2346@gmail.com" );
		Customer cAnne = dataFactory.createCustomer("Meyer, Anne", "+4917223524" );
		Customer cNadine = dataFactory.createCustomer("Nadine Ulla Blumenfeld", "+4915292454" );
		Customer cTimo = dataFactory.createCustomer("Timo Werner", "tw@gmail.com" );
		Customer cSandra = dataFactory.createCustomer("Sandra Mueller", "samue62@gmx.de" );
		
		Article aTasse = dataFactory.createArticle("Tasse", 299, 2000 );
		Article aBecher = dataFactory.createArticle("Becher", 149, 8400 );
		Article aKanne = dataFactory.createArticle("Kanne", 2000, 2400 );
		Article aTeller = dataFactory.createArticle("Teller", 649, 7000 );
		Article aKaffeemaschine = dataFactory.createArticle("Kaffeemaschine", 2999, 500 );
		Article aTeekocher = dataFactory.createArticle("Teekocher", 1999, 2000 );

		// Eric's 1st order
		Order o5234 = dataFactory.createOrder(cEric );
		OrderItem oi1 = dataFactory.createOrderItem( aKanne.getDescription(), aKanne, 1 );	// 1x Kanne
		o5234.addItem( oi1 );	// add OrderItem to Order 5234968294L

		// Eric's 2nd order
		Order o8592 = dataFactory.createOrder( cEric );
		o8592.addItem(	// add three OrderItems to Order 8592356245L
				dataFactory.createOrderItem( aTeller.getDescription(), aTeller, 4 )		// 4x Teller
		).addItem(
				dataFactory.createOrderItem( aBecher.getDescription(), aBecher, 8 )		// 8x Becher
		).addItem(
				dataFactory.createOrderItem( "passende Tassen", aTasse, 4 )				// 4x passende Tassen
		);

		// Anne's order
		Order o3563 = dataFactory.createOrder( cAnne );
		o3563.addItem(
				dataFactory.createOrderItem( aKanne.getDescription() + " aus Porzellan", aKanne, 1 )
		);

		// Nadine's order
		Order o6135 = dataFactory.createOrder( cNadine );
		o6135.addItem(													// 12x Teller
				dataFactory.createOrderItem( aTeller.getDescription() + " blau/weiss Keramik", aTeller, 12 )
		);
		
		//Timo's order
		Order o4352 = dataFactory.createOrder( cTimo );
		o4352.addItem(	
				dataFactory.createOrderItem( aKaffeemaschine.getDescription(), aKaffeemaschine, 1 )		// 1x Kaffeemaschine
			).addItem(
				dataFactory.createOrderItem( aTasse.getDescription(), aTasse, 6 )		// 6x Tassen
		);

		//Sandra's order
		Order o9283 = dataFactory.createOrder( cSandra );
		o9283.addItem(
				dataFactory.createOrderItem( aTeekocher.getDescription(), aTeekocher, 1 )		// 1x Teekocher
			).addItem(
				dataFactory.createOrderItem( aBecher.getDescription(), aBecher, 4 )		// 4x Becher
			).addItem(
				dataFactory.createOrderItem( aTeller.getDescription(), aTeller, 4 )				// 4x Teller
		);
		
		List<Order> orders = new ArrayList<Order>( List.of( o5234, o8592, o3563, o6135 ) );

		orders.addAll(new ArrayList<Order>(List.of( o4352, o9283 )));
	
		
			
		outputProcessor.printOrders( orders, false );
		

	}

}
