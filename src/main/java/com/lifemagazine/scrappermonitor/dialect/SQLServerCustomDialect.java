package com.lifemagazine.scrappermonitor.dialect;

import java.sql.Types;

import org.hibernate.dialect.SQLServer2012Dialect;

public class SQLServerCustomDialect extends SQLServer2012Dialect {

		public SQLServerCustomDialect() {
			super();
			registerColumnType(Types.INTEGER, "decimal");
			registerColumnType(Types.NUMERIC, "decimal");
//			registerColumnType(Types.VARCHAR, "nvarchar($l)");
//	        registerColumnType(Types.CLOB, "nvarchar(max)");
		}
}
