package com.vti.test;

import java.util.List;

import com.vti.entity.Position;
import com.vti.entity.enumerate.PositionName;
import com.vti.repository.PositionRepository;

public class PositionTest {
	public static void main(String[] args) {
		PositionRepository repository = new PositionRepository();

		System.out.println("***********GET ALL POSITIONS***********");

		List<Position> positions = repository.getAllPositions();

		for (Position position : positions) {
			System.out.println(position);
		}

		System.out.println("\n\n***********CREATE POSITION***********");

		Position positionCreate = new Position();
		positionCreate.setName(PositionName.PM);
		repository.createPosition(positionCreate);

	}
}
