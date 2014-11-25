package tools;

import model.dao.impl.RuleTypeDAOImpl;
import model.dao.impl.SessionDAOImpl;
import model.dao.impl.UserDAOImpl;
import model.dao.impl.UserRoleDAOImpl;
import model.dao.inerfaces.RuleTypeDAO;
import model.dao.inerfaces.SessionDAO;
import model.dao.inerfaces.UserDAO;
import model.dao.inerfaces.UserRoleDAO;

public class Factory {
	private static UserDAO userDAO = new UserDAOImpl();
	private static SessionDAO sessionDAO = new SessionDAOImpl();
	private static UserRoleDAO userRoleDAO = new UserRoleDAOImpl();
	private static RuleTypeDAO ruleTypeDAO = new RuleTypeDAOImpl();

	private static class InstanceHolder {
		private static final Factory instance = new Factory();

	}

	/**
	 * @return ������� �������
	 */
	public static Factory getInstance() {
		return InstanceHolder.instance;
	}

	public UserDAO getUserDAO() {

		return userDAO;
	}

	public SessionDAO getSessionDAO() {

		return sessionDAO;
	}

	public RuleTypeDAO getRuleTypeDAO() {

		return ruleTypeDAO;
	}

	public UserRoleDAO getUserRoleDAO() {

		return userRoleDAO;
	}
}
