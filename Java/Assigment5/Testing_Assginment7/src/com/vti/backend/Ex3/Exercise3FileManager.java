package com.vti.backend.Ex3;

import java.io.File;
import java.nio.file.Files;
import java.security.PublicKey;

//import com.vti.entity.Ex3.ScannerUtils;

public class Exercise3FileManager {
		public static final String FILE_EXISTS = "File is exits!";
		public static final String FILE_NOT_EXITS = "Error ! File Not Exists";
		
		
		
		
		public static final String SOURCE_FILE_NOT_EXISTS = "Source File is not exits!";
		public static final String DESTINATION_FILE_EXISTS = "Destination File is exits!";
		public static boolean isFileExists(String pathFile) {
			// TODO Auto-generated method stub
			return false;
		}
		
//		public static void main(String[] args) {
//			//Question1
//			System.out.println("Mời bạn nhập vào đường dẫn 1 file");
//			String str = ScannerUtils.inputString();
//			
//			File file  = new File(str);
//			if (file.exists()) {
//				System.out.println("file có tồn tại ");
//			} else {
//				System.out.println("file không tồn tại ");
//				
//			}
//		}
		
		//Question 2 : 
//			public static void main(String[] args) {
//				try {
//					System.out.println("Mời bạn nhập vào 1 đường dẫn file");
//					String str =  ScannerUtils.inputString();
//					File file = new File(str);
//					if (file.exists()) {
//						throw new Exception("Error! File Exists!");
//					} else {
//						file.createNewFile();
//					}
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
//			}
		//Question4
//		public static void main(String[] args)  throws Exception{
//						System.out.println("Mời bạn nhập vào đường dẫn 1 file");
//						String str = ScannerUtils.inputString();
//						File file = new File(str);
//						if (file.exists()) {
//							file.delete();
//							System.out.println("Delete successfully!");
//							
//						} else {
//							throw new Exception("Error! file not exists");
//						}
//		}
//			
		
		// Question5 : Check path is File or Folder
//		public static void main(String[] args) {
//			System.out.println("Mời bạn nhập vào đường dẫn 1 file");
//			String str = ScannerUtils.inputString();
//			File file = new File(str);
//			System.out.println(file.isDirectory() ? " Path is  folder" : "Path is file");
//		}
		
		// Question6 : Get all File name of Folder
//		public static void main(String[] args) {
//			System.out.println("Mời bạn nhập vào đường dẫn");
//			String str = ScannerUtils.inputString();
//			File file = new File(str);
//			for (	String li : file.list()) {
//				System.out.println(li);
//			}
//		}
		//Question7:  Copy File cho tryen tham so k nhap nua 
//			public static void main(String[] args) {
//				
//			}
//			public static void copyFile(String sourceFile, String destinationPath) throws Exception {
//				if (!isFileExists(sourceFile)) {
//					throw new Exception(DESTINATION_FILE_EXISTS);
//				}
//				File source  = new File(sourceFile);
//				File dest = new File(destinationPath);
//				Files.copy(source.toPath(), dest.toPath());
//						
//			}
//			private static boolean isFileExists(String sourceFile) {
//				// TODO Auto-generated method stub
//				return false;
//			}
		
		// Question 8 : Moving File
//				public static void main(String[] args) {
//					
//				}
//		public static void movingFile(String sourceFile, String destinationPath)  throws Exception{
//			
//			if (!isFileExists(sourceFile)) {
//				 throw new Exception(SOURCE_FILE_NOT_EXISTS);
//			}
//			File source = new File(sourceFile);
//			File dest = new File(destinationPath);
//			File.move(source.toPath() , dest.toPath());
//		}
		
		//Question9 : Rename File
		
		
}
