package com.axis.bankapplication;

import java.util.List;

public class HeadOffice {

	private List<Branch> branches;

	public void createBranch() {
		Branch branch = new Branch();
		String newbranchId = null;
		// The branchId is equal to one greater than the branchId of the last branch
		// that is created by this head office
		if(branches.size()<=0) {
			newbranchId = "1";
		}else {
			String branchId = branches.get(branches.size() - 1).getBranchId();
			int intbranchId = (Integer.parseInt(branchId));
			newbranchId = Integer.toString(intbranchId + 1);
		}
		branch.setBranchId(newbranchId);
		
	}

	public Branch getBranchById(String branchId) throws Exception {
		Branch requestedBranch = null;
		for (Branch branch : branches) {
			if (branch.getBranchId().equals(branchId))
				requestedBranch = branch;
			else
				throw new Exception("branch with the given branchId not found");
		}
		return requestedBranch;
	}

	public List<Branch> getAllBranches() {
		return branches;
	}
}
