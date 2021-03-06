package com.nolbu.ws.soap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.feature.Features;

import com.nolbu.ws.trainings.CreateOrdersRequest;
import com.nolbu.ws.trainings.CreateOrdersResponse;
import com.nolbu.ws.trainings.CustomerOrdersPortType;
import com.nolbu.ws.trainings.DeleteOrdersRequest;
import com.nolbu.ws.trainings.DeleteOrdersResponse;
import com.nolbu.ws.trainings.GetOrdersRequest;
import com.nolbu.ws.trainings.GetOrdersResponse;
import com.nolbu.ws.trainings.Order;
import com.nolbu.ws.trainings.Product;


@Features(features="org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersWsimpl implements CustomerOrdersPortType {
	
	Map<BigInteger, List<Order>> customerOrders = new HashMap<>();
	int currentId = 0;
	
	public CustomerOrdersWsimpl() {
		init();
	}
	
	private void init() {
		List<Order> orders = new ArrayList<>();
		Order order = new Order();
		order.setId(BigInteger.valueOf(1));
		
		List<Product> products = new ArrayList<>();
		Product product = new Product();
		product.setId("1");
		product.setDescription("IPhone");
		product.setQuantity(BigInteger.valueOf(3));
		products.add(product);
		order.getProduct().addAll(products);
		
		orders.add(new Order());
		
		customerOrders.put(BigInteger.valueOf(++currentId), orders);
	}

	@Override
	public GetOrdersResponse getOrders(GetOrdersRequest request) {
		BigInteger customerId = request.getCustomerId();
		List<Order> orders = customerOrders.get(customerId);
		
		GetOrdersResponse response = new GetOrdersResponse();
		response.getOrder().addAll(orders);
		return response;
	}

	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
		BigInteger customerId = request.getCustomerId();
		Order order = request.getOrder();
		
		List<Order> orders = customerOrders.get(customerId);
		orders.add(order);
		
		CreateOrdersResponse response = new CreateOrdersResponse();
		response.setResult(true);
		return response;
	}

	@Override
	public DeleteOrdersResponse deleteOrders(DeleteOrdersRequest request) {
		BigInteger customerId = request.getCustomerId();
		customerOrders.remove(customerId);
		
		DeleteOrdersResponse response = new DeleteOrdersResponse();
		response.setResult(true);
		return response;
	}

}
