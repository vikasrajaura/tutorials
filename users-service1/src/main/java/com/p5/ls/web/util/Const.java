package com.p5.ls.web.util;

public class Const {

	public static final String DB_DRIVER = "db.driverClassName";
	public static final String DB_PASSWORD = "db.password";
	public static final String DB_URL = "db.url";
	public static final String DB_USERNAME = "db.username";

	public static final String HB_DIALECT = "hibernate.dialect";
	public static final String HB_SHOW_SQL = "hibernate.show_sql";
	public static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	public static final String HB_FORMAT_SQL = "hibernate.format_sql";
	public static final String HB_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";

	public static final String HB_MIN_SIZE = "hibernate.c3p0.min_size";
	public static final String HB_MAX_SIZE = "hibernate.c3p0.max_size";
	public static final String HB_ACQUIRE_INCREMENT = "hibernate.c3p0.acquire_increment";
	public static final String HB_TIMEOUT = "hibernate.c3p0.timeout";
	public static final String HB_MAX_STATEMENTS = "hibernate.c3p0.max_statements";

	public static final String UNDERSCORE = "_";
	public static final String HYPHEN = "_";
	public static final String DOT = ".";
	public static final String SLASH = "/";

	public static final String MODE_ADD = "add";
	public static final String MODE_EDIT = "edit";
	public static final String MODE_VIEW = "view";
	public static final String MODE_DELETE = "delete";

	public static final String ADD = "add";
	public static final String SAVE = "save";
	public static final String EDIT = "edit";
	public static final String UPDATE = "update";
	public static final String VIEW = "view";
	public static final String DELETE = "delete";

	public static final String MSG_ERROR = "ERROR_MSG";
	public static final String MSG_SUCCESS = "SUCCESS_MSG";

	public static final String SLASH_ADD = SLASH + ADD;
	public static final String SLASH_SAVE = SLASH + SAVE;
	public static final String SLASH_EDIT = SLASH + EDIT;
	public static final String SLASH_UPDATE = SLASH + UPDATE;
	public static final String SLASH_VIEW = SLASH + VIEW;
	public static final String SLASH_DELETE = SLASH + DELETE;

	public static final String ROLE_SUPER_USER = "ROLE_SUPER_USER";
	public static final String ROLE_DBA_USER = "ROLE_DBA_USER";
	public static final String ROLE_ORG_USER = "ROLE_ORG_USER";
	public static final String ROLE_BRANCH_USER = "ROLE_BRANCH_USER";
	public static final String ROLE_ADMIN_USER = "ROLE_ADMIN_USER";
	public static final String ROLE_PRINCIPLE_USER = "ROLE_PRINCIPLE_USER";
	public static final String ROLE_TEACHER_USER = "ROLE_TEACHER_USER";
	public static final String ROLE_PARENT_USER = "ROLE_PARENT_USER";
	public static final String ROLE_STUDENT_USER = "ROLE_STUDENT_USER";

	public static final Long ROLE_SUPER_USER_ID = 1L;
	public static final Long ROLE_DBA_USER_ID = 2L;
	public static final Long ROLE_ORG_USER_ID = 3L;
	public static final Long ROLE_BRANCH_USER_ID = 4L;
	public static final Long ROLE_ADMIN_USER_ID = 5L;
	public static final Long ROLE_PRINCIPLE_USER_ID = 6L;
	public static final Long ROLE_TEACHER_USER_ID = 7L;
	public static final Long ROLE_PARENT_USER_ID = 8L;
	public static final Long ROLE_STUDENT_USER_ID = 9L;

}
