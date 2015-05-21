package com.changshuo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changshuo.db.DBUtil;

/**
 * Servlet implementation class PatientServlet
 */
@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PatientServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		if (request.getParameter("AddButton") != null) {
			request.getRequestDispatcher("/addPatient.html").forward(request,
					response);
		}

		else if (request.getParameter("DeleteButton") != null) {
			String[] ids = request.getParameterValues("check");
			if (ids == null) {

			}
			else {
				
				for (int i = 0; i < ids.length; i++) {
					System.out.println(ids[i]);
					try {
						String id = ids[i];
						String sql = "delete from patientinfo where id=?";
						PreparedStatement prestmt = conn.prepareStatement(sql);
						prestmt.setInt(1, Integer.parseInt(id));
						prestmt.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {

						
					}

				}
			}
			util.closeConnection(conn);
			request.getRequestDispatcher("/patient.jsp").forward(request,
					response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
