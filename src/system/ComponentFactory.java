package system;

import datamodel.RawDataFactory;

public final class ComponentFactory {
	
	private static ComponentFactory instance = null;
	private Components.InventoryManager inventoryManager;
	private Components.OrderProcessor orderProcessor;
	private Components.OutputProcessor outputProcessor;
	private Components.DataFactory dataFactory;
	
	
	/**
	 * Private constructor.
	 */
	
	private ComponentFactory() {
		this.inventoryManager = new InventoryManager();
		this.orderProcessor = new OrderProcessor(inventoryManager);
		this.outputProcessor = new OutputProcessor(inventoryManager, orderProcessor);
		
		RawDataFactory.RawDataFactoryIntf objectRawFactory = RawDataFactory.getInstance(this);
		this.dataFactory = new DataFactory(objectRawFactory, inventoryManager, outputProcessor);
	}
	
	/**
	 * Public access method to Factory singleton instance that is created
	 * when getInstance() is first invoked. Subsequent invocations return
	 * the reference to the same instance.
	 * 
	 * @return Factory singleton instance
	 */
	
	public static ComponentFactory getInstance() {
		if (instance == null) {
			instance = new ComponentFactory();
		}
		return instance;
	}
	
	/**
	 * @return the inventoryManager
	 */
	public Components.InventoryManager getInventoryManager() {
		return inventoryManager;
	}
	
	/**
	 * @return the orderProcessor
	 */
	public Components.OrderProcessor getOrderProcessor() {
		return orderProcessor;
	}

	/**
	 * @return the outputProcessor
	 */
	public Components.OutputProcessor getOutputProcessor() {
		return outputProcessor;
	}
	
	/**
	 * @return the dataFactory
	 */
	public Components.DataFactory getDataFactory() {
		return dataFactory;
	}

}
