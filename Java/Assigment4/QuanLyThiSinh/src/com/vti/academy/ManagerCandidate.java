package com.vti.academy;

import java.util.List;

public class ManagerCandidate {
		List<Candidate> cadidates;


		public ManagerCandidate(List<Candidate> cadidates) {
			super();
			this.cadidates = cadidates;
		}
		public void add(Candidate candidate) {
			this.cadidates.add(candidate);
		}
//		public void showInfo() {
//			this.cadidates.forEach(cadidate -> System.out.println(candidate.toString()));
//			
//			}
//		public void searchById(String id) {
//			return this.cadidates.stream()
//		}
	}
