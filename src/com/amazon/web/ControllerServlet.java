package com.amazon.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amazon.domain.Item;
import com.amazon.domain.SummaryOfAllItems;
import com.amazon.service.Summary.SummaryService;
import com.amazon.service.item.ItemService;
import com.amazon.service.login.LoginService;

public class ControllerServlet extends HttpServlet {

	private static final String USERNAME_TEXTBOX = "username";
	private static final String LOGIN_BUTTON = "Login Here";
	private static final String BUTTON_CLICKED = "action";
	private static final String CURRENT_PAGE = "page";
	private static final String ADD_TO_CART_BUTTON="Add to Cart";
	private static final String CHECKOUT_BUTTON="Checkout";
	
	
	private static final long serialVersionUID = 4818685114397399943L;
	private LoginService loginService;
	private ItemService itemService;
	private SummaryService summaryService;
	private HttpSession session;
	
	private List<Item> cart;

	@Override
	public void init() throws ServletException {
		loginService = new LoginService();
		itemService = new ItemService();
		summaryService=new SummaryService();
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = "/login.jsp";
		String page = request.getParameter(CURRENT_PAGE);
		String action = request.getParameter("action");

		if (page != null) {
			if (page.equalsIgnoreCase("login")) {
				if (action.equalsIgnoreCase(LOGIN_BUTTON)) {
					String username = request.getParameter(USERNAME_TEXTBOX);
					String password = request.getParameter("password");
					boolean isValidUser = loginService.authenticate(username, password);
					if (isValidUser) {
						nextPage = "/cart.jsp";
						request.setAttribute("items", itemService.getItems());
						session=request.getSession(true);
						cart=new ArrayList<>();
					} else {
						nextPage = "/login.jsp";
						request.setAttribute("invalidUser", "Invalid username or password.");
					}
				}
			}else if(page.equalsIgnoreCase("cart")){
				if (action.equalsIgnoreCase(ADD_TO_CART_BUTTON)) {
					//Delete the existing cart if any.
					session.removeAttribute("cart");
					
					//Detect which checkboxes are clicked
					String[] selectedItemIDs=request.getParameterValues("chkItem");
					if(selectedItemIDs!=null && selectedItemIDs.length>0){
						for(String selectedItemID:selectedItemIDs){
							Integer quantity=Integer.parseInt(request.getParameter("qty"+selectedItemID));
							Integer id=Integer.parseInt(selectedItemID);
							String name="Hardcoded Chair";//select name,price,description from items where item_id=selectedItemID;
							Float unitPrice=99.0f;
							String description="Hardcoded Description";
							Item item=new Item(id,name,unitPrice,description,quantity);
							cart.add(item);
						}
						request.setAttribute("items", itemService.getItems());
						session.setAttribute("cart", cart);
						request.setAttribute("addToCartMessage", selectedItemIDs.length +" Items added to cart sucessfully");
					}
					nextPage="/cart.jsp";
					
				}else  	if (action.equalsIgnoreCase(CHECKOUT_BUTTON)) {
					List<Item> cartItems=(List<Item>)session.getAttribute("cart");
					SummaryOfAllItems summaryOfAllItems=summaryService.getSummary(cartItems);
					request.setAttribute("summaryOfAllItems", summaryOfAllItems);
					nextPage="/summary.jsp";
				}
			}
		}

		// Forward control to whatever is the current value of 'nextPage'.
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);

	}

}
