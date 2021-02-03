package br.com.zup.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.zup.gerenciador.models.Company;
import br.com.zup.gerenciador.models.DataBase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/newCompany")
public class NewCompanyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	DataBase DB = new DataBase();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hello World!");

		PrintWriter out = response.getWriter();
		Company company = new Company();

		String id = request.getParameter("id");
		String name = request.getParameter("name");

		company.setId(Long.parseLong(id));
		company.setName(name);

		DB.add(company);

		out.println("<html>" + "<body>");

		out.println("<h1>" + name + " cadastrado(a) com sucesso!" + "</h1>");

		out.println("</html>" + "</body>");
	}

}
