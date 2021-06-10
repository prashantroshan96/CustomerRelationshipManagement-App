//package com.coforge.SpringBootJpaRestCrm.Controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.coforge.SpringBootJpaRestCrm.Bean.Bill;
//import com.coforge.SpringBootJpaRestCrm.Bean.Card;
//import com.coforge.SpringBootJpaRestCrm.Bean.CumulativePoint;
//import com.coforge.SpringBootJpaRestCrm.Bean.Customer;
//import com.coforge.SpringBootJpaRestCrm.Bean.Employee;
//import com.coforge.SpringBootJpaRestCrm.Bean.Payment;
//import com.coforge.SpringBootJpaRestCrm.Bean.Product;
//import com.coforge.SpringBootJpaRestCrm.Bean.Store;
//import com.coforge.SpringBootJpaRestCrm.Service.BillService;
//import com.coforge.SpringBootJpaRestCrm.Service.CardService;
//import com.coforge.SpringBootJpaRestCrm.Service.CumulativePointService;
//import com.coforge.SpringBootJpaRestCrm.Service.CustomerService;
//import com.coforge.SpringBootJpaRestCrm.Service.EmployeeService;
//import com.coforge.SpringBootJpaRestCrm.Service.PaymentService;
//import com.coforge.SpringBootJpaRestCrm.Service.ProductService;
//import com.coforge.SpringBootJpaRestCrm.Service.StoreService;
//
//
//
//@RestController
//@RequestMapping(value="/crm")
//public class CrmController {
//
//	
//	@Autowired
//	private CustomerService customerService;
//	
//	@Autowired
//	private ProductService productService;
//	
//	@Autowired
//	private BillService billService;
//	
//	@Autowired
//	private PaymentService paymentService;
//	
//	@Autowired
//	private CumulativePointService cumulativePointService;
//	
//	
//	@Autowired
//	private CardService cardService;
//	
//	@Autowired
//	private EmployeeService employeeService;
//	
//	@Autowired
//	private StoreService storeService;
//	
//	 static Bill bill;
//	 static Product product;
//	 static Customer customer;
//	 static Card card;
//	 static Store store;
//	 static Employee emp;
//	 static Payment payment;
//	 static CumulativePoint cp;
//	 
//	 
//	@RequestMapping(value="/addCustomer/{custID}/{custName}/{giftVoucher}/{custMob}/{custDOB}/{custCountary}/{custcity}/{custpincode}")
//	public Customer addCustomer(@PathVariable long custID,@PathVariable String custName,
//			@PathVariable long giftVoucher,@PathVariable String custMob,
//			@PathVariable String custDOB,@PathVariable String custCountary,@PathVariable String custcity,@PathVariable long custpincode)
//	{
//		customer= new Customer();
//		customer.setCustID(custID);
//		customer.setCustName(custName);
//		customer.setGiftVoucher(giftVoucher);
//		customer.setCustMob(custMob);
//		customer.setCustDOB(custDOB);
//		customer.setCustCountary(custCountary);
//		customer.setCustcity(custcity);
//		customer.setCustpincode(custpincode);
//		
//	//	customer.getBills().add(bill);
//		
//		customerService.addCustomer(customer);
//		return customer;
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	//@RequestMapping(value="/addCard/{cardNo}/{cardValidity}/{silverCardCumulativeTotal}/{goldCardCumulativeTotal}/{cumulativePointId}")
//	@PostMapping
////	public Card addCard(@PathVariable long cardNo,@PathVariable boolean cardValidity,@PathVariable double silverCardCumulativeTotal,
////			@PathVariable double goldCardCumulativeTotal,@PathVariable long cumulativePoint) {
//	public Card addCard(@RequestBody Card card) {
////		 card=new Card();
////		card.setCardNo(cardNo);
////		card.setCardValidity(cardValidity);
////		card.setSilverCardCumulativeTotal(silverCardCumulativeTotal);
////		card.setGoldCardCumulativeTotal(goldCardCumulativeTotal);
//		
////		
////	   Optional<CumulativePoint> cp	=cumulativePointService.findById(cumulativePoint);
////		card.setCumulativePoint(cp.get());
//		cardService.saveCard(card);
//		return card;
//		}
//	
//	@RequestMapping(value="/addBill/{BillId}")
//	public Bill addBill(@PathVariable long BillId) {
//		 bill=new Bill();
//		 bill.setBillId(BillId);
//		 bill.getProducts().add(product);
//		 bill.setCustomer(customer);
//		
//		return bill;
//	
//		}
//	
//	
//	@RequestMapping(value="/addProduct/{productID}/{producttype}/{productQuantity}/{productMRP}/{BillId}")
//	public Product addProduct(@PathVariable long productID,@PathVariable String producttype,
//			@PathVariable long productQuantity,@PathVariable double productMRP,
//			@PathVariable long BillId) {
//		 product=new Product();;
//		 product.setProductID(productID);
//		 product.setProducttype(producttype);
//		 product.setProductQuantity(productQuantity);
//		 product.setProductMRP(productMRP);
//		 product.setBill(billService.findById(BillId).get());
//		
//		 
//		 
//		return product;
//	
//		}
//	
//	
//	@RequestMapping(value="/addPayment/{paymentId}/{amount}/{modeOfPay}/{discount}/{BillId}")
//	public Payment addPayment(@PathVariable long paymentId,@PathVariable double amount,
//			@PathVariable String modeOfPay,@PathVariable double discount,@PathVariable long BillId) {
//		
//		payment=new Payment();
//		
//		payment.setPaymentId(paymentId);
//		payment.setAmount(amount);
//		payment.setModeOfPay(modeOfPay);
//		payment.setDiscount(discount);
//		
//		payment.setBill(billService.findById(BillId).get());	
//		
//		return payment ;
//	
//		}
//	
//	
//	
//	@RequestMapping(value="/addCumulativePoint/{cumulativePointsID}/{paymentId}")
//	public CumulativePoint addCumulativePoint(@PathVariable long cumulativePointsID,
//			@PathVariable long paymentId) {
//	
//		cp=new CumulativePoint();	
//		
//		cp.setCumulativePointsID(cumulativePointsID);
//		cp.setPayment(paymentService.findById(paymentId).get());
//		return cp;
//	
//		}
//	
//	
//	
//	
//	
//	
//	@RequestMapping(value="/add/{Storeid}/{Store_Name}/{Store_Country}/{Store_pinCode}")
//	public Store addStore(@PathVariable long Storeid,@PathVariable String Store_Name,@PathVariable String Store_Country,
//			@PathVariable long Store_pinCode)
//	{
//		 store=new Store();
//		store.setStoreid(Storeid);
//		store.setStore_Name(Store_Name);
//		store.setStore_Country(Store_Country);
//		store.setStore_pinCode(Store_pinCode);
//		storeService.saveStore(store);
//		return store;
//	}
//	
//	
//
//
//	
//	@RequestMapping(value ="/add/{Employee_Id}/{Employee_Name}/{Employee_Mob}/{Employee_Dob}/{Employee_Country}/{Employee_City}/{Employee_Pincode}")
//	public Employee addEmployee(@PathVariable long Employee_Id,@PathVariable String Employee_Name,
//			@PathVariable long Employee_Mob,@PathVariable int Employee_Dob,@PathVariable String Employee_Country,@PathVariable String Employee_City,
//			@PathVariable int Employee_Pincode)
//	{
//		 emp=new Employee();
//		
//		emp.setEmployee_Id(Employee_Id);
//		emp.setEmployee_Name(Employee_Name);
//		emp.setEmployee_Mob(Employee_Mob);
//		emp.setEmployee_Dob(Employee_Dob);
//		emp.setEmployee_Country(Employee_Country);
//		emp.setEmployee_City(Employee_City);
//		emp.setEmployee_Pincode(Employee_Pincode);
//		
//		employeeService.saveEmployee(emp);
//		
//		return emp;
//		
//		
//	}
//	
//
//	
//	@RequestMapping(value = "/employees")
//	public List<Employee> getEmployees()
//	{
//		return employeeService.findAll();
//		
//		
//	}
//	@RequestMapping(value = "/customers")
//	public List<Customer> getCustomers()
//	{
//		return customerService.getAll();
//		
//		
//	}
//	
//	@RequestMapping(value = "/products")
//	public List<Product> getProducts()
//	{
//		return productService.getAll();
//		
//		
//	}
//	
//	@RequestMapping(value = "/Payments")
//	public List<Payment> getPayment()
//	{
//		return paymentService.getAll();
//		
//		
//	}
//	
//	
//	@RequestMapping(value = "/Bills")
//	public List<Bill> getBill()
//	{
//		return billService.getAll();
//		
//		
//	}
//	@RequestMapping(value = "/cumulativePoints")
//	public List<CumulativePoint> getCumulativePoint()
//	{
//		return cumulativePointService.getAll();
//		
//		
//	}
//	
//	
//	@RequestMapping(value = "/employees/{Employee_Id}")
//	public Optional<Employee> getEmployee(@PathVariable int Employee_Id)
//	{
//		Optional<Employee> employee=employeeService.findOne(Employee_Id);
//		return employee;
//		
//		
//	}
//	
//	
//	
//	@RequestMapping(value="/stores")
//	public List<Store> getStores()
//	
//	{
//		return storeService.findAll();
//		
//	}
//	
//
//	@RequestMapping(value="/stores/{Storeid}")
//	public Optional<Store> getStore(@PathVariable int Storeid )
//	
//	{
//		Optional<Store> store=storeService.findOne(Storeid);
//		return store;
//		
//	}
//	
//	@RequestMapping(value="/search/Store_Name/{Store_Name}")
//	public List<Store> getStoreByName(@PathVariable  String Store_Name)
//	
//	{
//		List<Store> store=storeService.findByName(Store_Name);
//		return store;
//		
//	}
//	
//	
//	@RequestMapping(value="/cards")
//	public List<Card> getCards(){
//		return cardService.findAll();
//		
//	}
//
//
//	@RequestMapping(value="/cards/{id}")
//	public Optional<Card> getCard(@PathVariable int cardNo) {
//		Optional<Card> card=cardService.findOne(cardNo);
//		return card;
//	}
//	
//	
//	@RequestMapping(value="/delete/{cardNo}")
//	public void deleteCard(@PathVariable int cardNo) {
//		Card card=new Card();
//		card.setCardNo(cardNo);
//		cardService.delete(cardNo);
//	}
//
//	@RequestMapping(value="/deleteStore/{Storeid}")
//	public void  deleteStore(@PathVariable int Storeid)
//	
//	{
//		Store store=new Store();
//		store.setStoreid(Storeid);
//		
//		storeService.delete(Storeid);
//		
//	}
//	
//	
//	@RequestMapping(value = "/deleteEmployee/{Employee_Id}")
//	public void deleteEmployee(@PathVariable int Employee_Id)
//	{
//		Employee emp=new Employee();
//		
//		emp.setEmployee_Id(Employee_Id);
//		employeeService.delete(Employee_Id);
//	}
//	
//	
//}
