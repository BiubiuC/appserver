package com.arcst.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import com.arcst.bean.DataConnInfo;
import com.arcst.config.ConfigLoader;
import com.arcst.config.system.DataBasePoolInfo;
import com.arcst.tool.StrKit;

public class DataBasePoolManager {
	static Logger logger = Logger.getLogger(DataBasePoolManager.class);
	private static Object lock = new Object();
	private static DataBasePoolManager t = null;
	
	private DataBasePoolInfo dbpi = null;
	
	private DataBasePoolManager() {
		
	}
	public static DataBasePoolManager getManage() {
		// TODO Auto-generated method stub
		if(t == null) {
			synchronized (lock) {
				if(t == null) {
					t = new DataBasePoolManager();
				}
			}
		}
		return t;
	}
	
	public void initConnPool() {
		logger.info("初始化数据库连接池开始");
		dbpi = new DataBasePoolInfo();
		Document doc = ConfigLoader.getAppXmlDocument();
		Element database = doc.getRootElement().element("database");
		if(!"Y".equalsIgnoreCase(StrKit.attrStringValue(database.attribute("used")))) {
			dbpi.setUsed(false);
			return;
		}
		dbpi.setUsed(true);
		Element connections = database.element("connections");
		List<Element> connlist = connections.elements();
		for (int i = 0; i < connlist.size(); i++) {
			Element conn = connlist.get(i);
			DataConnInfo dci = new DataConnInfo();
			dci.maxnum = StrKit.attrIntValue(conn.attribute("max"));
			dci.type = conn.elementTextTrim("dbtype");
			dci.connstr = conn.elementTextTrim("connstr");
			dci.username = conn.elementTextTrim("username"); 
			dci.password = conn.elementTextTrim("password"); 
			dbpi.add(StrKit.attrStringValue(conn.attribute("max")), dci);
		}
		dbpi.shutdownSet();
		try {
			for(DataConnInfo dci:dbpi.getDataConnInfos()) {
				switch(dci.type) {
					case "oracle":
					case "ORACLE":
					case "Oracle":
						Class.forName("");
						break;
					case "Mysql":
					case "mysql":
					case "MYSQL":
						Class.forName("");
						break;
					case "DB2":
					case "Db2":
						Class.forName("");
						break;
					case "Infomix":
					case "infomix":
						Class.forName("");
						break;
				}
				//TODO:BiubiuC Doing
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("JDBC Class Not found");
			return;
		}
		
		logger.info("初始化数据库连接池完成");
	}
	
	private Connection createConn(DataConnInfo dci) {
		try {
			return DriverManager.getConnection(dci.connstr, dci.username, dci.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
