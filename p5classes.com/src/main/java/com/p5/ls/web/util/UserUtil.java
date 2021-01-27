package com.p5.ls.web.util;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.Authentication;

import com.p5.ls.web.model.Branch;
import com.p5.ls.web.model.CustomUser;
import com.p5.ls.web.model.Org;
import com.p5.ls.web.model.User;

public class UserUtil {

	public static User prepareDummyUser(List<Long> roleIds) {
		return new User(null, null, "P5Classes", "First", "Middle", "Last", "first.last@myorg.com", "male", new Date(),
				null, null, false, false, false, true, null, null, null, roleIds);
	}

	public static User getUser(Authentication auth) {
		if (auth == null)
			return null;
		CustomUser customUser = null;
		if (auth.getPrincipal() instanceof CustomUser) {
			customUser = (CustomUser) auth.getPrincipal();
		}
		return customUser.getUser();
	}
	
	public static CustomUser getCustomUser(Authentication auth) {
		if (auth == null)
			return null;
		CustomUser customUser = null;
		if (auth.getPrincipal() instanceof CustomUser) {
			return (CustomUser) auth.getPrincipal();
		} else
			return null;
	}
	
	
	public static Org getUserOrg(Authentication auth) {
		User user = getUser(auth);
		Org org = user == null ? null : user.getOrg();
		return org;
	}

	public static Long getUserOrgId(Authentication auth) {
		Org org = getUserOrg(auth);
		Long orgId = org == null ? null : org.getOrgId();
		return orgId;
	}

	public static Branch getUserBranch(Authentication auth) {
		User user = getUser(auth);
		Branch branch = user == null ? null : user.getBranch();
		return branch;
	}

	public static Long getUserBranchId(Authentication auth) {
		Branch branch = getUserBranch(auth);
		return branch == null ? null : branch.getBranchId();
	}


}
