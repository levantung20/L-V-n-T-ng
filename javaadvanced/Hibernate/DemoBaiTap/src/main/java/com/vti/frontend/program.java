package com.vti.frontend;

import java.util.List;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;

public class program {
	public static void main(String[] args) {
		GroupRepository repository = new GroupRepository();

		System.out.println("\n\n**************GET ALL GROUP*****************");

		List<Group> groups = repository.getAllGroups();
		for (Group group : groups) {
			System.out.println(group);
		}

		System.out.println("\n\n******************* GET GROUP BY ID ***********");
		Group groupById = repository.getGroupById((short) 2);
		System.out.println(groupById);

		System.out.println("\n\n*******************GET GROUP BY Name***********************");
		Group groupByName = repository.getGroupByName("Lê Văn Tùng");
		System.out.println(groupByName);

		System.out.println("\n\n************CREATE GROUP*****************");

		Group groupCreate = new Group();
		groupCreate.setName("Lê Văn Tùng");
		groupCreate.setCreate_Date(java.sql.Date.valueOf("2022-09-04"));
		repository.createGroup(groupCreate);

		System.out.println("\n\n***************UPDATE GROUP 1 ********************");
		repository.updateGroup((short) 1, "PM");

		System.out.println("\n\n***************UPDATE GROUP 2 ********************");
		Group group = new Group();
		group.setId((short) 1);
		group.setName("Test");
		group.setCreate_Date(java.sql.Date.valueOf("2022-10-04"));
		repository.updateGroup(group);

		System.out.println("\n\n****************DELETE GROUP*********************");
		repository.deleteGroupID((short) 2);

		System.out.println("\n\n********CHECK GROUP EXISTS BY ID*******************");
		System.out.println(repository.isGroupExistsByID((short) 2));

		System.out.println("\n\n****************CHECK GROUP EXISTS BY Name***************");
		System.out.println(repository.isGroupExistsByName("Java Web"));

	}
}
