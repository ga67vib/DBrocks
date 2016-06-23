package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import de.tum.in.dbpra.model.bean.InvoiceItemBean;
import de.tum.in.dbpra.model.bean.InvoiceItemListBean;
import de.tum.in.dbpra.model.bean.CustomerBean;
import de.tum.in.dbpra.model.bean.OrderBean;
import de.tum.in.dbpra.model.dao.CustomerDAO.CustomerNotFoundException;

public class InvoiceDAO extends DAO{
	public void getInvoiceInformation(OrderBean order,int orderkey, CustomerBean customer,InvoiceItemListBean ilb) throws OrderNotFoundException, SQLException, ClassNotFoundException {
		
		String GetOrder = "SELECT * FROM orders WHERE orderkey = "+orderkey+";";
		String getCustomer = "SELECT customer.custkey,customer.name, customer.address,customer.acctbal FROM (SELECT * FROM orders WHERE orderkey = "+orderkey + ") myorder, customer where myorder.custkey = customer.custkey;";
		String getInvoiceitems = "SELECT distinct lineitem.linenumber, part.name, lineitem.quantity, lineitem.extendedprice FROM orders, part,lineitem WHERE lineitem.orderkey = "+orderkey+" and lineitem.partkey = part.partkey order by lineitem.linenumber asc;";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmtOrder = con.prepareStatement(GetOrder);
		PreparedStatement pstmtCustomer = con.prepareStatement(getCustomer);
		PreparedStatement pstmtInvoiceitems = con.prepareStatement(getInvoiceitems);
		
		
		ResultSet rsOrder = pstmtOrder.executeQuery();
		ResultSet rsCustomer = pstmtCustomer.executeQuery();
		ResultSet rsInvoiceitems = pstmtInvoiceitems.executeQuery();
		
		rsOrder.next();
		order.setOrderkey(orderkey);
		order.setCustkey(rsOrder.getInt("custkey"));
		order.setOrderstatus(rsOrder.getString("orderstatus"));
		order.setTotalprice(rsOrder.getDouble("totalprice"));
		order.setOrderdate(rsOrder.getString("orderdate"));
		
		rsCustomer.next();
		customer.setCustkey(rsCustomer.getInt("custkey"));
		customer.setName(rsCustomer.getString("name"));
		customer.setAddress(rsCustomer.getString("address"));
		customer.setAcctbal(rsCustomer.getDouble("acctbal"));
		
		
		int i = 0;
		while(rsInvoiceitems.next()){
			InvoiceItemBean o = new InvoiceItemBean();
			o.setLinenumber(rsInvoiceitems.getInt("linenumber"));
			o.setPartName(rsInvoiceitems.getString("name"));
			o.setQuantity(rsInvoiceitems.getInt("quantity"));
			o.setPrice(rsInvoiceitems.getDouble("extendedprice"));
			ilb.setChild(o, i);
			i++;
		} 
		con.commit();
		
		rsOrder.close();
		rsCustomer.close();
		rsInvoiceitems.close();
		
		pstmtOrder.close();
		pstmtCustomer.close();
		pstmtInvoiceitems.close();
		
		con.close();
	}
	
	public static class OrderNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		OrderNotFoundException(String message){
			super(message);
		}
	}
}