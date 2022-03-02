package com.vti.frontend;

import java.util.Date;
import java.util.List;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;

public class GroupTest {
			@SuppressWarnings("deprecation")
			public static void main(String[] args) {
				GroupRepository groupRepository = new GroupRepository();
				
//				List<Group> groups = groupRepository.getALLGroups();
//				for (Group group : groups) {
//					System.out.println(group);
//				}
//				
				Group group = new Group();
				group.setId((short)12);
				group.setGroupName("DEV2");
				group.setCreateDate(null);
				groupRepository.createGroup(group);
			}
			
}
