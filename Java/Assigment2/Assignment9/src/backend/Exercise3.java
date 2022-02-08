package backend;

import entyti.CPU;

public class Exercise3 {
		public static void Question1() {
			CPU.Processor processor = new CPU.Processor(30f, "VietNam");
			System.out.println(processor.getCache());
			CPU.Ram ram = new CPU.Ram("5G"	, "VietNamse");
			System.out.println(ram.getClockSpeed());
}
}
