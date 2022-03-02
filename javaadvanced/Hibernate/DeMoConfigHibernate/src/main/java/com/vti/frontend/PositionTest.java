package com.vti.frontend;

import java.util.List;

import com.vti.entity.Position;
import com.vti.entity.enumrate.PositionName;
import com.vti.repository.PositionRepository;

public class PositionTest {
			public static void main(String[] args) {
				PositionRepository positionRepository = new PositionRepository();
				
				List<Position> positions = positionRepository.getPositions();
				
				for (Position position : positions) {
					System.out.println(position);
				}
				
				System.out.println("\n\n***********CREATE POSITION***********");

				Position positionCreate = new Position();
				positionCreate.setName(PositionName.PM);
				positionRepository.createPosition(positionCreate);

			}
			
			
}
