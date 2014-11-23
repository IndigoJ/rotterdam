package controllers;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.dao.UserDAO;
import model.dao.impl.UserDAOImpl;
import model.entity.User;

import org.json.JSONException;
import org.json.JSONObject;

import controllers.auth.CookieUtil;
import tools.MD5Decoder;

@Path("/")
@PermitAll
public class AuthApplication {

	private UserDAO userDAO = new UserDAOImpl();
	private CookieUtil cookieUtil = new CookieUtil();

	@POST
	@Path("/login")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response loginAuth(@Context HttpServletRequest hsr,
			@Context HttpServletResponse rspn, String data)
			throws JSONException {
		System.out.println(data);
		JSONObject loginData = new JSONObject(data);
		User user = userDAO.getUserByLoginAndPassword(loginData.getString("login"),
				loginData.getString("password"));
		if (user != null)// && cookieUtil.insertSessionUID(rspn, user))
			return Response.ok().build();
		else
			return Response.status(401).build();
	}

	@RolesAllowed({ "Driver" })
	@POST
	@Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	public Response logoutAuth(@Context HttpServletRequest hsr,
			@Context HttpServletResponse rspn) {
		if (true)// cookieUtil.removeSessionUID(hsr, rspn))
			return Response.ok().build();
		else
			return Response.status(404).build();
	}
}
