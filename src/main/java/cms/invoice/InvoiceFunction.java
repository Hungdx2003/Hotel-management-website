package cms.invoice;

import java.util.ArrayList;

import objects.Invoice;

public interface InvoiceFunction {
	public Invoice getRoom(int id);
	public ArrayList<Invoice> getServiceUsage(int id);
	public Invoice getTotalInvoice(int id);
	
	public boolean payInvoice(int id);
	
	public Invoice getInvoice(int id);
	public ArrayList<Invoice> getAllInvoice(Invoice simillar);
}
