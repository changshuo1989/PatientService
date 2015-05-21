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

import com.changshuo.bean.Patient;
import com.changshuo.db.DBUtil;

/**
 * Servlet implementation class AddPateintServlet
 */
@WebServlet("/AddPateintServlet")
public class AddPateintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddPateintServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		Patient pat = new Patient();
		String name = request.getParameter("patientname");
		pat.setName(name);
		String sql = "insert into patientinfo values(?);";
		
		try {
			PreparedStatement prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, pat.getName());
			prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			util.closeConnection(conn);
			request.getRequestDispatcher("/patient.jsp").forward(request, response);
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
