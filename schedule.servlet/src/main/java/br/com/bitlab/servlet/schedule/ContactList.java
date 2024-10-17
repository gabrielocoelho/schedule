package br.com.bitlab.servlet.schedule;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.bitlab.entity.Contact;
import br.com.bitlab.repository.impl.ContactRepositoryJDBC;
import br.com.bitlab.repository.interfaces.Repository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/schedule/list")
public class ContactList extends HttpServlet{

	private static final long serialVersionUID = 5902134880359736109L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/contactList.jsp");
			//requestDispatcher.forward(req, resp);
			
			Repository<Contact> repository = new ContactRepositoryJDBC();
			
			
			try {
				List<Contact> contacts = repository.list();
				req.setAttribute("contactList", contacts);			
			} catch (SQLException e) {
				req.setAttribute("errorMsg", e.getMessage());
			}
			Object errorMsg = req.getSession().getAttribute("errorMsg");
			if (errorMsg != null) {
				req.setAttribute("errorMsg", errorMsg.toString());
				req.getSession().removeAttribute("errorMsg");
			}
			RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/pages/schedule/contactList.jsp");
			dispatcher.forward(req, resp);
			
	}
}
